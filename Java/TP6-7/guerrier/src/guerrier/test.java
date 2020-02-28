/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guerrier;

/**
 *
 * @author aperrin
 */
public class test {
    public static void main (String [] args){
        Guerrier Yggdrasil = new Guerrier ();
        Guerrier Miyamoto = new Guerrier ();
        Guerrier cp = new Guerrier();
        cp.viellir.add(Yggdrasil);
        cp.viellir.add(Miyamoto);
    }
}
