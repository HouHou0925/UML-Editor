package UI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import core.BasicComponent;
import core.Shape;


public class Menu extends JMenuBar {
	private Canvas canvas;
	
	public Menu() 
	{
		canvas = Canvas.getInstance();   
		
		JMenu menu;
		JMenuItem memu_list;

		/* --- File menu --- */
		menu = new JMenu("File");
		add(menu);

		/* --- Edit menu --- */
		menu = new JMenu("Edit");
		add(menu);
		
		memu_list = new JMenuItem("Change object name");
		menu.add(memu_list);
		memu_list.addActionListener(new ChangeNameListener());
		
		memu_list = new JMenuItem("Group");
		menu.add(memu_list);
		memu_list.addActionListener(new GroupObjectListener());
		
		memu_list = new JMenuItem("Ungroup");
		menu.add(memu_list);
		memu_list.addActionListener(new UngroupObjectListener());
	}
	
	private void changeNameForm() {
		JFrame inputTextFrame = new JFrame("Change Object Name");
		inputTextFrame.setSize(400, 100);
		inputTextFrame.getContentPane().setLayout(new GridLayout(0, 1));
		
		JPanel panel = null;
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JTextField Text =  new JTextField("New object Name");
		panel.add(Text);
		inputTextFrame.getContentPane().add(panel);
		
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JButton confirm = new JButton("OK");
		panel.add(confirm);
		
		JButton cancel = new JButton("Cancel");
		panel.add(cancel);

		inputTextFrame.getContentPane().add(panel);
		
		inputTextFrame.setLocationRelativeTo(null);
		inputTextFrame.setVisible(true);
		
		
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(Shape obj: canvas.shape_vec){
                    if(obj.isSelected()){
                        obj.setName(Text.getText());
                    }
                }
                inputTextFrame.dispose();
                canvas.repaint();
				
			}
		});
		
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputTextFrame.dispose();
			}
		});
		
		
	}
	
	class UngroupObjectListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			canvas.removeGroup();
		}
	}
	
	class GroupObjectListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			canvas.GroupShape();
		}
	}
	
	class ChangeNameListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			changeNameForm();
		}
	}
}