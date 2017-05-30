/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.veloz.domain.dto;

/**
 *
 * @author josmarl
 */
public class IpAddressDTO {

    private String ip;

    public IpAddressDTO() {
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "IpDTO{" + "ip=" + ip + '}';
    }

}
