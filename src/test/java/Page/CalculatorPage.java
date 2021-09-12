package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DecimalFormat;

public class CalculatorPage extends BasePage {
    public WebElement canvas;
    public Button btnMC, btnMR, btnMPlus, btnMminus, btnC,
            btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btndot, btnchangestate,
            btndivide, btnmultiply, btnminus, btnplus,
            btnsquareroot, btnpercent, btnreverse, btnequal;
    WebDriver webDriver;

    public CalculatorPage(WebDriver driver) {
        webDriver = driver;
        canvas = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("canvas")));
        int distance = canvas.getSize().getHeight() / 54;
        btnMC = new Button(-distance * 14, -distance * 11);
        btnMR = new Button(-distance * 7, -distance * 11);
        btnMPlus = new Button(0, -distance * 11);
        btnMminus = new Button(distance * 7, -distance * 11);
        btnC = new Button(distance * 14, -distance * 11);
        btn1 = new Button(-distance * 14, distance * 11);
        btn2 = new Button(-distance * 7, distance * 11);
        btn3 = new Button(0, distance * 11);
        btn4 = new Button(-distance * 14, distance * 4);
        btn5 = new Button(-distance * 7, distance * 4);
        btn6 = new Button(0, distance * 4);
        btn7 = new Button(-distance * 14, -distance * 4);
        btn8 = new Button(-distance * 7, -distance * 4);
        btn9 = new Button(0, -distance * 4);
        btn0 = new Button(-distance * 14, distance * 18);
        btndot = new Button(-distance * 7, distance * 18);
        btnchangestate = new Button(0, distance * 18);
        btndivide = new Button(distance * 7, -distance * 4);
        btnmultiply = new Button(distance * 7, distance * 4);
        btnminus = new Button(distance * 7, distance * 11);
        btnplus = new Button(distance * 7, distance * 18);
        btnsquareroot = new Button(distance * 14, -distance * 4);
        btnpercent = new Button(distance * 14, distance * 4);
        btnreverse = new Button(distance * 14, distance * 11);
        btnequal = new Button(distance * 14, distance * 18);
    }

    public void clickOnNumber(float number) {
        DecimalFormat format = new DecimalFormat("#.########");
        String[] str = format.format(number).split("");
        if (str.length > 9)
            throw (new IndexOutOfBoundsException("Calculator support maximum 9 digits"));
        if (number < 0)
            clickOnCanvas(webDriver, canvas, btnchangestate);
        for (int i = 0; i < str.length; i++) {
            switch (str[i]) {
                case "1":
                    clickOnCanvas(webDriver, canvas, btn1);
                    break;
                case "2":
                    clickOnCanvas(webDriver, canvas, btn2);
                    break;
                case "3":
                    clickOnCanvas(webDriver, canvas, btn3);
                    break;
                case "4":
                    clickOnCanvas(webDriver, canvas, btn4);
                    break;
                case "5":
                    clickOnCanvas(webDriver, canvas, btn5);
                    break;
                case "6":
                    clickOnCanvas(webDriver, canvas, btn6);
                    break;
                case "7":
                    clickOnCanvas(webDriver, canvas, btn7);
                    break;
                case "8":
                    clickOnCanvas(webDriver, canvas, btn8);
                    break;
                case "9":
                    clickOnCanvas(webDriver, canvas, btn9);
                    break;
                case "0":
                    clickOnCanvas(webDriver, canvas, btn0);
                    break;
                case ".":
                    clickOnCanvas(webDriver, canvas, btndot);
                    break;
                default:
                    System.out.println("No number to click");
            }
        }
    }

    public void clickOnFunction(String function) {
        switch (function) {
            case "+":
                clickOnCanvas(webDriver, canvas, btnplus);
                break;
            case "-":
                clickOnCanvas(webDriver, canvas, btnminus);
                break;
            case "*":
                clickOnCanvas(webDriver, canvas, btnmultiply);
                break;
            case "/":
                clickOnCanvas(webDriver, canvas, btndivide);
                break;
            case "=":
                clickOnCanvas(webDriver, canvas, btnequal);
                break;
            case "button clear":
                clickOnCanvas(webDriver, canvas, btnC);
                break;
            default:
                System.out.println("Non-functional");
        }
    }
}