package stepDefinitions.Options;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShoppingStepDefinitions {

    @Given("I am on the product page")
    public void i_am_on_the_product_page() {
        System.out.println("Navigating to the product page...");
    }

    @When("I add a product to the cart")
    public void i_add_a_product_to_the_cart() {
        System.out.println("Adding a product to the cart...");
    }

    @Then("the product should be added successfully")
    public void the_product_should_be_added_successfully() {
        System.out.println("Product successfully added to the cart.");
    }

    @Given("I have items in the cart")
    public void i_have_items_in_the_cart() {
        System.out.println("Verifying items are present in the cart...");
    }

    @When("I proceed to checkout")
    public void i_proceed_to_checkout() {
        System.out.println("Proceeding to the checkout page...");
    }

    @Then("I should see the payment page")
    public void i_should_see_the_payment_page() {
        System.out.println("Payment page displayed successfully.");
    }

}
