package AdapterPattern.Client;

import AdapterPattern.Adaptee.WeightMachineForBabies;
import AdapterPattern.Adapter.WeightMachineAdapter;
import AdapterPattern.Adapter.WeightMachineAdapterImpl;

public class Main {

    public static void main(String args[]){

        WeightMachineAdapter weightMachineAdapter = new WeightMachineAdapterImpl(new WeightMachineForBabies());
        System.out.println(weightMachineAdapter.getWeightInKg());
    }
}

