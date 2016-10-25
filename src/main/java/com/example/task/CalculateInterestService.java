package com.example.task;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CalculateInterestService implements JavaDelegate {
    private static final Logger LOGGER = LoggerFactory.getLogger(CalculateInterestService.class);

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        LOGGER.debug("calculating interest");
    }
}
