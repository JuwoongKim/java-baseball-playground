package calculator;

import static calculator.exception.ErrorCode.*;

import java.util.regex.Pattern;

import calculator.exception.ExpressionValidationException;

public class Expression {

	private String expression;

	public Expression(String expression) {
		validateExpression(expression);
		this.expression = expression;
	}

	public static void validateExpression(String expression) {
		String pattern = "^[1-9][0-9]*(\\s[-+*/]\\s[1-9][0-9]*)+$";
		boolean isMatches = Pattern.matches(pattern, expression);

		if (!isMatches) {
			throw new ExpressionValidationException(INVALID_EXPRESSION.getMessage());
		}
	}

	public String[] getExpressionElements() {
		return expression.split(" ");
	}
}
