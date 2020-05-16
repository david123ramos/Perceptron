package perceptron;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PerceptronProject {


    public static void main(String[] args) {
        
        Perceptron p = new Perceptron(); //Instancia neuronio
        
        Integer[][] collection = { {0 ,0},{0,1},{1,0},{1,1}, }; // valores de entrada
        Integer[] auxms = {0, 0, 0, 1};  //valores esperados
        
        ArrayList mysupervisors = new ArrayList<>();
        mysupervisors.addAll(Arrays.asList(auxms)); 
        
        ArrayList< List<Integer> > myentries = new ArrayList<>();
        
        //transforma o array bidimensional em uma lista de listas
        for (Integer[] myentrie : collection) { 
            myentries.add( Arrays.asList(myentrie) );

        }
        
        
        p.setEntries(myentries);
        p.setSupervisor(mysupervisors);
        p.train();
      
    }
}
