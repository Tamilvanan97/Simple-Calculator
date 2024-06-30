import java.awt.*;
import java.awt.event.*;

public class Calculator extends Frame implements ActionListener {
    TextField tfResult;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;
    Button btnAdd, btnSubtract, btnMultiply, btnDivide, btnEquals, btnClear;
    double num1, num2, result;
    int operator;

    Calculator() {
        // Frame setup
        setTitle("Simple Calculator");
        setSize(300, 300);
        setLayout(null); // Using null layout for simplicity

        // Text field for displaying result
        tfResult = new TextField();
        tfResult.setBounds(50, 50, 200, 30);
        tfResult.setEditable(false);
        add(tfResult);

        // Number buttons
        btn1 = new Button("1");
        btn2 = new Button("2");
        btn3 = new Button("3");
        btn4 = new Button("4");
        btn5 = new Button("5");
        btn6 = new Button("6");
        btn7 = new Button("7");
        btn8 = new Button("8");
        btn9 = new Button("9");
        btn0 = new Button("0");

        btn1.setBounds(50, 100, 50, 30);
        btn2.setBounds(110, 100, 50, 30);
        btn3.setBounds(170, 100, 50, 30);
        btn4.setBounds(50, 140, 50, 30);
        btn5.setBounds(110, 140, 50, 30);
        btn6.setBounds(170, 140, 50, 30);
        btn7.setBounds(50, 180, 50, 30);
        btn8.setBounds(110, 180, 50, 30);
        btn9.setBounds(170, 180, 50, 30);
        btn0.setBounds(110, 220, 50, 30);

        add(btn1);
        add(btn2);
        add(btn3);
        add(btn4);
        add(btn5);
        add(btn6);
        add(btn7);
        add(btn8);
        add(btn9);
        add(btn0);

        // Operator buttons
        btnAdd = new Button("+");
        btnSubtract = new Button("-");
        btnMultiply = new Button("*");
        btnDivide = new Button("/");
        btnEquals = new Button("=");
        btnClear = new Button("C");

        btnAdd.setBounds(230, 100, 50, 30);
        btnSubtract.setBounds(230, 140, 50, 30);
        btnMultiply.setBounds(230, 180, 50, 30);
        btnDivide.setBounds(230, 220, 50, 30);
        btnEquals.setBounds(170, 220, 50, 30);
        btnClear.setBounds(50, 220, 50, 30);

        add(btnAdd);
        add(btnSubtract);
        add(btnMultiply);
        add(btnDivide);
        add(btnEquals);
        add(btnClear);

        // Adding ActionListener to buttons
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);
        btn6.addActionListener(this);
        btn7.addActionListener(this);
        btn8.addActionListener(this);
        btn9.addActionListener(this);
        btn0.addActionListener(this);

        btnAdd.addActionListener(this);
        btnSubtract.addActionListener(this);
        btnMultiply.addActionListener(this);
        btnDivide.addActionListener(this);
        btnEquals.addActionListener(this);
        btnClear.addActionListener(this);

        // Window closing event
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("1") || command.equals("2") || command.equals("3") ||
                command.equals("4") || command.equals("5") || command.equals("6") ||
                command.equals("7") || command.equals("8") || command.equals("9") ||
                command.equals("0")) {
            String currentText = tfResult.getText();
            tfResult.setText(currentText + command);
        } else if (command.equals("+") || command.equals("-") ||
                command.equals("*") || command.equals("/")) {
            num1 = Double.parseDouble(tfResult.getText());
            if (command.equals("+"))
                operator = 1;
            else if (command.equals("-"))
                operator = 2;
            else if (command.equals("*"))
                operator = 3;
            else if (command.equals("/"))
                operator = 4;
            tfResult.setText("");
        } else if (command.equals("=")) {
            num2 = Double.parseDouble(tfResult.getText());
            switch (operator) {
                case 1: result = num1 + num2; break;
                case 2: result = num1 - num2; break;
                case 3: result = num1 * num2; break;
                case 4: result = num1 / num2; break;
            }
            tfResult.setText(String.valueOf(result));
        } else if (command.equals("C")) {
            tfResult.setText("");
            num1 = 0;
            num2 = 0;
            operator = 0;
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
