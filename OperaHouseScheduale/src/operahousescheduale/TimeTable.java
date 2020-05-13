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
    
    // This get Funtion get all the classes that need to be shcduled , also we want to get the number of classes 
    public int getNumClasses() {
        
        // if the number of classes is bigger than 0 , then it return thr numClasses int variable
        if (this.numClasses > 0) {
			return this.numClasses;
		}

                // if the number is equal zero , we will make an array of Group called groups then it will put inside it all the values inisidethe hashmap groups
                // then it will for loop on the array 
                //then inside the for loop numClasses will equal numClasses plus the length of the array of courseIDs inside class group
		int numClasses = 0;
		Group groups[] = (Group[]) this.groups.values().toArray(new Group[this.groups.size()]);
		for (Group group : groups) {
			numClasses += group.getCourseIds().length;
		}
                // Finally it store the number in the variable NumClasses
		this.numClasses = numClasses;

                // Then it return the numClasses
		return this.numClasses;
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

    // This function is creating a Class which takes an object from class Individual which is Individual chromosome, and then it returns an array of Class
    // It needs to know the total no of groups and courses that must be scheduled. Creates a no of Classes ojects for these groups and courses. 
    // It read the chromosome and assigns the variable info to class TimeSlot, Hall and Instructor.
    // The goal of the gentic algorthim is here the chromosome try a different combinations between timeslots,Halls and Instructors to make a timetable.
    // Then it check on it , if there is any conflict or clashes (clashes or conflicts is the constraints which are 1) The Hall size 2) The professor teach one course at a time 
    // 3) The hall is for one course only at a time. It can't be two courses in the same timeslot and in same hall.
    public void createClasses(Individual individual) {
		// Init classes
                // Making an array for class Class and inside it, it get the number of classes
		Class classes[] = new Class[this.getNumClasses()];

		// Get individual's chromosome
                // Make an array of int for the chromosome (chromosome is like 010011) and inilize it by accessing class Individual and getting getChromosome() function
		int chromosome[] = individual.getChromosome();
                // Making a variable called chromosomePositin which is intilized by zero
		int chromosomePos = 0;
                // Making a variable called classIndex which is for the array as to set in it values. It is inilized by 0
		int classIndex = 0;

                // It is enhanced forLoop that loops on group array 
		for (Group group : this.getGroupsAsArray()) {
                    // It is array of courseID which is inside class Group
                    // It is a variable which is int array of courses IDs and it is inilized by getting all the ids from class Group
			int courseIds[] = group.getCourseIds();
                        
                        // It is enhanced forLoop that loops on courseIDs array
			for (int courseId : courseIds) {
                            
                            // In the first index in the array of classes will add new Class. class index it is like the classID. Then it get the groupId from thr looping. 
                            // And finally it put the courseId which it loop on it.
				classes[classIndex] = new Class(classIndex, group.getGroupId(), courseId);

				// Add TimeSlot
				classes[classIndex].addTimeslot(chromosome[chromosomePos]);
				chromosomePos++;

				// Add Hall
				classes[classIndex].setHallId(chromosome[chromosomePos]);
				chromosomePos++;

				// Add Instructor 
				classes[classIndex].addInstructor(chromosome[chromosomePos]);
				chromosomePos++;

                                // Finally thr classIndex is incrematnted by 1.
				classIndex++;
			}
		}
                // It take all of this and set it in the array of classes
		this.classes = classes;
	}
    
    

        // This function it take a hallID and then search inside the hashmap of halls if the id is found then it return Hall from the hallID
        // This function wants to get specific Hall but it first check if it is avaliable of not by searching by the hallID
        public Hall getHall(int hallID) {
            // This if condition says that if the hashmap halls doesn't contain the entered hallID , then this hall doesn't exisit.And print a statment says that hashmap halls
            // don't have this ID.
		if (!this.halls.containsKey(hallID)) {
			System.out.println("Halls doesn't have this " + hallID);
		}
                
                // If the ID was iniside the array then it will return this Hall 
		return (Hall) this.halls.get(hallID);
	}
        
        
        // This function get random hall and return it 
        public Hall getRandomRoom() {
            
               // Object is a superclass which have everything
               // Object array accepts different types like string, int , float and many more. So the array type is Object as to take the values from the halls hashMap
		Object[] hallArray = this.halls.values().toArray();
                // Here it get a random Hall and put it inside array hallArray and then it cast it's type to Hall class
		Hall hall = (Hall) hallArray[(int) (hallArray.length * Math.random())];
                
                // Finally it return the random Hall in a variable named hall
		return hall;  
	}
        
        // This function it take a instructorID and then search inside the hashmap of instructoras if the id is found then it return instructor from the instructorID
        // This function wants to get specific Instructor but it first check if the instructor id exisits inside the hashMap or not.
        public Instructor getInstructor(int instructorID) {
             // This if condition says that if the hashmap instructors doesn't contain the entered instructorID , then this instructor doesn't exisit.And print a statment says that hashmap instructors
            // don't have this ID.
            if (!this.instructors.containsKey(instructorID)) {
                
			System.out.println("Instructors doesn't have this " + instructorID);
		}
            
               // If the ID was iniside the hashmap then it will return this instructor 
		return (Instructor) this.instructors.get(instructorID);
	}

	// This function it take a courseID and then search inside the hashmap of courses if the id is found then it return course from the courseID
        // This function wants to get specific Course but it first check if the Course id exisits inside the hashMap or not.
	public Course getCourse(int courseID) {
            // This if condition says that if the hashmap courses doesn't contain the entered courseID , then this instructor doesn't exisit.And print a statment says that hashmap courses
            // don't have this ID.
            if (!this.courses.containsKey(courseID)) {
                
			System.out.println("Courses doesn't have this " + courseID);
		}
            
                 // If the ID was iniside the hashmap then it will return this Course 
		return (Course) this.courses.get(courseID);
	}
        
        // This function take a groupId and then make an object from class Group named group and it get the groupId from the hashmap and then cast to class Group to get 
        // all its info then it return the int array of the courseID that is inside this object group.
        public int[] getGroupCourses(int groupId) {
		Group group = (Group) this.groups.get(groupId);
		return group.getCourseIds();
	}

	// This function it take a groupID and then search inside the hashmap of groups if the id is found then it return Group from the groupID
        // This function wants to get specific Group but it first check if the Group id exisits inside the hashMap or not.
	public Group getGroup(int groupId) {
            
             // This if condition says that if the hashmap groups doesn't contain the entered groupID , then this Group doesn't exisit.And print a statment says that hashmap groups
            // don't have this ID.
            if (!this.groups.containsKey(groupId)) {
                
			System.out.println("groups doesn't have this " + groupId);
		}
            
                // If the ID was iniside the hashmap then it will return this Group 
		return (Group) this.groups.get(groupId);
	}
        
        
        // This function return group as an array and put all the values in this array, as to used it in the enhanced forloop
        public Group[] getGroupsAsArray() {
		return (Group[]) this.groups.values().toArray(new Group[this.groups.size()]);
	}


        // This function it take a timeslotId and then search inside the hashmap of timeslots if the id is found then it return TimeSlot from the timeslotId
        // This function wants to get specific TimeSlot but it first check if the timeslot id exisits inside the hashMap or not.
	public TimeSlot getTimeslot(int timeslotId) {
            
            // This if condition says that if the hashmap timeslots doesn't contain the entered timeslotId , then this TimeSlot doesn't exisit.And print a statment says that hashmap timeslots
            // don't have this ID.
            if (!this.timeslots.containsKey(timeslotId)) {
                
			System.out.println("groups doesn't have this " + timeslotId);
		}
            
                 // If the ID was iniside the hashmap then it will return this TimeSlot 
		return (TimeSlot) this.timeslots.get(timeslotId);
	}

	// This function get random Timeslot and return it 
	public TimeSlot getRandomTimeslot() {
               // Object is a superclass which have everything
               // Object array accepts different types like string, int , float and many more. So the array type is Object as to take the values from the timeslots hashMap
		Object[] timeslotArray = this.timeslots.values().toArray();
                // Here it get a random timeslot and put it inside array timeslotArray and then it cast it's type to TimeSlot class
		TimeSlot timeslot = (TimeSlot) timeslotArray[(int) (timeslotArray.length * Math.random())];
                 // Finally it return the random TimeSlot in a variable named timeslot
		return timeslot;
	}

        
        public int calcClashes() {
		int clashes = 0;

		for (Class classA : this.classes) {
			// Check room capacity
			int hallCapacity = this.getHall(classA.getHallId()).getCapacity();
			int groupSize = this.getGroup(classA.getGroupId()).getGroupSize();
			
			if (hallCapacity < groupSize) {
				clashes++;
			}

			// Check if room is taken
			for (Class classB : this.classes) {
				if (classA.getHallId()== classB.getHallId() && classA.getTimeslotId() == classB.getTimeslotId()
						&& classA.getClassId() != classB.getClassId()) {
					clashes++;
					break;
				}
			}

			// Check if professor is available
			for (Class classB : this.classes) {
				if (classA.getInstructorId()== classB.getInstructorId() && classA.getTimeslotId() == classB.getTimeslotId()
						&& classA.getClassId() != classB.getClassId()) {
					clashes++;
					break;
				}
			}
		}

		return clashes;
	}

}

