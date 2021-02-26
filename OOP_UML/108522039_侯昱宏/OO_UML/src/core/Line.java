package core;




import javax.swing.*;
import java.awt.*;

public class Line extends JComponent {
    public Port src, dst;
    public Point begin,end;
    public int width, height;

    public Line(){}

    public Line(Port source,Port target){
        src = source;
        dst = target;
        width = 960;
        height = 720;
        begin = source.coord;
        end = target.coord;
        setBounds(0,0,width,height);
    }

    public void setBegin(Point p){
        begin = p;
    }

    public void setEnd(Point p){
        end = p;
    }

}