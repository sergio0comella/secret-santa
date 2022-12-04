package it.panezio.secretsanta.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity(name = "members")
public class Member {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(length = 36, nullable = false, updatable = false)
    private String id;

    @NotNull(message = "Name is mandatory")
    private String name;

    @NotNull(message = "Email is mandatory")
    @Email(message = "Insert a valid email")
    private String email;


    @ManyToMany(targetEntity = Group.class, cascade = { CascadeType.ALL })
    @JoinTable(
            name = "group_member",
            joinColumns = { @JoinColumn(name = "member_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "group_id", referencedColumnName = "id") }
    )
    @JsonIgnore
    private Set<Group> groups;

    public void addGroup(Group g) {
        this.groups.add(g);
        g.getMembers().add(this);
    }

    public void removeGroup(Group g) {
        this.getGroups().remove(g);
        g.getMembers().remove(this);
    }

}
