package swing8;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class WindowWithJTextField extends JFrame {

	private JTextField m_text_id;
	private JLabel m_label_id;
	private JTextField m_text_name;
	private JLabel m_label_name;
	private JPasswordField m_text_pwd;
	private JLabel m_label_pwd;
	private JCheckBox m_chk_veg;
	private JSpinner m_dateSpinner;

	public WindowWithJTextField() throws HeadlessException {
		
		this.setSize(700,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
			
		//this.getContentPane().setBackground(Color.white); //Set the frame's background color using awt colors
		
		m_text_id = new JTextField();
		m_text_id.setPreferredSize(new Dimension(300,50));
		m_text_id.setFont(new Font("Consolas", Font.PLAIN, 40));//Set font
		m_text_id.setText("");
		m_text_id.setEnabled(true);
		m_text_id.setBounds(150,50,300,110);
		
		m_label_id = new JLabel();
		m_label_id.setText("id:");
		m_label_id.setFont(new Font("DAVID", Font.BOLD, 20));	
		m_label_id.setBounds(50,0,200,200);
		
		
		m_text_name = new JTextField();
		m_text_name.setPreferredSize(new Dimension(300,50));
		m_text_name.setFont(new Font("Consolas", Font.PLAIN, 40));//Set font
		m_text_name.setText("");
		m_text_name.setEnabled(true);
		m_text_name.setBounds(150,200,300,110);
		
		m_label_name = new JLabel();
		m_label_name.setText("name:");
		m_label_name.setFont(new Font("DAVID", Font.BOLD, 20));	
		m_label_name.setBounds(50,150,200,200); 
		
		m_text_pwd = new JPasswordField();
		m_text_pwd.setPreferredSize(new Dimension(300,50));
		m_text_pwd.setFont(new Font("Consolas", Font.PLAIN, 40));//Set font
		m_text_pwd.setText("");
		m_text_pwd.setEnabled(true);
		m_text_pwd.setBounds(150,350,300,110);
		
		m_label_pwd = new JLabel();
		m_label_pwd.setText("pwd:");
		m_label_pwd.setFont(new Font("DAVID", Font.BOLD, 20));	
		m_label_pwd.setBounds(50,300,200,200); 
		
		m_chk_veg = new JCheckBox("vegetarian?");
		m_chk_veg.setFont(new Font("DAVID", Font.BOLD, 20));
		m_chk_veg.setBounds(50,470,200,200);
		
		
		m_dateSpinner =  new JSpinner(new SpinnerDateModel(new Date(), null, null, Calendar.MONTH));
		JSpinner.DateEditor editor = new JSpinner.DateEditor(m_dateSpinner, "dd/MM/yy");
		m_dateSpinner.setFont(new Font("DAVID", Font.BOLD, 20));
		m_dateSpinner.setEditor(editor);
	    m_dateSpinner.setBounds(350,520,200,40);
	    
	    SpinnerModel value = new SpinnerNumberModel(4, 0, 10, 2);
	    
	      JSpinner spinner = new JSpinner(value);
	      spinner.setFont(new Font("DAVID", Font.BOLD, 20));
	      spinner.setBounds(350,570,200,40);
		
		// m_chk_veg.isSelected()
		m_chk_veg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("check box changed");
				
			}
			
		});
		
		
		this.add(m_label_id);
		this.add(m_text_id);
		this.add(m_label_name);
		this.add(m_text_name);
		this.add(m_label_pwd);
		this.add(m_text_pwd);
		this.add(m_chk_veg);	
		this.add(m_dateSpinner);
		this.add(spinner);
		this.setVisible(true);
		
	}
	
	

}
