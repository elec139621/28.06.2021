package swing9;


import javax.swing.JButton;
import javax.swing.JFrame;


public class EventsFifthDemo {
	private JFrame frame;
	private JButton btn;
	
	public EventsFifthDemo() {
		frame=new JFrame();
		btn=new JButton("Button");
		btn.setBounds(200,200,100,50);
		
		//We can add multiple ActionListeners to each component that will be invoked when the event is raised
		btn.addActionListener(e->{
			System.out.println("Button Clicked");
		});

		btn.addActionListener(e->{
			System.out.println(e.getSource());
		});
		
		
		frame.add(btn);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new EventsFifthDemo();
	}

}