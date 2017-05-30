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
import pe.com.veloz.domain.Persona;
import pe.com.veloz.service.PersonaService;

/**
 *
 * @author eddy
 */
@RestController
@RequestMapping("/persona")
public class PersonaController {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired

    private PersonaService personaService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Persona> allPersonas() {
        return personaService.listPersonas();
    }

    @RequestMapping(value = "/edit", method = {RequestMethod.GET, RequestMethod.POST})
    public void editPersona(@RequestBody Persona persona) {
        personaService.updatePersona(persona);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deletePersona(@PathVariable Long id) {
        personaService.deletePersona(id);
    }

    @RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST})
    public void savePersona(@RequestBody Persona persona) {
        personaService.savePersona(persona);
    }

}
