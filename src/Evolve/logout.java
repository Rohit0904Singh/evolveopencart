package Evolve;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class logout {
	
		
public static void main(String[] args) throws IOException {
	
	

		
		try {
		System.setProperty("webdriver.chrome.driver","E:\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
			WebDriver driver = new ChromeDriver(options);
		    driver.manage().window().maximize();
		    
			
		    //open evolve snacks
			driver.get("http://opencart.evolvesnacks.com");
			
			Thread.sleep(10000);
			driver.findElement(By.xpath("//*[@id='pro-modal']/div/div/div/button")).click();


         driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/button[1]")).click();
		   
		FileInputStream ExcelFile = new FileInputStream("E:/signup data.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(ExcelFile); 
		XSSFSheet sheet = wb.getSheet("Sheet1");
			
		for(int i=16;i<24;i++)
		{
			
			XSSFRow row = sheet.getRow(i);
		    String email = row.getCell(2).getStringCellValue();
		    String password = row.getCell(8).getStringCellValue();
			
			//	Thread.sleep(2000);
			
		
       


			
			//Go to login screen
			WebElement login=driver.findElement(By.xpath("//*[@id='Menu_YnwtL2RI']/nav/ul/li[1]/a/span/span/i"));
			JavascriptExecutor executor5 = (JavascriptExecutor)driver;
			executor5.executeScript("arguments[0].click()", login);
			Thread.sleep(2000);
			
			//Enter email and password
			driver.findElement(By.xpath("//*[@id='input-email']")).sendKeys(email);
			driver.findElement(By.xpath("//*[@id='input-password']")).sendKeys(password);
			
			//click on login button
			driver.findElement(By.xpath("//*[@class='buttons']/div[2]/input")).click();
			
			Thread.sleep(2000);
			
			System.out.println(" \n\n login successful"+":- "+email);


		
		//Click on BuySnacks 
		WebElement buysnacks=driver.findElement(By.xpath("//*[@id='menu_category_Menu_VIfWm2LT_461']/a/span/span"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()", buysnacks);
		Thread.sleep(2000);
	
		WebElement myaccount = driver.findElement(By.xpath("//*[@id='Menu_YnwtL2RI']/nav/ul/li[1]/a"));
		Actions action = new Actions(driver);
		action.moveToElement(myaccount).build().perform();

		WebDriverWait wait = new WebDriverWait(driver, 5); 
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='Menu_YnwtL2RI']/nav/ul/li[1]/ul/li[5]/a/span")));  // until this submenu is found

		//identify logout
		WebElement logout = driver.findElement(By.xpath("//*[@id='Menu_YnwtL2RI']/nav/ul/li[1]/ul/li[5]/a/span"));
		
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		executor1.executeScript("arguments[0].click()", logout);
		Thread.sleep(2000);

	
		} 
	driver.close();

		}
		
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}


	}
	
	
