package shared;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Data {

    public List<Book> books;
    public List<Library> libraries;
    public int noDays;

    public Data(List<Book> books, List<Library> libraries, int noDays){
        this.books = books;
        this.libraries = libraries;
        this.noDays = noDays;
    }

    public Data(Data d){

        this.books = new ArrayList<>();
        for(Book b: d.books){
            this.books.add(new Book(b));
        }

        this.libraries = new ArrayList<>();

        for(Library l: d.libraries){
            this.libraries.add(new Library(l));
        }

        this.noDays = d.noDays;

    }

    public Library getLibraryByID(int id){
        for(int i=0; i<libraries.size();i++){
            if(libraries.get(i).id == id){
                return libraries.get(i);
            }
        }
        return null;
    }

    public String toString() { // This toString is a very bad idea with a lot of books and libraries
        String books = "";
        String libraries = "";

        for (int i=0; i < this.books.size(); i++){
            books += "Book " + this.books.get(i).id + " score: " + this.books.get(i).score + "\n";
        }

        for (int i=0; i < this.libraries.size(); i++){
            libraries += "Library " + this.libraries.get(i).id + ": " + this.libraries.get(i).bookNumber + " books, " + this.libraries.get(i).signUpTime
                    + " days to sign up, " + this.libraries.get(i).throughput + " books per day.\nBooks: ";
            for (int j= 0; j< this.libraries.get(i).books.size(); j++){
                libraries += this.libraries.get(i).books.get(j).id + ", ";
            }
            libraries += "\n\n";
        }

        return String.format("BOOKS:\n%s\n\nLIBRARIES:\n%s", books, libraries);
    }
}
