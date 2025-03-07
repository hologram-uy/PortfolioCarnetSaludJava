package grafica;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Font;

@SuppressWarnings("serial")
public class VentanaVersion extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public VentanaVersion() {
		setResizable(false);
		setTitle("Versi\u00F3n");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaVersion.class.getResource("/img/settIcon.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 433, 201);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Obligatorio Java v1.0");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 11));
		lblNewLabel.setBounds(28, 33, 241, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblSistemaDeControl = new JLabel("Sistema de gesti\u00F3n de Carnet de Salud");
		lblSistemaDeControl.setFont(new Font("Arial", Font.PLAIN, 11));
		lblSistemaDeControl.setBounds(28, 51, 243, 14);
		contentPane.add(lblSistemaDeControl);
		
		JLabel lblSoporteVencido = new JLabel("SOPORTE VITALICIO");
		lblSoporteVencido.setFont(new Font("Arial", Font.ITALIC, 11));
		lblSoporteVencido.setBounds(28, 88, 243, 14);
		contentPane.add(lblSoporteVencido);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(VentanaVersion.class.getResource("/img/versionImgVer.png")));
		lblNewLabel_1.setBounds(299, 33, 104, 107);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblParaNiosDe = new JLabel("para ni\u00F1os de hasta 5 a\u00F1os de edad.");
		lblParaNiosDe.setFont(new Font("Arial", Font.PLAIN, 11));
		lblParaNiosDe.setBounds(28, 70, 243, 14);
		contentPane.add(lblParaNiosDe);
		
		JLabel lblautores = new JLabel("Autores:");
		lblautores.setFont(new Font("Arial", Font.PLAIN, 11));
		lblautores.setBounds(28, 109, 241, 14);
		contentPane.add(lblautores);
		
		JLabel lblNewLabel_2_1 = new JLabel("@Andrea Sosa - @Miguel Rivas");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.ITALIC, 11));
		lblNewLabel_2_1.setBounds(28, 126, 241, 14);
		contentPane.add(lblNewLabel_2_1);
	}
}
