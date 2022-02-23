package facades;

import dtos.MovieDTO;
import entities.Movie;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

//import errorhandling.RenameMeNotFoundException;
import utils.EMF_Creator;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class MovieFacade {

    private static MovieFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private MovieFacade() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static MovieFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new MovieFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public MovieDTO create(MovieDTO movieDTO){
        Movie movie = new Movie(movieDTO.getYear(),movieDTO.getTitle(),movieDTO.getActors());
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(movie);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new MovieDTO(movie);
    }
    public MovieDTO getById(long id) { //throws RenameMeNotFoundException {
        EntityManager em = emf.createEntityManager();
        Movie movie = em.find(Movie.class, id);
//        if (rm == null)
//            throw new RenameMeNotFoundException("The RenameMe entity with ID: "+id+" Was not found");
        return new MovieDTO(movie);
    }

    public List<MovieDTO> getAll(){
        EntityManager em = emf.createEntityManager();
        TypedQuery<Movie> query = em.createQuery("SELECT m FROM Movie m", Movie.class);
        List<Movie> movies = query.getResultList();
        return MovieDTO.getDtos(movies);
    }
    
    public static void main(String[] args) {
        emf = EMF_Creator.createEntityManagerFactory();
        MovieFacade fe = getFacadeExample(emf);
        fe.getAll().forEach(dto->System.out.println(dto));
    }

}
