package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Background {

    @Given("The student should complete the high school")
    public void the_student_should_complete_the_high_school() {
        System.out.println("Finally High School Completed");

    }


    @Given("Need to know the cutoff of the Medical seat")
    public void need_to_know_the_cutoff_of_the_medical_seat() {

        System.out.println("Need 98%, to get seat this MBBS");
    }

    @Then("apply form to the college for MBBS course")
    public void apply_form_to_the_college_for_mbbs_course() {
        System.out.println("Fill the mark details and apply.");
    }

    @Then("prepare amount for the Medical college fee")
    public void prepare_amount_for_the_medical_college_fee() {
        System.out.println("get ready Rs.10,000 for sem fee.");
    }

    @Then("pay the fees to join the Medical college")
    public void pay_the_fees_to_join_the_medical_college() {
        System.out.println("Pay the fee in the 4th counter.");
    }

    @Given("Need to know the cutoff of the Engineering seat")
    public void need_to_know_the_cutoff_of_the_engineering_seat() {

        System.out.println("Need 80%, to get seat this ECE");

    }

    @Then("apply form to the college for BE course")
    public void apply_form_to_the_college_for_be_course() {

        System.out.println("Fill the mark details and apply.");
    }

    @Then("prepare amount for the Engineering college fee")
    public void prepare_amount_for_the_engineering_college_fee() {

        System.out.println("get ready Rs.5,000 for sem fee.");
    }

    @Then("pay the fees to join the Engineering college")
    public void pay_the_fees_to_join_the_engineering_college() {
        System.out.println("Pay the fee in the 5th counter.");
    }


}
