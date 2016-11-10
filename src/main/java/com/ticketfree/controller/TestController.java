package com.ticketfree.controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import com.ticketfree.entity.bean.User;
import com.ticketfree.service.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;


@Controller
public class TestController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    BaseDao baseDao;

    @RequestMapping("/tests")
    public String index() {

        User byId = baseDao.findById(User.class, 1);

        System.out.println(byId.toString());


        List<Map<String, Object>> maps = jdbcTemplate.queryForList("SELECT * from USER");

        System.out.println(maps);


//        String page = "<html><head></head><body><h1>HTML to PDF</h1></body></html>";
//
//        byte[] bytes = page.getBytes();
//
//        try {
//            FileOutputStream fileOutputStream = new FileOutputStream("pdf.pdf");
//
//            Rectangle rectangle = new Rectangle(500, 500);
//
//            Document document = new Document(rectangle);
//            // step 2
//            PdfWriter writer = PdfWriter.getInstance(document, fileOutputStream);
//            // step 3
//            document.open();
//            // step 4
//            XMLWorkerHelper.getInstance().parseXHtml(writer, document,
//                    new ByteInputStream(bytes, 1024));
//            //step 5
//            document.close();
//            writer.close();
//            fileOutputStream.close();
//
//            System.out.println("PDF Created!");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        User admin = new User();
//        admin.setEntityId(1);
//        admin.setFirstName("Andrew");
//        admin.setLastName("Kot");
//        admin.setPassword("1234232");
//
//        String s = "";
//        try {
//             s = JacksonUtil.toJson(admin);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(s);
//
//        User admin1 = null;
//        try {
//            admin1 = JacksonUtil.toObj(s, User.class);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(admin1);


        return "index";
    }

    @RequestMapping("test")
    public String test() {

        return "index";
    }
}
