package UI;


import java.awt.BorderLayout;
import javax.swing.JFrame;

import Mode.selectMode;



public class UMLeditor extends JFrame{
	
	
	private Button toolbar;
	private Canvas canvas;
	private Menu menubar;

	
	public UMLeditor()
	{
		
		initComponents();
		initEventListenters();
		initMenuBar();
		initCanvas();
		initButton();
        
	}
	
	private void initEventListenters() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    private void initMenuBar(){
    	menubar = new Menu();
		getContentPane().add(menubar, BorderLayout.NORTH);
    }

    private void initComponents() {
        
    	this.getContentPane().setLayout(new BorderLayout());
        this.setTitle("Houml editor");
        this.setSize(960,720);
        this.setLocationRelativeTo(null);
        this.setResizable(true);
    }

    private void initButton(){
    	toolbar = new Button();
    	toolbar.setFloatable(false);
		getContentPane().add(toolbar, BorderLayout.WEST);
    }

    private void initCanvas(){
    	canvas = Canvas.getInstance();   // Canvas is singleton In order to paint in same Panel
    	this.getContentPane().add(BorderLayout.CENTER, canvas);
    	//canvas.add(selectMode.SelectedArea);
    	
    }
	
	
	
	
	
}


