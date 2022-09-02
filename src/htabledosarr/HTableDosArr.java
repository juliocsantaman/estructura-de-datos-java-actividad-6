/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htabledosarr;

/**
 *
 * @author Julio Cesar Santaman Cruz.
 */
public class HTableDosArr {
    
    int[] arrClaves;
    String [] arrValores;
    int indiceClaves=0;
    int indiceValores=0;
    int tam=0;
    
    public HTableDosArr(int tam) {
        this.tam = tam;
        arrClaves = new int[this.tam];
        arrValores = new String[this.tam];
        
    }
    
    /*
    Devuelve TRUE si
    la hashtable está vacía, FALSE si no.
    */
    
    /*
    size() -> nos ayuda a decir el tamaño actual, .length en mi caso
    no sirve porque con esa propiedad me dice el tamaño de elementos que puedo
    tener y yo quiero que me diga los elementos que hay en su momento.
    */
    public boolean isEmpty() {
        if(size() == 0) {
            return true;
        } else {
            return false;
        }
    }   
    
    /*
    Regresa el número de elementos total,
    dentro de la hashtable.
    */
    public int size() {
        int c=0;
        
        /*
        Vamos a recorrer el arreglo que contiene las claves, 
        si en alguna posición del arreglo es diferente de cero quiere
        decir que en esa posición si hay un elemento agregado entonces nuestra
        variable c se incrementará en uno para saber cuanto es el tamaño que hay 
        actualmente.
        */
        for(int i=0; i<arrClaves.length; i++) {
            if(arrClaves[i] != 0) {
                c++;
            }
        }
        
        return c;
    }
    
    /*
    Devuelve la hashtable después de 
    agregar el elemento.
    k=key, v=value.
    */
    public void add(int k, String v) {
        
        /*
        Si el tamaño actual del arreglo es menor que el tamaño especificado por
        el usuario, entonces procede a añadir la clave al arreglo arrClaves y 
        añade el elemento al arreglo arrValores después se aumenta en un 
        las variables que controlan el índice de cada arreglo o de otra manera
        le mostraremos un mensaje de error.
        
        Si se quiere añadir un elemento con una clave ya existente, lo que
        ocurrirá en mi programa es que lo sobreescribirá con el nuevo valor,
        por el momento lo dejamos así porque no nos pidieron un método que elimine o algo así, 
        porque se podría indicar al usuario que está intentando agregar un elemento con 
        una clave ya existente y me acabo de dar cuenta que la API DE JAVA si 
        se añade un elemento con la misma clave lo que hace es que lo sobreescribe
        con el nuevo valor, que es como lo tengo en mi programa.
        */
        if(size() < this.tam) {
            arrClaves[indiceClaves] = k;
            this.indiceClaves++;
        
            arrValores[indiceValores] = v;
            this.indiceValores++;
        } else {
            System.out.println("Error: has alcanzado el tamaño máximo de elementos.");
        }
        
        
    }
    
    /*
    Devuelve un arreglo con los elementos correspondientes.
    Devuelve el elemento con base a la clave (k).
    */
    public String getByKey(int k) {
        int indice=-1;
        String elemento = "";
        String mensajeError="";
        
       
        
        for(int i=0; i<arrClaves.length; i++) {
            if(arrClaves[i] == k) {
                /*
                Si en nuestro arreglo que contiene las claves
                hay algun elemento que coincida con la clave
                especificada por el usuario, vamos a guardar ese índice
                para únicamente obtener ese elemento de nuestro arreglo
                que contiene los elementos con base al índice obtenido.
                */
                indice = i;
                elemento = arrValores[indice];
            } else {
                /*
                Esto es por si en el arreglo que contiene las claves
                no hay algún elemento con la clave especificada por
                el usuario, entonces le mandaremos un mensaje de error.
                */
                mensajeError = "Error: no existe un elemento con la clave especificada.";
            }
        }
        
        /*
        Si se logra encontrar el elemento con la clave especificada por el 
        usuario, le devolveremos el elemento o de otra manera le devolveremos
        un mensaje de error.
        */
        if(indice != -1) {
            return elemento;
        } else {
            return mensajeError;
        }
        
        
        
    }

    public static void main(String[] args) {
        
        //Creamos un objeto de tipo HTableDosArr llamado tabla.
        HTableDosArr tabla = new HTableDosArr(2);
        
        //Añadimos un elemento.
        tabla.add(5, "Julio");
        System.out.println("Hemos añadido un elemento.");
        
        //Añadimos otro elemento.
        tabla.add(2, "Juan");
        System.out.println("Hemos añadido otro elemento.");
        
        if(tabla.isEmpty()) {
            System.out.println("La tabla está vacía.");
        } else {
            System.out.println("La tabla no está vacía.");
        }
        
        //Muestra el número de elementos actuales.
        System.out.println("El tamaño es: " + tabla.size() + ".");
        
        //Muestra el elemento con key 5.
        System.out.println("El elemento es: " + tabla.getByKey(5));
        
    }
    
}
