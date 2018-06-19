package distance;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.*;


public class Distance extends JFrame {

    private JTextField x1 = new JTextField(5);
    private JTextField x2 = new JTextField(5); 
    private JTextField y1 = new JTextField(5); 
    private JTextField y2 = new JTextField(5);
    private JTextField z1 = new JTextField(5); 
    private JTextField z2 = new JTextField(5);
    private JLabel rezultat = new JLabel("Udaljenost: "); 
    private JLabel udaljenost = new JLabel(""); 
    private JButton button = new JButton("Izracunaj");
    private JLabel X = new JLabel(" X "); 
    private JLabel Y = new JLabel(" Y "); 
    private JLabel Z = new JLabel(" Z "); 
    private JLabel prvaTacka = new JLabel("Prva tacka"); 
    private JLabel drugaTacka = new JLabel("Druga tacka");
    private JLabel prazno = new JLabel();
    
    Distance()
    {
        Popuni(); 
        setTitle("Distance calculator"); 
        setSize(320, 200); 
        setVisible(true); 
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void Popuni()
    {
        JPanel northPane = new JPanel(); 
        JPanel southPane = new JPanel(); 
        JPanel centerPane = new JPanel(new GridLayout(4, 2)); 
        JPanel westPane = new JPanel(new GridLayout(4, 1));
        
        northPane.add(rezultat); 
        northPane.add(udaljenost);
        add(northPane, "North"); 
        
        southPane.add(button); 
        add(southPane, "South"); 
        
        centerPane.add(prvaTacka); 
        centerPane.add(drugaTacka);
        centerPane.add(x1); 
        centerPane.add(x2); 
        centerPane.add(y1); 
        centerPane.add(y2);
        centerPane.add(z1); 
        centerPane.add(z2);
        add(centerPane, "Center"); 
        
        westPane.add(prazno);
        westPane.add(X);
        westPane.add(Y);
        westPane.add(Z);
        add(westPane, "West"); 
        
        button.addActionListener(click); 
    }
    
    ActionListener click = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) 
        {
            try
            {
                Double x11 = Double.parseDouble(x1.getText());
                Double y11 = Double.parseDouble(y1.getText());
                Double z11 = Double.parseDouble(z1.getText());
                Double x22 = Double.parseDouble(x2.getText());
                Double y22 = Double.parseDouble(y2.getText());
                Double z22 = Double.parseDouble(z2.getText());
                Double result = Math.sqrt((x22 - x11)*(x22 - x11) + (y22 - y11)*(y22 - y11) + (z22 - z11)*(z22 - z11));
                udaljenost.setText(String.valueOf(result));
            }
            catch (NumberFormatException e)
            {
                JOptionPane.showMessageDialog(null, "Unesite koordinate tačaka", "Greška", JOptionPane.WARNING_MESSAGE);
            }
        }
    };
    
    public static void main(String[] args) 
    {
        Distance distance = new Distance(); 
    }
    
}
