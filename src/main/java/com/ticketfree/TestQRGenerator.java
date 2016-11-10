package com.ticketfree;

//import com.google.zxing.BarcodeFormat;
//import com.google.zxing.EncodeHintType;
//import com.google.zxing.WriterException;
//import com.google.zxing.common.BitMatrix;
//import com.google.zxing.qrcode.QRCodeWriter;
//import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.EnumMap;
import java.util.Map;

public class TestQRGenerator {

    public static void main(String[] args) {

        // Por defecto es A4
        Document documento = new Document();

        try {
        // Obtenemos una instancia de un objeto PDFWriter
            PdfWriter.getInstance(documento, new FileOutputStream("D:\\web\\projects\\ticketFree\\src\\main\\java\\com\\ticketfree\\2.pdf"));
        // Abrimos el documento
        documento.open();
        // Seteamos a la variable el valor que deseamos que tenga el Codigo QR
        String textCodigoQR = "http://java-white-box.blogspot.com";
        // Realizamos una instancia de la clase la cual genera el Codigo QR
        // y seteamos el valor al codigo QR
        BarcodeQRCode codigoBarrasQR = new BarcodeQRCode(textCodigoQR, 0, 0, null);
        // Agregamos la imagen del codigo QR al documento
        documento.add(codigoBarrasQR.getImage());
        // Cerramos el documento
        documento.close();


        } catch (Exception ex) {
        // Atrapamos excepciones concernientes al documentoo.
        }
    }

}
