package bg.martin.aleksandrov.spring_mvc.model;

public class UserDTO {

    private String fname;
    private String lname;

    public UserDTO() {
    }

    public String getFname() {
        return fname;
    }

    public UserDTO setFname(String fname) {
        this.fname = fname;
        return this;
    }

    public String getLname() {
        return lname;
    }

    public UserDTO setLname(String lname) {
        this.lname = lname;
        return this;
    }

    @Override
    public String toString() {
        return fname + ' ' + lname;
    }
}
