package core;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JComponent;

public class Rectangle extends JComponent {
	
	
	protected Dimension dim = null ;
	
	
	
	@Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
        setDim(new Dimension(width,height));
        
        
    }
	
	
	@Override
    public boolean contains(Point p) {
        return (p.x>=super.getX())&&(p.y>=super.getY())&&
        		(p.x<super.getX()+super.getWidth())&&(p.y<super.getY()+super.getHeight());
        
    }
	
	
	public void setDim(Dimension dim) {
        this.dim = dim;
    }


	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.drawRect(0,0,dim.width-1,dim.height-1);
    }
	
}
