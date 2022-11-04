package cn.ronghuanet._02socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	// 申明一个serverSocket对象
	ServerSocket serverSocket;
	// 使用构造方法初始化serverSocket对象
	public Server() throws IOException{
		System.out.println("初始化服务端.....");
		serverSocket = new ServerSocket(8088);
		System.out.println("初始化服务端完成.....");
	}
	public static void main(String[] args) throws IOException {
		Server server = new Server();
		server.start(); // 启动服务
	}
	private void start() throws IOException {
		System.out.println("等待客户端链接........");
		// 启动服务器段的监听
		Socket socket = serverSocket.accept();
		
		// 获取客户端ip
		String hostAddress = socket.getInetAddress().getHostAddress();
		System.out.println("有人来了ip是：" + hostAddress);
		
		InputStream in = socket.getInputStream();
		InputStreamReader reader = new InputStreamReader(in,"UTF-8");
		BufferedReader br = new BufferedReader(reader);
		
		String readLine = br.readLine();
//		System.out.println("客户端说：" + readLine);
		
		
	}
}
