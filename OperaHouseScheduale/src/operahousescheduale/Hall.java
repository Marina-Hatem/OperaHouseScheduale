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

// This class for the halls that are avaliable in the opera house that the instructors will teach in it the courses.

public class Hall {
    
    private int hallID;
    // Hall capcity to know how many trainers can be in the hall , and to know the big and small halls.
    private int capacity;
    // Hall number like hal12 or hall6.
    private String hallNumber;

    public Hall() {
    }

    // Constractor for the class to initatite in it the variabkes.
    public Hall(int hallID, int capacity, String hallNumber) {
        this.hallID = hallID;
        this.capacity = capacity;
        this.hallNumber = hallNumber;
    }

    // The getters and the setters of the variables.
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
