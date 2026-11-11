import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ScenarioOneTest {

    @Test
    void getExistingUser() {

        given()
                .when()
                .get("https://reqres.in/api/users/2")
                .then()
                .log().status()
                .statusCode(200)
                .body("data.id", equalTo(2));
    }

    ///
    @TestC
    void getNonExistingUser() {

        given()
                .when()
                .get("https://reqres.in/api/users/9999")
                .then()
                .statusCode(404);
    }
}C