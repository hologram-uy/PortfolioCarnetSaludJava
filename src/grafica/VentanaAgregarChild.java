package grafica;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import logica.Child;
import logica.ColeccionChildren;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class VentanaAgregarChild extends JFrame {

	private JPanel contentPane;
	private ColeccionChildren coleccion;
	private JTextField txtNom;
	private JTextField txtDoc;
	private JTextField txtServMed;
	private JDateChooser dateChooser;
	private JCheckBox chkFonasa;
	private Child child;
	private JTextField txtMedCab;
	private JTextField txtConsultarci;
	private JButton btnAgregar_1;

	/**
	 * Create the frame.
	 */
	public VentanaAgregarChild(ColeccionChildren col) {
		coleccion = col;
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaAgregarChild.class.getResource("/img/vacIcon2.png")));
		setTitle("Alta de ni\u00F1os");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 375, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel.setBounds(25, 41, 140, 15);
		contentPane.add(lblNewLabel);

		JLabel lblDocuemnto = new JLabel("Documento:");
		lblDocuemnto.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDocuemnto.setBounds(25, 67, 140, 15);
		contentPane.add(lblDocuemnto);

		JLabel lblNacimiento = new JLabel("Nacimiento:");
		lblNacimiento.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNacimiento.setBounds(25, 103, 140, 15);
		contentPane.add(lblNacimiento);

		JLabel lblServicioMdico = new JLabel("Servicio M\u00E9dico:");
		lblServicioMdico.setFont(new Font("Arial", Font.PLAIN, 12));
		lblServicioMdico.setBounds(23, 135, 130, 15);
		contentPane.add(lblServicioMdico);

		JLabel lblFonasa = new JLabel("Fonasa:");
		lblFonasa.setFont(new Font("Arial", Font.PLAIN, 12));
		lblFonasa.setBounds(25, 200, 140, 15);
		contentPane.add(lblFonasa);

		chkFonasa = new JCheckBox("  (click)");
		chkFonasa.setToolTipText("Click en la caja para indicar si tiene Fonasa.");
		chkFonasa.setBounds(154, 197, 103, 23);
		contentPane.add(chkFonasa);

		txtNom = new JTextField();
		txtNom.setToolTipText("Nombre y apellido separado por un espacio.");
		txtNom.setFont(new Font("Arial", Font.PLAIN, 11));
		txtNom.setBounds(154, 39, 182, 20);
		contentPane.add(txtNom);
		txtNom.setColumns(10);

		txtDoc = new JTextField();
		txtDoc.setToolTipText("Escriba el documento sin puntos ni guiones.");
		txtDoc.setFont(new Font("Arial", Font.PLAIN, 11));
		txtDoc.setColumns(10);
		txtDoc.setBounds(154, 67, 182, 20);
		contentPane.add(txtDoc);

		txtServMed = new JTextField();
		txtServMed.setFont(new Font("Arial", Font.PLAIN, 11));
		txtServMed.setColumns(10);
		txtServMed.setBounds(154, 129, 182, 20);
		contentPane.add(txtServMed);

		dateChooser = new JDateChooser();
		dateChooser.setToolTipText("Escriba fecha en formato dd/MM/YY");
		dateChooser.setBounds(154, 98, 182, 20);
		contentPane.add(dateChooser);
		dateChooser.setDate(Calendar.getInstance().getTime());

		JButton btnAgregar = new JButton("Limpiar");
		btnAgregar.setFont(new Font("Arial", Font.PLAIN, 11));
		btnAgregar.setToolTipText("Borra todos los campos de la ventana.");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cleanUp();
			}
		});
		btnAgregar.setBounds(154, 248, 86, 23);
		contentPane.add(btnAgregar);

		btnAgregar_1 = new JButton("Agregar");
		btnAgregar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!isEmpty()) {
					if (!coleccion.hayLugar()) {
						JOptionPane.showMessageDialog(null, "No hay más lugar en la colección.");
						disableState();
						
					} else {
						try {
							String nom = txtNom.getText();
							int doc = Integer.parseInt(txtDoc.getText());
							Calendar fchNac = dateChooser.getCalendar();
							String servMed = txtServMed.getText();
							String medCab = txtMedCab.getText();
							boolean chkFon;
							if (chkFonasa.isSelected()) {
								chkFon = true;
							} else {
								chkFon = false;
							}

							child = new Child(nom, doc, fchNac, servMed, medCab, chkFon);
							coleccion.altaChild(child);
							
							JOptionPane.showMessageDialog(null, "Ni\u00f1o ingresado con éxito!");
							cleanUp();
							verifyState();
							//System.out.println(coleccion.listarChildren());

						} catch (NumberFormatException NumForEx) {
							JOptionPane.showMessageDialog(null, "Uno de los campos contiene caracteres no válidos.");
						}
					}

				} else {
					JOptionPane.showMessageDialog(null, "No deje campos vacíos por favor.");
				}
			}
		});
		btnAgregar_1.setFont(new Font("Arial", Font.PLAIN, 11));
		btnAgregar_1.setBounds(250, 248, 86, 23);
		contentPane.add(btnAgregar_1);

		JLabel lblMdicoCabecera = new JLabel("M\u00E9dico Cabecera:");
		lblMdicoCabecera.setFont(new Font("Arial", Font.PLAIN, 12));
		lblMdicoCabecera.setBounds(23, 164, 130, 15);
		contentPane.add(lblMdicoCabecera);
		txtMedCab = new JTextField();
		txtMedCab.setFont(new Font("Arial", Font.PLAIN, 11));
		txtMedCab.setColumns(10);
		txtMedCab.setBounds(154, 161, 182, 20);
		contentPane.add(txtMedCab);
		
		JButton btnNewButton = new JButton("Listar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int cii = Integer.parseInt(txtConsultarci.getText().trim());
				coleccion.getDatosChild(cii);
				child.getFechaNacimiento();
			}
		});
		btnNewButton.setBounds(25, 248, 89, 23);
		contentPane.add(btnNewButton);
		
		txtConsultarci = new JTextField();
		txtConsultarci.setToolTipText("Nombre y apellido separado por un espacio.");
		txtConsultarci.setFont(new Font("Arial", Font.PLAIN, 11));
		txtConsultarci.setColumns(10);
		txtConsultarci.setBounds(23, 286, 182, 20);
		contentPane.add(txtConsultarci);
	}

	/*
	 * Otros métodos
	 * 
	 */
	public void cleanUp() {

		txtNom.requestFocus();
		txtNom.setText("");
		txtDoc.setText("");
		txtServMed.setText("");
		txtMedCab.setText("");
		dateChooser.getCalendar();
		chkFonasa.setSelected(false);
	}

	public boolean isEmpty() {

		boolean emptyFields = false;

		if (txtNom.getText().trim().isEmpty() || txtDoc.getText().trim().isEmpty()
				|| txtServMed.getText().trim().isEmpty() || txtMedCab.getText().trim().isEmpty()
				|| dateChooser.getDate() == null) {
			emptyFields = true;
		}

		return emptyFields;
	}
	
	public void disableState() {
		txtNom.setEnabled(false);
		txtDoc.setEnabled(false);
		dateChooser.setEnabled(false);
		chkFonasa.setEnabled(false);
		txtMedCab.setEnabled(false);
		txtServMed.setEnabled(false);
		btnAgregar_1.setEnabled(false);
		
	}
	
	public void enableState() {
		txtNom.setEnabled(true);
		txtDoc.setEnabled(true);
		dateChooser.setEnabled(true);
		chkFonasa.setEnabled(true);
		txtMedCab.setEnabled(true);
		txtServMed.setEnabled(true);
		btnAgregar_1.setEnabled(true);
	}
	
	public void verifyState() {
		if(!coleccion.hayLugar()) {
			disableState();
			JOptionPane.showMessageDialog(null, "No hay más lugar en la colección.");
		} else {
			enableState();
		}
	}
}
