package com.xmunch.atomspace.examples;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

import com.xmunch.atomspace.aux.AtomParams;
import com.xmunch.atomspace.aux.AtomType;
import com.xmunch.atomspace.aux.VertexType;
import com.xmunch.atomspace.model.AtomSpace;
import com.xmunch.atomspace.model.Edge;
import com.xmunch.atomspace.model.Vertex;

public class RandomGraphExample {

	public static void run(HashMap<String, String> atomParams, AtomSpace atomSpace) {
		Integer max = 300;
		
		while(true){
			createRandomVertices(max,atomParams,atomSpace);
			createRandomEdges(max,atomParams,atomSpace);
			removeVertices(atomSpace);		
			removeEdges(atomSpace);
		}
	}

	private static void removeVertices(AtomSpace atomSpace) {
		
		Collection<Vertex> vertices = ((HashMap<String, Vertex>)atomSpace.getInstance().getVertexSpace().clone()).values();
		Iterator<Vertex> iterator = vertices.iterator();
		Vertex vertex;
		
		while(iterator.hasNext()){
			vertex = (Vertex)iterator.next();
			atomSpace.removeAtom(AtomType.VERTEX.get(), vertex.getId());
		}
	}

	private static void removeEdges(AtomSpace atomSpace) {
		Collection<Edge> edges = ((HashMap<String, Edge>)atomSpace.getInstance().getEdgeSpace().clone()).values();
		Iterator<Edge> iterator = edges.iterator();
		
		while(iterator.hasNext()){
			atomSpace.removeAtom(AtomType.EDGE.get(), iterator.next().getId());
		}
	}

	private static void createRandomVertices(Integer max, HashMap<String, String> atomParams, AtomSpace atomSpace) {
		for (int i = 0; i < max; i += 4) {
			atomParams.put(AtomParams.VERTEX_LABEL.get(), String.valueOf(i));
			atomParams.put(AtomParams.VERTEX_TYPE.get(), VertexType.A.get());
			atomSpace.createAtom(AtomType.VERTEX.get(), atomParams);
	
			atomParams.put(AtomParams.VERTEX_LABEL.get(), String.valueOf(i + 1));
			atomParams.put(AtomParams.VERTEX_TYPE.get(), VertexType.B.get());
			atomSpace.createAtom(AtomType.VERTEX.get(), atomParams);
	
			atomParams.put(AtomParams.VERTEX_LABEL.get(), String.valueOf(i + 2));
			atomParams.put(AtomParams.VERTEX_TYPE.get(), VertexType.E.get());
			atomSpace.createAtom(AtomType.VERTEX.get(), atomParams);
	
			atomParams.put(AtomParams.VERTEX_LABEL.get(), String.valueOf(i + 3));
			atomParams.put(AtomParams.VERTEX_TYPE.get(), VertexType.D.get());
			atomSpace.createAtom(AtomType.VERTEX.get(), atomParams);
		}
	}
	
	private static void createRandomEdges(Integer max, HashMap<String, String> atomParams, AtomSpace atomSpace) {
		Random random = new Random();
		for (int i = 0; i < max; ++i) {
			atomParams.put(AtomParams.FROM.get(),String.valueOf(random.nextInt(max)));
			atomParams.put(AtomParams.TO.get(),String.valueOf(random.nextInt(max)));
			atomSpace.createAtom(AtomType.EDGE.get(), atomParams);
		}
	}
}
