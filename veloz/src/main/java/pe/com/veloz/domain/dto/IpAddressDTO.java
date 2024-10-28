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
    private String datos;

    public IpAddressDTO() {
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }

    @Override
    public String toString() {
        return "IpAddressDTO{" +
                "ip='" + ip + '\'' +
                ", datos='" + datos + '\'' +
                '}';
    }
}
