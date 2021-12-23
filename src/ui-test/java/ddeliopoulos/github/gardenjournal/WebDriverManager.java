package ddeliopoulos.github.gardenjournal;

import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;
import org.junit.platform.launcher.TestPlan;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Optional;

import static ddeliopoulos.github.gardenjournal.RandomUserGenerator.randomUsername;

public class WebDriverManager implements TestExecutionListener {

    private static WebDriver DRIVER = null;

    public static WebDriver getDriver() {
        if (DRIVER == null) {
            DRIVER = new ChromeDriver();
            DRIVER.manage().window().setSize(new Dimension(1920, 1080));
        }
        return DRIVER;
    }

    public static Optional<String> getCurrentUserEmail() {
        return Optional.of("return window.localStorage.getItem('test-selenium-token');")
                .map(WebDriverManager::runJavascript)
                .map(String.class::cast)
                .map(token -> token.substring(11));
    }

    public static void loginWithTestToken() {
        final String randomUserEmail = randomUsername() + "@test.com";
        runJavascript("window.localStorage.setItem('test-selenium-token', 'test-token-" + randomUserEmail + "');");
    }

    public static void removeTestToken() {
        runJavascript("window.localStorage.removeItem('test-selenium-token');");
    }

    public static Object runJavascript(final String script) {
        final WebDriver driver = getDriver();
        if (driver instanceof JavascriptExecutor) {
            return ((JavascriptExecutor) driver).executeScript(script);
        } else {
            throw new IllegalStateException(driver.getClass() + " must be a JS executor");
        }
    }

    @Override
    public void executionFinished(TestIdentifier testIdentifier, TestExecutionResult testExecutionResult) {
        removeTestToken();
    }

    @Override
    public void testPlanExecutionFinished(final TestPlan testPlan) {
        if (DRIVER != null) {
            DRIVER.close();
        }
    }

}
