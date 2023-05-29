package com.mcb.insuffcient.fund.app.InsufficientFund.repository;

import com.mcb.insuffcient.fund.app.InsufficientFund.modal.FundRequest;
import com.mcb.insuffcient.fund.app.InsufficientFund.dao.FundRequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@EnableJpaRepositories
@Repository
public interface FundRequestRepository extends JpaRepository<FundRequest, String> {

    List<FundRequest> findByAccountOfficerAndStatus(String officer, FundRequestStatus status);

    List<FundRequest> findByAccountOfficerAndVerified(String officer,String verify);

    List<FundRequest> findByStatus(FundRequestStatus status);

    List<FundRequest> findAllByIdIn(List<Long> ids);

    @Query("SELECT Count(*) FROM FundRequest e WHERE " +
            "( e.status = :status) and " +
            "(:date is null or e.updated_on = :date) and " +
            "(:user is null or e.accountOfficer = :user)")
    int findByOptionalFields(
            @Param("status") FundRequestStatus status,
            @Param("date") Optional<LocalDate> date,
            @Param("user") Optional<String> user
    );
}
