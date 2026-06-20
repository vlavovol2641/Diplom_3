import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pages.MainPage;



public class ConstructorTest extends BaseTest {

    @Test
    @DisplayName("Переход к разделу «Булки» в конструкторе")
    public void switchToBunsTabTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickSaucesTab();
        mainPage.clickBunsTab();
        Assert.assertTrue(mainPage.isTabActive("Булки"));
    }

    @Test
    @DisplayName("Переход к разделу «Соусы» в конструкторе")
    public void switchToSaucesTabTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickSaucesTab();
        Assert.assertTrue(mainPage.isTabActive("Соусы"));
    }

    @Test
    @DisplayName("Переход к разделу «Начинки» в конструкторе")
    public void switchToFillingsTabTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickFillingsTab();
        Assert.assertTrue(mainPage.isTabActive("Начинки"));
    }
}
