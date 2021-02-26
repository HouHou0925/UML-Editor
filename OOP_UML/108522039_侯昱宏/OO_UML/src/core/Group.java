package core;



import javax.swing.*;
import java.awt.*;
import java.util.Vector;
import core.Shape;

public class Group extends Shape {
	private Vector<Shape> shapes = new Vector<Shape>();
	private Rectangle bounds = new Rectangle();
	private Shape selectedShape = null;


	 public Group(){
	       
		 	point = new Point(0,0) ;
		 	dim = new Dimension(1,1);
		 
	    }
	
	public void resetLocation(int moveX, int moveY) {
		for (int i = 0; i < shapes.size(); i++) {
			Shape shape = shapes.get(i);
			shape.resetLocation(moveX, moveY);
		}
		resetBounds(moveX, moveY);
	}


//
//	public void changeName(String name) {
//		selectedShape.changeName(name);
//	}

//	public void resetSelectedShape() {
//		selectedShape = null;
//	}
//	
//	public Shape getSelectedShape() {
//		return selectedShape;
//	}
	
	public void setBounds() {
		/* find most left and right objects, set group bounds */
		Point upLeftP, bottomRightP;
		int leftX = Integer.MAX_VALUE, rightX = Integer.MIN_VALUE;
		int upY = Integer.MAX_VALUE, bottomY = Integer.MIN_VALUE;

		for (int i = 0; i < shapes.size(); i++) {
			Shape shape = shapes.get(i);
			
			
			
			if (shape.getPoint().x < leftX) {
				leftX = shape.getPoint().x;
			}
			if (shape.getPoint().x + shape.getDim().width > rightX) {
				rightX =shape.getPoint().x + shape.getDim().width;
			}
			if (shape.getPoint().y < upY) {
				upY = shape.getPoint().y;
			}
			if (shape.getPoint().y+shape.getDim().height > bottomY) {
				bottomY = shape.getPoint().y+shape.getDim().height;
			}
		}

		upLeftP = new Point(leftX, upY);
		bottomRightP = new Point(rightX, bottomY);
		bounds.setBounds(upLeftP.x, upLeftP.y, Math.abs(upLeftP.x - bottomRightP.x),
				Math.abs(upLeftP.y - bottomRightP.y));
		// set parent shape coordinate
		point.x =bounds.getX();
		point.y= bounds.getY();
		dim.width = bounds.getWidth();
		dim.height = bounds.getHeight();
		
		
	
	}
	
	
    public void setSelected(boolean selected) {
        this.isSelected = selected;

        for(int i=0; i < shapes.size() ; i++)
        {
        	Shape temp_s = shapes.get(i);
        	temp_s.setSelected(selected);
        	
        }

    }
	
	
	@Override
    public boolean contains(Point p) {
        return (p.x>point.x)&&(p.y>point.y)&&(p.x<point.x+dim.width)&&(p.y<point.y+dim.height);
    }
	

	protected void resetBounds(int moveX, int moveY) {
		bounds.setLocation(bounds.getX() + moveX, bounds.getY() + moveY);
		point.x =bounds.getX();
		point.y= bounds.getY();
		dim.width = bounds.getWidth();
		dim.height = bounds.getHeight();
		
	}

	public void addShapes(Shape shape) {
		shapes.add(shape);
	}

	public Vector<Shape> getShapes() {
		return shapes;
	}
	
	public Rectangle get_gectangle() {
		return bounds;
	}
	
	
}