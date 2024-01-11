package com.example.sportcrm.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Getter
@Setter
@Entity
@SQLDelete(sql = "UPDATE trainers SET is_deleted = true WHERE id=?")
@SQLRestriction("is_deleted=false")
@Table(name = "trainers")
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false, name = "date_of_birth")
    private LocalDateTime dateOfBirth;
    @Column(nullable = false)
    private Integer age;
    @Column(nullable = false, name = "kind_of_sport")
    private String kindOfSport;
    @ManyToOne
    @JoinColumn(name = "sport_school_id", nullable = false)
    private SportSchool sportSchool;
    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted = false;
}
