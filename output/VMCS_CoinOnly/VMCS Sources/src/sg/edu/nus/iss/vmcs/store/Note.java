/*
 * Copyright 2003 ISS.
 * The contents contained in this document may not be reproduced in any
 * form or by any means, without the written permission of ISS, other
 * than for the purpose for which it has been supplied.
 *
 */
package sg.edu.nus.iss.vmcs.store;

/**
 * This object stores the weight and value of each type of Note, and hence enables the 
 * machine to recognize each Note entered.
 *
 * @see CashStore
 * @see CashStoreItem
 * @see DrinksBrand
 * @see DrinksStore
 * @see DrinksStoreItem
 * @see Store
 * @see StoreController
 * @see StoreItem
 * @see StoreObject
 * 
 * @version 3.0 4/12/2020
 * @author XU YA
 */
public class Note extends StoreObject {
    private int value;
    private double width;

    /**
     * This constructor creates an instance of the Note object.
     */
    public Note () {
    }
    
    /**
     * This constructor creates an instance of the Note object.
     * @param value the value of the Note.
     * @param weight the weight of the Note.
     */
    public Note (int value, double width) {
        this.value = value;
        this.width = width;
    }

    /**
     * This method sets the value of the Note.
     * @param v the value of the Note.
     */
    public void setValue(int v){
      value = v;
    }

    /**
     * This method sets the weight of the Note.
     * @param wt the weight of the Note.
     */
    public void setWidth(double wt){
      width = wt;
    }

    /**
     * This method returns the weight of the Note.
     * @return the weight of the Note.
     */
    public double getWidth () {
        return (width);
    }

    /**
     * This method returns the value of the Note.
     * @return the value of the Note.
     */
    public int getValue () {
        return (value);
    }
  }//End of class Note