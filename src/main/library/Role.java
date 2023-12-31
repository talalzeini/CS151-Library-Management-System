package src.main.library;
/**A list of topics that a book can cover, one book can have multiple topics, or none.*/
public enum Role {
    MEMBER,
    LIBRARIAN,
    AUTHOR;

    //toString method to convert enum into a string
    public String toString(){
        switch(this){
            case MEMBER: return("member");
            case LIBRARIAN: return("librarian");
            case AUTHOR: return("author");
            default: return("member");
        }
    }



}
