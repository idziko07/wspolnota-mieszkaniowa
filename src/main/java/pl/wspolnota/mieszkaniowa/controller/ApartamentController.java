package pl.wspolnota.mieszkaniowa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.wspolnota.mieszkaniowa.model.Apartament;
import pl.wspolnota.mieszkaniowa.model.HousingAssociation;
import pl.wspolnota.mieszkaniowa.model.Inhabitant;
import pl.wspolnota.mieszkaniowa.repository.ApartamentRepository;
import pl.wspolnota.mieszkaniowa.repository.HousingAssociationRepository;

import java.util.List;
import java.util.Optional;

@Controller
public class ApartamentController {

    private ApartamentRepository apartamentRepository;
   private HousingAssociationRepository housingAssociationRepository;
   private String error ="";

    public ApartamentController(ApartamentRepository apartamentRepository, HousingAssociationRepository housingAssociationRepository) {
        this.apartamentRepository = apartamentRepository;
        this.housingAssociationRepository = housingAssociationRepository;
    }

    @GetMapping("/addApartament")
    public String addHouse(Model model){
        List<HousingAssociation> houses = housingAssociationRepository.findAll();
        model.addAttribute("apartament" , new Apartament());
        model.addAttribute("houses",houses);
        return "addApartament";
    }
    @PostMapping("/addApartamentFinish")
    public String addHouseFinish(Apartament apartament){

        apartamentRepository.save(apartament);
        return "redirect:/";
    }

    @GetMapping("/showApartament")
    public String showHouse(Model model){
        List<Apartament> apartaments = apartamentRepository.findAll();
        if(!(error.isEmpty())){
            model.addAttribute("error",error);
            error = "";
        }
        model.addAttribute("apartaments", apartaments);
        return "showApartament";
    }
    @GetMapping("/editApartment")
    public String editApartment(@RequestParam Long id, Model model){
        Apartament apartament = apartamentRepository.getOne(id);
         model.addAttribute("apart", apartament);
         return "editApartment";
    }

    @PostMapping("/updateApart")
    public String updateApart(Apartament apartament){
        apartamentRepository.save(apartament);
        return "redirect:/showApartament";
    }

    @GetMapping("/detailsApartment")
    public String details(@RequestParam Long id, Model model){
        Optional<Apartament> apartamentOptional = apartamentRepository.findById(id);

        if(apartamentOptional.isPresent()){
            Apartament apartament = apartamentOptional.get();
            model.addAttribute("apartament", apartament);
        }else {
            return "redirect:/";
        }
        return "detailsApartament";
    }
    @GetMapping("/deleteApartment")
    public String deleteApartment(@RequestParam Long id){
        Apartament apartament = apartamentRepository.getOne(id);
        List<Inhabitant> inhabitantList = apartament.getInhabitantList();
        if(inhabitantList.size() == 0){
            apartamentRepository.delete(apartament);
        }else {
            error = "Nie można usunać elementu";
        }

        return "redirect:/showApartament";
    }




}
