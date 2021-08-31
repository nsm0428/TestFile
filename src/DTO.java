import java.io.*;

public class DTO implements Serializable{
	private String name;
	private String StdNum;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStdNum() {
		return StdNum;
	}
	public void setStdNum(String stdNum) {
		StdNum = stdNum;
	}
}
