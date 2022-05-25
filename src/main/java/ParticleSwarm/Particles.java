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
public class Particles {
    private int particleNumber;
    private double position=0, fitness,personalBestFitness;
    private ArrayList<Double> yCalculatedValues, xPosition,velocity,personalBest;

    public Particles(double firstPosition, double secondPosition,ArrayList<Double> xValues,ArrayList<Double> yValues,double prom,int _particleNumber){
        particleNumber = _particleNumber;
        yCalculatedValues = new ArrayList<>();
        xPosition = new ArrayList<>();
        velocity = new ArrayList<>();
        velocity.add(firstPosition*.1);
        velocity.add(secondPosition*.1);
        fillPosition(firstPosition+velocity.get(0), secondPosition+velocity.get(1));
        calculateYValues(xValues);
        setFitness(yValues, prom);
        position++;
    }

    public double getFitness() {
        return fitness;
    }

    public ArrayList<Double> getxPosition() {
        return xPosition;
    }
    
    public void updateParticle(double inertiaWeight,ArrayList<Double> globalBest,ArrayList<Double> xValues,double prom,ArrayList<Double> yValues){
        fillVelocityPosition(inertiaWeight, globalBest);
        fillPosition(xPosition.get(0)+velocity.get(0), xPosition.get(1)+velocity.get(1));
        calculateYValues(xValues);
        setFitness(yValues, prom);
    }
    private double calculateVelocity(double inertiaWeight,ArrayList<Double> globalBest,int number){
        return (double)(inertiaWeight*velocity.get(number))+(2*Math.random()*(personalBest.get(number)-xPosition.get(number)))+(2*Math.random()*(globalBest.get(number)-xPosition.get(number)));
    }
    
    private void fillVelocityPosition(double inertiaWeight,ArrayList<Double> globalBest){
        double velocityAuxiliar1,velocityAuxiliar2;
        velocityAuxiliar1 = calculateVelocity(inertiaWeight, globalBest, 0);
        velocityAuxiliar2 = calculateVelocity(inertiaWeight, globalBest, 1);
        velocity = new ArrayList<>();
        velocity.add(velocityAuxiliar1);
        velocity.add(velocityAuxiliar2);
        
    }
    
    public void fillPosition(double firstPosition,double secondPosition){
        xPosition = new ArrayList<>();
        xPosition.add(firstPosition);
        xPosition.add(secondPosition);
        
    }
    private double calculateEcuation(double x) {
        return xPosition.get(0) + (xPosition.get(1) * x);
    }

    private double superiorPartEcuation(ArrayList<Double> yValues) {
        double _fitness = 0;
        for (int i = 0; i < yCalculatedValues.size(); i++) {
            _fitness += (double) Math.pow((yValues.get(i) - yCalculatedValues.get(i)), 2);
        }
        return _fitness;
    }

    private double inferiorPartEcuation(ArrayList<Double> yValues, double yProm) {
        double _fitness = 0;
        for (int i = 0; i < yValues.size(); i++) {
            _fitness += (double) Math.pow(yValues.get(i) - yProm, 2);
        }
        return _fitness;
    }

    public void setFitness(ArrayList<Double> _yValues, double yProm) {
        double _fitness, auxiliar;
        _fitness = (double) ((superiorPartEcuation(_yValues) / inferiorPartEcuation(_yValues, yProm)));
        fitness = _fitness;
        replacePersonalBest();
    }

    public void calculateYValues(ArrayList<Double> _xValues) {
        yCalculatedValues = new ArrayList<>();

        for (int i = 0; i < _xValues.size(); i++) {
            yCalculatedValues.add(calculateEcuation(_xValues.get(i)));
        }
    }

    public void replacePersonalBest() {
        if (fitness < personalBestFitness || position==0) {
            personalBestFitness = fitness;
            personalBest = xPosition;
        }
        position++;
    }
    
    public boolean isAnswer(){
        return fitness<=0.023287016184291427 ;
    }

    @Override
    public String toString() {
        return "Particle No. "+String.valueOf(particleNumber)+" fitness=" + fitness + ", personalBest=" + personalBest + "\nxPosition=" + xPosition + ", velocity=" + velocity + '}';
    }
    
    
}

