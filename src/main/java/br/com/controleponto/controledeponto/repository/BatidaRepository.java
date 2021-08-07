package br.com.controleponto.controledeponto.repository;

import br.com.controleponto.controledeponto.entity.Batida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BatidaRepository extends JpaRepository<Batida, Integer> {

    @Query(value= "SELECT bat FROM Batida bat WHERE bat.entrada1 = ?1 ")
    List<Batida> buscarPorBatida(LocalDateTime entrada);

    @Query(value = "select COUNT(entrada1)  FROM batidas WHERE DATE(entrada1) = ?1  ", nativeQuery = true)
    Integer buscarQuantidadeBatidas(LocalDate data);
}
