package ua.testov.test;

import java.io.File;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.concurrent.Callable;

public class SearchFile implements Callable<String[]> {
private File folder;
private String str;

public SearchFile() {
	super();
}

public SearchFile(File folder, String str) {
	super();
	this.folder = folder;
	this.str = str;
}

@Override
public String[] call() throws Exception {
	if(folder.isFile()) {
		throw new InvalidParameterException(folder+"It is not directory!");
	}
	ArrayList<String> arrList=arrNames(folder, str);
	String[]arr=new String[arrList.size()];
	arrList.toArray(arr);
	return arr;
}
public ArrayList<String> arrNames(File folder, String str) {
	File[] arrFiles = folder.listFiles();
	ArrayList<String> arrNames = new ArrayList<String>();
	for (File file : arrFiles) {
		if (file.isDirectory()) {
			arrNames(file, str);
		} else {
			if (file.getName().equals(str))
				arrNames.add(file.getPath());
		}
	}
	Object[] arr = arrNames.toArray();
	for (Object string : arr) {
		System.out.println(string);
	}
	return arrNames;
}

}
