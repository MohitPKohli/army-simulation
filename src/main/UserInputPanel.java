import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.lang.Integer;
import javax.swing.JOptionPane;


public class UserInputPanel extends JPanel {

	private JButton start;
	private JTextField[] fields; 
	
	public UserInputPanel(ActionListener listener) {
		super(new BorderLayout());
		JPanel leftPanel = new JPanel(new GridLayout(6, 1));
    	JPanel rightPanel = new JPanel(new GridLayout(6, 1));
    	add(leftPanel, BorderLayout.WEST);
    	add(rightPanel, BorderLayout.CENTER);
		fields = new JTextField[6];

		String[] labels = {"Army 1 Number of soldiers", "Army 1 Number of Tanks", "Army 1 Number of Planes",
    					   "Army 2 Number of soldiers", "Army 2 Number of Tanks", "Army 2 Number of Planes"};
    	for (int i = 0; i < labels.length; i++) {
    		JLabel label = new JLabel(labels[i], JLabel.RIGHT);
    		fields[i] = new JTextField();
    		label.setLabelFor(fields[i]);
    		leftPanel.add(label);
    		rightPanel.add(fields[i]);
    	}
    	
		start = new JButton("Start");
		start.addActionListener(listener);
		JPanel bottom = new JPanel(new BorderLayout());
		bottom.add(start, BorderLayout.CENTER);
		add(bottom, BorderLayout.SOUTH);
	}

	public int[] getInput() {
		int[] input = new int[6];
		for (int i = 0; i < input.length; i++) {
			try{
			  	input[i] = Integer.parseInt(fields[i].getText());
			  	if (input[i] < 0) {
			  		JOptionPane.showMessageDialog(null, "Text fields will only accept positive integers.", 
											  "Array Simulation Error", JOptionPane.INFORMATION_MESSAGE);
					return null;
			  }
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Text fields will only accept valid integers.", 
											  "Array Simulation Error", JOptionPane.INFORMATION_MESSAGE);
				return null;
			}
		}
		return input;
	}
}