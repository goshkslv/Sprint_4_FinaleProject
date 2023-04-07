package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class PageOrderRentElements {
    private final WebDriver driver;
    //input delivery date
    private final By deliveryDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //push on field quantity day
    private final By quantityDay = By.className("Dropdown-control");
    //choose quantity day
    private final By chooseHowManyDays = By.xpath(".//*[(@role ='option' and text()='двое суток')]");
    //choose color of the Samokat
    private final By chooseColour = By.xpath(".//input[@id='black']");
    //locator for field of comment
    private final By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //locator for the button "Yes"
    private final By acceptOrderButton = By.xpath(".//*[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");
    //locator for the button "Order"
    private final By approveOrderForButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //locator for the button "View status"
    private final By modalWindow = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Посмотреть статус']");

    public PageOrderRentElements(WebDriver driver){
        this.driver = driver;
    }

    //method for input date of delivery
    public void inputOrderDate(String orderDate){
        driver.findElement(deliveryDate).sendKeys(orderDate);
        driver.findElement(deliveryDate).sendKeys(Keys.ENTER);
    }
    //method for input quantity days
    public void inputQuantityDays(){
        driver.findElement(quantityDay).click();
        driver.findElement(chooseHowManyDays).click();
    }
    //method for choose of color
    public void chooseColour(){
        driver.findElement(chooseColour).click();
    }
    //method for input comment
    public void inputCommentInField(String comment){
        driver.findElement(commentField).sendKeys(comment);
    }
    //method for accept order
    public void pushAcceptOrder(String orderDate, String comment){
        driver.findElement(acceptOrderButton).click();
    }
    //method for approve order
    public void pushApproveOrder(){
        driver.findElement(approveOrderForButton).click();
    }
    //method for check appear Modal window
    public boolean checkModalWindow(){
        return driver.findElement(modalWindow).isEnabled();
    }
    //method for create Order
    public void createOrder(String orderDate, String comment){
        inputOrderDate(orderDate);
        inputQuantityDays();
        chooseColour();
        inputCommentInField(comment);
        pushAcceptOrder(orderDate, comment);
        pushApproveOrder();


    }

}

