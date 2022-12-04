package it.panezio.secretsanta.services;

import it.panezio.secretsanta.dto.GroupDto;
import it.panezio.secretsanta.models.Group;
import it.panezio.secretsanta.models.Member;
import it.panezio.secretsanta.repositories.GroupRepository;
import it.panezio.secretsanta.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService{

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    MemberRepository memberRepository;

    @Override
    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    @Override
    public void save(GroupDto groupDto) {
        Group group = new Group();
        mapDtoToEntity(groupDto, group);
        groupRepository.save(group);
    }

    @Override
    public Group getById(String id) {
        return groupRepository.getReferenceById(id);
    }

    private void mapDtoToEntity(GroupDto groupDto, Group group) {
        group.setName(groupDto.getName());
        if (null == group.getMembers()) {
            group.setMembers(new HashSet<>());
        }
        groupDto.getMembers().forEach(memberId -> {
            Member member = memberRepository.findById(memberId).orElse(null);
            if (null == member) {

            }
            group.addMember(member);
        });
    }

}
