package com.sunnywr.controller;

import com.sunnywr.model.Course;
import com.sunnywr.service.CourseService;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Map;

@Controller
// 拦截 /courses 路径
@RequestMapping("/courses")
public class CourseController {

    private static Logger logger = LoggerFactory.getLogger(CourseController.class);

    private CourseService courseService;

    @Autowired
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    // 拦截 /courses/view?courseId=123 形式的URL
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String viewCourse(@RequestParam("courseId") Integer courseId, Model model) {
        logger.debug("In viewCourse, courseId = {}", courseId);
        Course course = courseService.getCoursebyId(courseId);
        model.addAttribute(course);
        return "course_overview";
    }

    // 拦截 /courses/view2/123 形式的URL
    @RequestMapping("/view2/{courseId}")
    public String viewCourse2(@PathVariable("courseId") Integer courseId,
                              Map<String, Object> model) {
        logger.debug("In viewCourse2, courseId = {}", courseId);
        Course course = courseService.getCoursebyId(courseId);
        model.put("course", course);
        return "course_overview";
    }

    //拦截 /courses/view3?courseId=123 形式的URL
    @RequestMapping("/view3")
    public String viewCourse3(HttpServletRequest request) {
        Integer courseId = Integer.valueOf(request.getParameter("courseId"));
        Course course = courseService.getCoursebyId(courseId);
        logger.debug("In viewCourse3, courseId = {}", courseId);
        request.setAttribute("course",course);
        return "course_overview";
    }

    @RequestMapping(value="/admin", method = RequestMethod.GET, params = "add")
    public String createCourse(){
        return "course_admin/edit";
    }

    @RequestMapping(value="/save", method = RequestMethod.POST)
    public String  doSave(@ModelAttribute Course course){

        logger.debug("Info of Course:");
        logger.debug(ReflectionToStringBuilder.toString(course));

        //在此进行业务操作，比如数据库持久化
        course.setCourseId(123);
        return "redirect:view2/" + course.getCourseId();
    }

    @RequestMapping(value="/upload", method=RequestMethod.GET)
    public String showUploadPage() {
        return "course_admin/file";
    }

    @RequestMapping(value="/doUpload", method=RequestMethod.POST)
    public String doUploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        if(!file.isEmpty()) {
            logger.debug("Process file: {}", file.getOriginalFilename());
            FileUtils.copyInputStreamToFile(file.getInputStream(),
                    new File("/home/silverlining/",
                    System.currentTimeMillis() + file.getOriginalFilename()));
        }
        return "success";
    }

    @RequestMapping(value="/{courseId}",method=RequestMethod.GET)
    public @ResponseBody Course getCourseInJson(@PathVariable Integer courseId){
        return  courseService.getCoursebyId(courseId);
    }


    @RequestMapping(value="/jsontype/{courseId}",method=RequestMethod.GET)
    public ResponseEntity<Course> getCourseInJson2(@PathVariable Integer courseId){
        Course course = courseService.getCoursebyId(courseId);
        return new ResponseEntity<Course>(course, HttpStatus.OK);
    }
}
