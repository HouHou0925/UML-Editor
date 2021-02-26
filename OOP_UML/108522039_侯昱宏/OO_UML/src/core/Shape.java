package core;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JComponent;

public abstract class  Shape extends JComponent {
	
	protected boolean isSelected = false ;
	protected Point point;
	protected Dimension dim;
	//basic
	protected void setPort(Point p) {}
	
	
	public void setSelected(boolean selected) {}

    public boolean isSelected() {
        return isSelected;
    }
	
    public Point getPoint() {
        return point;
    }
    
    public Dimension getDim() {
        return dim;
    }
    public void resetLocation(int moveX, int moveY){}  

	
	
	// Group
	public void resetSelectedShape() {}
	public Shape getSelectedShape() {
		return null;
	}
	
}
