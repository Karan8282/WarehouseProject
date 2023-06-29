package com.karan.metacore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="doc_tab")
public class Document {
	@Id
	@Column(name="doc_id_col")
	private Integer docId;
	@Column(name="doc_name_col")
	private String docName;
	
	@Column(name="doc_data_col")
	@Lob // byte[] + LOB = BLOB
	private byte[] docData;

	public Integer getDocId() {
		return docId;
	}

	public void setDocId(Integer docId) {
		this.docId = docId;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public byte[] getDocData() {
		return docData;
	}

	public void setDocData(byte[] docData) {
		this.docData = docData;
	}
	
	
}
