const { log } = console;
class Interpreter {
  constructor(ast) {
    this.global_query = "";
    this.ast = ast;
  }

  visit(node) {
    const result = node?.result ? node.result : node;
    let objectType = result?.constructor.name;
    // log(`===>: ${this.global_query}`)

    switch (objectType) {
      case "BinaryOperatorNode":
        return this.visitBinaryOperatorNode(node);
      case "TagNode":
        return this.visitTagNode(node);
      case "MetricNode":
        return this.visitMetricNode(node);
      case "ExactKeywordNode":
        return this.visitExactKeywordNode(node);
      case "Node":
        return this.visitNode(node);
      default:
        return null;
    }
  }

  visitBinaryOperatorNode(ast) {
    // const { result, error, paranthLeft, paranthRight } = ast;

    const left = ast?.result?.left ? ast.result.left : ast?.left;
    const operator = ast?.result?.operator
      ? ast.result.operator
      : ast?.operator;
    const right = ast?.result?.right ? ast.result.right : ast?.right;

    const arrowLL = ast?.paranthLeft ? ast.paranthLeft : "";
    const arrowLR = ast?.paranthRight ? ast.paranthRight : "";

    let op = "";

    switch (operator?.type) {
      case "TT_AND":
        op = ` ${operator.value} `;
        break;
      case "TT_OR":
        op = ` ${operator.value} `;
        break;
      case "TT_NOT":
        op = ` ${operator.value} `;
        break;
      case "TT_SPACE":
        op = `${operator.value}`;
        break;
    }

    this.global_query += arrowLL;
    this.global_query += left?.paranthLeft ? left.paranthLeft : "";
    this.visit(left?.result ? left.result : left);
    this.global_query += left?.paranthRight ? left.paranthRight : "";

    this.global_query += op;

    this.global_query += right?.paranthLeft ? right.paranthLeft : "";
    this.visit(right?.result ? right.result : right);
    this.global_query += right?.paranthRight ? right?.paranthRight : "";
    this.global_query += arrowLR;
  }

  visitNode(node) {
    let node_ = node?.result ? node.result : node;

    this.global_query += node?.paranthLeft ? node.paranthLeft : "";
    this.global_query += `${node_.token.value}`;
    this.global_query += node?.paranthRight ? node.paranthRight : "";
  }

  // visitTagNode(node) {
  //     let node_ = node?.result ? node.result : node;
  //     let { tag, colon, value } = node_;

  //     this.global_query += node?.paranthLeft ? node.paranthLeft : "";
  //     this.global_query += `${tag.value}${colon.value}${value.token.value}`;
  //     this.global_query += node?.paranthRight ? node.paranthRight : "";

  //     // let { tag, colon, value } = node;
  //     // // log(`visitTagNode: ${tag.value}, ${colon.value}, ${value.token.value}`)
  //     // this.global_query += `${tag.value}${colon.value}${value.token.value}`;
  // }

  visitTagNode(node) {
    let node_ = node?.result ? node.result : node;
    let { tag, colon, value } = node_;

    this.global_query += node?.paranthLeft ? node.paranthLeft : "";

    // check if value is an ExactKeywordNode
    if (value.constructor.name === "ExactKeywordNode") {
      // include the quotes directly
      this.global_query += `${tag.value}${colon.value}'${value.str}'`;
    } else {
      // original logic for handling the value
      this.global_query += `${tag.value}${colon.value}${value.token.value}`;
    }

    this.global_query += node?.paranthRight ? node.paranthRight : "";
  }

  visitMetricNode(node) {
    let node_ = node?.result ? node.result : node;
    let { metric, operator, value } = node_;

    this.global_query += node?.paranthLeft ? node.paranthLeft : "";
    this.global_query += `modelMetric.metrics.${metric.toUpperCase()}.value:${
      operator === "==" ? "" : `${operator}`
    }${Number(value)}`;
    this.global_query += node?.paranthRight ? node.paranthRight : "";

    // let { metric, operator, value } = node;
    // // log(node)
    // // log(`visitMetricNode: ${metric}, ${operator}, ${value}`)
    // this.global_query += `modelMetric.metrics.${metric.toUpperCase()}.value:${operator === '==' ? '' : `${operator}`}${Number(value)}`;
  }

  visitExactKeywordNode(node) {
    let node_ = node?.result ? node.result : node;

    this.global_query += node?.paranthLeft ? node.paranthLeft : "";
    this.global_query += `"${node_.startingQuote.value}${node_.str}${node_.endingQuote.value}"`;
    this.global_query += node?.paranthRight ? node.paranthRight : "";

    // this.global_query += `"${node.startingQuote.value}${node.str}${node.endingQuote.value}"`;
  }
}

module.exports = { Interpreter };
