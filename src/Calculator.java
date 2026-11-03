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

functionButtons[0] = addButton; functionButtons[1] = subButton;
functionButtons[2] = mulButton; functionButtons[3] = divButton;
functionButtons[4] = decButton; functionButtons[5] = equButton;
functionButtons[6] = delButton; functionButtons[7] = clrButton;
functionButtons[8] = negButton; functionButtons[9] = cosButton;
functionButtons[10] = sinButton; functionButtons[11] = tanButton;
functionButtons[12] = logButton; functionButtons[13] = piButton;
functionButtons[14] = sqrtButton; functionButtons[15] = powButton;

Color purpleColor = new Color(128, 0, 128);

        for (int i = 0; i < 16; ++i) {
functionButtons[i].addActionListener(this);
functionButtons[i].setFont(myFont);
functionButtons[i].setFocusable(false);
functionButtons[i].setBackground(purpleColor);
functionButtons[i].setForeground(Color.WHITE);
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
// 