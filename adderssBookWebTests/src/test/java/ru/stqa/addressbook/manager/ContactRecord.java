package ru.stqa.addressbook.manager;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "addressbook")
public class ContactRecord {
    @Id
    @Column(name="id")
    public   int id;

    @Column(name="firstname")
    public  String firstname;

    @Column(name="lastname")
    public String 	lastname;

    @Column(name="address")
    public  String 	address;

    @Column(name="home")
    public  String 	home;

    @Column(name="mobile")
    public  String 	mobile;

    @Column(name="work")
    public  String 	work;

    @Column(name="email")
    public  String 	email;

    @Column(name="email2")
    public  String 	email2;

    @Column(name="email3")
    public  String 	email3;



    @Column(name="nickname")
    public String 	nickname;

    @Column(name="company")
    public  String 	company;
}


