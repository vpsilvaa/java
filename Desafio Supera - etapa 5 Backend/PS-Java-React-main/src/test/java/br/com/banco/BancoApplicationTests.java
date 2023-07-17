package br.com.banco;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BancoApplicationTests {

	@Autowired
    private Service transactionService;

    @Test
    void testGettotal() {
        Transacao tran1 = new Transacao();
        Transacao tran2 = new Transacao();

        List<Transacao> transacoes = List.of(tran1, tran2);
        float totalBalance = transactionService.getTotalSaldo(transacoes);
        assertEquals(150.2f, totalBalance);
    }

}
