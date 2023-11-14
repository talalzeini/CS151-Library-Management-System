package src.main.library;
/**A list of topics that a book can cover, one book can have multiple topics, or none.*/
public enum Topic {
    POLITICS,
    LOVE,
    WAR,
    PHILOSOPHY,
    STEM;

    public String toString(){
        switch(this){
            case POLITICS: return("Politics");
            case LOVE: return("Love");
            case WAR: return("War");
            case PHILOSOPHY: return "Philosophy";
            case STEM: return("STEM");
            default: return("Invalid Topic");
        }
    }

    

}
