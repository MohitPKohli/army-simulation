import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class ArmySimulationFrame extends JFrame implements ActionListener{

	private UserInputPanel card1;
	private SimulationPanel card2;
	private JPanel mainPanel;
	private Battle battle;
	private Army army1, army2;

	public ArmySimulationFrame() {
		setTitle("Army Simulation");
        setSize(450, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        card1 = new UserInputPanel(this);
        card2 = new SimulationPanel(this);
        mainPanel = new JPanel(new CardLayout());
		mainPanel.add(card1, "User input panel");
		mainPanel.add(card2, "Simulation panel");
		add(mainPanel);

		try { 
		    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		    // Changing look and feel failed
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Start")){
	        int[] in = card1.getInput();
	        if (in != null) {
		        CardLayout cl = (CardLayout)(mainPanel.getLayout());
				cl.show(mainPanel, "Simulation panel");
				army1 = new Army(in[0], in[1], in[2]);
				army2 = new Army(in[3], in[4], in[5]);
				battle = new Battle(army1, army2);
				card2.updateSimulation(in[0], in[1], in[2], in[3], in[4], in[5]);
	        }
	    }
	    else if(e.getActionCommand().equals("New Simulation")){
	        CardLayout cl = (CardLayout)(mainPanel.getLayout());
			cl.show(mainPanel, "User input panel");
	    }
	    else if(e.getActionCommand().equals("Step")){
	    	battle.step();
	    	card2.updateSimulation(army1.getNumFootSoldiers(), army1.getNumTanks(), army1.getNumPlanes(),
	    					 army2.getNumFootSoldiers(), army2.getNumTanks(), army2.getNumPlanes());
	        if (battle.isFinished()) {
	        	displayWinner();
	        }
	    }
	    else if(e.getActionCommand().equals("Run Full Simulation")){
	        while (!battle.isFinished()) {
				battle.step();
			}
			card2.updateSimulation(army1.getNumFootSoldiers(), army1.getNumTanks(), army1.getNumPlanes(),
	    					 army2.getNumFootSoldiers(), army2.getNumTanks(), army2.getNumPlanes());
			displayWinner();
	    }
    }

    private void displayWinner() {
		if (army1.isDefeated() && army2.isDefeated())
			JOptionPane.showMessageDialog(null, "The battle was a draw!", "Army Simulation Result", JOptionPane.INFORMATION_MESSAGE);
		else if (army2.isDefeated())
			JOptionPane.showMessageDialog(null, "Army 1 is victorious!", "Army Simulation Result", JOptionPane.INFORMATION_MESSAGE);
		else
			JOptionPane.showMessageDialog(null, "Army 2 is victorious!", "Army Simulation Result", JOptionPane.INFORMATION_MESSAGE);
    }
}