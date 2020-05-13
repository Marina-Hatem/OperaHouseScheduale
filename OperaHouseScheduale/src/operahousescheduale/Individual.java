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
public class Individual {
    
    // The chromosome is array of int as the chromosome is like (101010) 
    private int[] chromosome;
    // varaible named fitness which is inilized by -1
    private double fitness = -1;
    
    
    public Individual(TimeTable timetable) {
		int numClasses = timetable.getNumClasses();

		// 1 gene for room, 1 for time, 1 for professor
		int chromosomeLength = numClasses * 3;
		// Create random individual
		int newChromosome[] = new int[chromosomeLength];
		int chromosomeIndex = 0;
		// Loop through groups
		for (Group group : timetable.getGroupsAsArray()) {
			// Loop through modules
			for (int courseId : group.getCourseIds()) {
				// Add random time
				int timeslotId = timetable.getRandomTimeslot().getTimeslotID();
				newChromosome[chromosomeIndex] = timeslotId;
				chromosomeIndex++;

				// Add random room
				int hallId = timetable.getRandomHall().getHallID();
				newChromosome[chromosomeIndex] = hallId;
				chromosomeIndex++;

				// Add random professor
				Course course = timetable.getCourse(courseId);
				newChromosome[chromosomeIndex] = course.getRandomInstructorID();
				chromosomeIndex++;
			}
		}

		this.chromosome = newChromosome;
	}
}
