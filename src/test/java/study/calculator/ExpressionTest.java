package study.calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import calculator.Expression;
import calculator.exception.ExpressionValidationException;

class ExpressionTest {

	@DisplayName("Expression 생성 시 validateExpression 메서드에 의한 검증 성공")
	@ParameterizedTest
	@ValueSource(strings = {
		"2 + 3 * 4 / 2",
		"200 + 300 * 40 / 20",
	})
	public void validateExpression(String input) {
		assertThatCode(() -> new Expression(input)).doesNotThrowAnyException();
	}

	@DisplayName("Expression 생성 시 validateExpression 메서드 의해 수식 조건에 맞지 않을 때 예외 발생")
	@ParameterizedTest
	@ValueSource(strings = {
		"10",
		"10 +",
		"10 + -",
		"10 ++",
		"10++ 10",
		"+ 10 + 10",
		"01 * 11"
	})
	public void validateExpressionWithExpressionValidationException(String input) {
		assertThatThrownBy(() -> new Expression(input)).isInstanceOf(ExpressionValidationException.class)
			.hasMessageContaining("수식의 형식이 맞지 않습니다.");
	}
}
