package it.panezio.secretsanta.services;

import it.panezio.secretsanta.dto.GroupDto;
import it.panezio.secretsanta.models.Group;

import java.util.List;

public interface GroupService {

    List<Group> getAllGroups();
    void save(GroupDto groupDto);
    Group getById(String id);

}
