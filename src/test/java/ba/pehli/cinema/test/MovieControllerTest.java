package ba.pehli.cinema.test;

import ba.pehli.cinema.controller.MovieController;
import ba.pehli.cinema.domain.Movie;
import ba.pehli.cinema.domain.User;
import ba.pehli.cinema.service.MovieDao;
import ba.pehli.cinema.service.MovieDaoImpl;
import ba.pehli.cinema.service.RatingDao;
import ba.pehli.cinema.service.UserDao;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


public class MovieControllerTest{
    //Controller
    @Autowired
    private MovieController movieControllerMock;

    //Dao'sdirector and other classes
    private MovieDao movieDaoMock;
    private MovieDaoImpl movieDaoImplMock;
    private RatingDao ratingDaoMock;

    //Models / objects
    private Movie movieMock1;
    private Movie movieMock2;
    private User userMock1;
    private User userMock2;

    //Else
    private Model modelMock;
    private BindingResult bindResultMock;
    private HttpServletRequest requestMock;
    private RedirectAttributes redirectAttributesMock;
    private Locale localeMock;
    private User userMock;
    private FieldError errorMock;
    private MessageSource messageSourceMock;
    private UserDao userDaoMock;
    private BindException bindExceptionMock;
    private MultipartFile MultipartFileMock;
    private MockMvc mockMvc;
    private HttpsURLConnection fileUrlMock;


    @Before
    public void setupMock(){
        movieDaoMock = mock(MovieDao.class);
        userDaoMock = mock(UserDao.class);
        ratingDaoMock = mock(RatingDao.class);
        movieControllerMock = new MovieController(movieDaoMock, userDaoMock, ratingDaoMock);
        modelMock = mock(Model.class);
        bindResultMock = mock(BindingResult.class);
        requestMock = mock(HttpServletRequest.class);
        fileUrlMock = mock (HttpsURLConnection.class);
        redirectAttributesMock = mock(RedirectAttributes.class);
        userMock = mock(User.class);
        errorMock = mock(FieldError.class);
        messageSourceMock = mock(MessageSource.class);
        bindExceptionMock = mock(BindException.class);
        MultipartFileMock = mock(MultipartFile.class);
        movieDaoImplMock = mock(MovieDaoImpl.class);

        movieMock1 = mock(Movie.class);
        movieMock2 = mock(Movie.class);
        modelMock = mock(Model.class);
        userMock1 = mock(User.class);
        userMock2 = mock(User.class);

        //Movie 1
        movieMock1.setId(1);

        //Movie 2
        movieMock2.setId(2);

        //Movies
        List<Movie> movies = new ArrayList<Movie>();
        movies.add(movieMock1);
        movies.add(movieMock2);

        //User 1
        userMock1.setId(1);
        userMock1.setUsername("username1");

        //User 2
        userMock2.setId(2);
        userMock2.setUsername("username1");

    }

    @Test
    public void testShowPage() {
        int id = 1;
        int size = 5;
        System.out.println("Calling MovieController.showPage(" + id + ", modelMock)");
        String result = movieControllerMock.showPage(id, modelMock);
        assertEquals(result, "movies/list");

        System.out.println("Verifying the order of method invocation that showPage() makes on MovieDao");
        InOrder order = inOrder(movieDaoMock, userDaoMock, ratingDaoMock);
        order.verify(userDaoMock, atLeast(1)).getAuthenticatedUser();
        order.verify(movieDaoMock).findAll(id, size);

    }

    @Test
    public void testShowEdit() throws Exception{
        String result = movieControllerMock.showEdit(1, modelMock);
        assertEquals(result, "movies/edit");
    }

    @Test
    public void testShowNew() throws Exception{

        String result = movieControllerMock.showNew(modelMock);
        assertEquals(result, "movies/edit");
    }


    @Test
    public void testNewMovie() throws Exception{
       //Test result if Bindingresult has NO errors

       /** when(bindResultMock.hasErrors()).thenReturn(true);
        String resultBindingErrors = movieControllerMock.newMovie(movieMock1, bindResultMock, modelMock, requestMock,
                redirectAttributesMock, localeMock, MultipartFileMock,"Null");
        assertEquals(resultBindingErrors, null); */

       String resultBindingErrors = messageSourceMock.getMessage("movies.edit.error", null, localeMock);
        assertEquals(resultBindingErrors, null);

        //Check if method save() returns the movie it was passed.
        when(movieDaoMock.save(movieMock1)).thenReturn(movieMock1);
        assertEquals(movieMock1, movieDaoMock.save(movieMock1));
    }

   	@Test
	public void testEdit() {
        //Check if method save() returns the movie it was passed.
        when(movieDaoMock.save(movieMock2)).thenReturn(movieMock2);
        assertEquals(movieMock2, movieDaoMock.save(movieMock2));


    }


}