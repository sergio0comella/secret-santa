package it.panezio.secretsanta;


import it.panezio.secretsanta.models.Group;
import it.panezio.secretsanta.models.Member;
import it.panezio.secretsanta.services.GroupService;
import it.panezio.secretsanta.services.MemberService;
import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;
import java.util.List;

@SpringBootTest
@Log
public class MemberTests {

    @Autowired
    GroupService groupService;

    @Autowired
    MemberService memberService;

    @Test
    public void testSaveMember(){
        log.info("Inizio testSaveMember");

        Group g = new Group();
        g.setName("GruppoTest");
        groupService.save(g);

        Member m = new Member();
        m.setEmail("sergiocomella@gmail.com");
        m.setName("Sergio");
        List<Group> groups = new LinkedList<>();
        groups.add(g);
        m.setGroups(groups);

        memberService.save(m);

    }
}
