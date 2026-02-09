import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JavaCalculator1 {

    static class RoundedButton extends JButton {

        public RoundedButton(String text) {
            super(text);
            setBorder(null);
            setFocusPainted(false);
            setContentAreaFilled(false);
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int buttonWidth = getWidth();
            int buttonHeight = getHeight();
            int cornerRadius = Math.min(buttonWidth, buttonHeight) / 2;

            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, buttonWidth, buttonHeight, cornerRadius, cornerRadius);

            g2.setColor(getForeground());
            FontMetrics fm = g2.getFontMetrics();
            int x = (buttonWidth - fm.stringWidth(getText())) / 2;
            int y = (getHeight() + fm.getAscent() - fm.getDescent()) / 2;
            g2.drawString(getText(), x, y);

            g2.dispose();
        }
    }

    private static double calculate(double a, double b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return b == 0 ? 0 : a / b;
            default: return 0;
        }
    }

    private static double evaluateExpression(String expr) {
        String[] tokens = expr.trim().split("\\s+");
        if (tokens.length == 0) return 0;
        double result = Double.parseDouble(tokens[0]);
        for (int i = 1; i < tokens.length; i += 2) {
            if (i + 1 < tokens.length) {
                String op = tokens[i];
                double num = Double.parseDouble(tokens[i + 1]);
                result = calculate(result, num, op);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Relosa");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));
        frame.setSize(340, 600);
        frame.setResizable(true);
        frame.getContentPane().setBackground(new Color(20, 20, 20));

        JPanel displayPanel = new JPanel(new BorderLayout());
        displayPanel.setBackground(new Color(20, 20, 20));

        JTextField display = new JTextField("0");
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setFont(new Font("Arial", Font.BOLD, 42));
        display.setEditable(false);
        display.setForeground(Color.WHITE);
        display.setBackground(new Color(20, 20, 20));
        display.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        displayPanel.add(display, BorderLayout.CENTER);
        frame.add(displayPanel, BorderLayout.NORTH);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(5, 4, 12, 12));
        buttonsPanel.setBackground(new Color(20, 20, 20));

        String[] buttons = {
                "C", "%", "←", "/",
                "7", "8", "9", "*",
                "4", "5", "6", "-",
                "1", "2", "3", "+",
                "00", "0", ".", "="
        };

        final StringBuilder expression = new StringBuilder("0");
        final boolean[] startNewNumber = {true};

        for (String text : buttons) {
            RoundedButton btn = new RoundedButton(text);
            btn.setFont(new Font("Arial", Font.BOLD, 20));
            btn.setForeground(Color.WHITE);

            if (text.matches("[0-9]") || text.equals("00") || text.equals("."))
                btn.setBackground(new Color(30, 30, 30));
            else if (text.equals("="))
                btn.setBackground(new Color(73, 86, 130));
            else
                btn.setBackground(new Color(50, 50, 50));

            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String command = e.getActionCommand();

                    if (command.matches("[0-9]") || command.equals("00")) {
                        if (startNewNumber[0]) {
                            expression.setLength(0);
                            startNewNumber[0] = false;
                        }
                        expression.append(command);
                        display.setText(expression.toString());
                    } else if (command.equals(".")) {
                        if (startNewNumber[0] || !expression.toString().contains(".")) {
                            if (startNewNumber[0]) {
                                expression.setLength(0);
                                expression.append("0");
                                startNewNumber[0] = false;
                            }
                            expression.append(".");
                            display.setText(expression.toString());
                        }
                    } else if (command.equals("+") || command.equals("-") || command.equals("*") || command.equals("/")) {
                        expression.append(" ").append(command).append(" ");
                        display.setText(expression.toString());
                    } else if (command.equals("=")) {
                        double result = evaluateExpression(expression.toString());
                        expression.setLength(0);
                        expression.append(result);
                        display.setText(expression.toString());
                        startNewNumber[0] = true;
                    } else if (command.equals("C")) {
                        expression.setLength(0);
                        expression.append("0");
                        display.setText(expression.toString());
                        startNewNumber[0] = true;
                    } else if (command.equals("←")) {
                        if (expression.length() > 1) {
                            expression.setLength(expression.length() - 1);
                        } else {
                            expression.setLength(0);
                            expression.append("0");
                        }
                        display.setText(expression.toString());
                    } else if (command.equals("%")) {
                        try {
                            double num = Double.parseDouble(expression.toString());
                            num /= 100;
                            expression.setLength(0);
                            expression.append(num);
                            display.setText(expression.toString());
                        } catch (NumberFormatException ex) {
                        }
                    }
                }
            });

            buttonsPanel.add(btn);
        }

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(new Color(20, 20, 20));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        centerPanel.add(buttonsPanel, BorderLayout.CENTER);
        frame.add(centerPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
