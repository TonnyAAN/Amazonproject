package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class AmazonPage {

    WebDriver driver = WebDriverManager.getDriver();

    public String actualProduct = null;
    public String expectedProduct = null;

    //Locators

    private By tryButton = By.xpath("//a[contains(.,'Try different image')]");

    private By acceptButton = By.xpath("//input[@id='sp-cc-accept']");
    private By helloSignIn = By.xpath("//span[@id='nav-link-accountList-nav-line-1']");
    private By emailInputLocator = By.xpath("//input[@id='ap_email']");
    private By contInputLocator = By.xpath("//input[@id='continue']");
    private By passwordInputLocator = By.xpath("//input[@id='ap_password']");
    private By signinButtonLocator = By.xpath("//input[@id='signInSubmit']");

    private By searchInputLocator = By.xpath("//input[@id='twotabsearchtextbox']");
    private By clickSearchLocator = By.xpath("//input[@id='nav-search-submit-button']");

    private By selectItemLocator = By.xpath("//div[@class='a-section a-spacing-base a-text-center']//img[@data-image-index=\"1\"]");

    private By selectText = By.xpath("//div[@id='titleBlock']//span[@id='productTitle']");

    private By adBasketLocator = By.xpath("//input[@id='add-to-cart-button']");

    private By viewBasketLocator = By.xpath("//span[@id='nav-cart-count']");

    private By expectedText = By.xpath("//form[@id='activeCartViewForm']//span[@class='a-truncate-cut']");


    //Constructor
    public AmazonPage(WebDriver driver) {
        this.driver = driver;
    }

    //Actions


    public void tryClick() {
        WebElement tryclick = driver.findElement(tryButton);
        tryclick.click();

    }

    public void helloSignButton() {
        WebElement hellosignIn = driver.findElement(helloSignIn);
        hellosignIn.click();
    }

    public void enterEmail(String email) {
        WebElement emailInput = driver.findElement(emailInputLocator);
        emailInput.sendKeys(email);

    }

    public void enterPassword(String password) {
        WebElement passwordInput = driver.findElement(passwordInputLocator);
        passwordInput.sendKeys(password);
    }

    public void clickSignButton() {
        WebElement signButton = driver.findElement(signinButtonLocator);
        signButton.click();
    }

    public void clickContButton() {
        WebElement contButton = driver.findElement(contInputLocator);
        contButton.click();

    }

    public void enterItem(String itemname) {

        WebElement searchInput = driver.findElement(searchInputLocator);
        searchInput.sendKeys(itemname);
    }

    public void clickSearchButton() {
        WebElement searchButton = driver.findElement(clickSearchLocator);
        searchButton.click();
    }

    public void selectItem() {
        WebElement selItem = driver.findElement(selectItemLocator);
        selItem.click();

    }

    public String selectItemText() {

        try {
            WebElement itemText = driver.findElement(selectText);
            String textA = itemText.getText();
            int commaIndex = textA.indexOf(",");
            if (commaIndex >= 0) {
                actualProduct = textA.substring(0, commaIndex);
            } else {
                actualProduct = textA;
            }
            return actualProduct;
        } catch (ArrayIndexOutOfBoundsException e) {
            // Handle the exception here
            System.out.println("Error: Index out of bounds for the string.");
            return ""; // Return an empty string or a default value
        }

    }

    public void addBasket() {
        WebElement add = driver.findElement(adBasketLocator);
        add.click();
    }

    public void viewBasket() {
        WebElement basket = driver.findElement(viewBasketLocator);
        basket.click();
    }

    public String expectedTextItem() {

        try {
            WebElement expectedItem = driver.findElement(expectedText);
            String textB = expectedItem.getText();
            int commaIndex = textB.indexOf(",");
            if (commaIndex >= 0) {
                expectedProduct = textB.substring(0, commaIndex);
            } else {
                expectedProduct = textB;
            }
            return expectedProduct;
        } catch (ArrayIndexOutOfBoundsException e) {
            // Handle the exception here
            System.out.println("Error: Index out of bounds for the string.");
            return ""; // Return an empty string or a default value
        }

    }

    public void accept() {
        WebElement acceptclick = driver.findElement(acceptButton);
        acceptclick.click();
    }

    public void verifyProduct() {

        if(expectedProduct.equals(actualProduct)) {
            System.out.println("Product matched");
        }
        else{
            System.out.println("Product not matched");
        }

    }
}







