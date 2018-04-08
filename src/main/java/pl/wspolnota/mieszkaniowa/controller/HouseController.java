package pl.wspolnota.mieszkaniowa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.wspolnota.mieszkaniowa.model.Apartament;
import pl.wspolnota.mieszkaniowa.model.HousingAssociation;
import pl.wspolnota.mieszkaniowa.repository.ApartamentRepository;
import pl.wspolnota.mieszkaniowa.repository.HousingAssociationRepository;

import java.util.List;
import java.util.Optional;

@Controller
public class HouseController {

    private HousingAssociationRepository housingAssociationRepository;
    private String error ="";

    public HouseController(HousingAssociationRepository housingAssociationRepository) {
        this.housingAssociationRepository = housingAssociationRepository;
    }

    @GetMapping("/addHouse")
    public String addHouse(Model model){
        model.addAttribute("house" , new HousingAssociation());
        return "addHouse";
    }
    @PostMapping("/addHouseFinish")
    public String addHouseFinish(HousingAssociation house){
        if (house.getName().equals("")){
            house.setName(house.getAdress());
       }
        housingAssociationRepository.save(house);
        return "redirect:/";
    }

    @GetMapping("/showHouse")
    public String showHouse(Model model){
        List<HousingAssociation> houses = housingAssociationRepository.findAll();
        if(!(error.isEmpty())){
            model.addAttribute("error",error);
            error = "";
        }
        model.addAttribute("houses", houses);
        return "showHouse";
    }

    @GetMapping("/house")
    public String show(@RequestParam Long id , Model model) {
        Optional<HousingAssociation> houseOptional = housingAssociationRepository.findById(id);

        if(houseOptional.isPresent()) {
            HousingAssociation house = houseOptional.get();

            model.addAttribute("house", house);

        } else {
            return "redirect:/";
        }
        return "infoHouse";
    }

    @GetMapping("/detailsHouse")
    public String details(@RequestParam Long id, Model model){
        Optional<HousingAssociation> houseOptional = housingAssociationRepository.findById(id);
        if(houseOptional.isPresent()){
            HousingAssociation housingAssociation = houseOptional.get();
            List<Apartament> apartaments = housingAssociation.getApartaments();
            int area = 0;
            if (apartaments.size() > 0){
                area = housingAssociationRepository.sumArea(id);
            }

            model.addAttribute("area", area);
            model.addAttribute("house", housingAssociation);
        }else {
            return "redirect:/";
        }
        return "detailsHouse";
    }

    @GetMapping("/editHouse")
    public String editHouse(@RequestParam Long id, Model model){
        HousingAssociation house = housingAssociationRepository.getOne(id);
        model.addAttribute("house", house);
        return "editHouse";
    }

    @PostMapping("/updateHouse")
    public String updeteHouse(HousingAssociation housingAssociation){
        if (housingAssociation.getName().equals("")){
            housingAssociation.setName(housingAssociation.getAdress());
        }
        housingAssociationRepository.save(housingAssociation);
        return "redirect:/showHouse";
    }


    @GetMapping("/deleteHouse")
    public String deleteApartment(@RequestParam Long id){
        HousingAssociation house = housingAssociationRepository.getOne(id);
        List<Apartament> apartaments = house.getApartaments();
        if(apartaments.size() == 0){
            housingAssociationRepository.delete(house);
        }else {
            error = "Nie można usunać elementu";
        }

        return "redirect:/showHouse";
    }

}
