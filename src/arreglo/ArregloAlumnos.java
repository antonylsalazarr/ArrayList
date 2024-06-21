package arreglo;

//Aqui se programan los mantenimientos

import java.util.ArrayList;
import clase.Alumno;

public class ArregloAlumnos {
    
    // El atributo privado ArrayList alu de tipo Alumno
    private ArrayList <Alumno> alu;
    
    // Un constructor que crea el ArrayList alu de 
    // tipo Alumno y autogenera ocho objetos.
    public ArregloAlumnos() {
        alu = new ArrayList <Alumno>();
        alu.add(new Alumno(100, "Pedro", 15, 16));
        alu.add(new Alumno(200, "Ana", 18, 19));
        alu.add(new Alumno(300, "Iván", 17, 16));
        alu.add(new Alumno(400, "Carlos", 10, 10));
        alu.add(new Alumno(500, "Carmen", 5, 9));
        alu.add(new Alumno(600, "Cesar", 18, 18));
        alu.add(new Alumno(700, "Elizabeth", 18, 14));
        alu.add(new Alumno(800, "Lucia", 15, 16));
    }
    
    // Un método adicionar que recibe la dirección de memoria de un
    // nuevo alumno y lo adiciona al ArrayList.
    
    public void adicionar(Alumno x) {
        alu.add(x);
    }
    
    // Un método tamaño que retorna la cantidad de 
    // alumnos registrados hasta ese momento
    public int tamaño() {
        return alu.size();
    }
    
    // Un método obtener que recibe una posición y 
    // retorna la dirección de memoria del alumno respectivo.
    public Alumno obtener(int i) {
        return alu.get(i);
    }
    
    // Un método buscar que busca un código y retorna la 
    // dirección de memoria del objeto que lo contiene.
    // En caso no existe retorna null
    public Alumno buscar(int codigo) {
        for (int i=0; i<tamaño(); i++)
            if (obtener(i).getCodigo() == codigo)
                   return obtener(i);
        return null;
    }
    
    // Un método eliminar que recibe la dirección de 
    // memoria de un objeto Alumno y lo retira del ArrayList.
    public void eliminar(Alumno x) {
        alu.remove(x);
    }

}

