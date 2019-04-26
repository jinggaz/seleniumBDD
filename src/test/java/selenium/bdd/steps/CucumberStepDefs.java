package selenium.bdd.steps;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import selenium.bdd.TestApplication;
import selenium.bdd.pageobj.BasicPage;
import selenium.bdd.pageobj.LandingPage;
import selenium.bdd.pageobj.LoginPage;
import selenium.bdd.pageobj.ProfilePage;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestApplication.class)
@SpringBootTest
public class CucumberStepDefs {

  @Autowired
  private LandingPage landingPage;
  @Autowired
  private LoginPage loginPage;
  @Autowired
  private ProfilePage profilepage;
  @Autowired
  private BasicPage basicPage;

  @Given("^I use the test user \"([^\"]*)\" with password \"([^\"]*)\" to login$")
  public void loginToApplication(final String user, final String password) throws Throwable {
    landingPage.toPage().toLogin();
    loginPage.doLogin(user, password);
  }
  
  @Then("^I can see USERNAME as \"([^\"]*)\"$")
  public void i_can_see_USERNAME_as(String userName) throws Throwable {
	profilepage.checkUserName(userName);  
  }

  @Then("^I can logout, mission accomplished$")
  public void logout() throws Throwable {
	profilepage.toPage();
    basicPage.logout();
  }

  @After
  public void cleanupWindows() throws Throwable {
    loginPage.quit();
  }
}
