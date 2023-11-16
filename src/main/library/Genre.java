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

    public static Genre getGenre(String str){
        if (str.contains("fantasy")){
            return Genre.FANTASY;
        } else if (str.contains("thriller")){
            return Genre.THRILLER;
        } else if (str.contains("action and adventure")) {
            return Genre.ACTION_AND_ADVENTURE;
        } else if (str.contains("mystery")){
            return Genre.MYSTERY;
        } else if (str.contains("science fiction")){
            return Genre.SCIENCE_FICTION;
        } else if (str.contains("nonfiction")){
            return Genre.NONFICTION;
        } else if (str.contains("graphic novel")){
            return Genre.GRAPHIC_NOVEL;
        } else if (str.contains("romance")){
            return Genre.ROMANCE;
        }
        return null;
    }
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
