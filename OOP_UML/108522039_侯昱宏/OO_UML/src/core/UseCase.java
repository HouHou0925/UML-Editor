package core;
import java.awt.*;



public class UseCase extends BasicComponent {
	
	public UseCase(String str, Point p){
        super(str,p,new Dimension(150,75));
       
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x1 = 0;
        int y1 = 0;
        int width = this.getWidth();
        int height = this.getHeight();
        int x2 = x1 + width ;
        int y2 = y1 + height;
//        g.setColor(Color.LIGHT_GRAY);
//        g.fillOval(0,0,width,height);
//        g.setColor(Color.black);
//        g.drawString(name,50,50);
        int stringWidth = g.getFontMetrics(font).stringWidth(name);
		double empty = (Math.abs(x1-x2) - stringWidth)/2;
		g.setFont(font);	
		g.drawString(name, x1 + (int)empty, y1 + 45);
    }

    @Override
    public void paintBorder(Graphics g){
        super.paintBorder(g);
        g.setColor(Color.black);
        int width = this.getWidth();
        int height = this.getHeight();
        g.drawOval(0,0,width,height);
    }
	
	
	

}
