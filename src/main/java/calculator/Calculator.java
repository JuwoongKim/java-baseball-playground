package calculator;

import static calculator.exception.ErrorCode.*;

import java.util.Arrays;
import java.util.function.BiFunction;

import calculator.exception.ExpressionValidationException;

public class Calculator {

	public enum Operator {
		ADD("+", (a, b) -> a + b),
		SUBTRACT("-", (a, b) -> a - b),
		MULTIPLY("*", (a, b) -> a * b),
		DIVIDE("/", (a, b) -> a / b);

		private String symbol;
		private BiFunction<Long, Long, Long> operate;

		Operator(String symbol, BiFunction<Long, Long, Long> operate) {
			this.symbol = symbol;
			this.operate = operate;
		}

		public static Long calculate(String operator, Long rightOperand, Long leftOperand) {
			return Arrays.stream(Operator.values())
				.filter(v -> v.symbol.equals(operator))
				.findFirst()
				.orElseThrow(() -> new ExpressionValidationException(INVALID_EXPRESSION.getMessage()))
				.operate.apply(rightOperand, leftOperand);
		}
	}

	public static String calculate(Expression expression) {
		String[] expressionElements = expression.getExpressionElements();

		String rightOperand = expressionElements[0];

		for (int i = 1; i < expressionElements.length; i++) {
			String operator = expressionElements[i++];
			String leftOperand = expressionElements[i];
			rightOperand = operate(operator, rightOperand, leftOperand);
		}

		return rightOperand;
	}

	private static String operate(String operator, String rightOperand, String leftOperand) {
		Long rightOperandNumber = Long.parseLong(rightOperand);
		Long leftOperandNumber = Long.parseLong(leftOperand);

		Long calculate = Operator.calculate(operator, rightOperandNumber, leftOperandNumber);

		return String.valueOf(calculate);
	}

}
