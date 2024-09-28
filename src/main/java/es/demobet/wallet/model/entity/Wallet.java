package es.demobet.wallet.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Wallet {

	@Id
	@Column(name = "user_idext")
	private Integer userIdext;
	
	@Column
	private Integer amount;
	
}
