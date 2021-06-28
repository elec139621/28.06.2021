package swing9;

import java.awt.event.ActionListener;
import java.beans.EventHandler;

import javax.swing.JButton;
import javax.swing.JFrame;


//3. Using beans.EventHandler
public class EventsThirdDemo {
	private JFrame frame;
	private JButton btn;
	
	public EventsThirdDemo() {
		frame=new JFrame();
		btn=new JButton("Button");
		btn.setBounds(200,200,100,50);
		btn.addActionListener(EventHandler.create(ActionListener.class, this, "someMethod"));
		frame.add(btn);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	
	public void someMethod() {
		System.out.println("Button Clicked");	
	}
	
	public static void main(String[] args) {
		new EventsThirdDemo();
	}

}