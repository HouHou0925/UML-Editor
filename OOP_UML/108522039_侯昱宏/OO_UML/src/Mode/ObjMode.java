package Mode;


import java.awt.event.MouseEvent;

import core.BasicComponent;
import core.Class;
import core.Port;
import core.UseCase;

public class ObjMode extends Mode{
	
	
	 private BasicComponent basicObj;
	private String objType = null;
	public ObjMode(String objType) {
		this.objType = objType;
	}
	
	public ObjMode(){}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(objType.equals("class")){
			basicObj = new Class(objType,e.getPoint());
			
		}
		else if(objType.equals("usecase")){
			basicObj = new UseCase(objType,e.getPoint());
		}
		
		canvas.add(basicObj);
		for(Port tmp:basicObj.ports){
            canvas.add(tmp);
            canvas.portsVec.add(tmp);
        }
		
		canvas.shape_vec.add(basicObj);
		canvas.repaint();
	}

}
