import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class ScenarioFiveTest {
    @Test
    void deleteNonExistingUser() {

        var response =
                given()
                        .when()
                        .delete("https://reqres.in/api/users/9999");

        System.out.println("Status Code: " + response.getStatusCode());

        response.then()
                .statusCode(204);
    }
}