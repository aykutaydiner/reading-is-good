package com.getir.readingisgood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.getir.readingisgood.domain.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
