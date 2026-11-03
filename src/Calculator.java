public class Calculator {
    // Κατασκευαστής για τα Βασικά Κουμπιά & Αριθμούς (@ccts!)
    public Calculator() {
        frame.setSize(420, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Ρύθμιση πεδίου κειμένου (οθόνης)
        textfield.setBounds(30, 25, 340, 50);
        textfield.setFont(myFont);
        textfield.setEditable(false);
        frame.add(textfield);

        // Task 1: Αρχικοποίηση των numberButtons[10] με for-loop και ActionListener
        JButton[] numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(myFont);
            numberButtons[i].addActionListener(this);
        }

        // Task 2: Αρχικοποίηση των βασικών πράξεων (+, -, *, /, .)
        JButton addButton = new JButton("+");
        JButton subButton = new JButton("-");
        JButton mulButton = new JButton("*");
        JButton divButton = new JButton("/");
        JButton decButton = new JButton(".");

        JButton[] functionButtons = {addButton, subButton, mulButton, divButton, decButton};
        for (JButton btn : functionButtons) {
            btn.setFont(myFont);
            btn.addActionListener(this);
        }

        // Τοποθέτηση κουμπιών αριθμών (0-9)
        int[][] coords = {
                {30, 320}, // 0
                {30, 250}, {110, 250}, {190, 250}, // 1, 2, 3
                {30, 180}, {110, 180}, {190, 180}, // 4, 5, 6
                {30, 110}, {110, 110}, {190, 110}  // 7, 8, 9
        };

        for (int i = 0; i <= 9; i++) {
            numberButtons[i].setBounds(coords[i][0], coords[i][1], 70, 50);
            frame.add(numberButtons[i]);
        }

        // Τοποθέτηση βασικών πράξεων
        decButton.setBounds(110, 320, 70, 50);
        addButton.setBounds(270, 250, 70, 50);
        subButton.setBounds(270, 180, 70, 50);
        mulButton.setBounds(270, 110, 70, 50);
        divButton.setBounds(270, 320, 70, 50);

        frame.add(decButton);
        frame.add(addButton);
        frame.add(subButton);
        frame.add(mulButton);
        frame.add(divButton);

        frame.setVisible(true);
    }

    // Task 3: Συγγραφή της λογικής στην actionPerformed για νούμερα και πράξεις
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        // Όταν πατιέται οποιοδήποτε κουμπί (νούμερο ή πράξη), προστίθεται στην οθόνη
        textfield.setText(textfield.getText() + command);
    }
}
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
        
// Επιστημονικά Κουμπιά & Έλεγχος
JButton[] functionButtons = new JButton[16];
        JButton equButton, delButton, clrButton, negButton;
        JButton cosButton, sinButton, tanButton, logButton;
        JButton piButton, sqrtButton, powButton;
// 
