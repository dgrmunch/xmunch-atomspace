package com.xmunch.atomspace.visualization;

import com.xmunch.atomspace.aux.Globals;
import com.xmunch.atomspace.aux.VertexType;
import com.xmunch.atomspace.aux.VisualizationParams;

public class VisualizationSpace {
	private UbigraphClient graph;

	public VisualizationSpace() {
		graph = new UbigraphClient();
		graph.clear();
		setEdgeStyle();
	}
	
	public void removeEdge(String id) {
		graph.removeEdge(Integer.valueOf(id));
	}

	public void createEdge(String edgeLabel, String from, String to) {
		Integer identifier = graph.newEdge(Integer.valueOf(from), Integer.valueOf(to));
		String label = new String();
		
		if(edgeLabel != null){
			label = edgeLabel;
		}
		
		graph.setEdgeAttribute(
				identifier, 
				VisualizationParams.LABEL.get(),
				label);
	}

	public void removeVertex(String id) {
		graph.removeVertex(Integer.valueOf(id));
	}
	
	public void createVertex(String id, String vertexType, String label) {
		Integer identifier = Integer.valueOf(id);
		graph.newVertex(identifier);
		
		graph.setVertexAttribute(
				identifier, 
				VisualizationParams.SHAPE.get(),
				VisualizationParams.SPHERE.get());
		
		graph.setVertexAttribute(
				identifier,
				VisualizationParams.SIZE.get(),
				Globals.ONE.get());
		
		graph.setVertexAttribute(
				identifier,
				VisualizationParams.LABEL.get(),
				label);
		
		graph.setVertexAttribute(
				identifier,
				VisualizationParams.COLOR.get(),
				getTypeColor(vertexType));
		
		graph.setVertexAttribute(
				identifier,
				VisualizationParams.FONT_COLOR.get(),
				Globals.WHITE.get());
	
	}

	private String getTypeColor(String vertexType) {
		String color = new String();
		
		switch (VertexType.valueOf(vertexType)){
		case A:
			color = Globals.BLUE.get();
			break;
		case B:
			color = Globals.RED.get();
			break;
		case C:
			color = Globals.YELLOW.get();
			break;
		case D:
			color = Globals.WHITE.get();
			break;
		case E:
			color = Globals.PINK.get();
			break;
		}
		
		return color;
	}

	private void setEdgeStyle() {
		graph.setEdgeStyleAttribute(0, VisualizationParams.WIDTH.get(), Globals.THREE.get());
		graph.setEdgeStyleAttribute(0, VisualizationParams.COLOR.get(), Globals.GREEN.get());
		graph.setEdgeStyleAttribute(0, VisualizationParams.ARROW.get(), Globals.TRUE.get());
		graph.setEdgeStyleAttribute(0, VisualizationParams.ARROW_POSITION.get(), Globals.ONE.get());
		graph.setEdgeStyleAttribute(0, VisualizationParams.STROKE.get(), VisualizationParams.DASHED.get());
		graph.setEdgeStyleAttribute(0, VisualizationParams.FONT_COLOR.get(),Globals.YELLOW.get());
		graph.setEdgeStyleAttribute(0, VisualizationParams.STRENGTH.get(),Globals.HALF.get());
		
	}

}
