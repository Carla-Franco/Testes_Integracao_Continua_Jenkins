package br.es.cirfranco.tasks.funcional;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TasksTest {
	
	public WebDriver acessarAplicacao() throws MalformedURLException {
		//WebDriver driver = new ChromeDriver();
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		WebDriver driver = new RemoteWebDriver(new URL(" http://192.168.0.110:4444/wd/hub"), cap);
		driver.navigate().to("http://192.168.0.110:8001/tasks");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	@Test
	public void deveSalvarTarefaComSucesso() throws MalformedURLException {
		
		WebDriver driver = acessarAplicacao();
		
		try {
		driver.findElement(By.id("addTodo")).click();
		
		driver.findElement(By.id("task")).sendKeys("Teste Selenium");
		
		driver.findElement(By.id("dueDate")).sendKeys("06/03/2054");
		
		driver.findElement(By.id("saveButton")).click();
		
		String message = driver.findElement(By.id("message")).getText();
		Assert.assertEquals("Success!", message);
		} finally {
		driver.quit();
		}
	}
	
	@Test
	public void naoDeveSalvarTarefaSemDescricao() throws MalformedURLException {
		
		WebDriver driver = acessarAplicacao();
		
		try {
		driver.findElement(By.id("addTodo")).click();
		
		driver.findElement(By.id("dueDate")).sendKeys("06/03/2044");
		
		driver.findElement(By.id("saveButton")).click();
		
		String message = driver.findElement(By.id("message")).getText();
		Assert.assertEquals("Fill the task description", message);
		} finally {
		driver.quit();
		}
	}
	
	@Test
	public void naoDeveSalvarTarefaSemData() throws MalformedURLException {
		
		WebDriver driver = acessarAplicacao();
		
		try {
		driver.findElement(By.id("addTodo")).click();
		
		driver.findElement(By.id("task")).sendKeys("Teste Selenium");
		
		driver.findElement(By.id("saveButton")).click();
		
		String message = driver.findElement(By.id("message")).getText();
		Assert.assertEquals("Fill the due date", message);
		} finally {
		driver.quit();
		}
	}
	
	@Test
	public void naoDeveSalvarTarefaComDataPassada() throws MalformedURLException {
		
		WebDriver driver = acessarAplicacao();
		
		try {
		driver.findElement(By.id("addTodo")).click();
		
		driver.findElement(By.id("task")).sendKeys("Teste Selenium");
		
		driver.findElement(By.id("dueDate")).sendKeys("06/03/2004");
		
		driver.findElement(By.id("saveButton")).click();
		
		String message = driver.findElement(By.id("message")).getText();
		Assert.assertEquals("Due date must not be in past", message);
		} finally {
		driver.quit();
		}
	}
	
	@Test
	public void deveRemoverTarefaComSucesso() throws MalformedURLException {
		
		WebDriver driver = acessarAplicacao();
		
		try {
		driver.findElement(By.id("addTodo")).click();
		driver.findElement(By.id("task")).sendKeys("Teste Selenium");
		driver.findElement(By.id("dueDate")).sendKeys("06/03/2034");
		driver.findElement(By.id("saveButton")).click();
		String message = driver.findElement(By.id("message")).getText();
		Assert.assertEquals("Success!", message);
		
		driver.findElement(By.xpath("//a[@class='btn btn-outline-danger btn-sm']")).click();
		message = driver.findElement(By.id("message")).getText();
		Assert.assertEquals("Success!", message);
		} finally {
		driver.quit();
		}
	}

}
