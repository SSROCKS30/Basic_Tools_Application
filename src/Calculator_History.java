import javax.swing.*;
import java.awt.*;
import java.util.List;
public class Calculator_History extends JFrame {
    public Calculator_History(List<String> historyList) {
        setTitle("Calculator History");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextArea historyTextArea = new JTextArea();
        historyTextArea.setEditable(false);

        for (String calculation : historyList) {
            historyTextArea.append(calculation + "\n");
        }

        JScrollPane scrollPane = new JScrollPane(historyTextArea);

        getContentPane().add(scrollPane, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
