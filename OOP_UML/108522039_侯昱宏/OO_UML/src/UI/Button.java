package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

import Mode.Mode;
import Mode.selectMode;
import Mode.ObjMode;
import Mode.LineMode;

public class Button extends JToolBar{
	private int ToolNum = 6;
	private JButton holdBtn = null;
	private Canvas canvas;
	
	public Button() {
		canvas = Canvas.getInstance();   // Canvas is singleton 
		setLayout(new GridLayout(ToolNum, 1, 2, 2));  
		this.setBackground(new Color(0, 0, 0));
		
//		ImageIcon selectIcon = new ImageIcon("img/select.png");
		ToolBtn selectBtn = new ToolBtn("¬Ý¤T¤p","Select", new selectMode());
		add(selectBtn);
		
//		ImageIcon associateIcon = new ImageIcon("img/associate.png");
		ToolBtn associateBtn = new ToolBtn("associate", "Associate", new LineMode("associate"));
		add(associateBtn);
//		
//		ImageIcon generalIcon = new ImageIcon("img/general.png");
		ToolBtn generalBtn = new ToolBtn("general", "General", new LineMode("general"));
		add(generalBtn);
//		
//		ImageIcon compositeIcon = new ImageIcon("img/composite.png");
		ToolBtn compositeBtn = new ToolBtn("composite", "composite", new LineMode("composite"));
		add(compositeBtn);
//		
//		ImageIcon classIcon = new ImageIcon("img/class.png");
		ToolBtn classBtn = new ToolBtn("class", "Class", new ObjMode("class"));
		add(classBtn);
//		
//		ImageIcon usecaseIcon = new ImageIcon("img/usecase.png");
		ToolBtn usecaseBtn = new ToolBtn("usecase", "Usecase", new ObjMode("usecase"));
		add(usecaseBtn);

	}
	private class ToolBtn extends JButton{
		Mode ToolMode;
		
		public ToolBtn(String ToolName,String text, Mode ToolMode) {
			this.ToolMode = ToolMode;
			setToolTipText(ToolName);
			this.setText(text);
//			setIcon(icon);
			setFocusable(false);
			setBackground(new Color(200, 200, 200));
			setBorderPainted(false);
			setRolloverEnabled(true);
			setFont(new Font("Arial", Font.PLAIN, 40));
			addActionListener(new toolListener());
		}
//		
//		
//		
//		public ToolBtn(String ToolName, ImageIcon icon, Mode ToolMode) {
//			this.ToolMode = ToolMode;
//			setToolTipText(ToolName);
//			setIcon(icon);
//			setFocusable(false);
//			setBackground(new Color(200, 200, 200));
//			setBorderPainted(false);
//			setRolloverEnabled(true);
//			addActionListener(new toolListener());
//		}
		class toolListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				
				canvas.reset();
				
				if(holdBtn != null)
					holdBtn.setBackground(new Color(200, 200, 200));
				holdBtn = (JButton) e.getSource();
				holdBtn.setBackground((new Color(50, 171, 175))); 
				//canvas.currentMode = ToolMode;
				canvas.setCurrentMode(ToolMode);
//				canvas.reset();
				canvas.repaint();
			}
		}
	}
}

