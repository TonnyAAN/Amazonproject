package stepdefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.AmazonPage;

import pages.WebDriverManager;



public class AmazonPageStepdef {

    WebDriver driver = WebDriverManager.getDriver();

    private AmazonPage loginPage;

    @Given("I am on the Amazon UK homepage")
    public void i_am_on_the_amazon_uk_homepage() {
        driver.get("https://www.amazon.co.uk");
        loginPage = new AmazonPage(driver);

        loginPage.tryClick();

    }
    @When("I click on the Sign in button")
    public void i_click_on_the_sign_in_button() {

        loginPage.helloSignButton();
    }
    @When("I enter a valid email or mobile number")
    public void i_enter_a_valid_email_or_mobile_number()  {
        loginPage.enterEmail("automationu08@gmail.com");
        loginPage.clickContButton();
    }
    @When("I enter the correct password")
    public void i_enter_the_correct_password() {

        loginPage.enterPassword("Automation@3t");
    }
    @Then("I should be signed in to my Amazon account")
    public void i_should_be_signed_in_to_my_amazon_account() {
        loginPage.clickSignButton();
    }

    @When("I search for {string}")
    public void i_search_for(String string) {
        //loginPage.accept();
        loginPage.enterItem("amazon socks");
        loginPage.clickSearchButton();
    }
    @When("I add the socks to the cart")
    public void i_add_the_socks_to_the_cart() {
        loginPage.selectItem();
        String actual=loginPage.selectItemText();
        System.out.println(actual);
        loginPage.addBasket();
    }
    @Then("the socks should be in the cart")
    public void the_socks_should_be_in_the_cart() {
        loginPage.viewBasket();
        String expected = loginPage.expectedTextItem();
        System.out.println(expected);
        loginPage.verifyProduct();

    }




}
