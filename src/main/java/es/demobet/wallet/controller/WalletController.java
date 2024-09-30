package es.demobet.wallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.demobet.wallet.model.dto.request.WalletRequest;
import es.demobet.wallet.model.dto.response.WalletResponse;
import es.demobet.wallet.service.WalletService;

@RestController
@RequestMapping("/wallet")
public class WalletController {

	@Autowired
	private WalletService walletService;
	
	@GetMapping("/{userIdext}")
    public ResponseEntity<WalletResponse> get(@PathVariable Integer userIdext) {
		WalletResponse walletResponse = walletService.get(userIdext);
        return ResponseEntity.ok(walletResponse);
    }
	
	@PutMapping("/deposit")
    public ResponseEntity<WalletResponse> deposit(@RequestBody WalletRequest walletRequest) {
		WalletResponse walletResponse = walletService.deposit(walletRequest);
        return ResponseEntity.ok(walletResponse);
    }

	@PutMapping("/withdraw")
    public ResponseEntity<WalletResponse> withdraw(@RequestBody WalletRequest walletRequest) {
		WalletResponse walletResponse = walletService.withdraw(walletRequest);
        return ResponseEntity.ok(walletResponse);
    }
	
	@PostMapping("/{userIdext}")
    public ResponseEntity<Void> initWallet(@PathVariable Integer userIdext) {
		walletService.create(userIdext);
        return ResponseEntity.ok().build();
    }
	
}
