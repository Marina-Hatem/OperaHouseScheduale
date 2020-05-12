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
public class Course {
    private int CourseID;
    private String CourseCode;
    private String Course;
    private int InstructorIDS[];

    public Course() {
    }

    public Course(int CourseID, String CourseCode, String Course, int[] InstructorIDS) {
        this.CourseID = CourseID;
        this.CourseCode = CourseCode;
        this.Course = Course;
        this.InstructorIDS = InstructorIDS;
    }

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
    public int getRandomInstructorID(){
    
        int InstructorId=InstructorIDS[(int)(InstructorIDS.length * Math.random())];
        return InstructorId;
    }
    
}
