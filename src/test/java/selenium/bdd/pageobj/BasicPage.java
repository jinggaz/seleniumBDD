package selenium.bdd.pageobj;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import selenium.bdd.driver.DriverFactory;

@Component
@ConfigurationProperties(prefix = "basicpage")
public class BasicPage extends AbstractPage {

	public void logout() {
		clickName("submit");
	}

	private void clickName(final String name) {
		final WebElement button = DriverFactory.getInstance().getDriver().findElement(By.name(name));
		final JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", button);
	}
}
