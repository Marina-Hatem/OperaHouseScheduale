/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operahousescheduale;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 *
 * @author meriam
 */

// Poplualtion consists of many chromsomoses 
public class Population {
    
    // oject from class Individual which is population and it is array
    private Individual population[];
    // double variable which is populationFitness and inislized by -1
    private double populationFitness = -1;
    
    
    // Constractor that takes the populationSize 
    public Population(int populationSize) {
		// Initialize population
		this.population = new Individual[populationSize];
	}
    
    // Another Constractor that takes the poulationSize and object from the TimeTable class
    public Population(int populationSize, TimeTable timetable) {
		// Initial population
		this.population = new Individual[populationSize];

                // This for loop loops on the population size 
		for (int individualCount = 0; individualCount < populationSize; individualCount++) {
			// Creating Individual 
			Individual individual = new Individual(timetable);
			// Adding Individual to population
			this.population[individualCount] = individual;
		}
	}
    
    
    // Another Constractor that takes populationSize and chromsomeLength to inilize population of individuals
    public Population(int populationSize, int chromosomeLength) {
		// Initiaizel population
		this.population = new Individual[populationSize];

		// This for loop loops on the population size 
		for (int individualCount = 0; individualCount < populationSize; individualCount++) {
			// Creating Individual 
			Individual individual = new Individual(chromosomeLength);
			// Adding Individual to population
			this.population[individualCount] = individual;
		}
	}


    // get for the variable population array 
    public Individual[] getPopulation() {
		return this.population;
	}
    
    
    // Find fittest individual in the population
    public Individual getFittest(int offset) {
		// Comparator sort population by fitness
		Arrays.sort(this.population, new Comparator<Individual>() {
			@Override
                        // comparator compares two objects from individual
			public int compare(Individual o1, Individual o2) {
				if (o1.getFitness() > o2.getFitness()) {
					return -1;
				} else if (o1.getFitness() < o2.getFitness()) {
					return 1;
				}
				return 0;
			}
		});

		// Return the fittest individual
		return this.population[offset];
	}
    
    
    // Setting the fitness
        public void setPopulationFitness(double fitness) {
		this.populationFitness = fitness;
	}

	
    
        // Get method for getting population fitiness
	public double getPopulationFitness() {
		return this.populationFitness;
	}

        
	// Get population Size
	public int size() {
		return this.population.length;
	}


        
        // set individual at offset 
	public Individual setIndividual(int offset, Individual individual) {
		return population[offset] = individual;
	}
        

	// get Individual at offset 
	public Individual getIndividual(int offset) {
		return population[offset];
	}

	
	public void mix() {
            // Random for getting random number 
		Random random = new Random();
                // This for loop loops on the population length
		for (int i = population.length - 1; i > 0; i--) {
                        // It will get random int and put it in the index
			int index = random.nextInt(i + 1);
                        // These steps for shuffle the population to put it in the right place 
			Individual a = population[index];
			population[index] = population[i];
			population[i] = a;
		}
	}

}
