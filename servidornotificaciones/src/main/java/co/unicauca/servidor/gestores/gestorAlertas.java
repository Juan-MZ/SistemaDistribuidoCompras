package co.unicauca.servidor.gestores;

import sop_corba.ControladorAlertaIntPackage.AlertaDTO;
import sop_corba.ControladorAlertaIntPackage.CompraDTO;

public class gestorAlertas {
    public static void imprimirAlerta(AlertaDTO alerta) {
        System.out.println("---------------------------------------------------");
        System.out.println("NUEVA ALERTA");
        System.out.println("---------------------------------------------------");
        System.out.println("Codigo de Alerta: " + alerta.codigoAlerta);
        System.out.println("Identificacion del comprador: " + alerta.idComprador);
        imprimirCompra(alerta.compras);
        System.out.println("Valor Acumulado: " + alerta.valorAcumulado);
    }

    private static void imprimirCompra(CompraDTO[] compras) {
        for (int i = 0; i < compras.length; i++) {
            System.out.println("---------------------------------------------------");
            System.out.println("Compra numero " + (i + 1) + ":");
            System.out.println("Codigo compra: " + compras[i].codigoCompra);
            System.out.println("Tipo de identificacion: " + compras[i].tipoIdentificacion);
            System.out.println("Codigo de empresa: " + compras[i].idEmpresa);
            System.out.println("Lugar de Compra: " + compras[i].lugarCompra);
            System.out.println("Fecha de compra: " + compras[i].fecha.toString());
            System.out.println("Valor de compra: " + compras[i].valor);
        }
        System.out.println("---------------------------------------------------");
    }
}
