package proyectoMetodos2.frontend;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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

import proyectoMetodos2.backend.MinimosCuadrados;

public class VentanaMinimosCuadrados extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfx1;
	private MinimosCuadrados mc;//declara objeto de tipo minimos cuadrados
	private ArrayList<Double> xs, ys;//valores que recibe
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
			VentanaMinimosCuadrados dialog = new VentanaMinimosCuadrados();
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
	public VentanaMinimosCuadrados() {
		setBounds(100, 100, 677, 448);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel_1 = new JLabel("Ingrese 4 puntos a aproximar:");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(245, 39, 170, 17);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel = new JLabel("M\u00EDnimos Cuadrados");//nombre de la ventana
			lblNewLabel.setBounds(260, 11, 140, 17);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			contentPanel.add(lblNewLabel);
		}
		
		tfx1 = new JTextField();
		tfx1.setBounds(66, 69, 86, 20);
		contentPanel.add(tfx1);
		tfx1.setColumns(10);
		//etiquetas de entrada
		JLabel lbx1 = new JLabel("x1=");
		lbx1.setBounds(10, 72, 46, 14);
		lbx1.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPanel.add(lbx1);
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 126, 641, 239);
			contentPanel.add(scrollPane);
				final JTextArea textArea = new JTextArea();
				scrollPane.setViewportView(textArea);
				
				JLabel lby1 = new JLabel("y1=");
				lby1.setHorizontalAlignment(SwingConstants.RIGHT);
				lby1.setBounds(10, 98, 46, 14);
				contentPanel.add(lby1);
				
				tfy1 = new JTextField();
				tfy1.setColumns(10);
				tfy1.setBounds(66, 95, 86, 20);
				contentPanel.add(tfy1);
				
				JLabel lbx2 = new JLabel("x2=");
				lbx2.setHorizontalAlignment(SwingConstants.RIGHT);
				lbx2.setBounds(181, 72, 46, 14);
				contentPanel.add(lbx2);
				
				tfx2 = new JTextField();
				tfx2.setColumns(10);
				tfx2.setBounds(237, 69, 86, 20);
				contentPanel.add(tfx2);
				
				JLabel lby2 = new JLabel("y2=");
				lby2.setHorizontalAlignment(SwingConstants.RIGHT);
				lby2.setBounds(181, 98, 46, 14);
				contentPanel.add(lby2);
				
				tfy2 = new JTextField();
				tfy2.setColumns(10);
				tfy2.setBounds(237, 95, 86, 20);
				contentPanel.add(tfy2);
				
				JLabel lbx3 = new JLabel("x3=");
				lbx3.setHorizontalAlignment(SwingConstants.RIGHT);
				lbx3.setBounds(358, 72, 46, 14);
				contentPanel.add(lbx3);
				
				tfx3 = new JTextField();
				tfx3.setColumns(10);
				tfx3.setBounds(414, 69, 86, 20);
				contentPanel.add(tfx3);
				
				JLabel lby3 = new JLabel("y3=");
				lby3.setHorizontalAlignment(SwingConstants.RIGHT);
				lby3.setBounds(358, 98, 46, 14);
				contentPanel.add(lby3);
				
				tfy3 = new JTextField();
				tfy3.setColumns(10);
				tfy3.setBounds(414, 95, 86, 20);
				contentPanel.add(tfy3);
				
				JLabel lbx4 = new JLabel("x4=");
				lbx4.setHorizontalAlignment(SwingConstants.RIGHT);
				lbx4.setBounds(510, 72, 46, 14);
				contentPanel.add(lbx4);
				
				tfx4 = new JTextField();
				tfx4.setColumns(10);
				tfx4.setBounds(566, 69, 86, 20);
				contentPanel.add(tfx4);
				
				JLabel lby4 = new JLabel("y4=");
				lby4.setHorizontalAlignment(SwingConstants.RIGHT);
				lby4.setBounds(510, 98, 46, 14);
				contentPanel.add(lby4);
				
				tfy4 = new JTextField();
				tfy4.setColumns(10);
				tfy4.setBounds(566, 95, 86, 20);
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
						xs=new ArrayList<Double>();
						ys = new ArrayList<Double>();
						//manda llamar metodo
						//linea que puede dar error
						try {
							xs.add(Double.parseDouble(tfx1.getText())) ;
							xs.add(Double.parseDouble(tfx2.getText())) ;
							xs.add(Double.parseDouble(tfx3.getText())) ;
							xs.add(Double.parseDouble(tfx4.getText())) ;
							ys.add(Double.parseDouble(tfy1.getText())) ;
							ys.add(Double.parseDouble(tfy2.getText())) ;
							ys.add(Double.parseDouble(tfy3.getText())) ;
							ys.add(Double.parseDouble(tfy4.getText())) ;
						}
						//dentro del parentesis va el error esperado y dentro va la accion a realizar
						catch (NumberFormatException ex) {
			            	JOptionPane.showMessageDialog(null, "Introduce un valor numérico en todos los campos");
			            	return;
			            }
						mc = new MinimosCuadrados(xs,ys);
						//
						textArea.setText(mc.getResultado());
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
