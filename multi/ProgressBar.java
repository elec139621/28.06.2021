package swinga;

import java.awt.*;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.swing.*;


//In this demo I upgraded the progress bar from the components tutorial
//1. Change the main method to use SwingUtilities.invokeLater()
//2. Create LongTask and execute instead of progress method.
public class ProgressBar {
	
	private JFrame frame;
	private JProgressBar bar;
	private LongTask longTask;

	ProgressBar(){
		UIManager.put("ProgressBar.selectionBackground",Color.BLACK);
		UIManager.put("ProgressBar.selectionForeground",Color.BLACK);
		
		frame= new JFrame();
		bar= new JProgressBar();
		bar.setValue(0);
		bar.setBounds(100, 50, 300, 30);
		bar.setStringPainted(true);
		bar.setFont(new Font("DAVID", Font.BOLD, 20));
		bar.setForeground(Color.GREEN);
		bar.setBackground(Color.WHITE);
		
		
		frame.add(bar);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setSize(500,500);
		frame.setVisible(true);
		
		longTask=new LongTask();
		longTask.execute();
	}
	
	//Private inner class the extends SwingWorker 
	//The generic parameters are: 
	//T (String)- the result type returned by this SwingWorker's doInBackground and get methods
	//V (Integer)- the type used for carrying out intermediate results by this SwingWorker's publish and process methods
	private class LongTask extends SwingWorker<String, Integer> {
		
		//This method will be invoked when we will call flipTask.Execute()
		@Override
		protected String doInBackground() {
			int counter = 0;
			while (counter<=100 ) {

				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				counter+=10;
				publish(counter);//The publish method sends data to the process 
								 //We will use this method from within doInBackground() method
								 //We will use it order to update the GUI while still in process
			}
			return "Completed!";
		}
		
		@Override
		protected void done() {
			String s="";
			try {
				s = get();
			} catch (InterruptedException e) {
			     // This is thrown if the thread's interrupted.
				e.printStackTrace();
			} catch (ExecutionException e) {
			     // This is thrown if we throw an exception from doInBackground.
				e.printStackTrace();
			}
			bar.setString(s);
		}
		
		//This method will be invoked after calling publish() inside the doInBackground() method
		//From within this method we will update the UI using the event dispatch thread
		//This method must get as an argument list of a specific type
		@Override
		protected void process(List<Integer> numbers) {
			bar.setValue(numbers.get(numbers.size() - 1));//set the value of the bar
		}
	}

	public static void main(String[] args) {
		//SwingUtilities.invokeLater will put the runnable task in the end of the event queue and return (asynchronous)
		//Runnable is an interface with only one method defined in it- run()
		//This interface should be implemented by any class whose instances are intended to be executed by a thread.
		//The Thread class also implements this interface
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {//This method will run
				new ProgressBar();
			}
		});
	}
}