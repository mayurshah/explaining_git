package com.Softcrylic.Automation.Testing;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertEquals;

/**
 * Simple {@link RemoteWebDriver} test that demonstrates how to run your Selenium tests with <a href="http://ondemand.saucelabs.com/ondemand">Sauce OnDemand</a>.
 * *
 * @author Ross Rowe
 */
public class WebDriverTest {

    private WebDriver driver;

    @Before
	public void setUp() throws Exception {

        DesiredCapabilities capabillities = DesiredCapabilities.android();
        capabillities.setCapability("version", "4");
        capabillities.setCapability("platform", Platform.MAC);
        this.driver = new RemoteWebDriver(
					  new URL("http://192.168.127.48:4444/wd/hub"),
					  capabillities);
        this.driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @Test
	public void basic() throws Exception {
        driver.get("http://www.amazon.com/");
        assertEquals("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more", driver.getTitle());
    }

    @After
	public void tearDown() throws Exception {
        driver.quit();
    }

}
