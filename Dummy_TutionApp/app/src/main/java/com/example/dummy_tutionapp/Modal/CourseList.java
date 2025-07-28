package com.example.dummy_tutionapp.Modal;

import android.widget.TextView;

public class CourseList {

    String courseName, studentCount;
    int imgLanguageLogo;

    public CourseList(String courseName, String studentCount, int imgLanguageLogo ){

        this.courseName = courseName;
        this.studentCount = studentCount;
        this.imgLanguageLogo = imgLanguageLogo;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setStudentCount(String studentCount) {
        this.studentCount = studentCount;
    }

    public void setImgLanguageLogo(int imgLanguageLogo) {
        this.imgLanguageLogo = imgLanguageLogo;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getStudentCount() {
        return studentCount;
    }

    public int getImgLanguageLogo() {
        return imgLanguageLogo;
    }

}
