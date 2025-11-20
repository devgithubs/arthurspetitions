package ie.nuigalway.ct5171.model;


import java.util.ArrayList;
import java.util.List;

public class Petition {

    private Long id;
    private String title;
    private String description;
    private ArrayList<Signature> signatures = new ArrayList<>();

    public Petition() {

    }
    public Petition(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    //getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public ArrayList<Signature> getSignatures() { return signatures; }
    public void setSignatures(ArrayList<Signature> signatures) { this.signatures = signatures; }

    public void addSignature(Signature signature) {
        this.signatures.add(signature);
    }

}
