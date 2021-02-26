package UI;



import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Mode.Mode;
import core.Rectangle;
import core.BasicComponent;
import core.Group;
import core.Port;
import core.Shape;


public class Canvas extends JPanel {
	
	

    public Vector<Shape> shape_vec;
	private static Canvas instance = null; // for singleton
	
	public Vector<Port> portsVec;
	//public Rectangle SelectedArea = new Rectangle();
	public Shape selectedObj = null;
	public boolean has_selectedObj= false  ;
	protected Mode currentMode = null;
//
//	private List<Shape> shapes = new ArrayList<Shape>();
//
//	public Shape tempLine = null;
//	public Rectangle SelectedArea = new Rectangle();
//	public Shape selectedObj = null;

	/* Singleton design pattern */
	private Canvas() {
		
		this.setLayout(null); // for specific Point
        this.setOpaque(true);
        this.setBackground(Color.white);
        shape_vec = new Vector<Shape>();
        portsVec = new Vector<Port>();
        
		
		
		// Exists only to defeat instantiation.
	}

	public static Canvas getInstance() {
		if (instance == null) {
			instance = new Canvas();
		}
		return instance;
	}

	public void setCurrentMode(Mode Mode) {
		this.removeMouseListener(currentMode);
        this.removeMouseMotionListener(currentMode);
        currentMode = Mode;
        this.addMouseListener(currentMode);
        this.addMouseMotionListener(currentMode);
		
		System.out.println(currentMode);
	}
//	
	public void reset() {
		if(selectedObj != null){
			selectedObj.setSelected(false);
			selectedObj.resetSelectedShape();   // for selected shape inside the group
			selectedObj = null;
		}
		
		for (int i = shape_vec.size() - 1; i >= 0; i--) {
			Shape shape = shape_vec.get(i);
			shape.setSelected(false);
			
			
		}
		
		has_selectedObj = false ;
		//SelectedArea.setBounds(0, 0, 0, 0);
	}

	public void GroupShape() {
		
        int count = 0;
        for(Shape tmp:shape_vec)
        {
            if(tmp.isSelected())
            	count++;            
        }
       
        if(count<2)  
        {
        	return ;
        }
        	
        
		
		
		Group group = new Group();
		for (int i = 0; i < shape_vec.size(); i++) {
			Shape shape = shape_vec.get(i);
			if (shape.isSelected()) {
				group.addShapes(shape);
				System.out.println(shape_vec.size());
				shape_vec.remove(i);
				System.out.println(shape_vec.size());
				i--;
				shape.setSelected(false);
			}
		}
		group.setBounds();
		shape_vec.add(group);
		this.add(group.get_gectangle());
		this.repaint();
		
		
	}
	public void removeGroup() {
		Group group = (Group) selectedObj;
		List<Shape> groupShapes = group.getShapes();
		for(int i = 0; i < groupShapes.size(); i++){
			Shape shape = groupShapes.get(i);
			shape_vec.add(shape);
		}
		shape_vec.remove(selectedObj);
		this.remove(group.get_gectangle());
		this.repaint();
		
		
	}


}