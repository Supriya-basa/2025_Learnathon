package coreComponents;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    @Before
    public void beforeScenario(Scenario scenario) {
        String scenarioName = scenario.getName();
        System.out.println("Scenario Name: " + scenarioName);
    }
}
