import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.lang.Integer;
import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.text.NumberFormat;

/**
 * The SimulationPanel class extends JPanel and is the interface used to run the simulation. 
 * @author  Mohit Kohli
 * @version 1.0, May 2017
 */
public class SimulationPanel extends JPanel {

	private JButton step, simulate, restart;
	private JFormattedTextField[] values;

	public SimulationPanel (ActionListener listener) {
		super(new BorderLayout());
		JPanel leftPanel = new JPanel(new GridLayout(0, 1));
    	JPanel rightPanel = new JPanel(new GridLayout(0, 1));
    	add(leftPanel, BorderLayout.WEST);
    	add(rightPanel, BorderLayout.CENTER);
		values = new JFormattedTextField[6];
		NumberFormat format = NumberFormat.getNumberInstance();

		String[] labels = {"Army 1 Number of soldiers: ", "Army 1 Number of Tanks: ", "Army 1 Number of Planes: ",
    					   "Army 2 Number of soldiers: ", "Army 2 Number of Tanks: ", "Army 2 Number of Planes: "};
    	for (int i = 0; i < labels.length; i++) {
    		JLabel label = new JLabel(labels[i], JLabel.RIGHT);
    		values[i] = new JFormattedTextField(format);
    		values[i].setColumns(10);
    		values[i].setEditable(false);
    		label.setLabelFor(values[i]);
    		leftPanel.add(label);
    		rightPanel.add(values[i]);
    	}
    	
		step = new JButton("Step");
		simulate = new JButton("Run Full Simulation");
		restart = new JButton("New Simulation");

		step.addActionListener(listener);
		simulate.addActionListener(listener);
		restart.addActionListener(listener);

		JPanel bottom = new JPanel(new FlowLayout());
		setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		bottom.add(step);
		bottom.add(simulate);
		bottom.add(restart);
		add(bottom, BorderLayout.SOUTH);
	}

	public void updateSimulation(int numFootSoldiers1, int numTanks1, int numPlanes1, 
								 int numFootSoldiers2, int numTanks2, int numPlanes2) {
		values[0].setValue(new Integer(numFootSoldiers1));
		values[1].setValue(new Integer(numTanks1));
		values[2].setValue(new Integer(numPlanes1));
		values[3].setValue(new Integer(numFootSoldiers2));
		values[4].setValue(new Integer(numTanks2));
		values[5].setValue(new Integer(numPlanes2));	
	}
}