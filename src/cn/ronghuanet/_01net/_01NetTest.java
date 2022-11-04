package cn.ronghuanet._01net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class _01NetTest {
	
	public static void main(String[] args) throws Exception {
//		static InetAddress getLocalHost()		--	返回本地主机IP  
		InetAddress ip1 = InetAddress.getLocalHost();
		System.out.println(ip1);
//		static InetAddress getByName(String host)	--	根据主机名或域名获取IP
		InetAddress ip2 = InetAddress.getByName("WIN-PEIFH9MF5RO");
		System.out.println(ip2);
//		static InetAddress getByAddress(byte[] addr)--	根据一个ip地址获得一个IP地址对象
		InetAddress byAddress = InetAddress.getByAddress(new byte[]{(byte)192,(byte)168,(byte)3,(byte)229});
		System.out.println(byAddress);
//		boolean isReachable(int timeout)	--	测试是否能在指定时间内连通该地址 （类似ping）14.215.177.38
		System.out.println(ip1.isReachable(5000));
	}
}
