import io.appium.java_client.android.AndroidDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;


public class TestClickAirQuality {
	AndroidDriver<WebElement> driver;

	@Before
	public void setUp() throws Exception{
		DesiredCapabilities capabilities=new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Coolpad8670");
		capabilities.setCapability("platformVersion", "4.4.2");
		capabilities.setCapability("noReset","ture");
		capabilities.setCapability("appPackage", "com.updrv.lifecalendar");
		capabilities.setCapability("appActivity", ".activity.MainActivity");
		//capabilities.setCapability("unicodeKeyboard","ture");
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}

	@Test
	public void weatherquality() throws Exception {

		driver.findElementById(
				"com.updrv.lifecalendar:id/iv_weather_container_ll").click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.findElementById("com.updrv.lifecalendar:id/aqi_relative")
				.click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		int connectionstate = driver.getNetworkConnection().value;

		if (connectionstate == 1) {
			System.out.println("��ǰ����״̬Ϊ����ģʽ");
		} else if (connectionstate == 2) {
			System.out.println("��ǰ����״̬ΪWiFiģʽ");
			boolean aqi = driver.findElementById(
					"com.updrv.lifecalendar:id/weather_poly_scroll")
					.isDisplayed();

			Assert.assertTrue(aqi);
		} else if (connectionstate == 4) {
			System.out.println("��ǰ����״̬Ϊ�ƶ�����ģʽ");
			boolean aqi = driver.findElementById(
					"com.updrv.lifecalendar:id/weather_poly_scroll")
					.isDisplayed();

			Assert.assertTrue(aqi);
		} else {
			System.out.println("������������");
		}
		
	}
	@After
	public void teardown(){
		driver.quit();
	}
}
