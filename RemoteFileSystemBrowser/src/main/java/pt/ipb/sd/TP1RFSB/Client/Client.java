package pt.ipb.sd.TP1RFSB.Client;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import pt.ipb.sd.TP1RFSB.Common.*;

@SuppressWarnings("serial")
public class Client implements Serializable {
	private static Protocol cp;

	public static void main(String[] args) throws RemoteException, NotBoundException {
		if(System.getSecurityManager()==null) {
			System.setSecurityManager(new SecurityManager());
		}
		
		String name = "RFSB";
			Registry registry = LocateRegistry.getRegistry(args[0]);
			cp = (Protocol) registry.lookup(name);
			
			
			Client_GUI.main(null);
		
				
	}
	
	public void createFolder(String nameDir) {
		try {
			cp.criarDiretoria(nameDir);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void createFile(String nameFile) {
		try {
			cp.criarFicheiro(nameFile);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void deleteFolder(String nameDir) {
		try {
			cp.delDiretoria(nameDir);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void deleteFile(String nameFile) {
		try {
			cp.delFicheiro(nameFile);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void rename(String nameFile, String newNameFile) {

		try {
			cp.mudarNome(nameFile, newNameFile);

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	public File[] readFolder(String nomeDir) throws RemoteException, NotBoundException {

		try {
			return cp.lerDiretoria(nomeDir);

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
}
