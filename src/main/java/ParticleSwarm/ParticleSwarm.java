/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ParticleSwarm;

import java.util.ArrayList;

/**
 *
 * @author luisjimenezmendoza
 */
public class ParticleSwarm {
    private int iteration=0;
    private double promY, globalBestFitness;
    private ArrayList<Double> xValues, yValues, globalBest;
    private ArrayList<Particles> particles;

    public ParticleSwarm() {
        xValues = new ArrayList<>();
        yValues = new ArrayList<>();
        particles = new ArrayList<>();
        globalBest = new ArrayList<>();
        addXValues();
        addYValues();
        promY = prom(yValues);
        fillParticlesArray(10);
        System.out.println("****************************************************************************************************************************************************************");
                System.out.println("iteration: " + String.valueOf(iteration));

        System.out.println("Global best Fitness: "+globalBestFitness);
        System.out.println("Global best: "+globalBest);
        printArray();
    }

    public void agentSwarmAlgorithm() {
            iteration++;
            updateParticles(10);
System.out.println("iteration: " + String.valueOf(iteration));
            System.out.println("Global best Fitness: "+globalBestFitness);
            System.out.println("Global"+globalBest);
                        printArray();
    }

    public boolean isAnswer() {
        for (int i = 0; i < 10; i++) {
            if (!particles.get(i).isAnswer()) {
                return false;
            }
        }
        return true;
    }

    private void updateParticles(int particleSize) {
        for (int i = 0; i < particleSize; i++) {
            if(!particles.get(i).isAnswer())
                particles.get(i).updateParticle(.4, globalBest, xValues, promY, yValues);
            if (particles.get(i).getFitness() < globalBestFitness) {
                globalBestFitness = particles.get(i).getFitness();
                globalBest = particles.get(i).getxPosition();
            }
        }

    }

    private void addXValues() {
        xValues.add((double) 23.0);
        xValues.add((double) 26.0);
        xValues.add((double) 30.0);
        xValues.add((double) 34.0);
        xValues.add((double) 43.0);
        xValues.add((double) 48.0);
        xValues.add((double) 52.0);
        xValues.add((double) 57.0);
        xValues.add((double) 58.0);
    }

    private double prom(ArrayList<Double> values) {
        double media = 0;
        for (int i = 0; i < values.size(); i++) {
            media += values.get(i);
        }
        return media / 9;
    }

    private void addYValues() {
        yValues.add((double) 651);
        yValues.add((double) 762);
        yValues.add((double) 856);
        yValues.add((double) 1063);
        yValues.add((double) 1190);
        yValues.add((double) 1298);
        yValues.add((double) 1421);
        yValues.add((double) 1440);
        yValues.add((double) 1518);

    }

    private void fillParticlesArray(int particleSize) {
        for (int i = 0; i < particleSize; i++) {
            Particles particle = new Particles((Math.random()) * 165, (Math.random()) * 25, xValues, yValues, promY,i);
            particles.add(particle);
            if (particles.get(i).getFitness() < globalBestFitness || i == 0) {
                globalBestFitness = particles.get(i).getFitness();
                globalBest = particles.get(i).getxPosition();
            }

        }
    }

    private void printArray() {
        for (int i = 0; i < 10; i++) {
            System.out.println(particles.get(i));
        }
                System.out.println("****************************************************************************************************************************************************************");

    }

}
