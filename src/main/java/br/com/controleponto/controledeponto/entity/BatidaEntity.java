package br.com.controleponto.controledeponto.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="batidas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BatidaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_registro")
    private Integer id;

    @Column(name = "entrada1")
    private LocalDateTime entrada1;

}
