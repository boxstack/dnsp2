package main;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class ShortPool {
	// Create a shuffled pool representing the range of values a short may hold
	public ShortPool() {
		for (int i = 0; i < Short.MAX_VALUE; i++){
			pool.add(i);			
		}
		
		Collections.shuffle(pool);
	}

	public Integer poolSize() {
		return pool.size();
	}
	
	public Integer selectAt(int idx){
		Integer v = -1;
		
		if (poolSize() > idx) {
		    v = pool.get(idx);
		    pool.remove(idx);
		}
		return v;
	}
	
	public Integer selectFirst(){
		Integer v = -1;
		
		if (poolSize() > 0) {
			v = pool.get(0);
		    pool.remove(0);  	
		}
    return v;
	}

	
	List<Integer> pool = new ArrayList<Integer>();	
}
