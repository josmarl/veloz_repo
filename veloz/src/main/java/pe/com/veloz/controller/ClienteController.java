/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.veloz.controller;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pe.com.veloz.domain.Cliente;
import pe.com.veloz.service.ClienteService;

/**
 *
 * @author josmarl
 */
@RestController
@RequestMapping("/cliente")
public class ClienteController {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private ClienteService clienteService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Cliente> allClientes() {
        return clienteService.findAllClientes();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void saveCliente(@RequestBody Cliente data) {
        clienteService.saveCliente(data);
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
    public void removeCliente(@PathVariable Long id) {
        clienteService.removeCliente(id);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public void editCliente(@RequestBody Cliente data) {
        clienteService.updateCliente(data);
    }

    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
    public Cliente findClienteById(@PathVariable Long id) {
        return clienteService.findClienteById(id);
    }

}
