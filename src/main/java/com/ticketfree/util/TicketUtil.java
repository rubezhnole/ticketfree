package com.ticketfree.util;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.codec.Base64;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.ticketfree.entity.bean.Event;
import com.ticketfree.entity.bean.Ticket;
import com.ticketfree.entity.bean.User;
import com.ticketfree.service.dao.BaseDao;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

public class TicketUtil {

    public static byte[] generateTicket(final String uuid, BaseDao baseDao) {
        Optional<Ticket> ticketOptional = baseDao.findTicketByUUID(uuid);
        if (ticketOptional.isPresent()) {
            Ticket ticket = ticketOptional.get();
            Event event = ticket.getEvent();
            User user = ticket.getUser();

            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            final String html = "<html><head><title>TEST</title></head><body>"
            + "<table>" +
                    "<tr>" +
                    "  <td>Name: </td>" +
                    "  <td>" + user.getUsername() + "</td>" +
                    "</tr>" +
                    "<tr>" +
                    "  <td>Event:</td>" +
                    "  <td>" + event.getTitle() + "</td>" +
                    " </tr>" +
                    " <tr>" +
                    "  <td>Venue:</td>" +
                    "  <td>" + event.getVenue() + "</td>" +
                    " </tr>" +
                    " <tr>" +
                    "  <td>Date start:</td>" +
                    "  <td>" + event.getDateStart() + "</td>" +
                    " </tr>" +
                    " <tr>" +
                    "  <td>Date end:</td>" +
                    "  <td>" + event.getDateEnd() + "</td>" +
                    " </tr>" +
                    "</table>"
//                    + "<img src='data:image/png;base64," + base64Image + "'/>"
            + "</body></html>";
            try {
                InputStream byteArrayInputStream = new ByteArrayInputStream(html.getBytes(StandardCharsets.UTF_8));


                Document document = new Document();
                PdfWriter writer = PdfWriter.getInstance(document, baos);
                document.open();

//                Image img = Image.getInstance("D:\\web\\projects\\ticketFree\\500pixels.gif");


                BarcodeQRCode codigoBarrasQR = new BarcodeQRCode(ticket.getUuid(), 200, 200, null);
                // Agregamos la imagen del codigo QR al documento
                document.add(codigoBarrasQR.getImage());

                XMLWorkerHelper.getInstance().parseXHtml(writer, document, byteArrayInputStream);

//                document.add(img);

                document.close();

//                ByteArrayInputStream pdfInputStream = new ByteArrayInputStream(baos.toByteArray());


                return baos.toByteArray();
            } catch (DocumentException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
