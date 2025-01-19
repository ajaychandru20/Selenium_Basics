package stepDefinitions.BeforeAfterHooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class ShoppingHooks {

    @Before("@CartFeature")
    public void beforeCartFeature() {
        System.out.println("Before @CartFeature: Setting up the cart environment...");
    }

    @After("@CartFeature")
    public void afterCartFeature() {
        System.out.println("After @CartFeature: Clearing the cart...");
    }

    @Before("@CheckoutFeature")
    public void beforeCheckoutFeature() {
        System.out.println("Before @CheckoutFeature: Preparing checkout environment...");
    }

    @After("@CheckoutFeature")
    public void afterCheckoutFeature() {
        System.out.println("After @CheckoutFeature: Resetting checkout session...");
    }

    @Before("@CheckoutFeature")
    public void beforeScenario() {
        System.out.println("Before Scenario: General setup for all scenarios in ShoppingHooks step file.");
    }

    @After("@CheckoutFeature")
    public void afterScenario() {
        System.out.println("After Scenario: General cleanup for all scenarios in ShoppingHooks step file.");
    }
}
