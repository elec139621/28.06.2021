package swing8;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class WindowWithMenuBar extends JFrame implements ActionListener {

	private JMenuBar m_menuBar;
	private JMenu m_fileMenu, m_editMenu, m_helpMenu;
	private ImageIcon m_fileIcon; 
	private JMenuItem m_newItem, m_saveItem, m_exitItem;
	private JPopupMenu popupMenu;
	private JMenuItem m_cut, m_copy, m_paste;
	private ArrayList<JMenuItem> m_menuItems;
	
	public WindowWithMenuBar() throws HeadlessException {
		this.setSize(450, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		
		m_menuBar = new JMenuBar();//Create new instance of JMenuBar
		
		//Create 3 JMenu instances with text for each
		m_fileMenu= new JMenu("File");
		m_editMenu= new JMenu("Edit");
		m_helpMenu= new JMenu("Help");
		
		//Create 3 JMenuItems instances with text for each
		m_newItem= new JMenuItem("New");
		m_saveItem= new JMenuItem("Save");
		m_exitItem= new JMenuItem("Exit");

		//Set icon to menu item
		m_fileIcon=new ImageIcon("Images/file icon.png");
		m_newItem.setIcon(m_fileIcon);
		
		//Register all 3 menuItems to ActionListener (this instance)
		m_newItem.addActionListener(this);
		m_saveItem.addActionListener(this);
		m_exitItem.addActionListener(this);

		//Set KeyEvent that will open each menu
		m_fileMenu.setMnemonic(KeyEvent.VK_F);//Alt+f
		m_editMenu.setMnemonic(KeyEvent.VK_E);//Alt+e
		m_helpMenu.setMnemonic(KeyEvent.VK_H);//Alt+h
		
		//Set KeyEvent to each menu item in file menu. Note- the menu has to be open in order for  
		m_newItem.setMnemonic(KeyEvent.VK_N);//n
		m_saveItem.setMnemonic(KeyEvent.VK_S);//s
		m_exitItem.setMnemonic(KeyEvent.VK_E);//e
		//If the key is the same as the first letter of the text in the item this letter will be underlined

		//Add the JMenuItems object to the fileMenu
		m_fileMenu.add(m_newItem);
		m_fileMenu.add(m_saveItem);
		m_fileMenu.add(m_exitItem);

		//Add the JMenu objects to the menubar
		m_menuBar.add(m_fileMenu);
		m_menuBar.add(m_editMenu);
		m_menuBar.add(m_helpMenu);
		
		popupMenu= new JPopupMenu("Edit");//Create new JPopupMenu instance with Edit title
		//Create 3 JMenuItem for cut copy paste
		m_cut = new JMenuItem("Cut");  
        m_copy = new JMenuItem("Copy");  
        m_copy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("choosed copy!");
				
			}
        	
        });
        m_paste = new JMenuItem("Paste");  
        
        m_editMenu.add(m_cut);
        m_editMenu.add(m_copy);
        m_editMenu.add(m_paste);
        
        //Add the 3 JMenuItem to the popupMenu
        popupMenu.add(m_cut);
        popupMenu.add(m_copy); 
        popupMenu.add(m_paste);       
        
        m_newItem.addActionListener(this);
        
        m_menuItems = new ArrayList<>();
        m_menuItems.add(m_copy);
        m_menuItems.add(m_cut);
        m_menuItems.add(m_paste);
        for(JMenuItem item : m_menuItems) {
        	item.addActionListener(this);
        }
        
        this.setJMenuBar(m_menuBar);//Setting the menu bar to the frame
        this.add(popupMenu);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setSize(500,500);
        this.setVisible(true);
        
        JFrame self = this;
        this.addMouseListener(new MouseAdapter() {  
            public void mouseClicked(MouseEvent e) {  
            	System.out.println(e);
            	if(e.getButton() == MouseEvent.BUTTON3) {
            		//Check if the button that was clicked on the mouse is the right button
            		popupMenu.show(self, e.getX(), e.getY());  
            		//open the popupMenu at the same location where the user clicked
            		System.out.println("mouse clicked");
            	}                 
            }
         });
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == m_newItem) {
			System.out.println("ctreate a new file!");
		}
		else if(e.getSource() == m_exitItem) {
			System.exit(0);//Exit the system with status code 0
		}
	}
	
	

}
