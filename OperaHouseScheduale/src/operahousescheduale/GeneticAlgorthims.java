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
public class GeneticAlgorthims {
    
        private int populationSize;
	private double mutationRate;
	private double crossoverRate;
	private int elitismCount;
	protected int tournamentSize;
        
        
        // Overloaded Constractor inililize all the variables 
       public GeneticAlgorthims(int populationSize, double mutationRate, double crossoverRate, int elitismCount,
			int tournamentSize) {

		this.populationSize = populationSize;
		this.mutationRate = mutationRate;
		this.crossoverRate = crossoverRate;
		this.elitismCount = elitismCount;
		this.tournamentSize = tournamentSize;
	}
       
       // Initialize population
       public Population initPopulation(TimeTable timetable) {
		// Initialize population
		Population population = new Population(this.populationSize, timetable);
		return population;
	}
       
       // Check if population has met termination condition
       // generationsCount is Number of generations passed,maxGenerations is Number of generations to terminate after
       public boolean isTerminationConditionMet(int generationsCount, int maxGenerations) {
           //boolean True if termination condition met, otherwise, false
		return (generationsCount > maxGenerations);
	}
       
       // Check if population has met termination condition
       public boolean isTerminationConditionMet2(Population population) {
           // boolean True if termination condition met, otherwise, false
		return population.getFittest(0).getFitness() == 1.0;
	}
       
       // Calculate individual's fitness value
       public double calcFitness(Individual individual, TimeTable timetable) {

		// Create new timetable object to use 
		TimeTable timetables = new TimeTable(timetable);
		timetables.createClasses(individual);

		// caclulating number of conflicts
		int conflicts = timetables.calcConflicts();
                // Calculate fitness
		double fitness = 1 / (double) (conflicts + 1);

		individual.setFitness(fitness);

		return fitness;
	}

       
       
       // Evaluate population
       public void evaluatePopulation(Population population, TimeTable timetable) {
		double populationFitness = 0;

		// Loop over population evaluating individuals and summing populationFitness
		for (Individual individual : population.getPopulation()) {
			populationFitness += this.calcFitness(individual, timetable);
		}

                // setting populationFitness in setPopulationFitness
		population.setPopulationFitness(populationFitness);
	}
       
       
       
       // Selects parent for crossover using tournament( is a method of selecting an individual from a population of individuals ) selection
       public Individual selectParent(Population population) {
		// Create tournament
		Population tournament = new Population(this.tournamentSize);

		// Add random individuals to the tournament
		population.mix();
		for (int i = 0; i < this.tournamentSize; i++) {
			Individual tournamentIndividual = population.getIndividual(i);
			tournament.setIndividual(i, tournamentIndividual);
		}

		// Return the best tournament
		return tournament.getFittest(0);
	}
       
       
       
       // Apply mutation (The gene that is different than other in the chromosome for example chromomse1 01010  chromomse2 01110 the changing from 0 to 1 is called mutation) to population 
       public Population mutatePopulation(Population population, TimeTable timetable) {
		// Initialize new population
		Population newPopulation = new Population(this.populationSize);

		// This ForLoop loops over current population by fitness
		for (int populationIndex = 0; populationIndex < population.size(); populationIndex++) {
			Individual individual = population.getFittest(populationIndex);

			// Create random individual to swap genes with
			Individual randomIndividual = new Individual(timetable);

			//This for loop loops on the individual chromsome length 
			for (int geneIndex = 0; geneIndex < individual.getChromosomeLength(); geneIndex++) {
				// Skip mutation if this is an elite individual
				if (populationIndex > this.elitismCount) {
					// Does this gene need mutation?
					if (this.mutationRate > Math.random()) {
						// Swap for new gene
						individual.setGene(geneIndex, randomIndividual.getGene(geneIndex));
					}
				}
			}

			// Add individual to population
			newPopulation.setIndividual(populationIndex, individual);
		}

		// Return mutated population
		return newPopulation;
	}

       
       
       
       // Apply crossover to population
       public Population crossoverPopulation(Population population) {
		// Creating  new population
		Population newPopulation = new Population(population.size());

		// This ForLoop loops over current population by fitness
		for (int populationIndex = 0; populationIndex < population.size(); populationIndex++) {
			Individual parent1 = population.getFittest(populationIndex);

			// Applying crossover to this individual
			if (this.crossoverRate > Math.random() && populationIndex >= this.elitismCount) {
				// Initializing offspring
				Individual offspring = new Individual(parent1.getChromosomeLength());
				
				// Finding the second parent
				Individual parent2 = selectParent(population);

				// This for loop loops on parent1 chromsome length
				for (int geneIndex = 0; geneIndex < parent1.getChromosomeLength(); geneIndex++) {
					// Use half of parent1's genes and half of parent2's genes
					if (0.5 > Math.random()) {
						offspring.setGene(geneIndex, parent1.getGene(geneIndex));
					} else {
						offspring.setGene(geneIndex, parent2.getGene(geneIndex));
					}
				}

				// Add offspring to new population
				newPopulation.setIndividual(populationIndex, offspring);
			} else {
				// Add individual to new population without applying crossover
				newPopulation.setIndividual(populationIndex, parent1);
			}
		}

                // return the new population after the crossover
		return newPopulation;
	}

}
