/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veloz.runner.helper;

import com.veloz.runner.contants.AppConstants;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jlimachi
 */
public class Utils {

    public static Properties readProperties(File file) {
        Properties properties = new Properties();
        try {
            InputStream input = new FileInputStream(file);
            properties.load(input);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }

        return properties;
    }

    public static void writeSettingsProperties(String file, String mysql, String veloz, String firefox) {
        Properties prop = new Properties();
        OutputStream output = null;
        try {
            output = new FileOutputStream(file);
            prop.setProperty("FILE_MYSQL", mysql);
            prop.setProperty("FILE_VELOZ", veloz);
            prop.setProperty("FILE_FIREFOX", firefox);
            prop.store(output, null);

        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String getCurrentHour() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdfHour = new SimpleDateFormat(AppConstants.HOUR_FORMAT);
        String hour = sdfHour.format(cal.getTime());
        return hour;
    }

    public static void garbageCollector() {
        Runtime r = Runtime.getRuntime();
        r.gc();
    }
}
