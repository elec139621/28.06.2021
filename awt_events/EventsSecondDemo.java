package swing9;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


//2. Using Anonymous objects we can add new instance of ActionListener without explicitly implementing an interface
public class EventsSecondDemo {
	private JFrame frame;
	private JButton btn;
	
	public EventsSecondDemo() {
		frame=new JFrame();
		btn=new JButton("Button");
		btn.setBounds(200,200,100,50);
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Button Clicked");
			}		
		});

		frame.add(btn);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new EventsSecondDemo();
	}

}