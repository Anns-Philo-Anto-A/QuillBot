package pagespkg;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class DataDriven {
	WebDriver driver;
	By qlogin=By.xpath("//*[@id=\"root-client\"]/div[2]/div[2]/div/header/div/div[3]/div/a");
	By qemail=By.xpath("//*[contains(@name,'username')]");
	By qpassword=By.xpath("//*[@name='password']");
	By qclicklogin=By.xpath("//*[@id=\"loginContainer\"]/div[2]/div[2]/div[5]/button");
	public DataDriven(WebDriver driver) {
		this.driver=driver;
	}
	public void loginclick() {
		driver.findElement(qlogin).click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,250)", "");
	}
	public void details(String email,String password) {
		driver.findElement(qemail).clear();
		driver.findElement(qemail).sendKeys(email);
		driver.findElement(qpassword).clear();
		driver.findElement(qpassword).sendKeys(password);
	}
	public void clicklogin() {
		driver.findElement(qclicklogin).click();
	}
}
