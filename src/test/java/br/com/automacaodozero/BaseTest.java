package br.com.automacaodozero;


import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
    protected WebDriver driver;

    @Before
    public void start(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://bugbank.netlify.app/");

    }

   @After
    public void quit(){
        driver.quit();
    }

    public void waiting() {
        try {
            // Pausa a execução por 5 segundos
            Thread.sleep(300);
        } catch (InterruptedException e) {
            // Tratamento da exceção
            e.printStackTrace();
        }
    }

}
