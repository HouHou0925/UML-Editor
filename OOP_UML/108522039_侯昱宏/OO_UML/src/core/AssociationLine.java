package core;

import javax.swing.*;

import java.awt.*;

public class AssociationLine extends Line {
	 
	
	   public AssociationLine(Port source,Port target){
	        super(source,target);
	    }

	    @Override
	    public void paintComponent(Graphics g){
	        super.paintComponent(g);
	        g.setColor(Color.BLACK);
	        g.drawLine(begin.x,begin.y,end.x,end.y);
	    }

}
