package webServiceTesting;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class DeleteUser extends User{

    private int id;
    private Response response;

    public DeleteUser() {
        this.requestSpecification = given()
                .baseUri("https://reqres.in/api/users/");
    }

    public void setId(int id){
        this.id = id;
    }

    public void deleteUserRest(){
        this.requestSpecification.contentType(ContentType.JSON);
        response = this.requestSpecification.delete(this.id+"");
    }

    public void deleteUserRest(CreateUser createUser){
        this.requestSpecification.contentType(ContentType.JSON);
        response = this.requestSpecification.delete(createUser.buildBody());
    }

    @Override
    public int getResponseCode() {
        return response.statusCode();
    }

}
