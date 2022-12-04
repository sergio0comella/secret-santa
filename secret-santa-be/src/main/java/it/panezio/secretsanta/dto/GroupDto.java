package it.panezio.secretsanta.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GroupDto {
    private String id;
    private String name;
    private List<String> members = new ArrayList<>();
}
