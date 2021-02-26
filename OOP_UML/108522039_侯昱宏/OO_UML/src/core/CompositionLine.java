package core;

import java.awt.*;

public class CompositionLine extends Line {
	

	 public CompositionLine(Port source, Port target){
	        super(source, target);
	    }

	    @Override
	    public void paintComponent(Graphics g){
	        super.paintComponent(g);
	        g.setColor(Color.BLACK);
	        int dis = (int) begin.distance(end);
	        int size=8;
	        Point online = new Point(end.x+size*(begin.x-end.x)/dis,end.y+size*(begin.y-end.y)/dis);
	        Point twoonline = new Point(end.x+size*2*(begin.x-end.x)/dis,end.y+size*2*(begin.y-end.y)/dis);
	        Point normal = new Point(-size*(end.y-begin.y)/dis,size*(end.x-begin.x)/dis);
	        int x[]={end.x,online.x+normal.x,twoonline.x,online.x-normal.x};
	        int y[]={end.y,online.y+normal.y,twoonline.y,online.y-normal.y};
	        g.drawLine(begin.x,begin.y,twoonline.x,twoonline.y);
	        g.drawPolygon(x, y, 4);
	    }
	

}
