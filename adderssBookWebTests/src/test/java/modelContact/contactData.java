package modelContact;

public record contactData(String firstname, String lastname, String address, String home, String mobile, String work,
                          String email, String email2, String email3) {
    public contactData (){
        this ("","","","","","","","","");
    }

    public contactData withName(String name) {
        return new contactData(name,this.lastname,this.address,this.home,this.mobile,this.work,this.email,this.email2,this.email3);
    }

    public contactData withLastName(String lastname) {
        return new contactData(this.firstname,lastname,this.address,this.home,this.mobile,this.work,this.email,this.email2,this.email3);
    }
    public contactData withAddress(String address) {
        return new contactData(this.firstname,this.lastname,address,this.home,this.mobile,this.work,this.email,this.email2,this.email3);
    }
    public contactData withHome(String home) {
        return new contactData(this.firstname,this.lastname,this.address,home,this.mobile,this.work,this.email,this.email2,this.email3);
    }
    public contactData withMobile(String mobile) {
        return new contactData(this.firstname,this.lastname,this.address,this.home,mobile,this.work,this.email,this.email2,this.email3);
    }
    public contactData withWork(String work) {
        return new contactData(this.firstname,this.lastname,this.address,this.home,this.mobile,work,this.email,this.email2,this.email3);
    }
    public contactData withEmail(String email) {
        return new contactData(this.firstname,this.lastname,this.address,this.home,this.mobile,this.work,email,this.email2,this.email3);
    }
    public contactData withEmail2(String email2) {
        return new contactData(this.firstname,this.lastname,this.address,this.home,this.mobile,this.work,this.email,email2,this.email3);
    }
    public contactData withEmail3(String email3) {
        return new contactData(this.firstname,this.lastname,this.address,this.home,this.mobile,this.work,this.email,this.email2,email3);
    }

}