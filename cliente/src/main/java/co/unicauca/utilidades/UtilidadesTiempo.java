package co.unicauca.utilidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class UtilidadesTiempo {
    public static boolean comprobarFechaUltimoAnio(String fechaEntrante) throws ParseException {
        LocalDate fecha = LocalDate.now();
        boolean bandera = false;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date fechaEntrada = dateFormat.parse(fechaEntrante);
        Date fechaAnioAnterior = dateFormat.parse((fecha.getYear() - 1) + "-" + fecha.getMonthValue() + "-" + fecha
                .getDayOfMonth());

        if (fechaEntrada.after(fechaAnioAnterior)) {
            bandera = true;
        }

        return bandera;
    }

    public static String obtenerFechaActualString() {
        LocalDate fecha = LocalDate.now();

        String cadena = fecha.getYear() + "-" + fecha.getMonthValue() + "-" + fecha
                .getDayOfMonth();

        return cadena;

    }

    public static String dateToString(int dia, int mes, int anio) {
        return (anio + "-" + mes + "-" + dia);
    }
}
