package com.ecommerce.backendone.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@JsonFilter(Section.FILTER)
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Section {
    public static final String FILTER = "section-filter";
    @Id
    @SequenceGenerator(name = "sectionSequence", sequenceName = "section_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sectionSequence")
    private Integer sectionId;
    private String sectionName;
    @OneToMany(mappedBy = "section")
    @JsonManagedReference
    private List<Category> categories;
}
