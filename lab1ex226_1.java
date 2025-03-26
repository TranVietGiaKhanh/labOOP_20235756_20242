import java.util.Scanner;

public class lab1ex226_1 {
	public static void main(String args[]) {
		Scanner sc= new Scanner (System.in);
		double a=sc.nextDouble();
		double b=sc.nextDouble();
		double res;
		int check=1;
		if (a==0) {
			if (b!=0) {
				check=0;
			}
			else {
				check=2;
			}
		}
		res=-b/a;
		switch (check) {
		case 0:
			System.out.print("no root");
			break;
		case 1:
			System.out.print(res);
			break;
		case 2:
			System.out.print("inf root");
			break;
		}
		
	}
}
