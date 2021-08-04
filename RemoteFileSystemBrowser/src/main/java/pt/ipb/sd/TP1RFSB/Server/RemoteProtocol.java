package pt.ipb.sd.TP1RFSB.Server;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.JOptionPane;

import pt.ipb.sd.TP1RFSB.Common.*;

@SuppressWarnings("serial")
public class RemoteProtocol extends UnicastRemoteObject implements Protocol {

	protected RemoteProtocol() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void criarDiretoria(String nome) throws RemoteException {
		File diretoria = new File(nome);

		try {
			if(diretoria.mkdir()) {
				JOptionPane.showMessageDialog(null, "Diretoria criada!");
			}else {
				JOptionPane.showMessageDialog(null, "Erro ao criar diretoria!");
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void criarFicheiro(String nome) throws RemoteException {
		File ficheiro = new File(nome);

		try {
			if (ficheiro.createNewFile()) {
				JOptionPane.showMessageDialog(null, "Ficheiro criado !");
			} else {
				JOptionPane.showMessageDialog(null, "Erro ao criar ficheiro !");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delDiretoria(String nome) throws RemoteException {
		File diretoria = new File(nome);

		File[] ficheiros = diretoria.listFiles();

		if (ficheiros != null) {
			for (File f : ficheiros) {
				if (f.isDirectory()) {
					delDiretoria(f.getAbsolutePath());
				} else {
					f.delete();
					JOptionPane.showMessageDialog(null, "A apagar ficheiros !");
				}
			}
		}
		if(diretoria.delete()) {
			JOptionPane.showMessageDialog(null, "Diretoria apagada !");
		}else{
			JOptionPane.showMessageDialog(null, "Erro ao apagar diretoria !");
		}
	}

	@Override
	public void delFicheiro(String nome) throws RemoteException {
		File ficheiro = new File(nome);

		try {
			if(ficheiro.delete()) {
				JOptionPane.showMessageDialog(null, "Ficheiro Apagado !");
			}else {
				JOptionPane.showMessageDialog(null, "Erro ao apagar ficheiro !");
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		}

	}


	@Override
	public void mudarNome(String nome, String nomeNovo) throws RemoteException {

		File ficheiro = new File(nome);

		File novoNome = new File(nomeNovo);

		try {
			if(ficheiro.renameTo(novoNome)) {
				JOptionPane.showMessageDialog(null, "Nome alterado !");
			}else {
				JOptionPane.showMessageDialog(null, "Erro ao alterar nome ! Não existe nenhum ficheiro com esse nome !");
			};
		} catch (SecurityException e) {
			e.printStackTrace();
		}

	}
	
	@Override
	public File[] lerDiretoria(String nomeDiretoria) throws RemoteException {

		File diretoria = null;

		File[] listaDiretoria = null;

		try {
			diretoria = new File(nomeDiretoria);
			listaDiretoria = diretoria.listFiles();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listaDiretoria;

	}

	@Override
	public <T> T executeTask(Task<T> t) throws RemoteException {
		return t.process();
	}
}
