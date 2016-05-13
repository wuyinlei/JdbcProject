package web.formbean;

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String d = "1993-2-30" ;
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
//		try {
//			sdf.parse(d) ;
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		DateLocaleConverter dlc = new DateLocaleConverter() ;
		try {
			dlc.convert(d) ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
