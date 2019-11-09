package desafioTestCases;

import static io.restassured.RestAssured.when;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.*;

import java.io.File;

import org.junit.Test;

public class ApiTestCase {

	public ApiTestCase() {
	};
	
	@Test
	public void contratoTestCarrinho(){
	    when()
	        .get("http://5d9cc58566d00400145c9ed4.mockapi.io/shopping_cart")
	    .then()
	            .statusCode(200)
	            .body(matchesJsonSchema(new File("Schema/schema.json")))
	            .body("shopping_cart",is(1))
	            .body("sku[0]",is("demo_2"))
	            .body("size[0]",is("S"))
	            .body("price[0]", is("27.00"))
	            .body("total_shipping", is("2.00"));
	}
}
