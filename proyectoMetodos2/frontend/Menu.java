package proyectoMetodos2.frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Menu {

	private JFrame frame;
	private MenuUnidad1 m1;
	private MenuUnidad2 m2;
	private MenuUnidad3 m3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JOptionPane.showMessageDialog(null, "\t\t********** UNAM **********\n\n"
				+ "FACULTAD DE ESTUDIOS SUPERIORES ACATL�N\n\n	"
				+ "MAC\n\n"
				+ "MATERIA: M�todos Num�ricos II\n\n"
				+ "INTEGRANTES\n"
				+ "\tP�rez Rosales Eduardo\n"
				+ "\tV�zquez S�nchez Fernando\n\n"
				+ "FECHA: 15 de Junio  de2021");
		JOptionPane.showMessageDialog(null, "INTRODUCCI�N A LOS M�TODOS NUM�RICOS:\n"
				+ "Los m�todos num�ricos son t�cnicas mediante las cuales es posible\n "
				+ "formular problemas matem�ticos de tal forma que puedan resolverse usando\n"
				+ "operaciones aritm�ticas. Son algoritmos "
				+ "mediante los cuales se obtiene, de\n"
				+ "manera aproximada, la soluci�n de ciertos problemas realizando c�lculos aritm�ticos\n"
				+ "y l�gicos (operaciones aritm�ticas elementales, c�lculo de funciones, tablas de\n"
				+ "valores, c�lculo proposicional, etc.).");
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		m1 = new MenuUnidad1();
		m2 = new MenuUnidad2();
		m3 = new MenuUnidad3();
		
		JLabel lblNewLabel = new JLabel("Escoge una unidad");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(137, 11, 163, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Sistemas de Ecuaciones No Lineales");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Introducci�n a la unidad 1
				JOptionPane.showMessageDialog(null, "SOLUCI�N DE SISTEMAS DE ECUACIONES NO LINEALES\n"
										+ "Un sistema de ecuaciones no lineales es un conjunto de \n"
										+ "dos o mas ecuaciones de grado mayor a 1 o \n"
										+ "que involucren funciones trascendentes, con dos o m�s inc�gnitas relacionadas \n"
										+ "entre s�. La soluci�n de un sistema de ecuaciones no\n"
										+" lineales es un conjunto de valores que satisfacen todas las\n"
										+ " ecuaciones al mismo tiempo. Solucionar el sistema consiste en encontrar\n"
										+ " los componentes del vector soluci�n. Para ello, existen m�todos iterativos\n"
										+ " que, mediante transformaciones, proveen aproximaciones de las soluciones a medida\n"
										+ " de que las iteraciones aumentan.");
				m1.setVisible(true);
			}
		});
		btnNewButton.setBounds(94, 42, 250, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Salir");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnSistemasDeEcuaciones = new JButton("Interpolaci\u00F3n y Aproximaci\u00F3n Polinomial");
		btnSistemasDeEcuaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Introducci�n a la Unidad 2
				JOptionPane.showMessageDialog(null, "INTERPOLACI�N Y APROXIMACI�N POLINOMIAL\n"
										+ "La interpolaci�n polin�mica consiste en encontrar un polinomio que pase \n"
										+ "por una serie de n puntos (xi, yi) representados en el \n"
										+ "plano, donde los valores de xi se encuentran dentro de \n"
										+ "un intervalo definido. A su vez, en algunos casos, es \n"
										+ "conveniente APROXIMAR un polinomio a los puntos dados, de manera \n"
										+ "que se pueda predecir su comportamiento fuera del intervalo. Las \n"
										+ "funciones suelen encontrarse mediante m�todos algebr�icos deducidos geom�tricamente.");
				
				m2.setVisible(true);
			}
		});
		btnSistemasDeEcuaciones.setBounds(77, 100, 285, 23);
		frame.getContentPane().add(btnSistemasDeEcuaciones);
		//*******
		

		JButton btnFactorizacionLU = new JButton("Derivaci\u00F3n e Integraci\u00F3n Num\u00E9rica");
		btnFactorizacionLU .addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "DERIVACI�N E INTEGRACI�N NUM�RICA\n"
						+ "Muchas veces, el c�lculo de derivadas e integrales definidas suele \n"
						+ "ser demasiado complejo mediante m�todos anal�ticos. Para ello, existen m�todos \n"
						+ "que permiten obtener aproximaciones a dichos valores, con un margen \n"
						+ "de error m�nimo. Los m�todos pueden basarse en conceptos anal�ticos \n"
						+ "(como el Polinomio de Taylor para la derivaci�n num�rica) o \n"
						+ "geom�tricos (como el �rea bajo la curva de la funci�n para \n"
						+ "la integral); mediante los cuales se desarrollan f�rmulas que los \n"
						+ "aproximan a los resultados reales, sin necesidad de hacer un \n"
						+ "proceso de derivaci�n o integraci�n.");
				m3.setVisible(true);
			}
		});
		btnFactorizacionLU.setBounds(94, 160, 250, 23);
		frame.getContentPane().add(btnFactorizacionLU );
		
		
	}
}
