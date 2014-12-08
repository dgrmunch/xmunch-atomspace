package com.xmunch.atomspace;

import java.util.HashMap;
import java.util.Random;

import com.xmunch.atomspace.aux.AtomParams;
import com.xmunch.atomspace.aux.AtomSpaceParams;
import com.xmunch.atomspace.aux.AtomType;
import com.xmunch.atomspace.aux.GlobalValues;
import com.xmunch.atomspace.aux.VertexType;
import com.xmunch.atomspace.model.AtomSpace;
import com.xmunch.atomspace.visualization.UbigraphClient;

public class Main {
	
	static AtomSpace atomSpace;

    public static void main(String[] args) {
    	
    	HashMap<String, String> atomSpaceParams = new HashMap<String, String>();
    	HashMap<String, String> atomParams = new HashMap<String, String>();
    	
    	atomSpaceParams.put(AtomSpaceParams.VISUALIZATION.get(),GlobalValues.TRUE.get());
    	
    	atomSpace = AtomSpace.getInstance(atomSpaceParams);
        
    }

}

