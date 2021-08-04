package pt.ipb.sd.TP1RFSB.Server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class Server {
	public static void main(String[] args) throws RemoteException{
		
		String name="RFSB";
		Registry registry = LocateRegistry.createRegistry(1099);
		
		RemoteProtocol cp = new RemoteProtocol();
		registry.rebind(name,cp);
	
		System.out.println("Servidor em funcionamento. A aguardar conexao....");
	}
}