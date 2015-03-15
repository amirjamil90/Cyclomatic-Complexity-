import java.io.*;
import java.util.*;
class CyclomaticComplexity {

	public int check() {
		int complexity = 1;
		String fileName;
		String[] keywords = {"if","else","while","case","for","switch","do","continue","break","&&","||","?",":","catch","finally","throw","throws","default","return"};
		String words = "";
		String line = null;
		try {
			fileName = "GetFiles.java";
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			line = br.readLine();
			while (line != null)
			{
				StringTokenizer stTokenizer = new StringTokenizer(line);
				while (stTokenizer.hasMoreTokens())
				{
					words = stTokenizer.nextToken();
					for(int i=0; i<keywords.length; i++)
					{
						if (keywords[i].equals(words))
						{
							complexity++;
						}
					}
				}
				line = br.readLine();
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return (complexity);
	}

	public void showCyclomaticComplexity(int ccValue) {
		System.out.println("\nThe Cyclomatic Complexity is : "+ccValue);
		System.out.print("\nResult : ");
		if (ccValue> 50){
			System.out.print("Most complex and highly unstable method ");
		}
		else if(ccValue>= 21 && ccValue<=50)
			System.out.print("High risk");
		else if(ccValue>= 11 && ccValue<=20)
			System.out.print("Moderate risk");
		else
			System.out.print("Low risk program");
	}
	
	public static void main(String ss[])
	{
		CyclomaticComplexity cc = new CyclomaticComplexity();
		cc.showCyclomaticComplexity(cc.check());
	}
}