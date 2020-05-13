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
    
    private HashMap<Integer, Hall> halls;
    private HashMap<Integer, Instructor> instructors;
    private HashMap<Integer, Course> courses;
    private HashMap<Integer, Group> groups;
    private HashMap<Integer, TimeSlot> timeslots;
    
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

    // To add a hall in the hashMap , by  put function which takes two parameter. First parameter it takes the key value or the unique key which here is the hallID
    // The other parameter is the constractor of class Hall that takes the values from the parameter of fucntion addHall and put it in the constractor to add new object the class.
    // Adding new hall 
    
    public void addHall(int hallID, int capacity, String hallNumber) {
        this.halls.put(hallID, new Hall(hallID, capacity, hallNumber));

    }

    // To add an Instructor in the hashMap , by  put function which takes two parameter. First parameter it takes the key value or the unique key which here is the InstructorID
    // The other parameter is the constractor of class Instructor that takes the values from the parameter of fucntion addInstructor and put it in the constractor to add new object the class.
    // Adding new Instructor 
    
    public void addInstructor(int InstructorID, String InstructorName) {
        this.instructors.put(InstructorID, new Instructor(InstructorID, InstructorName));

    }

    // To add a Course in the hashMap , by  put function which takes two parameter. First parameter it takes the key value or the unique key which here is the CourseID
    // The other parameter is the constractor of class Course that takes the values from the parameter of fucntion addCourse and put it in the constractor to add new object the class.
    // Adding new course 
    
    public void addCourse(int CourseID, String CourseCode, String Course, int[] InstructorIDS) {
        this.courses.put(CourseID, new Course(CourseID, CourseCode, Course, InstructorIDS));
    }

    // To add  Group in the hashMap , by  put function which takes two parameter. First parameter it takes the key value or the unique key which here is the grupId
    // The other parameter is the constractor of class Group that takes the values from the parameter of fucntion addGroup and put it in the constractor to add new object the class.
    // Adding new Group 
    
    public void addGroup(int groupId, int groupSize, int courseIds[]) {
        this.groups.put(groupId, new Group(groupId, groupSize, courseIds));
        this.numClasses = 0;
    }

    // To add TimeSlot in the hashMap , by  put function which takes to parameter. First parameter it takes the key value or the unique key which here is the timeslotId
    // The other parameter is the constractor of class TimeSlot that takes the values from the parameter of fucntion addTimeSlot and put it in the constractor to add new object the class.
    // Adding new TimeSlot 
    
    public void addTimeSlot(int timeslotId, String timeslot) {
        this.timeslots.put(timeslotId, new TimeSlot(timeslotId, timeslot));
    }

    
        
        
}
