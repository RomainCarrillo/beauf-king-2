package com.romcaral.beauf_king.domain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "player")
@Data
@Builder
@NoArgsConstructor  // Required for JPA entities
@AllArgsConstructor // Required for Builder pattern with @Data
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Use AUTO for UUID
    private UUID id;

    private String name;

    private int score;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] image;  // Change from String to byte[] for image storage
}
