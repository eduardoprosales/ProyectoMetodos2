package proyectoMetodos2.frontend;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.SystemColor;

public class MenuUnidad1 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private VentanaNewton vNewton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			
			MenuUnidad1 dialog = new MenuUnidad1();
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
	public MenuUnidad1() {
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
		
		JButton btnNewton = new JButton("Newton");
		btnNewton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Introduccion a Newton
				JOptionPane.showMessageDialog(null, "MÉTODO DE NEWTON\n"
						+ "El método de Newton-Raphson, permite hallar las raíces de un\n"
						+ " sistema de ecuaciones no lineales, siempre y cuando se parta\n"
						+ " de un vector inicial cercano al vector solución. Este método \n"
						+ "es la interpretación del método de Newton-Raphson para resolver ecuaciones\n"
						+ " no-lineales, derivado del desarrollo de Taylor de una función\n"
						+ " alrededor de un valor estimado, aplicado a matrices de sistemas \n"
						+ "de ecuaciones no lineales. ");
				vNewton = new VentanaNewton();
				vNewton.setVisible(true);
			}
		});
		btnNewton.setBounds(159, 102, 115, 23);
		contentPanel.add(btnNewton);
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
