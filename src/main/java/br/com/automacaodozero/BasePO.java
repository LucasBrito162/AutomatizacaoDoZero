package br.com.automacaodozero;

import org.openqa.selenium.WebDriver;

import com.github.javafaker.Faker;

public class BasePO {
   protected WebDriver driver;

public BasePO(WebDriver driver) {
    this.driver = driver;
}



    Faker faker = new Faker();
    String name = faker.name().firstName();
    String fullName = faker.name().fullName();
    




   

   

   
}
