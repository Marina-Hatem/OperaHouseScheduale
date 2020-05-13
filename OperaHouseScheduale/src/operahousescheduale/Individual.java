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
    
    // The chromosome is array of int as the chromosome is like (101010). Chromosome  binary number which means 0's and 1's
    private int[] chromosome;
    // varaible named fitness which is inilized by -1
    // fitness is evaluation for the soultion
    private double fitness = -1;
    
    // This is a constractor that take an object from class TimeTable, also this function create a random  valid chromosome 
    public Individual(TimeTable timetable) {
                
                // The number of classes will be get from the function that is in the timetable 
		int numClasses = timetable.getNumClasses();

                // To get the chromosomeLenght it will be number of classes (numClasses) multiply by 3 , why 3? because the 3 constraints. 1 for the timeslotm 1 for the Instructor
                // And 1 for the hall 
		int chromosomeLength = numClasses * 3;
                
		// Creating new chromosome or new indvidual array which is inilized by the array of the length. For example of the chromosome length is 3 then the new chromsome is 3 (010).
		int newChromosome[] = new int[chromosomeLength];
                
                // Making a variable which is chromosomeIndex for the array to move by it
		int chromosomeIndex = 0;
                
		// This enhanced ForLoop loops on the object of class Group and loop on the group array in class timetable which is the function called getGroupAsArray in class timeTable.
		for (Group group : timetable.getGroupsAsArray()) {
			// This enhanced for loop loops on the coursesIDs which are in class Group. But here it will get it from the object group from the timetable
			for (int courseId : group.getCourseIds()) {
                            
				// Adding random TimeSlot 
				int timeslotId = timetable.getRandomTimeslot().getTimeslotID();
                                // Setting this timeSlot in the newChromsome array 
				newChromosome[chromosomeIndex] = timeslotId;
                                // Increment the chromosome index by 1
				chromosomeIndex++;

				// Adding random Hall
				int hallId = timetable.getRandomHall().getHallID();
                                // Setting this hall in the newChromsome array 
				newChromosome[chromosomeIndex] = hallId;
                                // Increment the chromosome index by 1
				chromosomeIndex++;

				// Adding random Instructor 
				Course course = timetable.getCourse(courseId);
                                // Setting this randomInstractor in the newChromsome array 
				newChromosome[chromosomeIndex] = course.getRandomInstructorID();
                                 // Increment the chromosome index by 1
				chromosomeIndex++;
			}
		}
                

                // FInally save the array of newChromosome in the array of Chromosome 
		this.chromosome = newChromosome;
	}
    
    // This constractor create a chromosome with a given length by t it may be invalid chromsome. So, this constractor is used in the crossoverPopulation method in order to initialize the offspring.
    public Individual(int chromosomeLength) {
		
                 // Creating random Individual (chrosmome)
		int[] individual;
		individual = new int[chromosomeLength];
		
                // The for loop check if the the gene is less than the chromsome length
		for (int gene = 0; gene < chromosomeLength; gene++) {
                    // The individual array will stroe inside it the gene
			individual[gene] = gene;
		}
		// The individual will be stored inside thr array of chromosome
		this.chromosome = individual;
	}
    
    // Initializes individual with specific chromosome
    
    public Individual(int[] chromosome) {
		// creatingindividual chromosome
		this.chromosome = chromosome;
	}
    
    // get the individual's chromosome
    public int[] getChromosome() {
		return this.chromosome;
	}
    
    // getting the Individual's chromsome length
    public int getChromosomeLength() {
		return this.chromosome.length;
	}
    
    
    // Set gene at offset
    public void setGene(int offset, int gene) {
		this.chromosome[offset] = gene;
	}
    
    // Set gene at offset
    public int getGene(int offset) {
		return this.chromosome[offset];
	}
    
    // Store individual's fitness
    public void setFitness(double fitness) {
		this.fitness = fitness;
	}
    
    
    // Gets individual's fitness
    public double getFitness() {
		return this.fitness;
	}
    
    /**
     *
     * @return output
     */
    @Override
    
    // To String return the String in a specific format to print it anywhere
    public String toString() {
		String output = "";
		for (int gene = 0; gene < this.chromosome.length; gene++) {
                    // The output varaible store the chromsome gene inside it 
			output += this.chromosome[gene] + ",";
		}
                // Fianlly it return the output with have the Chromsome's gene
		return output;
	}


    
        // Searching for a specific int gene inside the individual 
	public boolean containsGene(int gene) {
                // This for loop lopps on the chromsome length
		for (int i = 0; i < this.chromosome.length; i++) {
                       // If the chromomse of i is equal to gene which we searching for it will return true 
			if (this.chromosome[i] == gene) {
				return true;
			}
		}
                // If not it will return false
		return false;
	}


}
