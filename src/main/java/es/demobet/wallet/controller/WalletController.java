package es.demobet.wallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.demobet.wallet.service.WalletService;

@RestController
@RequestMapping("/wallet")
public class WalletController {

	@Autowired
	private WalletService walletService;
	
	@GetMapping("/deposit")
    public ResponseEntity<String> deposit() {
        return ResponseEntity.ok("Deposit service!");
    }

	@GetMapping("/withdraw")
    public ResponseEntity<String> withdraw() {
        return ResponseEntity.ok("withdraw service!");
    }
	
	@PostMapping("/{userIdext}")
    public ResponseEntity<Void> initWallet(@PathVariable Integer userIdext) {
		walletService.create(userIdext);
        return ResponseEntity.ok().build();
    }
	
}
