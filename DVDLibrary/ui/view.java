import java.util.List;

public class view {

    private userIO io = new userIOimpl(); // local varibale to use io implemntation.
    private dvd currentDvd = new dvd();// variable to utilise dvd class

    public dvd getDvdinfo() {
        String title = io.readString("Please enter Dvd title: ");
        String releasedate = io.readString("Please enter Dvd release date: ");
        String mpaarating = io.readString("Please enter Dvd MPAA rating: ");
        String directorname = io.readString("Please enter the director name: ");
        String studio = io.readString("Please enter the studio name: ");
        String userrating = io.readString("Please enter Dvd user rating: ");

        currentDvd.setTitle(title);
        currentDvd.setReleasedate(releasedate);
        currentDvd.setMpaarating(mpaarating);
        currentDvd.setDirectorname(directorname);
        currentDvd.setStudio(studio);
        currentDvd.setUserrating(userrating);
        return currentDvd;
}
 
public void dvdInfo(dvd currentdDvd){

    io.print(":: title: "+ currentdDvd.getTitle());
    io.print(":: release date: "+ currentdDvd.getReleasedate());
    io.print(":: mpaa rating: "+ currentdDvd.getMpaarating());
    io.print(":: director: "+ currentdDvd.getDirectorname());
    io.print(":: studio: "+ currentdDvd.getStudio());
    io.print(":: user rating: "+ currentdDvd.getUserrating());
}

public void displayDvdlist(List<dvd> dvdList) {
    for (dvd currentDvd : dvdList) {

        io.print("Dvd title: "+ currentDvd.getTitle() + 
        ":: Dvd release date: " + currentDvd.getReleasedate());
    }
    io.readString("Please hit enter to continue.");
}

public void displayDvd(dvd dvdinput) {
    if (dvdinput != null) {
        dvdInfo(dvdinput);
    }else {
        io.print("No Dvd found!");
    }
    io.readString("Please hit enter to continue.");
}

public void displayDvdremove(dvd dvdinput) {
    if (dvdinput != null) {

        io.print("dvd successfully removed. ");
    }else {
        io.print("No Dvd found!");
    }
    io.readString("Please hit enter to continue.");
}

public void createDvdbanner() {
    io.print("=== Create Dvd ===");// creates banner to create dvd.
}

public void dvdBannercreated() {
    io.readString(
            "Dvd successfully created.  Please hit enter to continue");// creates banner if successfull in dvd creation.
}

public void displayDvdbanner() {
    io.print("=== Display Dvd list ===");// creates banner to display all dvds.
}

public void showDvdbanner() {
    io.print("=== Display Dvd ===");// creates banner to display single dvd.
}

public void displayErrorMessage(String errorMsg) {
    io.print("=== ERROR ===");
    io.print(errorMsg);
}
}
