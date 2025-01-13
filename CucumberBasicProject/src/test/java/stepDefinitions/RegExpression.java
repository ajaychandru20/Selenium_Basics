package stepDefinitions;

import io.cucumber.java.en.Given;

public class RegExpression {
    @Given("This is for the integer result {int}")
    public void this_is_for_the_integer_result(Integer int1) {
        System.out.println("This is for the Integer: " + int1);
    }
    @Given("This is for the float result {double}")
    public void this_is_for_the_float_result(Double double1) {
        System.out.println("This is for the Float: " + double1);
    }
    @Given("This is for the string result {string}")
    public void this_is_for_the_string_result(String string) {
        System.out.println("This is for the String: "+ string);
    }
}
