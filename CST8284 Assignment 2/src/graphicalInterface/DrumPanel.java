package graphicalInterface;

import javax.swing.*;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.List;

import domain.Drum;
import domain.FlammableDrum;
import domain.ToxicDrum;

/**
 * This class is the main panel/container object for the application GUI widgets.
 * This is a java Swing application.
*  @author Ewan Smith
 * @version 1.0
 * @since JDK 21.04
 */
public class DrumPanel extends JPanel {

	/** Creates a label that prompts the user to create the drums*/
	private JLabel drumPrompt;
	/**Creates a text field that asks the user to specify the number of barrels being created*/
	private JTextField numberToCreate;
	/** Creates a radio button to create a flammable drum*/
	private JRadioButton flammableDrumType;
	/** Creates a radio button to create a toxic drum*/
	private JRadioButton toxicDrumType;
	/** Creates a button that triggers the creation of the specified drum*/
	private JButton createDrums;
	/** Creates a button that triggers the capacity test of the specified drum	*/
	private JButton runTests;
	/** Creates a text area to display the results of the test	*/
	private JTextArea testResults;
	/** Creates a label to indicate the status of the program		*/
	private JLabel statusField;

	/** List of drums creates.														*/
	List<Drum> listOfDrums = new ArrayList<Drum>();
	
	/** Serial version required. */
	private static final long serialVersionUID = 1L;

	/**
	 * Create and populate the main drum panel with appropriate GUI widgets.
	 */
	public DrumPanel() {
		initGUI();
	}

	/**
	 * Create and populate the panel with appropriate GUI components.
	 */
	private void initGUI() {
		setToolTipText("When finished with the application click the 'X' on the top bar, right side to close the application");
		setLayout(new FlowLayout());	
		
		JPanel p = new JPanel();

		p.add(createDrumTypePanel());
		p.add(createDrumNumberPanel());
		Box box = new Box(BoxLayout.Y_AXIS);
		box.add(p);
		
		box.add(createButtonPanel());

		add(box,TOP_ALIGNMENT);
		add(createResultsPanel(),CENTER_ALIGNMENT);
		statusField = new JLabel("Status field for errors etc.");
		add(statusField,BOTTOM_ALIGNMENT);
	}

	/**
	 * Create the results panel
	 * 
	 * @return
	 */
	private JPanel createResultsPanel()	{
		JPanel trp = new JPanel();
		testResults = new JTextArea(25, 50);
		testResults.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Results"),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		testResults.setBorder(BorderFactory.createRaisedBevelBorder());
		JScrollPane sp = new JScrollPane(testResults);
		trp.add(sp);
		return trp;
	}
	
	/**
	 * Create the drum number panel.
	 * 
	 * @return
	 */
	private JPanel createDrumNumberPanel() {
		drumPrompt = new JLabel("Number of drums to create ");
		drumPrompt.setToolTipText("The number of drums to create");
		numberToCreate = new JTextField(10);
		numberToCreate.setToolTipText("Enter the number of drums to create");
		
		JPanel numberPanel = new JPanel();
		numberPanel.setLayout(new BoxLayout(numberPanel, BoxLayout.X_AXIS));
		numberPanel.add(drumPrompt);
		numberPanel.add(numberToCreate);
		numberPanel.setBorder(BorderFactory.createRaisedBevelBorder());

		return numberPanel;
	}

	/**
	 * Create the drum button panel.
	 * 
	 * @return	The panel object containing the buttons.
	 */
	private JPanel createButtonPanel() {
		createDrums = new JButton("Create Drums");
		createDrums.setToolTipText("Click me to create the specified number and type of drums to create");
		createDrums.addActionListener( new ActionListener()	{
			public void actionPerformed(ActionEvent ae)	{
				
				/* Get type of drums to create				*/
				
				int numDrums = Integer.parseInt(numberToCreate.getText());
				
				
				if (flammableDrumType.isSelected())	{
					testResults.append("\n\nCreating [" + numDrums + "] Flammable Drums");
						for (int i = 0; i < numDrums; i++) {
							listOfDrums.add(new FlammableDrum(36.0f, 24.0f, " Gasoline ", 150.0f));
						}
				}	else if(toxicDrumType.isSelected()) {
					testResults.append("\n\nCreating [" + numDrums + "] Toxic Drums");
					for (int i = 0; i < numDrums; i++) {
						listOfDrums.add(new ToxicDrum(36.0f, 24.0f, "  Radioactive Isotopes  ", ToxicDrum.CLASS_IB));
					}
				}	else	{
					statusField.setText("NO Drum type has been selected");
				}
			}});

				
		runTests = new JButton("Run Tests");
		runTests.addActionListener( new ActionListener()	{
			public void actionPerformed(ActionEvent ae)	{

				int count = 1;
				if(listOfDrums.isEmpty()) {
					testResults.append("\n\nNo Drums have been created to be tested");
					statusField.setText("Please create Drums to test");
					return;
				}
				
				for(Drum drum : listOfDrums) {
					testResults.append("\n [" + count++ + "] " + drum.getClass().getName() + " " + drum.getClass().getSimpleName());
					testResults.append("\n"+ drum.toString() + "\n");
				}
				
				statusField.setText("Set the status line");
			}});

		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

		buttonPanel.add(createDrums);
		buttonPanel.add(runTests);
		
		buttonPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Action"),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		buttonPanel.setBorder(BorderFactory.createRaisedBevelBorder());

		return buttonPanel;
	}

	
	/**
	 * Create the drum creation panel.
	 * 
	 * @return
	 */
	private JPanel createDrumTypePanel() {
		flammableDrumType = new JRadioButton("Flammable Drum");
		toxicDrumType = new JRadioButton("Toxic Drum");
		ButtonGroup group = new ButtonGroup();
		group.add(toxicDrumType);
		group.add(flammableDrumType);
		JPanel typePanel = new JPanel();
		typePanel.setLayout(new BoxLayout(typePanel, BoxLayout.Y_AXIS));
		typePanel.add(flammableDrumType);
		typePanel.add(toxicDrumType);
		typePanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Types of Drums"),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		typePanel.setBorder(BorderFactory.createRaisedBevelBorder());

		return typePanel;
	}

}
