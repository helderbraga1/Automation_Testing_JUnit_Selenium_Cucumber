package webServiceTesting.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import webServiceTesting.CreateUser;
import webServiceTesting.DeleteUser;
import webServiceTesting.RegisterUser;

public class WebServiceSteps {

  CreateUser createUser;
  DeleteUser deleteUser;
  RegisterUser registerUser;
  String name, job;

  //TC002
  @Given("^I use user creation service$")
  public void useUserCreationWebService() {
    createUser = new CreateUser();
  }

  @When("^I set name \"([^\"]*)\"$")
  public void setName(String name) {
    createUser.setName(name);
    this.name = name;
  }

  @When("^I set job \"([^\"]*)\"$")
  public void setJob(String job) {
    createUser.setJob(job);
    this.job = job;
  }

  @Then("^I validate my response is correct$")
  public void validateMyResponseIsCorrect() {
    createUser.createUserRest();
    Assert.assertEquals(HttpStatus.SC_CREATED, createUser.getResponseCode());
  }

  //TC003 by id

  @Given("^I delete the user by id \"([^\"]*)\"$")
  public void deleteUserById(int id){
    deleteUser = new DeleteUser();
    deleteUser.setId(id);
    deleteUser.deleteUserRest();
  }

  @Given("^I validate the user was deleted$")
  public void validateUserDeleted(){
    //Check if response code is 204, as per documentation https://reqres.in/
    Assert.assertEquals(HttpStatus.SC_NO_CONTENT, deleteUser.getResponseCode());
  }

  //TC003 by object
  @Given("^the user was created successfully \"([^\"]*)\" \"([^\"]*)\"$")
  public void userWasCreated(String name, String job){
    createUser = new CreateUser();
    createUser.setName(name);
    createUser.setJob(job);
    createUser.createUserRest();
    Assert.assertEquals(HttpStatus.SC_CREATED, createUser.getResponseCode());
  }

  @Given("^I delete the previously created user$")
  public void deleteUserById(){
    deleteUser = new DeleteUser();
    deleteUser.deleteUserRest(createUser);
  }

  //TC004
  @Given("^I insert a valid email \"([^\"]*)\"$")
  public void insertValidEmail(String email){
    registerUser = new RegisterUser();
    registerUser.setEmail(email);
  }
  @Given("^I insert an empty password \"([^\"]*)\"$")
  public void insertEmptyPassword(String password){
    registerUser.setPassword(password);
  }

  @Given("^I validate the user registration failed$")
  public void registrationFailed(){
    registerUser.registerUserRest();
    Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, registerUser.getResponseCode());
  }
}
