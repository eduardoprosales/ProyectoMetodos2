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
				+ "FACULTAD DE ESTUDIOS SUPERIORES ACATLÁN\n\n	"
				+ "MAC\n\n"
				+ "MATERIA: Métodos Numéricos II\n\n"
				+ "INTEGRANTES\n"
				+ "\tPérez Rosales Eduardo\n"
				+ "\tVázquez Sánchez Fernando\n\n"
				+ "FECHA: 15 de Junio  de2021");
		JOptionPane.showMessageDialog(null, "INTRODUCCIÓN A LOS MÉTODOS NUMÉRICOS:\n"
				+ "Los métodos numéricos son técnicas mediante las cuales es posible\n "
				+ "formular problemas matemáticos de tal forma que puedan resolverse usando\n"
				+ "operaciones aritméticas. Son algoritmos "
				+ "mediante los cuales se obtiene, de\n"
				+ "manera aproximada, la solución de ciertos problemas realizando cálculos aritméticos\n"
				+ "y lógicos (operaciones aritméticas elementales, cálculo de funciones, tablas de\n"
				+ "valores, cálculo proposicional, etc.).");
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
				//Introducción a la unidad 1
				JOptionPane.showMessageDialog(null, "SOLUCIÓN DE SISTEMAS DE ECUACIONES NO LINEALES\n"
										+ "Un sistema de ecuaciones no lineales es un conjunto de \n"
										+ "dos o mas ecuaciones de grado mayor a 1 o \n"
										+ "que involucren funciones trascendentes, con dos o más incógnitas relacionadas \n"
										+ "entre sí. La solución de un sistema de ecuaciones no\n"
										+" lineales es un conjunto de valores que satisfacen todas las\n"
										+ " ecuaciones al mismo tiempo. Solucionar el sistema consiste en encontrar\n"
										+ " los componentes del vector solución. Para ello, existen métodos iterativos\n"
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
				//Introducción a la Unidad 2
				JOptionPane.showMessageDialog(null, "INTERPOLACIÓN Y APROXIMACIÓN POLINOMIAL\n"
										+ "La interpolación polinómica consiste en encontrar un polinomio que pase \n"
										+ "por una serie de n puntos (xi, yi) representados en el \n"
										+ "plano, donde los valores de xi se encuentran dentro de \n"
										+ "un intervalo definido. A su vez, en algunos casos, es \n"
										+ "conveniente APROXIMAR un polinomio a los puntos dados, de manera \n"
										+ "que se pueda predecir su comportamiento fuera del intervalo. Las \n"
										+ "funciones suelen encontrarse mediante métodos algebráicos deducidos geométricamente.");
				
				m2.setVisible(true);
			}
		});
		btnSistemasDeEcuaciones.setBounds(77, 100, 285, 23);
		frame.getContentPane().add(btnSistemasDeEcuaciones);
		//*******
		

		JButton btnFactorizacionLU = new JButton("Derivaci\u00F3n e Integraci\u00F3n Num\u00E9rica");
		btnFactorizacionLU .addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "DERIVACIÓN E INTEGRACIÓN NUMÉRICA\n"
						+ "Muchas veces, el cálculo de derivadas e integrales definidas suele \n"
						+ "ser demasiado complejo mediante métodos analíticos. Para ello, existen métodos \n"
						+ "que permiten obtener aproximaciones a dichos valores, con un margen \n"
						+ "de error mínimo. Los métodos pueden basarse en conceptos analíticos \n"
						+ "(como el Polinomio de Taylor para la derivación numérica) o \n"
						+ "geométricos (como el área bajo la curva de la función para \n"
						+ "la integral); mediante los cuales se desarrollan fórmulas que los \n"
						+ "aproximan a los resultados reales, sin necesidad de hacer un \n"
						+ "proceso de derivación o integración.");
				m3.setVisible(true);
			}
		});
		btnFactorizacionLU.setBounds(94, 160, 250, 23);
		frame.getContentPane().add(btnFactorizacionLU );
		
		
	}
}
