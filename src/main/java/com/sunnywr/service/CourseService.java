package com.sunnywr.service;

import org.springframework.stereotype.Service;
import com.sunnywr.model.Course;

@Service
public interface CourseService {
    Course getCoursebyId(Integer courseId);
}