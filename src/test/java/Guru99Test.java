import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Guru99Test {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver","F://Intelij selenium projects//Workshop_project//src//test//resources//dirvers//chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/V4/");
    }


    @Test
    public void successfulLogin(){


        WebElement userIDTest = driver.findElement(By.name("uid"));
        userIDTest.sendKeys("mngr538765");

        WebElement passwordTest = driver.findElement(By.name("password"));
        passwordTest.sendKeys("jUpunum");

        WebElement loginButton = driver.findElement(By.xpath("//input[@value='LOGIN']"));
        loginButton.click();


        WebElement welcomeLable = driver.findElement(By.xpath("//tr[@class='heading3']/td"));
        Assert.assertEquals(welcomeLable.getText(), "Manger Id : mngr538765", "Error: User name is incorrect");

    }
    @Test
    public void unsuccessfulLogin(){

        WebElement userIDTest = driver.findElement(By.name("uid"));
        userIDTest.sendKeys("mngr538765");

        WebElement passwordTest = driver.findElement(By.name("password"));
        passwordTest.sendKeys("jUpunum**");

        WebElement loginButton = driver.findElement(By.xpath("//input[@value='LOGIN']"));
        loginButton.click();

        String alertMsg = driver.switchTo().alert().getText();
        Assert.assertEquals(alertMsg,"User or Password is not valid","Error: Alert Message incorrect");

    }
//    @AfterMethod
//    public void teardown(){
//        driver.quit();
//    }
}
