package until;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Teclado {


	public static double readDouble (String pregunta) {
		
		BufferedReader teclado= new BufferedReader (new InputStreamReader(System.in));
		double respuesta=0.0;
		
		System.out.print(pregunta);
		try {
			respuesta=Double.parseDouble(teclado.readLine());
		} catch (Exception e) {
	System.err.println("Error introduciendo el numero");
		}
		
		return respuesta;
			
	}
	
public static String readString (String pregunta) {
		
		BufferedReader teclado= new BufferedReader (new InputStreamReader(System.in));
		String respuesta="";
		
		System.out.print(pregunta);
		try {
			respuesta=teclado.readLine();
		} catch (Exception e) {
	System.err.println("Error introduciendo el numero");
		}
		
		return respuesta;
				
	}
	
public static int readInt (String pregunta) {
		
		BufferedReader teclado= new BufferedReader (new InputStreamReader(System.in));
		int respuesta=0;
		
		System.out.print(pregunta);
		try {
			respuesta=Integer.parseInt(teclado.readLine());
		} catch (Exception e) {
	System.err.println("Error introduciendo el numero");
		}
		
		return respuesta;
			
	}

public static float readFloat (String pregunta) {
	
	BufferedReader teclado= new BufferedReader (new InputStreamReader(System.in));
	float respuesta=0f;
	
	System.out.print(pregunta);
	try {
		respuesta=Float.parseFloat(teclado.readLine());
	} catch (Exception e) {
System.err.println("Error introduciendo el numero");
	}
	
	
	return respuesta;
	
}

public static Long readLong (String pregunta) {
	
	BufferedReader teclado= new BufferedReader (new InputStreamReader(System.in));
	long respuesta=0;
	
	System.out.print(pregunta);
	try {
		respuesta=Long.parseLong(teclado.readLine());
	} catch (Exception e) {
System.err.println("Error introduciendo el numero");
	}
	
	return respuesta;
}

public static double obtener_descuento(double unidades) {
	//CONSTANTES
	
	//VARIABLES
	
	double descuento;
	
	//INICIO

		if (unidades>=100) {
			descuento=40;
		} else if (unidades>=25){
			descuento=20;
		}else if(unidades>=10){
			descuento=10;
		} else {
			descuento=0;
		}
		
	return descuento;
}

public static double obtener_precio_sin_descuento(double unidades, double precio) {
	
	
	//CONSTANTES
	
	//VARIABLES
	double resultado=0.0;
	
	//INICIO
	
	resultado=precio*unidades;
	
	
	return resultado;
}

public static double obtener_precio_total(double precio_sin_descuento, double descuento) {
	//CONSTANTES
	
	//VARIABLES
	double resultado=0.0;
	//INICIO
	resultado = precio_sin_descuento-((precio_sin_descuento*descuento)/100);
	
	return resultado;
}

public static void sacar_par_impar(int num1) {
	
	if (num1 % 2 == 0) {
		System.out.println("Su numero es par");
	} else {
		System.out.println("Su numero es impar");
	}
	
}



}