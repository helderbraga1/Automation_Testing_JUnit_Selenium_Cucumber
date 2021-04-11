package webServiceTesting;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;

public class RegisterUser extends User{

    private String email;
    private String password;

    public RegisterUser() {
        this.requestSpecification = given()
                .baseUri("https://reqres.in/api/register");
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String buildBody() {
        String body =
                "{\r\n" +
                        "    \"email\" : \"" + this.email + "\",\r\n" +
                        "    \"password\" : \"" + this.password + "\"\r\n" +
                        "}";
        return body;
    }

    public void registerUserRest(){
        response = this.requestSpecification.contentType(ContentType.JSON).body(this.buildBody()).when().post().then().extract();

    }
}
