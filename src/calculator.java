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


    JButton equButton, delButton, clrButton;
    JButton cosButton, sinButton, tanButton, logButton;
    JButton piButton, sqrtButton, powButton;

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

        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");
        cosButton = new JButton("cos");
        sinButton = new JButton("sin");
        tanButton = new JButton("tan");
        logButton = new JButton("log");
        piButton = new JButton("pi");
        sqrtButton = new JButton("sqrt");
        powButton = new JButton("^");

        JButton[] sciButtons = {equButton, delButton, clrButton, cosButton, sinButton, tanButton, logButton, piButton, sqrtButton, powButton};
        for (JButton btn : sciButtons) {
            btn.setFont(new Font("Ink Free", Font.BOLD, 14)); // Λίγο μικρότερη γραμματοσειρά για να χωράνε τα ονόματα
            btn.addActionListener(this);
            btn.setBackground(new Color(128, 0, 128)); // Μωβ χρώμα για να ξεχωρίζουν
            btn.setForeground(Color.WHITE);
            frame.add(btn);
        }

        // Τοποθέτηση στο κάτω μέρος της οθόνης
        delButton.setBounds(30, 390, 100, 50);
        clrButton.setBounds(150, 390, 100, 50);
        equButton.setBounds(270, 390, 70, 50);

        sinButton.setBounds(30, 460, 70, 50);
        cosButton.setBounds(110, 460, 70, 50);
        tanButton.setBounds(190, 460, 70, 50);
        piButton.setBounds(270, 460, 70, 50);

        logButton.setBounds(30, 520, 70, 50);
        sqrtButton.setBounds(110, 520, 70, 50);
        powButton.setBounds(190, 520, 70, 50);

        frame.setVisible(true);
    }

    // Task 3: Συγγραφή της λογικής στην actionPerformed για νούμερα και πράξεις
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        // Όταν πατιέται οποιοδήποτε κουμπί (νούμερο ή πράξη), προστίθεται στην οθόνη
        if (e.getSource() == clrButton) {
            textfield.setText("");
        } else if (e.getSource() == delButton) {
            String string = textfield.getText();
            if (string.length() > 0) {
                textfield.setText(string.substring(0, string.length() - 1));
            }
        } else if (e.getSource() == equButton) {
            try {
                // Καλεί τον parser για να κάνει την πράξη
                double result = eval(textfield.getText());
                textfield.setText(String.valueOf(result));
            } catch (Exception ex) {
                textfield.setText("Error");
            }
        } else if (e.getSource() == piButton) {
            textfield.setText(textfield.getText() + Math.PI);
        } else {
            // Για όλα τα υπόλοιπα (αριθμοί, +, -, sin, cos κλπ) απλά τα προσθέτει στην οθόνη
            textfield.setText(textfield.getText() + command);
        }
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
        // --- ΠΡΟΣΘΗΚΗ: Ο parser για τις επιστημονικές λειτουργίες ---
        double parseFactor() {
            if (eat('+')) return parseFactor();
            if (eat('-')) return -parseFactor();

            double x;
            int startPos = this.pos;
            if (eat('(')) {
                x = parseExpression();
                eat(')');
            } else if ((ch >= '0' && ch <= '9') || ch == '.') {
                while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                x = Double.parseDouble(str.substring(startPos, this.pos));
            } else if (ch >= 'a' && ch <= 'z') {
                while (ch >= 'a' && ch <= 'z') nextChar();
                String func = str.substring(startPos, this.pos);
                x = parseFactor();
                if (func.equals("sqrt")) x = Math.sqrt(x);
                else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                else if (func.equals("log")) x = Math.log10(x);
                else throw new RuntimeException("Unknown function: " + func);
            } else {
                throw new RuntimeException("Unexpected: " + (char)ch);
            }

            if (eat('^')) x = Math.pow(x, parseFactor());
            return x;
        }
    }.parse();
    }
    public static void main(String[] args) {
        new Calculator();
    }
}