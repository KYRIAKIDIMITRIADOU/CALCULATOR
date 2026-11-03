import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Calculator implements ActionListener {
    // Βασικά Στοιχεία GUI
    JFrame frame = new JFrame("Scientific Calculator");
    JTextField textfield;
    JPanel panel;
    Font myFont = new Font("Ink Free", Font.BOLD, 20);

    Calculator() {
        // Στήσιμο Παραθύρου
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 600);
        frame.setLayout(null);

        textfield = new JTextField();
        textfield.setBounds(20, 20, 395, 50);
        textfield.setFont(myFont);
        textfield.setEditable(false);

       // Στήσιμο Panel & Εμφάνιση 
        panel = new JPanel();
        panel.setBounds(20, 80, 395, 400);
        panel.setLayout(new GridLayout(5, 5, 10, 10));
        panel.setBackground(Color.LIGHT_GRAY);

        panel.add(sinButton); panel.add(cosButton); panel.add(tanButton);
        panel.add(logButton); panel.add(piButton); panel.add(sqrtButton);
        panel.add(powButton); panel.add(delButton); panel.add(clrButton);
        panel.add(divButton); panel.add(numberButtons[7]); panel.add(numberButtons[8]);
        panel.add(numberButtons[9]); panel.add(mulButton); panel.add(negButton);
        panel.add(numberButtons[4]); panel.add(numberButtons[5]); panel.add(numberButtons[6]);
        panel.add(subButton); panel.add(addButton); panel.add(numberButtons[0]);
        panel.add(numberButtons[1]); panel.add(numberButtons[2]); panel.add(numberButtons[3]);
        panel.add(decButton);

        frame.add(panel);
        frame.add(textfield);
        equButton.setBounds(20, 490, 395, 50);
        frame.add(equButton);
        frame.setVisible(true);
        