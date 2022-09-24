package com.vmg.vont.bankdemo.dao;

import com.vmg.vont.bankdemo.models.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBankAccountDAO extends JpaRepository<BankAccount, Long> {
}
