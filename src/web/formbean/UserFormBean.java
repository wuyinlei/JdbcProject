package web.formbean;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

//此bean专门用来封装页面的数据
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
	
	//服务端验证
	public boolean validate(){
		//验证用户名
		if(username == "" || username == null){
			errors.put("username", "用户名不能为空") ;
		}else{
			if(username.length() > 8 || username.length() < 3){
				errors.put("username", "用户名长度必须在3~8位之间") ;
			}
		}
		
		//验证密码
		if(password == "" || password == null){
			errors.put("password", "密码不能为空") ;
		}else{
			if(password.length() > 8 || password.length() < 3){
				errors.put("password", "密码长度必须在3~8位之间") ;
			}
		}
		
		if(!repassword.equals(password)){
			errors.put("password", "两次密码输入不一致") ;
		}
		
		//验证邮箱
		if(email == "" || email == null){
			errors.put("email", "邮箱不能为空") ;
		}else{
			if(!email.matches("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$")) 
				errors.put("email", "邮箱格式不正确") ;
		}
		
		//验证生日
		if(birthday == "" || birthday == null){
			errors.put("birthday", "生日不能为空") ;
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
				errors.put("birthday", "日期格式错误") ;
			}
		}
		
		return errors.isEmpty() ;
	}
}
