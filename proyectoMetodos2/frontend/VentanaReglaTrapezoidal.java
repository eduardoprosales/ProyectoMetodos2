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
import proyectoMetodos2.backend.ReglaTrapezoidal;

public class VentanaReglaTrapezoidal extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txta;
	private ReglaTrapezoidal rt;//declara objeto de tipo regla trapezoidal
	private JTextField txtb;
	private JTextField iInt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaReglaTrapezoidal dialog = new VentanaReglaTrapezoidal();
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
	public VentanaReglaTrapezoidal() {
		setBounds(100, 100, 422, 448);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel_1 = new JLabel("Ingrese los l\u00EDmites de integraci\u00F3n y la cantidad de intervalos");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(11, 39, 385, 17);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel = new JLabel("Regla Trapezoidal");//nombre de la ventana
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(133, 11, 140, 17);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			contentPanel.add(lblNewLabel);
		}
		
		txta = new JTextField();
		txta.setBounds(62, 67, 46, 20);
		contentPanel.add(txta);
		txta.setColumns(10);
		//etiquetas de entrada
		JLabel lbla = new JLabel("a=");
		lbla.setBounds(13, 73, 46, 14);
		lbla.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPanel.add(lbla);
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(11, 126, 385, 239);
			contentPanel.add(scrollPane);
				final JTextArea textArea = new JTextArea();
				scrollPane.setViewportView(textArea);
				
				JLabel lblb = new JLabel("b=");
				lblb.setHorizontalAlignment(SwingConstants.RIGHT);
				lblb.setBounds(121, 73, 46, 14);
				contentPanel.add(lblb);
				
				txtb = new JTextField();
				txtb.setColumns(10);
				txtb.setBounds(180, 67, 46, 20);
				contentPanel.add(txtb);
				
				JLabel lbInt = new JLabel("Intervalos (n) =");
				lbInt.setHorizontalAlignment(SwingConstants.RIGHT);
				lbInt.setBounds(236, 73, 101, 14);
				contentPanel.add(lbInt);
				
				iInt = new JTextField();
				iInt.setColumns(10);
				iInt.setBounds(341, 67, 46, 20);
				contentPanel.add(iInt);
				
				JLabel lblNewLabel_1 = new JLabel("Este programa calcula la integral definida de f(x) = 1 / \u221A(4+x^3) ");
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_1.setBounds(11, 98, 385, 17);
				contentPanel.add(lblNewLabel_1);
				
				
				//ejecutar
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Ejecutar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						double a, b;
						int n;
						//manda llamar metodo
						//linea que puede dar error
						try {
							
							a= Double.parseDouble(txta.getText()) ;
							b= Double.parseDouble(txtb.getText());
							n= Integer.parseInt(iInt.getText());
						}
						//dentro del parentesis va el error esperado y dentro va la accion a realizar
						catch (NumberFormatException ex) {
			            	JOptionPane.showMessageDialog(null, "Introduce un valor numérico en todos los campos");
			            	return;
			            }
						rt = new ReglaTrapezoidal(a,b,n);
						//
						textArea.setText(rt.getResultado());
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
