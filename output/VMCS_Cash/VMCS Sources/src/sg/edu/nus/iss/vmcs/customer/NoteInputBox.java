/*
 * Copyright 2003 ISS.
 * The contents contained in this document may not be reproduced in any
 * form or by any means, without the written permission of ISS, other
 * than for the purpose for which it has been supplied.
 *
 */
package sg.edu.nus.iss.vmcs.customer;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Panel;

import sg.edu.nus.iss.vmcs.store.CashStore;
import sg.edu.nus.iss.vmcs.store.CashStoreItem;
import sg.edu.nus.iss.vmcs.store.Coin;
import sg.edu.nus.iss.vmcs.store.Note;
import sg.edu.nus.iss.vmcs.store.NoteStore;
import sg.edu.nus.iss.vmcs.store.NoteStoreItem;
import sg.edu.nus.iss.vmcs.store.Store;
import sg.edu.nus.iss.vmcs.store.StoreController;
import sg.edu.nus.iss.vmcs.store.StoreItem;
import sg.edu.nus.iss.vmcs.store.StoreObject;
import sg.edu.nus.iss.vmcs.system.MainController;

/**
 * This interface object is part of the Customer Panel&#46; It is used to enter
 * Coins into the vending machine.
 * @author Team SE16T5E
 * @version 1.0 2008-10-01
 */
public class NoteInputBox extends Panel{
	private NoteButton[] btnNoteButton;
	
	private TransactionController txCtrl;
	
	/**
	 * This constructor creates an instance of the object.
	 * @param cctrl the TransactionController.
	 */
	public NoteInputBox(TransactionController cctrl){
		this.txCtrl=cctrl;
		MainController mainCtrl=cctrl.getMainController();
		StoreController storeCtrl=mainCtrl.getStoreController();
		int cashStoreSize=storeCtrl.getStoreSize(Store.NOTE);
		StoreItem[] cashStoreItems=storeCtrl.getStore(Store.NOTE).getItems();
		
		btnNoteButton=new NoteButton[cashStoreSize+1];
		NoteInputListener coinInputListener=new NoteInputListener(txCtrl.getCoinReceiver());
		
		setLayout(new GridBagLayout());
		for(int i=0;i<cashStoreItems.length;i++){
			StoreItem storeItem=cashStoreItems[i];
			NoteStoreItem cashStoreItem=(NoteStoreItem)storeItem;
			StoreObject storeObject=cashStoreItem.getContent();
			Note coin=(Note)storeObject;
			String coinName=coin.getName();
			int coinValue=coin.getValue();
			double coinWeight=coin.getWidth();
			btnNoteButton[i]=new NoteButton(coinName,coinValue,coinWeight);
			btnNoteButton[i].addActionListener(coinInputListener);
			add(btnNoteButton[i],new GridBagConstraints(i,1,1,1,1.0,0.0,
				    GridBagConstraints.EAST,GridBagConstraints.HORIZONTAL,
				    new Insets(0,0,0,0),10,8));
		}
		btnNoteButton[cashStoreSize]=new NoteButton("Invalid",-1,NoteStore.INVALID_NOTE_WIDTH);
		btnNoteButton[cashStoreSize].addActionListener(coinInputListener);
		add(btnNoteButton[cashStoreSize],new GridBagConstraints(cashStoreSize,1,1,1,1.0,0.0,
			    GridBagConstraints.EAST,GridBagConstraints.HORIZONTAL,
			    new Insets(0,0,0,0),10,8));
	}
	
	/**
	 * This method activates the Coin Input Box if the parameter is TRUE&#46;
	 * Otherwise, the Coin Input Box is deactivated.
	 * @param active TRUE to activate the CoinInputBox, otherwise, deactivate the CoinInputBox.
	 */
	public void setActive(boolean active){
		if(btnNoteButton!=null){
			for(int i=0;i<btnNoteButton.length;i++){
				btnNoteButton[i].setEnabled(active);
			}
		}
	}
}//NotenInputBox