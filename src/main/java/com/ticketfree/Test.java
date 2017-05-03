package com.ticketfree;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.scene.layout.BackgroundImage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {

    public static final String IMAGE = "D:\\web\\projects\\ticketFree\\src\\main\\java\\com\\ticketfree\\image.jpg";
    public static final String DEST = "D:\\web\\projects\\ticketFree\\src\\main\\java\\com\\ticketfree\\background_image.pdf";

    public static void main(String[] args) throws IOException, DocumentException {
        File file = new File(DEST);
//        file.getParentFile().mkdirs();
        new Test().createPdf(DEST);
    }
    public void createPdf(String dest) throws IOException, DocumentException {

        Rectangle rectangle = new Rectangle(1000, 600);

        Document document = new Document(rectangle);
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();
        document.add(new Paragraph("Berlin!"));
        PdfContentByte canvas = writer.getDirectContentUnder();
        Image image = Image.getInstance(IMAGE);
        image.scaleAbsolute(PageSize.A4.rotate());
        image.setAbsolutePosition(0, 0);
        canvas.addImage(image);
        document.close();
        writer.close();
    }


    /*
* /* ferret *//*
*/
}
