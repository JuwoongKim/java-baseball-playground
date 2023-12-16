package calculator;

import static calculator.exception.ErrorCode.*;

import java.util.Arrays;

import calculator.exception.ExpressionValidationException;

public enum Operator {
	ADD("+") {
		@Override
		Long operate(Long a, Long b) {
			return a + b;
		}
	},
	SUBTRACT("-") {
		@Override
		Long operate(Long a, Long b) {
			return a - b;
		}
	},
	MULTIPLY("*") {
		@Override
		Long operate(Long a, Long b) {
			return a * b;
		}
	},
	DIVIDE("/") {
		@Override
		Long operate(Long a, Long b) {
			return a / b;
		}
	};

	private String symbol;

	Operator(String symbol) {
		this.symbol = symbol;
	}

	public String getSymbol() {
		return symbol;
	}

	abstract Long operate(Long a, Long b);

	public static Long calculate(String operator, Long rightOperand, Long leftOperand) {
		return Arrays.stream(Operator.values())
			.filter(v -> v.symbol.equals(operator))
			.findFirst()
			.orElseThrow(() -> new ExpressionValidationException(INVALID_EXPRESSION.getMessage()))
			.operate(rightOperand, leftOperand);
	}
}
