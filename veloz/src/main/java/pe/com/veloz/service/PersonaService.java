/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.veloz.service;

import java.util.List;
import pe.com.veloz.domain.Persona;

/**
 *
 * @author eddy
 */
public interface PersonaService {
    
     List<Persona> listPersonas();

    void deletePersona(Long id);

    void updatePersona(Persona persona);

    Persona findPersonaById(Long id);
    
    Persona findPersonasByNombres(String nombres);
    
    Persona findPersonasByApellidos(String apellidos);
    
    Persona findPersonasByDNI(String dni);
    
    Persona findPersonasByCelular(String celular);
    
    Persona findPersonasByDireccion(String direccion);

    void savePersona(Persona persona);
    
}
