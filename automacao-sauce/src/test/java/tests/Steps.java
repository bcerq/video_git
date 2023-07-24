package tests;

import java.io.IOException;

import elementos.Elementos;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Metodos;

public class Steps {
	Metodos metodos = new Metodos();
	Elementos elementos = new Elementos();

	@Given("que eu acesse {string}")
	public void que_eu_acesse(String appUrl) {
		metodos.abrirNavegador(appUrl, "Acessando saucedemo");
	}

	@Given("preencho login valido")
	public void preencho_login_valido() {
		metodos.escrever("standard_user", elementos.getqLogin(), "Escrevendo login");
	}

	@Given("preencho senha valida")
	public void preencho_senha_valida() {
		metodos.escrever("secret_sauce", elementos.getqPass(), "Escrevendo senha");
	}

	@When("pressiono enter")
	public void pressiono_enter() {
		metodos.submitEnter(elementos.getbLogin(), "dando enter em login");
	}

	@When("clico login")
	public void clico_login() {
		metodos.submitClick(elementos.getbLogin(), "clicando em login");
	}

	@Then("valido login")
	public void valido_login() throws IOException {
		metodos.validarPagina(elementos.gethProducts(), "validando pagina");
		metodos.screenShot("saucedemologin");
		metodos.fecharNavegador("fechando navegador");
	}

	@Given("preencho senha invalida")
	public void preencho_senha_invalida() {
		metodos.escrever("public_sauce", elementos.getqPass(), "Escrevendo senha invalida");

	}

	@Then("valido nao login")
	public void valido_nao_login() throws IOException {
		metodos.validarErro(elementos.getMsgError());
		metodos.screenShot("saucedemologin - fail ");
		metodos.fecharNavegador("fechando navegador");
	}

	@Given("preencho login invalido")
	public void preencho_login_invalido() {
		metodos.escrever("not_a_standard_user", elementos.getqLogin(), "Escrevendo login invalido");

	}

	@Given("nao preencho login")
	public void nao_preencho_login() {
		// vazio
	}

	@Given("nao preencho senha")
	public void nao_preencho_senha_valida() {
		// vazio
	}
}
