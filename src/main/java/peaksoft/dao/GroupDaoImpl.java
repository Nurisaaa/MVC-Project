package peaksoft.dao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.model.Group;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class GroupDaoImpl implements GroupDao {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveGroup(Group group) {
        if (group.getId() < 0) {
            group = new Group();
            entityManager.persist(group);
        } else
            entityManager.merge(group);
    }

    @Override
    public Group getById(long id) {
        return entityManager.find(Group.class, id);
    }

    @Override
    public void deleteGroup(long id) {
        Group group = getById(id);
        if (group != null) {
            entityManager.remove(group);
        }
    }

    @Override
    public void updateGroup(Group group) {
        entityManager.merge(group);
    }

    @Override
    public List<Group> getAllGroups() {
        return entityManager.createQuery("SELECT g FROM Group g", Group.class).getResultList();
    }

    @Override
    public List<Group> getGroupByCompanyById(long id){
        return entityManager.createQuery("SELECT gr FROM Group gr WHERE gr.company.id=:id",Group.class).setParameter("id",id).getResultList();
    }

}
