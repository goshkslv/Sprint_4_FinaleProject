package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserInfo {
    private final WebDriver driver;
    // locator for input name
    private final By userName = By.xpath(".//input[@placeholder='* Имя']");
    // locator for input surname
    public final By userSurname = By.xpath(".//input[(@placeholder='* Фамилия')]");
    // locator for input address of delivery
    private final By orderUserAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    // locator for input Underground station
    private final By orderMetroStation = By.xpath(".//*[(@class='select-search__input' and @placeholder='* Станция метро')]");
    // locator for choose Underground station
    private final By selectMetroStation = By.xpath(".//*[@class='Order_SelectOption__82bhS select-search__option' and @value='2']");
    // locator for input phone number
    private final By orderUserPhoneNumber = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    // Locator for the button "Next"
    private final By orderNextButton = By.xpath(".//button[(@class ='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее')]");


    public UserInfo (WebDriver driver){
        this.driver = driver;
    }

    //method for input name
    public void inputUserName(String user1Name){
        driver.findElement(userName).sendKeys(user1Name);
    }
    //method for input surname
    public void inputUserSurname(String surname){
        driver.findElement(userSurname).sendKeys(surname);
    }
    //method for input Address
    public void inputOrderUserAddress(String userAddress){
        driver.findElement(orderUserAddress).sendKeys(userAddress);
    }
    //method for input Underground station
    public void inputUndergroundStation(){
        driver.findElement(orderMetroStation).click();
        driver.findElement(selectMetroStation).click();
    }
    //method for input phone number
    public void inputUserPhoneNumber(String userNumber){
        driver.findElement(orderUserPhoneNumber).sendKeys(userNumber);
    }
    //method for push the button "Next"
    public void pushNextButton(){
        driver.findElement(orderNextButton).click();
    }

    //method for the creation order
    public void createOrder(String user1Name, String surname, String userAddress, String phoneNumber){
    inputUserName(user1Name);
    inputUserSurname(surname);
    inputOrderUserAddress(userAddress);
    inputUndergroundStation();
    inputUserPhoneNumber(phoneNumber);
    pushNextButton();
    }

}
