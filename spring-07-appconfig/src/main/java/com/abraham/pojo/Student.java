package com.abraham.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author long
 * @date 2020/9/29
 */
@Component
public class Student {

    @Value("20160901")
    private String StudentId;

    public String getStudentId() {
        return StudentId;
    }

    public void setStuentId(String studentId) {
        StudentId = studentId;
    }
}
