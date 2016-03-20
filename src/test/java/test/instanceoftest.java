package test;

class instanceoftest {
	 static 	A a;
	 static     B b;
	 static 	C c;
	  public static void main(String[] args){
	     System.out.println("A  " + a);
	     System.out.println("B  " +  b);
	     boolean res; 
	     
//	     System.out.println("instanceoftest test case 1: ------------------");
//	     res = a instanceof A; 
//	     System.out.println("a instanceof A: " + res);
//	       
//	     res = b instanceof B;
//	     System.out.println("b instanceof B: " + res);
//	       
//	     System.out.println("/ninstanceoftest test case 2: ------------------");   
//	     a=new B();
//	     b=new B();
//	     
//	     res = a instanceof A; 
//	     System.out.println("a instanceof A: " + res);
//	     
//	     res = a instanceof B;
//	     System.out.println("a instanceof B: " + res);
//
//	     res = b instanceof A;
//	     System.out.println("b instanceof A: " + res);
//	     
//	     res = b instanceof B;
//	     System.out.println("b instanceof B: " + res);
//	    
//	     System.out.println("/ninstanceoftest test case 3: ------------------");
//	     B b2=(C)new C();
//	     
//	     res = b2 instanceof A;
//	     System.out.println("b2 instanceof A: " + res);
//	     
//	     res = b2 instanceof B;
//	     System.out.println("b2 instanceof B: " + res);
//	     
//	     res = b2 instanceof C;
//	     System.out.println("b2 instanceof C: " + res);
//	     
//	     System.out.println("/ninstanceoftest test case 4: ------------------");
//	     
	     a=new B();
	     res = a instanceof A;
	     System.out.println("a instanceof A: " + res);
	     
	     res = a instanceof B;
	     System.out.println("a instanceof B: " + res);
	     
	     res = a instanceof C;
	     System.out.println("a instanceof C: " + res);
	     
	  }
	}