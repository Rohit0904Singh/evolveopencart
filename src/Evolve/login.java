package Evolve;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class login {

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
			
		
		for(int i=17;i<20;i++)
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

		
		//Click on BuySnacks 
		WebElement buysnacks=driver.findElement(By.xpath("//*[@id='menu_category_Menu_VIfWm2LT_461']/a/span/span"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()", buysnacks);
		Thread.sleep(2000);
		System.out.println("\n\nlogin successful:- "+email);
		
		for(int j=0;j<5;j++)
		{
			String uuid1 = RandomStringUtils.random(1, "123456789"); 
			//Add items to cart
			driver.findElement(By.xpath("//*[@id='ProductsSystem_ReH9ivFH']/div[1]/div["+uuid1+"]/div/div[2]/div[2]/div[1]/a")).click();
			Thread.sleep(2000);
		}
		
		//Go to cart
		WebElement we =driver.findElement(By.xpath("//*[@class='tb_icon ico-organie-basket']"));
		
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		executor1.executeScript("arguments[0].click()", we);
		Thread.sleep(2000);

		
		//click on check out
		driver.findElement(By.xpath("//*[@id='System_ipgD4p7y']/div[2]/div[2]/div/a")).click();

		Thread.sleep(2000);

		//Check out process
		WebElement we1=	driver.findElement(By.xpath("//*[@class='pull-right']/input"));
		JavascriptExecutor executor3 = (JavascriptExecutor)driver;
		executor3.executeScript("arguments[0].click()", we1);
		Thread.sleep(2000);
		driver.findElement(By.id("button-shipping-address")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("button-shipping-method")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='collapse-payment-method']/div/div[2]/label/span")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='button-payment-method']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='collapse-checkout-confirm']/div/div[2]/div/input")).click();
		Thread.sleep(2000);

		
		
		System.out.println(driver.findElement(By.xpath("//*[@id='System_6OjM9zPg']/div/div/p[1]")).getText());
		System.out.println(driver.findElement(By.xpath(".//*[@id='System_6OjM9zPg']/div/div/p[2]")).getText());
		
		System.out.println("Order placed by :-"+email);

		//hover my account
		WebElement myaccount = driver.findElement(By.xpath("//*[@id='Menu_YnwtL2RI']/nav/ul/li[1]/a"));
		Actions action = new Actions(driver);
		action.moveToElement(myaccount).build().perform();

		WebDriverWait wait = new WebDriverWait(driver, 5); 
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='Menu_YnwtL2RI']/nav/ul/li[1]/ul/li[5]/a/span")));  // until this submenu is found

		//identify logout
		WebElement logout = driver.findElement(By.xpath("//*[@id='Menu_YnwtL2RI']/nav/ul/li[1]/ul/li[5]/a/span"));
		JavascriptExecutor executor2 = (JavascriptExecutor)driver;
		executor2.executeScript("arguments[0].click()", logout);
		Thread.sleep(2000);
		
		System.out.println("logout:- "+email);


		} 
	driver.close();

		}
		
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}