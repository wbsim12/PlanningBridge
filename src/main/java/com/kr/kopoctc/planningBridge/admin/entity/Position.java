package com.kr.kopoctc.planningBridge.admin.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long positionPK;

    @Column
    private String name;

    @OneToMany(mappedBy = "position")
    private List<User> user;
}
