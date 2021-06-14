package proyectoMetodos2.backend;

import java.text.DecimalFormat;
import java.text.ParseException;

public class ReglaTrapezoidal {

	static String resultado;
    
	public String getResultado() {
		return resultado; 
	}
	
	public double redondear(double x){
		DecimalFormat formateador = new DecimalFormat("###.####");
		double prdped = x;
		try {
			prdped = formateador.parse(formateador.format(prdped)).doubleValue();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prdped;
	}
	
	public double funcion(double x) {
		return 1/(Math.sqrt(4+Math.pow(x, 3)));
	}
	
	public ReglaTrapezoidal(double a, double b, int n) {
		double h = (b-a)/n;
		double [][] tabla = new double [n+1][4];
		tabla[0][0]=a;
		//Se llena la columna de x
		for(int i=1; i<=n; i++) {
			tabla[i][0]=tabla[i-1][0]+h;
		}
		//Se llena la columna de f(x)
		for(int i=0; i<=n; i++) {
			tabla[i][1]=funcion(tabla[i][0]);
		}
		
		//Se llena la columna de los coeficientes
		tabla[0][2]=0.5;
		tabla[n][2]=0.5;
		for(int i=1; i<=n; i++) {
			if(tabla[i][2]!=0.5) {
				tabla[i][2]=1;
			}
		}
		
		//Se llena la columna de los productos
		double suma=0.0;
		for(int i=0; i<=n; i++) {
			tabla[i][3]=tabla[i][1]*tabla[i][2];
			suma+=tabla[i][3];
		}
		
		//Imprimir tabla
				resultado="\tREGLA DEL TRAPECIO\n\n";
				resultado+="h=(b-a)/n = "+redondear(h);
				resultado+="\n\nx\tf(x)\tc\tcf(x)\n";
				//System.out.println("x\tf(x)\tc\tcf(x)");
				for(int i=0; i<=n; i++) {
					for(int j=0; j<4; j++) {
						resultado+=redondear(tabla[i][j])+"\t";
						//System.out.print(redondear(tabla[i][j])+"\t");
					}
					resultado+="\n";
					//System.out.print("\n");
				}
		
		resultado+="\nLa suma de cf(x) es "+redondear(suma);
		suma*=h;
		resultado+="\n\nAl multiplicar la suma por h, se obtiene que ";
		resultado+="\nla integral definida de "+a+" hasta "+b+" de la función es: "+redondear(suma);
		//System.out.println("\nLa integral definida de "+a+" hasta "+b+" de la función es: "+redondear(suma));
	}
	
	public static void main(String[] args) {
		ReglaTrapezoidal rt= new ReglaTrapezoidal(0,4,25);
		System.out.print(rt.getResultado());

	}

}
