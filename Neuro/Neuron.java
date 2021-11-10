import java.util.HashMap;
import java.util.ArrayList;

/*Base neuron class. Variables are named with the following shorthand convetions:
 "pt" : potential or potentiation. Eg ptStrength = potentiation strength
 "dn" : dendrite or dendritic. Eg dnInputMatrix = Dendritic Input Matrix
 "ax" : Axon. Eg axOutputMatrix = Axonal Output Matrix
 "nrn" : neuron/neural eg nrnMatrix = neural matrix
 Neurons must be contained in a master array so that they can be referred to by hashcode. 
*/
public class Neuron {
    int hash;
    int ptStrength; //potentiation strength, starts at a default value & affects child resistance
    double ptThreshold; //potentiation threshold 0.0-1.0
    boolean isRefractory; //is the neuron current refractory? Lasts 1-2ms
    
    HashMap<Integer, Double> dnInputMatrix; //the Dendritic Input Matrix maps hashcodes of parent neurons with the resistance value // = new Hashmap<>();
    ArrayList<Integer> axOutputMatrix; //Axonal Output Matrix. List of all cells this one connects to by hashcode (memory location?).
    
    public Neuron() {
        this.hash = this.hashCode();
    }
    
}

class NeuralMatrix {
    HashMap<Integer, Neuron> nrnMatrix;
    public NeuralMatrix (int terst) {
        nrnMatrix = new HashMap<>();
    }
    
    public void addNrn() {
    }    
}

class NeuronTesting {
    public static void main (String[] args) {
        HashMap<Integer, Neuron> neuralMatrix = new HashMap<>();
        Neuron a = new Neuron();
        
        neuralMatrix.put(a.hashCode(), a);
        System.out.println(a.hashCode());
        System.out.println(a.hash);
        
        
        Neuron[] arr = {a, new Neuron()};
        //System.out.println( arr[0] + " " + arr[1]);
    }
}