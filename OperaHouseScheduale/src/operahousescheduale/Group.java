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
public class Group {

    private final int groupId;
    private final int groupSize;
    private final int CourseIds[];

    public Group(int groupId, int groupSize, int CourseIds[]) {
        this.groupId = groupId;
        this.groupSize = groupSize;
        this.CourseIds = CourseIds;
    }

    public int getGroupId() {
        return this.groupId;
    }

    public int getGroupSize() {
        return this.groupSize;
    }

    public int[] getCourseIds() {
        return this.CourseIds;
    }
}
