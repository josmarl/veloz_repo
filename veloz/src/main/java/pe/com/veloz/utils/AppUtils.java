/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.veloz.utils;

import java.math.BigDecimal;

/**
 *
 * @author josmarl
 */
public class AppUtils {

    public static double redondear(double numero) {
        BigDecimal a = new BigDecimal(numero);
        BigDecimal roundOff = a.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        return roundOff.doubleValue();
    }

}
