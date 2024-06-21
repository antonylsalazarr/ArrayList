package clase;

public class Alumno {
	
	//Atributos
	
	private int codigo, nota1, nota2;
	private String nombre;
	
	
	//Constructor
	public Alumno(int codigo, String nombre, int nota1, int nota2){		
		this.codigo = codigo;
		this.nombre = nombre;
		this.nota1 = nota1;
		this.nota2 = nota2;
	}
	
	
	//Método Promedio
	public double promedio() {
		return (nota1 + nota2)/2.0;
	}
	
	
	public String estado() {
		if (promedio() >= 13)
			return "Aprobado";
		else
			return "Desaprobado";
	}
	
	
	 public int notaMayor() {
	        if (nota1 > nota2)
	            return nota1;
	        else
	            return nota2;
	    }
	    
	    public int notaMenor() {
	        if (nota1 < nota2)
	            return nota1;
	        else
	            return nota2;
	                    
	    }
	    
	    // Metodos de Acceso public set - get

	    public int getCodigo() {
	        return codigo;
	    }

	    public void setCodigo(int codigo) {
	        this.codigo = codigo;
	    }

	    public int getNota1() {
	        return nota1;
	    }

	    public void setNota1(int nota1) {
	        this.nota1 = nota1;
	    }

	    public int getNota2() {
	        return nota2;
	    }

	    public void setNota2(int nota2) {
	        this.nota2 = nota2;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

}
