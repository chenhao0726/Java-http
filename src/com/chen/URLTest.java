package com.chen;

import org.apache.commons.io.IOUtils;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

public class URLTest {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://www.baidu.com/");// 403禁止访问
        FileOutputStream os = new FileOutputStream("D:\\test.html");
        InputStream input = url.openStream();
        IOUtils.copy(input, os);// 文件下载
        // 关流
        input.close();
        os.close();

    }
}
