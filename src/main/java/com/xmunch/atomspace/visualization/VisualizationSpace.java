package com.xmunch.atomspace.visualization;

import com.xmunch.atomspace.aux.GlobalValues;
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
		graph.setEdgeAttribute(
				identifier, 
				VisualizationParams.LABEL.get(),
				edgeLabel);
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
				GlobalValues.ONE.get());
		
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
				getTypeColor(vertexType));
	
	}

	private String getTypeColor(String vertexType) {
		String color = new String();
		
		switch (VertexType.valueOf(vertexType)){
		case A:
			color = GlobalValues.BLUE.get();
			break;
		case B:
			color = GlobalValues.GREEN.get();
			break;
		case C:
			color = GlobalValues.YELLOW.get();
			break;
		case D:
			color = GlobalValues.WHITE.get();
			break;
		case E:
			color = GlobalValues.PINK.get();
			break;
		case F:
			color = GlobalValues.RED.get();
			break;
		}
		
		return color;
	}

	private void setEdgeStyle() {
		graph.setEdgeStyleAttribute(0, VisualizationParams.WIDTH.get(), GlobalValues.ONE.get());
		graph.setEdgeStyleAttribute(0, VisualizationParams.COLOR.get(), GlobalValues.YELLOW.get());
		graph.setEdgeStyleAttribute(0, VisualizationParams.ARROW.get(), GlobalValues.TRUE.get());
	}

}
