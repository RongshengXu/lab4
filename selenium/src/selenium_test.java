/**
 * Created by rongshengxu on 11/25/15.
 */
//package org.openqa.selenium.example;
import static org.junit.Assert.*;
import java.lang.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class selenium_test {
    public static void test_normal() {

        // turn off htmlunit warnings
        java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(java.util.logging.Level.OFF);
        java.util.logging.Logger.getLogger("org.apache.http").setLevel(java.util.logging.Level.OFF);

        // Create a new instance of the html unit driver
        // Notice that the remainder of the code relies on the interface,
        // not the implementation.
        WebDriver driver = new HtmlUnitDriver();

        // And now use this to visit Google
        driver.get("http://apt-public.appspot.com/testing-lab-login.html");

        // Find the text input element by its name
        WebElement user = driver.findElement(By.name("userId"));
        WebElement pwd = driver.findElement(By.name("userPassword"));
        user.clear();
        pwd.clear();

        // Enter something to search for
        user.sendKeys("andy");
        pwd.sendKeys("apple");
        user.submit();

        assertEquals ("Online temperature conversion calculator", driver.getTitle());
        System.out.println("Page title is: " + driver.getTitle());

        WebElement element = driver.findElement(By.name("farenheitTemperature"));
        element.clear();
        System.out.println("Input value 100");
        element.sendKeys("100");
        element.submit();
        assertTrue(driver.getPageSource().contains("100 Farenheit = 37.78 Celsius"));
        System.out.println("Get resutl: 100 Farenheit = 37.78 Celsius");

        System.out.println("Select city: Austin");
        element = driver.findElement(By.cssSelector("input[value='Austin']"));
        element.click();
        element.submit();
        assertTrue(driver.getPageSource().contains("Temperature in Austin = 72 degrees Farenheit"));
        System.out.println("Temperature in Berkeley = 100 degrees Farenheit");
        driver.quit();
    }

    public void test_login() {

        String u = "bo";
        String p = "bathtub";

        System.out.println("Test bad login:" + u +", " + p);
        WebDriver driver= new HtmlUnitDriver();

        driver.get("http://apt-public.appspot.com/testing-lab-login.html");
        WebElement user=driver.findElement(By.name("userId"));
        WebElement pwd=driver.findElement(By.name("userPassword"));
        user.clear();
        pwd.clear();
        user.sendKeys(u);
        pwd.sendKeys(p);
        pwd.submit();

        assertEquals("Bad Login",driver.getTitle());
        System.out.println("Bad Login test!");
        driver.quit();
    }

    public void test_input(boolean after){
        if (!after) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        System.out.println("Test Input");

        WebDriver driver= new HtmlUnitDriver();
        driver.get("http://apt-public.appspot.com/testing-lab-login.html");
        WebElement element=driver.findElement(By.name("userId"));
        element.clear();
        WebElement element1=driver.findElement(By.name("userPassword"));
        element1.clear();
        element.sendKeys("bob");
        element1.sendKeys("bathtub");
        element.submit();

        System.out.println("Put in 211.99199");
        element=driver.findElement(By.name("farenheitTemperature"));
        element.clear();
        element.sendKeys("211.99199");
        element.submit();
        assertTrue(driver.getPageSource().contains("211.99199 Farenheit = 100 Celsius"));
        System.out.println("211.99199 Farenheit = 100 Celsius");

        System.out.println("Put in abc");
        driver.navigate().back();
        element=driver.findElement(By.name("farenheitTemperature"));
        element.clear();
        element.sendKeys("abc");
        element.submit();
        assertTrue(driver.getPageSource().contains("Got a NumberFormatException on abc"));
        System.out.println("Got a NumberFormatException on abc");

        System.out.println("Put in 123.456");
        driver.navigate().back();
        element=driver.findElement(By.name("farenheitTemperature"));
        element.clear();
        element.sendKeys("123.456");
        element.submit();
        assertTrue(driver.getPageSource().contains("123.456 Farenheit = 50.81 Celsius"));
        System.out.println("123.456 Farenheit = 50.81 Celsius");

        System.out.println("Put in 300");
        driver.navigate().back();
        element=driver.findElement(By.name("farenheitTemperature"));
        element.clear();
        element.sendKeys("300");
        element.submit();
        assertTrue(driver.getPageSource().contains("300 Farenheit = 148.89 Celsius"));
        System.out.println("300 Farenheit = 148.89 Celsius");

        System.out.println("Put in -456");
        driver.navigate().back();
        element=driver.findElement(By.name("farenheitTemperature"));
        element.clear();
        element.sendKeys("-456");
        element.submit();
        assertTrue(driver.getPageSource().contains("-456 Farenheit = -271.11 Celsius"));
        System.out.println("-456 Farenheit = -271.11 Celsius");


        driver.quit();
    }

    public static int main(String[] argc) {
        selenium_test task = new selenium_test();
//        task.test_normal();
//        task.test_login();
        task.test_input(false);
        return 0;
    }
}

