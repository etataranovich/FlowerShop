package by.tataranovich.shop.modelshop;

import java.io.Serializable;

public class Order implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Bouqet bouqet;
    private long id;
    private int clientId;
    private int bouqetCount;
    public static final int MAX_BOUQETCOUNT = 10;
        
    public Order(Bouqet bouqet, long id, int clientId, int bouqetCount) {
	
	this.bouqet = bouqet;
	this.id = id;
	this.clientId = clientId;
	this.bouqetCount = bouqetCount;
    }
    public Bouqet getBouqet() {
        return bouqet;
    }
    public void setBouqet(Bouqet bouqet) {
        this.bouqet = bouqet;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public int getClientId() {
        return clientId;
    }
    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
    public int getBouqetCount() {
        return bouqetCount;
    }
    public void setBouqetCount(int bouqetCount) {
        this.bouqetCount = bouqetCount;
    }
    
    

}
