import java.io‭.*;‬
import java.util‭.*;‬
import javax.swing‭.*;‬
import java.awt.event‭.*;‬
import java.awt‭.*;‬
class CyclomaticComplexity implements ActionListener
‭ {‬
‭      ‬JFrame fr1‭;‬
‭       ‬JLabel lb1‭;‬
‭       ‬TextField tf1‭;‬
‭       ‬int complexity=1‭;‬
‭       ‬String c‭="" +‬complexity‭; ‬
‭       ‬public CyclomaticComplexity‭()‬
‭       {‬
		fr1‭=‬new JFrame‭("‬result‭");‬
‭                ‬fr1‭.‬setLayout(new FlowLayout‭());‬
‭                ‬lb1‭=‬new JLabel‭("‬the number of regions are‭ ");‬
‭                ‬tf1‭=‬new TextField‭();‬
‭                ‬
‭                ‬fr1‭.‬add(lb1‭);‬fr1‭.‬add(tf1‭);‬
‭    ‬		fr1‭.‬setSize(300,300‭);‬
‭  ‬		fr1‭.‬setVisible(true‭);‬
	‭}‬
‭        ‬public void actionPerformed(ActionEvent e‭)‬
		‭{‬
	‭}‬
	
‭    ‬	public int check‭() {‬
		‭//‬int complexity‭ = ‬1‭;‬
		String fileName‭;‬
		String‭[] ‬keywords‭ = {"‬if‭","‬else‭","‬while‭","‬case‭","‬for‭","‬switch‭","‬do‭","‬continue‭","‬break‭","&&","||","?",":","‬catch‭","‬finally‭","‬throw‭","‬throws‭","‬default‭","‬return‭"};‬
		String words‭ = "";‬
		String line‭ = ‬null‭;‬
		try‭ {‬
			fileName‭ = "‬GetFiles.java‭";‬
			FileReader fr‭ = ‬new FileReader(fileName‭);‬
			BufferedReader br‭ = ‬new BufferedReader(fr‭);‬
			line‭ = ‬br.readLine‭();‬
			while‭ (‬line‭ != ‬null‭)‬
			‭{‬
				StringTokenizer stTokenizer‭ = ‬new StringTokenizer(line‭);‬
				while‭ (‬stTokenizer.hasMoreTokens‭())‬
				‭{‬
					words‭ = ‬stTokenizer.nextToken‭();‬
					for(int i=0‭; ‬i<keywords.length‭; ‬i‭++)‬
					‭{‬
						if‭ (‬keywords[i‭].‬equals(words‭))‬
						‭{‬
							complexity‭++;‬
						‭}‬
					‭}‬
				‭}‬
				line‭ = ‬br.readLine‭();‬
			‭}‬
		‭}‬
		catch‭ (‬IOException e‭)‬
		‭{‬
			e.printStackTrace‭();‬
		‭}‬
		return‭ (‬complexity‭);‬
	‭}‬

	public void showCyclomaticComplexity(int ccValue‭) {‬
		System.out.println‭("\‬nThe Number of regions and‭  ‬Cyclomatic Complexity is‭ : "+‬ccValue‭);‬
‭//‬tf1‭.‬setText(c‭);‬		
System.out.print‭("\‬nResult‭ : ");‬
		if‭ (‬ccValue‭> ‬50‭){‬
			System.out.print‭("‬Most complex and highly unstable method‭ ");‬
		‭}‬
		else if(ccValue‭>= ‬21‭ && ‬ccValue‭<=‬50‭)‬
			System.out.print‭("‬High risk‭");‬
		else if(ccValue‭>= ‬11‭ && ‬ccValue‭<=‬20‭)‬
			System.out.print‭("‬Moderate risk‭");‬
		else
			System.out.print‭("‬Low risk program‭");‬
	‭}‬
	‭//‬tf1‭.‬setText(c‭);‬
	public static void main(String ss‭[])‬
	‭{‬
		CyclomaticComplexity cc‭ = ‬new CyclomaticComplexity‭();‬
‭                //‬tf1‭.‬setText(c‭);‬
		cc.showCyclomaticComplexity(cc.check‭());‬
	‭}‬
‭}‬
