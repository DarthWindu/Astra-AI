package alphaComponents;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;


public class WriterTest {

	public static void main(String[] args) {
		Charset utf8 = StandardCharsets.UTF_8;
		List<String> lines = Arrays.asList("1st line", "3nd line");
		
		
		try {
			//<Works>
			Files.write(Paths.get(""
					+ "./lib/file5.txt"), lines, utf8);
			        //  ./ indictates the parent folder to the current folder
			
			Files.write(Paths.get("./lib/file6.txt"), lines, utf8,
					StandardOpenOption.CREATE, StandardOpenOption.APPEND);
					//Creates file if file does not exist; writes to end of file.
			//</Works>
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}catch(InvalidPathException invalidPath) {
			System.err.println("Invalid Path");
		}
	}
}
