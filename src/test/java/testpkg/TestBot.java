package testpkg;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import basepkg.BaseClass;
import pagespkg.FileUpload;
import pagespkg.MouseHover;
import pagespkg.WindowHandling;
import pagespkg.DataDriven;
import utilities.Excelutil;

public class TestBot extends BaseClass {
	@Test
	public void testrun() throws AWTException, InterruptedException, IOException {
		driver.manage().window().maximize();
		DataDriven l=new DataDriven(driver);
		String xl="C:\\Users\\annsp\\Desktop\\Philo\\Luminar\\Project\\QuillBot\\QuillBot.xlsx";
		String sheet="Sheet1";
		int rowCount=Excelutil.getRowCount(xl, sheet);
		
		for(int i=1;i<=rowCount;i++) {
			String email=Excelutil.getCellValue(xl,sheet,i,0);
			System.out.println("email---"+email);
			String password=Excelutil.getCellValue(xl,sheet,i,1);
			System.out.println("password---"+password);
			l.loginclick();
			l.details(email, password);
			l.clicklogin();
		}
	Thread.sleep(3000);
	FileUpload fu=new FileUpload(driver);
	fu.file();
	fu.fileUpload("C:\\Users\\annsp\\Desktop\\Philo\\Luminar\\Project\\QuillBot\\QuillBotfile.pdf");
	Thread.sleep(5000);
	fu.paraphrase();
	Thread.sleep(8000);
	File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileHandler.copy(screenshot,new File("./Screenshot//src.png"));
	WindowHandling wh=new WindowHandling(driver);
	String parentWindow=driver.getWindowHandle();
	System.out.println("Parent Window Title:"+driver.getTitle());
	wh.field();
	Thread.sleep(3000);
	Set<String> allWindowHandles=driver.getWindowHandles();
	for(String handles:allWindowHandles) {
		System.out.println(handles);
		if(!handles.equalsIgnoreCase(parentWindow)) {
			driver.switchTo().window(handles);
			Thread.sleep(3000);
			wh.help();
			Thread.sleep(5000);
			driver.close();
		}
		driver.switchTo().window(parentWindow);
	}
	MouseHover mh=new MouseHover(driver);
	mh.click();
	Thread.sleep(3000);
	WebElement British=mh.hover();
	WebElement American=mh.hover1();
	Actions act=new Actions(driver);
	act.moveToElement(British);
	Thread.sleep(3000);
	act.moveToElement(American);
	act.perform();
	Thread.sleep(3000);
	}
}


