package pkt;

import java.net.URISyntaxException;
import java.util.Scanner;

import net.sourceforge.jFuzzyLogic.demo.dynamics.Model;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Rule;

public class Test {

	public static void main(String[] args) throws URISyntaxException {
		Scanner in = new Scanner(System.in);
		System.out.print("Sıcaklık: ");
		double sicaklik = in.nextDouble();
		System.out.print("Hacim: ");
		double hacim = in.nextDouble();
		
		Basinc basinc = new Basinc(sicaklik,hacim);
		System.out.println(basinc);
		
		// üyelik fonksıyonlarını cizdirme
		JFuzzyChart.get().chart(basinc.getModel());
		
		// çalışan kuralları gösterme
		for(Rule rule : basinc.getModel().getFunctionBlock("Model").getFuzzyRuleBlock("No1"))
			if(rule.getDegreeOfSupport()>0) {
				System.out.println(rule);
			}
		
		
		//sadece taralı alanı cizdirelim
		JFuzzyChart.get().chart(basinc.getModel().getVariable("basinc").getDefuzzifier(), "Basinc",true);
	}
}
