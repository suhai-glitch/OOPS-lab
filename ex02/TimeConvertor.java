package time; import java.util.*;
import java.text.DecimalFormat; 
Class TimeConvertor
{
double hour,minute,second;
Scanner sc = new Scanner(System.in); 
DecimalFormat f = new DecimalFormat("##.###"); 
public convertHourToMinute()
{
System.out.println("Enter the Hour"); 
hour = sc.nextFloat();
minute = hour * 60;
System.out.println("Minutes : "+f.format(minute));
}
public convertMinuteToHour()
{
System.out.println("Enter the Minute"); 
minute = sc.nextFloat();
hour = minute / 60;
System.out.println("Hours : "+f.format(hour));
}
public convertHourToSeconds()
{
System.out.println("Enter the Hour"); 
hour = sc.nextFloat();
second = hour * 3600; 
System.out.println("Seconds : "+f.format(second));
}
public convertSecondsToHour()
{
System.out.println("Enter the Seconds"); 
second = sc.nextFloat();
hour = second / 3600; 
System.out.println("Hours : "+f.format(hour));
}
}
