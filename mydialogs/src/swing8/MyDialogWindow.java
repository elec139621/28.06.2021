package swing8;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MyDialogWindow extends JFrame implements ActionListener {

	JButton m_btn = new JButton("Open New JOptionPane");
	
	
	
	public MyDialogWindow() throws HeadlessException {
		m_btn.setBounds(150, 200, 200, 50);
		m_btn.setFocusable(false);
		m_btn.addActionListener(this);
		
		this.add(m_btn);
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);//Set layout to null in this demo
		this.setVisible(true);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == m_btn) {
			
			//JFrame jf = new JFrame()
			
			/*
			JOptionPane.showMessageDialog(this,"Some Message","title",JOptionPane.PLAIN_MESSAGE);
			JOptionPane.showMessageDialog(this,"Some Message","title",JOptionPane.INFORMATION_MESSAGE);
			JOptionPane.showMessageDialog(this,"Some Message","title",JOptionPane.WARNING_MESSAGE);
			JOptionPane.showMessageDialog(this,"Some Message","title",JOptionPane.QUESTION_MESSAGE);
			JOptionPane.showMessageDialog(this,"Some Message","title",JOptionPane.ERROR_MESSAGE);
			*/
			
			//We can give the user different options on the dialog using showConfirmDialog method
			//We can also save the answer of the user and use it later
			/*
			int answer1 = JOptionPane.showConfirmDialog(this, "Some question?","title", JOptionPane.YES_NO_OPTION);
			JOptionPane.showMessageDialog(this,answer1,"your choice",JOptionPane.INFORMATION_MESSAGE);
			int answer2 = JOptionPane.showConfirmDialog(this, "Some question?","title", JOptionPane.CLOSED_OPTION);
			JOptionPane.showMessageDialog(this,answer2,"your choice",JOptionPane.INFORMATION_MESSAGE);
			int answer3 = JOptionPane.showConfirmDialog(this, "Some question?","title", JOptionPane.YES_NO_CANCEL_OPTION);
			JOptionPane.showMessageDialog(this,answer3,"your choice",JOptionPane.INFORMATION_MESSAGE);
			// There are few more versions we can use in the options
			 * 
			 */
			
			//String name = JOptionPane.showInputDialog(this, "what is your name?", "name", JOptionPane.QUESTION_MESSAGE);
			//JOptionPane.showMessageDialog(this, name,"your name",JOptionPane.INFORMATION_MESSAGE);
			
			Path currentRelativePath = Paths.get("");
			String s = currentRelativePath.toAbsolutePath().toString();
			System.out.println("Current absolute path is: " + s);
			
			String[] options= {"java", ".NET", "python"};
			ImageIcon icon = new ImageIcon("images/Hello World Logo.jpg");
			int answer = JOptionPane.showOptionDialog(this, "choose your language", "programmer choice", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, icon, options, 0);
			
			JDialog dialog = new JDialog(this , "Dialog Demo", false); 
			//Create new instance of JDialog, 
			// the boolean parameter decides whether to block the main window or not
			
	        JButton dialogBtn = new JButton ("OK");  
	        dialogBtn.addActionListener ( new ActionListener()  
	        		 // Add ActionListener to the button by declaring the ActionListener directly in the method
	        {  
	            public void actionPerformed( ActionEvent e )  
	            {  
	        		if(e.getSource() == dialogBtn) {
	        			dialog.setVisible(false); 
	            	} 
	            }  
	        });  
	        dialog.setLayout(new FlowLayout());  // Set the layout of the dialog
	        dialog.add( new JLabel ("Click button to continue.") );  
	        dialog.add(dialogBtn);   
	        dialog.setSize(300,300);    
	        dialog.setVisible(true); 
	        
	      //JOptionPane
			//If we want to inform the user of something we can use showMessageDialog function with 5 different message options:

			
		
	        
		}
	}
	

}
