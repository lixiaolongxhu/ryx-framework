package test;

public  class OuterClass {
	private  int i=0;
	
	public abstract class InnerOne{ 
		public abstract double methoda(); 
	} 

	public  class InnerOne2 extends InnerOne { 
		public  double methoda(){
			return 0 ;
		}; 
	} 
	public OuterClass() {
		
		System.out.println("OuterClass Create");
		
//		InterClass ic = new InterClass();
	}

	public static void main(String[] args) {
		OuterClass oc = new OuterClass();
	}
}