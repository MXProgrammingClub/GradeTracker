package mxcs.gradeTracker.backend;

import java.util.List;
import java.util.Map;

public class Course {		//Represents a course
	private String name;
	private boolean points;
	private Map<String,Double> weights;
	private List<Score> scores;
	
	
	public double getGrade(){
		
		if(points){
			double grade = 0, total = 0;
			for(Score score:scores){
				grade+=score.getScore();
				total+=score.getTotal();
			}
			return grade/total;
		}
		//Find score in each cat, weight by tot
		double totgrade = 0;
		for(String category: weights.keySet()){
			double grade = 0, total = 0;
			for(Score score:scores){
				if(score.getCategory().equals(category)){
					grade+=score.getScore();
					total+=score.getTotal();
				}
			}
			totgrade+=weights.get(category)*(grade/total);
		}
		return totgrade;
	}
}
