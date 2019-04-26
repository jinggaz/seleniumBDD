package selenium.bdd.pageobj;

import static org.junit.Assert.assertTrue;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import selenium.bdd.driver.DriverFactory;

@Component
@ConfigurationProperties(prefix = "profilepage")
public class ProfilePage extends AbstractPage {
	
	public void checkUserName(final String userName) {
		assertTrue(findXpath(userName));
	}

	private boolean findXpath(final String userName) {
		return DriverFactory.getInstance().getDriver().getPageSource().contains(userName);
	}

	public void toPage() {
		clickId("menu1840");
		
	}
}
