package com.wipro.dataservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.wipro.dataservice.entity.Account;

public interface AccountsRepository extends JpaRepository<Account, Long> {
	@Modifying
	@Query("UPDATE Account acc  SET acc.type = :ty ,acc.number = :nu, acc.holderName = :hn, acc.acBal= :acbal WHERE acc.id = :id")
	int updateAddress(@Param("id") Long accID, @Param("ty") String type, @Param("nu") String number,
			@Param("hn") String hname, @Param("acbal") Long AcBalance);

}
