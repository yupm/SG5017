/*
 * Copyright 2003 ISS.
 * The contents contained in this document may not be reproduced in any
 * form or by any means, without the written permission of ISS, other
 * than for the purpose for which it has been supplied.
 *
 */
package sg.edu.nus.iss.vmcs.store;

/**
 * This object represents the store of cash in the vending machine.
 * 
 * @see CashStoreItem
 * @see Coin
 * @see DrinksBrand
 * @see DrinksStore
 * @see DrinksStoreItem
 * @see Store
 * @see StoreController
 * @see StoreItem
 * @see StoreObject
 * 
 * @version 3.0 5/07/2003
 * @author Olivo Miotto, Pang Ping Li
 */
public class NoteStore extends Store {
	/**This is the constant for Note invalid width.*/
	public final static int INVALID_NOTE_WIDTH = 9999;

	/**
	 * This constructor creates an instance of the NoteStore object.
	 */
	public NoteStore() {
	}
	
	/**
	 * This method find and returns the index of the note in the NoteStore of the given Note&#46;
	 * @param c the Note of interest&#46;
	 * @return the index of the given Note&#46; Return -1 if unknown Note is detected.
	 */
	public int findNoteStoreIndex(Note c) {
		int size = getStoreSize();
		for (int i = 0; i < size; i++) {
			StoreItem item = (NoteStoreItem) getStoreItem(i);
			Note current = (Note) item.getContent();
			if (current.getWidth() == c.getWidth())
				return i;
		}
		return -1;
	}

	/**
	 * This method determine whether the given weight of the {@link Note} is valid.
	 * @param weight the weight of the Note to be tested.
	 * @return TRUE if the weight is valid, otherwise, return FALSE.
	 */
	public boolean isValidWidth(double width){
		int size = getStoreSize();
		for (int i = 0; i < size; i++) {
			StoreItem item = (NoteStoreItem) getStoreItem(i);
			Note current = (Note) item.getContent();
			if (current.getWidth() == width)
				return true;
		}
		return false;
	}
	
	/**
	 * This method will locate a {@link Note} denomination held, with the input data 
	 * note width)&#46; If found, it returns an existence identifier (reference)&#46;
	 * Otherwise, it informs the requester that the coin is invalid.
	 * @param weight the weight of the note to be found.
	 * @return Note the note which has the input weight.
	 */
	public Note findWidth(double width){
		int size = getStoreSize();
		for (int i = 0; i < size; i++) {
			StoreItem item = (NoteStoreItem) getStoreItem(i);
			Note current = (Note) item.getContent();
			if (current.getWidth() == width)
				return current;
		}
		return null;
	}
}//End of class CashStore