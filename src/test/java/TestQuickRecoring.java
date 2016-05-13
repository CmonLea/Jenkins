import io.appium.java_client.android.AndroidDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;


public class TestQuickRecoring {
	AndroidDriver<WebElement> driver;

	@Before
	public void setUp() throws Exception{
		DesiredCapabilities capabilities=new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Coolpad8670");
		capabilities.setCapability("platformVersion", "4.4.2");
		capabilities.setCapability("noReset","ture");
		capabilities.setCapability("appPackage", "com.updrv.lifecalendar");
		capabilities.setCapability("appActivity", ".activity.MainActivity");
		capabilities.setCapability("unicodeKeyboard","ture");
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}

	@Test
	public void ��ݼ���Ӽ���() {
		String str = "ȥ�ɣ�Ƥ����";
		driver.findElementById("com.updrv.lifecalendar:id/iv_menu_main_middle")
				.click();
		driver.findElementById("com.updrv.lifecalendar:id/tv_record_event_ll")
				.click();
		driver.findElementById("com.updrv.lifecalendar:id/et_recordthing_title")
				.sendKeys(str);
		driver.findElementById("com.updrv.lifecalendar:id/txt_title_finish")
				.click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		String str1 = driver.findElementById(
				"com.updrv.lifecalendar:id/tv_recordthing_item_title")
				.getText();
//		System.out.println(str1);
		if (str1.equals(str)) {
			System.out.println("�ڼ����б���ʾ���Ϊ��true");
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			driver.findElementById(
					"com.updrv.lifecalendar:id/lin_menu_main_calendar").click();

			if (driver.findElementById("com.updrv.lifecalendar:id/tt_title_tv")
					.getText().equals(str1)) {

				System.out.println("�������·���ʾ�����true");
				System.out.println("����ִ�н��Ϊ��true");
			} else if(str1.equals(str) == false) {
			
			System.out.println("�ڼ����б���ʾ���Ϊ��false");
		} 
		}
	
	}
	
	@After
	public void teardown(){
		driver.quit();
	}
}
