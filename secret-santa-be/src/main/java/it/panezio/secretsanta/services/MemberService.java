package it.panezio.secretsanta.services;

import it.panezio.secretsanta.dto.MemberDto;

import java.util.List;

public interface MemberService {

    List<MemberDto> findAll();
    void save(MemberDto memberDto);

}
