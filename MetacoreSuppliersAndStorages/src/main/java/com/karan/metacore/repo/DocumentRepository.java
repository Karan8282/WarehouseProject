package com.karan.metacore.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.karan.metacore.model.Document;

public interface DocumentRepository 
	extends JpaRepository<Document, Integer> {

	@Query("SELECT docId,docName FROM Document ")
	List<Object[]> getDocIdAndNames();
}
