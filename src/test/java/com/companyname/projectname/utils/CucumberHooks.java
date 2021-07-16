package com.companyname.projectname.utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.Assert;

import java.util.logging.Logger;

public class CucumberHooks {
    private final java.util.logging.Logger logger = Logger.getLogger(Class.class.getName());

    @Before
    public void beforeScenario(Scenario scenario) {
        String scenarioName = new String();
        try {
            scenarioName= scenario.getName();
            logger.info("Running scenario - " + scenarioName);
            String browserToUse = PropertyReader.getProperty("browser");
            DriverUtil.openBrowser(browserToUse);
        } catch (Exception e) {
            Assert.fail("Before scenario failed. Scenario name is -- " + scenarioName);
        }
    }

    @After
    public void afterScenario(Scenario scenario) {
        try {
            DriverUtil.closeDriver();
        } catch (Exception e) {
            Assert.fail("After scenario failed. Scenario name is -- " + scenario.getName());
        }
    }
}
