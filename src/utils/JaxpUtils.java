package utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

//操作XML文件的方法
public class JaxpUtils {
	
	static String path ;
	
	static{
		path = JaxpUtils.class.getClassLoader().getResource("users.xml").getPath() ;
	}
	
	public static Document getDocument(){
		//创建一个dom4j解析器
		try {
			SAXReader reader = new SAXReader() ;
			Document document = reader.read(path) ;
			return document ;
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null ;
	}
	
	public static void write2xml(Document document){
		try {
			XMLWriter writer = new XMLWriter(new FileOutputStream(path), OutputFormat.createPrettyPrint()) ;
			writer.write(document) ;
			writer.close() ;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
