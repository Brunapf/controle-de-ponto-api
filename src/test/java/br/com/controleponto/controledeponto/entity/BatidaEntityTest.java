package br.com.controleponto.controledeponto.entity;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class BatidaEntityTest {

    @InjectMocks
    private BatidaEntity mock;

    @Mock
    private BatidaEntity expected;

    LocalDateTime date = LocalDateTime.now();

    @Test
    public void checkEquals(){

        expected = new BatidaEntity();
        expected.setId(1);
        expected.setEntrada1(date);

        mock.setId(1);
        mock.setEntrada1(date);
        assertEquals(expected.getEntrada1(), mock.getEntrada1());
    }
}
