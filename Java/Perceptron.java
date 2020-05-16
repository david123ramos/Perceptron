/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perceptron;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David
 */
public class Perceptron {
    
    private List<List<Integer>> entries;
    private List<Double> weights;
    private List<Integer> supervisor;
    private double lr;
    
    public Perceptron(){

        this.entries = new ArrayList<>();
        this.weights = new ArrayList<>();
        this.supervisor = new ArrayList<>();
        this.lr = 0.1;
                
        for( int i =0; i < 2; i++ ){
            this.weights.add(0.0);        
        }

    }
    
    
    public void setEntries(ArrayList entries) {
        this.entries = entries;
    }

    public void setWeights(ArrayList weights) {
        this.weights = weights;
    }

    public void setSupervisor(ArrayList supervisor) {
        this.supervisor = supervisor;
    }

    public void setLr(double lr) {
        this.lr = lr;
    }
    
    public int classify(List<Integer> value){
        
        double  sum = 0 ;
        
        for(int i =0; i < value.size(); i++){
            sum += this.weights.get(i) * value.get(i);
        }
         
        int aux = this.stepFunction(sum);
        return aux;
    }
    
    private int stepFunction(double value){
        return value >= 1.0 ? 1 : 0;
    }
    
    public void train(){
        
        int totalError = 1;
        
        while( totalError != 0 ){
            
            totalError = 0;
            
            for(int i =0; i < this.supervisor.size(); i++ ){
                
                int res = this.classify( this.entries.get(i)  );
                
                int error =  Math.abs( this.supervisor.get(i) - (int) res );
                

                totalError += error;
                
                for(int j = 0; j < this.weights.size(); j++){
                    
                    Double aux = this.weights.get(j);
                    this.weights.set(j,  aux + this.calculateNewWeight(error, i, j)) ;
                    
                    System.out.println("Pesos Atualizados "+this.weights.get(j));
                   
                }
                
                System.out.println("Total de erros "+totalError);
                
            }   
        }
    }
    
    
    private double calculateNewWeight(int error, int i, int j){
        return this.lr * this.entries.get(i).get(j) * error;
    }
}
