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
public class OperaHouseScheduale {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // Get a Timetable object with all the available information.
        TimeTable timetable = initializeOperaTimetable();
        
        // Initialize Genetic Algorthims
        GeneticAlgorthims ga = new GeneticAlgorthims(100, 0.01, 0.9, 2, 5);
        
        // Initialize population
        Population population = ga.initPopulation(timetable);
        
        // Evaluate population
        ga.evaluatePopulation(population, timetable);
        
        // Keep track of current generation
        int generation = 1;
    
    
   
     while (ga.isTerminationConditionMet(generation, 1000) == false
            && ga.isTerminationConditionMet2(population) == false) {
            // Print fitness
            System.out.println("Generation" + generation + " Best fitness: " + population.getFittest(0).getFitness());

            // Apply crossover
            population = ga.crossoverPopulation(population);

            // Apply mutation
            population = ga.mutatePopulation(population, timetable);

            // Evaluate population
            ga.evaluatePopulation(population, timetable);

            // Increment the current generation
            generation++;
        }

        // Print fitness
        timetable.createClasses(population.getFittest(0));
        System.out.println();
        System.out.println("Solution found in " + generation + " generations");
        System.out.println("Final solution fitness: " + population.getFittest(0).getFitness());
        System.out.println("Conflictes: " + timetable.calcConflicts());

        // Print classes
        System.out.println();
        Class classes[] = timetable.getClasses();
        int classIndex = 1;
        for (Class bestClass : classes) {
            System.out.println("Class " + classIndex + ":");
            System.out.println("Course: " + 
                    timetable.getCourse(bestClass.getCourseId()).getCourseName());
            System.out.println("Group: " + 
                    timetable.getGroup(bestClass.getGroupId()).getGroupId());
            System.out.println("Hall: " + 
                    timetable.getHall(bestClass.getHallId()).getHallNumber());
            System.out.println("Instructor: " + 
                    timetable.getInstructor(bestClass.getInstructorId()).getInstructorName());
            System.out.println("TimeSlot: " + 
                    timetable.getTimeslot(bestClass.getTimeslotId()).getTimeSlot());
            System.out.println("---------------------------------------------------------------------------");
            classIndex++;
        }
    }

        //Creates a Timetable with all the necessary information.
	private static TimeTable initializeOperaTimetable() {
		// Create timetable
		TimeTable timetable = new TimeTable();

		// Set up halls
		timetable.addHall(1, 10 , "A1");
		timetable.addHall(2, 30,  "B4");
		timetable.addHall(3, 20 , "D1");
		timetable.addHall(4, 25 , "F2");
                timetable.addHall(5, 35 , "H5");

		// Set up timeslots
		timetable.addTimeSlot(1, "Mon 9:00 - 11:00");
		timetable.addTimeSlot(2, "Mon 11:00 - 13:00");
		timetable.addTimeSlot(3, "Mon 13:00 - 15:00");
                timetable.addTimeSlot(4, "Mon 15:00 - 17:00");
		timetable.addTimeSlot(5, "Tue 9:00 - 11:00");
		timetable.addTimeSlot(6, "Tue 11:00 - 13:00");
		timetable.addTimeSlot(7, "Tue 13:00 - 15:00");
                timetable.addTimeSlot(8, "Tue 15:00 - 17:00");
		timetable.addTimeSlot(9, "Wed 9:00 - 11:00");
		timetable.addTimeSlot(10,"Wed 11:00 - 13:00");
		timetable.addTimeSlot(11,"Wed 13:00 - 15:00");
                timetable.addTimeSlot(12,"Wed 15:00 - 17:00");
		timetable.addTimeSlot(13,"Thu 9:00 - 11:00");
		timetable.addTimeSlot(14,"Thu 11:00 - 13:00");
		timetable.addTimeSlot(15,"Thu 13:00 - 15:00");
		timetable.addTimeSlot(16,"Fri 8:00 - 10:00");
                timetable.addTimeSlot(17,"Fri 13:00 - 15:00");
		timetable.addTimeSlot(18,"Sat 11:00 - 13:00");
		timetable.addTimeSlot(19,"Sat 13:00 - 15:00");

		// Set up Instructors
		timetable.addInstructor(1, "Ms Mariam");
		timetable.addInstructor(2, "Mrs Marina");
		timetable.addInstructor(3, "Mr Joe");
		timetable.addInstructor(4, "Mr Mark");
                timetable.addInstructor(5, "Mr Moustafa");
                timetable.addInstructor(6, "Ms Shima");
                timetable.addInstructor(7, "Ms Meriam");
		timetable.addInstructor(8, "Mrs Alaa");
		timetable.addInstructor(9, "Mr David");
		timetable.addInstructor(10, "Mr Ahmed");
                timetable.addInstructor(11, "Mr Karim");
                timetable.addInstructor(12, "Ms Fatma");
                

		// Set up courses and define the Instructors that teach them
		timetable.addCourse(1, "D1", "Drawing", new int[] { 1, 2 });
		timetable.addCourse(2, "PI1", "Playing Piano", new int[] { 7, 9 });
		timetable.addCourse(3, "VI1", "Playing violin", new int[] { 3, 4 });
		timetable.addCourse(4, "GR1", "Playing Guiter", new int[] { 6, 11 });
		timetable.addCourse(5, "VO1", "Vocals", new int[] { 8,10 });
		timetable.addCourse(6, "BT1", "Ballet", new int[] { 5, 12 });

		// Set up student groups and the modules they take.
		timetable.addGroup(1, 10, new int[] { 1, 2 });
		timetable.addGroup(2, 30, new int[] { 2, 5, 6 });
		timetable.addGroup(3, 18, new int[] { 3, 4, 5 });
		timetable.addGroup(4, 25, new int[] { 1, 4 });
		timetable.addGroup(5, 20, new int[] { 2, 3, 5 });
		timetable.addGroup(6, 34, new int[] { 1, 4, 5 });
		timetable.addGroup(7, 16, new int[] { 6, 1 });
		timetable.addGroup(8, 18, new int[] { 2, 5 });
		timetable.addGroup(9, 24, new int[] { 6 });
		timetable.addGroup(10, 25, new int[] { 3, 4 });
		return timetable;
	
}

}
