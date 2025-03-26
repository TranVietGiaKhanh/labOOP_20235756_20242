import javax.swing.JOptionPane;

public class ChoosingOption {
    public static void main(String[] args) {
        int option = JOptionPane.showOptionDialog(
                null,
                "Do you want to change the first class ticket?",
                "Confirmation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                null,
                null
        );

        JOptionPane.showMessageDialog(
                null,
                "You have chosen: " + (option == JOptionPane.YES_OPTION ? "Yes" : "No"),
                "Result",
                JOptionPane.INFORMATION_MESSAGE
        );

        System.exit(0);
    }
}
