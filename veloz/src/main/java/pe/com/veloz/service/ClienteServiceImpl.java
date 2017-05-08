/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.veloz.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.veloz.domain.Cliente;
import pe.com.veloz.mapper.ClienteMapper;

/**
 *
 * @author josmarl
 */
@Service("clienteService")
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    public ClienteMapper clienteMapper;

    @Override
    public List<Cliente> findAllClientes() {
        return clienteMapper.findAllClientes();
    }

    @Override
    public void saveCliente(Cliente cliente) {
        clienteMapper.saveCliente(cliente);
    }

    @Override
    public void removeCliente(Long id) {
        clienteMapper.removeCliente(id);
    }

    @Override
    public void updateCliente(Cliente cliente) {
        clienteMapper.updateCliente(cliente);
    }

    @Override
    public Cliente findClienteById(Long id) {
        return clienteMapper.findClienteById(id);
    }

}
