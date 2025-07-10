import javax.swing.*;

public class VierButtonGUI {
    private JButton redButton, greenButton, blueButton, greyButton;

    public VierButtonGUI(){
        JFrame frame = new JFrame("Vier Button GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JPanel panel = new JPanel();

        redButton = new JButton("Rot");
        redButton.addActionListener(e -> {
            // Set background color of the panel to red
            panel.setBackground(java.awt.Color.RED);
        });
        panel.add(redButton);

        greenButton = new JButton("Grün");
        greenButton.addActionListener(e -> {
            // Set background color of the panel to green
            panel.setBackground(java.awt.Color.GREEN);
        });
        panel.add(greenButton);

        blueButton = new JButton("Blau");
        blueButton.addActionListener(e -> {
            // Set background color of the panel to blue
            panel.setBackground(java.awt.Color.BLUE);
        });
        panel.add(blueButton);

        greyButton = new JButton("Grau");
        greyButton.addActionListener(e -> {
            // Set background color of the panel to grey
            panel.setBackground(java.awt.Color.GRAY);
        });
        panel.add(greyButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Starten der GUI
        SwingUtilities.invokeLater(() -> new VierButtonGUI());
    }
}
