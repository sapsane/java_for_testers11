package ru.stqa.addressbook.manager.hbm;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

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
    public String 	nickname="0";

    @Column(name="company")
    public  String 	company="0";

    public String middlename="0";
    public String title="0";
    public String fax="0";
    public String im="0";
    public String im2="0";
    public String im3="0";
    public String homepage="0";
    public int bday=1;
    public String bmonth="2";
    public String byear="1";
    public int aday=1;
    public String amonth="2";
    public String ayear="1";
    public String address2="0";
    public String phone2="0";
    public String notes="0";
    public Date deprecated = new Date();


    public ContactRecord(){
    }
    public ContactRecord(int id, String firstname, String lastname, String address, String home, String mobile, String work,
                         String email, String email2, String email3)
    {
        this.id=id;
        this.firstname=firstname;
        this.lastname=lastname;
        this.address=address;
        this.home=home;
        this.mobile=mobile;
        this.work=mobile;
        this.email=email;
        this.email2=email2;
        this.email3=email3;
    }
}


