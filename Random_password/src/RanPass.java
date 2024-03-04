import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class RanPass extends Frame implements ActionListener {
    private TextField limitField;
    private TextArea passwordArea;
    private Button generateButton;

    public RanPass() {
        setTitle("Password Generator");
        setSize(600, 500);
        setExtendedState(Frame.MAXIMIZED_BOTH); // Maximize the frame
        setLayout(new GridBagLayout());

        // Create a GridBagConstraints object for arranging components
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(new GridBagLayout());

        Label limitLabel = new Label("Enter the Limit of the Password:");
        limitLabel.setFont(new Font("Arial", Font.PLAIN, 28));

        // Increase the size of the input box and font
        limitField = new TextField(20); // Adjust the width
        Font inputFont = new Font("Arial", Font.PLAIN, 18);
        limitField.setFont(inputFont);

        generateButton = new Button("Generate Password");
        generateButton.addActionListener(this);

        generateButton.setBackground(Color.CYAN);
        generateButton.setPreferredSize(new Dimension(200, 40));
        generateButton.setFont(new Font("Arial", Font.PLAIN, 19));

        passwordArea = new TextArea(6, 30);
        passwordArea.setEditable(false);
        Font passwordFont = new Font("Arial", Font.PLAIN, 28);
        passwordArea.setFont(passwordFont);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10); // Add some padding
        gbc.anchor = GridBagConstraints.WEST;

        add(limitLabel, gbc);

        gbc.gridy++;
        add(limitField, gbc);

        gbc.gridy++;
        add(generateButton, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        add(new Label(), gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        add(passwordArea, gbc);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == generateButton) {
            String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String lower = "abcdefghijklmnopqrstuvwxyz";
            String num = "0123456789";
            String specialChars = "<>,.?/!@#$%^&**|";
            String combination = upper + lower + num + specialChars;

            int limit = Integer.parseInt(limitField.getText());
            char[] password = new char[limit];
            Random r = new Random();

            for (int i = 0; i < limit; i++) {
                password[i] = combination.charAt(r.nextInt(combination.length()));
            }

            passwordArea.setText("Generated Password is: " + new String(password));
        }
    }

    public static void main(String[] args) {
        RanPass ranPass = new RanPass();
        ranPass.setVisible(true);
    }
}
