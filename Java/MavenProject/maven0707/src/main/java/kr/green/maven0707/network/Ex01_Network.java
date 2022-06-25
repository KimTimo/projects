package kr.green.maven0707.network;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Ex01_Network {
	public static void main(String[] args) {
		try {
			InetAddress ip = InetAddress.getByName("www.naver.com");
			System.out.println(ip);
			System.out.println(ip.getHostName());
			System.out.println(ip.getHostAddress());
			System.out.println( Arrays.toString(ip.getAddress()));
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			InetAddress[] ipArray = InetAddress.getAllByName("naver.com");
			for(InetAddress address : ipArray) {
				System.out.println(address);
			}
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("내 정보");
			InetAddress myIp = InetAddress.getLocalHost();
			System.out.println(myIp);
			System.out.println(myIp.getHostName());
			System.out.println(myIp.getHostAddress());
			System.out.println(InetAddress.getLoopbackAddress());
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}
}
