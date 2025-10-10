package com.hackerearth.fullstack.backend.sample;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.test.context.SpringBootTest;

import com.hackerearth.fullstack.backend.AutomationScripts;
import com.hackerearth.fullstack.backend.JettyServer;
import com.hackerearth.fullstack.backend.Result;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.*;
import io.github.bonigarcia.wdm.WebDriverManager;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class sampleTest {

    static private WebDriver driver = null;
    private static JettyServer server = null;
    private static String pagUrl = null;
    private static Result result = null;

    @BeforeAll
    static void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage", "--disable-notifications", "--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        Dimension d = new Dimension(1180, 720);
        driver.manage().window().setSize(d);

        server = new JettyServer();
        server.start();

        pagUrl = "http://localhost:8080/index.html";
    }

    @AfterAll
    static void tearDown() {
        if (driver != null) driver.close();
        if (server != null) server.stop();
    }

    @Test
    @Order(1)
    void testgetTitle() throws InterruptedException {
        String title = AutomationScripts.getTitle(driver, pagUrl);
        assertThat(title).isEqualTo("User Data");
    }
}
