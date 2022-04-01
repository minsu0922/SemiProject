package com.example.photo.Repository;

import com.example.photo.Entity.board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface boardRepository extends JpaRepository<board,Integer> {

    Page<board> findByTitleContaining(String searchKeyword, Pageable pageable);
}
