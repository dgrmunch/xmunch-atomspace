package com.xmunch.atomspace.visualization;

import com.xmunch.atomspace.aux.Globals;
import com.xmunch.atomspace.aux.VisualizationParams;

public class VisualizationSpace {
	private UbigraphClient graph;
	private Boolean self = false;

	public VisualizationSpace(Boolean self) {
		graph = new UbigraphClient();
		graph.clear();
		if(self){
			this.self = self;
			graph.newVertex(-1);
			graph.setVertexAttribute(-1,VisualizationParams.SHAPE.get(),VisualizationParams.SPHERE.get());
			graph.setVertexAttribute(-1,VisualizationParams.COLOR.get(),Globals.GREEN.get());
		}
		setEdgeStyle();
	}
	
	public void removeEdge(String id) {
		graph.removeEdge(Integer.valueOf(id));
	}
	
	public void createEdge(String edgeLabel, String from, String to) {
		createEdge(edgeLabel, Integer.valueOf(from), Integer.valueOf(to));
	}

	public void createEdge(String edgeLabel, Integer from, Integer to) {
		Integer identifier = graph.newEdge(from , to);
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
	
	public void createVertex(String id, String label, Boolean createType, String vertexType, String vertexTypeId) {
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
		
		createOrUpdateVertexType(createType, id, vertexTypeId, vertexType);
	
	}

	private void createOrUpdateVertexType(Boolean createType, String vertexId, String vertexTypeId, String vertexType) {
		
		Integer identifier = Integer.valueOf(vertexTypeId);
		
		if(createType) {
			
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
					vertexType);
			
			graph.setVertexAttribute(
					identifier,
					VisualizationParams.COLOR.get(),
					Globals.BLUE.get());
			
			graph.setVertexAttribute(
					identifier,
					VisualizationParams.FONT_COLOR.get(),
					Globals.BLUE.get());
			
			if(this.self) graph.newEdge(-1, identifier);
		}
		
		createEdge(Globals.IS_A.get(), Integer.valueOf(vertexId), identifier);
	}

	private String getTypeColor(String vertexType) {
		String color =String.format(Globals.HEX_GEN.get(), (0xFFFFFF & vertexType.hashCode()));
		return Globals.SHARP.get()+color.substring(0, 6); 
	}

	private void setEdgeStyle() {
		graph.setEdgeStyleAttribute(0, VisualizationParams.WIDTH.get(), Globals.ONE.get());
		graph.setEdgeStyleAttribute(0, VisualizationParams.COLOR.get(), Globals.BLUE.get());
		graph.setEdgeStyleAttribute(0, VisualizationParams.ARROW.get(), Globals.TRUE.get());
		graph.setEdgeStyleAttribute(0, VisualizationParams.ARROW_POSITION.get(), Globals.ONE.get());
		graph.setEdgeStyleAttribute(0, VisualizationParams.STROKE.get(), VisualizationParams.DASHED.get());
		graph.setEdgeStyleAttribute(0, VisualizationParams.FONT_COLOR.get(),Globals.BLUE.get());
	}

}
