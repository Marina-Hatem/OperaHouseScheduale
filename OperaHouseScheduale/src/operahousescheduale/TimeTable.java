/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operahousescheduale;

import java.util.HashMap;

/**
 *
 * @author meriam
 */

// This class TimeTable cobmine all the other classes to genearte a timetable and it also appla the different constraints to be used and how they interacte with each other
// Our constraints are 1) The hall capacity must be equal to number of groups. 2) Each Instractor teach only one course at a time
// The hall is for only one course at a time

public class TimeTable {
        
    // All the obejcts from the other classes are stored in HashMap. We have used Hashmap and not arraylist because Hashmap store data in a form of a key value and
    // this key must be unique and no duplicate data. So, we use it as we have unique values like room id if it is not unique it duplicatte values and this is not allowed 
    // due to pur constraints.
        private  HashMap<Integer, Hall> halls;
	private  HashMap<Integer, Instructor> instructors;
	private  HashMap<Integer, Course> courses;
	private  HashMap<Integer, Group> groups;
	private  HashMap<Integer, TimeSlot> timeslots;
        // array of type Class
	private Class classes[];
        // int variable to know the number of classes 
	private int numClasses = 0;
        
        // The default constractor
        public TimeTable() {
		this.halls = new HashMap<Integer, Hall>();
		this.instructors = new HashMap<Integer, Instructor>();
		this.courses = new HashMap<Integer, Course>();
		this.groups = new HashMap<Integer, Group>();
		this.timeslots = new HashMap<Integer, TimeSlot>();
	}
        
        // The constractor has a object from timetable to set or inilize the hashMap
        
        public TimeTable(TimeTable timetable) {
		this.halls = timetable.getHalls();
		this.instructors = timetable.getInstructors();
		this.courses = timetable.getCourses();
		this.groups = timetable.getGroups();
		this.timeslots = timetable.getTimeslots();
	}

        
        // The getters 
    public HashMap<Integer, Hall> getHalls() {
        return halls;
    }

    public HashMap<Integer, Instructor> getInstructors() {
        return instructors;
    }

    public HashMap<Integer, Course> getCourses() {
        return courses;
    }

    public HashMap<Integer, Group> getGroups() {
        return groups;
    }

    public HashMap<Integer, TimeSlot> getTimeslots() {
        return timeslots;
    }

    public Class[] getClasses() {
        return classes;
    }

    public int getNumClasses() {
        return numClasses;
    }
      
    // To add a hall in the hashMap , by a put function which takes to parameter. First parameter it takes the key valye or the unique 
    
    public void addHall(int hallID, int capacity, String hallNumber) {
		this.halls.put(hallID, new Hall(hallID, capacity, hallNumber));
                
    }
    
    
        
}
