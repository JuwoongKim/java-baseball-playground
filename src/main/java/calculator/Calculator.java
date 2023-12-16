package calculator;

public class Calculator {

	public String calculate(Expression expression) {
		String[] expressionElements = expression.getExpressionElements();

		String rightOperand = expressionElements[0];

		for (int i = 1; i < expressionElements.length; i++) {
			String operator = expressionElements[i++];
			String leftOperand = expressionElements[i];
			rightOperand = operate(operator, rightOperand, leftOperand);
		}

		return rightOperand;
	}

	private String operate(String operator, String rightOperand, String leftOperand) {
		Long rightOperandNumber = Long.parseLong(rightOperand);
		Long leftOperandNumber = Long.parseLong(leftOperand);

		Long calculate = Operator.calculate(operator, rightOperandNumber, leftOperandNumber);

		return String.valueOf(calculate);
	}

}
