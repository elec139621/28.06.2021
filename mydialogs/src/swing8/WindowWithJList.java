package swing8;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class WindowWithJList extends JFrame {

	private final DefaultListModel<String> m_list1_items;
	private final JList<String> m_jlist1, m_jlist2;
	
	public WindowWithJList() throws HeadlessException {		
			this.setSize(450, 450);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLayout(null);
			
			m_list1_items = new DefaultListModel<>();//Create new instance of DefaultListModel.
			//We don't have to explicitly specify String type inside <> since we already 
			//specified it in the declaration of the variable.
			m_list1_items.addElement("Mazda");
			m_list1_items.addElement("Mistubishi");
			m_list1_items.addElement("Ferrari");
			m_list1_items.addElement("Honda");
			
			
			m_jlist1 = new JList<>(m_list1_items);//Create new JList instance and initialize it with the list we created
			m_jlist1.setBounds(100, 100, 75, 75);
			
			m_jlist2 = new JList<>(new String[] {"Red", "Black", "White", "Blue"}) ;
			//Another way to create JList is using simple array.
			// We can declare the array before initialize or within the list initialization.
			//Note- this is not type safe as the generic DefaultListModel
			m_jlist2.setBounds(100, 200, 75, 75);

			this.add(m_jlist1);
			this.add(m_jlist2);
			
			m_jlist1.addKeyListener(new KeyAdapter() {
				 public void keyPressed(KeyEvent e) {
			            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			                System.out.println("ENTER pressed");
			                for (String item : m_jlist1.getSelectedValuesList()) {
			                	System.out.println(item);
			                }
			            }
			        }
			});
			m_jlist1.addMouseListener(new MouseAdapter() {
		        public void mouseClicked(MouseEvent e) {
		        	System.out.println(e);
		            if (e.getClickCount() == 2) {
		                System.out.println("mouse event");
		            }
		        }
		    });
			
			this.setVisible(true);
	}
	
	

}
