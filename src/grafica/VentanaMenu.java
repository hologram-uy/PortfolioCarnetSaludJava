package grafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.ColeccionChildren;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Font;

@SuppressWarnings("serial")
public class VentanaMenu extends JFrame {

	private JPanel contentPane;
	private ColeccionChildren coleccion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMenu frame = new VentanaMenu();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaMenu() {
		setTitle("Gesti\u00F3n Carnet de Salud");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaMenu.class.getResource("/img/vacIcon2.png")));
		/*
		 * Agregado para la colección
		 */
		coleccion = new ColeccionChildren();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 356, 340);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("Archivo");
		menuBar.add(mnFile);

		JMenuItem mntmAddChild = new JMenuItem("Agregar Ni\u00F1o");
		mntmAddChild.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (coleccion.estaConfigurado()) {
					if (coleccion.hayLugar()) {
						VentanaAgregarChild vac = new VentanaAgregarChild(coleccion);
						vac.setLocationRelativeTo(null);
						vac.setVisible(true);
					} else {
						mntmAddChild.setEnabled(false);
						JOptionPane.showMessageDialog(null, "No hay más lugar en la colección.");
					}
				} else {
					JOptionPane.showMessageDialog(null,
							"Primero debe configurar el tamaño de la colección en [Preferencias -> Configuración]");
				}
			}
		});
		mnFile.add(mntmAddChild);

		JMenuItem mntmListChildren = new JMenuItem("Listar colecci\u00F3n");
		mntmListChildren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (coleccion.estaConfigurado()) {
					VentanaListarChildren vlc = new VentanaListarChildren(coleccion);
					vlc.setLocationRelativeTo(null);
					vlc.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null,
							"Primero debe configurar el tamaño de la colección en [Preferencias -> Configuración]");
				}

			}
		});
		mnFile.add(mntmListChildren);

		JMenu mnNewMenu = new JMenu("Registros");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Vacunas");
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Controles");
		mnNewMenu.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Consultas");
		mnNewMenu.add(mntmNewMenuItem_2);

		JMenu mnPreferences = new JMenu("Preferencias");
		menuBar.add(mnPreferences);

		JMenuItem mntmConf = new JMenuItem("Configuraci\u00F3n");
		mntmConf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!coleccion.estaConfigurado()) {
					VentanaConf vc = new VentanaConf(coleccion);
					vc.setLocationRelativeTo(null);
					vc.setVisible(true);
				} else {
					mntmConf.setEnabled(false);
				}

			}
		});
		mnPreferences.add(mntmConf);

		JMenu mnHelp = new JMenu("Ayuda");
		menuBar.add(mnHelp);

		JMenuItem mntmVersion = new JMenuItem("Versi\u00F3n");
		mntmVersion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				VentanaVersion vv = new VentanaVersion();
				vv.setLocationRelativeTo(null);
				vv.setVisible(true);
			}
		});
		mnHelp.add(mntmVersion);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VentanaMenu.class.getResource("/img/logoObliga.png")));
		lblNewLabel.setBounds(10, 11, 323, 218);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u00A1Bienvenidos!");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1.setBounds(116, 240, 110, 29);
		contentPane.add(lblNewLabel_1);
	}
}
