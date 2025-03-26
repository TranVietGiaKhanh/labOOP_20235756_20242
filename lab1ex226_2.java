import java.util.Scanner;

public class lab1ex226_2 {
	public static void main(String args[]) {
		Scanner sc=new Scanner (System.in);
		double a11=sc.nextDouble();
		double a12=sc.nextDouble();
		double b1=sc.nextDouble();
		double a21=sc.nextDouble();
		double a22=sc.nextDouble();
		double b2=sc.nextDouble();
		double d = a11 * a22 - a12 * a21;
		if (d==0) {
			if (a11/a21 == a12/a22 && a12/a22 == b1/b2) {
				System.out.print("inf root");
			}
			else {
				System.out.print("no root");
			}
		}
		else {
			double d1=b1*a22-b2*a12;
			double d2=a11*b2-a21*b1;
			System.out.print(d1/d +" "+ d2/d);
		}
	}
}
