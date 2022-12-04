package it.panezio.secretsanta.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity(name = "groups")
public class Group {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(length = 36, nullable = false, updatable = false)
    private String id;

    @Column(unique = true, length = 50)
    @NotNull(message = "Name is mandatory")
    private String name;

    @ManyToMany(mappedBy = "groups")
    private Set<Member> members;

    public void addMember(Member m) {
        this.members.add(m);
        m.getGroups().add(this);
    }

    public void removeMember(Member m) {
        this.getMembers().remove(m);
        m.getGroups().remove(this);
    }
}
