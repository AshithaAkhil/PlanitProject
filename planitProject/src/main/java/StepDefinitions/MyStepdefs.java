package StepDefinitions;

import Functions.TC1;
import Functions.TC2;
import Functions.TC3;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepdefs {
    @Given("The Planit Home Page")
    public void thePlanitHomePage(){
        TC1.openBrowser();
    }

    @When("From the home page go to contact page")
    public void fromTheHomePageGoToContactPage() throws InterruptedException {
        TC1.goToContactPage();
    }

    @Then("Click submit button")
    public void clickSubmitButton() throws InterruptedException {
        TC1.clickSubmit();
    }

    @And("Verify error messages")
    public void verifyErrorMessages() {
        TC1.verifyErrors();
    }

    @When("Populate mandatory fields")
    public void populateMandatoryFields() {
        TC1.enterMandatoryFields();
    }

    @Then("Validate errors are gone")
    public void validateErrorsAreGone() throws InterruptedException {
        TC1.validateNoErrors();
    }

    @And("Close the browser")
    public void closeTheBrowser() {
        TC1.closeBrowser();
    }

    @Then("Validate successful submission message")
    public void validateSuccessfulSubmissionMessage() throws InterruptedException {
        TC2.validateSuccess();
    }

    @When("Go to the Shop page")
    public void goToTheShopPage() {
        TC3.clickShop();
    }

    @Then("Add Products into Cart")
    public void addProductsIntoCart() throws InterruptedException {
        TC3.addProducts();
    }

    @Then("Verify the subtotal of each product")
    public void verifyTheSubtotalOfEachProduct() {
        TC3.calculateSubtotal();
    }

    @Then("Verify price for each product")
    public void verifyPriceForEachProduct() {
        TC3.calculatePrice();
    }

    @And("verify the Amount")
    public void verifyTheAmount() {
        TC3.calculateTotal();
    }
}
