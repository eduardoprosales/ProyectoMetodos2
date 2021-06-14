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

public class MenuUnidad3 extends JDialog{
	/*private VentanaDoolitle vDoolitle;
	private VentanaCrout vCrout;*/
	private VentanaReglaTrapezoidal vrt;
	private final JPanel contentPanel = new JPanel();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MenuUnidad3 dialog = new MenuUnidad3();
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
	public MenuUnidad3() {
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Escoge un m\u00E9todo");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel.setBounds(154, 11, 131, 20);
			contentPanel.add(lblNewLabel);
		}
		
		JButton btnNewButton = new JButton("Regla Trapezoidal");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, " REGLA TRAPEZOIDAL\n"
						+ "Este método se basa en aproximar el cálculo del área \n"
						+ "bajo la curva dividiéndola en trapecios verticales, de altura constante \n"
						+ "sobre el eje de las x y cuyas bases están \n"
						+ "definidas por los valores de la función. Para usarlo, se \n"
						+ "necesita definir la función, los límites de integración y la \n"
						+ "cantidad de intervalos en los que se dividirá la sección \n"
						+ "a integrar. A mayor cantidad de intervalos, estos son más \n"
						+ "pequeños y se consigue una mejor aproximación a la superficie real.");
				vrt = new VentanaReglaTrapezoidal();
				vrt.setVisible(true);
			}
		});
		btnNewButton.setBounds(126, 112, 197, 23);
		contentPanel.add(btnNewButton);
		
		
		JTextPane txtpnTodosLosMtodos = new JTextPane();
		txtpnTodosLosMtodos.setBackground(SystemColor.control);
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
