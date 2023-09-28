package pagespkg;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUpload {
	WebDriver driver;
	By qparaphraser=By.xpath("//*[@id=\"root-client\"]/div[2]/div[2]/div/div[2]/div/div[1]/ul[1]/div[1]/a");
	By qupload=By.xpath("//*[@id=\"pphr-view-input-panel-footer-box\"]/div[1]/div/div/div/div/span");
	By qparaphrase=By.xpath("//*[@id=\"pphr-view-input-panel-footer-box\"]/div[2]/div/button");
	public FileUpload(WebDriver driver) {
		this.driver=driver;
	}
	public void file() {
		driver.findElement(qparaphraser).click();
		driver.findElement(qupload).click();
	}
	public void fileUpload(String f) throws AWTException {
		StringSelection strSelection=new StringSelection(f);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSelection, null);
		//to paste into system window
		Robot robot=new Robot();
		robot.delay(3000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	public void paraphrase() {
		driver.findElement(qparaphrase).click();
	}
}
