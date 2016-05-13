package web.formbean;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

//��beanר��������װҳ�������
public class UserFormBean {

	private String username;

	private String password;
	
	private String repassword;

	private String email;

	private String birthday;
	
	private Map<String,String> errors = new HashMap<String,String>() ;

	public Map<String, String> getErrors() {
		return errors;
	}

	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	//�������֤
	public boolean validate(){
		//��֤�û���
		if(username == "" || username == null){
			errors.put("username", "�û�������Ϊ��") ;
		}else{
			if(username.length() > 8 || username.length() < 3){
				errors.put("username", "�û������ȱ�����3~8λ֮��") ;
			}
		}
		
		//��֤����
		if(password == "" || password == null){
			errors.put("password", "���벻��Ϊ��") ;
		}else{
			if(password.length() > 8 || password.length() < 3){
				errors.put("password", "���볤�ȱ�����3~8λ֮��") ;
			}
		}
		
		if(!repassword.equals(password)){
			errors.put("password", "�����������벻һ��") ;
		}
		
		//��֤����
		if(email == "" || email == null){
			errors.put("email", "���䲻��Ϊ��") ;
		}else{
			if(!email.matches("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$")) 
				errors.put("email", "�����ʽ����ȷ") ;
		}
		
		//��֤����
		if(birthday == "" || birthday == null){
			errors.put("birthday", "���ղ���Ϊ��") ;
		}else{
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
//			try {
//				sdf.parse(birthday) ;
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
			DateLocaleConverter dlc = new DateLocaleConverter() ;
			try {
				dlc.convert(birthday) ;
			} catch (Exception e) {
				errors.put("birthday", "���ڸ�ʽ����") ;
			}
		}
		
		return errors.isEmpty() ;
	}
}
