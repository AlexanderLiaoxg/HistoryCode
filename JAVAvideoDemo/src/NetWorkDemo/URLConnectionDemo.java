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
	       //���URLConnection�������
	       URLConnection urlconn = myurl.openConnection();
	       if(urlconn instanceof HttpURLConnection) {
	    	   System.out.println("yes");
	       }
	       //�����������ԣ��ַ�����UTF-8
	       urlconn.setRequestProperty("Charset", "utf-8");
	       //��URLConnection��ȡ��������������Buffereader����
	       BufferedReader br = new BufferedReader(new InputStreamReader(urlconn.getInputStream()));
	       String inputLine;
	       //ѭ����ȡ����ӡ����
	       while((inputLine = br.readLine())!=null) {
	    	   System.out.println(inputLine);
	       }
	       br.close();
	       
	       
	       
	       
	    		   }
}
