package com.springboot.boot.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.boot.entity.UserTable;

public interface UserTableDao extends CrudRepository<UserTable, String> {

}
