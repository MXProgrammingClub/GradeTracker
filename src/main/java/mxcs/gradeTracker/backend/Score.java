package mxcs.gradeTracker.backend;

public class Score {
	private String category, title,note;
	private Double score,total;
	public Score(String title,String note, String category,Double score,Double total){
		this.category = category;
		this.note = note;
		this.title = title;
		this.score = score;
		this.total = total;
	}
	
	public String getCategory(){return category;}
	
	public String getTitle(){return title;}
	
	public String getNote(){return note;}
	
	public Double getScore(){return score;}
	public Double getTotal(){return total;}
}
