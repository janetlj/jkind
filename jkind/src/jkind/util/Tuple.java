package jkind.util;

public class Tuple<X, Y> { 
	  private final X x; 
	  private final Y y; 
	  public Tuple(X x, Y y) { 
	    this.x = x; 
	    this.y = y; 
	  } 

	public X firstElement(){
		  return x;
	  }
	  
	  public Y secondElement(){
		  return y;
	  }
} 