package study.calculator;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import calculator.Calculator;
import calculator.Expression;

class CalculatorTest {

	@DisplayName("calculate 메서드 사칙 연산 성공")
	@ParameterizedTest
	@CsvSource(value = {"2 + 3 * 4 / 2:10", "200 + 300 * 40 / 20:1000"}, delimiter = ':')
	void calculate(String input, String expectedResult) {
		Expression expression = new Expression(input);

		String actualResult = Calculator.calculate(expression);

		assertThat(actualResult).isEqualTo(expectedResult);
	}
}