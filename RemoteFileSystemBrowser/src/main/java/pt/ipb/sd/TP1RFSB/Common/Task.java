package pt.ipb.sd.TP1RFSB.Common;

import java.rmi.RemoteException;

public interface Task<T> {
	T process() throws RemoteException;
}
