const {
  BinaryOperatorNode,
  Node,
  TagNode,
  MetricNode,
  ExactKeywordNode,
} = require("../parser");

class Interpreter {
  constructor(ast) {
    this.ast = ast;
  }

  visitAst() {
    const result = this.interpretNode(this.ast);
    const queryObject = { query: { bool: { must: [result] } } };

    let queryJson = JSON.stringify(queryObject);

    // console.log(queryJson);

    return queryJson;
  }

  interpretNode(node) {
    node = node?.result ? node.result : node;

    if (node instanceof BinaryOperatorNode) {
      return this.interpretBinaryOperatorNode(node);
    } else if (node instanceof Node) {
      return this.interpretTokenNode(node);
    } else if (node instanceof TagNode) {
      return this.interpretTagNode(node);
    } else if (node instanceof ExactKeywordNode) {
      return this.interpretExactKeywordNode(node);
    } else if (node instanceof MetricNode) {
      return this.interpretMetricNode(node);
    } else {
      throw new Error(`Cannot interpret node of type ${node.constructor.name}`);
    }
  }

  interpretTokenNode(node) {
    return {
      query_string: {
        query: node.token.value,
      },
    };
  }

  interpretTagNode(node) {
    let { tag, value } = node;
    let tagValue = value?.token?.value;
    let exactKeyword = value?.keyword;

    const tokenVal = {
      match: {
        [tag.value]: tagValue,
      },
    };

    const exactKeywordVal = {
      multi_match: {
        query: `${exactKeyword}`,
        fields: [`${tag.value}`],
        type: "phrase",
      },
    };

    return exactKeyword ? exactKeywordVal : tokenVal;
  }

  interpretMetricNode(node) {
    let { metric, comparOp, value } = node;
    let status = false;

    switch (comparOp) {
      case "==":
      case "=":
      case ":":
        status = true;
        break;
      case ">":
        comparOp = "gt";
        break;
      case "<":
        comparOp = "lt";
        break;
      case ">=":
        comparOp = "gte";
        break;
      case "<=":
        comparOp = "lte";
        break;
      default:
        throw new Error(`Invalid comparison operator: ${comparOp}`);
    }

    return {
      bool: {
        must: [
          {
            match: {
              "metrics.code": metric.toUpperCase(),
            },
          },
          {
            range: {
              "metrics.value": status
                ? {
                    gte: value,
                    lte: value,
                  }
                : {
                    [comparOp]: value,
                  },
            },
          },
        ],
      },
    };
  }

  interpretExactKeywordNode(node) {
    return {
      bool: {
        should: [
          {
            match_phrase: {
              content: node.keyword,
            },
          },
          {
            match_phrase: {
              description: node.keyword,
            },
          },
          {
            match_phrase: {
              name: node.keyword,
            },
          },
        ],
        minimum_should_match: 1,
      },
    };
  }

  interpretBinaryOperatorNode(node) {
    const logicOperator = node.logicalOp.value;
    const interpretNode = this.interpretNode.bind(this);

    if (logicOperator == "AND") {
      return {
        bool: {
          must: [interpretNode(node.left), interpretNode(node.right)],
        },
      };
    } else if (logicOperator == "OR" || logicOperator == " ") {
      return {
        bool: {
          should: [interpretNode(node.left), interpretNode(node.right)],
          minimum_should_match: 1,
        },
      };
    } else if (logicOperator == "NOT") {
      return {
        bool: {
          must_not: [interpretNode(node.right)],
          filter: [interpretNode(node.left)],
        },
      };
    } else {
      throw new Error(`Invalid logical operator: ${node.logicalOp.value}`);
    }
  }
}

module.exports = Interpreter;
