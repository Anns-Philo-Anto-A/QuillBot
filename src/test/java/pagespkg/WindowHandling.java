package pagespkg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class WindowHandling {
	WebDriver driver;
	By qfield=By.xpath("//*[@id=\"root-client\"]/div[2]/div[2]/div/div[2]/div");
	By qhelp=By.xpath("//*[@id=\"root-client\"]/div[2]/div[2]/div/div[2]/div/div[1]/ul[4]/div[1]/a");
	By qcontact=By.xpath("//*[@id=\"user-nav\"]/a");
	By qselect=By.xpath("//*[@id=\"new_request\"]/div/a");
	By qrequest=By.xpath("/html[1]/body[1]/div[2]");
	public WindowHandling(WebDriver driver) {
		this.driver=driver;
	}
	public void field() {
		driver.findElement(qfield);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)", "");
		driver.findElement(qhelp).click();
	}
	public void help() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
		driver.findElement(qcontact).click();
	}
	
}
