package com.mellow;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class testExample {
    // SpringSecurity加盐加密
    @Test
    public void testSpringSecurity(){
        // $2a$10$dyIf5fOjCRZs/pYXiBYy8uOiTa1z7I.mpqWlK5B/0icpAKijKCgxe
        // $2a$10$OphM.agzJ55McriN2BzCFeoLZh/z8uL.8dcGx.VCnjLq01vav7qEm

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String s = encoder.encode("zheng");
        System.out.println(s);
        String s1 = encoder.encode("abc");
        System.out.println(s1);

        // 进行判断
        boolean b = encoder.matches("zheng", "$2a$10$b7xQ.fiHt4T.0kQww6.Re.AN2LYvvcolwxm.sLI34rob8BnOZsjza");
        System.out.println(b);
    }
}
