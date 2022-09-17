package com.vmg.vont.models.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class User extends BasePOJO {
    @Column(length = 20, unique = true, nullable = false)
    private String username;
    @Column(length = 40, nullable = false)
    private String password;
    @Column(length = 50, nullable = false)
    private String fullName;
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Blog> blogs;
    @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    @JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
            @JoinColumn(name = "role_id") })
    private Set<Role> roles;
}
