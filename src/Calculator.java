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


    //Βασικά Κουμπιά & Αριθμοί
    JButton[] numberButtons = new JButton[10];
    JButton addButton, subButton, mulButton, divButton, decButton;

        // Επιστημονικά Κουμπιά & Έλεγχος
    JButton[] functionButtons = new JButton[16];
    JButton equButton, delButton, clrButton, negButton;
    JButton cosButton, sinButton, tanButton, logButton;
    JButton piButton, sqrtButton, powButton;


    Calculator() {
        // Στήσιμο Παραθύρου
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 600);
        frame.setLayout(null);

        textfield = new JTextField();
        textfield.setBounds(20, 20, 395, 50);
        textfield.setFont(myFont);
        textfield.setEditable(false);

        //Αρχικοποίηση Βασικών Κουμπιών
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");

        for (int i = 0; i < 10; ++i) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        // Αρχικοποίηση Επιστημονικών & Styling
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");
        negButton = new JButton("(-)");
        cosButton = new JButton("cos");
        sinButton = new JButton("sin");
        tanButton = new JButton("tan");
        logButton = new JButton("log");
        piButton = new JButton("pi");
        sqrtButton = new JButton("sqrt");
        powButton = new JButton("^");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;
        functionButtons[9] = cosButton;
        functionButtons[10] = sinButton;
        functionButtons[11] = tanButton;
        functionButtons[12] = logButton;
        functionButtons[13] = piButton;
        functionButtons[14] = sqrtButton;
        functionButtons[15] = powButton;

        Color purpleColor = new Color(128, 0, 128);

        for (int i = 0; i < 16; ++i) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
            functionButtons[i].setBackground(purpleColor);
            functionButtons[i].setForeground(Color.WHITE);
        }

        // Στήσιμο Panel & Εμφάνιση
        panel = new JPanel();
        panel.setBounds(20, 80, 395, 400);
        panel.setLayout(new GridLayout(5, 5, 10, 10));
        panel.setBackground(Color.LIGHT_GRAY);

        panel.add(sinButton);
        panel.add(cosButton);
        panel.add(tanButton);
        panel.add(logButton);
        panel.add(piButton);
        panel.add(sqrtButton);
        panel.add(powButton);
        panel.add(delButton);
        panel.add(clrButton);
        panel.add(divButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(negButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(addButton);
        panel.add(numberButtons[0]);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(decButton);

        frame.add(panel);
        frame.add(textfield);
        equButton.setBounds(20, 490, 395, 50);
        frame.add(equButton);
        frame.setVisible(true);
    }
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            // Λογική Αριθμών & Βασικών Πράξεων
            for (int i = 0; i < 10; ++i) {
                if (e.getSource() == numberButtons[i]) {
                    textfield.setText(textfield.getText().concat(String.valueOf(i)));
                    return;
                }
            }
            if (e.getSource() == decButton) {
                textfield.setText(textfield.getText().concat("."));
            }

            else if (e.getSource() == addButton || e.getSource() == subButton ||
                    e.getSource() == mulButton || e.getSource() == divButton || e.getSource() == powButton) {
                textfield.setText(textfield.getText().concat(command));
            }
    //  Λογική Επιστημονικών & Ελέγχου
                else if (e.getSource() == piButton) {
        textfield.setText(textfield.getText().concat(String.valueOf(Math.PI)));
    }
        else if (e.getSource() == cosButton || e.getSource() == sinButton ||
            e.getSource() == tanButton || e.getSource() == logButton || e.getSource() == sqrtButton) {
        textfield.setText(textfield.getText().concat(command));
    }
        else if (e.getSource() == negButton) {
        textfield.setText(textfield.getText().concat("-"));
    }
        else if (e.getSource() == clrButton) {
        textfield.setText("");
    }
        else if (e.getSource() == delButton) {
        String string = textfield.getText();
        if (string.length() > 0) {
            textfield.setText(string.substring(0, string.length() - 1));
        }
    }

    // Κουμπί '=' και Integration
                    else if (e.getSource() == equButton) {
        try {
            double result = eval(textfield.getText());
            textfield.setText(String.valueOf(result));
        } catch (Exception ex) {
            textfield.setText("Error");
        }
    }

}
        // Βασικός Parser & Προτεραιότητα Πράξεων
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
            if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
            return x;
        }

        double parseExpression() {
            double x = parseTerm();
            for (;;) {
                if      (eat('+')) x += parseTerm(); // Πρόσθεση
                else if (eat('-')) x -= parseTerm(); // Αφαίρεση
                else return x;
            }
        }

        double parseTerm() {
            double x = parseFactor();
            for (;;) {
                if      (eat('*')) x *= parseFactor(); // Πολλαπλασιασμός
                else if (eat('/')) x /= parseFactor(); // Διαίρεση
                else return x;
            }
        }
        // ΚΩΔΙΚΑΣ ΑΤΟΜΟΥ 5: Προχωρημένος Parser (Math, Παρενθέσεις) task2-3
        double parseFactor() {
            if (eat('+')) return parseFactor(); // Μοναδιαίο συν
            if (eat('-')) return -parseFactor(); // Μοναδιαίο πλην

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
            
            if (eat('^')) x = Math.pow(x, parseFactor()); // Ύψωση σε δύναμη
            return x;
        }
        
    }.parse();
}
}
public static void main(String[] args) {
    Calculator calc = new Calculator();
}



        









