import org.junit.jupiter.api.Test;
import org.apache.log4j.Logger;

public class LoginTests extends BaseTest {

    private static final Logger logger = Logger.getLogger(LoginTests.class);

    @Test
    void teknosagiristesti() throws InterruptedException {
        logger.info("Test başlıyor: teknosagiristesti");

        SearchPage searchPage = new SearchPage(driver);
        ProductPage productPage = new ProductPage(driver);

        logger.info("Arama kutusuna 'saat' kelimesi yazılıyor.");
        searchPage.searchForProduct("saat");
        Thread.sleep(1000);
        logger.info("Arama sonuçları bekleniyor.");
        searchPage.waitForSearchResults();

        logger.info("İlk ürüne tıklanıyor.");
        productPage.clickOnFirstProduct();

        if (productPage.isAddToCartButtonVisible()) {
            logger.info("Sepete ekle butonu bulundu.");
            productPage.showAlertMessage("Sepete ekle Butonu bulundu!");
            Thread.sleep(2000);
        } else {
            logger.warn("Sepete ekle butonu bulunamadı.");
            productPage.showAlertMessage("Sepete ekle Butonu bulunamadı!");
        }

        logger.info("Test tamamlandı: teknosagiristesti");
    }
}