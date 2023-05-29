package com.mcb.insuffcient.fund.app.InsufficientFund.modal;


import com.mcb.insuffcient.fund.app.InsufficientFund.dao.FundRequestStatus;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "fund_requests")
public class FundRequest {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String business_key;
    private String application;
    private String comments;
    private String transaction_currency;
    private Double transaction_amount;
    private Double amount_in_mur;
    private Double debit_account_number;
    private String payment_details_1;
    private String payment_details_2;
    private String payment_details_3;
    private String payment_details_4;
    private String verified;
    private String discrepancy_reason;
    private String created_by;
    private LocalDate created_on;
    private String updated_by;
    private LocalDate updated_on;
    private String customer_number;
    private String customer_name;
    private String accountOfficer;
    private String alt_account_officer;
    private LocalDate date_mail_sent;
    private String override;
    private String bu_name;
    private Double amount_in_debit_account_ccy;
    private Double debit_account_balance;
    private String beneficiary_account_number;
    private String beneficiary_name;
    private String beneficiary_bank_name;
    private String beneficiary_bank_swift_code;
    private Double agreed_rate;
    @Enumerated(EnumType.STRING)
    private FundRequestStatus status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBusiness_key() {
        return business_key;
    }

    public void setBusiness_key(String business_key) {
        this.business_key = business_key;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getTransaction_currency() {
        return transaction_currency;
    }

    public void setTransaction_currency(String transaction_currency) {
        this.transaction_currency = transaction_currency;
    }

    public Double getTransaction_amount() {
        return transaction_amount;
    }

    public void setTransaction_amount(Double transaction_amount) {
        this.transaction_amount = transaction_amount;
    }

    public Double getAmount_in_mur() {
        return amount_in_mur;
    }

    public void setAmount_in_mur(Double amount_in_mur) {
        this.amount_in_mur = amount_in_mur;
    }

    public Double getDebit_account_number() {
        return debit_account_number;
    }

    public void setDebit_account_number(Double debit_account_number) {
        this.debit_account_number = debit_account_number;
    }

    public String getPayment_details_1() {
        return payment_details_1;
    }

    public void setPayment_details_1(String payment_details_1) {
        this.payment_details_1 = payment_details_1;
    }

    public String getPayment_details_2() {
        return payment_details_2;
    }

    public void setPayment_details_2(String payment_details_2) {
        this.payment_details_2 = payment_details_2;
    }

    public String getPayment_details_3() {
        return payment_details_3;
    }

    public void setPayment_details_3(String payment_details_3) {
        this.payment_details_3 = payment_details_3;
    }

    public String getPayment_details_4() {
        return payment_details_4;
    }

    public void setPayment_details_4(String payment_details_4) {
        this.payment_details_4 = payment_details_4;
    }

    public String getVerified() {
        return verified;
    }

    public void setVerified(String verified) {
        this.verified = verified;
    }

    public String getDiscrepancy_reason() {
        return discrepancy_reason;
    }

    public void setDiscrepancy_reason(String discrepancy_reason) {
        this.discrepancy_reason = discrepancy_reason;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public LocalDate getCreated_on() {
        return created_on;
    }

    public void setCreated_on(LocalDate created_on) {
        this.created_on = created_on;
    }

    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by;
    }

    public LocalDate getUpdated_on() {
        return updated_on;
    }

    public void setUpdated_on(LocalDate updated_on) {
        this.updated_on = updated_on;
    }

    public String getCustomer_number() {
        return customer_number;
    }

    public void setCustomer_number(String customer_number) {
        this.customer_number = customer_number;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getAccountOfficer() {
        return accountOfficer;
    }

    public void setAccountOfficer(String accountOfficer) {
        this.accountOfficer = accountOfficer;
    }

    public String getAlt_account_officer() {
        return alt_account_officer;
    }

    public void setAlt_account_officer(String alt_account_officer) {
        this.alt_account_officer = alt_account_officer;
    }

    public LocalDate getDate_mail_sent() {
        return date_mail_sent;
    }

    public void setDate_mail_sent(LocalDate date_mail_sent) {
        this.date_mail_sent = date_mail_sent;
    }

    public String getOverride() {
        return override;
    }

    public void setOverride(String override) {
        this.override = override;
    }

    public String getBu_name() {
        return bu_name;
    }

    public void setBu_name(String bu_name) {
        this.bu_name = bu_name;
    }

    public Double getAmount_in_debit_account_ccy() {
        return amount_in_debit_account_ccy;
    }

    public void setAmount_in_debit_account_ccy(Double amount_in_debit_account_ccy) {
        this.amount_in_debit_account_ccy = amount_in_debit_account_ccy;
    }

    public Double getDebit_account_balance() {
        return debit_account_balance;
    }

    public void setDebit_account_balance(Double debit_account_balance) {
        this.debit_account_balance = debit_account_balance;
    }

    public String getBeneficiary_account_number() {
        return beneficiary_account_number;
    }

    public void setBeneficiary_account_number(String beneficiary_account_number) {
        this.beneficiary_account_number = beneficiary_account_number;
    }

    public String getBeneficiary_name() {
        return beneficiary_name;
    }

    public void setBeneficiary_name(String beneficiary_name) {
        this.beneficiary_name = beneficiary_name;
    }

    public String getBeneficiary_bank_name() {
        return beneficiary_bank_name;
    }

    public void setBeneficiary_bank_name(String beneficiary_bank_name) {
        this.beneficiary_bank_name = beneficiary_bank_name;
    }

    public String getBeneficiary_bank_swift_code() {
        return beneficiary_bank_swift_code;
    }

    public void setBeneficiary_bank_swift_code(String beneficiary_bank_swift_code) {
        this.beneficiary_bank_swift_code = beneficiary_bank_swift_code;
    }

    public Double getAgreed_rate() {
        return agreed_rate;
    }

    public void setAgreed_rate(Double agreed_rate) {
        this.agreed_rate = agreed_rate;
    }

    public FundRequestStatus getStatus() {
        return status;
    }

    public void setStatus(FundRequestStatus status) {
        this.status = status;
    }
}
