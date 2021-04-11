package webServiceTesting;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;

public class CreateUser extends User{

  private String name;
  private String job;

  public CreateUser() {
    this.requestSpecification = given()
        .baseUri("https://reqres.in/api")
        .basePath("/users");
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setJob(String job) {
    this.job = job;
  }

  public String buildBody() {
    String body =
            "{\r\n" +
            "    \"name\" : \"" + this.name + "\",\r\n" +
            "    \"job\" : \"" + this.job + "\"\r\n" +
            "}";

    return body;
  }

  public void createUserRest(){
    response = this.requestSpecification.contentType(ContentType.JSON).body(this.buildBody()).when().post().then().extract();
  }
}
