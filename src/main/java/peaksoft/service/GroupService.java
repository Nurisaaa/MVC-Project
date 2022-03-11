package peaksoft.service;

import org.springframework.stereotype.Service;
import peaksoft.dto.RequestGroup;
import peaksoft.model.Group;

import java.util.List;
@Service
public interface GroupService {

    void saveGroup(Group group);
    Group getById(long id);
    void deleteGroup(long id);
    void updateGroup(Group group);
    List<Group> getAllGroups();
    List<Group>getGroupByCompanyById(long id);
    Group groupRequest(RequestGroup requestGroup);
}
