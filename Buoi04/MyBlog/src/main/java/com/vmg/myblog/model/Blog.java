package com.vmg.myblog.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is empty")
    private String title;

    private String cover;

    private String content;
}
