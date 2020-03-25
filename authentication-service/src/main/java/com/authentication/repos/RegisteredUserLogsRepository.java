package com.authentication.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.authentication.entities.RegisteredUserLogs;

@Repository
public interface RegisteredUserLogsRepository extends JpaRepository<RegisteredUserLogs, Integer> {

	public RegisteredUserLogs findByUsername(String username);

	public void deleteByUsername(String username);

}
