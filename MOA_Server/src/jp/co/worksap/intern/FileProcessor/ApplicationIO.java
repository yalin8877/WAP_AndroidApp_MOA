package jp.co.worksap.intern.FileProcessor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import jp.co.worksap.intern.Constants.Constants;

public class ApplicationIO {

	private String outFilePath;
	
	public ApplicationIO() {
		outFilePath = Constants.DEFAULT_APPLICATION_FILE;
	}

	public ApplicationIO(String file) {
		outFilePath = file;
	}

	public void AddApplication(String[] application) {

		try {
			File file=new File(outFilePath);
			if(!file.exists())
				file.createNewFile();
			FileOutputStream out=new FileOutputStream(file,true);
			String temp = "";
			for (int i = 0; i < 9; i++) {
				temp += application[i] + "\t";
			}
			temp += "\n";
			StringBuffer sb=new StringBuffer();
            sb.append(temp);
            out.write(sb.toString().getBytes("utf-8"));
            System.out.println("New application added!");
		}
		catch (IOException e) {
			System.out.println("Error when add new application!");
		}
	}
	
	public void RewriteApplication(List<String[]> applications) {
		File file=new File(outFilePath);
		if(file.exists())
			file.delete();
		for (int i = 0; i < applications.size(); i++) {
			AddApplication(applications.get(i));
		}
	}
	
	public List<String[]> ReadApplication() {
		List<String[]> results = new ArrayList<String[]>();
		try {
			File file=new File(outFilePath);
			if(!file.exists())
				return null;
			BufferedReader br=new BufferedReader(new FileReader(file));
			String temp=null;
			temp=br.readLine();
			while(temp!=null) {
				String[] params = temp.split("\t");
				results.add(params);
				temp=br.readLine();
			}
		}
		catch (IOException e) {
			System.out.println("Error when read application!");
		}
		return results;
	}

}
