import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ContactCreationsTests {
  private WebDriver driver;

  @BeforeEach
  public void setUp() {
    driver = new ChromeDriver();

  }
  @AfterEach
  public void tearDown() {
    driver.quit();
  }
  @org.junit.jupiter.api.Test
  public void canGreateContact() {
    driver.get("http://localhost/addressbook/");
    driver.manage().window().setSize(new Dimension(1920, 1040));
    driver.findElement(By.name("user")).sendKeys("admin");
    driver.findElement(By.name("pass")).sendKeys("secret");
    driver.findElement(By.xpath("//input[@value=\'Login\']")).click();
    driver.findElement(By.linkText("add new")).click();
    driver.findElement(By.name("firstname")).click();
    driver.findElement(By.name("firstname")).sendKeys("first_name");
    driver.findElement(By.name("firstname")).sendKeys("first_name");
    driver.findElement(By.cssSelector("body")).click();
    driver.findElement(By.name("middlename")).click();
    driver.findElement(By.name("middlename")).sendKeys("middle_name");
    driver.findElement(By.name("lastname")).click();
    driver.findElement(By.name("lastname")).sendKeys("last_name");
    driver.findElement(By.name("nickname")).click();
    driver.findElement(By.name("nickname")).click();
    driver.findElement(By.name("nickname")).sendKeys("nickname");
    driver.findElement(By.xpath("(//input[@name=\'submit\'])[2]")).click();
    driver.findElement(By.linkText("home")).click();
    driver.findElement(By.linkText("Logout")).click();

  }
}
