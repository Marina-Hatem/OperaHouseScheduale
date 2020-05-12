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

// This class for each timeslot availiable for all instractors that can teach in it. For example instructor 
// Mariam timeslot that she is available and teach in it is "Thursday 10-12". She is giving her course every thursday from 10 to 12.

public class TimeSlot {
    
    // This variable is a string for the timeslot which is "Sun 10-12".
    private String timeSlot;
    // This variable is int id for the timeslot as to use it in the functions as a unique variable.
    private int timeslotID;

    // The default constractor 
    public TimeSlot() {
    }

    // The loaded constractor which have all the variables and initlize this variables. Also, for initializing new TimeSlot
    public TimeSlot(String timeSlot, int timeslotID) {
        this.timeSlot = timeSlot;
        this.timeslotID = timeslotID;
    }
    
    // The getters and the setters of all the vairables in the class.

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public int getTimeslotID() {
        return timeslotID;
    }

    public void setTimeslotID(int timeslotID) {
        this.timeslotID = timeslotID;
    }
    
    
    
    
}
