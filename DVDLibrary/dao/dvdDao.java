import java.util.List;

public interface dvdDao {
 
    dvd addDvd(String title, dvd dvd) throws dvdDaoexception;

    /**
     * Returns a List of all dvds in the roster.
     *
     * @return List containing all dvds in the roster.
     * @throws dvdDaoexception
     */
    List<dvd> getAlldvds() throws dvdDaoexception;

    /**
     * Returns the dvd object associated with the given dvd id.
     * Returns null if no such dvd exists
     *
     * @param dvdId ID of the dvd to retrieve
     * @return the dvd object associated with the given dvd id,  
     * null if no such dvd exists
     * @throws dvdDaoexception
     */
    dvd getDvd(String title) throws dvdDaoexception;

    /**
     * Removes from the roster the dvd associated with the given id.
     * Returns the dvd object that is being removed or null if
     * there is no dvd associated with the given id
     *
     * @param dvdId id of dvd to be removed
     * @return dvd object that was removed or null if no dvd
     * was associated with the given dvd id
     * @throws dvdDaoexception
     */
    dvd removeDvd(String title) throws dvdDaoexception;

}
