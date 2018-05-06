package com.pb.game.battleship;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import lombok.extern.slf4j.*;

@Slf4j
public class FileUtils {

	public static List<String> readFile(String fileName) {
		
		List<String> input = new ArrayList<String>();
		
		//Get file from resources folder
		ClassLoader classLoader = FileUtils.class.getClassLoader();
		if(classLoader.getResource(fileName) != null)
		{
			fileName = classLoader.getResource(fileName).getFile();
		}
		File file = new File(fileName);

		try (Scanner scanner = new Scanner(file)) {
			while (scanner.hasNextLine()) {
				input.add(scanner.nextLine());
			}
			scanner.close();
		} catch (IOException e) {
			log.error("Error while reading from file", e);
		}
		return input;
	}
}
