/*
 * Copyright 2003 ISS.
 * The contents contained in this document may not be reproduced in any
 * form or by any means, without the written permission of ISS, other
 * than for the purpose for which it has been supplied.
 *
 */
package sg.edu.nus.iss.vmcs.system;



import sg.edu.nus.iss.vmcs.store.*;

/**
 * This control object manages the initialization of the CashStore&#46;
 *
 * @version 3.0 5/07/2003
 * @author Olivo Miotto, Pang Ping Li
 */
public class NotePropertyLoader extends FilePropertyLoader {

	private static final String NAME_LABEL     = "Name";
	private static final String WIDTH_LABEL   = "Width";
	private static final String VALUE_LABEL    = "Value";
	private static final String QUANTITY_LABEL = "Quantity";

	/**
	 * This constructor creates an instance of CashPropertyLoader object.
	 * @param filen the name of the cash property file.
	 */
	public NotePropertyLoader(String filen) {
		super(filen);
	}

	/**
	 * This method reads the data from the hash table and creates a CashStoreItem.
	 * @param index the index of the StoreItem.
	 * @return StoreItem the store item of the given index.
	 */
	public StoreItem getItem (int index) {
		int idx = index + 1;
		Note note = new Note();

		String name = new String(NAME_LABEL + idx);
		String value = getValue(name);
		note.setName(value);

		name = new String(WIDTH_LABEL + idx);
		value = getValue(name);
		note.setWidth(Double.parseDouble(value));

		name = new String(VALUE_LABEL + idx);
		value = getValue(name);
		note.setValue(Integer.parseInt(value));

		name = new String(QUANTITY_LABEL + idx);
		value = getValue(name);
		int qty = Integer.parseInt(value);

		NoteStoreItem item = new NoteStoreItem(note, qty);
		return item;
	}

	/**
	 * This method updates the hash table with the data from the CashStoreItem.
	 * @param index the index of the item.
	 * @param cashItem the cash store item.
	 */
	public void setItem(int index, StoreItem cashItem) {
		int idx = index + 1;

		NoteStoreItem item = (NoteStoreItem) cashItem;
		Note cn = (Note) item.getContent();
		String itn = new String(NAME_LABEL + idx);

		setValue(itn, cn.getName());

		itn = new String(WIDTH_LABEL + idx);
		setValue(itn, String.valueOf(cn.getWidth()));

		itn = new String(VALUE_LABEL + idx);
		setValue(itn, String.valueOf(cn.getValue()));

		itn = new String(QUANTITY_LABEL + idx);
		setValue(itn, String.valueOf(item.getQuantity()));
	}
}//End of class CashPropertyLoader