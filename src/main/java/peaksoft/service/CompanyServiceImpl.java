package peaksoft.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.dao.CompanyDao;
import peaksoft.dao.CompanyDaoImpl;
import peaksoft.model.Company;
import peaksoft.model.Course;

import java.util.List;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService{

    private CompanyDao companyDao;

    @Autowired
    public CompanyServiceImpl(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    public void saveCompany(Company company){
        companyDao.saveCompany(company);
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyDao.getAllCompanies();
    }

    @Override
    public Company getCompanyById(long id) {
        return companyDao.getCompanyById(id);
    }

    @Override
    public void deleteCompanyById(Long id) {
        companyDao.deleteCompanyById(id);
    }

    @Override
    public void updateCompany(Company company) {
        companyDao.updateCompany(company);
    }
}