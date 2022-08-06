package co.unicauca.cliente.modelos;

public class Compra {
    /**
    *
    */
    private Long codigoCompra;
    private Long idComprador;
    private String tipoIdentificacion;
    private double valor;
    private String lugarCompra;
    private String fecha;
    private Long idEmpresa;

    public Long getCodigoCompra() {
        return codigoCompra;
    }

    public void setCodigoCompra(Long codigoCompra) {
        this.codigoCompra = codigoCompra;
    }

    public Long getIdComprador() {
        return idComprador;
    }

    public void setIdComprador(Long idComprador) {
        this.idComprador = idComprador;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getLugarCompra() {
        return lugarCompra;
    }

    public void setLugarCompra(String lugarCompra) {
        this.lugarCompra = lugarCompra;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
}
