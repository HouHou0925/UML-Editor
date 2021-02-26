package core;

import java.awt.*;

public class Class extends BasicComponent {

    public Class(String str, Point p){
        super(str,p,new Dimension(100,90));

        
        
        
    }

    @Override
    public void paintComponent(Graphics g){
//        super.paintComponent(g);
    	int width = this.getWidth();
        int height = this.getHeight();
        int x = 0;
        int y = 0;
        int x2 = x + width;
		int y2 = y + height;
        
        int offset = height/3;
//
        g.setColor(Color.black);
        
		
		int portion = height / 3;
		g.drawLine(x, y + portion, x2, y + portion);
		g.drawLine(x, y + portion * 2, x2, y + portion * 2);
		
		int stringWidth = g.getFontMetrics(font).stringWidth(name);
		
		double empty = (Math.abs(x-x2) - stringWidth)/2;
		g.setFont(font);	
		g.drawString(name, x + (int)empty, y + portion/2+7/2); //字的位置而已
    	
    	
    }


    @Override
    public void paintBorder(Graphics g){
        super.paintBorder(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.black);
        g2d.setStroke(new BasicStroke(2));
        g2d.drawRect(0,0,this.getWidth(),this.getHeight());
    }


}
