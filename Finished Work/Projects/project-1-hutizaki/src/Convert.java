

import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

/*  NOTES:
	DocumentBuilderFactory is a class, that creates DocumentBuilder objects. -> javax.xml.parsers package
	Parsing = Reading files
	
	XML = Extensible Markup Language
	Uses "Nodes" or Parent stored sections --> Elements are data inside of nodes
	
	<gpx> is the "root" node
		<trkpt> is the element, stands for 'track point'
		
	Document builder usage of parse and normalize makes the challenge too easy with built in functions
	
	BufferedX-er and FileX-er need try and catch
	
	when using catch ---> } catch (IOException e) { e.printStrackTrace();
						      
*/

/*  java.io; package contents
   
    BufferedReader
    BufferedWriter
    FileReader
  	FileWriter
  	
*/
	
/*  ChatGPT Solution: CLOSE FOR GRADING
  	
	public static void convertFile(String filePath) throws IOException {
		
		int time = 0;
		
		try {
			
		File file = new File(filePath); // File is from the java.io package
		
		if (!file.exists()) {
            System.out.println("Error: File not found - " + file.getAbsolutePath());
            return;
        }
		
		System.out.println("Reading file from: " + file.getAbsolutePath());
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		Document document = builder.parse(file); // Reads File
		
		document.getDocumentElement().normalize(); // Removes white lines
		
		BufferedWriter writer = new BufferedWriter(new FileWriter("triplog.csv"));
		
		writer.write("Time,Latitude,Longitude\n");
		
		NodeList nodeList = document.getElementsByTagName("trkpt");
		
		for (int i = 0; i < nodeList.getLength(); i++) {
			
			Node node = nodeList.item(i);
			
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				
				Element element = (Element) node;
				
				String lat = element.getAttribute("lat").replaceAll("[^0-9.-]", "");
				
				String lon = element.getAttribute("lon").replaceAll("[^0-9.-]", "");
				
				writer.write(time + "," + lat + "," + lon + "\n");
				
				time += 5;
			}	
		}
		
		writer.close();
		
		System.out.println("Conversion completed: triplog.csv created. \n Increment time: " + time);
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	*/
	
/*  METHODS:
    +getFilePath()
    +extractData()
    +filterData()
*/

public class Convert {
	
	public static void convertFile(String fileName) {
		int time = 0;
		
		File workingFilePath = getFilePath(fileName);
		
		try {
			String outputFileName = "triplog.csv";
			FileReader reader = new FileReader(workingFilePath);
			//System.out.println("File Reader being used...");
			BufferedReader bufferedReader = new BufferedReader(reader);
			//System.out.println("Buffered Reader being used...");
			BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));
			//System.out.println("New File being made...");
			writer.write("Time,Latitude,Longitude\n");
			//System.out.println("Writing title row...");
			String line = bufferedReader.readLine();
			
			while ((line = bufferedReader.readLine()) != null) {
				line = line.trim();
				if(line.isEmpty()) {
					continue;
				}
				if(line.startsWith("<trkpt")) {
					String lat = extractData(line, "lat=\"");
					String lon = extractData(line, "lon=\"");
					
					writer.write(time + "," + lat + "," + lon + "\n");
					time += 5;
				}
			}
			bufferedReader.close();
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public static String extractData(String line, String data) {
		int start = line.indexOf(data);
		String dataEnd = "\"";
		if(start == -1) return "N/A";
		start += data.length();
		int end = line.indexOf(dataEnd, start);
		return (end == -1) ? "N/A": filterData(line.substring(start, end));
	}
	
	public static String filterData(String line) {
		
		StringBuilder stringbuilder = new StringBuilder();
		
		for(int i = 0; i < line.length(); i++) {
			
			char c = line.charAt(i);
			
			if(Character.isDigit(c) || c == '.' || c == '-') {
				stringbuilder.append(c);
			}
		}
		return stringbuilder.toString();
	}
	
	public static File getFilePath(String fileName) {
		
		File filesName = new File(fileName);
		
		String filePath = filesName.getAbsolutePath();
		
		System.out.println("Reading file from: " + filePath);
		
		File searchFile = new File(filePath);
		
		// Check if the file exists before proceeding
	    if (!searchFile.exists()) {
	        System.out.println("❌ Error: File not found!");
	        return null;
	    }

	    // File is found, proceed with processing...
	    System.out.println("✅ File found! Processing now...");
	    return searchFile;
	}
}
