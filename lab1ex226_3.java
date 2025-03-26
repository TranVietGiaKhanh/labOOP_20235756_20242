import java.util.Scanner;

public class lab1ex226_3 {
	public static void main (String args[]) {
		Scanner sc=new Scanner (System.in);
		double a=sc.nextDouble();
		double b=sc.nextDouble();
		double c=sc.nextDouble();
		if (a==0) {
			if (b==0) {
				System.out.print("inf solution");
			}
			else {
				System.out.print(-c/b);
			}
		}
		else {
			double del=b*b-4*a*c;
			if (del<0) {
				System.out.print("no real solution");
			}
			if (del==0) {
				System.out.print(-b/(2*a));
			}
			if (del>0) {
				System.out.println((-b-Math.sqrt(del))/(2*a));
				System.out.println((-b+Math.sqrt(del))/(2*a));
			}
		}
	}
}
