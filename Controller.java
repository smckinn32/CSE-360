
/************************************************************
 * Author: Emerson Carter
 * Date: 3/22/2022
 * Class: CSE360 Mon 3pm
 ************************************************************/


import java.awt.Component;
import java.awt.event.*;

public class Controller extends MouseAdapter implements ActionListener {
	private boolean debug = true;
	private Object source = null;
		
	/*
	 * Extends just the mousePressed function, allowing recognition of all mouse
	 * buttons operating similar to other windows applications
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		if(debug) //Print debug data
		{
			System.out.println(e.getComponent() + "; " + e.getX() + ", " + e.getY());
		}
		
		//Set the UI element action is being performed on
		if(!(null == e.getComponent()))
		{
			setElement(e.getComponent());
		}
	}
	
	
	/*
	 * Implementation of the ActionListener class, to make buttons functional
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(debug) //Print debug data
		{
			System.out.println(e.getSource() + "...button pressed");
		}
		
		//Set the UI element action is being performed on
		if(!(null == e.getSource()))
		{
			setElement(e.getSource());
		}
		System.exit(0);
	}
	
	
	/*
	 * Set the GUI source element being interacted with
	 */
	private void setElement(Object o)
	{
		source = o;
	}
	
	/*
	 * Return the GUI source element being interacted with
	 */
	public Object getElement()
	{
		return source;
	}
}
