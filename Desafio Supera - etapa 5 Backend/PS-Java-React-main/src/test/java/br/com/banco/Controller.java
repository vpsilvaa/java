package br.com.banco;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/transacoes")
    public ResponseEntity<List<Transacao>> getTransactions(
            @RequestParam(required = false) String id,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime inicio,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fim,
            @RequestParam(required = false) int valor,
    		@RequestParam(required = false) String tipo,
            @RequestParam(required = false) String operador) {

        List<Transacao> transacoes = Service.getTransacoes(id, inicio, fim, valor, tipo, operador);
        return ResponseEntity.ok(transacoes);
    }

    @GetMapping("/total")
    public ResponseEntity<Float> getTotalBalance(
    		@RequestParam(required = false) String id,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime inicio,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fim,
            @RequestParam(required = false) int valor,
    		@RequestParam(required = false) String tipo,
            @RequestParam(required = false) String operator) {

        List<Transacao> transacoes = Service.getTransacoes(id, inicio, fim, valor, tipo, operador);
        float totalBalance = Service.getTotalSaldo(transacoes);
        return ResponseEntity.ok(totalBalance);
    }
}

