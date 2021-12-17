package ddeliopoulos.github.gardenjournal;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static ddeliopoulos.github.gardenjournal.WebDriverManager.getCurrentUserEmail;
import static ddeliopoulos.github.gardenjournal.WebDriverManager.loginWithTestToken;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlContains;


class HomePageTest {

    private static final String BASE_URL = "http://localhost:8081";
    private static By USER_NAME_FIELD = By.cssSelector("#app > div.header > div > div.account-info > h3");
    private static By ADD_PLANT_BUTTON = By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div/div/div/div[2]/div/button");
    private static By WATERING_BUTTON = By.cssSelector("#water-btn > div > div");
    private static By SUBMIT_PLANT_BUTTON = By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div/div/div/div[2]/div/div[2]/div[2]/button");



    @Test
    void whenNavigatingToHomePage_shouldRedirectToLoginPage() {
        // create a driver
        final WebDriver driver = WebDriverManager.getDriver();

        // go to main page
        driver.navigate().to(BASE_URL);

        // wait until we are redirected
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(urlContains("/login"));

        // verify we are on the login page
        assertEquals(BASE_URL + "/login", driver.getCurrentUrl());
    }

    @Test
    void whenLoggedInWithTestToken_shouldShowTestUserName() {
        // create a driver
        final WebDriver driver = WebDriverManager.getDriver();

        // go to main page
        driver.navigate().to(BASE_URL);
        loginWithTestToken();
        driver.navigate().to(BASE_URL);

        assertEquals("User: " + getCurrentUserEmail().orElse(null), driver.findElement(USER_NAME_FIELD).getText());
    }

    @Test
    void whenAddingAPlant_wateringButtonShouldBeAvailable() {
        // create a driver
        final WebDriver driver = WebDriverManager.getDriver();

        // go to main page
        driver.navigate().to(BASE_URL);
        loginWithTestToken();
        driver.navigate().to(BASE_URL);

        // add plant button is available
        assertTrue(driver.findElement(ADD_PLANT_BUTTON).isDisplayed());

        // when clicking on add plant button, form pops up
        driver.findElement(ADD_PLANT_BUTTON).click();
//        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOf(
//                driver.findElement(By.cssSelector("#add-plant-btn > div.modal > div.container > label:nth-child(2)"))
//        ));
        assertEquals("Plant name:", driver.findElement(By.cssSelector("#add-plant-btn > div.modal > div.container > label:nth-child(2)")).getText());

        WebElement plantNameInput = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div/div/div/div[2]/div/div[2]/div[2]/input[1]"));
        WebElement plantTypeInput = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div/div/div/div[2]/div/div[2]/div[2]/input[2]"));
        WebElement plantDatePlantedInput = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div/div/div/div[2]/div/div[2]/div[2]/input[3]"));
        WebElement plantWateringSchedule = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div/div/div/div[2]/div/div[2]/div[2]/input[4]"));

        plantNameInput.sendKeys("Christini Plant");
        plantTypeInput.sendKeys("CutiePatootie");
        plantDatePlantedInput.sendKeys("08/31/1990");
        plantWateringSchedule.sendKeys("2");

        assertTrue(driver.findElement(SUBMIT_PLANT_BUTTON).isDisplayed());

        driver.findElement(SUBMIT_PLANT_BUTTON).click();

        assertTrue(driver.findElement(WATERING_BUTTON).isDisplayed());

        //assertThat(driver.findElement(WATERING_BUTTON).isDisplayed()).isTrue();
        // if we click button
        // does it change color?
        // is the journal entry created?
    }

    private void plantExists() {
        // TODO: create a plant here
    }
}
