package stepDefinitions.Options;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HooksExample {
    @Given("Thanos is born on Titan")
    public void thanos_is_born_on_titan() {
        System.out.println("Thanos is born on Titan, and he has big plans!");
    }

    @When("he collects the {string} Stone")
    public void he_collects_the_stone(String stone) {
        System.out.println("Thanos collects the " + stone + " Stone.");
    }

    @Then("he snaps his fingers to erase half the universe")
    public void he_snaps_his_fingers_to_erase_half_the_universe() {
        System.out.println("Thanos snaps his fingers, and half the universe vanishes.");
    }

    @Then("he retires to the garden")
    public void he_retires_to_the_garden() {
        System.out.println("Thanos retires to his garden, enjoying a peaceful sunset.");
    }
}
