package cn.ronghuanet._03selfclient;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TomcatClient {

	ServerSocket server;
	
	// 熟悉的初始化
	public TomcatClient()  {
		System.out.println("TomcatClient init......");
		try {
			server = new ServerSocket(8090);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("TomcatClient init finish......");
	}
	public static void main(String[] args) throws IOException {
		TomcatClient tomcatClient = new TomcatClient();
		while(true) {
			
			tomcatClient.start();
		}
	}
	public void start() throws IOException {
		// 监听
		Socket socket = server.accept();
		// 吧页面响应到浏览器上
		// 创建了一个 输出流
		OutputStream os = socket.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(os, "utf-8");
		PrintWriter pw = new PrintWriter(osw);
		InetAddress inetAddress = socket.getInetAddress();
		System.out.println("inetAddress:" + inetAddress);
		InetAddress localAddress = socket.getLocalAddress();
		System.out.println("localAddress:" + localAddress);
		// 告诉输出流你要响应给前端 浏览器 的页面是什么
		File file = new File("D:\\0914-java全栈-三期\\EclipseWorkspace\\day33-html\\WebContent\\_04form.html");
		InputStreamReader isr = new InputStreamReader(new FileInputStream(file));
		BufferedReader br = new BufferedReader(isr);
		
		//如何输出到页面呢？设置响应信息 -- 不然就只能输出到控制台或文本中，但是用户就需要在页面中看到内容，所以需要设置响应信息
		pw.println("http1.1 200 OK");//1.设置响应头：协议版本 状态码 状态描述
		pw.println("Content-Type: text/html;charset=UTF-8");//2.设置响应类型和字符编码
//		pw.println("Content-Length: "+file.length());//可以不写
		pw.println();//3.结束头部信息 -- 表示结束头部信息，接下来开始写内容
		
		String len = null;
		while((len= br.readLine())!= null) {
			pw.println(len);
		}
		pw.close();
		br.close();
	}
}
