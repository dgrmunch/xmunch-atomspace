package com.xmunch.atomspace.api;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xmunch.atomspace.aux.AtomParams;
import com.xmunch.atomspace.aux.AtomType;
import com.xmunch.atomspace.aux.Globals;
import com.xmunch.atomspace.model.AtomSpace;
import com.xmunch.atomspace.model.Vertex;

@RestController
public class VertexController {
	
	private static final String EMPTY = "";
	AtomSpace atomSpace = AtomSpace.getInstance();
	HashMap<String, String> atomParams;

	@RequestMapping("/vertex/create")
	public Vertex createVertex(
			@RequestParam(value = "label", defaultValue = "no-name") String label,
			@RequestParam(value = "type", defaultValue = "A") String type,
			@RequestParam(value = "params", defaultValue = "") String params) {
		
		atomParams = new HashMap<String, String>();
		atomParams.put(AtomParams.VERTEX_LABEL.get(), label);
		atomParams.put(AtomParams.VERTEX_TYPE.get(), type);
		atomParams.put(AtomParams.VERTEX_PARAMS.get(),
				params.replace(Globals.COMMA.get(), Globals.SPACE.get()));
		return (Vertex) atomSpace.createAtom(AtomType.VERTEX.get(), atomParams);
	}

	@RequestMapping("/vertices/number/get")
	public Integer getVerticesNumber(
			@RequestParam(value = "type", defaultValue = EMPTY) String type) {
		return (Integer) atomSpace.getVerticesNumber(type);
	}
	
	@RequestMapping("/vertices/get/")
	public ArrayList<String> getVerticesLabels(
			@RequestParam(value = "type", defaultValue = "") String type) {
		return (ArrayList<String>) atomSpace.getVerticesLabels(type);
	}
	
	@RequestMapping("/types/number/get")
	public Integer getTypesNumber() {
		return (Integer) atomSpace.getTypesNumber();
	}
	
	@RequestMapping("/types/get")
	public ArrayList<String> getVertexTypes() {
		return (ArrayList<String>) atomSpace.getTypes();
	}
	
	@RequestMapping("/vertex/get/")
	public Vertex getVertexByLabel(
			@RequestParam(value = "label", defaultValue = "no-name") String label) {
		return (Vertex) atomSpace.getVertexByLabel(label);
	}
	
}
