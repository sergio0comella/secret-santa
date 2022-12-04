package it.panezio.secretsanta.controllers;

import it.panezio.secretsanta.dto.GroupDto;
import it.panezio.secretsanta.models.Group;
import it.panezio.secretsanta.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
public class GroupController {

    @Autowired
    GroupService groupService;

    @GetMapping("")
    public List<Group> getAllGroups(){
        return groupService.getAllGroups();
    }

    @PostMapping("")
    public ResponseEntity<String> storeGroup(@RequestBody GroupDto groupDto){
        //TODO handle exception for validation
        groupService.save(groupDto);
        return new ResponseEntity<>(groupDto.getId(), HttpStatus.CREATED);
    }


}
