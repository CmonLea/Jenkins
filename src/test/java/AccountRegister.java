package com.appium.test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.StartsActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
public class AccountRegister {
	//������������
	public AppiumDriver<AndroidElement> driver;
	String substr0="@";
	String substr1=GetRadom.getCharAccount((int) (3+Math.random()*3));
	String substr2=".gmail";
	String user_name1="δ��¼";
	String user_name2="";
	String pass_word="";
	String confirm_password=pass_word;
	String email="";
	//�����û�����������ʽ�����ж�������û����Ƿ���Ϲ����û����Ĺ���Ϊ��6-16λ��ĸ���߻����������
	String usernamerex="[0-9a-zA-Z]{6,16}";
	//�������뼰ȷ�������������ʽ
	String passwordrex="[0-9a-zA-Z]{6,16}";
	//���������ʽ��������ʽ
	String emailrex="\\w+@\\w+(\\.\\w+)*\\.\\w+";
	//��������Ϊ�ո��������ʽ
	String blankrex="\\p{Blank}+";

	//��junit setUp()�����г�ʼ��������Ϣ
	@Before
public void setUp() throws Exception {

	//�������Գ���·��
	File classpathRoot = new File(System.getProperty("user.dir"));
	File appDir = new File(classpathRoot, "../../../apps");
	File app = new File(appDir, "LifeCalendar.apk");
	//���������豸��Ϣ
	DesiredCapabilities capabilities = new DesiredCapabilities();
	capabilities.setCapability("deviceName","honami");
	capabilities.setCapability("platformVersion", "4.4");
	capabilities.setCapability("app", app.getAbsolutePath());
	//�������Գ��������activity
	capabilities.setCapability("appPackage", "com.updrv.lifecalendar");
	capabilities.setCapability("appActivity", ".activity.MainActivity");
	//��ʼ������Զ�����ӵ�ַ
	driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}
	/*===================================����һ����ȡ����û����ķ���==============================*/
	
static class GetRadom{
		
public static String getCharAccount(int length) {
		String account="";
		Random random = new Random();
			
		  for (int i = 0; i <=length; i++) {
		   // �����ĸ��������
		   String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num"; 
		   // �ַ���
		   if ("char".equalsIgnoreCase(charOrNum)) {
		    // ȡ�ô�д��ĸ����Сд��ĸ
		    int choice = random.nextInt(2) % 2 == 0 ? 65 : 97; 
		    account += (char) (choice + random.nextInt(26));
		   
		   } else if ("num".equalsIgnoreCase(charOrNum)) { // ����
		    account += String.valueOf(random.nextInt(10));
		 
		   }
		  
		  }
		  return account;
	}
		 }
	/*======================����һ����ȡ����û����ķ���==========================*/
	
