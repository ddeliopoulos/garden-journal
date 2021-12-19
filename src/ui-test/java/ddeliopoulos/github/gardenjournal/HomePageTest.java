package ddeliopoulos.github.gardenjournal;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static ddeliopoulos.github.gardenjournal.WebDriverManager.getCurrentUserEmail;
import static ddeliopoulos.github.gardenjournal.WebDriverManager.loginWithTestToken;
import static org.junit.jupiter.api.Assertions.*;


class HomePageTest {

    private static final String BASE_URL = "http://localhost:8081";
    private static By USER_NAME_FIELD = By.cssSelector("#app > div.header > div > div.account-info > h3");
    private static By ADD_PLANT_BUTTON = By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div/div/div/div[2]/div/button");
    private static By WATERING_BUTTON = By.cssSelector("#water-btn > div > div");
    private static By SUBMIT_PLANT_BUTTON = By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div/div/div/div[2]/div/div[2]/div[2]/button");
    private static By CLICKABLE_PLANT_CARD = By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div/div/div/div[3]/div/div");
    private static By ADD_JOURNAL_BUTTON = By.xpath("/html/body/div[1]/div[1]/section/div/div/div/div[2]/p/button");
    private static By SUBMIT_JOURNAL_BUTTON = By.cssSelector("#modals > div > div > div > button.add-journal-entry-close");

    @Test
    void whenNavigatingToHomePage_shouldRedirectToLoginPage() {
        // create a driver
        final WebDriver driver = WebDriverManager.getDriver();

//        driver.manage().deleteAllCookies();
//        driver.get("chrome://settings/clearBrowserData");
//        driver.findElement(By.xpath("//settings-ui")).sendKeys(Keys.ENTER);

        // go to main page
        driver.navigate().to(BASE_URL);

        // wait until we are redirected
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.urlContains("/login"));


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
    void whenClickingAddPlantButton_thenSubmitButtonAndPlantImageIsVisible() {
        // create a driver
        final WebDriver driver = WebDriverManager.getDriver();

        // go to main page
        driver.navigate().to(BASE_URL);
        loginWithTestToken();
        driver.navigate().to(BASE_URL);

        // wait to navigate to home
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        // clicks button to add plant
        driver.findElement(ADD_PLANT_BUTTON).click();

        // waits for form to pop up
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        // checks if submit button is displayed
        assertTrue(driver.findElement(SUBMIT_PLANT_BUTTON).isDisplayed());

        //check is plant image is visible
        assertTrue(driver.findElement(By.cssSelector("#add-plant-btn > div.modal > div.container > div > img")).isDisplayed());
    }

    @Test
    void whenAddingAPlant_wateringButtonShouldBeAvailable() {
        // create a driver
        final WebDriver driver = WebDriverManager.getDriver();

        // go to main page
        driver.navigate().to(BASE_URL);
        loginWithTestToken();
        driver.navigate().to(BASE_URL);

        // wait to navigate to home
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        // checks if plant button is visible
        assertTrue(driver.findElement(ADD_PLANT_BUTTON).isDisplayed());

//        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOf(
//                driver.findElement(By.cssSelector("#add-plant-btn > div.modal > div.container > label:nth-child(2)"))
//        ));

        // clicks button to add plant
        driver.findElement(ADD_PLANT_BUTTON).click();

        // checks if add plant form popped up
        assertEquals("Plant name:", driver.findElement(By.cssSelector("#add-plant-btn > div.modal > div.container > label:nth-child(2)")).getText());

        // add inputs for a plant
        addPlantInput();

        // checks if watering button is visible
        assertTrue(driver.findElement(WATERING_BUTTON).isDisplayed());
    }

    @Test
    void whenAddingAPlant_allInputsMatchTheCreatedPlantData() {
        final WebDriver driver = WebDriverManager.getDriver();

        // go to main page
        driver.navigate().to(BASE_URL);
        loginWithTestToken();
        driver.navigate().to(BASE_URL);

        // wait to navigate to home
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.findElement(ADD_PLANT_BUTTON).click();

        // wait to navigate to home
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        addPlantInput();

        // wait to navigate to home
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        assertTrue(driver.findElement(CLICKABLE_PLANT_CARD).isDisplayed());

        assertEquals("Christini Plant", driver.findElement(By.cssSelector("#home > div > div > div > div > div > div.single-plant-container > div > div > a > h2")).getText());
//        assertEquals("CutiePatootie  08/31/1990", driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div/div/div/div[3]/div/div/a/div[2]/p")).getText());
//        assertEquals("08/31/1990", driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div/div/div/div[3]/div/div/a/div[2]/p/b/text()[2]")).getText());

    }

