package com.vmg.vont.service.impl;

import com.vmg.vont.dao.CompanyDAO;
import com.vmg.vont.models.Company;
import com.vmg.vont.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService implements ICompanyService {
    private final CompanyDAO companyDAO;

    public CompanyService(CompanyDAO companyDAO) {
        this.companyDAO = companyDAO;
    }

    @Override
    public List<Company> getCompanyList() {
        return companyDAO.findAll();
    }

    @Override
    public Company getCompanyById(Integer id) {
        return companyDAO.getReferenceById(id);
    }

    @Override
    public void saveOrUpdateCompany(Company company) {
        companyDAO.save(company);
    }

    @Override
    public void deleteCompany(Integer id) {
        companyDAO.deleteById(id);
    }
}
