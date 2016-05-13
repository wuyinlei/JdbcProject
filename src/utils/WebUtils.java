package utils;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

//专门为页面服务: 封装了页面的信息
public class WebUtils {

	public static <T> T fillFormBean(Class<T> clazz,HttpServletRequest request){
		T t = null ;
		try {
			t = clazz.newInstance() ;
			BeanUtils.populate(t, request.getParameterMap()) ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t ;
	}
}
