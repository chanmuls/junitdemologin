package net.devtopia.demo.security;

import net.devtopia.demo.exception.NotExistingUserException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * 1. 테스트 클래스 만들기
 * 2. 객체 생성하기(쉬운)
 * 3. ID 값이 비정상인 경우(쉬운, 정상에서 벗어난)
 * 4. PW 값이 비정상인 경우(쉬운, 정상에서 벗어난)
 * 5. User가 존재하지 않는 경우(정상에서 벗어난)
 * 6. ID에 해당하는 User가 존재하는데, PW가 일치하지 않는 경우(정상에서 벗어난)
 * 7. ID와 PW가 일치하는 경우(정상)
 *    - 인증 정보를 리턴
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthServiceTest12 {

    public static final String USER_PASSWORD = "userPassword";
    private AuthService authService;

    @Before
    public void setUp() {
        // 중복 코드 제거
        authService = new AuthService();
    }

    @Test
    public void canCreate() {
        // 1. 코드 작성
    }

    @Test
    public void whenUserNotFound_throwNotExistingUserEx() {
        assertExceptionthrown("noUserId", USER_PASSWORD, NotExistingUserException.class);
    }

    private void assertExceptionthrown(String id, String password, Class<? extends Exception> type) {
        Exception thrownEx = null;

        try {
            authService.authenticate(id, password);
        } catch (Exception e) {
            //e.printStackTrace();

            thrownEx = e;
        }

        assertThat(thrownEx).isInstanceOf(type);
    }

    @Test
    public void givenInvalidId_throwIllegalArgEx() {
        // 3. 예외처리 로직

        // 중복되는 코드는 메소드 추출을 하게 되는데 다른 부분을 로컯 변수로 만들고 추출하면 됨
        // "userPassword" 은 매직 넘버이므로 상수로 교체 가능

        // 아이디 오류 로직
        assertIllegalArgExThrown(null, USER_PASSWORD);
        assertIllegalArgExThrown("", USER_PASSWORD);

        // 패스워드 오류 로직
        assertIllegalArgExThrown("userId", null);
        assertIllegalArgExThrown("userId", "");
    }

    private void assertIllegalArgExThrown(String id, String password) {
        assertExceptionthrown(id, password, IllegalArgumentException.class);
    }

    // 2. 객체 생성
    private class AuthService {
        public void authenticate(String id, String password) {
            if (id == null || id.isEmpty()) {
                throw new IllegalArgumentException();
            }

            if (password == null || password.isEmpty()) {
                throw new IllegalArgumentException();
            }

            if (id.equals("noUserId")) {
                throw new NotExistingUserException();
            }
        }
    }
}
