package Evolve;

import java.io.FileInputStream;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DiscountVerification {
	static int evolvemoney1,money2;

	public static void main(String[] args) {

		try {
			System.setProperty("webdriver.chrome.driver","E:\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
		    driver.manage().window().maximize();
	

			
		
	    
		FileInputStream ExcelFile = new FileInputStream("E:/signup data.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(ExcelFile); 
		XSSFSheet sheet = wb.getSheet("Sheet1");
			
		
		for(int i=3;i<5;i++)
		{
			
			XSSFRow row = sheet.getRow(i);
		    String email = row.getCell(2).getStringCellValue();
		    String password = row.getCell(8).getStringCellValue();
			
			//	Thread.sleep(2000);
			
			
		//open evolve snacks
		driver.get("http://opencart.evolvesnacks.com");
		
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

		System.out.println("login successful:- "+email);

		for(int a=1;a<4;a++)
		{
			
		//Click on BuySnacks 
		WebElement buysnacks=driver.findElement(By.xpath("//*[@id='menu_category_Menu_VIfWm2LT_461']/a/span/span"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()", buysnacks);
		Thread.sleep(2000);
	
		
		if(a==1)
				{

			//Add items to cart
			driver.findElement(By.xpath("//*[@id='ProductsSystem_ReH9ivFH']/div[1]/div[1]/div/div[2]/div[2]/div[1]/a")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='ProductsSystem_ReH9ivFH']/div[1]/div[5]/div/div[2]/div[2]/div[1]/a")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='ProductsSystem_ReH9ivFH']/div[1]/div[6]/div/div[2]/div[2]/div[1]/a")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='ProductsSystem_ReH9ivFH']/div[1]/div[8]/div/div[2]/div[2]/div[1]/a")).click();

			Thread.sleep(5000);
		}
		
		else if(a==2)
		{
			for(int b=1;b<4;b++)
			{

				//Add items to cart
				driver.findElement(By.xpath("//*[@id='ProductsSystem_ReH9ivFH']/div[1]/div[1]/div/div[2]/div[2]/div[1]/a")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='ProductsSystem_ReH9ivFH']/div[1]/div[5]/div/div[2]/div[2]/div[1]/a")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='ProductsSystem_ReH9ivFH']/div[1]/div[6]/div/div[2]/div[2]/div[1]/a")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='ProductsSystem_ReH9ivFH']/div[1]/div[8]/div/div[2]/div[2]/div[1]/a")).click();

				Thread.sleep(5000);
			}
}
	
		else if(a==3)
		{
			for(int b=1;b<8;b++)
			{
				//Add items to cart
				driver.findElement(By.xpath("//*[@id='ProductsSystem_ReH9ivFH']/div[1]/div[1]/div/div[2]/div[2]/div[1]/a")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='ProductsSystem_ReH9ivFH']/div[1]/div[5]/div/div[2]/div[2]/div[1]/a")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='ProductsSystem_ReH9ivFH']/div[1]/div[6]/div/div[2]/div[2]/div[1]/a")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='ProductsSystem_ReH9ivFH']/div[1]/div[8]/div/div[2]/div[2]/div[1]/a")).click();

				Thread.sleep(5000);
			}
}
	
		//Go to cart
		WebElement cart =driver.findElement(By.xpath("//*[@class='tb_icon ico-organie-basket']"));
		
		JavascriptExecutor executor2 = (JavascriptExecutor)driver;
		executor2.executeScript("arguments[0].click()", cart);
		Thread.sleep(2000);

		
		//click on check out
		driver.findElement(By.xpath("//*[@id='System_ipgD4p7y']/div[2]/div[2]/div/a")).click();

		Thread.sleep(2000);
		
		//read cart sub total
		String subtotal=driver.findElement(By.xpath("//*[@id='mny-Sub-Total']")).getText();
		String subtotal1=subtotal.replaceAll("[^0-9]", "");
		int subtotal2= Integer.valueOf(subtotal1);
		int subtotal3=subtotal2/100;
		System.out.println("\n cart sub-total is:- "+subtotal3);
		
		if(subtotal3<500)
		{
			int evolvemoney=subtotal3*5;
			evolvemoney1=evolvemoney/100;
			System.out.println("Expected 5% evolve money:- "+evolvemoney1);
		}

		
		else if(subtotal3>500 && subtotal3<1000)
		{
			int evolvemoney=subtotal3*7;
			evolvemoney1=evolvemoney/100;
			System.out.println("Expected 7% evolve money:- "+evolvemoney1);	
		}
		
		if(subtotal3>1000)
		{
			int evolvemoney=subtotal3*10;
			evolvemoney1=evolvemoney/100;
			System.out.println("Expected 10% evolve money:- "+evolvemoney1);
		}
		
	
		
		//Check out process
		WebElement we1=	driver.findElement(By.id("button-payment-address"));
		JavascriptExecutor executor3 = (JavascriptExecutor)driver;
		executor3.executeScript("arguments[0].click()", we1);
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

		
		String orderid=driver.findElement(By.xpath("//*[@id='System_6OjM9zPg']/div/div/p[1]")).getText();
		String orderid1=orderid.replaceAll("[^0-9]", "");
		int orderid2= Integer.valueOf(orderid1);
		
		System.out.println(driver.findElement(By.xpath("//*[@id='System_6OjM9zPg']/div/div/p[1]")).getText());
		System.out.println(driver.findElement(By.xpath(".//*[@id='System_6OjM9zPg']/div/div/p[2]")).getText());
		
	

		
		//backend process
	WebDriver driver1 = new ChromeDriver();
    driver1.manage().window().maximize();
	driver1.get("http://opencart.evolvesnacks.com/admin");
	
	driver1.findElement(By.id("input-username")).sendKeys("admin");
	driver1.findElement(By.id("input-password")).sendKeys("Evolve@123#");
	driver1.findElement(By.xpath("//*[@class='text-right']/button")).click();
	
	System.out.println("login successfully to admin panel");
	
	Thread.sleep(5000);
	driver1.findElement(By.xpath("//*[@id='menu-sale']/a")).click();
	driver1.findElement(By.xpath("//*[@id='menu-sale']/ul/li[1]/a")).click();
	
	Thread.sleep(2000);
	driver1.findElement(By.id("input-order-id")).sendKeys(""+orderid2);
	driver1.findElement(By.id("button-filter")).click();
	
	driver1.findElement(By.id("tn-"+orderid2)).sendKeys("123456");
	driver1.findElement(By.xpath("//*[@id='form-order']/div/table/tbody/tr/td[1]/input[1]")).click();
	
	driver1.findElement(By.xpath("//*[@id='bulk_action_id']")).sendKeys("complete");
	driver1.findElement(By.xpath("//*[@id='button-bulk-action']")).click();
	Thread.sleep(5000);
	System.out.println("order no. :"+orderid2+" changed to complete");
	driver1.close();
	
	
	//check evolve money gained
	driver.findElement(By.xpath("//*[@id='Menu_YnwtL2RI']/nav/ul/li[1]/a")).click();
	driver.findElement(By.xpath("//*[@id='System_DdmbwILT']/div/div[2]/ul/li[2]/a")).click();
	Thread.sleep(2000);
	
	
	WebElement order= driver.findElement(By.xpath("//*[@id='System_iEByBbpF']/div[1]/table/tbody/tr[1]/td[2]/a"));
	String order3=order.getText();
	String order1=order3.replaceAll("[^0-9]", "");
	int order2= Integer.valueOf(order1);
	
	if(order2==orderid2)
	{
		WebElement money3=driver.findElement(By.xpath("//*[@id='System_iEByBbpF']/div[1]/table/tbody/tr[1]/td[3]"));
		String money=money3.getText();
		String money1=money.replaceAll("[^0-9]", "");
		 money2= Integer.valueOf(money1);
		System.out.println("received Evolve money:- "+money2);
		
		
	}
	
	if(evolvemoney1==money2)
	{
		System.out.println("test passed");
	}
	
	else
	{
		System.out.println("test failed");
	}
	
		} 
			
	
	//identify logout
		WebElement logout = driver.findElement(By.xpath("//*[@id='Menu_YnwtL2RI']/nav/ul/li[1]/ul/li[5]/a/span"));
	JavascriptExecutor executor1 = (JavascriptExecutor)driver;
	executor1.executeScript("arguments[0].click()", logout);
	Thread.sleep(2000);

	System.out.println("logout successfully:- "+email);

    
     System.out.println("\n\n\n");
	
	


		}
			 driver.close();

		}
		
		catch(NumberFormatException e)
		{
			System.out.println(e);
		}
		
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	}
	
	
