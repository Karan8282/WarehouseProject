package com.karan.metacore.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.karan.metacore.model.Part;

public interface IPartService {

	Integer savePart(Part part);
	List<Part> getAllParts();
	void deletePart(Integer id);
	boolean isPartExist(Integer id);
	Optional<Part> getOnePart(Integer id);
	void updatePart(Part part);

	Map<Integer,String> getPartIdAndCode();
}
