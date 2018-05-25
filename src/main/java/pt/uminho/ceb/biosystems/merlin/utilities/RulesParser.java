package pt.uminho.ceb.biosystems.merlin.utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import pt.uminho.ceb.biosystems.mew.utilities.datastructures.pair.Pair;

public class RulesParser {

	
	/**
	 * @param genes
	 * @param concatenate
	 * @return
	 */
	public static String processReactionGenes(Set<Pair<String,String>> genes, boolean concatenate) {

		String geneData = "";
		if(genes!=null) {

			for(Pair<String,String> gene:genes){
				if(gene!=null){
					geneData=geneData.concat(gene.getA());
					
					if(concatenate && gene.getB()!=null && !gene.getB().isEmpty())
						geneData=geneData.concat("_").concat(gene.getB());
				}
				geneData=geneData.concat(" or ");
			}	
			geneData=geneData.substring(0, geneData.lastIndexOf(" or "));
		}
		
		return geneData;
	}
	
	/**
	 * Get gene rule from raw data.
	 * 
	 * @param rawData
	 * @param genes
	 * @return
	 */
	public static String getGeneRule(String rawData, Map<Integer, Pair<String, String>> genes) {
		
		return RulesParser.getRules2String(RulesParser.parseGeneRules(rawData, genes));
	}

	/**
	 * Parse gene rules from database;
	 * 
	 * @param rawData
	 * @param genes
	 * @return
	 */
	public static List<List<Pair<String, String>>> parseGeneRules(String rawData, Map<Integer, Pair<String, String>> genes) {

		List<List<Pair<String, String>>> res = new ArrayList<>();

		String [] rules = rawData.split(" OR ");
		
		for(String rule : rules) {
		
			String [] ids = rule.split(" AND ");
			
			List<Pair<String, String>> pairList= new ArrayList<>();
			
			for(String idString : ids) {
				
				pairList.add(genes.get(Integer.parseInt(idString)));
			}
			res.add(pairList);
		}
		
		return res;
	}
	
	/**
	 * reverse parse gene rules from database;
	 * 
	 * @param rawData
	 * @param genes
	 * @return
	 */
	public static String reverseParseGeneRules(String processedData, Map<String, Integer> genes) {

		List<List<Pair<String, String>>> res = new ArrayList<>();

		String [] rules = processedData.split(" OR ");
		
		for(String rule : rules) {
		
			String [] ids = rule.split(" AND ");
			
			List<Pair<String, String>> pairList= new ArrayList<>();
			
			for(String idString : ids) {
				
				int data = genes.get(idString.trim());
				
				pairList.add(new Pair<String, String>(String.valueOf(data),""));
			}
			res.add(pairList);
		}
		
		return RulesParser.getRules2String(res);
	}

	/**
	 * Get list of OR rules to list
	 * 
	 * @param geneRules
	 * @return
	 */
	public static List<String> getAND_geneRulesList2List(List<List<Pair<String, String>>> geneRules) {

		List<String> resultsList = new ArrayList<>();
		
		for(List<Pair<String, String>> geneRule : geneRules) {

			String rule = null;
			for(Pair<String, String> gene : geneRule) {

				if(rule == null)
					rule = "";
				else
					rule = rule.concat(" AND ");

				rule = rule.concat(gene.getA());

				if(gene.getB() != null && !gene.getB().trim().isEmpty())
					rule = rule.concat(" (").concat(gene.getB()).concat(")");

			}
			resultsList.add(rule);					
		}
		return resultsList;
	}

	/**
	 * * Get list of AND gene rules 2 String
	 * 
	 * @param genesRule
	 * @return
	 */
	public static String getOR_geneRulesList2String(List<String> genesRule) {

		String rule = null;

		for(String genes : genesRule) {

			if(rule == null)
				rule = "";
			else
				rule = rule.concat(" OR ");

			rule = rule.concat(genes);
		}
		return rule;
	}
	
	/**
	 * Get geneRules 2 String
	 * 
	 * @param geneRules
	 * @return
	 */
	public static String getRules2String(List<List<Pair<String, String>>> geneRules) {
		
		return RulesParser.getOR_geneRulesList2String(RulesParser.getAND_geneRulesList2List(geneRules));
	}

}
