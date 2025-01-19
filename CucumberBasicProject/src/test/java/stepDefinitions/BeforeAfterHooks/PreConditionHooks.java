package stepDefinitions.BeforeAfterHooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

public class PreConditionHooks {
    @Before("@ThanosHooks")
    public void beforeScenario() {
        System.out.println("Before Scenario: The Universe exists. Chaos is balanced.");
    }

    @After("@ThanosHooks")
    public void afterScenario() {
        System.out.println("After Scenario: The Universe has been balanced. Time for a break.");
    }

    @BeforeStep("@ThanosHooks")
    public void beforeStep() {
        System.out.println("Before Step: Thanos thinks about his next move.");
    }

    @AfterStep("@ThanosHooks")
    public void afterStep() {
        System.out.println("After Step: Thanos reflects on the progress he made.");
    }

    @Before("@InfinityGauntlet")
    public void beforeInfinityGauntletTag() {
        System.out.println("Before @InfinityGauntlet: Thanos sharpens his resolve to collect the Stones.");
    }

    @After("@InfinityGauntlet")
    public void afterInfinityGauntletTag() {
        System.out.println("After @InfinityGauntlet: Thanos feels accomplished and stares at the sunrise.");
    }
}
