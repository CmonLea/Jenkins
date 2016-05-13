import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;


public class TestTongzhilan {
   AndroidDriver<AndroidElement> driver;
	@Before
	
	public void setUp() throws Exception{
//		File classpathRoot = new File(System.getProperty("user.dir"));
//		File appDir = new File(classpathRoot, "apps");
//		File app = new File(appDir, "LifeCalendar.apk");
		//���������豸��Ϣ
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName","Coolpad8670");
		capabilities.setCapability("platformVersion", "4.4");
		//capabilities.setCapability("app", app.getAbsolutePath());
		//capabilities.setCapability("unicodeKeyboard","ture");
		capabilities.setCapability("resetKeyboard","ture");
		capabilities.setCapability("noReset","ture");
		
		//�������Գ��������activity
		capabilities.setCapability("appPackage", "com.updrv.lifecalendar");
		capabilities.setCapability("appActivity", ".activity.MainActivity");
		//��ʼ������Զ�����ӵ�ַ
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}
	
	@Test
	public void tongzhilan() throws Exception{
		driver.startActivity("com.updrv.lifecalendar", ".activity.syssetting.SystemSettingActivity ");
		AndroidElement notifacation=driver.
				findElementById("com.updrv.lifecalendar:id/notifactionSet");
		notifacation.click();
		String notifacation_weather=driver.
				findElementById("com.updrv.lifecalendar:id/weather_box").getAttribute("checked");
		String notifacation_date=driver.
				findElementById("com.updrv.lifecalendar:id/week_box").getAttribute("checked");

		if(notifacation_weather.equals("true")
				&&notifacation_date.equals("true"))
		{
			
			System.out.println("֪ͨ������������Ϊ����״̬");
			driver.openNotifications();
			Thread.sleep(2000);
			Assert.assertTrue(driver.findElementById("com.updrv.lifecalendar:id/week_name_1").isDisplayed());
			Assert.assertTrue(driver.findElementById("com.updrv.lifecalendar:id/weather_icon").isDisplayed());

		}
	else if(notifacation_weather.equals("true")
				&&notifacation_date.equals("false"))
		{
			
			System.out.println("֪ͨ����������״̬������δ��ʾ��֪ͨ��");
			driver.openNotifications();
			Thread.sleep(2000);
			Assert.assertTrue(driver.findElementById("com.updrv.lifecalendar:id/weather_icon").isDisplayed());
		}
		else if(notifacation_weather.equals("false")
				&&notifacation_date.equals("true"))
		{
			System.out.println("֪ͨ��δ��ʾ��������ʾ������");
			driver.openNotifications();
			Thread.sleep(2000);
			Assert.assertTrue(driver.findElementById("com.updrv.lifecalendar:id/week_name_1").isDisplayed());
			
		}else if(notifacation_weather.equals("false")
				&&notifacation_date.equals("false"))
		{
			System.out.println("֪ͨ��û����ʾ����������");
		}
		
	}
	@After
	public void teardown(){
		driver.quit();
	}
}
