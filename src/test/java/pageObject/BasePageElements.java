package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;


public class BasePageElements {
    private static WebDriver driver = new ChromeDriver();
    // button "Order" in the page haired part
    private final By headerOrderButton = By.className("Button_Buton__ra12g");
    //button "Order" in the page down part
    private final By downOrderButton = By.xpath(".//button[@class ='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать')]");
    //locators button with some question
    public static  final String [] buttonsQuestionArray = new String[]{
            "accordion__heading-0",
            "accordion__heading-1",
            "accordion__heading-2",
            "accordion__heading-3",
            "accordion__heading-4",
            "accordion__heading-5",
            "accordion__heading-6",
            "accordion__heading-7"
    };
    //Locators the text "Questions about important"
    public static final String[]  textQuestionsAboutImportantArray = new String[]{
            "accordion__panel-0",
            "accordion__panel-1",
            "accordion__panel-2",
            "accordion__panel-3",
            "accordion__panel-4",
            "accordion__panel-5",
            "accordion__panel-6",
            "accordion__panel-7"};
    //button "Status order"
    private final By orderStatusButton = By.className("Header_Link__1TAG7");
    //button logo Samokat
    private final By yandexLogo = By.className("Header_Logo__23yGT");

    public BasePageElements(WebDriver driver){
        this.driver = driver;
    }
    //method for push on the header button "Order"
    public void  pushHeaderOrderButton(){
        driver.findElement(headerOrderButton).click();
    }
    //method for scroll for the header button "Order"
    public void scrollAndPushHeaderOrderButton(){
        WebElement element = driver.findElement(headerOrderButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    //method for scroll for the down button "Order"
    public void scrollAndPushDownOrderButton(){
        WebElement element = driver.findElement(downOrderButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    //method for push on the down button "Order"
    public void  pushDownOrderButton(){
        driver.findElement(downOrderButton).click();
    }
    //method for scroll before list "Questions about important"
    public void scrollPageToQuestionsAboutImportant(){
        WebElement lastQuestionPointer = driver.findElement(By.id(buttonsQuestionArray[7]));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", lastQuestionPointer);
    }
    //click for the pointer of list
    public static void clickQuestionPointer(int questionNamber){
        new WebDriverWait(driver,5)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(textQuestionsAboutImportantArray[questionNamber])));
        driver.findElement(By.id(buttonsQuestionArray[questionNamber])).click();
    }
    //check text the button of list "Questions about important"
    public static void checkTextInOpenPanel(int answerNumber, String expectedText){
        new WebDriverWait(driver,5)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(textQuestionsAboutImportantArray[answerNumber])));
        String answerText = driver.findElement(By.id(textQuestionsAboutImportantArray[answerNumber])).getText();
        assertEquals(expectedText, answerText);
    }
    //click the button question
    public void clickQuestionButton(String questionButtonLocator){
        new WebDriverWait(driver,5)
                .until(ExpectedConditions.elementToBeClickable(By.id(questionButtonLocator)));
    driver.findElement(By.id(questionButtonLocator)).click();
    }
}