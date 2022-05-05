
import java.util.*;
import java.io.*;

public class dvdDaoimpl implements dvdDao {
    public static Map<String, dvd> dvdcollection = new HashMap<>(); // hashmap to store dvd collection. 
    public static final String ROSTER_FILE = "roster.txt";
    public static final String DELIMITER = "::";

    @Override
    public dvd addDvd(String title ,dvd dvd)
            throws dvdDaoexception 
    {
        loadRoster();
        dvd newdvd = dvdcollection.put(title, dvd);
        writeRoster();
    
     return newdvd;
    }

    @Override
    public List<dvd> getAlldvds()         
    throws dvdDaoexception 
    {
        loadRoster();
        return new ArrayList<>(dvdcollection.values());
    }
    
    @Override
    public dvd getDvd(String title)         
    throws dvdDaoexception 
    {
        loadRoster();
        dvd receivedDvd = dvdcollection.get(title);
        return receivedDvd;
    }

    @Override
    public dvd removeDvd(String title)
            throws dvdDaoexception 
    {
        loadRoster();
        dvd removedDvd = dvdcollection.remove(title);
        writeRoster();
        return removedDvd;    
    }
    

    public dvd unmarshallDvd(String dvdtext){
        String[]  currentTokens = dvdtext.split(DELIMITER);
        dvd currentDvd = new dvd();

        if (currentTokens.length>1){
            currentDvd.setTitle(currentTokens[0]);
            currentDvd.setReleasedate(currentTokens[1]);
            currentDvd.setMpaarating(currentTokens[2]);
            currentDvd.setDirectorname(currentTokens[3]);
            currentDvd.setStudio(currentTokens[4]);
            currentDvd.setUserrating(currentTokens[5]);
        }
        return currentDvd;
        
    }
    
    public void loadRoster() throws dvdDaoexception {
        Scanner scanner;
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(ROSTER_FILE)));
        } catch (FileNotFoundException e) {
            throw new dvdDaoexception("-_- Could not load Dvd data.", e);
        }
        String currentLine;
        dvd currentdvd;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentdvd = unmarshallDvd(currentLine);
            dvdcollection.put(currentdvd.getTitle(), currentdvd);
        }
        scanner.close();

    }

    public String marshallDvd(dvd currentDvd){
        String dvdtext = (currentDvd.getTitle() + DELIMITER
        + currentDvd.getReleasedate() + DELIMITER
        + currentDvd.getMpaarating() + DELIMITER
        + currentDvd.getDirectorname() + DELIMITER
        + currentDvd.getStudio() + DELIMITER
        + currentDvd.getUserrating() + DELIMITER);
        
        return dvdtext;
    }

    public void writeRoster() throws dvdDaoexception {
        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        } catch (IOException e) {
            throw new dvdDaoexception(
                    "Could not save DVD data.", e);
        }
        List<dvd> dvdList = this.getAlldvds();
        for (dvd currentDvd : dvdList) {
            out.println(marshallDvd(currentDvd));
            out.flush();
        }
        out.close();// close printwriter
    }

}