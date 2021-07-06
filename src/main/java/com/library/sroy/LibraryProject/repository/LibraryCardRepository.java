package com.library.sroy.LibraryProject.repository;

import com.library.sroy.LibraryProject.model.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryCardRepository extends JpaRepository<LibraryCard, Integer> {

}
