import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.*;
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//archivos
class Eof implements Serializable{
}



//fechas
class Fecha{
    int dia; 
    int mes;
    int anio;
    public void Fecha(){
        
    
    }
    public void Fecha(int d, int m, int a){
    dia = d;
    mes = m;
    anio = a;
    }
     public void setDia(int d){
     dia = d;
  }
  public int getDia(){
  return dia;
  }
   public void setMes(int m){
     mes = m;
  }
  public int getMes(){
  return mes;
  }
  
  public void setAnio(int a){
     anio = a;
  }
  public int getAnio(){
  return anio;
  }

}
//clase estdudiante
class Estudiante{
    //atributos
    String nombre;
    String apellido;
    int documento;
    double [] notas;
    double prom = 0;
    int materias = 0;
    boolean situacion;
    double aux;
    int edad;
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    
    //construtores
    public void Estudiante(){
      
  }
  public void Estudiante(String nombre, String apellido, int documento, int materias,int []notas, double prom, boolean situacion){
      this.nombre = nombre;
      this.apellido = apellido;
      this.documento = documento;
      this.materias = materias;
      this.notas[materias] = notas[materias];
      this.prom = prom;
      this.situacion = situacion;
  }
  ////////////////////////////////////////////////////////////////////////////////////////////////////////
  
  //metodos
  public void setNombre(String n){
     nombre = n;
  }
  public String getNombre(){
  return nombre;
  }
  public void setApellido(String a){
     apellido = a;
  }
  public String getApellido(){
  return apellido;
  }
  public void setDocumento(int d){
     documento = d;
  }
  public int getDocumento(){
  return documento;
  }
  public void SetMaterias(int m){
     materias = m;
  }
  public int getMaterias(){
  return materias;
  }
  public void Prom(){
     prom = 0;
     for (int i = 0; i < materias ; i++ ){
        prom = prom + notas[i];  
     } 
     prom = prom/materias;
}
  public double getProm(){
  return prom;
  }
  public void Situacion(){
     if(prom <= 3.4){
     situacion = true;
     
  }
  else{
    situacion = false;
  }
      
  }
   
  public boolean getSituacion(){
  return situacion;
  }
  public void arreglo(){
  Prom();
  }
  public void verificar(){
   Situacion();
  }
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////

//clase main
public class Main
{
    
