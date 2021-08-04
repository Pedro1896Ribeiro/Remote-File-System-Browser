package pt.ipb.sd.TP1RFSB.Client;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;

public class Client_GUI {
	
	private JPanel contentPane;
	private Client cp=new Client();

	String name;
	String newname;
	public static String path;

	private JFrame frame;
	protected Frame browser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client_GUI window = new Client_GUI();
					window.frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Client_GUI() {
		contentPane = new JPanel();

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(700, 300, 450, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnNovoFicheiro = new JButton("Novo Ficheiro");
		btnNovoFicheiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name = JOptionPane.showInputDialog("Nome do ficheiro:\n Formato: ficheiro.txt");
				cp.createFile(name);

			}
		});
		btnNovoFicheiro.setBounds(50, 110, 145, 23);
		frame.getContentPane().add(btnNovoFicheiro);

		JButton btnRenomearFicheiro = new JButton("Renomear Ficheiro");
		btnRenomearFicheiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name = JOptionPane.showInputDialog("Nome do ficheiro:\n Formato: ficheiro.txt");
				newname = JOptionPane.showInputDialog("Novo nome do ficheiro:\n Formato: ficheiro.txt");
				
					cp.rename(name, newname);
				
			}
		});
		btnRenomearFicheiro.setBounds(50, 155, 145, 23);
		frame.getContentPane().add(btnRenomearFicheiro);

		JButton btnApagarFicheiro = new JButton("Apagar Ficheiro");
		btnApagarFicheiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name = JOptionPane.showInputDialog("Nome do ficheiro:\n Formato: ficheiro.txt");
				
					cp.deleteFile(name);
				
			}
		});
		btnApagarFicheiro.setBounds(50, 200, 145, 23);
		frame.getContentPane().add(btnApagarFicheiro);

		JButton btnNovaPasta = new JButton("Nova Pasta");
		btnNovaPasta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name = JOptionPane.showInputDialog("Nome da pasta:\n");
				
					cp.createFolder(name);
				
			}
		});
		btnNovaPasta.setBounds(240, 110, 145, 23);
		frame.getContentPane().add(btnNovaPasta);

		JButton btnRenomearPasta = new JButton("Renomear Pasta");
		btnRenomearPasta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				name = JOptionPane.showInputDialog("Nome da pasta:\n");
				newname = JOptionPane.showInputDialog("Novo nome da pasta:\n");
				
					cp.rename(name, newname);
				
			}
		});
		btnRenomearPasta.setBounds(240, 155, 145, 23);
		frame.getContentPane().add(btnRenomearPasta);

		JButton btnApagarPasta = new JButton("Apagar Pasta");
		btnApagarPasta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name = JOptionPane.showInputDialog("Nome da pasta:");
				
					cp.deleteFolder(name);
				
			}
		});
		btnApagarPasta.setBounds(240, 200, 145, 23);
		frame.getContentPane().add(btnApagarPasta);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setBounds(145, 250, 313, 111);
		contentPane.add(textArea_3);
		
		JButton btnLerPasta = new JButton("Ler Pasta");
		btnLerPasta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name = JOptionPane.showInputDialog("Nome da pasta:");
				browser = JOptionPane.getFrameForComponent(frame);
				
				File[] p = null;
				try {
					p = cp.readFolder(name);
				} catch (RemoteException | NotBoundException e1) {
					e1.printStackTrace();
				}

				for (File path : p) {
					textArea_3.append(path + "\n");
				}
				
				
			}
		});
		btnLerPasta.setBounds(50, 250, 335, 23);
		frame.getContentPane().add(btnLerPasta);

		JLabel lblFileManager = new JLabel("Remote File System Browser");
		lblFileManager.setFont(new Font("Arial", Font.PLAIN, 20));
		lblFileManager.setBounds(90, 40, 270, 20);
		frame.getContentPane().add(lblFileManager);
	}
}
