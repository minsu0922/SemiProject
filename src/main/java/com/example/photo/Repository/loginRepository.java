package com.example.photo.Repository;

import com.example.photo.Entity.login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface loginRepository extends JpaRepository<login, Integer> {
    public login findByEmail(String email);
}
