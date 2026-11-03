
//  ΚΩΔΙΚΑΣ ΑΤΟΜΟΥ 5: Κουμπί '=' και Integration task1
        else if (e.getSource() == equButton) {
        try {
double result = eval(textfield.getText());
                textfield.setText(String.valueOf(result));
        } catch (Exception ex) {
        textfield.setText("Error");
            }
                    }
                    //ΤΕΛΟΣ ΑΤΟΜΟΥ 5
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
// ΤΕΛΟΣ ΑΤΟΜΟΥ 5