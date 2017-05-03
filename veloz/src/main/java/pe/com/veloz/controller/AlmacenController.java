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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pe.com.veloz.domain.Almacen;
import pe.com.veloz.domain.dto.AlmacenDTO;
import pe.com.veloz.service.AlmacenService;

/**
 *
 * @author josmarl
 */
@RestController
@RequestMapping("/almacen")
public class AlmacenController {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private AlmacenService almacenService;

    @RequestMapping(value = "/all", method = {RequestMethod.GET, RequestMethod.POST})
    public List<Almacen> findAllAlmacen() {
        return almacenService.findAllAlmacen();
    }

    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    public void saveAlmacen(@RequestBody AlmacenDTO data) {
        
    }
}
