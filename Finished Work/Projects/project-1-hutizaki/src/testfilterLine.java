
public class testfilterLine {
	static String text = "<trkpt lat=\"35.??2110   37\"  lon=\" -97.438866\" >";
	
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
			
			if(Character.isDigit(c) || c == '.') {
				stringbuilder.append(c);
			}
		}
		return stringbuilder.toString();
	}
	
	public static void main(String[] args) {
		System.out.print(extractData(text, "lat=\""));

	}

}
