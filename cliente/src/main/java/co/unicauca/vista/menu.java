package co.unicauca.vista;

import java.io.IOException;

import co.unicauca.cliente.controladores.CompraControlle;
import co.unicauca.cliente.modelos.Compra;
import co.unicauca.utilidades.UtilidadesConsola;
import co.unicauca.utilidades.UtilidadesTiempo;

public class menu {
    public static void iniciarMenu() throws IOException {
        int opcion = -1;
        while (opcion != 2) {
            imprimirMenu();
            opcion = UtilidadesConsola.leerEntero();
            switch (opcion) {
                case 1:
                    registrarCompra();
                    break;

                default:
                    System.out.println("opcion ingresada incorrecta, porfavor vuelva intentar.");
                    break;
            }
        }
    }

    private static void imprimirMenu() {
        System.out.println("----------------------------------");
        System.out.println("Menu Compras");
        System.out.println("----------------------------------");
        System.out.println("1. Registrar Compra");
        System.out.println("2. Salir");
        System.out.println("----------------------------------");
        System.out.println("Porfavor ingrese su opcion: ");
    }

    /*
     * private Long codigoCompra;
     * private Long idComprador;
     * private String tipoIdentificacion;
     * private double valor;
     * private String lugarCompra;
     * private String fecha;
     * private Long idEmpresa;
     */

    private static void registrarCompra() throws IOException {

        Compra compra = new Compra();
        CompraControlle controlador = new CompraControlle();

        System.out.println("----------------------------------");
        System.out.println("A continuacion registre su compra: ");
        System.out.println("----------------------------------");
        System.out.println("Ingrese el id de la compra: ");
        compra.setCodigoCompra(UtilidadesConsola.leerLong());
        System.out.println("Ingrese el id del comprador: ");
        compra.setIdComprador(UtilidadesConsola.leerLong());
        System.out.println("Ingrese el tipo de documento del comprador: ");
        compra.setTipoIdentificacion(UtilidadesConsola.leerCadena());
        System.out.println("Ingrese el valor de la compra: ");
        compra.setValor(UtilidadesConsola.leerDouble());
        System.out.println("Ingrese el lugar de la compra: ");
        compra.setLugarCompra(UtilidadesConsola.leerCadena());
        System.out.println("Ingrese el id de la empresa: ");
        compra.setIdEmpresa(UtilidadesConsola.leerLong());

        compra.setFecha(UtilidadesTiempo.obtenerFechaActualString());
        System.out.println("----------------------------------");
        if (controlador.enviarCompra(compra)) {
            System.out.println("Compra registrada correctamente.");
        } else {
            System.out.println("No se pudo registrar la compra, VERIFIQUE!!.");
        }
    }
}
