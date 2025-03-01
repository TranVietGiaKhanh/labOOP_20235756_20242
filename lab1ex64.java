import java.util.Scanner;

public class lab1ex64 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        
        String[][] mon = {
            {"January", "Jan.", "Jan", "1"},
            {"February", "Feb.", "Feb", "2"},
            {"March", "Mar.", "Mar", "3"},
            {"April", "Apr.", "Apr", "4"},
            {"May", "May", "May", "5"},
            {"June", "Jun.", "Jun", "6"},
            {"July", "Jul.", "Jul", "7"},
            {"August", "Aug.", "Aug", "8"},
            {"September", "Sept.", "Sep", "9"},
            {"October", "Oct.", "Oct", "10"},
            {"November", "Nov.", "Nov", "11"},
            {"December", "Dec.", "Dec", "12"}
        };

        
        int[] common = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] leap = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        
        String inmon = sc.nextLine();
        String inyear = sc.nextLine();
        sc.close(); 

        int month = -1;
        int year = -1;

        
        for (int i = 0; i < mon.length; i++) {
            for (String alias : mon[i]) {
                if (alias.equalsIgnoreCase(inmon)) {
                    month = i;
                    break;
                }
            }
            if (month != -1) break;
        }

        
        try {
            year = Integer.parseInt(inyear);
            if (year < 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            System.out.println("errors");
            return; 
        }

        
        if (month == -1) {
            System.out.println("errors");
            return; 
        }

        
        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        int days = isLeapYear ? leap[month] : common[month];

        
        System.out.println(days);
    }
}
