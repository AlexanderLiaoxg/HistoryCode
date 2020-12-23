package NetWorkDemo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionDemo {
 public static void main(String[] args) throws Exception {
	       URL myurl = new URL("http://www.baidu.com");
	       //获得URLConnection子类对象
	       URLConnection urlconn = myurl.openConnection();
	       if(urlconn instanceof HttpURLConnection) {
	    	   System.out.println("yes");
	       }
	       //设置请求属性，字符集是UTF-8
	       urlconn.setRequestProperty("Charset", "utf-8");
	       //由URLConnection获取输入流，并构造Buffereader对象
	       BufferedReader br = new BufferedReader(new InputStreamReader(urlconn.getInputStream()));
	       String inputLine;
	       //循环读取并打印数据
	       while((inputLine = br.readLine())!=null) {
	    	   System.out.println(inputLine);
	       }
	       br.close();
	       
	       
	       
	       
	    		   }
}
