package jm.media;

public class DataToCase {
	
	public String a(){
		return String.valueOf(super.hashCode());
	}

	public static void main(String[] args) {
		DataToCase dt = new DataToCase();
		System.out.println(dt);

	}

}
