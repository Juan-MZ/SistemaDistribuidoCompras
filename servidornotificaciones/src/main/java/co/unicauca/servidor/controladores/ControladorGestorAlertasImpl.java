package co.unicauca.servidor.controladores;

import java.rmi.RemoteException;

import co.unicauca.servidor.gestores.gestorAlertas;
import co.unicauca.servidor.repositorios.AlertaRepositoryInt;
import sop_corba.ControladorAlertaIntPOA;
import sop_corba.ControladorAlertaIntPackage.AlertaDTO;

public class ControladorGestorAlertasImpl extends ControladorAlertaIntPOA {

    private final AlertaRepositoryInt objAlertasRepository;

    public ControladorGestorAlertasImpl(AlertaRepositoryInt objAlertasRepository) throws RemoteException {
        this.objAlertasRepository = objAlertasRepository;
    }

    @Override
    public boolean registrarAlerta(AlertaDTO objAlerta) {
        boolean bandera = false;

        objAlerta.codigoAlerta = objAlertasRepository.getListaAlertas().size() + 1;

        if (this.objAlertasRepository.registrarAlerta(objAlerta)) {
            gestorAlertas.imprimirAlerta(objAlerta);
            bandera = true;
        }
        return bandera;
    }
}
