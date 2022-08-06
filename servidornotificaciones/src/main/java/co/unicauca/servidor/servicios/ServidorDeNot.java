package co.unicauca.servidor.servicios;

import co.unicauca.servidor.controladores.ControladorGestorAlertasImpl;
import co.unicauca.servidor.repositorios.AlertaRepository;
import co.unicauca.servidor.utilidades.UtilidadesConsola;
import co.unicauca.servidor.utilidades.UtilidadesRegistroS;

/**
 * Hello world!
 */
public final class ServidorDeNot {

    private ServidorDeNot() {
    }

    /**
     * Says hello to the world.
     *
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        try {
            String[] vectorDatosLocalizarNS = new String[4];// almacena la información para localizar el ns
            vectorDatosLocalizarNS[0] = "-ORBInitialHost";
            vectorDatosLocalizarNS[1] = "127.0.0.1";
            vectorDatosLocalizarNS[2] = "-ORBInitialPort";
            vectorDatosLocalizarNS[3] = "2020";

            System.out.println("El n_s se encuentra en escucha con ip y puerto " + vectorDatosLocalizarNS[1] + ":"
                    + vectorDatosLocalizarNS[3]);

            AlertaRepository objRepository = new AlertaRepository();
            ControladorGestorAlertasImpl objRemotoGestionAlertas = new ControladorGestorAlertasImpl(
                    objRepository);

            UtilidadesRegistroS.registrarObjetoRemoto(vectorDatosLocalizarNS, objRemotoGestionAlertas,
                    "objAlertas");
        } catch (Exception e) {
            System.out.println("Error: " + e);
            e.printStackTrace(System.out);
        }
    }
}
