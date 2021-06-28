package swing8;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MyFileChooserWindow extends JFrame implements ActionListener {

	private JButton m_btn;
	private JFileChooser m_fileChooser;
	
	public MyFileChooserWindow() throws HeadlessException {
		m_btn = new JButton("Choose File");
		m_btn.addActionListener(this);
		
		this.add(m_btn);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == m_btn) {
			m_fileChooser = new JFileChooser();//Create new instance of JFileChooser
			
			FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
			m_fileChooser.setFileFilter(filter);
			
			m_fileChooser.setCurrentDirectory(new File("c:\\temp"));//Set the directory that will be opened to the project directory.
														   //We can specify other directory such as desktop by passing it's full path
			
			int response = m_fileChooser.showOpenDialog(this);//Select file to open. we are saving the response to int variable
			
			if(response == JFileChooser.APPROVE_OPTION) {//If the user approved meaning clicked open or save
				//File file = new File(m_fileChooser.getSelectedFile().getAbsolutePath());//Create new File object and initialize it with path of the file the user chose
				//file.na
				System.out.println(m_fileChooser.getSelectedFile().getAbsolutePath());//Printing the file object will print it's path
				
			}
		}
	}

}
