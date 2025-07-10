import javax.swing.*;

public class VierButtonGUI {
    private JButton redButton, greenButton, blueButton, greyButton;
    private JPanel panel; // Panel als Instanzvariable, damit das Menü darauf zugreifen kann

    public VierButtonGUI() {
        JFrame frame = new JFrame("Vier Button GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        panel = new JPanel();

        redButton = new JButton("Rot");
        redButton.addActionListener(e -> panel.setBackground(java.awt.Color.RED));
        panel.add(redButton);

        greenButton = new JButton("Grün");
        greenButton.addActionListener(e -> panel.setBackground(java.awt.Color.GREEN));
        panel.add(greenButton);

        blueButton = new JButton("Blau");
        blueButton.addActionListener(e -> panel.setBackground(java.awt.Color.BLUE));
        panel.add(blueButton);

        greyButton = new JButton("Grau");
        greyButton.addActionListener(e -> panel.setBackground(java.awt.Color.GRAY));
        panel.add(greyButton);

        // Menüleiste erstellen
        JMenuBar menuBar = new JMenuBar();

        // Menü "Datei"
        JMenu fileMenu = new JMenu("Datei");

        JMenuItem resetItem = new JMenuItem("Zurücksetzen");
        resetItem.addActionListener(e -> panel.setBackground(null));

        JMenuItem exitItem = new JMenuItem("Beenden");
        exitItem.addActionListener(e -> System.exit(0));

        JMenu colorMenu = new JMenu("Farbe ändern");

        JMenuItem redMenuItem = new JMenuItem("Rot");
        redMenuItem.addActionListener(e -> panel.setBackground(java.awt.Color.RED));
        colorMenu.add(redMenuItem);

        JMenuItem greenMenuItem = new JMenuItem("Grün");
        greenMenuItem.addActionListener(e -> panel.setBackground(java.awt.Color.GREEN));
        colorMenu.add(greenMenuItem);

        JMenuItem blueMenuItem = new JMenuItem("Blau");
        blueMenuItem.addActionListener(e -> panel.setBackground(java.awt.Color.BLUE));
        colorMenu.add(blueMenuItem);

        JMenuItem greyMenuItem = new JMenuItem("Grau");
        greyMenuItem.addActionListener(e -> panel.setBackground(java.awt.Color.GRAY));
        colorMenu.add(greyMenuItem);

        fileMenu.add(resetItem);
        fileMenu.addSeparator();
        fileMenu.add(colorMenu);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);

        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(VierButtonGUI::new);
    }
}
