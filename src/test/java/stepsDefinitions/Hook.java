package stepsDefinitions;

import base.BaseUtil;
import static io.restassured.RestAssured.given;
import cucumber.api.java.*;

public class Hook extends BaseUtil {

	private BaseUtil base;

	public Hook(BaseUtil base) {
		this.base = base;
	}

	@Before
	public void InicializeTest() {

		base.request = given().header("Accept", "application/json").header("Content-Type", "application/json");
	}
}
