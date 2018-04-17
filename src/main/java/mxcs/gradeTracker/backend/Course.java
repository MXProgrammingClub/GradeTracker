package mxcs.gradeTracker.backend;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Course {		//Represents a course
	private String name;
	private boolean points;
	private Map<String,Double> weights;
	private List<Score> scores;
	private Double examScore;
	public Course(String name, Map<String,Double> weights, boolean points){
		examScore = null;
		this.name = name;
		this.weights = weights;
		this.points = points;
		scores = new LinkedList<Score>();
		
	}
	public void examScore(double score){
		examScore=score;
	}
	public double getGrade(){
		
		if(points){
			double grade = 0, total = 0;
			for(Score score:scores){
				grade+=score.getScore();
				total+=score.getTotal();
			}
			return (examScore==null)?grade/total:.75*grade/total+.25*examScore;
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
		return (examScore==null)?totgrade:.75*totgrade+.25*examScore;
	}
}
