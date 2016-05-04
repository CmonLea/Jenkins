import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.URL;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;


public class ClickDayRealeaseInfo {
	 AndroidDriver<AndroidElement> driver;
		@Before
		public void setUp() throws Exception{
//			File classpathRoot = new File(System.getProperty("user.dir"));
//			File appDir = new File(classpathRoot, "apps");
//			File app = new File(appDir, "LifeCalendar.apk");
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
		public void DaypageElementDispaly(){
		
		int connectionstate=driver.getNetworkConnection().value;
		
		if(connectionstate==1){
			System.out.println("��ǰ����״̬Ϊ����ģʽ");
		}else if(connectionstate==2){
			System.out.println("��ǰ����״̬ΪWiFiģʽ");
		}else if(connectionstate==4){
			System.out.println("��ǰ����״̬Ϊ�ƶ�����ģʽ");
		}else{
			System.out.println("������������");
		}
		driver.findElementById("com.updrv.lifecalendar:id/tv_menu_main_day_life").click();
		String user_name=driver.findElementById("com.updrv.lifecalendar:id/day_user_name_item").getText();
		driver.findElementById("com.updrv.lifecalendar:id/day_main_rel").click();
		String user_name1=driver.findElementById("com.updrv.lifecalendar:id/day_user_name_item").getText();  
		Assert.assertEquals(user_name1,user_name);		
		
		}
	
		@After
		public void teardown(){
			driver.quit();
		}
}
