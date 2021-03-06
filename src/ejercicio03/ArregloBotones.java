/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio03;

/**
 *
 * @author Jairo
 */
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
                
public class ArregloBotones extends JFrame implements ActionListener{
    
    private JButton botones[];
    private final Color color[]={Color.LIGHT_GRAY,Color.GREEN,Color.WHITE,Color.YELLOW,
                                 Color.RED,Color.BLUE,Color.CYAN,Color.ORANGE,Color.MAGENTA,Color.GRAY};
    private JLabel tecleado;
    private final int VALORES=10;
    private String clave="31416";
    private String claveX="";
    private JButton acceder;
    private Integer intentos;
   
    
    public ArregloBotones(){
    
        JFrame marco=new JFrame("Ejemplo Grid");
        marco.setLayout(new GridLayout(4,4,2,2));
        botones=new JButton[VALORES];
        tecleado= new JLabel("");
        intentos=0;
        acceder=new JButton("Acceder");
        acceder.addActionListener(this);
        for (int i = 0; i < VALORES; i++) {
           botones[i]= new JButton(""+i);
           botones[i].setBackground(color[i]);
           botones[i].addActionListener(this);
           botones[i].setToolTipText(color[i].toString());
           marco.add(botones[i]);
        }
        
        marco.add(tecleado);
        marco.add(acceder);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setSize(400,300);
        marco.setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent e){
    
        JButton b=(JButton) e.getSource();
        claveX=claveX+b.getText();
        tecleado.setText(claveX);
         if(claveX.equals(clave)){
             JOptionPane.showMessageDialog(null,"Clave Correcta");
             }
        if(e.getSource()==acceder){
          claveX="";
          tecleado.setText("");
          intentos++;
         if(intentos>3){
           acceder.removeActionListener(this);
           acceder.setToolTipText("Acceso denegado");
         JOptionPane.showMessageDialog(null,"Acceso denegado");
         
         }
       }
    }
    
    public static void main(String[]args){
        ArregloBotones ab=new ArregloBotones();
    
    }
    
    
}

