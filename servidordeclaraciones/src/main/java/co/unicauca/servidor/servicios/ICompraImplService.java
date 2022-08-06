package co.unicauca.servidor.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.unicauca.servidor.modelos.Compra;
import co.unicauca.servidor.repositorios.dao.ICompraDao;

@Service
public class ICompraImplService implements ICompraService {
    /**
     * Inyección de producto Dao
     */
    @Autowired
    private ICompraDao compraDao;

    /**
     * Servicio para buscar todas las compras
     *
     * @return Listado de compras
     */
    @Override
    @Transactional(readOnly = true) // Para que esté sincronizada con la bd
    public List<Compra> findAll() {
        return (List<Compra>) compraDao.findAll();
    }

    /**
     * Busca una compra por su Id
     *
     * @param id identificador de la compra
     * @return objeto de tipo compra
     */
    @Override // Para que esté sincronizada con la bd
    public Compra findById(Long id) {
        Compra compra = compraDao.findById(id).orElse(null);
        return compra;
    }

    /**
     * Crea una nueva compra
     *
     * @param compra compra a crear en la bd
     * @return compra creada
     */
    @Override
    @Transactional
    public Compra create(Compra compra) {
        return compraDao.save(compra);
    }

    /**
     * Modifica o edita una compra
     *
     * @param id,    identificador del compra a modificar
     * @param compra compra con los datos a editar
     * @return Compra modificada
     */
    @Override
    @Transactional
    public Compra update(Long id, Compra compra) {
        /**
         * Compra compra = this.findById(id);
         * compra.se
         * compra.setName(compra.getName());
         * compra.setPrice(compra.getPrice());
         * 
         * IMPLEMENTACION A FUTURO
         */

        return compraDao.save(compra);
    }

    /**
     * Eliminar compra por su id
     *
     * @param id identificador de la compra a eliminar
     */
    @Override
    @Transactional
    public void deleteById(Long id) {
        compraDao.deleteById(id);
    }
}
