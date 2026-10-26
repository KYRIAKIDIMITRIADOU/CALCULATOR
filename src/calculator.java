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
    JTextField textfield = new JTextField();
    JPanel panel;
    Font myFont = new Font("Ink Free", Font.BOLD, 20);

    Calculator() {
        //Στήσιμο Παραθύρου
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 600);
        frame.setLayout(null);
        
        textfield = new JTextField();
        textfield.setBounds(20, 20, 395, 50);
        textfield.setFont(myFont);
        textfield.setEditable(false);

    // Κατασκευαστής για τα Βασικά Κουμπιά & Αριθμούς
    public Calculator() {
        frame.setSize(420, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Ρύθμιση οθόνης
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


public static double eval(final String str) {
    return new Object() {
        int pos = -1, ch;

        void nextChar() {
            ch = (++pos < str.length()) ? str.charAt(pos) : -1;
        }

        boolean eat(int charToEat) {
            while (ch == ' ') nextChar();
            if (ch == charToEat) {
                nextChar();
                return true;
            }
            return false;
        }

        double parse() {
            nextChar();
            double x = parseExpression();
            if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char) ch);
            return x;
        }

        double parseExpression() {
            double x = parseTerm();
            for (; ; ) {
                if (eat('+')) x += parseTerm(); // Πρόσθεση
                else if (eat('-')) x -= parseTerm(); // Αφαίρεση
                else return x;
            }
        }

        double parseTerm() {
            double x = parseFactor();
            for (; ; ) {
                if (eat('*')) x *= parseFactor(); // Πολλαπλασιασμός
                else if (eat('/')) x /= parseFactor(); // Διαίρεση
                else return x;
            }

        }
    }.parse();
    }
}