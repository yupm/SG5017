/*
 * Copyright 2003 ISS.
 * The contents contained in this document may not be reproduced in any
 * form or by any means, without the written permission of ISS, other
 * than for the purpose for which it has been supplied.
 *
 */
package sg.edu.nus.iss.vmcs.store;

/**
 * This object stores the weight and value of each type of Coin, and hence enables the 
 * machine to recognize each Coin entered.
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
 * @version 3.0 5/07/2003
 * @author Olivo Miotto, Pang Ping Li
 */
public class Card {
    private String number;

    /**
     * This constructor creates an instance of the Coin object.
     */
    public Card () {
    }
    
    /**
     * This constructor creates an instance of the Coin object.
     * @param value the value of the Coin.
     * @param weight the weight of the Coin.
     */
    public Card (String number) {
        this.number = number;
    }


    /**
     * This method sets the weight of the Coin.
     * @param wt the weight of the Coin.
     */
    public void setNumber(String wt){
      number = wt;
    }

    /**
     * This method returns the weight of the Coin.
     * @return the weight of the Coin.
     */
    public String getNumber () {
        return (number);
    }
  }//End of class card