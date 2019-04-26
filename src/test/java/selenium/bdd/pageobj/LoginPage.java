package selenium.bdd.pageobj;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "loginpage")
public class LoginPage extends AbstractPage {

	public void doLogin(final String testUser, final String testPass) {
		assertThat(pageTitle(), is(equalTo("SuiteCRM - CRM for the World")));
		editText("username", testUser);
		editText("password", testPass);
		clickXpath("Login");
		assertThat(hasErrors(), is(false));
	}


}
