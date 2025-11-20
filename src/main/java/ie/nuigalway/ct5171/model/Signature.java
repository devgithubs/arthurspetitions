package ie.nuigalway.ct5171.model;

public class Signature {

    private String name;
    private String email;

    public Signature() {}

    public Signature(String name, String email) {
        this.email = email;
        this.name = name;
    }

    //getters & setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

}
