package com.example.sportcrm.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Getter
@Setter
@Entity
@SQLDelete(sql = "UPDATE sport_schools SET is_deleted=true WHERE id=?")
@SQLRestriction("is_deleted=false")
@Table(name = "sport_schools")
public class SportSchool {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String address;
    private String description;
    @Column(nullable = false, name = "telephone_number")
    private String telephoneNumber;
    @Column(nullable = false, unique = true)
    private String email;
    @Transient
    private List<String> trainerNames;
    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted = false;
}
