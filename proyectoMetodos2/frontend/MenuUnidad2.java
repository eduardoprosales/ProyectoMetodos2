package proyectoMetodos2.frontend;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class MenuUnidad2 extends JDialog {
	private VentanaDiferenciasDivididas vDD;
	private VentanaNewtonAdelanteAtras  vNAA;
	private VentanaMinimosCuadrados vMinimosCuadrados;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MenuUnidad2 dialog = new MenuUnidad2();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setLocationRelativeTo(null);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MenuUnidad2() {
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Escoge un m\u00E9todo");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel.setBounds(151, 11, 131, 20);
			contentPanel.add(lblNewLabel);
		}
		
		JButton btnNewButton = new JButton("Diferencias divididas");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Introduccion a matriz inversa
				JOptionPane.showMessageDialog(null, "DIFERENCIAS DIVIDIDAS\n"
										+ "Se basa en calcular una tabla de diferencias divididas, las \n"
										+ "cuales son utilizadas para cada dato que se vaya a interpolar.\n"
										+ "Las diferencias divididas f[x0,x1] se calculan mediante (f(x1)-f(x0))/(x1-x0); al calcularlas en \n"
										+ "órdenes superiores (por columnas), podemos obtener los coeficientes de un\n"
										+ " polinomio de n-ésimo grado ajustado a n + 1 datos.");
				vDD = new VentanaDiferenciasDivididas();
				vDD.setVisible(true);
			}
		});
		btnNewButton.setBounds(91, 72, 252, 23);
		contentPanel.add(btnNewButton);
		
		JButton btnNewton = new JButton("Newton hacia adelante y atr\u00E1s");
		btnNewton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "NEWTON HACIA ADELANTE Y HACIA ATRÁS\n"
						+ "A partir de la tabla de diferencias divididas, es posible\n"
						+ " encontrar dos polinomios equivalentes que interpolen la serie de puntos dados.\n"
						+ " Los coeficientes y factores de dichos polinomios estarán dados por\n"
						+ " las interpretaciones progresiva (hacia adelante / abajo) y regresiva (hacia atrás / arriba)\n"
						+ " de la tabla de diferencias divididas. ");
				vNAA = new VentanaNewtonAdelanteAtras();
				vNAA.setVisible(true);
			}
		});
		btnNewton.setBounds(91, 133, 252, 23);
		contentPanel.add(btnNewton);
		
		JButton btnSecante = new JButton("Minimos Cuadrados");
		btnSecante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "MÍNIMOS CUADRADOS\n"
						+ "Este método permite encontrar una recta continua que se aproxime \n"
						+ "a un conjunto de puntos (x,y), utilizando el criterio del \n"
						+ "mínimo error cuadrático: la aproximación óptima es aquella donde la \n"
						+ "suma de los cuadrados de las diferencias en las ordenadas \n"
						+ "entre los puntos y la función es mínima. Para encontrar \n"
						+ "dicha recta y=mx+b, basta con encontrar, mediante fórmulas definidas, los\n"
						+ " valores de m y b a partir de los puntos dados");
				vMinimosCuadrados = new VentanaMinimosCuadrados();
				vMinimosCuadrados.setVisible(true);
			}
		});
		btnSecante.setBounds(91, 194, 252, 23);
		contentPanel.add(btnSecante);
		
		JTextPane txtpnTodosLosMtodos = new JTextPane();
		txtpnTodosLosMtodos.setBackground(SystemColor.control);
		txtpnTodosLosMtodos.setText("Estos m\u00E9todos interpolan una serie de puntos");
		txtpnTodosLosMtodos.setEditable(false);
		txtpnTodosLosMtodos.setBounds(10, 39, 414, 20);
		contentPanel.add(txtpnTodosLosMtodos);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Regresar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
