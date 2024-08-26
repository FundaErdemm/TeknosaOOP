import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchPage {
    private WebDriver driver;
    private WebDriverWait wait;


    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By searchInput = By.id("search-input");
    private By searchButton = By.className("sbx-search");

     public void searchForProduct(String productName) {
        driver.findElement(searchInput).sendKeys(productName);
        Actions actions = new Actions(driver);
        WebElement searchBtn = driver.findElement(searchButton);
        actions.doubleClick(searchBtn).perform();
    }

    public void waitForSearchResults() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("prd-inner")));
    }
}