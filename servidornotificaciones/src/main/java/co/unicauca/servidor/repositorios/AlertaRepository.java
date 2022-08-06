package co.unicauca.servidor.repositorios;

import java.util.ArrayList;

import sop_corba.ControladorAlertaIntPackage.AlertaDTO;

public class AlertaRepository implements AlertaRepositoryInt {

    private final ArrayList<AlertaDTO> listaAlertas;

    public AlertaRepository() {
        this.listaAlertas = new ArrayList<>();
    }

    @Override
    public boolean registrarAlerta(AlertaDTO objAlerta) {
        boolean bandera = false;

        bandera = listaAlertas.add(objAlerta);

        return bandera;
    }

    @Override
    public ArrayList<AlertaDTO> getListaAlertas() {
        return listaAlertas;
    }

}
