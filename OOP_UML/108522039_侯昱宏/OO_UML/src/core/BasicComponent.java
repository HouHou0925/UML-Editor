package core;

import javafx.util.Pair; 

import javax.swing.*;

import UI.Canvas;

import java.awt.*;
import java.util.Vector;


public class BasicComponent extends  Shape{
	
	
	public String name;
	public Vector<Port> ports;
	private final static int num = 4;
	protected Font font = new Font(Font.DIALOG, Font.BOLD, 14);
	
	public BasicComponent(){}
	
	public BasicComponent(String str,Point p,Dimension d){
	    
		point = p;
	    dim = d;
	    name = str;
	    isSelected = false;
	    ports = new Vector<Port>();
	
	    for(int i=0;i<num;i++){
	        ports.add(new Port(point,this));
	    }
	    setLocation(p);
	    
	}
	@Override
	protected void setPort(Point p){
        for(int i=0;i<num;i++){
            Port tmp = ports.get(i);
            if(i==0){ //top
                tmp.setLocation(new Point(p.x+dim.width/2,p.y-5));
            }else if(i==1){ //left
                tmp.setLocation(new Point(p.x-5,p.y+dim.height/2));
            }else if(i==2){ // right
                tmp.setLocation(new Point(p.x+dim.width,p.y+dim.height/2));
            }else if(i==3){
                tmp.setLocation(new Point(p.x+dim.width/2,p.y+dim.height));
            }

            // set line point of this port
            for(Pair<Line,Integer> pair:tmp.lines){
                Line l = pair.getKey();
                Integer flag = pair.getValue();
                if(flag==0){
                    l.setBegin(tmp.coord);
                }else if(flag==1){
                    l.setEnd(tmp.coord);
                }
            }
        }
    }
	
	
	@Override
    public boolean contains(Point p) {
        return (p.x>point.x)&&(p.y>point.y)&&(p.x<point.x+dim.width)&&(p.y<point.y+dim.height);
    }

    @Override
    public void setLocation(Point p) {
        super.setLocation(p);
        point = p;
        setBounds(p.x,p.y,dim.width,dim.height);
        setPort(p);
    }
    
    @Override
    public void setName(String name) {
        this.name = name;
    }

    public void setSelected(boolean selected) {
        this.isSelected = selected;

        for(int i=0;i<num;i++){
            ports.get(i).setVisible(selected);
        }

    }

    public boolean isSelected() {
        return isSelected;
    }

  

    public void setPoint(Point point) {
        this.point = point;
    }

    public void resetLocation(int moveX, int moveY) {
    	point.x = this.point.x + moveX;
		point.y = this.point.y + moveY;
		setBounds(point.x,point.y,dim.width,dim.height);
        setPort(point);
		
		
	}
	
	

}
