package ie.nuigalway.ct5171.service;

import ie.nuigalway.ct5171.model.Petition;
import ie.nuigalway.ct5171.model.Signature;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PetitionService {

    private final ArrayList<Petition> petitionList = new ArrayList<Petition>();
    private final AtomicLong idGenerator = new AtomicLong();

    @PostConstruct
    public void init() {
        petitionList.add(new Petition(
                idGenerator.getAndIncrement(),
                "Save the Dublin Christmas Market",
                "The Christmas Market is being cancelled. Sign to help protect it!"
        ));

        petitionList.add(new Petition(
                idGenerator.getAndIncrement(),
                "More Public Transport",
                "Request for improved transport in rural areas."
        ));
    }
    public ArrayList<Petition> getAll() {
        return petitionList;
    }
    public Petition getById(Long id) {
        return petitionList.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    public Petition create(String title, String description) {
        Petition petition = new Petition(idGenerator.getAndIncrement(), title, description);
        petitionList.add(petition);
        return petition;
    }
    public List<Petition> search(String keyword) {
        if (keyword == null || keyword.isEmpty()) return new ArrayList<>();

        return petitionList.stream()
                .filter(p -> p.getTitle().toLowerCase().contains(keyword.toLowerCase()))
                .toList();
    }
    public void addSignature(Long id, Signature signature) {
        Petition petition = getById(id);
        if (petition != null) {
            petition.addSignature(signature);
        }
    }
}
