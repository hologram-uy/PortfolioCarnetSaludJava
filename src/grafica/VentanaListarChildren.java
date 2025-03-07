package grafica;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.ColeccionChildren;

import java.awt.Toolkit;

public class VentanaListarChildren extends JFrame {

	private JPanel contentPane;
	private ColeccionChildren coleccion;

	/**
	 * Create the frame.
	 */
	public VentanaListarChildren(ColeccionChildren col) {

		coleccion = col;
		setTitle("Listar Colecci\u00F3n");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(VentanaListarChildren.class.getResource("/img/vacIcon2.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 515, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
