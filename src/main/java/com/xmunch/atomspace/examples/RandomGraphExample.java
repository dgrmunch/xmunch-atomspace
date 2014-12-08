package com.xmunch.atomspace.examples;

import java.util.HashMap;
import java.util.Random;

import com.xmunch.atomspace.aux.AtomParams;
import com.xmunch.atomspace.aux.AtomType;
import com.xmunch.atomspace.aux.VertexType;
import com.xmunch.atomspace.model.AtomSpace;

public class RandomGraphExample {

	public static void run(HashMap<String, String> atomParams, AtomSpace atomSpace) {
		int N = 500;

		for (int i = 0; i < N; i += 4) {
			atomParams.put(AtomParams.VERTEX_LABEL.get(), String.valueOf(i));
			atomParams.put(AtomParams.VERTEX_TYPE.get(), VertexType.A.get());
			atomSpace.createAtom(AtomType.VERTEX.get(), atomParams);

			atomParams
					.put(AtomParams.VERTEX_LABEL.get(), String.valueOf(i + 1));
			atomParams.put(AtomParams.VERTEX_TYPE.get(), VertexType.B.get());
			atomSpace.createAtom(AtomType.VERTEX.get(), atomParams);

			atomParams
					.put(AtomParams.VERTEX_LABEL.get(), String.valueOf(i + 2));
			atomParams.put(AtomParams.VERTEX_TYPE.get(), VertexType.E.get());
			atomSpace.createAtom(AtomType.VERTEX.get(), atomParams);

			atomParams
					.put(AtomParams.VERTEX_LABEL.get(), String.valueOf(i + 3));
			atomParams.put(AtomParams.VERTEX_TYPE.get(), VertexType.D.get());
			atomSpace.createAtom(AtomType.VERTEX.get(), atomParams);
		}

		Random random = new Random();
		for (int i = 0; i < N; ++i) {
			atomParams.put(AtomParams.FROM.get(),
					String.valueOf(random.nextInt(N)));
			atomParams.put(AtomParams.TO.get(),
					String.valueOf(random.nextInt(N)));
			atomSpace.createAtom(AtomType.EDGE.get(), atomParams);
		}
	}
}
