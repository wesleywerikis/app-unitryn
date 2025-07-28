package br.com.unitryn.app_unitryn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unitryn.app_unitryn.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
