package kr.green.maven0629.exam;

public class Ex01 {

	public static void main(String[] args) {
		System.out.println("남은시간 : " + calTime(17, 29, 0) + "초");
		System.out.println("남은시간 : " + calTime(16, 28, 30) + "초");
		long sec = calTime(16, 28, 30);
		long hh = sec/3600;
		long mm = (sec%3600)/60;
		long ss = (sec%3600)%60;
		System.out.println("남은시간 : " + hh + ":" + mm + ":" + ss);
		
	}
	
	public static long calTime(int hh, int mm, int ss) { // 초로 환산하여 계산
		int hour = 17, minute = 30, second = 0;
		return (hour*3600 + minute*60 + second) - (hh*3600 + mm*60 + ss);
	}

}
