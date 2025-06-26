import java.awt.*;
import javax.swing.*;

public class TestFrame1
{
    public static void main ( String[] args )
    {
        JFrame frame = new JFrame("Test Frame 1");
        frame.setSize(200,100);
        frame.setVisible( true );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }
}
