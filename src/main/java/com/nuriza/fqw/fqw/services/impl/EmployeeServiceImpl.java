package com.nuriza.fqw.fqw.services.impl;

import com.nuriza.fqw.fqw.entity.Employee;
import com.nuriza.fqw.fqw.repositories.EmployeeRepository;
import com.nuriza.fqw.fqw.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository repository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository){
        this.repository=repository;
    }

    @Override
    public List<Employee> getAll() {
        return repository.findAll();
    }

    @Override
    public Employee create(Employee employee) {
return repository.save(employee);
    }

    @Override
    public Employee getById(Integer id) {
        return repository.findById(id).orElse(new Employee());
    }

    @Override
    public void delete(Employee employee) {
repository.delete(employee);
    }

    @Override
    public Employee update(Employee employee) {
        return repository.save(employee);
    }
}
