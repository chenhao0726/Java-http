package cn.ronghuanet._01net;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.IOUtils;

public class _02URL {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		URL url = new URL("https://www.baidu.com/");// 403禁止访问
		FileOutputStream os = new FileOutputStream("D:\\豆瓣.html");
		InputStream input = url.openStream();
		IOUtils.copy(input, os);// 文件下载
		// 关流
		input.close();
		os.close();
		
	}
}
