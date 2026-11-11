import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ScenarioFourTest {

    @Test
    void updateUserSuccessfully() {

        String requestBody = """
                {
                  "name": "Chaitanya",
                  "job": "Senior QA Engineer"
                }
                """;

        given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .put("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .body("name", equalTo("Chaitanya"))
                .body("job", equalTo("Senior QA Engineer"))
                .body("updatedAt", notNullValue());
    }
}