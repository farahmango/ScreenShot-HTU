import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AddItems {

	public static void main(String[] args) throws IOException {
//		WebDriver driver = new EdgeDriver();
//		Random myRandom = new Random();
//		driver.get("https://www.saucedemo.com/inventory.html");
//		driver.manage().window().maximize();
//		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/input[1]")).sendKeys("standard_user");
//		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[2]/input[1]")).sendKeys("secret_sauce");
//		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/input[1]")).click();



//	way two 
	for(int k =0 ; k<3 ; k++) {
		

		WebDriver driver = new EdgeDriver();
		Random myRandom = new Random();
		driver.get("https://www.saucedemo.com/inventory.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/input[1]")).sendKeys("standard_user");
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[2]/input[1]")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/input[1]")).click();
//		int cart = myRandom.nextInt(0,6);
		
		Date date = new Date();
		String myDate = date.toString();
		String myUpdateDate = myDate.replace(":","-");

		
		List<WebElement> itemss = driver.findElements(By.className("btn_inventory"));
		int cart = myRandom.nextInt(0,itemss.size());

		for(int i =0 ; i<= cart; i++) {	
			WebElement itemDivv =itemss.get(i) ;
			itemDivv.click();
			
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,1)");
	
			TakesScreenshot scrShot =((TakesScreenshot)driver);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			
			File DestFile=new File(".//"+myUpdateDate+".png");
	        FileUtils.copyFile(SrcFile, DestFile);
			
			    }		
				
			}
		
		}
	
}
