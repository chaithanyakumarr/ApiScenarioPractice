import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ScenarioThreeTest {

    @Test
    void createUserSuccessfully() {

        String requestBody = """
                {
                  "name": "Chaitanya",
                  "job": "QA Engineer"
                }
                """;

        given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(201)
                .body("name", equalTo("Chaitanya"))
                .body("job", equalTo("QA Engineer"))
                .body("id", notNullValue())
                .body("createdAt", notNullValue());
    }

    @Test
    void createUserWithMissingJob() {

        String requestBody = """
                {
                  "name": "Chaitanya"
                }
                """;

        given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(400);
    }
}