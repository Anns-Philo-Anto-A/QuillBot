package pagespkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MouseHover {
	WebDriver driver;
	By qlanguage=By.xpath("//*[@id=\"language-menu-button\"]");
	By qBritish=By.xpath("/html/body/div[7]/div[3]/div/span[3]/div");
	By qAmerican=By.xpath("/html/body/div[7]/div[3]/div/span[1]/div");
	public MouseHover(WebDriver driver) {
		this.driver=driver;
	}
	public void click() {
		driver.findElement(qlanguage).click();
	}
	public WebElement hover() {
		 return driver.findElement(qBritish);
	}
	public WebElement hover1() {
		return driver.findElement(qAmerican);
	}
}