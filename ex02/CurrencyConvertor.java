package currency; import java.util.*;
import java.text.DecimalFormat; 
Class CurrencyConvertor
{
double rupee,dollar,euro,yen;
Scanner sc = new Scanner(System.in); 
DecimalFormat f = new DecimalFormat("##.###"); 
public convertInrToEuro()
{
System.out.println("Enter amount in rupees"); 
rupee = sc.nextFloat();
euro = rupee / 80;
System.out.println("Euro : "+f.format(euro));
}
public convertEuroToInr()
{
System.out.println("Enter amount in Euro"); 
euro = sc.nextFloat();
rupee = euro * 80;
System.out.println("Rupees : "+f.format(rupee));
}
public convertInrToDollar()
{
System.out.println("Enter amount in rupees"); 
rupee = sc.nextFloat();
dollar = rupee / 66;
System.out.println("Dollar : "+f.format(dollar));
}
public convertDollarToInr()
{
System.out.println("Enter amount in Dollar"); 
dollar = sc.nextFloat();
rupee = dollar * 66;
System.out.println("Rupees : "+f.format(rupee))
}
public convertInrToYen()
{
System.out.println("Enter amount in rupees"); 
rupee = sc.nextFloat();
yen = rupee / 0.61; System.out.println("Yen : "+f.format(yen));
}
public convertYenToInr()
{
System.out.println("Enter amount in Yen"); 
euro = sc.nextFloat();
rupee = yen * 0.61;
System.out.println("Rupees : "+f.format(rupee));
}
}
