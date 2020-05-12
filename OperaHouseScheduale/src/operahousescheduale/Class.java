/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package operahousescheduale;
/**
 *
 * @author Toumie
 */

// The Class class represents a combination of all of the other classes. It represents a trainers group taking a course at a specific time, in a specific hall,
//with a specific Instructor in the opera house .

public class Class {

    private  int classId;
    private  int groupId;
    private  int CourseId;
    private int InstructorId;
    private int timeslotId;
    private int HallId;

    // The overloaded constactor which inilize all the variables.
    public Class(int classId, int groupId, int CourseId) {
        this.classId = classId;
        this.CourseId = CourseId;
        this.groupId = groupId;
    }

    public void addProfessor(int InstructorId) {
        this.InstructorId = InstructorId;
    }

    public void addTimeslot(int timeslotId) {
        this.timeslotId = timeslotId;
    }

    public void setHallId(int HallId) {
        this.HallId = HallId;
    }

    public int getInstructorId() {
        return InstructorId;
    }

    public void setInstructorId(int InstructorId) {
        this.InstructorId = InstructorId;
    }

    public int getHallId() {
        return HallId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public void setCourseId(int CourseId) {
        this.CourseId = CourseId;
    }

    public void setTimeslotId(int timeslotId) {
        this.timeslotId = timeslotId;
    }


    
    public int getClassId() {
        return this.classId;
    }

    public int getGroupId() {
        return this.groupId;
    }

    public int getCourseId() {
        return this.CourseId;
    }

    public int getProfessorId() {
        return this.InstructorId;
    }

    public int getTimeslotId() {
        return this.timeslotId;
    }

    public int getRoomId() {
        return this.HallId;
    }
}
