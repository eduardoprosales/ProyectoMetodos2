package proyectoMetodos2.frontend;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import proyectoMetodos2.backend.Newton;

public class VentanaNewton extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtx0;
	private Newton n;//declara objeto de tipo regla trapezoidal
	private JTextField txty0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaNewton dialog = new VentanaNewton();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaNewton() {
		setBounds(100, 100, 550, 448);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel_1 = new JLabel("Ingrese las coordenadas del vector inicial");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(74, 39, 385, 17);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel = new JLabel("M\u00E9todo de Newton");//nombre de la ventana
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(197, 11, 140, 17);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			contentPanel.add(lblNewLabel);
		}
		
		txtx0 = new JTextField();
		txtx0.setBounds(72, 69, 46, 20);
		contentPanel.add(txtx0);
		txtx0.setColumns(10);
		//etiquetas de entrada
		JLabel lblx0 = new JLabel("x0=");
		lblx0.setBounds(13, 72, 46, 14);
		lblx0.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPanel.add(lblx0);
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(11, 126, 513, 239);
			contentPanel.add(scrollPane);
				final JTextArea textArea = new JTextArea();
				scrollPane.setViewportView(textArea);
				
				JLabel lbly0 = new JLabel("y0=");
				lbly0.setHorizontalAlignment(SwingConstants.RIGHT);
				lbly0.setBounds(13, 101, 46, 14);
				contentPanel.add(lbly0);
				
				txty0 = new JTextField();
				txty0.setColumns(10);
				txty0.setBounds(72, 95, 46, 20);
				contentPanel.add(txty0);
				
				JLabel lblNewLabel_1 = new JLabel("Este programa obtiene la soluci\u00F3n del sistema");
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_1.setBounds(133, 67, 391, 17);
				contentPanel.add(lblNewLabel_1);
				
				JLabel lblNewLabel_1_1 = new JLabel("x^2+xy-10=0");
				lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_1_1.setBounds(133, 84, 391, 17);
				contentPanel.add(lblNewLabel_1_1);
				
				JLabel lblNewLabel_1_1_1 = new JLabel("y+3xy^2-57=0\r\r\n");
				lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_1_1_1.setBounds(133, 100, 391, 17);
				contentPanel.add(lblNewLabel_1_1_1);
				
				
				//ejecutar
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Ejecutar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						double x0, y0;
						//manda llamar metodo
						//linea que puede dar error
						try {
							
							x0= Double.parseDouble(txtx0.getText()) ;
							y0= Double.parseDouble(txty0.getText());
						}
						//dentro del parentesis va el error esperado y dentro va la accion a realizar
						catch (NumberFormatException ex) {
			            	JOptionPane.showMessageDialog(null, "Introduce un valor numérico en todos los campos");
			            	return;
			            }
						n = new Newton(x0,y0);
						//
						textArea.setText(n.getResultado());
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Salir");
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
