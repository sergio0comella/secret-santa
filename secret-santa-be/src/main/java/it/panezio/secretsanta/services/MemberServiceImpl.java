package it.panezio.secretsanta.services;

import it.panezio.secretsanta.dto.MemberDto;
import it.panezio.secretsanta.models.Group;
import it.panezio.secretsanta.models.Member;
import it.panezio.secretsanta.repositories.GroupRepository;
import it.panezio.secretsanta.repositories.MemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<MemberDto> findAll() {
        return convertToDto(memberRepository.findAll());
    }

    @Override
    public void save(MemberDto memberDto) {
        Member member = new Member();
        mapDtoToEntity(memberDto, member);
        memberRepository.save(member);
    }

    private void mapDtoToEntity(MemberDto memberDto, Member member) {
        member.setName(memberDto.getName());
        member.setEmail(memberDto.getEmail());
        if (null == member.getGroups()) {
            member.setGroups(new HashSet<>());
        }
        memberDto.getGroups().forEach(groupId -> {
            Group group = groupRepository.findById(groupId).orElse(null);
            if (null == group) {
                group = new Group();
            }
            member.addGroup(group);
        });
    }

    private MemberDto convertToDto(Member member)
    {
        return member != null
                ? modelMapper.map(member, MemberDto.class)
                : null;
    }

    private List<MemberDto> convertToDto(List<Member> members)
    {
        List<MemberDto> memberDtoList = members
                .stream()
                .map(source -> modelMapper.map(source, MemberDto.class))
                .collect(Collectors.toList());

        return memberDtoList;
    }
}
