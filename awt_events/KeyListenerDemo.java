package swing9;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class KeyListenerDemo extends JFrame implements KeyListener {

	private JLabel label;
	private ImageIcon icon;
	
	public KeyListenerDemo() {
		icon=new ImageIcon("images/ghost.png");
		
		label=new JLabel();
		label.setBounds(0,0,128,128);
		
		label.setIcon(icon);
		
		this.add(label);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,500);
		this.setLayout(null);
		this.addKeyListener(this);
		this.setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// Invokes when a key is typed, use KeyChar for obtaining char output,
		// keyTyped is fired when a key is pressed that can be converted into a unicode character, used to find characters that are typed,
		// If the shift key is down, pressing "a" will tell keyTyped that you typed a capital A
		switch(e.getKeyChar()) {//Change the label's location by the 10 px each time we press awsd key
			case 'a': 
				label.setLocation(label.getX()-1,label.getY());
				break;
			case 'w': 
				label.setLocation(label.getX(),label.getY()-1);
				break;
			case 's': 
				label.setLocation(label.getX(),label.getY()+1);
				break;		
			case 'd': 
				label.setLocation(label.getX()+1,label.getY());
				break;	
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// Invokes when a key is pressed down, use KeyCode for obtaining raw key presses. 
		// If the shift key is down, pressing "a" will just get the "a" key, without capital or lowercase designations
		switch(e.getKeyCode()) {//Change the label's location by the 10 px each time we press arrow key
		case 37: 
			label.setLocation(label.getX()-10,label.getY());
			break;
		case 38: 
			label.setLocation(label.getX(),label.getY()-10);
			break;
		case 39: 
			label.setLocation(label.getX()+10,label.getY());
			break;		
		case 40: 
			label.setLocation(label.getX(),label.getY()+10);
			break;	
	}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// Invokes when a key is released
		System.out.println("Key char released: " + e.getKeyChar());//print the char of the released key
		System.out.println("Key code released: " + e.getKeyCode());//print the code of the released key
	}
	
	public static void main(String[] args) {
		new KeyListenerDemo();
	}
}