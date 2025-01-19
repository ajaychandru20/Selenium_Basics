package stepDefinitions.Options;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class Taggs {
    private int number1;
    private int number2;
    private int result;

    @Given("I have two numbers {int} and {int}")
    public void i_have_two_numbers_and(int num1, int num2) {
        this.number1 = num1;
        this.number2 = num2;
    }

    @When("I add them")
    public void i_add_them() {
        this.result = this.number1 + this.number2;
    }

    @When("I subtract them")
    public void i_subtract_them() {
        this.result = this.number1 - this.number2;
    }

    @Then("the result should be {int}")
    public void the_result_should_be(int expected) {
        assertEquals(expected, this.result);
    }
}
