package com.exam.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class exam {
    @Id
    private int examid;
    private String examname;
    private String teachersName;
    private String duration;
    private Date dateOfexam;


    public exam() {
    }

    public exam(int examid, String examname, String teachersName, String duration, Date dateOfexam) {
        this.examid = examid;
        this.examname = examname;
        this.teachersName = teachersName;
        this.duration = duration;
        this.dateOfexam = dateOfexam;
    }

    public int getExamid() {
        return examid;
    }

    public void setExamid(int examid) {
        this.examid = examid;
    }

    public String getExamname() {
        return examname;
    }

    public void setExamname(String examname) {
        this.examname = examname;
    }

    public String getTeachersName() {
        return teachersName;
    }

    public void setTeachersName(String teachersName) {
        this.teachersName = teachersName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Date getDateOfexam() {
        return dateOfexam;
    }

    public void setDateOfexam(Date dateOfexam) {
        this.dateOfexam = dateOfexam;
    }
}
