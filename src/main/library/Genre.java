package src.main.library;
/**The genre of a book. A book must have at least one genre. */
public enum Genre {
    FANTASY,
    NARRATIVE,
    THRILLER,
    ACTION_AND_ADVENTURE,
    MYSTERY,
    SCIENCE_FICTION,
    NONFICTION,
    GRAPHIC_NOVEL,
    ROMANCE;

    public String toString(){
        switch(this){
            case FANTASY: return("Fantasy");
            case NARRATIVE: return("Narrative");
            case THRILLER: return("Thriller");
            case ACTION_AND_ADVENTURE: return("Action and Adventure");
            case MYSTERY: return("Mystery");
            case SCIENCE_FICTION: return "Science Fiction";
            case NONFICTION: return("Nonfiction");
            case GRAPHIC_NOVEL: return("Graphic Novel");
            case ROMANCE: return("Romance");
            default: return("Invalid Genre");
        }
    }
}
