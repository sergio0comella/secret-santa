package it.panezio.secretsanta.repositories;

import it.panezio.secretsanta.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, String> {

}
