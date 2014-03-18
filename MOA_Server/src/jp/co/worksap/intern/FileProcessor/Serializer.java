package jp.co.worksap.intern.FileProcessor;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializer {
		//java serialize a object to file	
		public static void writeObject(String path,Object map) throws IOException{
			try {
				File f=new File(path); 
				FileOutputStream out=new FileOutputStream(f); 
				ObjectOutputStream objwrite=new ObjectOutputStream(out);
				objwrite.writeObject(map);
				objwrite.flush(); 
				objwrite.close(); 
			}
			catch (Exception e) {
				System.out.println("Error when add new application!");
			}
		}
	 
		// read the object from the file
		public static Object readObject(String path) throws IOException, ClassNotFoundException{		
			FileInputStream in=new FileInputStream(path); 
			ObjectInputStream objread=new ObjectInputStream(in);
			try {
				Object map=objread.readObject();		
				objread.close();
				return map;
			}
			catch (EOFException e) {
				System.out.println("Error when read existing application!");
				return null;
			}
		}
		
}
