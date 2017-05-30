import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.lang.Integer;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.text.NumberFormat;

/**
 * The UserInputPanel class extends JPanel and is the interface used to collect the information
 * for both armies from the user. 
 * @author  Mohit Kohli
 * @version 1.0, May 2017
 */
public class UserInputPanel extends JPanel {

	private JButton start;
	private JFormattedTextField[] fields; 
	
	/**
	  * Constructor.
	  * 
	  * @param listener (required) ActionListener object that will handle the start button click. 
	  */
	public UserInputPanel(ActionListener listener) {
		super(new BorderLayout());
		JPanel leftPanel = new JPanel(new GridLayout(0, 1));
    	JPanel rightPanel = new JPanel(new GridLayout(0, 1));
		fields = new JFormattedTextField[6];
		NumberFormat format = NumberFormat.getNumberInstance();
		String[] labels = {"Army 1 Number of soldiers", "Army 1 Number of Tanks", "Army 1 Number of Planes",
    					   "Army 2 Number of soldiers", "Army 2 Number of Tanks", "Army 2 Number of Planes"};
    	for (int i = 0; i < labels.length; i++) {
    		JLabel label = new JLabel(labels[i], JLabel.RIGHT);
    		fields[i] = new JFormattedTextField(format);
    		fields[i].setColumns(10);
    		label.setLabelFor(fields[i]);
    		leftPanel.add(label);
    		rightPanel.add(fields[i]);
    	}
    	
		start = new JButton("Start");
		start.addActionListener(listener);
		JPanel bottom = new JPanel(new BorderLayout());
		bottom.add(start, BorderLayout.CENTER);
	
		setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    	add(leftPanel, BorderLayout.WEST);
    	add(rightPanel, BorderLayout.CENTER);
    	add(bottom, BorderLayout.SOUTH);
	}

	/**
	 * Returns the data collected from the text fields in the form. Creates a popup
	 * warning if any of the fields are blank, negative, or not integers.
	 *
	 * @return input from the form in an int array (None if positive int not passed in)
	 */
	public int[] getInput() {
		int[] input = new int[6];
		for (int i = 0; i < input.length; i++) {
			try{
			  	// input[i] = Integer.parseInt(fields[i].getText());
			  	input[i] = ((Number)fields[i].getValue()).intValue();
			  	if (input[i] < 0) {
			  		JOptionPane.showMessageDialog(null, "Text fields will only accept positive integers.", 
											  "Array Simulation Error", JOptionPane.INFORMATION_MESSAGE);
					return null;
				}
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Text fields will only accept valid integers.", 
											  "Array Simulation Error", JOptionPane.INFORMATION_MESSAGE);
				return null;
			}
		}
		return input;
	}
}