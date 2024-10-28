/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.veloz.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pe.com.veloz.domain.dto.IpAddressDTO;
import pe.com.veloz.domain.dto.ResponseDTO;
import pe.com.veloz.enums.StatusEnum;
import pe.com.veloz.utils.SocketClient;

/**
 *
 * @author josmarl
 */
@RestController
@RequestMapping("/app")
public class AppController {

    protected final Log logger = LogFactory.getLog(getClass());

    @RequestMapping(value = "/print", method = RequestMethod.POST)
    public ResponseDTO print(@RequestBody IpAddressDTO data) {
        SocketClient client = new SocketClient();
        String responseSocket = client.run(data.getIp(), data.getDatos());
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMsg(responseSocket);
        responseDTO.setStatus(StatusEnum.OK.getStatus());
        return responseDTO;
    }

}
