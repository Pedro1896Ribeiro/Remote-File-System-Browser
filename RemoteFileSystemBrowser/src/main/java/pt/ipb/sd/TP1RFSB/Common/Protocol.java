package pt.ipb.sd.TP1RFSB.Common;

import java.io.File;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Protocol extends Remote {
	
	<T> T executeTask(Task<T> t) throws RemoteException;

	public void criarDiretoria(String nome) throws RemoteException;

	public void delDiretoria(String nome) throws RemoteException;

	public void criarFicheiro(String nome) throws RemoteException;

	public void delFicheiro(String nome) throws RemoteException;

	public void mudarNome(String nome, String novoNome) throws RemoteException;
	
	public File[] lerDiretoria(String nome) throws RemoteException;

}
