package es.demobet.wallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.demobet.wallet.model.entity.Wallet;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Integer> {

}
