package com.chen;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Administrator
 */
public class IpTest {
    public static void main(String[] args) throws IOException {
        // 得到本地主机
        InetAddress host1 = InetAddress.getLocalHost();
        System.out.println(host1);
        // 根据主机名获取IP
        InetAddress chenHao = InetAddress.getByName("DESKTOP-4FFIKGU");
        System.out.println(chenHao);
        // 得到IP地址通过byte数组
        InetAddress byAddress = InetAddress.getByAddress(new byte[]{(byte) 192,(byte) 168,(byte) 3,(byte) 229});
        System.out.println(byAddress);
        System.out.println((byte)192);
        // 测试这个ip是否ping通
        System.out.println(host1.isReachable(5000));

    }
}
