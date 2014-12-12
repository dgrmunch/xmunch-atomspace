package com.xmunch.atomspace;

import java.util.HashMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import com.xmunch.atomspace.aux.AtomSpaceParams;
import com.xmunch.atomspace.aux.Globals;
import com.xmunch.atomspace.model.AtomSpace;

@ComponentScan
@EnableAutoConfiguration
public class Main {

    public static void main(String[] args) {
    	HashMap<String, String> atomSpaceParams = new HashMap<String, String>();
    	atomSpaceParams.put(AtomSpaceParams.VISUALIZATION.get(),Globals.TRUE.get());
    	atomSpaceParams.put(AtomSpaceParams.SELF.get(),Globals.TRUE.get());
    	AtomSpace.getInstance(atomSpaceParams);
    	SpringApplication.run(Main.class, args);    
    }

}

