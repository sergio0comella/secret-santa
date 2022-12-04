package it.panezio.secretsanta.dto;


import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class MemberDto {

    private String id;
    private String name;
    private String email;
    private List<String> groups = new ArrayList<>();
}
