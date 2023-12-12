import java.io.IOException;
import java.util.ArrayList;

public class WebPage
{
	public String url;
	public WordCounter counter;
	public double score;

	public WebPage(String url)
	{
		this.url = url;
		this.counter = new WordCounter(url);
	}

	public void setScore(ArrayList<Keyword> keywords) throws IOException
	{
		score = 0;
		for(Keyword keyword: keywords) {
			int times = counter.countKeyword(keyword.name);
			score += keyword.weight * times;
		}
	}
}