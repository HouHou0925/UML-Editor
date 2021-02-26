package Mode;


import java.awt.*;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.List;

import UI.Canvas;
import core.BasicComponent;
import core.Group;
import core.Rectangle;
import core.Shape;

public class selectMode extends Mode {
	
	private BasicComponent tmp;
	private Point startPoint,endPoint;
	private int has_selectobj_number = 0 ;
	public Rectangle SelectedArea = new Rectangle();
	
	public selectMode(){
		canvas = Canvas.getInstance();
	    //tmp = new BasicComponent();
	    startPoint = new Point();
	    endPoint = new Point();
	    canvas.add(SelectedArea);
	  
	
	}
	
	
	
	public void mousePressed(MouseEvent e) {
		startPoint = e.getPoint();
		boolean isempty = true ; //是否按在空白處

		// reset
		for (int i = canvas.shape_vec.size() - 1; i >= 0; i--) {
			Shape shape = canvas.shape_vec.get(i);
			if( shape.contains(e.getPoint()) )
			{
				isempty = false ;
				break;
			}
			
			
		}
		
		if( has_selectobj_number < 2 || isempty)
		{
			has_selectobj_number = 0 ;
			canvas.reset();
		}
			
		
		if (!isempty)
		{
			/* find which basic object, record its reference */
			for (int i = canvas.shape_vec.size() - 1; i >= 0; i--) {
				Shape shape = canvas.shape_vec.get(i);
			
				if (shape.contains(e.getPoint())) {
					canvas.selectedObj = shape;
					shape.setSelected(true);
					canvas.shape_vec.remove(i);  //深度處理
					canvas.shape_vec.add(shape);
					canvas.has_selectedObj = true ;
					break;
				}
			}
			
		}
		
		
		
		
		canvas.repaint();
	}
	
	
	
	
	
	
	@Override
	public void mouseDragged(MouseEvent e) {
		
		
		
		int moveX = e.getX() - startPoint.x;
		int moveY = e.getY() - startPoint.y;
		
		int left =  startPoint.x;
		int top =   startPoint.y;
		
		if(moveX < 0)
			left += moveX;
		if(moveY<0)
			top += moveY;
		
		
		/* object selected */
		if ( canvas.has_selectedObj) {
			
			
			
			for (int i = canvas.shape_vec.size() - 1; i >= 0; i--) {
				Shape shape = canvas.shape_vec.get(i);
				if( shape.isSelected() )
				{
					shape.resetLocation(moveX,moveY);
				}
				
				
			}
			
			
			
			startPoint.x = e.getX();
			startPoint.y = e.getY();
			
			
			
		}
		/* group area selected */
		else {
			// 左上到右下
			if (e.getX() > startPoint.x)
				SelectedArea.setBounds(left, top, Math.abs(moveX), Math.abs(moveY));
			else
				SelectedArea.setBounds(left, top, Math.abs(moveX), Math.abs(moveY));
			
			for (int i = canvas.shape_vec.size() - 1; i >= 0; i--) {
				Shape shape = canvas.shape_vec.get(i);
				shape.setSelected(false) ;
				
				if (SelectedArea != null && checkSelectedArea(shape)) {
					
					shape.setSelected(true);
					canvas.selectedObj = shape;
					canvas.shape_vec.remove(i);  //深度處理
					canvas.shape_vec.add(shape);
					
				}
				
			}
			
			
		
			
			
			
			

		}
		canvas.repaint();
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
	    super.mouseReleased(e);
	    endPoint = e.getPoint();
	    
	    //------------
	    
		
		for (int i = canvas.shape_vec.size() - 1; i >= 0; i--) {
			Shape shape = canvas.shape_vec.get(i);
			
			
			if (SelectedArea != null && checkSelectedArea(shape)) {
				
				has_selectobj_number++ ;
			
			}
			
		}
		
	    
	    
	    //------------
	    
	  
	    SelectedArea.setBounds(0, 0, 0, 0);
	    if(has_selectobj_number > 0)
			canvas.has_selectedObj=true;
	
	
	}
	
	private boolean checkSelectedArea(Shape shape) {
		Point upperleft = new Point(shape.getPoint().x, shape.getPoint().y);
		Point lowerright = new Point(shape.getPoint().x + shape.getDim().width, shape.getPoint().y + shape.getDim().height);
	
		
		/* show ports of selected objects */
		if (SelectedArea.contains(upperleft) && SelectedArea.contains(lowerright)) {
			return true;
		}
		return false;
	}

	
	

}
