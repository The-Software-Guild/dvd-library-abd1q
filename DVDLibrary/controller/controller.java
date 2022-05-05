import java.util.List;
import java.util.Map;

public class controller {

    private userIO io = new userIOimpl();
    private dvdDao dao = new dvdDaoimpl();
    private view   show = new view();
    private dvdDaoimpl newdao = new dvdDaoimpl();


    public void run(){

       boolean loop = true;
       int choice = 0; // variable to choose item for view.
       
            while(loop){
            
                    io.print("1. Add DVD");
                    io.print("2. Remove DVD");
                    io.print("3. Edit DVD information ");
                    io.print("4. List DVDs in collection");
                    io.print("5. Display information for DVD");
                    io.print("6. Search for DVD by title");
                    io.print("7. Load DVDs from file");
                    io.print("8. Save DVDs to file");
                    io.print("9. Add, edit, and delete many DVDs");
                    io.print("10. Exit");

        try{            choice = io.readInt("Please select from the"
                    + " above choices:", 1, 10);
                    switch(choice){
                        case 1:
                            io.print("Add DVD to the collection");
                            createDvd();
                            break;
                        case 2:
                            io.print("Remove Dvd from the collection");
                            removeDvd();
                            break;
                        case 3:
                            io.print("Edit information for existing Dvd");
                            editDvd();
                            break;
                        case 4:
                            io.print("List Dvds in the collection");
                            listDvds();
                            break;
                        case 5:
                            io.print("Show info about a Dvd");
                            showDvd();
                            break;
                        case 6:
                            io.print("Search Dvd by title");
                            searchDvd();
                            break;
                        case 7:
                            io.print("Load Dvd from file");
                            loadDvds();
                            break;
                        case 8:
                            io.print("Save Dvd to file");
                            saveDvds();
                            break;
                        case 9:
                            io.print("Add, edit, and delete many Dvds");
                            loop = true; // contain looping to allow changes to dvds
                            break;
                        case 10:
                            loop = false;
                            saveDvds();
                            break;
                        default:
                            io.print("unknown command");
                        }
                        
         } catch (dvdDaoexception e){
             show.displayErrorMessage(e.getMessage());}
       }
    }
    

    private void createDvd()     
    throws dvdDaoexception{// method to create new dvd entry
        show.createDvdbanner();
        dvd newDvd = show.getDvdinfo();
        dao.addDvd(newDvd.getTitle(), newDvd);
        show.dvdBannercreated();
    }

    private void editDvd()     
    throws dvdDaoexception{// method to create new dvd entry
        io.print("=== edit Dvd by entering title of dvd to edit ===");
        Map<String, dvd> dvdlib = dvdDaoimpl.dvdcollection;
    
        String title = io.readString("Please enter the Dvd title.");
        while(dvdlib.containsKey(title) ){
            dvd newDvd = show.getDvdinfo();
            dao.addDvd(newDvd.getTitle(), newDvd);
            io.print("=== Dvd edited or updated ===");
            io.readString("Please hit enter to continue.");
            
         }  
        io.print("Dvd not found");
    }

    private void listDvds() 
    throws dvdDaoexception{ // method to list all dvds in collection
        show.displayDvdbanner();
        List<dvd> dvdList = dao.getAlldvds();
        show.displayDvdlist(dvdList);
    }

    private void showDvd() 
    throws dvdDaoexception{ // method to show info about dvd
        show.showDvdbanner();
        String title = io.readString("Please enter the Dvd title.");
        dvd showdvd = newdao.getDvd(title);
        show.displayDvd(showdvd);
    }
   
    private void searchDvd() 
    throws dvdDaoexception{ // method to search for dvd by title
        io.print("=== search for Dvd by title ===");
        String title = io.readString("Please enter the Dvd title.");
        dvd searchdvd = newdao.getDvd(title);
        show.displayDvd(searchdvd);
    }

    private void removeDvd()
    throws dvdDaoexception { // method to remove dvd by title
        io.print("=== remove Dvd ===");
        String title = io.readString("Please enter the Dvd title.");
        dvd removedvd = dao.removeDvd(title);
        show.displayDvdremove(removedvd);
    }

    private void loadDvds() 
    throws dvdDaoexception{ 
        io.print("=== load Dvds from file ===");
        newdao. loadRoster();
        io.print("load from file roster.txt");
    }

    private void saveDvds() 
    throws dvdDaoexception{ 
        io.print("=== save Dvds to file ===");
        newdao. writeRoster();
        io.print("saved to file roster.txt");
    }


}

