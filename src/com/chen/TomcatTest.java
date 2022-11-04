package com.chen;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TomcatTest {
    ServerSocket serverSocket;
    // 构造器中初始化服务器的套接字
    public TomcatTest() {
        try {
            serverSocket = new ServerSocket(8088);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void start() throws IOException {
        System.out.println("服务器开启，等待连接....");
        while (true) {
            // 监听客户端的访问
            Socket socket = serverSocket.accept();

            // 获取请求头
            InputStream inputStream = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(inputStream);
            System.out.println("浏览器请求成功！");
            BufferedReader br = new BufferedReader(isr);
            System.out.println("-------------");
            String readLine = br.readLine();
            String filePath = "log";
            System.out.println("readLine:"+readLine);
            String[] split = readLine.split(" ");
            if (split[1].endsWith("html")) {
                filePath += split[1];
            }
            System.out.println("请求路径为" + filePath);
            System.out.println("-------------");
            // 发送响应请求

            // 打印消息

            // 创建输出流
            OutputStream outputStream = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(outputStream, "UTF-8");
            PrintWriter pw = new PrintWriter(osw, true);

            // 创建输入流：根据用户的访问找到服务器中的资源，用流的方式写出去
            File file = new File("D:\\idea-workspace\\Java-html\\web\\one.html");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            // 设置相应请求头
            pw.println("http1.1 200 OK");
            pw.println("Content-Type: text/html;charset=UTF-8");
            pw.println();

            // 相应内容
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                pw.println(line);
            }

            // 关流
            pw.close();
            bufferedReader.close();
        }
    }

    public static void main(String[] args) {
        TomcatTest tomcatTest = new TomcatTest();
        try {
            tomcatTest.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
