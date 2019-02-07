import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SignUpTest {

    WebDriver driver;
    SignUpPage page;

    @Before
    public void setUp() {//throws MalformedURLException {
        System.setProperty("webdriver.gecko.driver", "C:\\drivers\\geckodriver.exe");
        System.setProperty ("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        //  System.setProperty("phantomjs.binary.path", "C:\\phantomjs\\phantomjs.exe");

        driver = new ChromeDriver();
        //driver = new FirefoxDriver();

       // DesiredCapabilities caps = DesiredCapabilities.firefox();
        // driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
        // driver = new RemoteWebDriver(new URL("http://localhost:4444/grid/console"), caps);



        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.manage().window().maximize();
//browser ="marionette";
        driver.get("https://accounts.spotify.com/en/login/?_locale=int&continue=https:%2F%2Fwww.spotify.com%2Fint%2Faccount%2Foverview%2F");
    }

    @Test
    public void signUpWithEmptyPassword(){
        page = new SignUpPage (driver);
        page.typeName ("wqerty")
                //   .typeConfirmEmail("sdf@mail.ru")
                //    .setShare (true)
                .clickSignUpButton ();
        //  page.getError ("Please enter your password.").shouldBe(Condition.visible);
        Assert.assertEquals ("Please enter your password.",page.getPasswordErrorText ());

    }
    @Test
    public void signUpWithEmptyName() {
        page = new SignUpPage (driver);
        // page.typeName ("")

        //   .typeConfirmEmail("sdf@mail.ru")
        //  .setShare (true)
        page.clickSignUpButton ();
        //  page.getError ("Please enter your Spotify username or email address.").shouldBe(Condition.visible);
        Assert.assertEquals ("Please enter your Spotify username or email address.", page.getNameErrorText ());
    }
    @Test

    public void typeInvalidCheckBox(){
        page = new SignUpPage (driver);
        page.typeName ("wqeqe213")
                //.typeName ("")
                .typePassword ("fggfd")
                //  .typePassword ("")
                .setShare (false)
                .clickSignUpButton ();
        //page.getError ("Remember me").shouldBe(Condition.visible);
        Assert.assertEquals ("Remember me", page.getCheckBoxErrorText ());

    }
    @Test

    public void typeInvalidValues(){
        page = new SignUpPage (driver);
        page.typeName ("wqeqe213")
                //.typeName ("")
                .typePassword ("35kgjlgl4")
                //  .typePassword ("")
                // .setShare (true)
                .clickSignUpButton ();
        //  page.getError ("Incorrect username or password.").shouldBe(Condition.visible);
        String error = page.getErrorLabelText ();
        Assert.assertEquals ("Incorrect username or password.", error);

    }



    @After
    public void tearDown(){
        driver.quit ();
    }
}