	//�Զ���һ���û����������ж��û�����ע����Ϣ
class UserNameData{
		//�Զ���һ���ļ���ȡ����
public void readFile(String fileName,String string) {
		ArrayList<String> list = new ArrayList<>();
		try {
			//����Filereader���������ȡ�ļ�
			FileReader fr = new FileReader(new File("username.txt")); 
			//����BufferReader������ȡReader�����fr
			BufferedReader bufr = new BufferedReader(fr);
			String s = null; 
			//���ж�ȡ�ļ�����ַ���
			while ((s = bufr.readLine()) != null) {
				String str = s;
				//���ַ����洢��list������
				list.add(str);
			}
			//��������ַ����β���list��������ַ����Ƚ�
			boolean Isequal = compare(list, string);
			if (Isequal) {
				System.out.println( "�û����ѱ�ע��");
				//driver.close();
			}else {
				System.out.println("������֤�����Ƿ�ע��...... ");
				Thread.sleep(1000);
				new EmailData().readFile("emaildata.txt", email);
				
		bufr.close(); 
		fr.close(); 
			}

		}
		catch (Exception e1) { 
			e1.printStackTrace();
		}
	}
		//�Զ���ıȽϷ���
	public boolean compare(ArrayList<String> list2, String string) {
		boolean flag = false;
		//����list����
		for (int i = 0; i < list2.size(); i++) {
			if (list2.get(i).equals(string)) {
				return true;
			}
		}
		return flag;
	}
	}
	//�Զ���һ���ж������Ƿ�ע����࣬ͬ�û����ж�
class EmailData{
public void readFile(String fileName,String string) {
			ArrayList<String> list = new ArrayList<>();
			try {
				File file=new File("emaildata.txt");
				FileReader fr = new FileReader(file); 
				BufferedReader bufr = new BufferedReader(fr);
				String s = null; 
				while ((s = bufr.readLine()) != null) {
					String str = s;
					list.add(str);
				}
				boolean Isequal = compare(list, string);
				if (Isequal) {
					System.out.println( "�����ѱ�ע�ᣡ");
					//driver.close();
				}else {
					System.out.println("������֤�Ƿ�ע��ɹ�...... ");
					Thread.sleep(3000);
					String getUser0=driver.findElement(By.id("com.updrv.lifecalendar:id/tv_personal_account_user_name")).getText();
					if(getUser0.equals(user_name2)){
			        System.out.println("ע��ɹ�!"+"�û���Ϊ��"+user_name2+"����Ϊ��"+pass_word+"����Ϊ��"+email);
			     
			    	}
			    	else{
			    		if(getUser0.equals(user_name2)==false)
			    		System.out.println("ע��ʧ��");
			    	}
				}
			bufr.close(); 
			fr.close(); 
			} 
				catch (Exception e1) { 
				e1.printStackTrace();
			}
		}	
public boolean compare(ArrayList<String> list2, String string){
			boolean flag = false;
			for (int i = 0; i < list2.size(); i++) {
				if (list2.get(i).equals(string)) {
					return true;
				}
			}
			return flag;
		}
		}
	@Test
	//��������
public void TestRegister() throws Exception{
		//�ж��Ƿ�Ϊ��¼״̬
for(int i=1;i<=5;i++){	  
			
			substr1=GetRadom.getCharAccount((int) (3+Math.random()*3));
			user_name2=GetRadom.getCharAccount((int)(5+(Math.random())*12));
			 pass_word=GetRadom.getCharAccount((int)((5+Math.random()*12)));
			 confirm_password=pass_word;
			 email=GetRadom.getCharAccount(6)+substr0+substr1+substr2;
			 
			 
			
	System.out.println("*==============================��ǰΪ��"+i+"��ѭ��============================*");
			
		WebElement d = driver.findElement(By.
				id("com.updrv.lifecalendar:id/lin_menu_main_personal_account"));
		d.click();//�������û������,�����������ֻ�
		String getUser=driver.findElement(By.
				id("com.updrv.lifecalendar:id/tv_personal_account_user_name")).
				getText();//�����������ֻ�
		//�û�δ��¼ֱ�ӽ���ע��ҳ���¼
		if(getUser.equals(user_name1)){
			System.out.println("�û�δ��¼����ע��ҳ��");
		WebElement e = driver.findElement(By.
					id("com.updrv.lifecalendar:id/account_linear"));
	    	e.click();
	    	WebElement e4 = driver.findElement(By.
	    			id("com.updrv.lifecalendar:id/tv_register"));
	    	e4.click();
	    	Thread.sleep(500);
	    	//��ʼ����¼״̬
	    	String user_name0=driver.findElement(By.
	    			id("com.updrv.lifecalendar:id/user_name")).
	    			getText();
	    	String pass_word0=driver.findElement(By.
	    			id("com.updrv.lifecalendar:id/user_pwd")).
	    			getText();
	    	String confirm_password0=driver.findElement(By.
	    			id("com.updrv.lifecalendar:id/user_pwd_ok")).
	    			getText();
	    	
	    	String email0=driver.findElement(By.
	    			id("com.updrv.lifecalendar:id/email")).
	    			getText();
	    	
	    	List<AndroidElement> textFieldsList1 = driver.
	    			findElementsByClassName("android.widget.EditText");	
	    	textFieldsList1.get(0).sendKeys(user_name2);
	    	textFieldsList1.get(1).sendKeys(pass_word);
	    	textFieldsList1.get(2).sendKeys(confirm_password);
	    	textFieldsList1.get(3).sendKeys(email);

	    	//ִ��ע��
	    	WebElement e5 = driver.findElement(By.
	    			id("com.updrv.lifecalendar:id/btn_register"));
	    	e5.click();   
	    	
	    	if(user_name2.equals(user_name0)||user_name2.matches(blankrex)||user_name2.equals("")){
	    		//��ʾ�û���Ϊ��
	    		
	    	System.out.println("�û�������Ϊ�գ�����������");
	    	driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
	    	((StartsActivity) driver).startActivity("com.updrv.lifecalendar", ".activity.MainActivity");
	    	}
	    	else {
	    		System.out.println("�û�����Ϊ�գ����ڼ�������Ƿ�Ϊ��...");
	    		//��������Ƿ�Ϊ��
	    		if(pass_word.equals(pass_word0)||pass_word.matches(blankrex)||pass_word.equals("")){
	    			//��ʾ����Ϊ��
	    			System.out.println("����Ϊ��,���������룡");
	    			driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
	    			((StartsActivity) driver).startActivity("com.updrv.lifecalendar", ".activity.MainActivity");
	    		}
	    		else {
	    				//���ȷ�������Ƿ�Ϊ��
	    				
	    				System.out.println("���벻Ϊ�գ����ڼ��ȷ�������Ƿ�Ϊ��...");
	    				
	    				if(confirm_password.equals(confirm_password0)||confirm_password.matches(blankrex)||confirm_password.equals("")){
	    					//��ʾȷ������Ϊ��
	    					System.out.println("ȷ������Ϊ�գ�����������");
	    					driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
	    					((StartsActivity) driver).startActivity("com.updrv.lifecalendar", ".activity.MainActivity");
	    				}
	    				//ȷ�����벻Ϊ��
	    					else {
	    						//��������Ƿ�Ϊ��
	    						System.out.println("ȷ�����벻Ϊ�գ����ڼ�������Ƿ�Ϊ��...");
	    						if(email.equals(email0)||email.matches(blankrex)||email.equals("")){
	    							//��ʾ����Ϊ��
	    							System.out.println("����Ϊ�գ�����������");
	    							driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
	    							((StartsActivity) driver).startActivity("com.updrv.lifecalendar", ".activity.MainActivity");
	    						}
	    						//���䲻Ϊ��
	    						else{
	    							System.out.println("���䲻Ϊ�գ�����û��������롢ȷ�����롢�������...");
	    							System.out.println("/*===========================�û��������롢ȷ�����롢��������ж�=============================*/")	;					
	    							
	    							//�ж��û��������롢��������Լ��Ƿ�ע��
	    							if(user_name2.matches(usernamerex)){
	    								System.out.println("�û����Ϸ����ж������Ƿ�Ϸ�");
	    								if(pass_word.matches(passwordrex)){
	    									System.out.println("����Ϸ����ж�ȷ�������Ƿ�һ��");
	    									if(confirm_password.matches(pass_word)){
	    									
	    									System.out.println("ȷ������һ�£��ж������Ƿ�Ϸ�");
	    									if(email.matches(emailrex)){
	    										System.out.println("����Ϸ������ڼ���û����������Ƿ�ע��......");
	    										new UserNameData().readFile("username.txt", user_name2);
	    										}
	    									else{
	    										System.out.println("���䲻�Ϸ�������������");
	    										driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
	    										((StartsActivity) driver).startActivity("com.updrv.lifecalendar", ".activity.MainActivity");
	    						
	    									}
	    									
	    									}
	    									else{
	    										System.out.println("ȷ�����������벻һ�£�����������");
	    										driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
	    										((StartsActivity) driver).startActivity("com.updrv.lifecalendar", ".activity.MainActivity");
	    										
	    									}
	    								}
	    								else{
	    									System.out.println("����Ϊ6-16λӢ����ĸ�����������������");
	    									driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
	    									((StartsActivity) driver).startActivity("com.updrv.lifecalendar", ".activity.MainActivity");
	    									
	    								}
	    								
	    							}
	    							else{
	    								System.out.println("�û���Ϊ6-16λӢ����ĸ�����������������");
	    								driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
	    								((StartsActivity) driver).startActivity("com.updrv.lifecalendar", ".activity.MainActivity");
	    							}
	    						}
	    					
	    					}
	    				}
	    			}
	    	Thread.sleep(500);	
	  System.out.println("*======================���Խ���====================================*");
	    	Thread.sleep(500);
		}
		//�û��ѵ�¼�˳���¼�ٽ���ע��
		else{
			System.out.println("�û��ѵ�¼�˳���¼�ٽ���ע��ҳ��");
			WebElement e = driver.findElement(By.
					id("com.updrv.lifecalendar:id/account_linear"));
	    	e.click();
	    	WebElement e1 = driver.findElement(By.
	    			id("com.updrv.lifecalendar:id/account_linear"));
	    	e1.click();
	    	List<AndroidElement> textFieldsList = driver.findElementsByClassName("android.widget.RelativeLayout");
	    	textFieldsList.get(4).click();
	    	WebElement e2 = driver.findElement(By.id("com.updrv.lifecalendar:id/dialog_text2"));
	    	e2.click();
	    	WebElement e3 = driver.findElement(By.id("com.updrv.lifecalendar:id/account_linear"));
	    	e3.click();
	    	WebElement e4 = driver.findElement(By.id("com.updrv.lifecalendar:id/tv_register"));
	    	e4.click();
	    	
	    	
	    	//��ʼ����¼״̬
	    	String user_name0=driver.findElement(By.
	    			id("com.updrv.lifecalendar:id/user_name")).
	    			getText();
	    	String pass_word0=driver.findElement(By.
	    			id("com.updrv.lifecalendar:id/user_pwd")).
	    			getText();
	    	String confirm_password0=driver.findElement(By.
	    			id("com.updrv.lifecalendar:id/user_pwd_ok")).
	    			getText();
	    	
	    	String email0=driver.findElement(By.
	    			id("com.updrv.lifecalendar:id/email")).
	    			getText();
	    	//
	    	
	    	
	    	List<AndroidElement> textFieldsList1 = driver.findElementsByClassName("android.widget.EditText");
	    	
	    	textFieldsList1.get(0).sendKeys(user_name2);
	    	textFieldsList1.get(1).sendKeys(pass_word);
	    	textFieldsList1.get(2).sendKeys(confirm_password);
	    	textFieldsList1.get(3).sendKeys(email);
	    	WebElement e5 = driver.findElement(By.id("com.updrv.lifecalendar:id/btn_register"));
	    	e5.click();
	    	

		if(user_name2.equals(user_name0)||user_name2.matches(blankrex)||user_name2.equals("")){    		
	    	System.out.println("�û�������Ϊ�գ�����������");
	    	((StartsActivity) driver).startActivity("com.updrv.lifecalendar", ".activity.MainActivity");
	    	}
	    	else {
	    		System.out.println("�û�����Ϊ�գ����ڼ�������Ƿ�Ϊ��...");
	    		//��������Ƿ�Ϊ��
	    		if(pass_word.equals(pass_word0)||pass_word.matches(blankrex)||pass_word.equals("")){
	    			//��ʾ����Ϊ��
	    			System.out.println("����Ϊ��,���������룡");
	    			((StartsActivity) driver).startActivity("com.updrv.lifecalendar", ".activity.MainActivity");
	    		}    		
	    		else {
	    				//���ȷ�������Ƿ�Ϊ��
	    				
	    				System.out.println("���벻Ϊ�գ����ڼ��ȷ�������Ƿ�Ϊ��...");
	    				
	    				if(confirm_password.equals(confirm_password0)||confirm_password.matches(blankrex)||confirm_password.equals("")){
	    					//��ʾȷ������Ϊ��
	    					System.out.println("ȷ������Ϊ�գ�����������");
	    					((StartsActivity) driver).startActivity("com.updrv.lifecalendar", ".activity.MainActivity");
	    				}
	    				//ȷ�����벻Ϊ��
	    					else {
	    						//��������Ƿ�Ϊ��
	    						System.out.println("ȷ�����벻Ϊ�գ����ڼ�������Ƿ�Ϊ��...");
	    						if(email.equals(email0)||email.matches(blankrex)||email.equals("")){
	    							//��ʾ����Ϊ��
	    							System.out.println("����Ϊ�գ�����������");
	    							((StartsActivity) driver).startActivity("com.updrv.lifecalendar", ".activity.MainActivity");
	    						}
	    						//���䲻Ϊ��
	    						else{
	    							System.out.println("���䲻Ϊ�գ�����û��������롢ȷ�����롢�������...");
	    		/*===========================�û��������롢ȷ�����롢��������ж�=============================*/					
	    							
	    							//�ж��û��������롢��������Լ��Ƿ�ע��
	    							if(user_name2.matches(usernamerex)){
	    								System.out.println("�û����Ϸ����ж������Ƿ�Ϸ�");
	    								if(pass_word.matches(passwordrex)){
	    									System.out.println("����Ϸ����ж�ȷ�������Ƿ�һ��");
	    									if(confirm_password.matches(pass_word)){
	    									System.out.println("ȷ������һ�£��ж������Ƿ�Ϸ�");
	    									if(email.matches(emailrex)){
	    										System.out.println("����Ϸ������ڼ���û����������Ƿ�ע��......");
	    										new UserNameData().readFile("username.txt", user_name2);
	    										}
	    									else{
	    										System.out.println("���䲻�Ϸ�������������");
	    										//driver.closeApp();
	    									}
	    									
	    									}
	    									else{
	    										System.out.println("ȷ�����������벻һ�£�����������");
	    										//driver.closeApp();
	    									}
	    								}
	    								else{
	    									System.out.println("����Ϊ6-16λӢ����ĸ�����������������");
	    									//driver.closeApp();
	    								}
	    								
	    							}
	    							else{
	    								System.out.println("�û���Ϊ6-16λӢ����ĸ�����������������");
	    								//driver.closeApp();
	    							}
	    						}
	    					
	    					}
	    				}
	    			}
	    System.out.println("*======================���Խ���====================================*");
		}
	}
}
	//��������
	@After
	public void tearDown() throws Exception {
	    
		driver.closeApp();
	}
	

	
}
