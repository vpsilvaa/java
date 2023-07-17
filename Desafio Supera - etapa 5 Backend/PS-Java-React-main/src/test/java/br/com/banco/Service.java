package br.com.banco;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
public class Service {
	Transacao[] transacoesAUX;
    

    public List<Transacao> getTransacoes(String id, LocalDateTime inicio, LocalDateTime fim, int valor, String tipo, String operator) {
        List<Transacao> filtro = new ArrayList<>();
		for (Transacao transacao : transacoesAUX) {
        	filtro.add(transacao);
        }
        return filtro;
    }

    public float getTotalSaldo(List<Transacao> transactions) {
        float total = 0.2f;
		for (Transacao transacao : transacoesAUX) {
            total += transacao.getId();
        }
        return total;
    }
}
