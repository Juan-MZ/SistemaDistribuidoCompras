package co.unicauca.cliente.controladores;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import co.unicauca.cliente.utilidades.UtilidadesRegistroC;
import co.unicauca.cliente.utilidades.UtilidadesTiempo;
import co.unicauca.servidor.modelos.Compra;
import sop_corba.ControladorAlertaInt;
import sop_corba.ControladorAlertaIntPackage.AlertaDTO;
import sop_corba.ControladorAlertaIntPackage.CompraDTO;

public class ControladorGestorAlertas {

    private List<Compra> comprasTotales;
    private List<Compra> comprasUsuario;
    private double valorTotal;
    private static ControladorAlertaInt objRemoto;

    public ControladorGestorAlertas(List<Compra> comprasTotales) {
        this.comprasTotales = comprasTotales;
        this.comprasUsuario = new ArrayList<>();
    }

    public boolean crearAlerta(Long idUsuario) throws ParseException {
        boolean bandera = false;

        if (comprobarAlertaUsuario(idUsuario)) {
            AlertaDTO alerta = new AlertaDTO();

            alerta.idComprador = idUsuario;
            alerta.valorAcumulado = valorTotal;
            alerta.compras = obtenerComprasUsuario();

            bandera = enviarAlerta(alerta);
        }

        return bandera;
    }

    private boolean enviarAlerta(AlertaDTO alerta) {
        boolean bandera = false;

        String[] vectorDatosLocalizarNS = new String[4];
        vectorDatosLocalizarNS[0] = "-ORBInitialHost";
        vectorDatosLocalizarNS[1] = "127.0.0.1";
        vectorDatosLocalizarNS[2] = "-ORBInitialPort";
        vectorDatosLocalizarNS[3] = "2020";

        objRemoto = UtilidadesRegistroC.obtenerObjRemoto(vectorDatosLocalizarNS, "objAlertas");

        bandera = objRemoto.registrarAlerta(alerta);

        if (bandera) {
            System.out.println("Alerta enviada al servidor de notificaciones.");
        }

        return bandera;
    }

    private CompraDTO[] obtenerComprasUsuario() {

        CompraDTO[] comprasUser = new CompraDTO[comprasUsuario.size()];

        for (int i = 0; i < comprasUser.length; i++) {
            comprasUser[i] = new CompraDTO();
            comprasUser[i].codigoCompra = comprasUsuario.get(i).getCodigoCompra().longValue();
            comprasUser[i].idComprador = comprasUsuario.get(i).getIdComprador().longValue();
            comprasUser[i].tipoIdentificacion = comprasUsuario.get(i).getTipoIdentificacion();
            comprasUser[i].idEmpresa = comprasUsuario.get(i).getIdEmpresa().longValue();
            comprasUser[i].lugarCompra = comprasUsuario.get(i).getLugarCompra();
            comprasUser[i].valor = comprasUsuario.get(i).getValor();
            comprasUser[i].fecha = comprasUsuario.get(i).getFecha();
        }

        return comprasUser;
    }

    private boolean comprobarAlertaUsuario(Long idUsuario) throws ParseException {
        boolean bandera = false;

        this.valorTotal = obtenerSumaComprasUsuarioLastYear(idUsuario);

        if (valorTotal > 45000000) {
            bandera = true;
        }

        return bandera;
    }

    /**
     * retorna el valor total de las compras de un usuario en su ultimo año
     * 
     * @param id de usuario
     */
    private double obtenerSumaComprasUsuarioLastYear(Long idUsuario) throws ParseException {
        List<Compra> compras = getShoppingLastYear();
        double valorTotal = 0;

        for (int i = 0; i < compras.size(); i++) {
            if (idUsuario == compras.get(i).getIdComprador()) {
                comprasUsuario.add(compras.get(i));
                valorTotal = valorTotal + compras.get(i).getValor();
            }
        }

        return valorTotal;
    }

    /**
     * 
     * @return retorna las compras del ultimo año
     * @throws ParseException
     */
    private List<Compra> getShoppingLastYear() throws ParseException {

        List<Compra> comprasLastYear = new ArrayList<>();

        for (int i = 0; i < comprasTotales.size(); i++) {
            if (UtilidadesTiempo.comprobarFechaUltimoAnio(comprasTotales.get(i).getFecha())) {
                comprasLastYear.add(comprasTotales.get(i));
            }
        }

        return comprasLastYear;
    }

}
