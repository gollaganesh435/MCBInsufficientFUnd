package com.mcb.insuffcient.fund.app.InsufficientFund.repository;


import com.mcb.insuffcient.fund.app.InsufficientFund.modal.RefreshToken;
import com.mcb.insuffcient.fund.app.InsufficientFund.modal.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

	Optional<RefreshToken> findByToken(String token);

	@Modifying
	int deleteByUser(User user);
}
