/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operahousescheduale;

/**
 *
 * @author Yasmine
 */

//This class is for the courses that will be taught in the opera house llike ballet, piano , vocals and drawing.

public class Course {
    // The couse id 
    private int CourseID;
    private String CourseCode;
    // The course name 
    private String Course;
    // Array of the ids of the instractors that are in the opera house
    private int InstructorIDS[];

    // The default constractor
    public Course() {
    }
    
    // Overloaded constractor to inilizae all the variables.

    public Course(int CourseID, String CourseCode, String Course, int[] InstructorIDS) {
        this.CourseID = CourseID;
        this.CourseCode = CourseCode;
        this.Course = Course;
        this.InstructorIDS = InstructorIDS;
    }

    //The getters and the setters
    public int getCourseID() {
        return CourseID;
    }

    public void setCourseID(int CourseID) {
        this.CourseID = CourseID;
    }

    public String getCourseCode() {
        return CourseCode;
    }

    public void setCourseCode(String CourseCode) {
        this.CourseCode = CourseCode;
    }

    public String getCourseName() {
        return Course;
    }

    public void setCourse(String Course) {
        this.Course = Course;
    }

    public int[] getInstructorIDS() {
        return InstructorIDS;
    }

    public void setInstructorIDS(int[] InstructorIDS) {
        this.InstructorIDS = InstructorIDS;
    }
    
    // This function get a random instructor id 
    public int getRandomInstructorID(){
    
        // There is a variable called Instructorid which stores the random ID
        // The function Math.random () gets any number by random then it multiplies it by the array length  as the function Math.radnom get number between 0 and 1 so ti get the id 
        // inisde the array it multiply by the length and it cast it into array of intgers
        int InstructorId=InstructorIDS[(int)(InstructorIDS.length * Math.random())];
        return InstructorId;
    }
    
}
