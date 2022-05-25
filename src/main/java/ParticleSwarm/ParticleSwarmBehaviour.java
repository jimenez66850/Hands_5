/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ParticleSwarm;

import jade.core.behaviours.Behaviour;

/**
 *
 * @author luisjimenezmendoza
 */
public class ParticleSwarmBehaviour extends Behaviour{
    private ParticleSwarm main = new ParticleSwarm();
    @Override
    public void action() {
        main.agentSwarmAlgorithm(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean done() {
        return main.isAnswer(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
