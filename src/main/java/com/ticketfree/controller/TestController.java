package com.ticketfree.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class TestController {

//    @Autowired
//    JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    BaseDao baseDao;

    @RequestMapping("/tests")
    public String index() {

//        User byId = baseDao.findById(User.class, 1);

   /*     System.out.println(byId.toString());


        List<Map<String, Object>> maps = jdbcTemplate.queryForList("SELECT * from USER");

        System.out.println(maps);*/


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

//        User user = SessionUtil.getUser(baseDao);
//
//        System.out.println(user);


        return "index";
    }
}
