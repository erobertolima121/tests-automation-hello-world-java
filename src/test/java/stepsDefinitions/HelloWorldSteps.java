package stepsDefinitions;

import base.BaseUtil;
import static com.jayway.restassured.module.jsv.JsonSchemaValidator.*;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Quando;
import cucumber.api.java.pt.Então;
import org.junit.Assert;

public class HelloWorldSteps extends BaseUtil {

	private String cnpj;
	private BaseUtil base;

	public HelloWorldSteps(BaseUtil base) {
		this.base = base;
	}

	public HelloWorldSteps() {

	}

	@Dado("^que eu possua a operacao desejada a ser chamada$")
	public void que_eu_possua_a_operacao_dejesada() throws Throwable {

		cnpj = "/hello";

	}

	@Quando("^eu realizar a requisicao no endpoint$")
	public void eu_realizar_a_requisicao_no_endpoint() throws Throwable {
		System.out.println("URL SOLICITADA:::::::::: " + base.urlDigital + cnpj);
		base.response = base.request.get(base.urlDigital + cnpj);
	}

	@Então("^a api me retorna Hello World$")
	public void a_api_me_retorna_hello_world() throws Throwable {

		//System.out.println(base.response.getBody().asString());
		String body = base.response.getBody().asString();
		Assert.assertEquals("Hello, World!", body.replaceAll("[\\\\\\r\\\\\\n]+", ""));
	}

}