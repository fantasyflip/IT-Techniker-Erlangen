import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CardLayoutDemo extends JFrame {

    private CardLayout cardLayout;
    private JPanel cardPanel;

    public CardLayoutDemo() {
        super("CardLayout Demo");

        // CardLayout und Panel
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // --- Karten erstellen ---
        JPanel card1 = new JPanel();
        card1.setBackground(Color.CYAN);
        card1.add(new JLabel("Dies ist Karte 1"));

        JPanel card2 = new JPanel();
        card2.setBackground(Color.PINK);
        card2.add(new JLabel("Dies ist Karte 2"));

        JPanel card3 = new JPanel();
        card3.setBackground(Color.LIGHT_GRAY);
        card3.add(new JLabel("Dies ist Karte 3"));

        // Karten zum CardPanel hinzufügen
        cardPanel.add(card1, "Karte1");
        cardPanel.add(card2, "Karte2");
        cardPanel.add(card3, "Karte3");

        // - Buttons für die Navigation ---
        JPanel btnPanel = new JPanel();
        JButton btn1 = new JButton("Karte 1");
        JButton btn2 = new JButton("Karte 2");
        JButton btn3 = new JButton("Karte 3");

        btn1.addActionListener(e -> cardLayout.show(cardPanel, "Karte1"));
        btn2.addActionListener(e -> cardLayout.show(cardPanel, "Karte2"));
        btn3.addActionListener(e -> cardLayout.show(cardPanel, "Karte3"));

        btnPanel.add(btn1);
        btnPanel.add(btn2);
        btnPanel.add(btn3);

        // Layout zusammenstellen
        setLayout(new BorderLayout());
        add(cardPanel, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);

        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CardLayoutDemo();
    }
}
