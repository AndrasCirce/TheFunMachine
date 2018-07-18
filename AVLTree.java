package MATILDA;

import javax.swing.JOptionPane;

/**
 *
 * @author Adeaf
 */
public class AVLTree {

    private NdoAVL raiz;
    NdoAVL inicio, fin, sig, padre;
    int height;

    public void insertar(String name) {

        if (raiz == null) {//No existe raiz, asi que la creamos
            raiz = new NdoAVL(name);
            System.out.println("Nodo insertado: " + raiz.dato);
        } else {
            insertax(raiz, name);
            System.out.println("Nodo insertado: " + padre.dato);
            Fathersfather(padre);
        }

    }

    public void InsertarAMano() {
        String ojo = "";
        while (!ojo.equals("no")) {
            ojo = capturar("Inserta un nodo");
            if (!ojo.equals("no"))
                insertar(ojo);
        }
    }

    public void insertax(NdoAVL r, String name) {

        if (r.dato.compareTo(name) != 0) {
            if (r.dato.compareTo(name) > 0) {//dato va a la izquierda
                if (r.izq == null) {
                    padre = r.izq = new NdoAVL(name);
                    r.izq.padre = r;
                } else {
                    insertax(r.izq, name);
                }
            } else {//dato va a la derecha
                if (r.der == null) {
                    padre = r.der = new NdoAVL(name);
                    r.der.padre = r;
                } else {
                    insertax(r.der, name);
                }
            }
        } else {
            System.out.println("El dato'" + name + "' ya existe");
        }
    }

    public int Altura(NdoAVL r) {
        if (r == null) {
            return 0;
        }
        int a = Math.max(Altura(r.izq), Altura(r.der)) + 1;
        return a;

    }

    public int FE(NdoAVL r) {
        if (r == null) {
            return 0;
        }
        int Ali = Altura(r.izq), Ald = Altura(r.der);
        return Ali - Ald;
    }

    public void imprimir() {
        inorden(raiz);
    }

    public void inorden(NdoAVL r) {
        if (r != null) {
            inorden(r.izq);
            System.out.printf("- %15s %5s\n", r.dato, FE(r));

            inorden(r.der);

        }
    }

    public void preorden(NdoAVL r) {
        if (r != null) {

            System.out.println(r.dato);
            inorden(r.izq);
            inorden(r.der);
        }
    }

    public NdoAVL buscar() {
        String ojo = capturar("Escribe a quien buscas");

        if (raiz == null) {//No existe raiz, asi no existen datos; no existe el nombre
            System.out.println("No hay que buscar");
            return null;
        } else {
            //buscarx(raiz, ojo);
            return buscarx(raiz, ojo);
        }
    }

    public NdoAVL buscarx(NdoAVL r, String name) {
        NdoAVL n;
        if (r == null) {
            JOptionPane.showMessageDialog(null,
                    "No existe ese nombre",
                    "Nodo no encotrado",
                    JOptionPane.ERROR_MESSAGE,
                    null);
            return null;
        } else {
            if (r.dato.compareTo(name) == 0) {
                System.out.println("Encontramos a " + r.dato);
                return r;
            } else {
                if (r.dato.compareTo(name) > 0) { // Busqueda por la izquierda
                    n = buscarx(r.izq, name);
                } else { // Busqueda por la derecha
                    n = buscarx(r.der, name);
                }
            }
        }
        return n;
    }

    public String capturar(String ss) {
        String s;
        s = JOptionPane.showInputDialog(ss);
        return (s);
    }

    public void DD(NdoAVL r) {
        NdoAVL sp = r;
        NdoAVL sh = r.der;
        NdoAVL ff = r.padre;
        sp.der = sh.izq;
        if (sp.der != null)//evaluar que hijo derecho de hijo izquierdo exista
        {
            sp.der.padre = sp;
        }
        sh.izq = sp;
        sh.padre = ff;
        sp.padre = sh;
        if (ff != null) {
            if (ff.dato.compareTo(sh.dato) > 0) {//no es raiz
                ff.izq = sh;
            } else {
                ff.der = sh;
            }
        } else {
            raiz = sh;
        }

    }

    public void II(NdoAVL r) {
        NdoAVL sp = r;
        NdoAVL sh = r.izq;
        NdoAVL ff = r.padre;
        sp.izq = sp.der;
        if (sp.izq != null)//evaluar que hijo izquierdo de hijo derecho exista
        {
            sh.izq.padre = sp;
        }
        sh.der = sp;
        sh.padre = ff;
        sp.padre = sh;
        if (ff != null) {
            if (r.dato.compareTo(sh.dato) > 0) {
                ff.der = sh;
            } else {
                raiz = sp;
            }
        } else {
            raiz = sh;
        }

    }

