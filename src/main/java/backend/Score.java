package backend;

public class Score {
	private String category, title,note;
	private Double score;
	public Score(String title,String note, String category,Double score){
		this.category = category;
		this.note = note;
		this.title = title;
		this.score = score;
	}
	
	public String getCategory(){return category;}
	
	public String getTitle(){return title;}
	
	public String getNote(){return note;}
	
	public Double updateScore(){return score;}
}
