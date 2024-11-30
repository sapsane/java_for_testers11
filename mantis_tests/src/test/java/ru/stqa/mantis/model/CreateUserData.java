package ru.stqa.mantis.model;

public record CreateUserData(String username, String password, String realName, String email, String access_level) {

    public CreateUserData (){
        this ("","","","","");
    }

    public CreateUserData withUsername(String username){
        return new CreateUserData( username,this.password,this.realName,this.email,this.access_level);
    };

    public CreateUserData withPassword(String password){
        return new CreateUserData( this.username,password,this.realName,this.email,this.access_level);
    };

    public CreateUserData withRealName(String realName){
        return new CreateUserData( this.username,this.password,realName,this.email,this.access_level);
    };

    public CreateUserData withEmail(String email){
        return new CreateUserData( this.username,this.password,this.realName,email,this.access_level);
    };
    public CreateUserData withAccessLevel (String access_level){
        return new CreateUserData( this.username,this.password,this.realName,this.email,access_level);
    };



}
