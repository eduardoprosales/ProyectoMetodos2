package proyectoMetodos2.backend;

import java.text.DecimalFormat;
import java.text.ParseException;

public class Newton {
	static String resultado;
    
	public String getResultado() {
		return resultado; 
	}
	
	public double redondear(double x){
		DecimalFormat formateador = new DecimalFormat("###.###");
		double prdped = x;
		try {
			prdped = formateador.parse(formateador.format(prdped)).doubleValue();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prdped;
	}
	
	public double[][] multiplicar(double[][] a, double[][] b) {
	    double[][] c = new double[a.length][b[0].length];
	    // se comprueba si las matrices se pueden multiplicar
	    if (a[0].length == b.length) {
	        for (int i = 0; i < a.length; i++) {
	            for (int j = 0; j < b[0].length; j++) {
	                for (int k = 0; k < a[0].length; k++) {
	                    // aquí se multiplica la matriz
	                    c[i][j] += a[i][k] * b[k][j];
	                }
	            }
	        }
	    }
	    /**
	     * si no se cumple la condición se retorna una matriz vacía
	     */
	    return c;
	}
	
	public double[][] funcion(double x, double y) {
		double[][] f = new double[2][1];
		f[0][0] = Math.pow(x, 2)+x*y-10;
		f[1][0] = y+3*x*Math.pow(y, 2)-57;
		return f;
	}
	
	public double[][] jacobianoInverso(double x, double y) {
		double [][] jInv = new double[2][2];
		double determinante = 2*x+12*Math.pow(x, 2)*y+y+3*x*Math.pow(y, 2);
		jInv[0][0] = (1+6*x*y)/determinante;
		jInv[0][1] = (-x)/determinante;
		jInv[1][0] = (-3*Math.pow(y,2))/determinante;
		jInv[1][1] = (2*x+y)/determinante;
		return jInv;
	}
	
	public Newton(double x0, double y0) {
		double[][] Xn = new double[2][1];
		Xn[0][0]=x0;
		Xn[1][0]=y0;
		double[][] f = funcion(x0, y0);
		double[][] j = jacobianoInverso(x0,y0);
		double[][] producto = multiplicar(j,f);	
		Xn[0][0]-=producto[0][0];
		Xn[1][0]-=producto[1][0];
		int n=0;
		//Imprimir primera fila
		resultado = "n\tXn\t          J-1(X)\t\tf(X)\tXn+1\n";
		for(int i=0; i<2; i++) {
			if(i==0) {
				resultado+=n+"\t";
				resultado+=redondear(x0)+"\t"+redondear(j[i][0])+"\t"+redondear(j[i][1])+"\t"+redondear(f[i][0])+"\t"+redondear(Xn[i][0])+"\n";
			}
			else {
				resultado+="\t";
				resultado+=redondear(y0)+"\t"+redondear(j[i][0])+"\t"+redondear(j[i][1])+"\t"+redondear(f[i][0])+"\t"+redondear(Xn[i][0])+"\n\n";
			}
		}
		while ((Math.abs(f[0][0]) >0.0001 || Math.abs(f[0][0])>0.0001) && n<=20) {
			n++;
			x0=Xn[0][0];
			y0=Xn[1][0];
			f = funcion(Xn[0][0], Xn[1][0]);
			j = jacobianoInverso(Xn[0][0], Xn[1][0]);
			producto = multiplicar(j,f);
			Xn[0][0]-=producto[0][0];
			Xn[1][0]-=producto[1][0];
			for(int i=0; i<2; i++) {
				if(i==0) {
					resultado+=n+"\t";
					resultado+=redondear(x0)+"\t"+redondear(j[i][0])+"\t"+redondear(j[i][1])+"\t"+redondear(f[i][0])+"\t"+redondear(Xn[i][0])+"\n";
				}
				else {
					resultado+="\t";
					resultado+=redondear(y0)+"\t"+redondear(j[i][0])+"\t"+redondear(j[i][1])+"\t"+redondear(f[i][0])+"\t"+redondear(Xn[i][0])+"\n\n";
				}
			}
		}
		if (n<=20) {
			resultado+="Por lo tanto, el vector solución del sistema es: ("+redondear(Xn[0][0])+" , "+redondear(Xn[1][0])+")\n";
		}
		else {
			resultado+="La aproximación obtenida al vector solución es: ("+redondear(Xn[0][0])+" , "+redondear(Xn[1][0])+")\n";
		}
	}
	
	/*public static void main(String[] args) {
		double x=10.0;
		double y=10.0;
		Newton n = new Newton(x,y);
		System.out.print(n.getResultado());
		
	}*/
}
