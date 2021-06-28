package swing9;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;


public class KeyBindingsDemo {
	//Key Bindings- bind an action to a key stroke, we don't have to be focused on the component in order for it to react to the key stroke
	//All swing components can use key bindings. It is more flexible than KeyListeners, you can assign key stroke to individual swing component.
	//It can save us the switch case on checking which key has been pressed. It can also help us reusing same actions for several components or several key strokes.
	
	private JFrame frame;
	private JLabel label;
	//Create 4 Actions, Action is an interface that provides a useful extension to the ActionListener interface
	//in cases where the same functionality may be accessed by several controls. 
	private Action upAction, downAction, leftAction, rightAction;
	
	public KeyBindingsDemo() {
		frame=new JFrame();
		label=new JLabel();
		label.setBackground(Color.blue);
		label.setBounds(100, 100, 100, 100);
		label.setOpaque(true);
		
		//Initialize the 4 actions
		upAction=new UpAction();
		downAction=new DownAction();
		leftAction=new LeftAction();
		rightAction=new RightAction();
		
		//We need to get the input map from the label and put into it the key stroke that will trigger the action and custom name we choose that will our key
		label.getInputMap().put(KeyStroke.getKeyStroke('w'), "upAction");
		//Now we will get the action map from the label and put into it the key we defined and an instance of the action 
		label.getActionMap().put("upAction", upAction);
		
		//Do the same for the other actions
		label.getInputMap().put(KeyStroke.getKeyStroke('s'), "downAction");
		label.getActionMap().put("downAction", downAction);
		
		label.getInputMap().put(KeyStroke.getKeyStroke('a'), "leftAction");
		label.getActionMap().put("leftAction", leftAction);
		
		label.getInputMap().put(KeyStroke.getKeyStroke('d'), "rightAction");
		label.getActionMap().put("rightAction", rightAction);
		
		frame.add(label);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	
	//Create 4 inner classes that extends AbstractAction
	//AbstractAction is an abstract class that provides default implementation of the Action interface
	//In each class we will override the actionPerformed method and within this method we will change the location of the label
	
	@SuppressWarnings("serial")
	public class UpAction extends AbstractAction{
		@Override
		public void actionPerformed(ActionEvent e) {
			label.setLocation(label.getX(), label.getY()-10);
		}	
	}
	
	@SuppressWarnings("serial")
	public class DownAction extends AbstractAction{
		@Override
		public void actionPerformed(ActionEvent e) {
			label.setLocation(label.getX(), label.getY()+10);
		}	
	}
	
	@SuppressWarnings("serial")
	public class LeftAction extends AbstractAction{
		@Override
		public void actionPerformed(ActionEvent e) {
			label.setLocation(label.getX()-10, label.getY());
		}	
	}
	
	@SuppressWarnings("serial")
	public class RightAction extends AbstractAction{
		@Override
		public void actionPerformed(ActionEvent e) {
			label.setLocation(label.getX()+10, label.getY());
		}	
	}
	
	public static void main(String[] args) {
		new KeyBindingsDemo();
	}
}