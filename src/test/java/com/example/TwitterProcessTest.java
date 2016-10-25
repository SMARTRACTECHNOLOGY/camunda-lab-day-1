package com.example;

import java.util.HashMap;
import java.util.Map;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.test.assertions.ProcessEngineAssertions;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

/**
 * Tests the twitter approval process.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
@SpringApplicationConfiguration(classes = CamundaSpringBootApplication.class)
public class TwitterProcessTest {

    @Autowired
    private ProcessEngine processEngine;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    /**
     * Just tests if the process definition is deployable.
     */
    @Test
    public void testParsingAndDeployment() {
        // nothing is done here, as we just want to check for exceptions during deployment
    }

    @Test
    public void testProcessing() {

        Map<String, Object> map = new HashMap<>();
        map.put("approved", true);
        map.put("content", "I am a teapot.");

        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("twitter-blocker", map);

        assertThat(processInstance, is(notNullValue()));

        // To generate the coverage report for a single tests add this line as the last line of your test method:
        // Not working in Spring Context right now.
        // ProcessTestCoverage.calculate(processInstance,processEngine);

        ProcessEngineAssertions.assertThat(processInstance)
            .isEnded();

        assertThat(runtimeService.createProcessInstanceQuery()
                       .count(), is(0L));

    }
}
