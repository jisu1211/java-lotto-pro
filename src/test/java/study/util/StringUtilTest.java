package study.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("String 객체의 유틸성 메소드 테스트")
class StringUtilTest {

    @ParameterizedTest
    @NullAndEmptySource
    void isEmpty_문자열이_null이거나_비어있으면_true(String str) {
        assertTrue(StringUtil.isEmpty(str));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "테스트"})
    void isEmpty_문자열이_null이_아니고_비어있지_않으면_false(String str) {
        assertFalse(StringUtil.isEmpty(str));
    }

}
