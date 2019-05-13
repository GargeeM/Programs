abstract class Item{
	private String uid;
	private String title;
	private int noOfCopies;

	public Item(){

	}

	public Item(String uid, String title, int noOfCopies){
		
	}

	public void setUID(String uid){
        this.uid = uid;
	}
	public String getUID(){
		return uid;
	}

	public void setTitle(String title){
        this.title = title;
	}
	public String getTitle(){
		return title;
	}

	public void setNoOfCopies(int noOfCopies){
        this.noOfCopies = noOfCopies;
	}
	public int getNoOfCopies(){
		return noOfCopies;
	}
    
    

}

abstract class WrittenItem extends Item{
    private String author;
    public void setAuthor(String author){
    	this.author = author;
    }
    public String getAuthor(){
    	return author;
    }
}

abstract class MediaItem extends Item{
    private int runTime;
    public void setRunTime(int runTime){
    	this.runTime = runTime;
    }
    public int getRunTime(){
    	return runTime;
    }
}

class Book extends WrittenItem{
    public Book(String uid, String title, int noOfCopies){
		super.setUID(uid);
		super.setTitle(title);
		super.setNoOfCopies(noOfCopies);
	}
}

class JournalPaper extends WrittenItem{
    private String yearOfPublication;
    public void setYearOfPublication(String yearOfPublication){
    	this.yearOfPublication = yearOfPublication;
    }
    public String getYearOfPublication(){
    	return yearOfPublication;
    }
}

class Video extends MediaItem{
    private String director;
    private String genre;
    private String releaseYear;

    public void setDirector(String director){
    	this.director = director;
    }
    public String getDirector(){
    	return director;
    }

    public void setGenre(String genre){
    	this.genre = genre;
    }
    public String getGenre(){
    	return genre;
    }

    public void setReleaseYear(String releaseYear){
    	this.releaseYear = releaseYear;
    }
    public String getReleaseYear(){
    	return releaseYear;
    }
}

class CD extends MediaItem{
   private String artist;
   private String genre;

   public void setArtist(String artist){
    	this.artist = artist;
   }
   public String getArtist(){
    	return artist;
   }
   
   public void setGenre(String genre){
    	this.genre = genre;
   }
   public String getGenre(){
    	return genre;
   } 
}

class LibraryDriver{
	public static void main(String[] args) {

		//creating CD object
		CD cd = new CD();
		cd.setArtist("Lady Gaga");
        System.out.println("Artist of CD: " + cd.getArtist());

		//creating JournalPaperObject
        JournalPaper jp = new JournalPaper();
        jp.setYearOfPublication("2008");
        jp.setUID("7890J");
        jp.setTitle("A study on Boson Particle");
        jp.setNoOfCopies(5);
        System.out.println("Year of Publication of Journal: " + jp.getUID());
        System.out.println("UID of Journal: " + jp.getTitle());
        System.out.println("Title of Journal: " + jp.getNoOfCopies());
        System.out.println("No. of copies left: " + jp.getYearOfPublication());
        
        //creating Book object
		Book book = new Book("2345N", "Pride & Prejudice", 7);
		System.out.println("Title of book: " + book.getTitle());
		System.out.println("UID of book: " + book.getUID());
		System.out.println("No. of copies left: " + book.getNoOfCopies());
	}
}