package proyectoMetodos2.backend;

import java.text.DecimalFormat;
import java.text.ParseException;

public class DiferenciasDivididas {

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
	
	/*public static void main(String[] args) {
		double [] X = {1,3,5,6};
		double [] F = {2.0/3.0,1,-1,0};
		DiferenciasDivididas dd = new DiferenciasDivididas(X,F);
		System.out.print(dd.getResultado());
	}*/
	
	public DiferenciasDivididas (double[] X, double[] F){
        int n = X.length;
        double [][] A = new double[n][n];
        for (int j=0;j<n;j++){
            A[j][0]=F[j];
        }
        int p;
        for (int k=0; k<n-1;k++){
        	p=0;
       		for(int i=k+1;i<n;i++){
            		A[i][k+1]=(A[i][k]-A[i-1][k])/(X[i]-X[p]);
        		p++;
       		}
        }
        //imprimir tabla
        resultado="\tTABLA DE DIFERENCIAS DIVIDIDAS\nx\tf(x)\tDiferencias Divididas\n";
        //System.out.println("x\tf(x)\tDiferencias Divididas");
        for(int j=0; j<n; j++) {
        	resultado+=redondear(X[j])+"\t";
        	//System.out.print(redondear(X[j])+"\t");
        	for(int k=0; k<=j; k++) {
        		resultado+=redondear(A[j][k])+"\t";
        		//System.out.print(redondear(A[j][k])+"\t");
        	}
        	resultado+="\n";
        	//System.out.print("\n");
        }
        //Imprimir polinomio
        resultado+="\nEl polinomio que interpola los puntos es:\n\nP(x) = ";
        //System.out.print("\nEl polinomio que interpola los puntos es:\n\nP(x) = ");
        for(int i=0; i<n; i++) {
        	resultado+=redondear(A[i][i])+" ";
        	//System.out.print(redondear(A[i][i]));
        	for(int j=0; j<i; j++) {
        		resultado+="(x-"+X[j]+")";
        		//System.out.print("(x-"+X[j]+")");
        	}
        	if(i!=n-1 && A[i+1][i+1]>=0) {
        		resultado+=" + ";
        		//System.out.print("+");
        	}
        	else {
        		resultado+=" ";
        	}
        }
        
	}

}
