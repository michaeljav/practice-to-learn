package com.hackerearth.fullstack.backend;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

@Component
public class AutomationScripts {

    public AutomationScripts() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
    }

    public static String getTitle(WebDriver driver, String pagUrl) throws InterruptedException {
        driver.get(pagUrl);
        Thread.sleep(1000);
        return driver.getTitle();
    }

    public static boolean getDataButton(WebDriver driver, String pagUrl) throws InterruptedException {
        driver.get(pagUrl);
        Thread.sleep(1000);
        WebElement button = driver.findElement(By.id("getDataButton"));
        button.click();
        Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userData")));

        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 8; j++) {
                WebElement cellData = driver.findElement(By.xpath("//*[@id=\"userData\"]/tbody/tr[" + i + "]/td[" + j + "]"));
                if (cellData.getText() == null) return false;
            }
        }
        return true;
    }

    public static boolean getResponsiveTable(WebDriver driver, String pagUrl) throws InterruptedException {
        driver.get(pagUrl);
        Thread.sleep(1000);
        WebElement button = driver.findElement(By.id("getDataButton"));
        button.click();
        Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userData")));

        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 8; j++) {
                WebElement cellData = driver.findElement(By.xpath("//*[@id=\"userData\"]/tbody/tr[" + i + "]/td[" + j + "]"));
                if (cellData.getText() == null) return false;
            }
        }

        driver.manage().window().setSize(new Dimension(600, 720));
        Thread.sleep(1000);

        for (int k = 1; k <= 10; k++) {
            for (int m = 1; m <= 3; m++) {
                WebElement cellData = driver.findElement(By.xpath("//*[@id=\"userData\"]/tbody/tr[" + k + "]/td[" + m + "]"));
                if (cellData.getText().isEmpty()) return false;
            }
            for (int l = 4; l <= 8; l++) {
                WebElement cellData = driver.findElement(By.xpath("//*[@id=\"userData\"]/tbody/tr[" + k + "]/td[" + l + "]"));
                if (!cellData.getText().isEmpty()) return false;
            }
        }
        return true;
    }

    public static Result buttonDisableStatus(WebDriver driver, String pagUrl) throws InterruptedException {
        Result result = new Result();
        result.setButtonStatus(false);
        result.setCursorStyle(null);
        result.setButtonColorBeforeDisabled(null);
        result.setButtonColorAfterDisabled(null);

        try {
            driver.get(pagUrl);
            driver.manage().window().setSize(new Dimension(1180, 720));
            Thread.sleep(1000);
            WebElement button = driver.findElement(By.id("getDataButton"));

            String buttonColorBeforeDisabled = button.getCssValue("background-color");
            result.setButtonColorBeforeDisabled(buttonColorBeforeDisabled);

            button.click();
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userData")));

            WebElement button2 = driver.findElement(By.id("getDataButton"));
            String cursorStyle = button2.getCssValue("cursor");
            result.setCursorStyle(cursorStyle);

            String buttonColorAfterDisabled = button2.getCssValue("background-color");
            result.setButtonColorAfterDisabled(buttonColorAfterDisabled);

            result.setButtonStatus(button2.isEnabled());
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }

    public static String getAnchorTag(WebDriver driver, String pagUrl) throws InterruptedException {
        driver.get(pagUrl);
        Thread.sleep(1000);
        WebElement anchorTag = driver.findElement(By.id("responsive"));
        anchorTag.click();
        Thread.sleep(1000);
        return driver.getTitle();
    }
}
