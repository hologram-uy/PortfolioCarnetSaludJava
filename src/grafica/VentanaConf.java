package grafica;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.ColeccionChildren;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class VentanaConf extends JFrame {

	private JPanel contentPane;
	private JTextField txtTamCol;
	private JTextField txtTamReg;
	private JButton btnAceptar;
	private ColeccionChildren coleccion;

	/**
	 * Create the frame.
	 */
	public VentanaConf(ColeccionChildren col) {

		coleccion = col;
		setResizable(false);
		setTitle("Configuraci\u00F3n");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaConf.class.getResource("/img/settIcon.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 305, 198);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Configuraci\u00F3n de inicio");
		lblNewLabel.setBounds(20, 11, 144, 25);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Tama\u00F1o de la Colecci\u00F3n:");
		lblNewLabel_1.setBounds(20, 58, 157, 25);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_1);

		txtTamCol = new JTextField();
		txtTamCol.setBounds(187, 61, 89, 20);
		contentPane.add(txtTamCol);
		txtTamCol.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Tama\u00F1o para registros:");
		lblNewLabel_1_1.setBounds(20, 84, 157, 25);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_1_1);

		txtTamReg = new JTextField();
		txtTamReg.setBounds(187, 87, 89, 20);
		txtTamReg.setColumns(10);
		contentPane.add(txtTamReg);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(187, 118, 89, 23);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (txtTamCol.getText().isEmpty() || txtTamReg.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "No deje campos vacíos");
				} else {
					try {
						if (coleccion.estaConfigurado()) {
							JOptionPane.showMessageDialog(null, "La colección ya está configurada.");
							cleanFields();
						} else {
							int maxChildren = Integer.parseInt(txtTamCol.getText());
							int maxRegistros = Integer.parseInt(txtTamReg.getText());
							if (maxChildren < 1 || maxRegistros < 1) {
								JOptionPane.showMessageDialog(null,
										"Los valores ingresados deben ser enteros positivos.");
								cleanFields();
							} else {
								coleccion.configurar(maxChildren, maxRegistros);
								

								JOptionPane.showMessageDialog(null, "Colección configurada con éxito.");
								VentanaConf.this.setVisible(false);
							}
						}

					} catch (NumberFormatException numFormat) {

						JOptionPane.showMessageDialog(null, "Escriba sólo enteros en los campos.");
						cleanFields();
						// numFormat.printStackTrace();
					}
				}
			}
		});
		btnAceptar.setFont(new Font("Arial", Font.PLAIN, 11));
		contentPane.add(btnAceptar);
	}
	
	/*
	 *	Otros métodos 
	 * 
	 */

	public void cleanFields() {
		txtTamCol.setText("");
		txtTamReg.setText("");
		txtTamCol.requestFocus();
	}
}
