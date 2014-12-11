package com.xmunch.atomspace.api;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xmunch.atomspace.aux.AtomParams;
import com.xmunch.atomspace.aux.AtomType;
import com.xmunch.atomspace.aux.Globals;
import com.xmunch.atomspace.examples.LabeledGraphExample;
import com.xmunch.atomspace.examples.RandomGraphExample;
import com.xmunch.atomspace.model.AtomSpace;
import com.xmunch.atomspace.model.Vertex;

@RestController
public class VertexController {

    @RequestMapping("/vertex/create")
    public Vertex createVertex(@RequestParam(value="label", defaultValue="no-name") String label) {
    	
    	AtomSpace atomSpace = AtomSpace.getInstance();
    	HashMap<String, String> atomParams = new HashMap<String, String>();
    	atomParams.put(AtomParams.VERTEX_LABEL.get(), label);
        return (Vertex) atomSpace.createAtom(AtomType.VERTEX.get(),atomParams);
    }
}
