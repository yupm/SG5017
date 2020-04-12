/*
 * Copyright 2003 ISS.
 * The contents contained in this document may not be reproduced in any
 * form or by any means, without the written permission of ISS, other
 * than for the purpose for which it has been supplied.
 *
 */
package sg.edu.nus.iss.vmcs.customer;

import java.util.ArrayList;

 

import sg.edu.nus.iss.vmcs.machinery.MachineryController;
import sg.edu.nus.iss.vmcs.store.Card;
import sg.edu.nus.iss.vmcs.store.CashStore;
import sg.edu.nus.iss.vmcs.store.Coin;
import sg.edu.nus.iss.vmcs.store.Note;
import sg.edu.nus.iss.vmcs.store.NoteStore;
import sg.edu.nus.iss.vmcs.store.Store;
import sg.edu.nus.iss.vmcs.util.VMCSException;

/**
 * This control object manages the input and storage of Coins.
 * @author Team SE16T5E
 * @version 1.0 2008-10-01
 */
public class CardReceiver {
	private TransactionController txCtrl;
	/**
	 * This constructor creates an instance of the object.
	 * @param txCtrl the transaction controller.
	 */
	public CardReceiver(TransactionController txCtrl){
		this.txCtrl=txCtrl;
	}
	
	/**
	 * Commence receiving a series of Coins&#46;  To do this the Coin Receiver
	 * instructs the Coin Input Box to become activated&#46;  It also updates the Total
	 * Money Inserted Display on the Customer Panel.
	 */
	public void startReceiver(){
		if(txCtrl.getPaymentType()== PaymentType.CardOnly ||
		   txCtrl.getPaymentType() == PaymentType.CashWithCard ||
		   txCtrl.getPaymentType() == PaymentType.CoinWithCard) {
			txCtrl.getCustomerPanel().setCardInputBoxActive(true);
		}
	}

	public void receiveCard(Card card){
		if(card == null || card.getNumber() == null || 
		 card.getNumber().trim().isEmpty())
		{
			txCtrl.getCustomerPanel().setInvalidCoinLabel("Invalid Card");
			txCtrl.getCustomerPanel().displayInvalidCoin(true);
			txCtrl.getCustomerPanel().setChange("Invalid Card");
		}
		else{
			System.out.println("Received the card number:" + card.getNumber());
			txCtrl.completeTransaction();
		}
	}
}//End of class CoinReceiver