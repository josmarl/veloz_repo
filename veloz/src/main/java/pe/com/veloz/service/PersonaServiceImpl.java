/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.veloz.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.veloz.domain.Persona;
import pe.com.veloz.mapper.PersonaMapper;

/**
 *
 * @author eddy
 */
@Service("personaService")
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaMapper personaMapper;

    @Override
    public List<Persona> listPersonas() {
        return personaMapper.listPersona();
    }

    @Override
    public void deletePersona(Long id) {
        personaMapper.removePersona(id);
    }

    @Override
    public void updatePersona(Persona persona) {
        personaMapper.updatePersona(persona);
    }

    @Override
    public Persona findPersonaById(Long id) {
        return personaMapper.findPersonaById(id);
    }

    @Override
    public Persona findPersonasByNombres(String nombres) {
        return personaMapper.findPersonaByNombres(nombres);
    }

    @Override
    public Persona findPersonasByApellidos(String apellidos) {
        return personaMapper.findPersonaByApellidos(apellidos);
    }

    @Override
    public Persona findPersonasByDNI(String dni) {
        return personaMapper.findPersonaByDNI(dni);
    }

    @Override
    public Persona findPersonasByCelular(String celular) {
        return personaMapper.findPersonaByCelular(celular);
    }

    @Override
    public Persona findPersonasByDireccion(String direccion) {
        return personaMapper.findPersonaByDireccion(direccion);
    }

    @Override
    public void savePersona(Persona persona) {
        personaMapper.savePersona(persona);
    }

}
