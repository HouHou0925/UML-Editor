package Mode;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.List;

import core.AssociationLine;
import core.BasicComponent;
import core.CompositionLine;
import core.GeneralizationLine;
import core.Line;
import core.Port;

public class LineMode extends Mode {
	
	private String lineType = null;
	private Line tempLine = null,line = null; ;
	private Port temp_end_port = null ;
	
	protected Point A,B;
	protected BasicComponent src,dst;
	protected Port port_A,port_B;
	public LineMode(String lineType){
		
		
	    A = new Point();
	    B = new Point();
	   
	    src = null;
	    dst = null;
	    port_A = null;
	    port_B = null;
	    this.lineType = lineType;
	    
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
	    super.mousePressed(e);
	    A.setLocation(e.getPoint());
	    AutoConnect();
	    
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
	    super.mouseDragged(e);
	    for(Port p:canvas.portsVec){
	        p.setVisible(true);
	    }
	    if( src != null )
	    {
	    	
	    	
	    	
	    	if( tempLine == null )
	    	{
	    		
	    	
	    		temp_end_port = new Port(e.getPoint(),null);
	    		tempLine = this.creat(lineType);
	    		canvas.add(tempLine);
	    	}
	    	else
	    	{
	    		temp_end_port.setLocation(e.getPoint());
	    		tempLine.dst = temp_end_port ;
	    		tempLine.setEnd(e.getPoint());
//	    		System.out.println(e.getPoint());
	    		
	    		
	    	}	
	    	
	    	
//	    	tempLine.dst = temp_end_port ;
	    	
	    }
	    
	    canvas.repaint();
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
	    super.mouseReleased(e);
	    B.setLocation(e.getPoint());
	    
	    if(AutoConnect())
	    {
	    	//temp_end_port = port_B ;
	    	//canvas.remove(tempLine);
	    	//line = this.creat(lineType);
	    	
	    	
    		//canvas.add(line);
    		port_A.addLine(tempLine,0);
            port_B.addLine(tempLine,1);
            
	    	
            
	    }
	    
	    else
	    {
	    	if( tempLine != null)
	    		canvas.remove(tempLine);
	    	tempLine = null;
	    }
	    
//	    if(tempLine != null)
//	    	canvas.remove(tempLine);
	    tempLine = null;
	    
	    
	    for(Port p:canvas.portsVec){
	        p.setVisible(false);
	    }
	    
	    
	    canvas.repaint();
	    
	}
	
	protected boolean AutoConnect(){
	    src = dst = null;
	    port_A = port_B = null;
	    for(Port p:canvas.portsVec){
	        if(p.contains(A)){
	            src = p.getParent();
	            port_A = p;
	            System.out.println("Set A " + p.coord);
	        }else if(p.contains(B)){
	            dst = p.getParent();
	            port_B = p;
	            System.out.println("Set B " + p.coord);
	        }
	    }
	
	
	    if(src!=null && dst!=null && src!=dst){
	        System.out.println("Add Line Success");
	        return true;
	    }
	    return false;
	}
	
	protected Line creat(String type)
	{
		if( type.equals("associate"))
		{
			return new AssociationLine(port_A,temp_end_port);
		}
		else if(type.equals("general"))
		{
			
			return  new CompositionLine(port_A,temp_end_port);
		}
		else if(type.equals("composite"))
		{
			return  new GeneralizationLine(port_A,temp_end_port);
		}
		else {
			
		}
		return line;

		
	}
	
	
	
	
}