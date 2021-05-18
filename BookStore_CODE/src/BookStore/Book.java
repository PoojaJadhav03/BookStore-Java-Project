package BookStore;

import java.util.ArrayList;

public class Book 
{
	  String bookName,authorName,lang;
      static int total_books;
      int book_id,qty;
      double bookPrice;
      // public static final String free = "Free";
      //public static final String paid =  "Paid";
      
      ArrayList<Book>books = new ArrayList<Book>();

      Book()
      {
    	  
      }
      
      public String toString(){
          return "Id: " + book_id + "\nBook Title: " + bookName + "\nAuthor Name: "+authorName+  "\nPrice:" + bookPrice + "\n Language  :  " +lang +"\nBook-Available: " + qty + "\n";
	}
	Book(int id,String book,String author,double price,String lang,int quantity){
		this.book_id = id;
		this.bookName = book;
		this.authorName = author;
	//	this.publisherName = pub;
		this.bookPrice = price;
		this.qty =  quantity;
	    this.lang=lang;
		total_books=total_books+1;
		
	}
	
	
	public void setName(String name) {
		bookName = name;
	}
	public void setAutName(String name) {
		authorName = name;
	}
	/*public void setPubName(String name) {
	   publisherName = name;
	}*/
	/*public void setLang(String lang) {
		language = lang;
	}*/
	public void setPrice(double price) {
		bookPrice = price;
	}
	
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getId() {
		return book_id;
	}
	public String getBookName() {
		return bookName;
	}
	public String getAuthorName() {
		return authorName;
	}
	/*public String getPubName() {
		return publisherName;
	}*/
	public String getLang()
	{
		showLang();
		return lang;
	} 
	public void setLang(String la)
	{
		this. lang = la;
	}
	public double getBookPrice() {
		return bookPrice;
	}
	public int getQty() {
		return qty;
	}
	public void addQty(int count) {
		qty+=count;
	}
	public int decQty(int count)
	{
		return qty = qty-count;
		// return qty;
	}
	
	
	public void showLang()
	{
		int i ;
		for(i=0;i<books.size();i++)
		{
		 books.get(i).getLang();
			
		}
		
		
	}
	
 
}
