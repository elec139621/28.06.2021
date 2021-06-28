package swing9;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DragPanel extends JPanel {
//This class extends JPanel and we will use this class to practice Drag & Drop using 
	
	ImageIcon image = new ImageIcon("images/ghost.png");
	final int WIDTH = image.getIconWidth();
	final int HEIGHT = image.getIconHeight();
	Point imageCorner;
	Point prevPoint;

	DragPanel() {
		imageCorner = new Point(0, 0);
		ClickListener clickListner = new ClickListener();//Create instance of ClickListener which implements the MouseAdapter's mousePressed method
		DragListener dragListner = new DragListener();//Create instance of DragListener which implements the MouseMotionAdapter's mouseDragged method
		this.addMouseListener(clickListner);//Register the ClickListener's instance to listen to mouse events on this panel
		this.addMouseMotionListener(dragListner);//Register the DragListener's instance to listen to mouse motion events on this panel
	}

	// paintComponent will repaint the image after the position of the image has changed
	public void paintComponent(Graphics g) {
		super.paintComponent(g);//call paintComponent method that belongs to the father class
		image.paintIcon(this, g, (int) imageCorner.getX(), (int) imageCorner.getY());
	}

	private class ClickListener extends MouseAdapter {
		//This is an inner class that extends MouseAdapter abstract class.
		public void mousePressed(MouseEvent e) {
			//Each time the mouse will get clicked we will set the prevPoint field to the current point clicked by the mouse
			prevPoint = e.getPoint();
		}
	}

	private class DragListener extends MouseMotionAdapter {
		//This is an inner class that extends MouseMotionAdapter abstract class.
		public void mouseDragged(MouseEvent e) {
			//Each time the mouse will be moved while its pressed down we will get the current point on the mouse
			Point currentPoint = e.getPoint();

			int dx = (int) (currentPoint.getX() - prevPoint.getX());//get the x distance between the current point and the previous
			int dy = (int) (currentPoint.getY() - prevPoint.getY());//get the y distance between the current point and the previous

			imageCorner.translate(dx, dy);//Set where to move the image corner with the x and y distances 

			prevPoint = currentPoint;//Set the previous point to be equal to the current
			
			repaint();//repaint the component
		}
	}
}