package net.devtopia.demo.security;

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
public class AuthServiceTest06 {

    // 중복 코드 제거
    private AuthService authService;

    @Before
    public void setUp() {
        authService = new AuthService();
    }

    @Test
    public void canCreate() {
        // 1. 코드 작성
    }

    @Test
    public void givenInvalidId_throwIllegalArgEx() {
        // 3. 예외처리 로직
        Exception thrownEx = null;

        try {
            authService.authenticate(null, "userPassword");
        } catch (Exception e) {
            //e.printStackTrace();

            thrownEx = e;
        }

        assertThat(thrownEx).isInstanceOf(IllegalArgumentException.class);

        Exception thrownEx2 = null;

        try {
            authService.authenticate("", "userPassword");
        } catch (Exception e) {
            //e.printStackTrace();

            thrownEx2 = e;
        }

        assertThat(thrownEx2).isInstanceOf(IllegalArgumentException.class);
    }

    // 2. 객체 생성
    private class AuthService {
        public void authenticate(String id, String password) {
            if (id == null) {
                throw new IllegalArgumentException();
            }
        }
    }
}
