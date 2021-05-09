package org.aslem.composantsinformatiques;

import java.util.ArrayList;
import java.util.List;

public class TestAssemblagePC {
    public static void main(String[] args) {     
        List<Composant> composantsPc1 = new ArrayList<>();
        composantsPc1.add(new HardDisk(100, 2000, 0, 50.4));
        composantsPc1.add(new Alimentation(200, 1, 79.9));
        composantsPc1.add(new Processor(100, 15, "LGA", 2, 68.6));
        composantsPc1.add(new MemoryBar(14, 100, 3, 72.3));
        
        if (PC.testPuissance(composantsPc1)) {
            PC unPc = new PC(composantsPc1);
        }
    }
}