    @Test
    void whenAddingAJournalEntryAndRemovingIt_shouldNotBePresent() {
        final WebDriver driver = WebDriverManager.getDriver();

        // go to main page
        driver.navigate().to(BASE_URL);
        loginWithTestToken();
        driver.navigate().to(BASE_URL);

        driver.findElement(ADD_PLANT_BUTTON).click();

        // wait to navigate to home
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        // add inputs for a plant
        addPlantInput();

        // wait for plant to be submitted
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        // check to see plant card was created and visible
        assertTrue(driver.findElement(CLICKABLE_PLANT_CARD).isDisplayed());

        //click on created plant
        driver.findElement(CLICKABLE_PLANT_CARD).click();

        // wait to navigate to plant details page
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        // checks that we are on the correct page via url string
        assertTrue(driver.getCurrentUrl().contains("/plant-details"));

        // checks if the add journal button is available
        assertTrue(driver.findElement(ADD_JOURNAL_BUTTON).isDisplayed());

        // clicks on add journal button
        driver.findElement(ADD_JOURNAL_BUTTON).click();

        // wait for journal options to pop up
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        // checks to see that the add text journal entry button is available
        assertTrue(driver.findElement(By.cssSelector("#modals > div > div > div > button.journal-icon-txt > img")).isDisplayed());

        // click on add text journal entry
        driver.findElement(By.cssSelector("#modals > div > div > div > button.journal-icon-txt > img")).click();

        // adds input for a text journal entry
        WebElement textJournalEntry = driver.findElement(By.cssSelector("#styled"));
        textJournalEntry.sendKeys("I IS MAGICAL ROBOT HERE TO WRITE A JOURNAL ENTRY");

        // checks that submit journal button is available
        assertTrue(driver.findElement(SUBMIT_JOURNAL_BUTTON).isDisplayed());

        // clicks on submit journal
        driver.findElement(SUBMIT_JOURNAL_BUTTON).click();

        // waits for the creating of new journal entry
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        // checks if the journal entry has been added and displayed
        assertTrue(driver.findElement(By.xpath("/html/body/div[1]/div[1]/section/div/div/div/div[3]/div/div/div")).isDisplayed());
        assertEquals("I IS MAGICAL ROBOT HERE TO WRITE A JOURNAL ENTRY", driver.findElement(By.xpath("/html/body/div[1]/div[1]/section/div/div/div/div[3]/div/div/div/div[2]/div/div[2]")).getText());

        // checks to see if delete icon for removing plant is available and clicks it for removal
        assertTrue(driver.findElement(By.xpath("/html/body/div[1]/div[1]/section/div/div/div/div[3]/div/div/div/div[2]/div/div[1]/i")).isDisplayed());
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/section/div/div/div/div[3]/div/div/div/div[2]/div/div[1]/i")).click();

        // waits for the plant created to be removed
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        // checks weather the journal entry has been removed
        boolean textJournalIsPresent = driver.findElements(By.xpath("/html/body/div[1]/div[1]/section/div/div/div/div[3]/div/div/div")).size() > 0;
        assertFalse(textJournalIsPresent);

    }

    // adds plant input
    private void addPlantInput() {
        final WebDriver driver = WebDriverManager.getDriver();

        // finds element inputs for adding plant
        WebElement plantNameInput = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div/div/div/div[2]/div/div[2]/div[2]/input[1]"));
        WebElement plantTypeInput = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div/div/div/div[2]/div/div[2]/div[2]/input[2]"));
        WebElement plantDatePlantedInput = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div/div/div/div[2]/div/div[2]/div[2]/input[3]"));
        WebElement plantWateringSchedule = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div/div/div/div[2]/div/div[2]/div[2]/input[4]"));

        // add inputs for plant
        plantNameInput.sendKeys("Christini Plant");
        plantTypeInput.sendKeys("CutiePatootie");
        plantDatePlantedInput.sendKeys("08/31/1990");
        plantWateringSchedule.sendKeys("2");

        // clicks submit to add the plant
        driver.findElement(SUBMIT_PLANT_BUTTON).click();
    }
}
