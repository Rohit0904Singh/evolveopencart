package Evolve;

import java.io.FileInputStream;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class coupon_login {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {

			System.setProperty("webdriver.chrome.driver","E:\\chromedriver.exe");
				WebDriver driver = new ChromeDriver();
			    driver.manage().window().maximize();
			


				  
				FileInputStream ExcelFile = new FileInputStream("E:/signup data.xlsx");
				XSSFWorkbook wb = new XSSFWorkbook(ExcelFile); 
				XSSFSheet sheet = wb.getSheet("Sheet1");
				XSSFSheet sheet1 = wb.getSheet("Sheet2");
					
				
				for(int i=4;i<10;i++)
				{
					
					XSSFRow row = sheet.getRow(i);
				    String email = row.getCell(2).getStringCellValue();
				    String password = row.getCell(8).getStringCellValue();
					
				//open evolve snacks
				    driver.get("http://opencart.evolvesnacks.com");
					Thread.sleep(5000);
				
			//	for(int j=1;j<sheet1.getLastRowNum();j++)
				for(int j=1;j<3;j++)
				{
					//Click on BuySnacks 
					WebElement buysnacks=driver.findElement(By.xpath("//*[@id='menu_category_Menu_VIfWm2LT_461']/a/span/span"));
					JavascriptExecutor executor = (JavascriptExecutor)driver;
					executor.executeScript("arguments[0].click()", buysnacks);
					Thread.sleep(2000);
					
					for(int k=0;k<4;k++)
					{
					String uuid1 = RandomStringUtils.random(1, "1456789"); 
					//Add items to cart
					driver.findElement(By.xpath("//*[@id='ProductsSystem_ReH9ivFH']/div[1]/div["+uuid1+"]/div/div[2]/div[2]/div[1]/a")).click();
					Thread.sleep(2000);
					}
					
				//Go to cart
				WebElement we =driver.findElement(By.xpath("//*[@class='tb_icon ico-organie-basket']"));
				
				JavascriptExecutor cart = (JavascriptExecutor)driver;
				cart.executeScript("arguments[0].click()", we);
				Thread.sleep(2000);
				
				

				//Enter Coupon
				XSSFRow row1 = sheet1.getRow(j);
			    String coupon = row1.getCell(0).getStringCellValue();
				WebElement we4 =driver.findElement(By.xpath("//*[@id='accordion']/div[1]/div[1]/h4/a"));
				JavascriptExecutor executor3 = (JavascriptExecutor)driver;
				executor3.executeScript("arguments[0].click()", we4);
			
				Thread.sleep(5000);

				driver.findElement(By.xpath(" //*[@id='input-coupon']")).sendKeys(coupon);
				System.out.println("\n\ncoupon applied:- "+coupon);
				
				driver.findElement(By.xpath("//*[@id='button-coupon']")).click();
				
				Thread.sleep(5000);
				
			
			List<WebElement> couponmessage = driver.findElements(By.xpath("//*[@id='System_ipgD4p7y']/div[1]/div"));
			System.out.println(couponmessage.size());
			if(couponmessage.size()==0)
			{
				WebElement couponmessage1= driver.findElement(By.xpath("//*[@id='System_ipgD4p7y']/div[1]"));
			String couponmessage2= couponmessage1.getText();
			System.out.println("coupon message:- "+couponmessage2);
		
				Thread.sleep(5000);
				
			
				
				//click on check out
				
			 driver.findElement(By.xpath("//*[@id='System_ipgD4p7y']/div[3]/div[2]/div/a")).click();				
				/*
				WebElement we5=	driver.findElement(By.xpath("//*[@class='pull-right']/a"));
				JavascriptExecutor executor5 = (JavascriptExecutor)driver;
				executor5.executeScript("arguments[0].click()", we5);
			
				*/
			}
			
			else
			{
				WebElement couponmessage1= driver.findElement(By.xpath("//*[@id='System_ipgD4p7y']/div[1]/div"));
				String couponmessage2= couponmessage1.getText();
				System.out.println("coupon message:- "+couponmessage2);
			
					Thread.sleep(5000);
					
				
					
					//click on check out
					
				 driver.findElement(By.xpath("//*[@id='System_ipgD4p7y']/div[2]/div[2]/div/a")).click();				
					
			}
				//Click on returning customer
				Thread.sleep(2000);
			

				WebElement we6=driver.findElement(By.xpath("//*[@id='collapse-checkout-option']/div/ul/li[2]/a/legend"));
				JavascriptExecutor executor6 = (JavascriptExecutor)driver;
				executor6.executeScript("arguments[0].click()", we6);
				Thread.sleep(2000);
				
				//Enter email and password
				Thread.sleep(2000);

				driver.findElement(By.xpath("//*[@id='input-email']")).sendKeys(email);
				driver.findElement(By.xpath("//*[@id='input-password']")).sendKeys(password);
				Thread.sleep(2000);

				//click on login button
				driver.findElement(By.xpath("//*[@class='pull-right']/input")).click();
				System.out.println("login successful:- "+email);
				
				Thread.sleep(5000);
				
				//Check out process
				WebElement we1=	driver.findElement(By.xpath("//*[@class='pull-right']/input"));
				JavascriptExecutor executor4= (JavascriptExecutor)driver;
				executor4.executeScript("arguments[0].click()", we1);
				Thread.sleep(5000);
				
				driver.findElement(By.id("button-shipping-address")).click();
				Thread.sleep(5000);
				driver.findElement(By.id("button-shipping-method")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id='collapse-payment-method']/div/div[2]/label/span")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id='button-payment-method']")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id='collapse-checkout-confirm']/div/div[2]/div/input")).click();
				Thread.sleep(5000);

				
				
				System.out.println(driver.findElement(By.xpath("//*[@id='System_6OjM9zPg']/div/div/p[1]")).getText());
				//System.out.println(driver.findElement(By.xpath(".//*[@id='System_6OjM9zPg']/div/div/p[2]")).getText());
				System.out.println("order placed by :-"+email);

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
				System.out.println("logout successful:- "+email);
				}

				
				}
				
				driver.close();
				
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
