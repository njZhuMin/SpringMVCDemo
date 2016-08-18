package com.sunnywr.controller;

import com.sunnywr.object.*;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.beans.PropertyEditor;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class BindingController {

    // http://127.0.0.1:8080/baseType.do?age=10
    @RequestMapping("baseType.do")
    @ResponseBody
    public String baseType(int age) {
        return "age: " + age;
    }

    // http://127.0.0.1:8080/baseType2.do?age=10
    @RequestMapping("baseType2.do")
    @ResponseBody
    public String baseType2(Integer age) {
        return "age: " + age;
    }

    // http://127.0.0.1:8080/array.do?name=Tom&name=Lucy&name=Jim
    @RequestMapping("array.do")
    @ResponseBody
    public String array(String[] name) {
        StringBuilder sbf = new StringBuilder();
        for(String item : name) {
            sbf.append(item).append(" ");
        }
        return sbf.toString();
    }

    // http://127.0.0.1:8080/object.do?name=Tom&age=10&contactInfo.phone=10086
    // http://127.0.0.1:8080/object.do?user.name=Tom&admin.name=Lucy&user.age=10
    @RequestMapping("object.do")
    @ResponseBody
    public String object(User user, Admin admin) {
        return user.toString() + " " + admin.toString();
    }

    @InitBinder("user")
    public void initUser(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("user.");
    }

    // http://127.0.0.1:8080/object.do?user.name=Tom&admin.name=Lucy&user.age=10
    @InitBinder("admin")
    public void initAdmin(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("admin.");
    }

    // http://127.0.0.1:8080/list.do?users[0].name=Tom&users[1].name=Lucy
    @RequestMapping("list.do")
    @ResponseBody
    public String list(UserListForm userListForm) {
        return "size=" + userListForm.getUsers().size() + " "
                + userListForm.toString();
    }

    // http://127.0.0.1:8080/set.do?users[0].name=Tom&users[1].name=Tom
    @RequestMapping("set.do")
    @ResponseBody
    public String set(UserSetForm userSetForm) {
        return userSetForm.toString();
    }

    // http://127.0.0.1:8080/map.do?users['X'].name=Tom&users['X'].age=10&users['Y'].name=Lucy
    @RequestMapping("map.do")
    @ResponseBody
    public String map(UserMapForm userMapForm) {
        return userMapForm.toString();
    }

//    {
//        "name":"Jim",
//            "age":16,
//            "contactInfo":{
//                "address":"Beijing",
//                "phone":"10086"
//            }
//    }
    @RequestMapping("json.do")
    @ResponseBody
    public String json(@RequestBody User user) {
        return user.toString();
    }

//    <?xml version="1.0" encoding="UTF-8" ?>
//    <admin>
//        <name>Jim</name>
//        <age>16</age>
//    </admin>
    @RequestMapping("xml.do")
    @ResponseBody
    public String xml(@RequestBody Admin admin) {
        return admin.toString();
    }

    // http://127.0.0.1:8080/date1.do?date1=2016-08-18
    @RequestMapping("date1.do")
    @ResponseBody
    public String date1(Date date1) {
        return date1.toString();
    }

//    @InitBinder("date1")
//    public void initDate1(WebDataBinder binder) {
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(
//                new SimpleDateFormat("yyyy-MM-dd"),true));
//    }

    // http://127.0.0.1:8080/date2.do?date2=2016-08-18
    @RequestMapping("date2.do")
    @ResponseBody
    public String date2(Date date2) {
        return date2.toString();
    }

    // http://127.0.0.1:8080/book
    @RequestMapping(value = "/book", method = RequestMethod.GET)
    @ResponseBody
    public String book(HttpServletRequest request) {
        String contentType = request.getContentType();
        if(contentType == null) {
            return "book.default";
        } else if(contentType.equals("txt")) {
            return "book.txt";
        } else if(contentType.equals("html")) {
            return "book.html";
        }
        return "book.default";
    }

    // http://127.0.0.1:8080/subject/123456
    @RequestMapping(value = "/subject/{subjectId}", method = RequestMethod.GET)
    @ResponseBody
    public String subjectGet(@PathVariable("subjectId") String subjectId) {
        return "this is a get method. subjectId: " + subjectId;
    }

    @RequestMapping(value = "/subject/{subjectId}", method = RequestMethod.POST)
    @ResponseBody
    public String subjectPost(@PathVariable("subjectId") String subjectId) {
        return "this is a post method. subjectId: " + subjectId;
    }

    @RequestMapping(value = "/subject/{subjectId}", method = RequestMethod.DELETE)
    @ResponseBody
    public String subjectDelete(@PathVariable("subjectId") String subjectId) {
        return "this is a delete method. subjectId: " + subjectId;
    }

    @RequestMapping(value = "/subject/{subjectId}", method = RequestMethod.PUT)
    @ResponseBody
    public String subjectPut(@PathVariable("subjectId") String subjectId) {
        return "this is a put method. subjectId: " + subjectId;
    }
}
