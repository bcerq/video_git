package elementos;

import org.openqa.selenium.By;

public class Elementos {
	private By qLogin = By.id("user-name");
	private By qPass = By.id("password");
	private By bLogin = By.id("login-button");
	private By hProducts = By.cssSelector("#header_container > div.header_secondary_container > span");
	private By msgError = By.id("login_button_container");

	
	
	
	
	public By getqLogin() {
		return qLogin;
	}

	public By getqPass() {
		return qPass;
	}

	public By getbLogin() {
		return bLogin;
	}

	public By gethProducts() {
		return hProducts;
	}

	public By getMsgError() {
		return msgError;
	}
}
