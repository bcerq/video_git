package pages;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

@SuppressWarnings("unused")
public class Metodos {
	WebDriver driver;

	public void abrirNavegador(String appUrl, String descriPasso) {
		FirefoxOptions options = new FirefoxOptions();
		options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");

		System.setProperty("webdriver.gecko.driver", "./webdriver/geckodriver.exe");
		driver = new FirefoxDriver(options);
		driver.manage().window().maximize();
		driver.get(appUrl);

	}

	public void fecharNavegador(String descriPasso) {
		driver.quit();
	}

	public void escrever(String texto, By elemento, String descriPasso) {
		driver.findElement(elemento).sendKeys(texto);
	}

	public void submitEnter(By elemento, String descriPasso) {
		driver.findElement(elemento).submit();
	}

	public void submitClick(By elemento, String descriPasso) {
		driver.findElement(elemento).click();
	}

	public void validarPagina(By elemento, String descriPasso) {
		String paginaEsperada;
		String pagina;
		paginaEsperada = "Products";
		pagina = driver.findElement(elemento).getText();
		assertEquals(paginaEsperada, pagina);
	}

	public void screenShot(String nome) throws IOException {
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File scrFile = scrShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./scr/evidencias/" + nome + ".png");
		FileUtils.copyFile(scrFile, destFile);

	};

	public void validarErro(By elemento) {

		String erro = driver.findElement(elemento).getText();
		if (erro.equals("Epic sadface: Username and password do not match any user in this service")) {
			String erroEsperado = "Epic sadface: Username and password do not match any user in this service";
			assertEquals(erroEsperado, erro);
		} else if (erro.equals("Epic sadface: Username is required")) {
			String erroEsperado = "Epic sadface: Username is required";
			assertEquals(erroEsperado, erro);
		} else if (erro.equals("Epic sadface: Password is required")) {
			String erroEsperado = "Epic sadface: Password is required";
			assertEquals(erroEsperado, erro);
		}

	}
}
