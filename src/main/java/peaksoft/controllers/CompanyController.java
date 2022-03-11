package peaksoft.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.model.Company;
import peaksoft.service.CompanyService;
import peaksoft.service.CompanyServiceImpl;

@Configuration
@Controller
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyServiceImpl companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/new")
    public String newComp(Model model) {
        model.addAttribute("company", new Company());
        return "CompanyPages/new-company";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") long id, Model model){
        model.addAttribute("company",companyService.getCompanyById(id));
        return "CompanyPages/mainPage";
    }

    @PostMapping("/save")
    public String addComp(@ModelAttribute("company") Company company) {
        companyService.saveCompany(company);
        return "redirect:/companies";
    }

    @GetMapping
    public String allCompanies(Model model){
        model.addAttribute("companies", companyService.getAllCompanies());
        return "CompanyPages/mainPage";
    }

    @GetMapping("/{id}/edit")
    public String editCompany(Model model,@PathVariable("id") long id){
        model.addAttribute("company", companyService.getCompanyById(id));
        return "CompanyPages/editCompany";
    }

    @PatchMapping("/{id}")
    public String updateCompany(@ModelAttribute("company") Company company){
        companyService.updateCompany(company);
        return "redirect:/companies";
    }

    @DeleteMapping("/{id}/delete")
    public String deleteCompany(@PathVariable("id") long id){
        companyService.deleteCompanyById(id);
        return "redirect:/companies";
    }
}
