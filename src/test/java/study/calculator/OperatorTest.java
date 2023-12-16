package study.calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import calculator.Operator;

public class OperatorTest {

	@DisplayName("calculator 메서드 사칙 연산 동작 성공")
	@ParameterizedTest
	@CsvSource(value = {"+:10:5:15","-:10:5:5","*:10:5:50","/:10:5:2"}, delimiter = ':')
	public void calculate(String operator, Long rightOperand, Long leftOperand, Long expectedResult) {
		Long actualResult = Operator.calculate(operator,rightOperand,leftOperand);
		assertThat(actualResult).isEqualTo(expectedResult);
	}

	@DisplayName("calculator 메서드 0으로 나눌 때 ArithmeticException 발생")
	@Test
	public void calculateWithArithmeticException(){
		assertThatThrownBy(()->Operator.calculate("/", 10L, 0L))
			.isInstanceOf(ArithmeticException.class)
			.hasMessageContaining("0으로 나누기");
	}
}
