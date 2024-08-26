import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;


public class ProductPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;


    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.js = (JavascriptExecutor) driver;
    }


    private By firstProductLink = By.className("prd-link");
    private By addToCartButton = By.className("AddToCart-AddToCartAction");

    public void clickOnFirstProduct() throws InterruptedException {
        WebElement link = driver.findElement(firstProductLink);
        String hrefValue = link.getAttribute("href");

        if (hrefValue.contains("watch")) {
            js.executeScript("alert('Kelime bulundu!');");
           // Thread.sleep(2000);
            driver.switchTo().alert().accept();
            link.click();
        } else {
            js.executeScript("alert('Kelime bulunamadı :(!');");
            driver.switchTo().alert().accept();
        }
    }

    public boolean isAddToCartButtonVisible() {
        try {
            WebElement button = driver.findElement(addToCartButton);
            return button.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void showAlertMessage(String message) {
        js.executeScript("alert('" + message + "');");
        driver.switchTo().alert().accept();
    }
}