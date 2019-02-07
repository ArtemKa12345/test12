//package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpPage {

    WebDriver driver;
    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private By nameField = By.cssSelector ("#login-username");
    private By passwordField = By.cssSelector ("#login-password");
    private By shareCheckBox = By.cssSelector ("body > div.ng-scope > div.container-fluid.login.ng-scope > div > form > div.row.row-submit > div:nth-child(1) > div > label > span");
    private By regisretButton = By.cssSelector ("#login-button");
    private By errorLabel = By.cssSelector ("body > div.ng-scope > div.container-fluid.login.ng-scope > div > form > div.row.ng-scope > div > p > span");
    private By errorName = By.cssSelector ("body > div.ng-scope > div.container-fluid.login.ng-scope > div > form > div:nth-child(1) > div > div > label");
    private By errorPassword = By.cssSelector ("body > div.ng-scope > div.container-fluid.login.ng-scope > div > form > div:nth-child(2) > div > div > label");
    private By errorCheckBox = By.cssSelector ("body > div.ng-scope > div.container-fluid.login.ng-scope > div > form > div:nth-child(3) > div > div > label");

    private By errorByText = By.cssSelector ("body > div.ng-scope > div.container-fluid.login.ng-scope > div > form > div:nth-child(%s) > div > div > label");



    public SignUpPage typeName(String name) {
        driver.findElement (nameField).sendKeys (name);
        return this;
    }

    public SignUpPage typePassword(String password) {
        driver.findElement  (passwordField).sendKeys (password);
        return this;
    }

    public SignUpPage setShare(boolean value) {
//$(shareCheckBox).setSelected (value);

        WebElement checkbox = driver.findElement  (shareCheckBox);
        if (!checkbox.isSelected () == value) {
            checkbox.click ();
        }

        return this;
    }

    public void clickSignUpButton() {
        // $(regisretButton).waitWhile (Condition.disabled, 5000);
        driver.findElement  (regisretButton).click ();
    }

    public String getErrorLabelText(){
        return driver.findElement (errorLabel).getText ();
    }

 /*   public List<WebElement> getErrors() {
        return driver.findElements (errorLabel);
    }
    public String getErrorByNumber(int number) {
        return getErrors ().get (number - 1).getText ();
    }
*/


    //если не сработает метод со срингом
    public String getNameErrorText(){
        return driver.findElement (errorName).getText ();
    }
    public String getPasswordErrorText(){
        return driver.findElement (errorPassword).getText ();
    }
    public String getCheckBoxErrorText(){
        return driver.findElement (errorCheckBox).getText ();
    }

 /*   public SelenideElement getError(String message) {
        return $(cssSelector (format (message,errorByText)));
    }
*/
/*
        //  System.setProperty("webdriver.gecko.driver", "D:\\progi\\JavaProject\\testselenium\\drivers\\geckodriver.exe");
        System.setProperty ("webdriver.chrome.driver", "D:\\progi\\JavaProject\\testselenium\\driver\\chromedriver.exe");
        //  System.setProperty("phantomjs.binary.path", "C:\\phantomjs\\phantomjs.exe");


        driver = new ChromeDriver ();

        driver.manage ().timeouts ().implicitlyWait (5, TimeUnit.SECONDS);
        driver.manage ().window ().maximize ();
        driver.get ("https://spotify.com");
*/
}