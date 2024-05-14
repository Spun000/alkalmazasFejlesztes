package futoverseny.futoverseny.controllers;

import futoverseny.futoverseny.models.Race;
import futoverseny.futoverseny.models.api.RaceRunner;
import futoverseny.futoverseny.services.RaceService;
import futoverseny.futoverseny.services.ResultsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.UUID;

@Controller
public class HomeController {
    private final RaceService raceService;
    private final ResultsService resultsService;

    public HomeController(RaceService raceService, ResultsService resultsService) {
        this.raceService = raceService;
        this.resultsService = resultsService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("features", List.of(
                "Versenyek listázása",
                "Új verseny létrehozása",
                "Verseny részletek")
        );
        return "index";
    }

    @GetMapping(path = "getRaces")
    public String getRaces(Model model) {
        List<Race> races = raceService.getRaces();
        model.addAttribute("races", races);

        return "races";
    }

    @GetMapping(path = "newRace")
    public String newRace(Model model) {
        model.addAttribute("race", new Race());

        return "newRace";
    }

    @PostMapping("addRace")
    public String addRace(@ModelAttribute Race race, Model model) {
        try {
            raceService.addRace(race);
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("onError", true);
        }

        return "newRace";
    }

    @GetMapping(path = "getRaceDetails/{raceId}")
    public String getRaceDetails(@PathVariable(required = true) String raceId, Model model) {
        try {
            List<RaceRunner> raceRunners = resultsService.getRaceRunners(UUID.fromString(raceId));
            model.addAttribute("raceRunners", raceRunners);
        } catch (Exception e) {
            model.addAttribute("error", "No details found");
            model.addAttribute("onError", true);
        }

        return "raceDetails";
    }
}
