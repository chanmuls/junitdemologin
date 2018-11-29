package net.devtopia.demo.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
public class AuthServiceTest01 {
    /**
     * 테스트 클래스 만들고 테스트 실행
     * 일단 성공과 자신감 획득
     */

    @Test
    public void nothing() {

    }
}
