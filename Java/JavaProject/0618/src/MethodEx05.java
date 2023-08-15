
public class MethodEx05 {
   public static void main(String[] args) {
      // 다른 클래스의 static메서드를 호출할때는 "클래스이름.메서드명()"으로 호출한다.
      System.out.println(DateUtil.getYear());
      System.out.println(DateUtil.getMonth());
      System.out.println(DateUtil.getDate());
      System.out.println(DateUtil.getToday());
      System.out.println(DateUtil.getTime());
      System.out.println(DateUtil.isLeapYear(DateUtil.getYear()));
      System.out.println(DateUtil.isLeapYear(2020));
      System.out.println(DateUtil.getLastday(2020,2));
      System.out.println(DateUtil.getLastday(2021,2));
      System.out.println(DateUtil.getTotalDay(2021,6, 18));
      System.out.println(DateUtil.getWeekDay(2021,6, 18));
      System.out.println(DateUtil.getWeekDayStr(2021,6, 18));
      DateUtil.viewCalendar(2021, 6);
      // 내년도 달력 전부
      for(int i=1;i<=12;i++) DateUtil.viewCalendar(2022, i);
   }
}