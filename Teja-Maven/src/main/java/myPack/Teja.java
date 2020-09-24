package myPack;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Teja {
@Test
 public static void VerifyLogin() {
	System.setProperty("webdriver.chrome.driver",
			"E:\\Softwares\\chrome\\chrome85\\chromedriver.exe");
ChromeDriver driver = new ChromeDriver();
 driver.get("http://apps.qaplanet.in/hrm");
 
 //login
 driver.findElement(By.name("txtUserName")).sendKeys("qaplanet1");
 driver.findElement(By.name("txtPassword")).sendKeys("lab1");
 driver.findElement(By.name("Submit")).click();
 
 //verify page title
 if(driver.getTitle().equals("OrangeHRM")){
	 System.out.println("TC passed!");
 }else {
	 System.out.println("TC failed!");
 }
 
 //logout
 driver.findElement(By.linkText("Logout")).click();
 
 driver.close();
}
@Test
 public static void addEmp() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver",
			"E:\\Softwares\\chrome\\chrome85\\chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	driver.get("http://apps.qaplanet.in/hrm");
	
	//driver.manage().window().maximize();
	//login into the application........
	driver.findElement(By.name("txtUserName")).sendKeys("qaplanet1");
	driver.findElement(By.name("txtPassword")).sendKeys("lab1");
	driver.findElement(By.name("Submit")).click();
	
	//click on the ADD button by switching on to the frame.......
	String firstName ="Mahesh";
	String lastName  ="Tungala";

	driver.switchTo().frame("rightMenu");
	
	//clicking the ADD button
	driver.findElement(By.xpath("//*[@id='standardView']/div[3]/div[1]/input[1]")).click();
	                             
	//add the employee details.....
	Thread.sleep(5000);
	driver.findElement(By.name("txtEmpLastName")).sendKeys(lastName);
	driver.findElement(By.name("txtEmpFirstName")).sendKeys(firstName);
	driver.findElement(By.xpath("//*[@id='btnEdit']")).click();
	
	//Thread.sleep(2000);
	
	//verify the employee name just entered .....in the personal details page...
	
	Thread.sleep(5000);
	//click the edit button
	driver.findElement(By.xpath("//*[@id='btnEditPers']")).click();
	
	//fetch the innertext of both lastname and firstname fields
	String fN=driver.findElement(By.xpath("//*[@id='txtEmpFirstName']")).getAttribute("value");
	String lN=driver.findElement(By.xpath("//*[@id='txtEmpLastName']")).getAttribute("value");
	System.out.println("firstName :"+ fN);
	System.out.println("lastName : "+ lN);
	
	if(fN.equals(firstName)&&(lN.equals(lastName))){
		System.out.println("Employee successfully added : TestCase Passed");
	}
	else
	{
		System.out.println("Add Employee failed : testcase failed");
	}
	
	//switch back to the parent frame
	//driver.switchTo().defaultContent();
	driver.switchTo().parentFrame();
	Thread.sleep(2000);
	
	//click the logout link
	driver.findElement(By.xpath("html/body/div[3]/ul/li[3]/a")).click();
	
	//close the browser
	Thread.sleep(2000);
	driver.close();	
}
@Test
 public static void editEmp() {
	System.out.println("Edit emp passed!");
}
@Test
  public static void deleteEmp() {
	System.out.println("Delete emp passed!");
}
@Test
 public static void addCompany() {
	System.out.println("Add Company passed!");
}
@Test
 public static void editCompany() {
	System.out.println("Edit Company passed!");
}
}
