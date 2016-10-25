package com.example;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CamundaSpringBootApplication.class)
@WebAppConfiguration
@ActiveProfiles("test")
public class CamundaSpringBootApplicationTests {

    @Test
    public void contextLoads() {

    }

}
