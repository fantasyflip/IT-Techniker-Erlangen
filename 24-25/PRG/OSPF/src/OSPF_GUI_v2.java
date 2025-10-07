import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class OSPF_GUI_v2 extends JFrame {

    private ArrayList<String> config;
    private int routerCount = 1;
    private JLabel titleLabel;

    // Buttons
    private JButton btnEnable, btnConfigT, btnRouterOSPF, btnRouterID, btnNetwork, btnPassive, btnEnd;

    public OSPF_GUI_v2(String title) {
        super(title);
        config = new ArrayList<>();

        setLayout(new BorderLayout());
        titleLabel = new JLabel("OSPF Konfiguration - Router " + routerCount, JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(titleLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        // Buttons initialisieren
        btnEnable = new JButton("enable");
        btnConfigT = new JButton("configure terminal");
        btnRouterOSPF = new JButton("router ospf <ID>");
        btnRouterID = new JButton("router-id <ID>");
        btnNetwork = new JButton("network <IP> <Maske> area <X>");
        btnPassive = new JButton("passive-interface <INT>");
        btnEnd = new JButton("end");

        // Anfangszustand
        btnEnable.setEnabled(true);
        btnConfigT.setEnabled(false);
        btnRouterOSPF.setEnabled(false);
        btnRouterID.setEnabled(false);
        btnNetwork.setEnabled(false);
        btnPassive.setEnabled(false);
        btnEnd.setEnabled(false);

        // ActionListener
        btnEnable.addActionListener(e -> {
            saveCommand("enable");
            btnEnable.setEnabled(false);
            btnConfigT.setEnabled(true);
        });

        btnConfigT.addActionListener(e -> {
            saveCommand("configure terminal");
            btnConfigT.setEnabled(false);
            btnRouterOSPF.setEnabled(true);
        });

        btnRouterOSPF.addActionListener(e -> {
            String ospfId = JOptionPane.showInputDialog(this, "OSPF-Prozess-ID:");
            if (ospfId != null && ospfId.matches("\\d+")) {
                saveCommand("router ospf " + ospfId);
                btnRouterOSPF.setEnabled(false);
                btnRouterID.setEnabled(true);
                btnNetwork.setEnabled(true);
                btnPassive.setEnabled(true);
                btnEnd.setEnabled(true);
            }
        });

        btnRouterID.addActionListener(e -> {
            String rid = JOptionPane.showInputDialog(this, "Router-ID (z.B. 1.1.1.1):");
            if (rid != null && validateIP(rid)) saveCommand("router-id " + rid);
            else JOptionPane.showMessageDialog(this, "Ungültige Router-ID!", "Fehler", JOptionPane.ERROR_MESSAGE);
        });

        btnNetwork.addActionListener(e -> {
            JPanel panel = new JPanel();
            JTextField ipField = new JTextField(10);
            JTextField maskField = new JTextField(10);
            JTextField areaField = new JTextField(3);
            panel.add(new JLabel("IP:"));
            panel.add(ipField);
            panel.add(new JLabel("Maske:"));
            panel.add(maskField);
            panel.add(new JLabel("Area:"));
            panel.add(areaField);

            int result = JOptionPane.showConfirmDialog(this, panel, "Network konfigurieren", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                String ip = ipField.getText().trim();
                String mask = maskField.getText().trim();
                String area = areaField.getText().trim();
                if (validateIP(ip) && validateIP(mask) && area.matches("\\d+")) {
                    saveCommand("network " + ip + " " + mask + " area " + area);
                } else JOptionPane.showMessageDialog(this, "Ungültige Eingabe!", "Fehler", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnPassive.addActionListener(e -> {
            String iface = JOptionPane.showInputDialog(this, "Interface (z.B. g0/0/0):");
            if (iface != null && !iface.isBlank()) saveCommand("passive-interface " + iface);
        });

        btnEnd.addActionListener(e -> {
            saveCommand("end");
            // Buttons deaktivieren
            btnRouterID.setEnabled(false);
            btnNetwork.setEnabled(false);
            btnPassive.setEnabled(false);
            btnEnd.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Konfiguration abgeschlossen. Alle Befehle in der Konsole sichtbar.", "Fertig", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        });

        buttonPanel.add(btnEnable);
        buttonPanel.add(btnConfigT);
        buttonPanel.add(btnRouterOSPF);
        buttonPanel.add(btnRouterID);
        buttonPanel.add(btnNetwork);
        buttonPanel.add(btnPassive);
        buttonPanel.add(btnEnd);

        add(buttonPanel, BorderLayout.CENTER);

        setSize(800, 200);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void saveCommand(String cmd) {
        String fullCmd = "Router " + routerCount + ": " + cmd;
        config.add(fullCmd);
        System.out.println(fullCmd);
    }

    private boolean validateIP(String ip) {
        String[] parts = ip.split("\\.");
        if (parts.length != 4) return false;
        try {
            for (String p : parts) {
                int val = Integer.parseInt(p);
                if (val < 0 || val > 255) return false;
            }
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new OSPF_GUI_v2("OSPF GUI v2"));
    }
}
