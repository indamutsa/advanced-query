const Token = require("../lexer/token");
const { getTokenType, tokenTypes } = require("../lexer/validTokens");
const { TT_NUMBER, TT_SPACE, TT_QUOTE, TT_FUZZ, TT_PLUS, TT_MINUS, TT_EOF } =
  tokenTypes;

const {
  VALID_ASSIGNMENT_OPERATORS,
  VALID_COMPARISON_OPERATORS,
  VALID_LOGICAL_OPERATORS,
  VALID_METRICS,
  VALID_TAGS,
} = require("../lexer/validTokens");

describe("Token class", () => {
  test("should correctly metrics token types", () => {
    // Prepare examples for each valid metric
    const metricExamples = Array.from(VALID_METRICS).map((metric) => {
      const tokenType = getTokenType(metric);
      return {
        value: metric,
        expectedType: tokenType,
      };
    });

    for (const example of metricExamples) {
      const token = new Token(example.value);

      expect(token.type).toEqual(example.expectedType);
      expect(token.value).toEqual(example.value);
    }
  });

  test("should correctly tags token types", () => {
    // Prepare examples for each valid tag
    const tagExamples = Array.from(VALID_TAGS).map((tag) => {
      const tokenType = getTokenType(tag);
      return {
        value: tag,
        expectedType: tokenType,
      };
    });
  });

  test("should correctly logical token types", () => {
    // Prepare examples for each valid logical operator
    const logicalOperatorExamples = Array.from(VALID_LOGICAL_OPERATORS).map(
      (operator) => {
        const tokenType = getTokenType(operator);
        return {
          value: operator,
          expectedType: tokenType,
        };
      }
    );
    for (const example of logicalOperatorExamples) {
      const token = new Token(example.value);

      expect(token.type).toEqual(example.expectedType);
      expect(token.value).toEqual(example.value);
    }
  });

  test("should correctly comparison token types", () => {
    // Prepare examples for each valid comparison operator
    const comparisonOperatorExamples = Array.from(
      VALID_COMPARISON_OPERATORS
    ).map((operator) => {
      const tokenType = getTokenType(operator);
      return {
        value: operator,
        expectedType: tokenType,
      };
    });

    for (const example of comparisonOperatorExamples) {
      const token = new Token(example.value);

      expect(token.type).toEqual(example.expectedType);
      expect(token.value).toEqual(example.value);
    }
  });

  test("should correctly valid token types", () => {
    // Prepare examples for each valid assignment operator
    const assignmentOperatorExamples = Array.from(
      VALID_ASSIGNMENT_OPERATORS
    ).map((operator) => {
      const tokenType = getTokenType(operator);
      return {
        value: operator,
        expectedType: tokenType,
      };
    });

    for (const example of assignmentOperatorExamples) {
      const token = new Token(example.value);

      expect(token.type).toEqual(example.expectedType);
      expect(token.value).toEqual(example.value);
    }
  });

  test("should correctly extra token types", () => {
    // Define examples for other token types
    const otherExamples = [
      { value: "12.34", expectedType: TT_NUMBER },
      { value: " ", expectedType: TT_SPACE },
      { value: '"', expectedType: TT_QUOTE },
      { value: "~", expectedType: TT_FUZZ },
      { value: "+", expectedType: TT_PLUS },
      { value: "-", expectedType: TT_MINUS },
      { value: null, expectedType: TT_EOF },
      { value: undefined, expectedType: TT_EOF },
    ];

    for (const example of otherExamples) {
      const token = new Token(example.value);
      //   console.log(token);
      expect(token.type).toEqual(example.expectedType);
      expect(token.value).toEqual(example.value);
    }
  });
});
