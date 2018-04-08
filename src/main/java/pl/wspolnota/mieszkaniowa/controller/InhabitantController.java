package pl.wspolnota.mieszkaniowa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.wspolnota.mieszkaniowa.model.Apartament;
import pl.wspolnota.mieszkaniowa.model.Inhabitant;
import pl.wspolnota.mieszkaniowa.repository.ApartamentRepository;
import pl.wspolnota.mieszkaniowa.repository.InhabitantRepository;
import pl.wspolnota.mieszkaniowa.model.Sex;

import java.util.List;

@Controller
public class InhabitantController {

    private InhabitantRepository inhabitantRepository;
    private ApartamentRepository apartamentRepository;

    public InhabitantController(InhabitantRepository inhabitantRepository, ApartamentRepository apartamentRepository) {
        this.inhabitantRepository = inhabitantRepository;
        this.apartamentRepository = apartamentRepository;
    }

    @GetMapping("/addInhabitant")
    public String addHouse(Model model){
        List<Apartament> apartaments = apartamentRepository.findAll();
        model.addAttribute("inhabitant" , new Inhabitant());
        model.addAttribute("sex", Sex.values());
        model.addAttribute("apartaments" ,apartaments);
        return "addInhabitant";
    }
    @PostMapping("/addInhabitantFinish")
    public String addHouseFinish(Inhabitant inhabitant){

        inhabitantRepository.save(inhabitant);
        return "redirect:/";
    }

    @GetMapping("/showInhabitant")
    public String showHouse(Model model){
        List<Inhabitant> inhabitants = inhabitantRepository.findAll();
        model.addAttribute("inhabitants", inhabitants);
        return "showInhabitant";
    }

    @GetMapping("/editInhabitant")
    public String editInhabitant(@RequestParam Long id, Model model){
        Inhabitant inhabitant = inhabitantRepository.getOne(id);
        List<Apartament> apartaments = apartamentRepository.findAll();
        model.addAttribute("inhabitant", inhabitant);
        model.addAttribute("apartments",apartaments);
        model.addAttribute("sex",Sex.values());
        return "editInhabitant";
    }

    @PostMapping("/updateInhabitant")
    public String updateInhabitant(Inhabitant inhabitant){
        inhabitantRepository.save(inhabitant);
        return "redirect:/showInhabitant";
    }

    @GetMapping("/deleteInhabitant")
    public String deleteInhabitant(@RequestParam Long id){
        inhabitantRepository.deleteById(id);
        return "redirect:/showInhabitant";
    }
}
