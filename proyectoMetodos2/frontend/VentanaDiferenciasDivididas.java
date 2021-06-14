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

import proyectoMetodos2.backend.DiferenciasDivididas;

public class VentanaDiferenciasDivididas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfx1;
	private DiferenciasDivididas dd;//declara objeto de tipo minimos cuadrados
	private JTextField tfy1;
	private JTextField tfx2;
	private JTextField tfy2;
	private JTextField tfx3;
	private JTextField tfy3;
	private JTextField tfx4;
	private JTextField tfy4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaDiferenciasDivididas dialog = new VentanaDiferenciasDivididas();
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
	public VentanaDiferenciasDivididas() {
		setBounds(100, 100, 499, 448);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel_1 = new JLabel("Ingrese 4 puntos a interpolar:");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(156, 39, 170, 17);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel = new JLabel("Diferencias Divididas");//nombre de la ventana
			lblNewLabel.setBounds(171, 11, 140, 17);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			contentPanel.add(lblNewLabel);
		}
		
		tfx1 = new JTextField();
		tfx1.setBounds(66, 69, 46, 20);
		contentPanel.add(tfx1);
		tfx1.setColumns(10);
		//etiquetas de entrada
		JLabel lbx1 = new JLabel("x1=");
		lbx1.setBounds(10, 72, 46, 14);
		lbx1.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPanel.add(lbx1);
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 126, 462, 239);
			contentPanel.add(scrollPane);
				final JTextArea textArea = new JTextArea();
				scrollPane.setViewportView(textArea);
				
				JLabel lby1 = new JLabel("y1=");
				lby1.setHorizontalAlignment(SwingConstants.RIGHT);
				lby1.setBounds(10, 98, 46, 14);
				contentPanel.add(lby1);
				
				tfy1 = new JTextField();
				tfy1.setColumns(10);
				tfy1.setBounds(66, 95, 46, 20);
				contentPanel.add(tfy1);
				
				JLabel lbx2 = new JLabel("x2=");
				lbx2.setHorizontalAlignment(SwingConstants.RIGHT);
				lbx2.setBounds(122, 72, 46, 14);
				contentPanel.add(lbx2);
				
				tfx2 = new JTextField();
				tfx2.setColumns(10);
				tfx2.setBounds(178, 69, 46, 20);
				contentPanel.add(tfx2);
				
				JLabel lby2 = new JLabel("y2=");
				lby2.setHorizontalAlignment(SwingConstants.RIGHT);
				lby2.setBounds(122, 98, 46, 14);
				contentPanel.add(lby2);
				
				tfy2 = new JTextField();
				tfy2.setColumns(10);
				tfy2.setBounds(178, 95, 46, 20);
				contentPanel.add(tfy2);
				
				JLabel lbx3 = new JLabel("x3=");
				lbx3.setHorizontalAlignment(SwingConstants.RIGHT);
				lbx3.setBounds(234, 72, 46, 14);
				contentPanel.add(lbx3);
				
				tfx3 = new JTextField();
				tfx3.setColumns(10);
				tfx3.setBounds(290, 69, 46, 20);
				contentPanel.add(tfx3);
				
				JLabel lby3 = new JLabel("y3=");
				lby3.setHorizontalAlignment(SwingConstants.RIGHT);
				lby3.setBounds(234, 98, 46, 14);
				contentPanel.add(lby3);
				
				tfy3 = new JTextField();
				tfy3.setColumns(10);
				tfy3.setBounds(290, 95, 46, 20);
				contentPanel.add(tfy3);
				
				JLabel lbx4 = new JLabel("x4=");
				lbx4.setHorizontalAlignment(SwingConstants.RIGHT);
				lbx4.setBounds(346, 72, 46, 14);
				contentPanel.add(lbx4);
				
				tfx4 = new JTextField();
				tfx4.setColumns(10);
				tfx4.setBounds(402, 69, 46, 20);
				contentPanel.add(tfx4);
				
				JLabel lby4 = new JLabel("y4=");
				lby4.setHorizontalAlignment(SwingConstants.RIGHT);
				lby4.setBounds(346, 98, 46, 14);
				contentPanel.add(lby4);
				
				tfy4 = new JTextField();
				tfy4.setColumns(10);
				tfy4.setBounds(402, 95, 46, 20);
				contentPanel.add(tfy4);
				
				
				//ejecutar
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Ejecutar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						double [] x = new double [4];
						double [] y = new double [4];
						//manda llamar metodo
						//linea que puede dar error
						try {
							x[0]= Double.parseDouble(tfx1.getText()) ;
							x[1]= Double.parseDouble(tfx2.getText()) ;
							x[2]= Double.parseDouble(tfx3.getText()) ;
							x[3]= Double.parseDouble(tfx4.getText()) ;
							y[0]= Double.parseDouble(tfy1.getText()) ;
							y[1]= Double.parseDouble(tfy2.getText()) ;
							y[2]= Double.parseDouble(tfy3.getText()) ;
							y[3]= Double.parseDouble(tfy4.getText()) ;
						}
						//dentro del parentesis va el error esperado y dentro va la accion a realizar
						catch (NumberFormatException ex) {
			            	JOptionPane.showMessageDialog(null, "Introduce un valor numérico en todos los campos");
			            	return;
			            }
						dd = new DiferenciasDivididas(x,y);
						//
						textArea.setText(dd.getResultado());
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
