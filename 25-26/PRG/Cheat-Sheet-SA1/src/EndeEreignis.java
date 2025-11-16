import java.awt.event.*; //Ereignisbehandlung
import javax.swing.JTextField;

class EndeEreignis implements ActionListener{

  JTextField jtname;

  // Beim Erstellen der Klasse wird das Textfeld übergeben, da es nicht global verfügbar ist
  EndeEreignis(JTextField jtname){
    this.jtname = jtname;
  }  
  
  
  public void actionPerformed(ActionEvent e){
    System.out.println(jtname.getText()); // Textfeldinhalt wird ausgegeben
    System.exit(0);  //beendet den GUI-Prozess
    
  }
  
}
