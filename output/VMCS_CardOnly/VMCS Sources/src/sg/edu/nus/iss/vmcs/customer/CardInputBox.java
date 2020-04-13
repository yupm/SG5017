/*
 * Copyright 2003 ISS.
 * The contents contained in this document may not be reproduced in any
 * form or by any means, without the written permission of ISS, other
 * than for the purpose for which it has been supplied.
 *
 */
package sg.edu.nus.iss.vmcs.customer;

import java.awt.Button;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sg.edu.nus.iss.vmcs.store.Card;

/**
 * This interface object is part of the Customer Panel&#46; It is used to enter
 * Coins into the vending machine.
 * @author Team SE16T5E
 * @version 1.0 2008-10-01
 */
public class CardInputBox extends Panel implements ActionListener{
	private TextField tfCardNumber = new TextField();
	private Button btnPayButton;
    private Label lblEnterNumber=new Label("Enter Credit Card Number:");
    
	private TransactionController txCtrl;
	private CardReceiver cardReceiver;
	
	/**
	 * This constructor creates an instance of the object.
	 * @param cctrl the TransactionController.
	 */
	public CardInputBox(TransactionController cctrl){
		this.txCtrl=cctrl;
		this.cardReceiver = new CardReceiver(this.txCtrl);
		
		setLayout(new GridBagLayout());
	    int i=0;
	    
		add(lblEnterNumber,new GridBagConstraints(i++, 0, 1,1,1.0,0.0,
			    GridBagConstraints.WEST,GridBagConstraints.HORIZONTAL,
			    new Insets(0,0,0,0),10,8));
		
		add(tfCardNumber,new GridBagConstraints(i++, 0, 1, 1, 1.0,0.0,
			    GridBagConstraints.WEST,GridBagConstraints.HORIZONTAL,
			    new Insets(0,0,0,0),10,8));

		btnPayButton= new Button("Pay");
		btnPayButton.addActionListener(this);
		add(btnPayButton, new GridBagConstraints(i++, 0, 1, 1, 1.0, 0.0,
			    GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
			    new Insets(0,0,0,0),10,8));
	}
	
	/**
	 * This method activates the Coin Input Box if the parameter is TRUE&#46;
	 * Otherwise, the Coin Input Box is deactivated.
	 * @param active TRUE to activate the CoinInputBox, otherwise, deactivate the CoinInputBox.
	 */
	public void setActive(boolean active){
		tfCardNumber.setEnabled(active);
		btnPayButton.setEnabled(active);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Card card = new Card();
		card.setNumber(tfCardNumber.getText());
		cardReceiver.receiveCard(card);
		tfCardNumber.setText("");
	}
}//CoinInputBox


 