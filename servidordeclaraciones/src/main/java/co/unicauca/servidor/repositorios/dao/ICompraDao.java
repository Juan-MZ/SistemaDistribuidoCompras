package co.unicauca.servidor.repositorios.dao;

import org.springframework.data.repository.CrudRepository;
import co.unicauca.servidor.modelos.Compra;

/**
 * Interfaces DAO de compras
 * 
 * @author JuanMZ, Hauries
 *
 */

public interface ICompraDao extends CrudRepository<Compra, Long> {

}
