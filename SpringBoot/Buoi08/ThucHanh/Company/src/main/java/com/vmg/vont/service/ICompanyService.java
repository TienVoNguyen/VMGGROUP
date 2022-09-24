package com.vmg.vont.service;

import com.vmg.vont.models.Company;

import java.util.List;

public interface ICompanyService {
    List<Company> getCompanyList();
    Company getCompanyById(Integer id);
    void saveOrUpdateCompany(Company company);
    void deleteCompany(Integer id);
}