    public void DI(NdoAVL r) {
        NdoAVL A = r;
        NdoAVL B = A.der;
        NdoAVL C = B.izq;
        NdoAVL ff = A.padre;
        A.der = C.izq;
        C.izq = A;
        A.padre = C;
        B.padre = C;
        C.padre = ff;
        B.izq = C.der;
        C.der = B;
        if (A.der != null) {
            A.der.padre = A;
        }
        if (B.izq != null) {
            B.izq.padre = B;
        }
        if (ff == null) {
            raiz = C;
        } else {
            if (ff.dato.compareTo(C.dato) > 0) {
                ff.izq = C;
            } else {
                ff.der = C;
            }
        }
    }

    public void ID(NdoAVL r) {
        NdoAVL A = r;
        NdoAVL B = A.izq;
        NdoAVL C = B.der;
        NdoAVL ff = A.padre;
        A.izq = C.der;
        C.der = A;

        A.padre = C;
        B.padre = C;
        C.padre = ff;
        B.der = C.der;
        C.izq = B;
        if (A.izq != null) {
            A.izq.padre = A;
        }
        if (B.der != null) {
            B.der.padre = B;
        }
        if (ff == null) {
            raiz = C;
        } else {
            if (ff.dato.compareTo(C.dato) > 0) {
                ff.izq = C;
            } else {
                ff.der = C;
            }
        }
    }

    public void Fathersfather(NdoAVL r) {//obtener padre anteriores al nodo a evaluar
        if (r != null) {
            if (FE(r) == 2 || FE(r) == -2) {
                Balancear(r);
            }
            Fathersfather(r.padre);
        }
    }

    public void Balancear(NdoAVL r) {
        if (FE(r) == 2) {
            if (Altura(r.izq.izq) > Altura(r.izq.der)) {
                System.out.println("    Izquierda izquierda: " + r.dato);
                II(r);
            } else {
                System.out.println("    Izquierda derecha: " + r.dato);
                ID(r);
            }

        } else {
            if (Altura(r.der.der) > Altura(r.der.izq)) {
                System.out.println("    Derecha derecha: " + r.dato);
                DD(r);
            } else {
                System.out.println("    Derecha izquierda: " + r.dato);
                DI(r);
            }
        }

    }

    public void Eliminar() {
        NdoAVL r = buscar();
        NdoAVL aux = null;
        if (r != null) {
            switch (r.Nana()) {
                case 0:
                    aux = Borrar(r);
                    System.out.println("eliminar hoja");
                    break;
                case 1:
                    aux = BorrarORama(r);
                    System.out.println("eliminar rama");
                    break;
                case 2:
                    aux = BorrarRaiz(r);
                    System.out.println("eliminar raiz");
                    break;
            }
            Fathersfather(aux.padre);
        }
    }

    public NdoAVL Borrar(NdoAVL r) {
        NdoAVL guts = null;

        if (r.padre != null) {
            guts = r;
            if (r.padre.dato.compareTo(r.dato) > 0) {
                r.padre.izq = null;
            } else {
                r.padre.der = null;
            }
        }
        return guts;
    }

    public NdoAVL BorrarORama(NdoAVL r) {
        NdoAVL A = r.padre;
        NdoAVL B = r;
        NdoAVL C;
        if (r == raiz) {
            if (r.der != null) {
                raiz = r.der;
                r.der.padre = null;
                r.der = null;
            } if(r.izq != null){
                raiz = r.izq;
                r.izq.padre = null;
                r.izq = null;
            }
        } else {
            if (B.der != null) {
                C = B.der;
            } else {
                C = B.izq;
            }
            if (A.dato.compareTo(B.dato) < 0) { // es hijo derecho
                A.der = C;
                C.padre = A;
            } else {// es hijo izquierdo
                A.izq = C;
                C.padre = A;
            }
        }
        return B;
    }

    public NdoAVL BorrarRaiz(NdoAVL r) {
        NdoAVL A = r;
        NdoAVL Aux = A.izq;
        while (Aux.der != null) {
            Aux = Aux.der;
        }
        NdoAVL guts = null;
        switch (Aux.Nana()) {
            case 0:
                guts = Borrar(Aux);
                break;
            case 1:
                guts = BorrarORama(Aux);
                break;
        }
        A.dato = guts.dato;
        return guts;
    }
}
