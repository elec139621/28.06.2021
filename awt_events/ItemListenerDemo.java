package swing9;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ItemListenerDemo {
   private JFrame frame;
   private JLabel headerLabel, statusLabel;
   private JPanel controlPanel;

   public ItemListenerDemo(){
	   	  frame = new JFrame("Java SWING Examples");
	   	  frame.setSize(400,400);
	   	  frame.setLayout(new GridLayout(3, 1));
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	      headerLabel = new JLabel("",JLabel.CENTER );
	      statusLabel = new JLabel("",JLabel.CENTER);        
	      statusLabel.setSize(350,100);
	         
	      controlPanel = new JPanel();
	      controlPanel.setLayout(new FlowLayout());

	      frame.add(headerLabel);
	      frame.add(controlPanel);
	      frame.add(statusLabel);
	      frame.setVisible(true);    
   }

   private void showItemListenerDemo(){
      headerLabel.setText("Listener in action: ItemListener");      
      JCheckBox chkApple = new JCheckBox("Apple");
      JCheckBox chkMango = new JCheckBox("Mango");
      JCheckBox chkPeer = new JCheckBox("Peer");
   
      chkApple.addItemListener(new CustomItemListener());
      chkMango.addItemListener(new CustomItemListener());
      chkPeer.addItemListener(new CustomItemListener());

      controlPanel.add(chkApple);
      controlPanel.add(chkMango);
      controlPanel.add(chkPeer);               
      frame.setVisible(true); 
   }
   
   class CustomItemListener implements ItemListener {
      public void itemStateChanged(ItemEvent e) {
         statusLabel.setText(((JCheckBox)e.getItem()).getText()
            +" Checkbox: " + (e.getStateChange()==1?"checked":"unchecked"));
      }    
   }
   
   public static void main(String[] args){
	   ItemListenerDemo swingListenerDemo = new ItemListenerDemo();  
      swingListenerDemo.showItemListenerDemo();
   }
}