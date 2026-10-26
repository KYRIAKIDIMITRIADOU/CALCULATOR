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