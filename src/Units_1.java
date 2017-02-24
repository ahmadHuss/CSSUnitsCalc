import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Units_1 extends JFrame {
	// Component GrigBagLayout
	private GridBagLayout gridbag;
	// Component GrigBagConstraints helps to customize GridBagLayout
	private GridBagConstraints constraints;

	// Component TextFields
	private JTextField pixelfield, emfield, percentagefield, pointfield;

	// ComboBox because we use in selection
	private JComboBox<String> combo;

	// String Array for Selecting Units add this array to JComboBox
	private static final String[] names = { "Pixel", "Em/Rem", "Percentage", "Point" };

	public Units_1() {
		super("CSS Units v1.0");
		// Component ImageIcon for appear icon in title
		ImageIcon icon = new ImageIcon(getClass().getResource("icon.png"));
		setIconImage(icon.getImage());
		// create instance of these components because we want to use them
		gridbag = new GridBagLayout();
		constraints = new GridBagConstraints();

		// Important void Method of Full Template
		Template();
		// JFrame settings
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	// template structure
	private void Template() {
		// Default JFrame is set to be BorderLayout
		// calling add method which take component argument
		// so i write 3 methods that return 3 JPanels

		// and this JPanel set to be top of the JFrame
		add(Menubar(), BorderLayout.NORTH);

		// and this JPanel set to be Center of the JFrame
		add(centerTemplate(), BorderLayout.CENTER);

		// and this JPanel set to be bottom of the JFrame
		add(ComboModel(), BorderLayout.SOUTH);

	}

	// MenuBarTemplate
	private JPanel Menubar() {

		// Local instances

		// Component JPanel
		JPanel panel = new JPanel();

		// I'm Creating this JPanel for JMenuBar so default layout is FlowLayout

		// Component icon add into Dialog
		Icon credit = new ImageIcon(getClass().getResource("hu_1.png"));
		// Component JMenuBar
		JMenuBar menu = new JMenuBar();
		// Component JMenu
		JMenu file = new JMenu("File");
		// Component JMenu
		JMenu about = new JMenu("About");

		// Component Sub JMenuItem appear bottom of JMenu `File`
		JMenuItem exit = new JMenuItem("Exit");
		// Component Sub JMenuItem appear bottom of JMenu `About`
		JMenuItem aboutdeveloper = new JMenuItem("Developer");

		// Method to fix the JMenuBar
		setJMenuBar(menu);

		// calling JMenuBar add method
		menu.add(file);
		// calling JMenuBar add method
		menu.add(about);

		// calling JMenu add method
		file.add(exit);
		// calling JMenu add method
		about.add(aboutdeveloper);

		// Exit ActionListener
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		// About Developer Dialog ActionListener
		aboutdeveloper.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Ahmad HussNain 'Ahmad'", "About Author",
						JOptionPane.ERROR_MESSAGE, credit);
			}
		});

		return panel;
	}

	// CenterTemplate
	private JPanel centerTemplate() {

		// Local instances
		// Component JPanel
		JPanel panel2 = new JPanel();

		// Set Layout of JPanel 3 to GridBagLayout
		panel2.setLayout(gridbag);

		// Total 4 Rows
		// Padding top left bottom right
		constraints.insets = new Insets(66, 10, 5, 10);

		// anchor attribute used to where to place the component left
		constraints.anchor = GridBagConstraints.WEST;
		// Row 0
		constraints.gridy = 0;

		// Component JLabel
		JLabel pixel = new JLabel("Pixels 'px'");

		// Font Size
		pixel.setFont(new Font("Tahoma", Font.PLAIN, 16));

		// Add this label to Panel
		panel2.add(pixel, constraints);

		// Row 1
		constraints.gridy = 1;
		// Component JLabel
		JLabel em = new JLabel("Em/Rems 'em/rem'");

		em.setFont(new Font("Tahoma", Font.PLAIN, 16));

		panel2.add(em, constraints);

		// Row 2
		constraints.gridy = 2;
		// Component JLabel
		JLabel percentage = new JLabel("Percentage '%'");
		percentage.setFont(new Font("Tahoma", Font.PLAIN, 16));

		panel2.add(percentage, constraints);

		// Row 3
		constraints.gridy = 3;
		// Component JLabel
		JLabel point = new JLabel("Point 'pt'");
		point.setFont(new Font("Tahoma", Font.PLAIN, 16));

		panel2.add(point, constraints);

		// TextFields
		constraints.gridy = 0;
		constraints.gridx = 1;
		pixelfield = new JTextField(15);
		panel2.add(pixelfield, constraints);

		constraints.gridy = 1;
		constraints.gridx = 1;
		emfield = new JTextField(15);
		panel2.add(emfield, constraints);

		constraints.gridy = 2;
		constraints.gridx = 1;
		percentagefield = new JTextField(15);
		panel2.add(percentagefield, constraints);

		constraints.gridy = 3;
		constraints.gridx = 1;
		pointfield = new JTextField(15);
		panel2.add(pointfield, constraints);

		constraints.insets = new Insets(10, 30, 10, 30);
		constraints.gridy = 4;
		constraints.gridx = 1;
		// Button
		JButton calculate = new JButton("Calculate");
		panel2.add(calculate, constraints);

		calculate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Perform();
			}// ActionEvent

		});

		return panel2;
	}

	// ComboBar Template
	private JPanel ComboModel() {

		// Local instances
		JPanel panel3 = new JPanel();

		// Set Layout of JPanel 3 to GridBagLayout
		panel3.setLayout(gridbag);

		// Insets For external Padding top left bottom right
		constraints.insets = new Insets(5, 10, 48, 10);
		// Row 0
		constraints.gridy = 0;
		constraints.gridx = 0;
		// Component JLabel
		JLabel selectUnit = new JLabel("Select Unit");

		selectUnit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		// Add this label to Panel
		panel3.add(selectUnit, constraints);

		// Column 1
		constraints.gridx = 1;
		// Component JComboBox This is Raw type JComboBox combo = new
		// JComboBox();
		// So we use Generic ComboBox because now Combo Box is generic class
		combo = new JComboBox<>(names);
		panel3.add(combo, constraints);

		combo.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {

				if (e.getStateChange() == ItemEvent.SELECTED) {

					pixelfield.setText("");
					emfield.setText("");
					percentagefield.setText("");
					pointfield.setText("");
				}
			}

		});

		return panel3;
	}
	
	public void Perform(){
		
		DecimalFormat d2 = new DecimalFormat();// For Eliminate
		// 1.0 to 1
		//don't automatic use grouping mean don't add comma for big values
		d2.setGroupingUsed(false);
		// For Combo Index Checking
		String index = null;

		if (combo.isEnabled()) {
			index = combo.getSelectedItem().toString();

		}

		// Pixel Section
		if (index == names[0]) {

			

			String a = pixelfield.getText();
			if (a.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Enter a value in pixel field!", "Error Message",
						JOptionPane.ERROR_MESSAGE);
			} else {

				double num1 = Double.parseDouble(a);
				// pixel to em formula
				double ans1 = num1 / 16;

				emfield.setText(d2.format(ans1) + " em");

				// Pixel to percentage formula
				double ans2 = (num1 / 16) * 100;
				// Original Answer
				 percentagefield.setText(d2.format(ans2)+" %");

				// But After RoundOff with left one decimal put 10.0 if
				// two than 100.0
				//double roundOff = Math.round(ans2 * 10.0) / 10.0;
			//	percentagefield.setText(d2.format(roundOff) + " %");

				// pixel to point formula
				double ans3 = (num1 * 72) / 96;
				pointfield.setText(d2.format(ans3) + " pt");
			}

		}

		else if (index == names[1]) {
			String b = emfield.getText();
			//if TextField is empty
			if (b.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Enter a value in em/rm field!", "Error Message",
						JOptionPane.ERROR_MESSAGE);
			} else {
				
				
				double num2 = Double.parseDouble(b);
				//em to pixel formula
				double ans1 = num2 * 16;

				pixelfield.setText(d2.format(ans1) + " px");
				
			
				//em to percentage formula
				double ans2 = num2 * 100;

				percentagefield.setText(d2.format(ans2) + " %");
				
				
				
				//em to point first get pixel value than formula
				double ans3 = (ans1 * 72) / 96;

				pointfield.setText(d2.format(ans3) + " pt");
				
			}
			
		}//else if close
			
			else if (index == names[2]) {
				String c = percentagefield.getText();
				//if TextField is empty
				if (c.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Enter a value in percentage field!", "Error Message",
							JOptionPane.ERROR_MESSAGE);
				} 
				
				else {
					
					double num3 = Double.parseDouble(c);
					//percentage to pixel formula
					double ans1 = num3/6.25;

					pixelfield.setText(d2.format(ans1) + " px");
				
					
					//percentaga to em formula
					double ans2 = num3/100;

					emfield.setText(d2.format(ans2) + " em");
				
					
					//percentage,pixel to point
					double ans3 = (ans1 * 72) / 96;

					pointfield.setText(d2.format(ans3) + " pt");
					
					
				}
			
		}//else if close

	
	
		else if (index == names[3]) {
			String d = pointfield.getText();
			//if TextField is empty
			if (d.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Enter a value in point field!", "Error Message",
						JOptionPane.ERROR_MESSAGE);
			} 
			
			else {
	
				double num1 = Double.parseDouble(d);
				//point to pixel formula
				double ans1 = (num1*96)/72;

				pixelfield.setText(d2.format(ans1) + " px");
				
	
				//point to pixel and pixel to em formula
				double ans2 = num1/16;
				emfield.setText(d2.format(ans2) + " em");
	
				
				//point to pixel,pixel to percentage formula
				double ans3 = (ans1 / 16) * 100;
				percentagefield.setText(d2.format(ans3) + " %");
				
				
				
			}
		}//else if close
		
		
	}
}
