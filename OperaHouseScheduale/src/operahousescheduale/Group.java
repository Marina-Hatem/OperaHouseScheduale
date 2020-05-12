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

// This class for the trainers that will have courses. It have attributes like group id and group size and array of int which is courseids. 
//For example group A3 , thery are 20 people and they take ballet course.
public class Group {

    private  int groupId;
    private  int groupSize;
    private  int CourseIds[];

    // Overloaded constractor to inilize the variables 
    public Group(int groupId, int groupSize, int[] CourseIds) {
        this.groupId = groupId;
        this.groupSize = groupSize;
        this.CourseIds = CourseIds;
    }
    
   // The getters and the setters.

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getGroupSize() {
        return groupSize;
    }

    public void setGroupSize(int groupSize) {
        this.groupSize = groupSize;
    }

    public int[] getCourseIds() {
        return CourseIds;
    }

    public void setCourseIds(int[] CourseIds) {
        this.CourseIds = CourseIds;
    }

   
}