	public static void main(String[] args) {
		menu();
    } 
////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//crear menu
	public static void menu(){
	    //objetos
	    Scanner leer = new Scanner (System. in);
	    Estudiante [] EST;
	    
	    Estudiante AUXEST = new Estudiante();
		int opcion = 0;
		int cont = 0;
		EST = new Estudiante[0];
		Fecha actual = new Fecha();
		
		System.out.println("escriba el dia actual");
		actual.setDia(leer.nextInt());
		System.out.println("escriba el mes actual");
		actual.setMes(leer.nextInt());
		System.out.println("escriba el Anio actual");
		actual.setAnio(leer.nextInt());
		
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		do{
		System.out.println("escoja una opcion: ");
		System.out.println();
		System.out.println("1) agregar usuario");
		System.out.println("2) quitar un usuario");
		System.out.println("3) mirar datos de Estudiantes");
		System.out.println("4) adicionar notas a un Estudiante");
		System.out.println("5) eliminar notas de un Estudiante");
		System.out.println("6) obtener edad de los Estudiantes");
		System.out.println("7) ordenar a los Estudiantes");
		System.out.println("8) lista de Estudiantes");
		System.out.println("9) archivo de Estudiantes");
		System.out.println("0) salir");
		opcion = leer.nextInt();
		// escoger casos por consola
		switch(opcion){
		    
		case 1:
		
		boolean err; 
		err = false;
		
		EST = redimendionar(EST);
		EST[cont] = info();
		cont ++;
		
		break;
		case 2:
		    EST = redimendionar_menos(EST);
		    cont = cont - 1 ; 
		    break;
		
		case 3:
		    mostrar(EST, cont);
		    break;
	    case 4:
		agregarnota(EST); 
		break;
		case 5:
		eliminarnota(EST);
		break;
		case 6:
		    calcedad(EST,actual);
		    break;
		case 7:
		     EST = ordenar(EST);
		    System.out.println("ordenado");
		    break;
		    case 8:
		    lista(EST);
		    break;
		    
		  	case 9:
		    crear_archico(EST);
		    break;
		    case 0:
		    System.out.println("salio del progrma");
		    break;
		    default:
		    System.out.println("escogio una opcion enxistente");
		    break;
		    } }while(opcion != 0);
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
//metodos
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	//agregar datos de nuevo Estudiantes
	
	public static Estudiante info(){
	    Estudiante AUXEST = new Estudiante();
	    Scanner leer = new Scanner (System. in);
	    System.out.println("ingrese el nombre del Estudiante");
		
		
		AUXEST.setNombre(leer.nextLine());
		System.out.println("ingrese el apellido del estdudiante");
		AUXEST.setApellido(leer.nextLine());
		System.out.println("ingrese el numero del documento del Estudiante");
		AUXEST.setDocumento(leer.nextInt());
		System.out.println("ingrese el numero de notas");
		AUXEST.SetMaterias(leer.nextInt());
		AUXEST.notas = new double[AUXEST.materias];
		
		AUXEST.notas = crearnotas(AUXEST.materias);
		System.out.println(AUXEST.notas[0]);
		AUXEST.arreglo();
		AUXEST.verificar();
		return AUXEST;
		
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//crear notas
	
	public static double []crearnotas(int materias){
	        double []auxnotas = new double [materias];
	        Scanner leer = new Scanner (System. in);
	    	for(int i = 0; i < materias; i++){
	    	  System.out.println("ingrese nota "+(i+1));
		      auxnotas[i] = (leer.nextDouble());
	    	 } 
	    return auxnotas;
	}
	
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// adicionar estdudiante
	
	public static Estudiante[] redimendionar(Estudiante[] EST){
	  Estudiante []nuevoEST;
	  nuevoEST = new Estudiante[EST.length + 1];
	  System.arraycopy(EST, 0 , nuevoEST, 0, EST.length);
	  return nuevoEST;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//mostrar estudiantes
	public static void mostrar(Estudiante[] EST, int cont){
	    if(cont > 0){
	    for(int i = 0; i < cont; i++){
	        System.out.println("el nombre del estudiante "+(i+1)+" es "+ EST[i].nombre);
	        System.out.println("el apellido del estudiante "+(i+1)+" es "+ EST[i].apellido);
	        System.out.println("el documento de Estudiante es "+EST[i].documento);
	        for(int j = 0; j < EST[i].materias; j++){
	          System.out.println(" la nota " + (j+1)+" es "+ EST[i].notas[j]);
	        }
	         System.out.println("el promedio es  "+EST[i].prom);
	         System.out.println("se encuentra en prueba acadmica: "+ EST[i].situacion);
	         System.out.println("tiene " + EST[i].edad + " años");
	         
	    }
	    
	}
	else{
	    System.out.println("no ha ingrseado ningun estudiante");
	    
	}
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////

// eliminar un estudiante
public static Estudiante[] redimendionar_menos(Estudiante[] EST){
    if(EST.length > 1){
      Estudiante []nuevoEST;
      int doc;
	  nuevoEST = new Estudiante[EST.length - 1];
	  System.out.println("ingrese el documento del que desea eliminar");
	  Scanner leer = new Scanner (System. in);
	  doc = leer.nextInt();
	  for(int i = 0; i< (EST.length-1); i++){
	      if(doc != EST[i].documento ){
	          nuevoEST[i] = EST[i];
	          }
	  }
	  //System.arraycopy(EST, 0 , nuevoEST, 0, EST.length);
	  return nuevoEST;
	  
    }
    else{
    System.out.println("su arreglo es demasiado pequeño");
    return EST;
    }
    
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////

//agregar notas
public static Estudiante[] agregarnota(Estudiante[] EST){
    Scanner leer = new Scanner (System. in);
    int doc;
    int aux;
    System.out.println("ingrese el documento del estdudiante");
    doc = leer.nextInt();
    for(int i = 0; i < EST.length; i++){
    aux = EST[i].documento ;   
    if( doc == aux){
    EST[i].notas = agr(EST[i]);
    EST[i].materias = EST[i].materias +  1 ;
    EST[i].arreglo();
    EST[i].verificar();
    return EST;
    }
    else{
    System.out.print("bunscando......");    
    }
    }
    System.out.println(" ");
    System.out.println("no ha ingresado un documento existente");
    return EST;
}

public static double[] agr(Estudiante EST){
    Scanner leer = new Scanner (System. in);
    double aux[] = new double[EST.materias + 1];
    System.arraycopy(EST.notas, 0 , aux , 0, EST.materias);
    System.out.println("ingrese la nueva nueva nota");
    aux[EST.materias] = leer.nextInt();
    return aux;
}
////////////////////////////////////////////////////////////////////////////////////////////////////

// eliminar nota

public static Estudiante[] eliminarnota(Estudiante[] EST){
    Scanner leer = new Scanner (System. in);
    int doc;
    int aux;
    System.out.println("ingrese el documento del estdudiante");
    doc = leer.nextInt();
    
    for(int i = 0; i < EST.length; i++){
    aux = EST[i].documento ;   
    if( doc == aux){
    if(EST[i].materias > 0){
    EST[i].notas = el(EST[i]);
    EST[i].materias = EST[i].materias - 1 ;
    EST[i].arreglo();
    EST[i].verificar();
    return EST;
        
    }
    else{
     System.out.println("no tiene notas por eliminar");
     return EST;
    }
    }
    else{
        System.out.print("cargando..........");
    }
    
    }
    System.out.println();
    System.out.println("no se encontro ese documento");
    return EST;


}
public static double[] el(Estudiante EST){
    Scanner leer = new Scanner (System. in);
    int eliminar;
    System.out.println("escoja la nota que desea eliminar");
    eliminar = leer.nextInt();
    eliminar = eliminar - 1 ;
    int cont = 0;
    double aux[] = new double[EST.materias - 1];
    if(eliminar < EST.materias && eliminar >= 0){
    for(int i = 0; i < (EST.materias); i++){
	      if(eliminar != i ){
	          aux[cont] = EST.notas[i];
	          cont++;
	          }
	  }
      return aux;
      }
    else{
       System.out.println("ha escogido una nota que no tiene el Estudiante");
       System.out.println();
       return EST.notas;
    }
}
////////////////////////////////////////////////////////////////////////////////////////////////////////

// calcular edad

public static Estudiante[] calcedad(Estudiante EST[], Fecha actual){
    Scanner leer = new Scanner (System. in);
    Fecha aux = new Fecha();
    for(int i = 0; i < EST.length; i++){
    System.out.println("escriba el dia nacimiento de " + EST[i].nombre + EST[i]. apellido);
		aux.setDia (leer.nextInt());
		System.out.println("escriba el mes nacimiento de "+ EST[i].nombre + EST[i]. apellido);
		aux.setMes(leer.nextInt());
		System.out.println("escriba el Año de nacimiento de " + EST[i].nombre + EST[i]. apellido);
		aux.setAnio(leer.nextInt());
		EST[i].edad=edade(actual,aux);
    }
    return EST;   
    }


public static int edade(Fecha actual, Fecha na){
   int edad;
   edad = actual.anio - na.anio;
   if(na.mes < actual.anio ){
       edad = edad - 1;
   }
   else if(na.mes == actual.mes){
      if(na.dia < actual.dia){
          edad = edad - 1;
      } 
   }
   else {
       edad = edad;
   }
   return edad;
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////

// ordenar

public static Estudiante[] ordenar(Estudiante EST[]){
    Estudiante aux = new Estudiante();
    String aux1;
    String aux2;
    
    for(int i = 0; i < EST.length; i++ ){
        for(int j = 0; j < (EST.length-1); j++){
            aux1 = EST[j].apellido;
            aux2 = EST[j+1].apellido;
            if( aux1.compareTo(aux2) > 0){
            aux = EST[j];
            EST[j] = EST[j+1];
            EST[j+1] = aux;
            }
            
            else if(aux1.equals(aux2)){
                aux1 = EST[j].nombre;
                aux2 = EST[j+1].nombre;
               if(aux1.compareTo(aux2)  > 0){
                aux = EST[j];
                EST[j] = EST[j+1];
                EST[j+1] = aux; 
               } 
            }
            else{
             EST[i] = EST[i];    
            }
            
            
        }
    }
    return EST;
}


/////////////////////////////////////////////////////////////////////////////////////////////////////////


//archivos
public static void crear_archico(Estudiante EST[]){
try {
      FileWriter fw = new FileWriter ("clase.txt", true);
      BufferedWriter bf = new BufferedWriter (fw);
      PrintWriter salida = new PrintWriter (bf);
      for(int i = 0; i < EST.length;i++){
      salida.print (EST[i].nombre + "; " + EST[i].apellido);
      salida.print ("; " + EST[i].documento + "; " + EST[i].prom);
      salida.print ("; " + EST[i].documento + "; " + EST[i].prom);
      salida.print ("; " + EST[i].materias + "; " + EST[i].situacion);
      salida.println ("; " + EST[i].edad + "; "+ EST[i].materias);
      
      for(int j=0; j < EST[i].materias; j++){
      salida.print ("; " + EST[i].notas[j]);
      }
      salida.println();
      salida.println();

      
    }
    salida.close();
    
}
    catch (Exception e){
      e.printStackTrace();
    }
}

public static void lista(Estudiante EST[]){
    EST = ordenar(EST);
    try {
      FileWriter fw = new FileWriter ("listaclase.txt", true);
      BufferedWriter bf = new BufferedWriter (fw);
      PrintWriter salida = new PrintWriter (bf);
      for(int i = 0; i < EST.length ; i++){
      salida.print (EST[i].nombre + " " + EST[i].apellido);
      salida.println (" " + EST[i].documento);
      salida.println();
      salida.println();

    
}
      salida.close();





}
catch (Exception e){
      e.printStackTrace();
    }
    
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    
}


///////////////////////////////////////////////////////////////////////////////////////////////////////////








