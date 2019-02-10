package ua.testov.test;

import java.io.File;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

	public static void main(String[] args) {
		ExecutorService service=Executors.newSingleThreadExecutor();
		File folder=new File(".");
		try {
			Future<String[]> future=service.submit(new SearchFile(folder, "test.txt"));
			String[] res=null;
		try {
			res=future.get();
			for (String string : res) {
				System.out.println(string);
			}
		} catch (InterruptedException|ExecutionException e) {
			e.printStackTrace();
		} 
		}
		finally {
			service.shutdown();
		}
	}

}
