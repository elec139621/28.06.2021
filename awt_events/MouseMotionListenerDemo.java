package swing9;

import javax.swing.JFrame;

//In this demo we will also use the DragPanel.java file with DragPanel class defined in it
@SuppressWarnings("serial")
public class MouseMotionListenerDemo extends JFrame{
	//This class will extend JFrame and will be used as the main window
	
	private DragPanel dragPanel;//Define variable of type DragPanel
	
	MouseMotionListenerDemo(){
		dragPanel= new DragPanel();//Assign new DragPanel instance
		this.add(dragPanel);
		
		this.setTitle("Drag & Drop");
		this.setSize(600,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new MouseMotionListenerDemo();
	}

}