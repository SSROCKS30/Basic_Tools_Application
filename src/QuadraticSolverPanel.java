import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuadraticSolverPanel extends JPanel {
    private JTextField coefficientAField;
    private JTextField coefficientBField;
    private JTextField coefficientCField;
    private JTextArea resultTextArea;

    public QuadraticSolverPanel(HomePage homePage) {
        setBackground(Color.BLACK);
        setLayout(new BorderLayout());

        // Input Fields
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(6, 6,5,5));
        inputPanel.setBackground(Color.BLACK);
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        Font inputFont = new Font("Arial", Font.BOLD, 30); 
        

        JLabel labelA = new JLabel("Coefficient A:");
        labelA.setForeground(Color.WHITE);
        labelA.setFont(new Font("Arial", Font.BOLD, 40));
        coefficientAField = new JTextField();
        coefficientAField.setFont(inputFont);
        coefficientAField.setBackground(Color.gray);
        inputPanel.add(labelA);
        inputPanel.add(coefficientAField);

        JLabel labelB = new JLabel("Coefficient B:");
        labelB.setForeground(Color.WHITE);
        labelB.setFont(new Font("Arial", Font.BOLD, 40));
        coefficientBField = new JTextField();
        coefficientBField.setFont(inputFont);
        coefficientBField.setBackground(Color.gray);
        inputPanel.add(labelB);
        inputPanel.add(coefficientBField);

        JLabel labelC = new JLabel("Coefficient C:");
        labelC.setForeground(Color.WHITE);
        labelC.setFont(new Font("Arial", Font.BOLD, 40));
        coefficientCField = new JTextField();
        coefficientCField.setFont(inputFont);
        coefficientCField.setBackground(Color.gray);
        inputPanel.add(labelC);
        inputPanel.add(coefficientCField);

        // Button to Calculate
        JButton calculateButton = new JButton("Calculate");
        calculateButton.setFont(new Font("Arial", Font.BOLD, 20));
        calculateButton.setBackground(Color.GREEN);
        calculateButton.setForeground(Color.WHITE);
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateQuadraticEquation();
            }
        });

        // Result TextArea
        resultTextArea = new JTextArea(2, 20);
        resultTextArea.setEditable(false);
        resultTextArea.setBackground(Color.BLACK);
        resultTextArea.setForeground(Color.WHITE);
        resultTextArea.setFont(inputFont);

        JButton exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.BOLD, 20));
        exitButton.setBackground(Color.RED);
        exitButton.setForeground(Color.WHITE);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homePage.switchToHomePage();
            }
        });

        add(inputPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.add(calculateButton);
        buttonPanel.add(exitButton);

        add(buttonPanel, BorderLayout.SOUTH);

        add(new JScrollPane(resultTextArea), BorderLayout.NORTH);

    }

    private void calculateQuadraticEquation() {
        try {
            double a = Double.parseDouble(coefficientAField.getText());
            double b = Double.parseDouble(coefficientBField.getText());
            double c = Double.parseDouble(coefficientCField.getText());

            double discriminant = b * b - 4 * a * c;

            if (discriminant > 0) {
                double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                displayResult("Roots: " + root1 + ", " + root2);
            } else if (discriminant == 0) {
                double root = -b / (2 * a);
                displayResult("Single Root: " + root);
            } else {
                displayResult("Complex Roots");
            }
        } catch (NumberFormatException | ArithmeticException ex) {
            displayResult("Invalid Input");
        }
    }

    private void displayResult(String result) {
        resultTextArea.setText(result);
    }
}
