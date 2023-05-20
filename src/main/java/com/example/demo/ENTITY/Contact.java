package com.example.demo.ENTITY;
import javax.persistence.*;
import java.sql.Date;
@Entity
@Table(name = "Contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false)
    private String c_content;

    @Column(length = 50, nullable = false)
    private String c_name;

    @Column(length = 256, nullable = false)
    private String c_mail;

    @Column(length = 500, nullable = false)
    private String c_message;
    private Date c_date;

    public Contact() {
    }
    public Contact(Integer id, String c_content, String c_name, String c_mail, String c_message, Date c_date) {
        this.id = id;
        this.c_content = c_content;
        this.c_name = c_name;
        this.c_mail = c_mail;
        this.c_message = c_message;
        this.c_date = c_date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getC_content() {
        return c_content;
    }

    public void setC_content(String c_content) {
        this.c_content = c_content;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_mail() {
        return c_mail;
    }

    public void setC_mail(String c_mail) {
        this.c_mail = c_mail;
    }

    public String getC_message() {
        return c_message;
    }

    public void setC_message(String c_message) {
        this.c_message = c_message;
    }

    public Date getC_date() {
        return c_date;
    }

    public void setC_date(Date c_date) {
        this.c_date = c_date;
    }
}
