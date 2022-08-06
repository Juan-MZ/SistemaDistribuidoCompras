package co.unicauca.servidor.repositorios;

import java.util.ArrayList;

import sop_corba.ControladorAlertaIntPackage.AlertaDTO;

public interface AlertaRepositoryInt {

    public boolean registrarAlerta(AlertaDTO objAlerta);

    public ArrayList<AlertaDTO> getListaAlertas();
}
