package MATILDA;

import javax.swing.JOptionPane;

/**
 *
 * @author Adeaf
 */
public class MainMATILDA {

    public static void main(String[] args) {
        AVLTree MustDie = new AVLTree();
          //MustDie.InsertarAMano();
//        MustDie.insertar("Aaron");
//        MustDie.insertar("Bambi");
//        MustDie.insertar("Cagliostro");
//        MustDie.insertar("Circe");
//        MustDie.insertar("Delva");
//        MustDie.insertar("Andras");
//        MustDie.insertar("Anathem");
//        MustDie.insertar("Diane");
//        MustDie.insertar("HawwaH");
//        MustDie.insertar("Sylvana");
//        MustDie.insertar("Antharas");
//        MustDie.insertar("Kaley");
//        MustDie.insertar("Mestly");
//        MustDie.imprimir();
//        MustDie.Eliminar();
//       
        MustDie.imprimir();
        //MustDie.ver();
        //MustDie.imprim();
        //MustDie.buscar();
        String mientras = "";
        
        while (!mientras.equals("no")) {
            mientras = JOptionPane.showInputDialog(
                    "1. Insertar\n" +
                    "2. Eliminar\n" +
                    "3. Salir");
            switch(mientras) {
                case "1":
                    MustDie.InsertarAMano();
                    MustDie.imprimir();
                    break;
                case "2":
                    MustDie.Eliminar();
                    MustDie.imprimir();
                    break;
                case "3":
                    mientras = "no";
                    break;
            }
        }
    }
    
}
