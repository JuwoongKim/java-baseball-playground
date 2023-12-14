package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.*;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");

        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split(){
        String[] actual = "1,2".split(",");

        assertThat(actual).isNotNull()
            .contains("2","1")
            .containsExactly("1","2");
    }

    @Test
    void substring(){
        String actual = "(1,2)".substring(1, 4);

        assertThat(actual).isNotNull()
            .isEqualTo("1,2");
    }

    @DisplayName("범위 내에 있는 문자 추출 성공")
    @Test
    void charAt(){
        char actual = "abc".charAt(0);
        assertThat(actual).isEqualTo('a');
    }

    @DisplayName("범위 밖에 있는 문자 추출시 예외 발생")
    @Test
    void charAtWithException(){
        assertThatThrownBy(() -> "abc".charAt(3)).isInstanceOf(StringIndexOutOfBoundsException.class);
    }

}
