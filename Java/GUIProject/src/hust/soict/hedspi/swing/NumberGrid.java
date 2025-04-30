package hust.soict.hedspi.swing;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class NumberGrid extends JFrame{
	private JButton[] btnNumbers = new JButton[10];
	private JButton btnDelete, btnReset;
	private JTextField tfDisplay;
	public NumberGrid() {
        tfDisplay = new JTextField();
        tfDisplay.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        
        JPanel panelButtons = new JPanel(new GridLayout(4, 3));
        addButtons(panelButtons);

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(tfDisplay, BorderLayout.NORTH);
        cp.add(panelButtons, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Number Grid");
        setSize(200, 200);
        setVisible(true);
    }
	private void addButtons(JPanel panel) {
        ButtonListener btnListener = new ButtonListener();

        for (int i = 1; i <= 9; i++) {
            btnNumbers[i] = new JButton(String.valueOf(i));
            panel.add(btnNumbers[i]);
            btnNumbers[i].addActionListener(btnListener);
        }

        btnReset = new JButton("C");
        panel.add(btnReset);
        btnReset.addActionListener(btnListener);

        btnNumbers[0] = new JButton("0");
        panel.add(btnNumbers[0]);
        btnNumbers[0].addActionListener(btnListener);

        btnDelete = new JButton("DEL");
        panel.add(btnDelete);
        btnDelete.addActionListener(btnListener);
    }
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String button = e.getActionCommand();
			if (button.charAt(0) >= '0' && button.charAt(0) <= '9')
				tfDisplay.setText(tfDisplay.getText() + button);
			else if (button.equals("DEL")) {
				try {
					int len = tfDisplay.getText().length();
					tfDisplay.setText(tfDisplay.getText(0, len - 1));
				}
				catch (Exception err) {
					return;					
				}
			}
			else if (button.equals("C")){
				tfDisplay.setText("");
			}
		}
	}
}
