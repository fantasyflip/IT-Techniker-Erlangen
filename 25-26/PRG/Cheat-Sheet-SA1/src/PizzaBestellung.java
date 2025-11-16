import java.awt.*; // Datentypen wie JTextField
import java.awt.event.*; //Ereignisbehandlung
import java.io.*; // Für Input und Output
import javax.swing.*; // Für JFrame etc.


class PizzaBestellung extends JFrame implements ActionListener{
                                                         //Interface
  //Instanzvariablen - Global verfügbar -> Wenn nicht notwendig: Im Konstruktor anlegen
  JTextField jtName, jtTel;
  JRadioButton g_26, g_30;
  ButtonGroup group;
  JComboBox<String> pizzaArt;
  JCheckBox jcBSalami, jcBPeperoni, jcBSchinken;
  Integer bestellNr = 1;
  
  public PizzaBestellung(String titel){
    // JTextField jtName, jtTel; --- Für den Fall, dass die Felder nicht Global verfügbar sein müssen

    // Legt Fenstertitel fest
    super(titel); //super(); wird automatisch ausgeführt, wenn nicht anders spezifiziert
    //setTitle(titel); - Alternativ
    
    setLayout(new GridLayout(8,1));
    //kein Layout: setLayout(null);
    
    Font schrift = new Font("Monospaced",Font.BOLD+Font.ITALIC,30);
    Font schrift1 = new Font("Monospaced",Font.BOLD+Font.ITALIC,20);
    
    //-------------------- Zeile 1: Farbiges Text-Label ---------------------
    JLabel lb1 = new JLabel("Pizzabestellung",JLabel.CENTER);
    lb1.setForeground(Color.RED);      // ... new Color(123,45,6);
    lb1.setBackground(Color.YELLOW);
    lb1.setOpaque(true); 
    lb1.setFont(schrift);
    //lb1.setFont(new Font("Monospaced",Font.BOLD+Font.ITALIC,30));
    add(lb1);
    
    //--------------------- Zeile 2: Textfeld für Name --------------------
    JPanel pZeile2 = new JPanel();  //leeren Container erzeugen
                                    //Default: FlowLayout
    
    JLabel jlName = new JLabel("Name: ");
    jlName.setFont(schrift);
    pZeile2.add(jlName); //Komponenten dem Panel zuordnen
    jtName = new JTextField(20);
    pZeile2.add(jtName);
    
    add(pZeile2); //Panel in zweite Grid-Zelle
    
    
    //--------------------- Zeile 3: Textfeld für Telefonnummer --------------------
    JPanel pZeile3 = new JPanel();
    
    JLabel jlTel = new JLabel("Tel.: ");
    jlTel.setFont(schrift);
    pZeile3.add(jlTel); //Komponenten dem Panel zugeordnet
    jtTel = new JTextField(20);
    pZeile3.add(jtTel);
    
    add(pZeile3);            //Panel in dritte Grid-Zelle
    
    
    //--------------------- Zeile 4: Radiobutton-Group für Größe --------------------
    JPanel pZeile4 = new JPanel();
                     //Optik
    g_26 = new JRadioButton("26cm");
    g_26.setSelected(true);
    g_26.setFont(schrift);
    pZeile4.add(g_26);
    g_30 = new JRadioButton("30cm");
    g_30.setSelected(true); //wird ignoriert aufgrund der button group
    g_30.setFont(schrift);
    pZeile4.add(g_30); 
    
    add(pZeile4);
    //Logik
    group = new ButtonGroup();
    group.add(g_26);
    group.add(g_30);



    
    //--------------------- Zeile 5: Dropdown für Sorte --------------------
    String[] pizza = { "Salami", "Hawaii", "VierJahresZeiten" , "Ruccula" };
    
    pizzaArt = new JComboBox<String>(pizza);
    pizzaArt.setSelectedIndex(2); // Standard-Auswahl festlegen
    pizzaArt.setFont(schrift);
    
    add(pizzaArt);
    
    //--------------------- Zeile 6: Label --------------------
    JLabel lb6 = new JLabel("Extra: ",JLabel.LEFT);
    lb6.setForeground(Color.BLUE);      // ... new Color(123,45,6); 
    lb6.setFont(schrift);
    add(lb6);
    
    //--------------------- Zeile 7: Checkboxen für Zusatzoptionen --------------------
    JPanel pZeile7 = new JPanel();
    
    jcBSalami = new JCheckBox("Salami");
    jcBSalami.setFont(schrift1);
    pZeile7.add(jcBSalami);
    jcBPeperoni = new JCheckBox("Peperoni");
    jcBPeperoni.setFont(schrift1);
    pZeile7.add(jcBPeperoni);
    jcBSchinken = new JCheckBox("Schinken");
    jcBSchinken.setFont(schrift1);
    pZeile7.add(jcBSchinken);
    
    add(pZeile7);
    
    //--------------------- Zeile 8: Panel für Buttons --------------------
    JPanel pZeile8 = new JPanel();
    
    JButton jbSenden = new JButton("Senden");
    jbSenden.setFont(schrift1);
    jbSenden.addActionListener(this);
    pZeile8.add(jbSenden);
    
    JButton jbAbbrechen = new JButton("Abbrechen");
    jbAbbrechen.setFont(schrift1);
    jbAbbrechen.addActionListener(new AbbrechenEreignis());
    pZeile8.add(jbAbbrechen);
    
    JButton ende = new JButton("Ende");
    ende.setFont(schrift1);
    ende.addActionListener(new EndeEreignis(jtName));
    pZeile8.add(ende);
    
    add(pZeile8);
    
    
    setSize(400,400);
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }
  
  
  public void actionPerformed(ActionEvent e){
    
    //hier steht das, was passiert

    System.out.println("Action Performed");
    
    if (e.getActionCommand().equals("Senden"))
    {
      
      //Textfelder
      String name = jtName.getText();    //Auslesen des Textfeldes
      String tel  = jtTel.getText();
      
      //RadioButton
      String groesse;
      if (g_26.isSelected()) {
         groesse = "26cm";
      }  
      else {
         groesse = "30cm";
      } // end of if-else 
      
      //ComboBox - Implizites Typecasting, da Object returned wird
      String p_Art = (String)pizzaArt.getSelectedItem();
      
      //CheckBoxen
      String salami;
      if (jcBSalami.isSelected()) {
         salami = "Salami";
      }  
      else {
         salami = "nein";
      } // end of if-else 
      
      String peperoni;
      if (jcBPeperoni.isSelected()) {
         peperoni = "Peperoni";
      }  
      else {
         peperoni = "nein";
      } // end of if-else 
      
      String schinken;
      if (jcBSchinken.isSelected()) {
         schinken = "Schinken";
      }  
      else {
         schinken = "nein";
      } // end of if-else 
      
      
      //Ausgabe in der Console
      System.out.println("------Pizzabestellung-------");
      System.out.println();
      System.out.println("Name : " + name);
      System.out.println("Tel. : " + tel);
      System.out.println();
      System.out.println("Groesse: " + groesse);
      System.out.println("Art : " + p_Art);
      System.out.println("Extras:");
      System.out.println(salami);
      System.out.println(peperoni);
      System.out.println(schinken);
      System.out.println();
      System.out.println("Vielen Dank fuer ihre Bestellung!");

      JOptionPane.showMessageDialog(null,"Best.-Nr. \n"+ bestellNr,"Bestellungsübersicht",JOptionPane.INFORMATION_MESSAGE);

      try {
        // File-Writer im Append-Modus durch "true" als zweiter Übergabeparameter
        BufferedWriter writer = new BufferedWriter(new FileWriter("Bestellungen.txt", true)); // In Datei schreiben durch Angabe des Dateinamen

        writer.write(bestellNr.toString());
        writer.newLine(); // Neue Zeile in die Datei
        writer.close();

      } catch (Exception exception) {
        exception.printStackTrace();
      }

      System.out.println("Einlesen der letzten Bestellungsnummern:\n");

      try {
        BufferedReader in = new BufferedReader(new FileReader("Bestellungen.txt"));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        br2bw(in,out);
      }
      catch (Exception exception) {
        exception.printStackTrace();
      }

      bestellNr++;

    }
    else {    
      
      
      
    } // end of if-else
      
  }

  public static void br2bw(BufferedReader br, BufferedWriter bw)
    throws IOException {

    String z;                             // Zeile

    while ((z = br.readLine()) != null) { // lesen, Stromende pruefen,

      bw.write(z);                        // ausgeben und

      bw.newLine();                       // Zeilenwechsel ausgeben

    }

    br.close();

    bw.close(); // Schließt den Output-Stream permanent! Auch System.out!

  }
  
  
  class AbbrechenEreignis implements ActionListener{
    
    public void actionPerformed(ActionEvent e){
    
      //Textfelder leeren
      jtName.setText("");    
      jtTel.setText("");
      
      //Radiobutton unausgewaehlt
      g_26.setSelected(true);
      
      //ComboBox - Vorauswahl
      pizzaArt.setSelectedIndex(2);
      
      //Checkboxen leeren
      jcBSalami.setSelected(false);
      jcBPeperoni.setSelected(false);
      jcBSchinken.setSelected(false);
      
    }  
  }  
     
}  
