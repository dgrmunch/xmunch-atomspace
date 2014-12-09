package com.xmunch.atomspace.model;

import java.util.HashMap;

import com.xmunch.atomspace.aux.AtomParams;
import com.xmunch.atomspace.aux.AtomSpaceParams;
import com.xmunch.atomspace.aux.AtomType;
import com.xmunch.atomspace.aux.GlobalValues;
import com.xmunch.atomspace.visualization.VisualizationSpace;

public class AtomSpace {
	private static volatile AtomSpace instance = null;
	private HashMap<String, Vertex> vertexSpace;
	private HashMap<String, Edge> edgeSpace;
	private VisualizationSpace visualizationSpace;
	private Boolean visualization = false;

	private AtomSpace(HashMap<String, String> atomSpaceParams) {
		vertexSpace = new HashMap<String, Vertex>();
		edgeSpace = new HashMap<String, Edge>();

		visualizationActivation(atomSpaceParams
				.get(AtomSpaceParams.VISUALIZATION.get()));
	}

	public static AtomSpace getInstance(HashMap<String, String> atomSpaceParams) {
		if (instance == null) {
			synchronized (AtomSpace.class) {
				if (instance == null) {
					instance = new AtomSpace(atomSpaceParams);
				}
			}
		}
		return instance;
	}

	public static AtomSpace getInstance() {
		return instance;
	}

	public void createAtom(String atomType, HashMap<String, String> atomParams) {
		if (atomType.equals(AtomType.VERTEX.get())) {
			createVertex(atomParams);
		} else {
			createEdge(atomParams);
		}
	}

	public void removeAtom(String atomType, String id) {
		if (atomType.equals(AtomType.VERTEX.get())) {
			removeVertex(id);
		} else {
			removeEdge(id);
		}
	}
	
	private void removeEdge(String id) {
		edgeSpace.remove(id);
		
		if (visualization) {
			visualizationSpace.removeEdge(id);
		}
	}

	private void removeVertex(String id) {
		vertexSpace.remove(id);
		
		if (visualization) {
			visualizationSpace.removeVertex(id);
		}
	}

	private void createVertex(HashMap<String, String> atomParams) {
		String vertexId = String.valueOf(vertexSpace.size());
		Vertex vertex = new Vertex(
				vertexId,
				atomParams.get(AtomParams.VERTEX_TYPE.get()),
				atomParams.get(AtomParams.VERTEX_LABEL.get()));
		
		vertexSpace.put(vertexId, vertex);
		
		if (visualization) {
			visualizationSpace.createVertex(
					vertexId,
					atomParams.get(AtomParams.VERTEX_TYPE.get()),
					atomParams.get(AtomParams.VERTEX_LABEL.get()));
		}
	}

	private void createEdge(HashMap<String, String> atomParams) {
		String edgeId = String.valueOf(edgeSpace.size());
		Edge edge = new Edge(
				edgeId,
				atomParams.get(AtomParams.FROM.get()), 
				atomParams.get(AtomParams.TO.get()),
				atomParams.get(AtomParams.STRENGTH.get()),
				atomParams.get(AtomParams.EDGE_TYPE.get()),
				atomParams.get(AtomParams.EDGE_LABEL.get()));
		
		edgeSpace.put(edgeId, edge);
		
		if (visualization) {
				visualizationSpace.createEdge(atomParams.get(AtomParams.FROM.get()),
				atomParams.get(AtomParams.TO.get()));
		}
	}

	private void visualizationActivation(String visualizationParam) {
		this.visualization = visualizationParam.equals(GlobalValues.TRUE.get());
		if (this.visualization) {
			this.visualizationSpace = new VisualizationSpace();
		}
	}

}