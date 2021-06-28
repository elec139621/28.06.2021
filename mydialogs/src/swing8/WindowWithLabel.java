package swing8;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class WindowWithLabel  extends JFrame {
	
	JLabel m_label;

	public WindowWithLabel() throws HeadlessException {
		super();
		this.setSize(700,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setVisible(true);
		
		ImageIcon image = new ImageIcon("images/Hello World Logo.jpg");
		this.setIconImage(image.getImage());
		
		this.getContentPane().setBackground(Color.white); //Set the frame's background color using awt colors
		m_label = new JLabel("Hello world");
		
		m_label.setText("new text");
		m_label.setIcon(image);
		//m_label.setHorizontalTextPosition(JLabel.CENTER);
		//m_label.setIconTextGap(15);
		m_label.setFont(new Font("DAVID", Font.BOLD, 20));
		
		m_label.setBackground(Color.yellow);
		m_label.setOpaque(true);
		m_label.setBounds(0,100,200,200);
		
		Border border = BorderFactory.createLineBorder(Color.DARK_GRAY,4);
		m_label.setBorder(border);
		
		this.add(m_label);
		//this.remove(m_label);
		
		//this.removeAll();
	}
	
	

}
