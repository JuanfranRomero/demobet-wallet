package es.demobet.wallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.demobet.wallet.model.entity.Wallet;
import jakarta.transaction.Transactional;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Integer> {

	@Modifying
	@Transactional
	@Query("update Wallet w set w.amount = w.amount + :amount where w.userIdext = :userIdext")
	public void deposit(@Param("userIdext") Integer userIdext, @Param("amount") Integer amount);
	
	@Modifying
	@Transactional
	@Query("update Wallet w set w.amount = w.amount + :amount where w.userIdext = :userIdext")
	public void increaseProfit(@Param("userIdext") Integer userIdext, @Param("amount") Integer amount);
	
	@Modifying
	@Transactional
	@Query("update Wallet w set w.amount = w.amount - :amount where w.userIdext = :userIdext")
	public void withdraw(@Param("userIdext") Integer userIdext, @Param("amount") Integer amount);
	
	@Modifying
	@Transactional
	@Query("update Wallet w set w.amount = w.amount - :amount where w.userIdext = :userIdext")
	public void subtract(@Param("userIdext") Integer userIdext, @Param("amount") Integer amount);
	
}
