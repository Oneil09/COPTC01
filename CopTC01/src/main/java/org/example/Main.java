package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;




public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;


        //Navigate to the website
        String url = "https://automationexercise.com/";
        driver.get(url);
        String title = driver.getTitle();
        System.out.println(title);

        //Home page
        String homeBtn = driver.findElement(By.linkText("Home")).getText();
        System.out.println(homeBtn + " page is visible");

        //Sign up
        driver.findElement(By.linkText("Signup / Login")).click();
        String signupText = driver.findElement(By.xpath("//h2[normalize-space()='New User Signup!']")).getText();
        System.out.println(signupText + " text is visible");

        //creating elements for signup fields
        WebElement nameField = driver.findElement(By.name("name"));
        WebElement emailField = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        WebElement signupBtn = driver.findElement(By.xpath("//button[normalize-space()='Signup']"));

        //actions
        nameField.sendKeys("Oneil Malik");
        emailField.sendKeys("oneilmalik09@gmail.com");
        signupBtn.click();

        //Check if Enter account information is visible
        String enterInfoText = driver.findElement(By.xpath(" //b[normalize-space()='Enter Account Information']")).getText();
        System.out.println(enterInfoText + " is visible");

        //fill in the form
        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.id("password")).sendKeys("test");
        Select day = new Select(driver.findElement(By.xpath("//select[@id='days']")));
        day.selectByValue("6");
        new Select(driver.findElement(By.id("months"))).selectByValue("9");
        new Select(driver.findElement(By.id("years"))).selectByValue("2000");
        driver.findElement(By.id("newsletter")).click();
        driver.findElement(By.id("optin")).click();
        Select country = new Select(driver.findElement(By.id("country")));
        country.selectByValue("Canada");
        driver.findElement(By.id("first_name")).sendKeys("test");
        driver.findElement(By.id("last_name")).sendKeys("test");
        driver.findElement(By.id("company")).sendKeys("test");
        driver.findElement(By.id("address1")).sendKeys("test");
        driver.findElement(By.id("address2")).sendKeys("test");
        driver.findElement(By.id("state")).sendKeys("test");
        driver.findElement(By.id("city")).sendKeys("test");
        driver.findElement(By.id("zipcode")).sendKeys("test");
        driver.findElement(By.id("mobile_number")).sendKeys("test");
        driver.findElement(By.xpath("//button[normalize-space()='Create Account']")).click();

        //Account is created
        String accountCreatedText = driver.findElement(By.xpath("//b[normalize-space()='Account Created!']")).getText();
        System.out.println(accountCreatedText + " is visible");

        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();

        //ad handling

        // 1st method
//        try {
//            WebElement dismissBtn = driver.findElement(By.xpath(" //*[@id='dismiss-button']"));
//
//            if (dismissBtn.isDisplayed()) {
//                System.out.println("dismiss button is displayed");
//                dismissBtn.click();
//            } else {
//                System.out.println("no ad was displayed");
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        };

        try {
            // Handle ad dismissal using JavaScript
            WebElement dismissButton = driver.findElement(By.xpath(" //*[@id='dismiss-button']"));
            if (dismissButton.isDisplayed()) {
                js.executeScript("arguments[0].click();", dismissButton);
                System.out.println("Dismiss button is clicked.");
            } else {
                System.out.println("No ad was displayed.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        // 2nd method
//        Duration timeout = Duration.ofSeconds(5);
//        WebDriverWait wait = new WebDriverWait(driver, timeout); // Adjust the timeout as needed
//        WebElement dismissBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='dismiss-button']")));
//
//        if (dismissBtn.isDisplayed()) {
//            System.out.println("Dismiss button is displayed");
//            dismissBtn.click();
//        } else {
//            System.out.println("No ad was displayed");
//        }


        //check username
        String username = driver.findElement(By.xpath("//li[10]//a[1]")).getText();
        System.out.println("user is " + username);

        //Delete account
        driver.findElement(By.xpath("//a[normalize-space()='Delete Account']")).click();

        //ad handle

//        try {
//            WebElement dismissBtn = driver.findElement(By.xpath("//*[name()='path' and contains(@d,'M38 12.83L')]"));
//
//            if (dismissBtn.isDisplayed()) {
//                System.out.println("dismiss button is displayed");
//                dismissBtn.click();
//            } else {
//                System.out.println("no ad was displayed");
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        };

        String deleteText =  driver.findElement(By.xpath("//b[normalize-space()='Account Deleted!']")).getText();
        System.out.println(deleteText + " is visible");

    }
}
