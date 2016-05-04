import io.appium.java_client.android.AndroidDriver;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;


public class DayLifeTakePicture {
	 AndroidDriver<WebElement> driver;
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
		public void daylifetakePicture() throws InterruptedException{
		
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
		driver.findElementById("com.updrv.lifecalendar:id/iv_camera").click();
		
		Assert.assertEquals(driver.findElementById("com.updrv.lifecalendar:id/day_from_album_tv").getText(),"�������ѡ��" );
		Assert.assertEquals(driver.findElementById("com.updrv.lifecalendar:id/day_take_picture_tv").getText(),"����" );
		Assert.assertEquals(driver.findElementById("com.updrv.lifecalendar:id/day_cancel_tv").getText(),"ȡ��");
		int i=(int)(Math.random()*2);
		switch(i){
		case 0:
			System.out.println("�������ڷ�������");
			driver.findElementByName("�������ѡ��").click();
			List<WebElement> xiangce=driver.findElementsByXPath("//android.widget.GridView/android.widget.LinearLayout");
			xiangce.get(0).click();
			
			List<WebElement> zhaopian=driver.findElementsByXPath("//android.widget.GridView/android.widget.RelativeLayout");
			zhaopian.get(0).click();
			driver.findElementById("com.updrv.lifecalendar:id/btn_sure").click();
			driver.findElementById("com.updrv.lifecalendar:id/media_release_desc").sendKeys("VIPABC");
			driver.findElementById("com.updrv.lifecalendar:id/tv_daylife_post_send").click();
			Thread.sleep(2000);
			String content=driver.findElementById("com.updrv.lifecalendar:id/user_content").getText();
			if(content.equals("VIPABC")){
				System.out.println("���ӷ����ɹ�");
			}else{
				System.out.println("���ӷ���ʧ�ܣ�������");
			}
			driver.findElementByName("�ҵ�").click();
			driver.findElementById("com.updrv.lifecalendar:id/lin_personal_account_day_lifte").click();
			driver.findElementById("com.updrv.lifecalendar:id/user_more").click();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			driver.findElementByName("ȷ��").click();
		break;
		
		case 1:
			System.out.println("��������ڷ�������");
		driver.findElementByName("����").click();
		driver.findElementByAccessibilityId("���Ű�ť").click();
		driver.findElementByAccessibilityId("ȷ��").click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElementById("com.updrv.lifecalendar:id/media_release_desc").sendKeys("VIPABC");
		driver.findElementById("com.updrv.lifecalendar:id/tv_daylife_post_send").click();
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		String content1=driver.findElementById("com.updrv.lifecalendar:id/user_content").getText();
		if(content1.equals("VIPABC")){
			System.out.println("���ӷ����ɹ�");
		}else{
			System.out.println("���ӷ���ʧ�ܣ�������");
		}
		driver.findElementByName("�ҵ�").click();
		driver.findElementById("com.updrv.lifecalendar:id/lin_personal_account_day_lifte").click();
		driver.findElementById("com.updrv.lifecalendar:id/user_more").click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElementByName("ȷ��").click();
	break;
		
		}
	
		}
	
	@After
	public void teardown() {
		driver.quit();
	}
}
