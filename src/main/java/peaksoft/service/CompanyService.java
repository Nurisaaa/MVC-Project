package peaksoft.service;
import org.springframework.stereotype.Service;
import peaksoft.model.Company;
import java.util.List;
@Service
public interface CompanyService {
    void saveCompany(Company company);
    List<Company> getAllCompanies();
    Company getCompanyById(long id);
    void deleteCompanyById(Long id);
    void updateCompany(Company company);
}
