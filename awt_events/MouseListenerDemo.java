package swing9;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MouseListenerDemo extends JFrame implements MouseListener{

	private JLabel label;
	
	MouseListenerDemo(){
		label= new JLabel();
		label.setBounds(200,200,100,100);
		label.setBackground(Color.BLUE);
		label.setOpaque(true);
		label.addMouseListener(this);
		
		this.add(label);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		this.setLayout(null);
		this.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// Invoked when the mouse has been clicked (pressed and released) on a component
		System.out.println("Mouse Clicked");
		label.setBackground(Color.GREEN);

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// Invoked when the mouse has been pressed on a component
		System.out.println("Mouse Pressed");
		label.setBackground(Color.RED);

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// Invoked when the mouse has been released on a component
		System.out.println("Mouse Released");
		label.setBackground(Color.PINK);

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// Invoked when the mouse enters a component
		System.out.println("Mouse Entered");
		label.setBackground(Color.YELLOW);

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// Invoked when the mouse leaves a component
		System.out.println("Mouse Exited");
		label.setBackground(Color.BLACK);

	}
	
	public static void main(String[] args) {
		new MouseListenerDemo();
	}
}