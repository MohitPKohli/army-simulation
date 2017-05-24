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


public class SimulationPanel extends JPanel {

	private JButton step, simulate, restart;
	private JLabel[] values;

	public SimulationPanel (ActionListener listener) {
		super(new BorderLayout());
		JPanel leftPanel = new JPanel(new GridLayout(6, 1));
    	JPanel rightPanel = new JPanel(new GridLayout(6, 1));
    	add(leftPanel, BorderLayout.WEST);
    	add(rightPanel, BorderLayout.CENTER);
		values = new JLabel[6];

		String[] labels = {"Army 1 Number of soldiers: ", "Army 1 Number of Tanks: ", "Army 1 Number of Planes: ",
    					   "Army 2 Number of soldiers: ", "Army 2 Number of Tanks: ", "Army 2 Number of Planes: "};
    	for (int i = 0; i < labels.length; i++) {
    		JLabel label = new JLabel(labels[i], JLabel.RIGHT);
    		values[i] = new JLabel("0");
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
		bottom.add(step);
		bottom.add(simulate);
		bottom.add(restart);
		add(bottom, BorderLayout.SOUTH);
	}

	public void updateSimulation(int numFootSoldiers1, int numTanks1, int numPlanes1, 
								 int numFootSoldiers2, int numTanks2, int numPlanes2) {
		values[0].setText(numFootSoldiers1+"");
		values[1].setText(numTanks1+"");
		values[2].setText(numPlanes1+"");
		values[3].setText(numFootSoldiers2+"");
		values[4].setText(numTanks2+"");
		values[5].setText(numPlanes2+"");	
	}
}