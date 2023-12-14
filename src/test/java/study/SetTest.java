package study;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {
	private Set<Integer> numbers;

	@BeforeEach
	void setup(){
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(4);
	}

	@DisplayName("size 메서드 동작 성공")
	@Test
	void size(){
		assertThat(numbers.size()).isEqualTo(3);
	}

	@DisplayName("ValueSource기능을 활용한 contains 메서드 동작 성공")
	@ParameterizedTest
	@ValueSource(ints ={1,2,4})
	void containsWithValueSource(Integer number){
		assertThat(numbers.contains(number)).isTrue();
	}

	@DisplayName("CsvSource를 활용한 contains 메서드 동작 성공")
	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:false", "4:true"} , delimiter = ':')
	void containsSithCsvSource(Integer number, boolean result){
		assertThat(numbers.contains(number)).isEqualTo(result);
	}

}
