import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import pageObject.BasePageElements;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ListOfQuestionTest extends MainTest{
    private final String question;
    private final String answer;
    private final String answerText;

    public ListOfQuestionTest(String question, String answer, String answerText){
        this.question = question;
        this.answer = answer;
        this.answerText = answerText;
    }

    @Parameterized.Parameters
    public static Object[][] expectedAnswerParamList (){
        return new Object[][]{
                {BasePageElements.buttonsQuestionArray[0], BasePageElements.textQuestionsAboutImportantArray[0], "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {BasePageElements.buttonsQuestionArray[1], BasePageElements.textQuestionsAboutImportantArray[1], "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {BasePageElements.buttonsQuestionArray[2], BasePageElements.textQuestionsAboutImportantArray[2], "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {BasePageElements.buttonsQuestionArray[3], BasePageElements.textQuestionsAboutImportantArray[3], "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {BasePageElements.buttonsQuestionArray[4], BasePageElements.textQuestionsAboutImportantArray[4], "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {BasePageElements.buttonsQuestionArray[5], BasePageElements.textQuestionsAboutImportantArray[5], "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {BasePageElements.buttonsQuestionArray[6], BasePageElements.textQuestionsAboutImportantArray[6], "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {BasePageElements.buttonsQuestionArray[7], BasePageElements.textQuestionsAboutImportantArray[7], "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }
    @Test
    public void EqualsTextQuestionAboutImportantTest(){
        BasePageElements element = new BasePageElements(driver);
        element.scrollPageToQuestionsAboutImportant();
        element.clickQuestionButton(question);
        String ActualAnswer = driver.findElement(By.id(answer)).getText();
        assertEquals("Тексты не совпали", answerText, ActualAnswer);
    }

}
