package modelContact;

public record ContactData2(String firstname, String lastname, String address, String home, String mobile, String work,
                           String email, String email2, String email3) {

    public ContactData2(){
        this ("","","","","","","","","");
    }

    public ContactData2 withFirstname(String firstname) {
        return new ContactData2(firstname,this.lastname,this.address,this.home,this.mobile,this.work,this.email,this.email2,this.email3);
    }

    public ContactData2 withLastName(String lastname) {
        return new ContactData2(this.firstname,lastname,this.address,this.home,this.mobile,this.work,this.email,this.email2,this.email3);
    }
    public ContactData2 withAddress(String address) {
        return new ContactData2(this.firstname,this.lastname,address,this.home,this.mobile,this.work,this.email,this.email2,this.email3);
    }
    public ContactData2 withHome(String home) {
        return new ContactData2(this.firstname,this.lastname,this.address,home,this.mobile,this.work,this.email,this.email2,this.email3);
    }
    public ContactData2 withMobile(String mobile) {
        return new ContactData2(this.firstname,this.lastname,this.address,this.home,mobile,this.work,this.email,this.email2,this.email3);
    }
    public ContactData2 withWork(String work) {
        return new ContactData2(this.firstname,this.lastname,this.address,this.home,this.mobile,work,this.email,this.email2,this.email3);
    }
    public ContactData2 withEmail(String email) {
        return new ContactData2(this.firstname,this.lastname,this.address,this.home,this.mobile,this.work,email,this.email2,this.email3);
    }
    public ContactData2 withEmail2(String email2) {
        return new ContactData2(this.firstname,this.lastname,this.address,this.home,this.mobile,this.work,this.email,email2,this.email3);
    }
    public ContactData2 withEmail3(String email3) {
        return new ContactData2(this.firstname,this.lastname,this.address,this.home,this.mobile,this.work,this.email,this.email2,email3);
    }

}