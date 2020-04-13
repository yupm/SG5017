/*
 * Copyright 2003 ISS.
 * The contents contained in this document may not be reproduced in any
 * form or by any means, without the written permission of ISS, other
 * than for the purpose for which it has been supplied.
 *
 */
package sg.edu.nus.iss.vmcs.store;

/**
 * This entity object represents a column of notes in the vending machine&#46;
 * It can store a coin of any particular type&#46; There can be as many CashStoreItem
 * as desire in the vending machine&#46; There can be more than one CashStoreItem storing
 * the same or different types of Coin This number will be configurable&#46; This will
 * be implemented as an instance of StoreItem&#46;
 *
 * @see CashStore
 * @see Coin
 * @see DrinksBrand
 * @see DrinksStore
 * @see DrinksStoreItem
 * @see Store
 * @see StoreController
 * @see StoreItem
 * @see StoreObject
 * 
 * @version 4/12/2020
 * @author Xu Ya
 */
public class NoteStoreItem extends StoreItem {

	/**
	 * This constructor creates an instance of {@link NoteStoreItem} object.
	 * @param note the note associated with this CashStoreItem.
	 * @param qty the quantity of the note.
	 */
	public NoteStoreItem(Note note, int qty) {
		super((StoreObject) note, qty);
	}
}//End of class CashStoreItem