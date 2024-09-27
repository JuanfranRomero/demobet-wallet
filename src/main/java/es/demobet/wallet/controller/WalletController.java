package es.demobet.wallet.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wallet")
public class WalletController {

	@GetMapping("/deposit")
    public ResponseEntity<String> deposit() {
        return ResponseEntity.ok("Deposit service!");
    }

	@GetMapping("/withdraw")
    public ResponseEntity<String> withdraw() {
        return ResponseEntity.ok("withdraw service!");
    }
	
}
