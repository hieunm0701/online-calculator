package calculation.steps;

import Page.CalculatorPage;
import base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.sourceforge.tess4j.TesseractException;
import java.io.IOException;

public class CalculatorSteps extends BaseTest {
    CalculatorPage calculatorPage;
    @Before
    public void setup(){
        super.setup();
    }
    @After
    public void teardown(){}{
        super.teardown();
    }
    @Given("The calculator is ready to use")
    public void theCalculatorIsReadyToUse() throws IOException, TesseractException {
        calculatorPage = new CalculatorPage(driver);
    }

    @When("I press {}")
    public void iPressFunction(String function) {
        calculatorPage.clickOnFunction(function);
    }

    @Then("the result should be {word} on the screen")
    public void theResultShouldBeResultOnTheScreen(String result) throws IOException, TesseractException {
        calculatorPage.verifyResult(driver, calculatorPage.canvas, result);

    }

    @When("I have entered {float} into the calculator")
    public void i_have_entered_into_the_calculator(float number) {
        calculatorPage.clickOnNumber(number);
    }


}