package com.example.people.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Block {
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;
    private String reason;
    private LocalDate startDate;
    private LocalDate endDate;

}
