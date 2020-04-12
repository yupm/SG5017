/*
 * Copyright 2003 ISS.
 * The contents contained in this document may not be reproduced in any
 * form or by any means, without the written permission of ISS, other
 * than for the purpose for which it has been supplied.
 *
 */
package sg.edu.nus.iss.vmcs.customer;

/*
 * Copyright 2003 ISS.
 * The contents contained in this document may not be reproduced in any
 * form or by any means, without the written permission of ISS, other
 * than for the purpose for which it has been supplied.
 *
 */

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import sg.edu.nus.iss.vmcs.system.SimulatorControlPanel;
import sg.edu.nus.iss.vmcs.util.LabelledValue;
import sg.edu.nus.iss.vmcs.util.WarningDisplay;

/**
 * This class Customer Panel display the GUI interactive with the Customer&#46;
 * 
 * This panel simulates the vending machine's customer interface panel&#46; It will
 * enable the user (Customer) to:
 * <ol>
 * <li>
 * insert coins;
 * </li>
 * <li>
 * select Brands;
 * </li>
 * <li>
 * terminate Transaction&#46;  
 * </li> 
 * </ol>
 * It will also provide the following display functions;
 * <ol>
 * <li>
 * display total money inserted.
 * </li>
 * <li>
 * indicate coin not valid.
 * </li>
 * <li>
 * indicate no change available.
 * </li>
 * <li>
 * display the value of the change to be collected.
 * </li>
 * <li>
 * display an icon representing the dispensed drink.
 * </li>
 * </ol>
 *
 * @version 1.1 2020-04-11
 */
public class NoPayCustomerPanel extends CustomerPanel {
	private Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
	private int frameX=0;
	private int frameY=0;
	private int frameWidth=300;
	private int frameHeight=400;
	private int screenWidth=screen.width;
	private int screenHeight=screen.height;
	
	private NoPayTransactionController txCtrl;

    private Label lblTitle=new Label("VMCS Soft Drinks Dispenser without payment");
    private DrinkSelectionBox drinkSelectionBox;
    private LabelledValue lbdCollectCan=new LabelledValue("Collect Can Here:","",100);

    /**
     * This constructor creates an instance of the Customer Panel&#46; It further
     * creates Invalid Coin Display, No Change Available Display, Refund/ Change
     * Tray Display, Total Money Inserted Display, Coin Input Box, Drink Selection
     * Box, Can Collection Box and Terminate Button.
     * 
     * @param fr the parent frame
     * @param ctrl the Transaction Controller
     */
	public NoPayCustomerPanel(Frame fr, NoPayTransactionController ctrl) {
		super(fr, ctrl);
	
		this.removeAll();
		this.pan0 = new Panel();
		
		renderUI(fr, ctrl);
	}

 
	public void renderUI(Frame fr, NoPayTransactionController ctrl) {
		txCtrl = ctrl;
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent ev) {
				txCtrl.getMainController().getSimulatorControlPanel().setButtonState(SimulatorControlPanel.ACT_CUSTOMER,true);
				dispose();
				txCtrl.nullifyCustomerPanel();
			}
		});
		
		drinkSelectionBox=new DrinkSelectionBox(txCtrl);
		drinkSelectionBox.setActive(true);
		
		lblTitle.setAlignment(Label.CENTER);
		lblTitle.setFont(new Font("Helvetica", Font.BOLD, 24));
		
		pan0.setLayout(new GridBagLayout());
		
		pan0.add(drinkSelectionBox,new GridBagConstraints(0,4,0,1,0.0,0.0,
			    GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,
			    new Insets(5,0,0,0),10,0));
		pan0.add(lbdCollectCan,new GridBagConstraints(0,8,0,1,0.0,0.0,
			    GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,
			    new Insets(2,0,20,0),10,0));
		
		setLayout(new BorderLayout());
	    add(lblTitle,BorderLayout.NORTH);
	    add(pan0,BorderLayout.CENTER);
	    
		pack();
		frameWidth=this.getWidth();
        frameHeight=this.getHeight();
        frameX=(screenWidth-frameWidth)/2;
        frameY=(screenHeight-frameHeight)/2;
        setBounds(frameX,frameY,frameWidth, frameHeight);
	}
	/**
	 * Display the Customer Panel&#46; This will be achieved by displaying the frame
	 * of the panel and then sending messages to its constituent objects 
	 * instructing them to display themselves.
	 */
	public void display() {
		this.setVisible(true);
	}

	/**
	 * This method sets the can name to the collect tray.
	 * @param name the name of the can.
	 */
	public void setCan(String name){
		lbdCollectCan.setValue(name);
	}
	
	/**
	 * This method return the name of the can.
	 * @return the name of the can&#46; 
	 */
	public String getCan(){
		return lbdCollectCan.getValue();
	}


	/**
	 * This method resets the drink can display at the collection tray.
	 */
	public void resetCan(){
		setCan("");
	}
	
	/**
	 * Remove the Customer Panel from the display.
	 */
	public void closeDown() {
		dispose();
	}

	/**
	 * This method activates or deactivates the DrinkSelectionBox in the CustomerPanel.
	 * @param active the active status of the DrinkSelectionBox; TRUE to activate,
	 * FALSE to deactivate it.
	 */
	public void setDrinkSelectionBoxActive(boolean active){
		drinkSelectionBox.setActive(active);
	}
	
	
	/**
	 * This method returns the DrinkSelectionBox in the CustomerPanel.
	 * @return the DrinkSelectionBox in the CustomerPanel.
	 */
	public DrinkSelectionBox getDrinkSelectionBox(){
		return drinkSelectionBox;
	}
	
	/**
	 * This method activates or deactivates the Customer Panel and its component
	 * objects.
	 * 
	 * @param comp the component to be activated or deactivated.
	 * @param st the active status; TRUE to activate, FALSE to deactivate.
	 */
	public void setActive(int comp, boolean st) {
		Component c=this.getComponent(comp);
		c.setEnabled(st);
	}
}//End of class CustomerPanel