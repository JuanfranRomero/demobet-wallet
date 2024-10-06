package es.demobet.wallet.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.demobet.wallet.model.dto.request.WalletRequest;
import es.demobet.wallet.model.dto.response.WalletResponse;
import es.demobet.wallet.model.entity.Wallet;
import es.demobet.wallet.repository.WalletRepository;
import es.demobet.wallet.service.WalletService;

@Service
public class WalletServiceImpl implements WalletService {

	private final WalletRepository walletRepository;
	
	@Autowired
	public WalletServiceImpl(WalletRepository walletRepository) {
		this.walletRepository = walletRepository;
	}

	@Override
	public Wallet create(Integer userIdext) {
		Wallet wallet = new Wallet();
		wallet.setUserIdext(userIdext);
		wallet.setAmount(0);
		return walletRepository.save(wallet);
	}

	@Override
	public WalletResponse get(Integer userIdext) {
		return getAmount(userIdext);
	}
	
	@Override
	public WalletResponse deposit(WalletRequest walletRequest) {
		walletRepository.deposit(walletRequest.getUserId(), walletRequest.getAmount());
		
		return getAmount(walletRequest.getUserId());
	}

	@Override
	public WalletResponse withdraw(WalletRequest walletRequest) {
		walletRepository.withdraw(walletRequest.getUserId(), walletRequest.getAmount());
		
		return getAmount(walletRequest.getUserId());
	}
	
	@Override
	public WalletResponse subtract(WalletRequest walletRequest) {
		walletRepository.subtract(walletRequest.getUserId(), walletRequest.getAmount());
		
		return getAmount(walletRequest.getUserId());
	}
	

	@Override
	public WalletResponse increaseProfit(WalletRequest walletRequest) {
		walletRepository.increaseProfit(walletRequest.getUserId(), walletRequest.getAmount());
		
		return getAmount(walletRequest.getUserId());
	}
	
	private WalletResponse getAmount(Integer userId) {
		WalletResponse walletResponse = new WalletResponse();
		Optional<Wallet> optionalWallet = walletRepository.findById(userId);
		walletResponse.setAmount(optionalWallet.isPresent() ? optionalWallet.get().getAmount() : null);
		
		return walletResponse;
	}
	
}
