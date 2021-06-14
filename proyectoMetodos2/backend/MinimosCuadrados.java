package proyectoMetodos2.backend;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;

public class MinimosCuadrados {
	
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
	
	private Double promedio(ArrayList<Double> numeros) {
		Double media=0.0;
		for(Double m:numeros) {
			media+=m;
		}
		return media/numeros.size();
	}
	
	public MinimosCuadrados(ArrayList<Double> x, ArrayList<Double> y) {
		Double promedioX= promedio(x);
		//System.out.println("El promedio de X (x~) es: "+redondear(promedioX));
		resultado="El promedio de X (x*) es: "+redondear(promedioX);
		Double promedioY= promedio(y);
		//System.out.println("El promedio de Y (y~) es: "+redondear(promedioY));
		resultado+="\nEl promedio de Y (y*) es: "+redondear(promedioY);
		ArrayList<Double> difY = new ArrayList<Double>(), difX = new ArrayList<Double>(), xDifY = new ArrayList<Double>(), xDifX = new ArrayList<Double>();
		Double sumaXDifY=0.0;
		Double sumaXDifX=0.0;
		//System.out.println("n\tx_i\ty_i\ty_i-(y~)\tx_i-(x~)\t");
		resultado+="\n\nn\tx\ty\ty-y*\tx-x*\tx(y-y*)\tx(x-x*)\n";
		for(int i=0; i<x.size(); i++ ) {
			difY.add(y.get(i)-promedioY);
			//System.out.println("");
			difX.add(x.get(i)-promedioX);
			xDifY.add(x.get(i)*difY.get(i));
			xDifX.add(x.get(i)*difX.get(i));
		}
		for(Double a:xDifY) {
			sumaXDifY+=a;
		}
		for(Double b:xDifX) {
			sumaXDifX+=b;
		}
		for(int i=0; i<x.size(); i++ ) {
			resultado+=(i+1)+"\t"+
		redondear(x.get(i))+"\t"+
					redondear(y.get(i))+"\t"+
		redondear(difY.get(i))+"\t"+
					redondear(difX.get(i))+"\t"+
		redondear(xDifY.get(i))+"\t"+
					redondear(xDifX.get(i))+"\n";
		}
		resultado+="\nLa suma de x(y-y*) es: "+redondear(sumaXDifY);
		resultado+="\nLa suma de x(x-x*) es: "+redondear(sumaXDifX);
		Double m=sumaXDifY/sumaXDifX;
		resultado+="\n\nLa pendiente de la recta es m = "+redondear(sumaXDifY)+" / "+redondear(sumaXDifX)+" = "+redondear(m);
		Double b=promedioY-m*promedioX;
		resultado+="\nEl término independiente es b = y*-mx* = "+redondear(promedioY)+" - ("+redondear(m)+")("+redondear(promedioX)+") = "+redondear(b)+"\n";
		//System.out.println("La ecuación de la recta es: y="+redondear(m)+"x"+redondear(b));
		if(b>=0) {
			resultado+="\nLa ecuación de la recta es: y = "+redondear(m)+"x+"+redondear(b);
		}
		else {
			resultado+="\nLa ecuación de la recta de mejor ajuste es: y = "+redondear(m)+"x"+redondear(b);
		}
		
	}
	
	public static void main(String[] args) {
		ArrayList<Double> xs = new ArrayList<Double>();
		xs.add(10.0);
		xs.add(20.0);
		xs.add(30.0);
		xs.add(40.0);
		xs.add(50.0);
		ArrayList<Double> ys = new ArrayList<Double>();
		ys.add(5.0);
		ys.add(15.0);
		ys.add(29.0);
		ys.add(46.0);
		ys.add(66.0);
		MinimosCuadrados mc = new MinimosCuadrados(xs, ys);
		System.out.print(mc.getResultado());
	}
}
