package com.vmg.vont.bankdemo.service;

import com.vmg.vont.bankdemo.models.BankAccount;

public interface IBankAccountService {
    BankAccount save(BankAccount bankAccount);

    BankAccount update(BankAccount bankAccount);

    void delete(long id);
}
