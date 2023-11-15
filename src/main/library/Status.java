package src.main.library;

/** Describes different states a book can be in at different times. */
public enum Status {
    CHECKED_IN,
    CHECKED_OUT;

    public Boolean toBoolean(){
        switch(this){
            case CHECKED_IN: return(true); // book is available
            case CHECKED_OUT: return(false); // book is not available
            default: return(null);
        }
    }
}