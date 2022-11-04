package com.chen.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	Socket socket;
	
	// 通过构造函数 初始化客户端
	public Client() throws UnknownHostException, IOException{
		System.out.println("初始化客户端....");
		socket = new Socket("localhost", 8088);
		System.out.println("初始化客户端完成....");
	}

	private void start() throws IOException {
		OutputStream os = socket.getOutputStream();
		OutputStreamWriter ow = new OutputStreamWriter(os);
		PrintWriter printWriter = new PrintWriter(ow, true);
		printWriter.println("服务器你好啊~~~");
	}
	public static void main(String[] args) throws UnknownHostException, IOException {
		Client client = new Client();
		// 启动客户端
		client.start();
	}
}
