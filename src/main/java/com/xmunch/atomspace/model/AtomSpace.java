package com.xmunch.atomspace.model;

import java.util.ArrayList;
import java.util.HashMap;

import com.xmunch.atomspace.aux.AtomParams;
import com.xmunch.atomspace.aux.AtomSpaceParams;
import com.xmunch.atomspace.aux.AtomType;
import com.xmunch.atomspace.aux.Globals;
import com.xmunch.atomspace.visualization.VisualizationSpace;

public class AtomSpace {
	private static volatile AtomSpace instance = null;
	private HashMap<String, Vertex> vertexSpace;
	private ArrayList<String> vertexTypeSpace;
	private HashMap<String, Edge> edgeSpace;
	private VisualizationSpace visualizationSpace;
	private Boolean visualization = false;

	private AtomSpace(HashMap<String, String> atomSpaceParams) {
		vertexSpace = new HashMap<String, Vertex>();
		edgeSpace = new HashMap<String, Edge>();
		vertexTypeSpace = new ArrayList<String>();

		visualizationActivation(atomSpaceParams
				.get(AtomSpaceParams.VISUALIZATION.get()));
		
		//persistenceActivation(atomSpaceParams.get(AtomSpaceParams.PERSISTENCE.get()));
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

	public Atom createAtom(String atomType, HashMap<String, String> atomParams) {
		Atom atom;
		if (atomType.equals(AtomType.VERTEX.get())) {
			atom = createVertex(atomParams);
		} else {
			atom = createEdge(atomParams);
		}
		return atom;
	}

	public void removeAtom(String atomType, String id) {
		if (atomType.equals(AtomType.VERTEX.get())) {
			removeVertex(id);
		} else {
			removeEdge(id);
		}
	}
	
	private void removeEdge(String edgeLabel) {
		
		if (visualization) {
			visualizationSpace.removeEdge(edgeSpace.get(edgeLabel).getId());
		}
		
		edgeSpace.remove(edgeLabel);
	}

	private void removeVertex(String vertexLabel) {
		
		if (visualization) {
			visualizationSpace.removeVertex(vertexSpace.get(vertexLabel).getId());
		}
		
		vertexSpace.remove(vertexLabel);
	}

	private Vertex createVertex(HashMap<String, String> atomParams) {
		Vertex vertex = new Vertex();
		if(!vertexSpace.containsKey(atomParams.get(AtomParams.VERTEX_LABEL.get()))){
			 vertex = new Vertex(
					String.valueOf(vertexSpace.size()),
					atomParams.get(AtomParams.VERTEX_TYPE.get()),
					atomParams.get(AtomParams.VERTEX_LABEL.get()),
					atomParams.get(AtomParams.VERTEX_PARAMS.get()));
			
			vertexSpace.put(vertex.getVertexLabel(),vertex);
			
			if (visualization) {
				createVertexInVisualSpace(vertex);
			}
		} 
		
		return vertex;
	}

	private void createVertexInVisualSpace(Vertex vertex){
		Boolean createType = true;
		String vertexTypeId;
		
		if(!vertexTypeSpace.contains(vertex.getVertexType())){
			vertexTypeSpace.add(vertex.getVertexType());
			vertexTypeId = String.valueOf(vertexTypeSpace.size() - 1);
		} else {
			vertexTypeId = String.valueOf(vertexTypeSpace.indexOf(vertex.getVertexType()));
			createType = false;
		}
		
		visualizationSpace.createVertex(
				vertex.getId(),
				vertex.getVertexLabel(),
				createType,
				vertex.getVertexType(),
				vertexTypeId);
	}

	private Edge createEdge(HashMap<String, String> atomParams) {
		String edgeId = String.valueOf(edgeSpace.size());
		Edge edge = new Edge(
				edgeId,
				atomParams.get(AtomParams.FROM.get()), 
				atomParams.get(AtomParams.TO.get()),
				atomParams.get(AtomParams.EDGE_LABEL.get()),
				atomParams.get(AtomParams.EDGE_PARAMS.get()));
		
		edgeSpace.put(edge.getEdgeLabel(), edge);
		
		if (visualization) {
			String from = vertexSpace.get(atomParams.get(AtomParams.FROM.get())).getId();
			String to = vertexSpace.get(atomParams.get(AtomParams.TO.get())).getId();
				visualizationSpace.createEdge(atomParams.get(AtomParams.EDGE_LABEL.get()),from,to);
		}
		
		return edge;
	}

	private void visualizationActivation(String visualizationParam) {
		this.visualization = visualizationParam.equals(Globals.TRUE.get());
		if (this.visualization) {
			this.visualizationSpace = new VisualizationSpace();
		}
	}

	public HashMap<String, Vertex> getVertexSpace() {
		return vertexSpace;
	}

	public void setVertexSpace(HashMap<String, Vertex> vertexSpace) {
		this.vertexSpace = vertexSpace;
	}

	public HashMap<String, Edge> getEdgeSpace() {
		return edgeSpace;
	}

	public void setEdgeSpace(HashMap<String, Edge> edgeSpace) {
		this.edgeSpace = edgeSpace;
	}
}