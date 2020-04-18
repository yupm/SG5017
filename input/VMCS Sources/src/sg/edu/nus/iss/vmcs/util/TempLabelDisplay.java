package sg.edu.nus.iss.vmcs.util;

import java.awt.Checkbox;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TempLabelDisplay extends LabelledDisplay{
	private TextField tempValue;
	private String defaultTemp = "None";
	private Label lb;
	
	public TempLabelDisplay(String label, int length, int lt) {
		super(label, length, lt);

		lb = new Label("(Hot/Cold/None)");
		lb.setAlignment(Label.RIGHT);
		Panel tp = new Panel();
		tp.setLayout(new FlowLayout());
		
		tempValue = new TextField();
		tempValue.setColumns(length);
		tempValue.setText(defaultTemp);
		tp.add(tempValue);
		
		this.add(lb);
		this.add(tp);
	}
	
	/**
	 * This method attach a listener to the LabelledDislay.
	 * @param listener the ActionListener for the display.
	 */
	public void addTempListener(ActionListener listener) {
		tempValue.addActionListener(listener);
	}

}
