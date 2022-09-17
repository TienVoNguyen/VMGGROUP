package com.vmg.vont.models.pojo;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@MappedSuperclass
public abstract class BasePOJO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Date createDate;
    @Column
    private Date modifiedDate;
    @Column
    private String createBy;
    @Column
    private String modifiedBy;

}
