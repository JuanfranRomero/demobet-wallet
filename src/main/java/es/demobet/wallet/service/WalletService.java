package es.demobet.wallet.service;

import es.demobet.wallet.model.dto.request.WalletRequest;
import es.demobet.wallet.model.dto.response.WalletResponse;
import es.demobet.wallet.model.entity.Wallet;

public interface WalletService {
	
	public WalletResponse get(Integer userIdext);

	public Wallet create(Integer userIdext);
	
	public WalletResponse deposit(WalletRequest walletRequest);
	
	public WalletResponse withdraw(WalletRequest walletRequest);
	
}
