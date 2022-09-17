package com.vmg.vont.models.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Role extends BasePOJO {
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false, unique = true)
    private String code;
    @ManyToMany(mappedBy = "roles")
    @JsonIgnore
    private Set<User> users;
}
