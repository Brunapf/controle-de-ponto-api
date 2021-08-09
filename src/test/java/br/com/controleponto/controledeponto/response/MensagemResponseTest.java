package br.com.controleponto.controledeponto.response;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class MensagemResponseTest {

    @InjectMocks
    private MensagemResponse mock;

    @Mock
    private MensagemResponse expected;

    @BeforeEach
    public void setUp(){
        expected = new MensagemResponse();
        expected.setMensagem("Horário já registrado");
    }

    @Test
    public void checkEquals(){
        mock.setMensagem("Horário já registrado");
        assertEquals(expected.getMensagem(), mock.getMensagem());
    }
}
