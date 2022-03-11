package peaksoft.dao;
import org.springframework.stereotype.Repository;
import peaksoft.model.Company;
import java.util.List;

public interface CompanyDao {
    void saveCompany(Company company);
    List<Company> getAllCompanies();
    Company getCompanyById(long id);
    void deleteCompanyById(long id);
    void updateCompany(Company company);
}
