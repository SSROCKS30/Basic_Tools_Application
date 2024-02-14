import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends JFrame {
    @SuppressWarnings("unused")
    private JPanel currentPanel;
    private CalculatorPanel calculatorPanel;
    private BMICalculatorPanel bmiCalculatorPanel;
    private JPanel homePanel;

    public HomePage() {
        setTitle("run_java_project()");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException
                | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        JButton calculatorButton = new JButton("Calculator");
        JButton bmiCalculatorButton = new JButton("BMI Calculator");
        calculatorButton.setBackground(new Color(32, 32, 32));
        calculatorButton.setForeground(Color.WHITE);
        calculatorButton.setFocusPainted(false);
        calculatorButton.setPreferredSize(new Dimension(150, 50));
        bmiCalculatorButton.setBackground(new Color(32, 32, 32));
        bmiCalculatorButton.setForeground(Color.WHITE);
        bmiCalculatorButton.setFocusPainted(false);
        bmiCalculatorButton.setPreferredSize(new Dimension(150, 50));
        homePanel = new JPanel(new GridLayout(4, 1));
        homePanel.setBackground(new Color(32, 32, 32));
        homePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel welcomeLabel = new JLabel("WELCOME TO YOUR BASIC_TOOLS_APP");
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 40));
        homePanel.add(welcomeLabel);

        JLabel subheadingLabel = new JLabel("OUR SWEET LITTLE JAVA PROJECT....");
        subheadingLabel.setForeground(Color.WHITE);
        subheadingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        subheadingLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        homePanel.add(subheadingLabel);

        homePanel.add(calculatorButton);
        homePanel.add(bmiCalculatorButton);

        add(homePanel, BorderLayout.CENTER);

        calculatorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchToCalculator();
            }
        });

        bmiCalculatorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchToBMICalculator();
            }
        });

        calculatorPanel = new CalculatorPanel(this);
        bmiCalculatorPanel = new BMICalculatorPanel(this);

        setVisible(true);
    }

    public void switchToCalculator() {
        getContentPane().removeAll();
        getContentPane().add(calculatorPanel, BorderLayout.CENTER);
        currentPanel = calculatorPanel;
        revalidate();
        repaint();
    }

    public void switchToBMICalculator() {
        getContentPane().removeAll();
        getContentPane().add(bmiCalculatorPanel, BorderLayout.CENTER);
        currentPanel = bmiCalculatorPanel;
        revalidate();
        repaint();
    }

    public void switchToHomePage() {
        getContentPane().removeAll();
        getContentPane().add(homePanel, BorderLayout.CENTER);
        currentPanel = homePanel;
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HomePage();
            }
        });
    }
}