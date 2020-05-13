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
    
    public Individual(Timetable timetable) {
		int numClasses = timetable.getNumClasses();

		// 1 gene for room, 1 for time, 1 for professor
		int chromosomeLength = numClasses * 3;
		// Create random individual
		int newChromosome[] = new int[chromosomeLength];
		int chromosomeIndex = 0;
		// Loop through groups
		for (Group group : timetable.getGroupsAsArray()) {
			// Loop through modules
			for (int moduleId : group.getModuleIds()) {
				// Add random time
				int timeslotId = timetable.getRandomTimeslot().getTimeslotId();
				newChromosome[chromosomeIndex] = timeslotId;
				chromosomeIndex++;

				// Add random room
				int roomId = timetable.getRandomRoom().getRoomId();
				newChromosome[chromosomeIndex] = roomId;
				chromosomeIndex++;

				// Add random professor
				Module module = timetable.getModule(moduleId);
				newChromosome[chromosomeIndex] = module.getRandomProfessorId();
				chromosomeIndex++;
			}
		}

		this.chromosome = newChromosome;
	}
}
