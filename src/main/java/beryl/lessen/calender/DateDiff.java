package beryl.lessen.calender;

import java.util.Date;

public class DateDiff {
	public static void main(String[] args) {
		//初始化时间
		Date a1=new Date("2014/1/11 18:23");
		Date a2=new Date("2014/1/11 3:20");
		//计算他们之间时间差（相差多少毫秒 1000毫秒等于一秒）
		long l=a2.getTime()-a1.getTime();
		//计算相差多少分钟
		int m=(int) (l/1000.0/60);
		//计算相差多少小时
		int h=(int) (l/1000.0/60/60);
		//相差多少小时分钟
		System.out.println(l/1000/60/60+"小时"+l/1000/60%60+"分钟");
	}

}
