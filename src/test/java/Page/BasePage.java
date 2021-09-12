package Page;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BasePage {

    public void clickOnCanvas(WebDriver driver, WebElement webElement, Button button) {
        new Actions(driver).moveToElement(webElement, 0, 0).moveByOffset(button.offsetx, button.offsety).click().build().perform();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void verifyResult(WebDriver driver, WebElement webElement, String result) throws IOException, TesseractException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String base64 = js.executeScript("return arguments[0].toDataURL('image/png').substring(21);", webElement).toString();
        byte[] data = DatatypeConverter.parseBase64Binary(base64);
        File destFile = new File("src/test/resources/temp.png");
        FileUtils.writeByteArrayToFile(destFile, data);

        int height = ImageIO.read(destFile).getHeight();
        int width = ImageIO.read(destFile).getWidth();
        BufferedImage img = ImageIO.read(destFile).getSubimage((int) (0.05 * width), (int) (0.05 * height), (int) (0.9 * width), (int) (0.1 * height));
        ImageIO.write(img, "png", destFile);

        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("src/test/resources/tessdata");
        tesseract.setTessVariable("user_defined_dpi", "300");
        tesseract.setTessVariable("tessedit_char_whitelist", "0123456789\\.\\-Error");
        Assert.assertEquals(tesseract.doOCR(destFile).replaceAll("\n", ""), result);
    }


}
