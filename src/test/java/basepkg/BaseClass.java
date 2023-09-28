package basepkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	public WebDriver driver;
	@BeforeTest
	public void browser() {
		driver=new ChromeDriver();
	}
	@BeforeMethod
	public void urlload() {
		driver.get("https://quillbot.com/");
	}

}
