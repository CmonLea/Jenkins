
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.StartsActivity;

public class TestCreateRecordings {
	public AppiumDriver<AndroidElement> driver;

//��ȡ�������ڵķ���
public void getdate() throws Exception{
	
	int startx1,endx1,startx2,endx2,startx3,endx3;
	int starty1,starty2,starty3,endy1,endy2,endy3;
	int duration1=(int)(500*Math.random()+600);
	int duration2=(int)(500*Math.random()+1500);
	int duration3=(int)(800*Math.random()+500);
	startx1=endx1=driver.manage().window().getSize().getWidth()*1/6;
	startx2=endx2= driver.manage().window().getSize().getWidth()*1/2;
	startx3=endx3=driver.manage().window().getSize().getWidth()*5/6;
	
	int datawindows_size=driver.findElementById("com.updrv.lifecalendar:id/year").getSize().getHeight();
	
	if(datawindows_size==292){
	//��������
	starty1=(int)(driver.manage().window().getSize().getHeight()*(0.3*Math.random()+0.62));
	starty2=(int)(driver.manage().window().getSize().getHeight()*(0.3*Math.random()+0.62));
	starty3=(int)(driver.manage().window().getSize().getHeight()*(0.3*Math.random()+0.62));
	endy1=(int)(driver.manage().window().getSize().getHeight()*(0.3*Math.random()+0.62));
	endy2=(int)(driver.manage().window().getSize().getHeight()*(0.3*Math.random()+0.62));
	endy3=(int)(driver.manage().window().getSize().getHeight()*(0.3*Math.random()+0.62));
	//ѡ�����   
	driver.swipe( startx1, starty1, endx1, endy1,duration1);
	//ѡ���·�
	driver.swipe(startx2, starty2, endx2, endy2, duration2);
	//ѡ������
	driver.swipe(startx3, starty3, endx3, endy3, duration3);
	
	
	}
	else if(datawindows_size==160){
    //��С��Ĵ���
	
	starty1=(int)(driver.manage().window().getSize().getHeight()*(0.16*Math.random()+0.76));
	starty2=(int)(driver.manage().window().getSize().getHeight()*(0.16*Math.random()+0.76));
	starty3=(int)(driver.manage().window().getSize().getHeight()*(0.16*Math.random()+0.76));
	endy1=(int)(driver.manage().window().getSize().getHeight()*(0.16*Math.random()+0.76));
	endy2=(int)(driver.manage().window().getSize().getHeight()*(0.16*Math.random()+0.76));
	endy3=(int)(driver.manage().window().getSize().getHeight()*(0.16*Math.random()+0.76));
	//ѡ�����   
	driver.swipe( startx1, starty1, endx1, endy1,duration1);
	//ѡ���·�
	driver.swipe(startx2, starty2, endx2, endy2, duration2);
	//ѡ������
	driver.swipe(startx3, starty3, endx3, endy3, duration3);
	}
	Thread.sleep(3000);
	WebElement btn_datetime_sure=driver.findElementById("com.updrv.lifecalendar:id/btn_datetime_sure");
	btn_datetime_sure.click();
	  System.out.println("�����������");  
}

//��ȡ����ʱ��ķ���
public void getRemind_time() throws Exception{
			//��������ʱ��
	WebElement time_type=driver.findElementById("com.updrv.lifecalendar:id/time_type");
	time_type.click();
	int datawindows_size=driver.findElementById("com.updrv.lifecalendar:id/mins").getSize().getHeight();
 
   //�������ڴ�С	
	int startx1,endx1,startx2,endx2;
	int starty1,starty2,endy1,endy2;
	int duration1=(int)(500*Math.random()+800);
	int duration2=(int)(500*Math.random()+1500);
if(datawindows_size==292){
	startx1=endx1=driver.manage().window().getSize().getWidth()*1/4;
	startx2=endx2= driver.manage().window().getSize().getWidth()*3/4;
	starty1=(int)(driver.manage().window().getSize().getHeight()*(0.3*Math.random()+0.371875));
	starty2=(int)(driver.manage().window().getSize().getHeight()*(0.3*Math.random()+0.371875));
	
	endy1=(int)(driver.manage().window().getSize().getHeight()*(0.3*Math.random()+0.371875));
	endy2=(int)(driver.manage().window().getSize().getHeight()*(0.3*Math.random()+0.371875));	
	//ѡ��ʱ�� 
	try {
		driver.swipe( startx1, starty1, endx1, endy1,duration1);
		//ѡ�����
		driver.swipe(startx2, starty2, endx2, endy2, duration2);
	} catch (Exception e) {
		// TODO �Զ����ɵ� catch ��
		e.printStackTrace();
		 System.out.println("����ʶ�����");  
	}
   }
else if(datawindows_size==160){		
		startx1=endx1=driver.manage().window().getSize().getWidth()*1/4;
		startx2=endx2= driver.manage().window().getSize().getWidth()*3/4;
		   
		starty1=(int)(driver.manage().window().getSize().getHeight()*(0.2*Math.random()+0.441));
		starty2=(int)(driver.manage().window().getSize().getHeight()*(0.2*Math.random()+0.441));
		
		endy1=(int)(driver.manage().window().getSize().getHeight()*(0.2*Math.random()+0.441));
		endy2=(int)(driver.manage().window().getSize().getHeight()*(0.2*Math.random()+0.441));
		//ѡ��ʱ�� 
		try {
			driver.swipe( startx1, starty1, endx1, endy1,duration1);
			//ѡ�����
			driver.swipe(startx2, starty2, endx2, endy2, duration2);
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
			 System.out.println("����ʶ�����");  
		}
   }

	Thread.sleep(3000);
			
	WebElement btn_datetime_sure=driver.findElementById("com.updrv.lifecalendar:id/btn_datetime_sure");
	btn_datetime_sure.click();
	  System.out.println("��������ʱ�����");  
	  
}	

//��ȡʱ�����ķ���
public void gettimespan(){
	
	 WebElement record_datetime=driver.findElementById("com.updrv.lifecalendar:id/record_datetime");
	 record_datetime.click();
	int datawindows_size=driver.findElementById("com.updrv.lifecalendar:id/hour").getSize().getHeight();
	  
	   //�������ڴ�С	
		int startx1,endx1;
		int starty1,endy1;
		int duration1=(int)(500*Math.random()+1800);
	if(datawindows_size==292){
		startx1=endx1=driver.manage().window().getSize().getWidth()* 1/2; 
		starty1=(int)(driver.manage().window().getSize().getHeight()*(45/96+(9/96*Math.random())));
		endy1=(int)(driver.manage().window().getSize().getHeight()*(45/96+(9/96*Math.random())));
		//ѡ��ʱ�� 
		try {
			driver.swipe( startx1, starty1, endx1, endy1,duration1);
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
			  System.out.println("����ʶ�����");  
		}
	   }
	else if(datawindows_size==160){
			startx1=endx1=driver.manage().window().getSize().getWidth()* 1/2;
			starty1=(int)(driver.manage().window().getSize().getHeight()*(0.15*Math.random()+0.45));
			endy1=(int)(driver.manage().window().getSize().getHeight()*(0.15*Math.random()+0.45));
			//ѡ��ʱ�� 
			try {
				driver.swipe( startx1, starty1, endx1, endy1,duration1);
			} catch (Exception e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
				 System.out.println("����ʶ�����");  
			}

	   }
	 WebElement btn_datetime_sure=driver.findElementById("com.updrv.lifecalendar:id/btn_datetime_sure");
	 btn_datetime_sure.click();
	  System.out.println("����ʱ�����");  
}

//����һ����ȡ����Ƶ�ʵķ���

public void gettime_remind_frequency() throws Exception{
	//�������Ƶ��
	WebElement every_type=driver.findElementById("com.updrv.lifecalendar:id/every_type");
	every_type.click();
	//��ȡ����Ƶ�������б�
	List<AndroidElement> dialog_listview=driver.findElementsByClassName("android.widget.RelativeLayout");

    int index_frequency=(int)(6*Math.random());
	//int index_frequency=4;
	dialog_listview.get(index_frequency).click();
	if(index_frequency==0){
		System.out.println("����Ƶ��Ϊ������һ��");
		//�����������
		WebElement date_type=driver.findElementById("com.updrv.lifecalendar:id/date_type");
	   date_type.click();
	   //��ȡ��������
	   System.out.println("����������������...");
	   getdate();
	   //��ȡ����ʱ��
	 
	  System.out.println("������������ʱ��...");  
	 getRemind_time();
	}
	else if(index_frequency==1){
		System.out.println("����Ƶ��Ϊÿ��");
		//��������ʱ�䷽��
		 System.out.println("������������ʱ��...");  
		getRemind_time();

	}
	else if(index_frequency==2){
		System.out.println("����Ƶ��Ϊÿ��");
		//--------------------��ȡÿ���е�ĳһ�����------------------------
		//��������������ÿ��
		  System.out.println("����ѡ������...");  
		 WebElement date_type_week=driver.findElementById("com.updrv.lifecalendar:id/date_type");
	     date_type_week.click();
	     //��ȡ�ܵ�����
	     List<AndroidElement> week_type_list=driver.findElementsByClassName("android.widget.RelativeLayout");
	     int loop=(int)(7*Math.random());
	     for(int j=0;j<=loop;j++){
	    int index_week=(int)(7*Math.random());
	     week_type_list.get(index_week).click();
	     }
	     WebElement btn_datetime_sure=driver.findElementById("com.updrv.lifecalendar:id/btn_datetime_sure");
	     btn_datetime_sure.click();
	     System.out.println("�����������");  
	     //��ȡ����ʱ��
	     System.out.println("������������ʱ��...");  
		getRemind_time();
	}
	else if(index_frequency==3){
		System.out.println("����Ƶ��Ϊÿ��");
		//��ȡ����ʱ�����ÿ��--------------------------------
		 WebElement date_type_month=driver.findElementById("com.updrv.lifecalendar:id/date_type");
	     date_type_month.click();
	     
	     int datawindows_size=driver.findElementById("com.updrv.lifecalendar:id/hour").getSize().getHeight();
	     //�������ڴ�С	
	  	int startx1,endx1;
	  	int starty1,endy1;
	  	int duration1=(int)(500*Math.random()+800);
	    System.out.println("��������ÿ������ʱ��...");  
	  if(datawindows_size==292){
	  	startx1=endx1=(int)(driver.manage().window().getSize().getWidth()*0.5);
	  	starty1=(int)(driver.manage().window().getSize().getHeight()*(0.3*Math.random()+0.371875));
	  	endy1=(int)(driver.manage().window().getSize().getHeight()*(0.3*Math.random()+0.371875));
	  	//ѡ��ʱ�� 
	  	driver.swipe( startx1, starty1, endx1, endy1,duration1);
	     }
	  else if(datawindows_size==160){
	  		startx1=endx1=(int)(driver.manage().window().getSize().getWidth()* 0.5);
	  		starty1=(int)(driver.manage().window().getSize().getHeight()*(0.2*Math.random()+0.441));
	  		endy1=(int)(driver.manage().window().getSize().getHeight()*(0.2*Math.random()+0.441));
	  		driver.swipe( startx1, starty1, endx1, endy1,duration1);
	     }

	  WebElement btn_datetime_sure=driver.findElementById("com.updrv.lifecalendar:id/btn_datetime_sure");
	btn_datetime_sure.click();
	  System.out.println("����ÿ������ʱ�����");  
	//��ȡ�����������ÿ��--------------------------------
	//��ȡ����ʱ��
		getRemind_time();
	}
	else if(index_frequency==4){
		System.out.println("����Ƶ��Ϊÿ��");
		//�����·ݼ����ڣ����������������ÿ��-------------------------------
		WebElement btn_date_type=driver.findElementById("com.updrv.lifecalendar:id/date_type");
		btn_date_type.click();
		int startx1,endx1,startx2,endx2;
		int starty1,starty2,endy1,endy2;
		int duration1=(int)(500*Math.random()+600);
		int duration2=(int)(500*Math.random()+1500);
		startx1=endx1=driver.manage().window().getSize().getWidth()*1/4;
		startx2=endx2= driver.manage().window().getSize().getWidth()*3/4;
		
		starty1=(int)(driver.manage().window().getSize().getHeight()*(0.16*Math.random()+0.76));
		starty2=(int)(driver.manage().window().getSize().getHeight()*(0.16*Math.random()+0.76));
		
		endy1=(int)(driver.manage().window().getSize().getHeight()*(0.16*Math.random()+0.76));
		endy2=(int)(driver.manage().window().getSize().getHeight()*(0.16*Math.random()+0.76));
		  System.out.println("��������ÿ����������...");  
		int datawindows_size=driver.findElementById("com.updrv.lifecalendar:id/month").getSize().getHeight();
		if(datawindows_size==292){
		//��������			
		//ѡ���·� 
		driver.swipe( startx1, starty1, endx1, endy1,duration1);
		//ѡ������
		driver.swipe(startx2, starty2, endx2, endy2, duration2);
		
		}
		else if(datawindows_size==160){	
		//ѡ���·�
		driver.swipe( startx1, starty1, endx1, endy1,duration1);
		//ѡ������
		driver.swipe(startx2, starty2, endx2, endy2, duration2);
	
		}
		WebElement btn_datetime_sure=driver.findElementById("com.updrv.lifecalendar:id/btn_datetime_sure");
		btn_datetime_sure.click();
		  System.out.println("����ÿ�������������");  
		//�����·ݼ����ڣ����������������ÿ��-------------------------------
		
		//��ȡ����ʱ��
		  System.out.println("������������ʱ��...");  
		getRemind_time();
	}else if(index_frequency==5){
		System.out.println("����Ƶ��Ϊÿʱ��");
		//������������
		WebElement create_date1=driver.findElementById("com.updrv.lifecalendar:id/date_type");
		create_date1.click();
		  System.out.println("��������ÿʱ����������...");  
		getdate();
//		�������Ѽ������
		  System.out.println("��������ÿʱ������ʱ����...");  
		gettimespan();
		//��������ʱ�䷽��
		  System.out.println("������������ʱ��...");  
		getRemind_time();
	}
	WebElement finish1=driver.findElementById("com.updrv.lifecalendar:id/txt_title_finish");
	finish1.click();
	
}
public void alarmclock() throws Exception{
	
	WebElement alarm_type=driver.findElementById("com.updrv.lifecalendar:id/alarm_type");
	alarm_type.click();
	
	List<AndroidElement> ring_list_type=driver.findElementsByClassName("android.widget.RelativeLayout");
 //  int index_ring_list=(int)(4*Math.random());
   int index_ring_list=3;//ѡ����������
	//ѡ��һ���������
	ring_list_type.get(index_ring_list).click();
	
	//List<AndroidElement> ring_list=driver.findElementsByClassName("android.widget.RelativeLayout");
	int startx,starty, endx, endy, duration;
	startx=endx=driver.findElementByClassName("android.widget.ListView").getSize().getWidth()*1/2;
	starty=(int)(driver.findElementByClassName("android.widget.ListView").getSize().getHeight());
	endy=(int)(driver.findElementByClassName("android.widget.ListView").getSize().getHeight()*1/10);
		
		duration=(int)(Math.random()*1500+500);
		
		driver.swipe(startx, starty, endx, endy, duration);
		Thread.sleep(1000);
	    
		//����1
		List<AndroidElement> ListView=driver.findElementsByXPath("//android.widget.ListView/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView");
		System.out.println(ListView.size());
		int ring_index=(int)(Math.random()*10);
		System.out.println(ring_index);
		String TextName=ListView.get(ring_index).getText();
		System.out.println(TextName);
		driver.scrollToExact(TextName).click();
			WebElement lay_add_recordthing=driver.findElementById("com.updrv.lifecalendar:id/lay_add_recordthing");
			lay_add_recordthing.click();
			  System.out.println("�����������");  
	}

@Before
public void setUp() throws Exception{
	//�������Գ���·��
//		File classpathRoot = new File(System.getProperty("user.dir"));
//		File appDir = new File(classpathRoot, "apps");
//		File app = new File(appDir, "LifeCalendar.apk");
		//���������豸��Ϣ
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName","honami");
		capabilities.setCapability("platformVersion", "4.4");
		//capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("unicodeKeyboard","ture");
		capabilities.setCapability("resetKeyboard","ture");
		capabilities.setCapability("noReset","ture");
		
		//�������Գ��������activity
		capabilities.setCapability("appPackage", "com.updrv.lifecalendar");
		capabilities.setCapability("appActivity", ".activity.MainActivity");
		//��ʼ������Զ�����ӵ�ַ
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
}

@After
public void teardown(){
	driver.quit();
}
@Test
public void createnotes() throws Exception {
	for(int i=1;i<=5;i++){
	System.out.println("��ǰΪ��"+i+"��ѭ��");
	System.out.println("===================================================");
	((StartsActivity) driver).startActivity("com.updrv.lifecalendar", ".activity.recordthing.RecordThingNewPageActivity");
	WebElement title=driver.findElementById("com.updrv.lifecalendar:id/et_recordthing_title");
	title.sendKeys("����");
	WebElement content=driver.findElementById("com.updrv.lifecalendar:id/et_recordthing_content");
	content.sendKeys("���������ķ��ɽ�ɫ");
	WebElement create_date=driver.findElementById("com.updrv.lifecalendar:id/lin_recordthing_create_date");
	create_date.click();
Thread.sleep(3000);
//��������
System.out.println("������Ӽ�������...");
getdate();
driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

WebElement reminder_type=driver.findElementById("com.updrv.lifecalendar:id/reminder_type");
reminder_type.click();

List<AndroidElement> reminder_type_list=driver.findElementsByClassName("android.widget.RelativeLayout");
//int index=2;
int index=(int)(3*Math.random());
reminder_type_list.get(index).click();

String note_way=driver.findElementById("com.updrv.lifecalendar:id/note_way").getText();
if(note_way.contains("������")){
	System.out.println("��������Ϊ������");
	WebElement finish1=driver.findElementById("com.updrv.lifecalendar:id/txt_title_finish");
	finish1.click();
	
}else if(note_way.contains("״̬������")){
	System.out.println("��������Ϊ״̬������");
	gettime_remind_frequency();
}
else{
	System.out.println("��������Ϊ��������");
	//�����ӷ���
	  System.out.println("������������...");  
	alarmclock();
	gettime_remind_frequency();
}
}

}
}
