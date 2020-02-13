package com.probir.bottomnavigation_example.Models;


/**
 * Created by Probir Bhowmik on 09-Feb-20. Soft BD Ltd. Email:probirbhowmikcse@gmail.com
 */
public class QModel {
    String SubjectName;

    public QModel(String subjectName) {
        this.SubjectName = subjectName;
    }

    public String getSubjectName() {
        return SubjectName;
    }

    public void setSubjectName(String subjectName) {
        SubjectName = subjectName;
    }
}
