import javax.swing.JOptionPane;

public class lab1ex225 {
    public static void main(String[] args) {
        String strNum1, strNum2, strNum3;
        strNum1 = JOptionPane.showInputDialog(null, "Please enter the first number: ", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
        double num1 = Double.parseDouble(strNum1);
        strNum2 = JOptionPane.showInputDialog(null, "Please enter the second number: ", "Input the second number", JOptionPane.INFORMATION_MESSAGE);
        double num2 = Double.parseDouble(strNum2);
        strNum3 = JOptionPane.showInputDialog(null, "Select the calculation (sum ,difference, product, quotient): ", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
        switch (strNum3){
        case "sum":
            JOptionPane.showMessageDialog(null, num1 + num2, "Sum of two numbers", JOptionPane.INFORMATION_MESSAGE);
            break;
        case "difference":
            JOptionPane.showMessageDialog(null, num1 - num2, "Difference of two numbers", JOptionPane.INFORMATION_MESSAGE);
            break;
        case "product":
            JOptionPane.showMessageDialog(null, num1 * num2, "Product of two numbers", JOptionPane.INFORMATION_MESSAGE);
            break;
        case "quotient":
            JOptionPane.showMessageDialog(null, num1 / num2, "Quotient of two numbers", JOptionPane.INFORMATION_MESSAGE);
            break;
        }
        System.exit(0);
    }
}
