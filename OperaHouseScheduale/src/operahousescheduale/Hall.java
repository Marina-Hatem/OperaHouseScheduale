/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operahousescheduale;

/**
 *
 * @author meriam
 */
public class Hall {
    
    private int hallID;
    private int capacity;
    private String hallNumber;

    public Hall() {
    }

    public Hall(int hallID, int capacity, String hallNumber) {
        this.hallID = hallID;
        this.capacity = capacity;
        this.hallNumber = hallNumber;
    }

    public int getHallID() {
        return hallID;
    }

    public void setHallID(int hallID) {
        this.hallID = hallID;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getHallNumber() {
        return hallNumber;
    }

    public void setHallNumber(String hallNumber) {
        this.hallNumber = hallNumber;
    }

    
    
    
    
    
    
}
