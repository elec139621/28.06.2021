package swing9;

import javax.swing.JButton;
import javax.swing.JFrame;


//4. Using arrow function
public class EventsForthDemo {
	private JFrame frame;
	private JButton btn;
	
	public EventsForthDemo() {
		frame=new JFrame();
		btn=new JButton("Button");
		btn.setBounds(200,200,100,50);
		btn.addActionListener(e->{
			System.out.println("Button Clicked");
		});

		frame.add(btn);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new EventsForthDemo();
	}

}