package peaksoft.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.dao.GroupDao;
import peaksoft.dto.RequestCourse;
import peaksoft.dto.RequestGroup;
import peaksoft.model.Course;
import peaksoft.model.Group;

import java.util.List;
@Service
@Transactional
public class GroupServiceImpl implements GroupService{

    private GroupDao groupDao;

    @Autowired
    public GroupServiceImpl(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    @Override
    public void saveGroup(Group group) {
        groupDao.saveGroup(group);
    }

    @Override
    public Group getById(long id) {
        return groupDao.getById(id);
    }

    @Override
    public void deleteGroup(long id) {
        groupDao.deleteGroup(id);
    }

    @Override
    public void updateGroup(Group group) {
         groupDao.updateGroup(group);
    }

    @Override
    public List<Group> getAllGroups() {
        return groupDao.getAllGroups();
    }

    @Override
    public List<Group> getGroupByCompanyById(long id) {
        return groupDao.getGroupByCompanyById(id);
    }

    @Override
    public Group groupRequest(RequestGroup requestGroup) {
        Group group = new Group();
        group.setName(requestGroup.getName());
        group.setDateOfStart(requestGroup.getDateOfStart());
        group.setDateOfFinis(requestGroup.getDateOfFinis());
        group.setCourseName(requestGroup.getCourseName());
        return group;
    }
}
