package br.com.controleponto.controledeponto.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="batidas")
@Getter
@Setter
@NoArgsConstructor
public class Batida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_registro")
    private Integer id;

    @Column(name = "entrada1")
    private LocalDateTime entrada1;

}
