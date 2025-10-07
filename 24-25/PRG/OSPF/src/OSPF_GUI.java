import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class OSPF_GUI extends JFrame {

    private CardLayout mainLayout;
    private JPanel mainPanel;
    private ArrayList<String> config;
    private int routerCount = 1;
    private JLabel titleLabel;
    private HashMap<String, JPanel> interfaceCards;

    // --- Speichert den aktuellen OSPF-Prozess
    private String currentOSPF = null;

    public OSPF_GUI(String title) {
        super(title);
        config = new ArrayList<>();
        interfaceCards = new HashMap<>();

        setLayout(new BorderLayout());
        titleLabel = new JLabel("OSPF Konfiguration - Router " + routerCount, JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(titleLabel, BorderLayout.NORTH);

        mainLayout = new CardLayout();
        mainPanel = new JPanel(mainLayout);
        add(mainPanel, BorderLayout.CENTER);

        createEnablePanel();
        createConfigPanel();
        createOSPFPanel();
        createInterfacePanel();

        mainLayout.show(mainPanel, "enable");

        setSize(800, 300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void createEnablePanel() {
        JPanel enablePanel = new JPanel();
        JButton btnEnable = new JButton("enable");
        btnEnable.addActionListener(e -> {
            saveCommand("enable");
            mainLayout.show(mainPanel, "config");
        });
        enablePanel.add(btnEnable);
        mainPanel.add(enablePanel, "enable");
    }

    private void createConfigPanel() {
        JPanel configPanel = new JPanel();
        JButton btnConfigT = new JButton("configure terminal");
        btnConfigT.addActionListener(e -> {
            saveCommand("configure terminal");
            mainLayout.show(mainPanel, "ospf");
        });
        configPanel.add(btnConfigT);
        mainPanel.add(configPanel, "config");
    }

    private void createOSPFPanel() {
        JPanel ospfPanel = new JPanel(new FlowLayout());
        JButton btnRouterOSPF = new JButton("router ospf <ID>");
        btnRouterOSPF.addActionListener(e -> {
            String ospfId = JOptionPane.showInputDialog(this, "Gib die OSPF-Prozess-ID ein (z.B. 10):");
            if (ospfId != null && ospfId.matches("\\d+")) {
                currentOSPF = ospfId.trim(); // Speichern der aktuellen OSPF-ID
                saveCommand("router ospf " + currentOSPF);
                mainLayout.show(mainPanel, "interface");
            } else {
                JOptionPane.showMessageDialog(this, "Ungültige OSPF-ID!", "Fehler", JOptionPane.ERROR_MESSAGE);
            }
        });
        ospfPanel.add(btnRouterOSPF);
        mainPanel.add(ospfPanel, "ospf");
    }

    private void createInterfacePanel() {
        JPanel interfacePanel = new JPanel(new GridLayout(3, 1, 5, 5));
        JPanel btnPanel = new JPanel();

        JButton btnRouterID = new JButton("router-id <ID>");
        JButton btnNetwork = new JButton("network <IP> <Maske> area <X>");
        JButton btnAddInterface = new JButton("Interface konfigurieren");
        JButton btnPassive = new JButton("passive-interface <INT>");
        JButton btnEnd = new JButton("end");

        btnRouterID.addActionListener(e -> routerIDDialog());
        btnNetwork.addActionListener(e -> networkDialog());
        btnAddInterface.addActionListener(e -> interfaceSelectDialog());
        btnPassive.addActionListener(e -> passiveInterfaceDialog());

        btnEnd.addActionListener(e -> {
            saveCommand("end");
            saveToFile();

            int choice = JOptionPane.showOptionDialog(
                    this,
                    "Router fertig konfiguriert.\nWas möchtest du tun?",
                    "Fertig",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    new String[]{"Neuer Router", "Beenden"},
                    "Beenden"
            );

            if (choice == JOptionPane.YES_OPTION) {
                routerCount++;
                titleLabel.setText("OSPF Konfiguration - Router " + routerCount);
                currentOSPF = null;
                mainLayout.show(mainPanel, "enable");
            } else {
                System.exit(0);
            }
        });

        btnPanel.add(btnRouterID);
        btnPanel.add(btnNetwork);
        btnPanel.add(btnAddInterface);
        btnPanel.add(btnPassive);
        btnPanel.add(btnEnd);

        interfacePanel.add(new JLabel("OSPF-Modus - Router " + routerCount, JLabel.CENTER));
        interfacePanel.add(btnPanel);

        mainPanel.add(interfacePanel, "interface");
    }

    private void interfaceSelectDialog() {
        String iface = JOptionPane.showInputDialog(this, "Gib den Interface-Namen ein (z.B. GigabitEthernet0/0/0):");
        if (iface != null && !iface.isBlank()) {
            if (!interfaceCards.containsKey(iface)) createInterfaceCard(iface);
            saveCommand("interface " + iface);
            mainLayout.show(mainPanel, "iface-" + iface);
        }
    }

    private void createInterfaceCard(String iface) {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel lbl = new JLabel("Interface: " + iface, JLabel.CENTER);
        panel.add(lbl, BorderLayout.NORTH);

        JPanel btnPanel = new JPanel();
        JButton btnRouterID = new JButton("router-id <ID>");
        JButton btnNetwork = new JButton("network <IP> <Maske> area <X>");
        JButton btnPassive = new JButton("passive-interface <INT>");
        JButton btnLeave = new JButton("Interface verlassen");

        btnRouterID.addActionListener(e -> routerIDDialog());
        btnNetwork.addActionListener(e -> networkDialog());
        btnPassive.addActionListener(e -> passiveInterfaceDialog());

        // --- Interface verlassen → zurück zum OSPF-Hauptpanel & OSPF wieder aktivieren ---
        btnLeave.addActionListener(e -> {
            mainLayout.show(mainPanel, "interface");

            if (currentOSPF != null) {
                saveCommand("router ospf " + currentOSPF); // Automatisch OSPF wieder aktivieren
            }

            JOptionPane.showMessageDialog(this,
                    "Interface verlassen. Du bist nun wieder im OSPF-Konfigurationsmodus.",
                    "Info",
                    JOptionPane.INFORMATION_MESSAGE);
        });

        btnPanel.add(btnRouterID);
        btnPanel.add(btnNetwork);
        btnPanel.add(btnPassive);
        btnPanel.add(btnLeave);

        panel.add(btnPanel, BorderLayout.CENTER);
        interfaceCards.put(iface, panel);
        mainPanel.add(panel, "iface-" + iface);
    }

    private void routerIDDialog() {
        JPanel ridPanel = createIPPanel("Router-ID");
        int result = JOptionPane.showConfirmDialog(this, ridPanel, "Gib die Router-ID ein", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            JTextField[] fields = (JTextField[]) ridPanel.getClientProperty("ipFields");
            String rid = String.join(".", fields[0].getText().trim(), fields[1].getText().trim(),
                    fields[2].getText().trim(), fields[3].getText().trim());
            if (validateIP(rid)) saveCommand("router-id " + rid);
            else JOptionPane.showMessageDialog(this, "Ungültige Router-ID!", "Fehler", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void networkDialog() {
        JPanel netPanel = createIPPanel("Netzwerk-IP");
        JPanel maskPanel = createIPPanel("Maske");
        JTextField areaField = new JTextField(3);

        JPanel mainPanel = new JPanel(new GridLayout(3, 1));
        mainPanel.add(netPanel);
        mainPanel.add(maskPanel);
        JPanel areaP = new JPanel();
        areaP.add(new JLabel("Area:"));
        areaP.add(areaField);
        mainPanel.add(areaP);

        mainPanel.putClientProperty("ipFields", netPanel.getClientProperty("ipFields"));
        mainPanel.putClientProperty("maskFields", maskPanel.getClientProperty("ipFields"));
        mainPanel.putClientProperty("areaField", areaField);

        int result = JOptionPane.showConfirmDialog(this, mainPanel, "Netzwerk eingeben", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            JTextField[] ipFields = (JTextField[]) mainPanel.getClientProperty("ipFields");
            JTextField[] maskFields = (JTextField[]) mainPanel.getClientProperty("maskFields");
            JTextField areaF = (JTextField) mainPanel.getClientProperty("areaField");

            String ip = String.join(".", ipFields[0].getText().trim(), ipFields[1].getText().trim(),
                    ipFields[2].getText().trim(), ipFields[3].getText().trim());
            String mask = String.join(".", maskFields[0].getText().trim(), maskFields[1].getText().trim(),
                    maskFields[2].getText().trim(), maskFields[3].getText().trim());
            String area = areaF.getText().trim();

            if (validateIP(ip) && validateIP(mask) && !area.isBlank()) {
                saveCommand("network " + ip + " " + mask + " area " + area);
            } else JOptionPane.showMessageDialog(this, "Ungültige Eingabe!", "Fehler", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void passiveInterfaceDialog() {
        String iface = JOptionPane.showInputDialog(this, "Gib das Interface ein (z.B. g0/0/0):");
        if (iface != null && !iface.isBlank()) saveCommand("passive-interface " + iface.trim());
    }

    private JPanel createIPPanel(String label) {
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(new JLabel(label + ":"));
        JTextField[] ipFields = new JTextField[4];
        for (int i = 0; i < 4; i++) {
            ipFields[i] = new JTextField(3);
            panel.add(ipFields[i]);
            if (i < 3) panel.add(new JLabel("."));
        }
        panel.putClientProperty("ipFields", ipFields);
        return panel;
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

    private void saveCommand(String cmd) {
        String fullCmd = "Router " + routerCount + ": " + cmd;
        config.add(fullCmd);
        System.out.println(fullCmd);
    }

    private void saveToFile() {
        try (FileWriter writer = new FileWriter("ospf_config.txt")) {
            for (String cmd : config) {
                writer.write(cmd + System.lineSeparator());
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Fehler beim Schreiben der Datei!", "Fehler", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new OSPF_GUI("OSPF GUI"));
    }
}
