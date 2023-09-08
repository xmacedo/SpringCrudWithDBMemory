package com.xmacedo.repository;

import com.xmacedo.model.LibraryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends JpaRepository<LibraryModel, Long> {
    LibraryModel findBySection(String section);
}