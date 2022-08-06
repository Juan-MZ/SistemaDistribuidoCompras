package co.unicauca.servidor.controladores;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import co.unicauca.cliente.controladores.ControladorGestorAlertas;
import co.unicauca.servidor.modelos.Compra;
import co.unicauca.servidor.servicios.ICompraService;

/**
 * Servicios web de compras
 *
 * @author JuanMZ
 *
 */
@RestController
@RequestMapping("compras")
public class CompraController {
    @Autowired
    private ICompraService compraService;

    /**
     * Listar todos
     *
     * @return listado de compras en json
     */
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Compra> findAll() {
        return (List<Compra>) compraService.findAll();
    }

    /**
     * Listar una compra por id
     *
     * @param id identificador
     * @return compra en formato json
     * @throws Exception
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Compra findById(@PathVariable Long id) {
        Compra compra = compraService.findById(id);
        return compra;
    }

    /**
     * Crear un compra
     *
     * @param compra compra
     * @return compra creado
     * @throws ParseException
     */
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Compra create(@RequestBody Compra compra) throws ParseException {

        compra.setCodigoCompra(Long.valueOf(findAll().size() + 1));

        Compra compraAux = compraService.create(compra);

        ControladorGestorAlertas alerta = new ControladorGestorAlertas(compraService.findAll());

        alerta.crearAlerta(compra.getIdComprador());

        return compraAux;
    }

    /**
     * Editar
     *
     * @param compra a editar
     * @param id     identificador de la compra
     * @return compra editado
     * @throws ResourceNotFoundException recurso no encontrado
     * @throws Exception                 Id no encontrado
     */
    @RequestMapping(value = "{id}", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public Compra update(@RequestBody Compra compra, @PathVariable Long id) {
        return compraService.update(id, compra);
    }

    /**
     * Eliminar
     *
     * @param id id de la compra
     * @throws ResourceNotFoundException id no encontrado
     */
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        compraService.deleteById(id);
    }

    /**
     * @return ICompraService return the compraService
     */
    public ICompraService getCompraService() {
        return compraService;
    }

    /**
     * @param compraService the compraService to set
     */
    public void setCompraService(ICompraService compraService) {
        this.compraService = compraService;
    }

}
