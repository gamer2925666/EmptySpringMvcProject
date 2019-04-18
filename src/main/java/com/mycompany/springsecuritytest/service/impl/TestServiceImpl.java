package com.mycompany.springsecuritytest.service.impl;

import com.mycompany.springsecuritytest.service.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
        @Override
        public void test() {
                System.out.println("test");
        }
}
