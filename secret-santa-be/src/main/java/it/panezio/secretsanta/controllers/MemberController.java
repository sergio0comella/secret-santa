package it.panezio.secretsanta.controllers;

import it.panezio.secretsanta.dto.MemberDto;
import it.panezio.secretsanta.services.GroupService;
import it.panezio.secretsanta.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    MemberService memberService;

    @Autowired
    GroupService groupService;

    @GetMapping("")
    public List<MemberDto> getAll(){
        List<MemberDto> memberDtos = memberService.findAll();

        return memberService.findAll();
    }

    @PostMapping("")
    public ResponseEntity<String> storeMember(@RequestBody MemberDto memberDto){
        //TODO handle exception for validation
        memberService.save(memberDto);
        return new ResponseEntity<>(memberDto.getId(), HttpStatus.CREATED);
    }

}
