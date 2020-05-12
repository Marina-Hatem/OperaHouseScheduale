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
public class Class {

    private final int classId;
    private final int groupId;
    private final int CourseId;
    private int InstructorId;
    private int timeslotId;
    private int HallId;

    public Class(int classId, int groupId, int CourseId) {
        this.classId = classId;
        this.CourseId = CourseId;
        this.groupId = groupId;
    }

    public void addProfessor(int professorId) {
        this.InstructorId = InstructorId;
    }

    public void addTimeslot(int timeslotId) {
        this.timeslotId = timeslotId;
    }

    public void setRoomId(int roomId) {
        this.HallId = HallId;
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
