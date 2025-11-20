package ie.nuigalway.ct5171.controller;

import ie.nuigalway.ct5171.model.Petition;
import ie.nuigalway.ct5171.model.Signature;
import ie.nuigalway.ct5171.service.PetitionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/petitions")
public class PetitionController {

    private final PetitionService petitionService;

    public PetitionController(PetitionService petitionService) {
        this.petitionService = petitionService;
    }

    @GetMapping
    public String listPetitions(Model model) {
        model.addAttribute("petitions", petitionService.getAll());
        return "list-petitions";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("petition", new Petition());
        return "create-petition";
    }

    @PostMapping
    public String createPetition(@ModelAttribute Petition petition) {
        petitionService.create(petition.getTitle(), petition.getDescription());
        return "redirect:/petitions";
    }

    @GetMapping("/search")
    public String searchForm() {
        return "search";
    }

    @GetMapping("/search/results")
    public String searchResults(@RequestParam("query") String query, Model model) {
        model.addAttribute("results", petitionService.search(query));
        model.addAttribute("query", query);
        return "search-results";
    }

    @GetMapping("/{id}")
    public String petitionDetails(@PathVariable Long id, Model model) {
        Petition petition = petitionService.getById(id);
        model.addAttribute("petition", petition);
        model.addAttribute("signature", new Signature());
        return "petition-details";
    }

    @PostMapping("/{id}/sign")
    public String signPetition(@PathVariable Long id, @ModelAttribute Signature signature) {
        petitionService.addSignature(id, signature);
        return "redirect:/petitions/" + id;
    }
}
