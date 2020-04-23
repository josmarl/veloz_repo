/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;

/**
 * @author josmarl
 */
public class PrintServiceUtil {

    public static void printGeneric(String contentTicket) {
        PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null); //nos da el array de los servicios de impresion
        /**
         * Creamos un arreglo de tipo byte y le agregamos el string convertido
         * (cuerpo del ticket) a bytes tal como lo maneja la impresora(mas bien
         * ticketera :p)
         */

        byte[] bytes = contentTicket.getBytes(); //Especificamos el tipo de dato a imprimir 
        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;//Tipo: bytes; Subtipo: autodetectado 
        Doc doc = new SimpleDoc(bytes, flavor, null); //Creamos un trabajo de impresión
        DocPrintJob job = null;
        if (services.length > 0) {
            for (int i = 0; i < services.length; i++) {
                //aqui escribimos/elegimos la impresora por la que queremos imprimir
                System.out.println(services[i].getName());
                if (services[i].getName().equals("EPSON TM-T20II Receipt")) {
                    job = services[i].createPrintJob();
                    /*System.out.println(i + ": " + services[i].getName());*/
                }
            }
        }
        //Imprimimos dentro de un try obligatoriamente
        try {
            job.print(doc, null);
        } catch (PrintException ex) {
            System.out.println(ex);
        }
    }
}
