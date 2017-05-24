import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ArmySimulationFrame extends JFrame implements ActionListener{

	private UserInputPanel card1;
	JPanel mainPanel;

	public ArmySimulationFrame() {
		setTitle("Army Simulation");
        setSize(750, 750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        card1 = new UserInputPanel(this);
        // JPanel card1 = new JPanel();
        JPanel card2 = new JPanel();
        mainPanel = new JPanel(new CardLayout());
		mainPanel.add(card1, "User input panel");
		mainPanel.add(card2, "Simulation panel");

		add(mainPanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Start")){
	        int[] yo = card1.getInput();
	        if (yo != null) {
	        	for (int i = 0; i < yo.length; i++){
		        	System.out.println(yo[i]+"");
		        }
		        CardLayout cl = (CardLayout)(mainPanel.getLayout());
    			cl.show(mainPanel, "Simulation panel");

	        }
	    }
    }


}