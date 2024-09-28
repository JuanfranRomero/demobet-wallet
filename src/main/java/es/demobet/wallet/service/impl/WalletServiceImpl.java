package es.demobet.wallet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.demobet.wallet.model.entity.Wallet;
import es.demobet.wallet.repository.WalletRepository;
import es.demobet.wallet.service.WalletService;

@Service
public class WalletServiceImpl implements WalletService {

	@Autowired
	private WalletRepository walletRepository;
	
	@Override
	public Wallet create(Integer userIdext) {
		Wallet wallet = new Wallet();
		wallet.setUserIdext(userIdext);
		wallet.setAmount(0);
		return walletRepository.save(wallet);
	}
	
}
