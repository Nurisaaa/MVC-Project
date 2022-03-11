package peaksoft.dao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.model.Company;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CompanyDaoImpl implements CompanyDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveCompany(Company company) {
        entityManager.persist(company);
    }

    @Override
    public List<Company> getAllCompanies() {
        return entityManager.createQuery("SELECT e FROM Company e",Company.class).getResultList();
    }

    @Override
    public Company getCompanyById(long id) {
        return entityManager.find(Company.class, id);
    }

    @Override
    public void deleteCompanyById(long id) {
       Company company = getCompanyById(id);
       if(company!=null){
        entityManager.remove(company);
       }
    }

    @Transactional
    @Override
    public void updateCompany(Company company){
        entityManager.merge(company);
    }


}
