package co.unicauca.servidor.servicios;

import java.util.List;
import co.unicauca.servidor.modelos.Compra;

public interface ICompraService {

    public List<Compra> findAll();

    public Compra findById(Long id);

    public Compra create(Compra product);

    public Compra update(Long id, Compra compra);

    public void deleteById(Long id);
}
