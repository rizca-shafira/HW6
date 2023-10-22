package SwagLabs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Login {
    WebDriver driver;
    @Given("the user launches the web app")
    public void the_user_launches_the_web_app() {
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.setHeadless(false);

        driver = new ChromeDriver(opt);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); //wait to load page before asserting
        driver.manage().window().maximize();
        driver.get(baseUrl);

        String title = driver.getTitle();
        Assert.assertEquals(title,"Swag Labs");
    }

    @When("the user inputs a registered username")
    public void the_user_inputs_a_registered_username() {
        driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
    }

    @When("the user inputs the correct password for the given username")
    public void the_user_inputs_the_correct_password_for_the_given_username() {
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
    }

    @When("the user clicks the Login button")
    public void the_user_clicks_the_login_button() {
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
    }

    @Then("the user should be logged in successfully")
    public void the_user_should_be_logged_in_successfully() {
        WebElement burgerMenu = driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]"));
        driver.close();
        driver.quit();
    }

    @When("the user inputs an unregistered username")
    public void the_user_inputs_an_unregistered_username() {
        driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("riz");
    }

    @When("the user inputs an incorrect password for the username")
    public void the_user_inputs_an_incorrect_password_for_the_username() {
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("password");
    }

    @Then("the user should not be able to log in")
    public void the_user_should_not_be_able_to_log_in() {
        String ErrorLogin = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
        Assert.assertEquals(ErrorLogin,"Epic sadface: Username and password do not match any user in this service");
        driver.close();
        driver.quit();
    }

    @Given("the user is already successfully logged in")
    public void the_user_is_already_successfully_logged_in() {
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.setHeadless(false);

        driver = new ChromeDriver(opt);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); //wait to load page before asserting
        driver.manage().window().maximize();
        driver.get(baseUrl);

        String title = driver.getTitle();
        Assert.assertEquals(title,"Swag Labs");

        driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");

        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");

        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();

        WebElement burgerMenu = driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]"));
    }

    @When("the user opens the inventory\\/product list page")
    public void the_user_opens_the_inventory_product_list_page() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.saucedemo.com/inventory.html");
    }

    @Then("the user can see the list of products")
    public void the_user_can_see_the_list_of_products() {
        String statusInventory = "Not displayed"; // Initialize with a default value
        List<WebElement> inventories = driver.findElements(By.xpath("//*[starts-with(@id, 'item_')]/div"));
        for (WebElement inventory : inventories) {
            if (inventory.isDisplayed()) {
                statusInventory = "Displayed";
                break; // Exit the loop as soon as a displayed element is found
            }
        }
        Assert.assertEquals(statusInventory,"Displayed");
        driver.close();
        driver.quit();
    }

    @Given("the user hasn't yet logged in or is already logged out")
    public void the_user_hasn_t_yet_logged_in_or_is_already_logged_out() {
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.setHeadless(false);

        driver = new ChromeDriver(opt);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); //wait to load page before asserting
        driver.manage().window().maximize();
        driver.get(baseUrl);

        String title = driver.getTitle();
        Assert.assertEquals(title,"Swag Labs");

        driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");

        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");

        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();

        driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]")).click();

        driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]")).click();
    }

    @Then("the user can't see products")
    public void the_user_can_t_see_products() {
        String statusInventory = "Not displayed"; // Initialize with a default value
        List<WebElement> inventories = driver.findElements(By.xpath("//*[starts-with(@id, 'item_')]/div"));
        for (WebElement inventory : inventories) {
            if (inventory.isDisplayed()) {
                statusInventory = "Displayed";
                break; // Exit the loop as soon as a displayed element is found
            }
        }
        Assert.assertEquals(statusInventory,"Not displayed");
    }

    @Then("the page displays a warning that the user must be logged in to access the inventory page")
    public void the_page_displays_a_warning_that_the_user_must_be_logged_in_to_access_the_inventory_page() {
        String warning = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
        Assert.assertEquals(warning,"Epic sadface: You can only access '/inventory.html' when you are logged in.");
        driver.close();
        driver.quit();
    }

    @When("the user fail to open the inventory\\/product list page")
    public void theUserFailToOpenTheInventoryProductListPage() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.saucedemo.com/");
        driver.get("https://www.saucedemo.com/inventory.html");
    }
}
