import javax.swing.*;
import java.awt.*;

public class VierButtonGUI {
    private JButton redButton, greenButton, blueButton, greyButton, imageButton;
    private BackgroundPanel panel;

    public VierButtonGUI() {
        JFrame frame = new JFrame("Vier Buttons");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);

        panel = new BackgroundPanel();
        panel.setLayout(new FlowLayout());

        redButton = new JButton("Rot");
        redButton.addActionListener(e -> {
            panel.setBackgroundImage(null);
            panel.setBackground(Color.RED);
        });
        panel.add(redButton);

        greenButton = new JButton("Grün");
        greenButton.addActionListener(e -> {
            panel.setBackgroundImage(null);
            panel.setBackground(Color.GREEN);
        });
        panel.add(greenButton);

        blueButton = new JButton("Blau");
        blueButton.addActionListener(e -> {
            panel.setBackgroundImage(null);
            panel.setBackground(Color.BLUE);
        });
        panel.add(blueButton);

        greyButton = new JButton("Grau");
        greyButton.addActionListener(e -> {
            panel.setBackgroundImage(null);
            panel.setBackground(Color.GRAY);
        });
        panel.add(greyButton);

        imageButton = new JButton("Bild");
        imageButton.addActionListener(e -> {
            ImageIcon icon = new ImageIcon("img.png");
            panel.setBackgroundImage(icon.getImage());
        });
        panel.add(imageButton);

        // Menüleiste wie zuvor (verkürzt)
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Datei");
        JMenuItem exitItem = new JMenuItem("Beenden");
        exitItem.addActionListener(e -> System.exit(0));
        menu.add(exitItem);
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);

        frame.setContentPane(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(VierButtonGUI::new);
    }

    // Spezielles Panel mit optionalem Hintergrundbild
    static class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public void setBackgroundImage(Image img) {
            this.backgroundImage = img;
            this.repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
                // Bild strecken oder anpassen
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }
}
