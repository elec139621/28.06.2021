package swing9;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

//In this following demos we will see different options to handle events in Java

//1. Register the event to instance of a class that implement ActionListener interface (can be any other listener interface)
//   We can do it in 3 ways: Make the class itself (EventsFirstDemo) implement the ActionListener interface, add this instance as button's action listener
//							 Create another public class in a new file that will implement the ActionListener interface, add instance of this class as  button's action listener
//							 Create inner private class that will implement the ActionListener interface, add instance of this class as button's action listener
//In this demo we will see the first and third options
public class EventsFirstDemo /*implements ActionListener*/ {
	private JFrame frame;
	private JButton btn, btn2;
	
	public EventsFirstDemo() {
		frame=new JFrame();
		btn=new JButton("Button");
		btn.setBounds(200,200,100,50);
		//btn.addActionListener(this);
		btn.addActionListener(new InnerClass());

		//Now lets try and add another button
		btn2=new JButton("Button 2");
		btn2.setBounds(300,200,100,50);
		btn2.addActionListener(new InnerClass());//Let's try and register it to the same event listener

		frame.add(btn);
		frame.add(btn2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	private class InnerClass implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {//We can get different data from events. In this case get we get the source of the event (btn),
			  										//We can then get  different information from the source such as it's name, text etc..
			if(e.getSource()==btn)//Check the source of the event and decide which action to run using if-else on the event's source
				System.out.println("First Button Clicked");	
			else if(e.getSource()==btn2)
				System.out.println("Second Button Clicked");	
		}
	}
	
	public static void main(String[] args) {
		new EventsFirstDemo();
	}


	//@Override
	//public void actionPerformed(ActionEvent e) {
	//	System.out.println("Button Clicked");
	//}
}