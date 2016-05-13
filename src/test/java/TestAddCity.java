import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestAddCity {
	AndroidDriver<WebElement> driver;
	int index;
	@Before
	public void setUp() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Coolpad8670");
		capabilities.setCapability("platformVersion", "4.4.2");
		// capabilities.setCapability("noReset","false");
		capabilities.setCapability("appPackage", "com.updrv.lifecalendar");
		capabilities.setCapability("appActivity", ".activity.MainActivity");
		capabilities.setCapability("unicodeKeyboard", "ture");
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),
				capabilities);
	}

	@Test
	public void selectcity() throws Exception {
        boolean dispaly=driver.findElementById(
				"com.updrv.lifecalendar:id/iv_weather_container_ll").isDisplayed();
		if(dispaly==true){
        driver.findElementById(
				"com.updrv.lifecalendar:id/iv_weather_container_ll").click();
		driver.findElementById("com.updrv.lifecalendar:id/iv_citylist").click();
		
		for (int i = 0; i < 5; i++) {
			System.out.println("----------------------------��ǰΪ��"+i+"��ѭ��----------------------------");
			List<WebElement> list_city = driver
					.findElementsByXPath("//android.widget.ListView/android.widget.FrameLayout");

			System.out.println("����ʱ�Ѵ��ڵĳ������£�");
			// ��ȡ���ǰ�Ѵ��ڵĳ������Ʋ�����list�б�
			List<WebElement> find_city = driver
					.findElementsByXPath("//android.widget.ListView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView");
			// ����Ѵ��ڵĳ�������
			Iterator<WebElement> iterator = find_city.iterator();
			ArrayList<String> arraylist = new ArrayList<String>();
			while (iterator.hasNext()) {
				String exist_citys = iterator.next().getText();
				arraylist.add(exist_citys);
			}
			System.out.println("arraylist=" + arraylist);
			// ��ȡ����
			System.out.println(list_city.size());
			if (list_city.size() == 5) {
				System.out.println("���ֻ�����5������");

			} else if (list_city.size() < 5) {

				// �����Ӱ�ť
				driver.findElementById("com.updrv.lifecalendar:id/lay_save")
						.click();

				List<WebElement> Hot_City_Slot = driver
						.findElementsByXPath("//android.widget.GridView/android.widget.LinearLayout");
				 index = (int) (Math.random() * 30 + 1);
				// ��ȡ������ӳ��е�����
				 System.out.println("index=" + index+",Hot_City_Slot size = "+Hot_City_Slot.size());
				String Being_added_city = Hot_City_Slot
						.get(index)
						.findElement(
								By.id("com.updrv.lifecalendar:id/cityName"))
						.getText();

				// �ж�������ӵĳ��к��Ѵ��ڵ��Ƿ��ظ�
				 System.out.println("Being_added_city==="+Being_added_city);
			
				 if (compareSameCity(arraylist, Being_added_city)) {
					 System.out.println(Being_added_city + "�����");
				}else {
					driver.findElementsByXPath(
							"//android.widget.GridView/android.widget.LinearLayout")
							.get(index).click();
					System.out.println("��ӵĳ���Ϊ��" + Being_added_city);
				
				}
			}
		}
		}
		else if(dispaly==false){
			snapshot(driver,"weather_widget_screenshot.jpg");
		}
	
	}

	@After
	public void teardown() {
		driver.quit();
	}
	
	private boolean compareSameCity(ArrayList<String> list,String city){
		for (int j = 0; j < list.size(); j++) {
			if (list.get(j).contains(city)) {
				return true;
			}
		}
		return false;
	}
	public static void snapshot(TakesScreenshot drivername, String filename) {
        // this method will take screen shot ,require two parameters ,one is
        // driver name, another is file name
 
        String currentPath = System.getProperty("user.dir"); // get current work
                                                                // folder
        File scrFile = drivername.getScreenshotAs(OutputType.FILE);
        // Now you can do whatever you need to do with it, for example copy
        // somewhere
        try {
            System.out.println("��ͼ�����·��Ϊ:" + currentPath + "/"
                    + filename);
            FileUtils
                    .copyFile(scrFile, new File(currentPath + "\\" + filename));
        } catch (IOException e) {
            System.out.println("�޷������ͼ");
            e.printStackTrace();
        } finally {
            System.out.println("��ͼ���, �ļ�λ�� " + currentPath
                    + " �ļ���");
        }
    }
	
	
}
