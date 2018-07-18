/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MATILDA;

/**
 *
 * @author Adeaf
 */
public class NdoAVL {

    String dato;
    public NdoAVL izq, der, padre;
    int fe;

    public NdoAVL(String dato) {
        this.dato = dato;
    }

    @Override
    public String toString() {
        return "NdoAVL{" + "izq=" + izq + ", der=" + der + ", padre=" + padre + '}';
    }

public int Nana(){
    if(der == null && izq == null)
        return 0;
    if(der != null && izq != null)
        return 2;
    else
        return 1;
}    

}
