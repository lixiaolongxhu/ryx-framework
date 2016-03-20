package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Teacher extends Person {

	public Teacher() throws FileNotFoundException {
		System.out.println("Teacher");
	   InputStreamReader  input=	new   InputStreamReader(new FileInputStream("1.dat") );
	}
	
	public static void main(String[] ats){
		String  str1="hello";
		String str2="he"+new String ("llo");
		System.out.println(str1==str2);
	}

}
