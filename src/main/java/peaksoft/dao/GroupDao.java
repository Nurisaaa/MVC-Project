package peaksoft.dao;

import peaksoft.model.Group;

import java.util.List;

public interface GroupDao {
    void saveGroup(Group group);
    Group getById(long id);
    void deleteGroup(long id);
    void updateGroup(Group group);
    List<Group> getAllGroups();
    List<Group>getGroupByCompanyById(long id);
}
