import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageObject.BasePageElements;
import pageObject.PageOrderRentElements;
import pageObject.UserInfo;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class CreateParametrizedTest extends MainTest {
    private final String userName;
    private final String useSurname;
    private final String userAddress;
    private final String userPhoneNumber;
    private final String orderDate;
    private final String comment;

    public CreateParametrizedTest(String userName, String useSurname, String userAdress, String userPhoneNamber , String orderDate, String comment){
        this.userName = userName;
        this.useSurname = useSurname;
        this.userAddress = userAdress;
        this.userPhoneNumber = userPhoneNamber;
        this.orderDate =orderDate;
        this.comment = comment;
    }

    //testDate
    @Parameterized.Parameters
    public static Object [][] getCredentails(){
        return new Object[][]{
                {"Georgii","Kiselev","Gastello 42","89270000000","22.03.2023","be faster"},
                {"Ygroeg","Velesik","Gastello 45","89270000001","22.03.2023","be slower"},
        };
    }

    @Test
    public void CreateNewUserOrderFromHeaderButtonTest(){
        BasePageElements objElements = new BasePageElements(driver);
        UserInfo objUserInfo = new UserInfo(driver);
        PageOrderRentElements objInfoOrder = new PageOrderRentElements(driver);

        objElements.scrollAndPushHeaderOrderButton();
        objElements.pushHeaderOrderButton();
        objUserInfo.createOrder(userName,useSurname,userAddress,userPhoneNumber);
        objInfoOrder.pushAcceptOrder(orderDate,comment);
        assertTrue(objInfoOrder.checkModalWindow());
    }
    @Test
    public void CreateNewUserOrderWithDownButtonTest(){
        BasePageElements objElements = new BasePageElements(driver);
        UserInfo objUserInfo = new UserInfo(driver);
        PageOrderRentElements objInfoOrder = new PageOrderRentElements(driver);

        objElements.scrollAndPushDownOrderButton();
        objElements.pushDownOrderButton();
        objUserInfo.createOrder(userName,useSurname,userAddress,userPhoneNumber);
        objInfoOrder.pushAcceptOrder(orderDate,comment);
        assertTrue(objInfoOrder.checkModalWindow());
    }
}
