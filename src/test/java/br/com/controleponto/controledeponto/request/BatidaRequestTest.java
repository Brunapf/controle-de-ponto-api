package br.com.controleponto.controledeponto.request;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class BatidaRequestTest {

    @InjectMocks
    private BatidaRequest mock;

    @Mock
    private BatidaRequest expected;

    LocalDateTime date = LocalDateTime.now();

    @BeforeEach
    public void setUp(){
        expected = new BatidaRequest();
        expected.setDataHora(date);
    }

    @Test
    public void checkEquals(){
        mock.setDataHora(date);
        assertEquals(expected.getDataHora(), mock.getDataHora());
    }
}