package com.morty.usercenter.service;

import java.util.Date;

import com.morty.usercenter.model.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 用户服务测试
 *
 * @author shkstart
 * @create 2024--10 17:33
 */
@SpringBootTest
class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    public void testAddUser() {
        User user = new User();
        user.setUsername("testMorty");
        user.setUserAccount("123");
        user.setAvatarUrl("https://www.baidu.com/link?url=tHxZyszC7kOr7yJJbGCQp-2wlYBCZMeqXsJYsSgH7Ryzidwuqy4MhSWKPyaPWVEiQyyoH0umZqQFuJTmrOkybOHVE6KKajzQdcyhL4D5dOBqniWmjnZvTnIKR9ovEYz_HweBtUHfKI1xrCZCoA7yHYO2A2kNqXpgOxsGRk45jYpmfL2gPUXUXmVKzrfDmksJ1GqKQAwBXvsgB3shWmjDaMJj63M3OOC3k0Hm1KHOjpvgO7FNheJiQ999i-uxVVVbpZq8hO_vP0WLZ3ex-xz-47rmQrJA2O2I7WeEMKCYEErJm-gMMmWKRIX2KHAX6nxFAlnVqSlpKfBtydMA5Mr6SoTw2al88DCInfq3IEkTXrwjAYxM3xZ2tOy5d2h8HrnUzMHmavDn6CndXTeP8pyGBSJSNFoGG4xfQF3cej6QNvemB1AbCPoiZYtq3WDxP6-5CYsgjnXYUtCaDFuTSfdZibosaxYI4DTc2HJ5-y8N3ZPw1xHZV6YRsnmWELlAKI3eAtLHWeeYGyznV_-CAwII8gZwZEpflIdMX3Kl6VRs5LNyi_idbOWnPYKaEFPkvAyBiA7E0y31rkqmwdyucrMS5sauBDx_lnqgMXvnTcfYKqYzrrC6N-YRNWLqyAxKuJPbnIeIHW09EwbXRuHJb_b3VJ80lEvabz87Q9DG4GI28Ga&wd=&eqid=d8319056001d51480000000665ed8189");
        user.setGender(0);
        user.setUserPassword("123");
        user.setPhone("123");
        user.setEmail("123");
        boolean result = userService.save(user);
        System.out.println(user.getId());
        Assertions.assertTrue(result);
    }

    @Test
    void userRegister() {
        String userAccount = "morty";
        String userPassword = "";
        String checkPassword = "123456";
        String planetCode = "1";
        long result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1, result);

        userAccount = "mo";
        result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1, result);

        userAccount = "morty";
        userPassword = "123456";
        result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1, result);

        userAccount = "mo r ty";
        userPassword = "12345678";
        result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1, result);

        checkPassword = "123456789";
        result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1, result);

        userAccount = "testMorty";
        checkPassword = "12345678";
        result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1, result);

        userAccount = "morty";
        result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1, result);
    }
}