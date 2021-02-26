package core;


import javafx.util.Pair;
import java.util.Vector;
import java.awt.*;
import javax.swing.*;

public class Port extends JComponent {
	
	public Point coord;
    public BasicComponent parent;
    public Vector<Pair<Line,Integer>> lines;
    private static int width = 5;
    private static int height = 5;
    private static int offset = 20;

    public Port(Point p, BasicComponent com){
        coord = p;
        parent = com;
        lines = new Vector<Pair<Line,Integer>>();
        setVisible(false);
        setLocation(p);
    }

    @Override
    public boolean contains(Point p) {
        return (p.x>coord.x-offset)&&(p.y>coord.y-offset)&&(p.x<coord.x+width+offset)&&(p.y<coord.y+height+offset);
    }

    @Override
    public void setLocation(Point p) {
        super.setLocation(p);
        coord = p;
        setBounds(p.x,p.y,width,height);
    }

    @Override
    public BasicComponent getParent() {

    	return parent;
    }

    public void addLine(Line l,int i){
        // i:0 -> begin , i:1 -> end
        Pair<Line,Integer> pair = new Pair<>(l,i);
        lines.add(pair);
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.blue);
        g.fillRect(0,0,this.width,this.height);
    }
	

}
