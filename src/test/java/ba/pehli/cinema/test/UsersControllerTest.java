package ba.pehli.cinema.test;

import ba.pehli.cinema.controller.UsersController;
import ba.pehli.cinema.domain.User;
import ba.pehli.cinema.service.UserDao;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.MessageSource;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UsersControllerTest {

    private UsersController userControllerMock;
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

    @Before
    public void setup() {
        userControllerMock = new UsersController();
        modelMock = mock(Model.class);
        bindResultMock = mock(BindingResult.class);
        requestMock = mock(HttpServletRequest.class);
        redirectAttributesMock = mock(RedirectAttributes.class);
        userMock = mock(User.class);
        errorMock = mock(FieldError.class);
        messageSourceMock = mock(MessageSource.class);
        userControllerMock.setMessageSource(messageSourceMock);
        userDaoMock = mock(UserDao.class);
        bindExceptionMock = mock(BindException.class);
    }

    @Test
    public void testShowRegistring() throws Exception{
        String result = userControllerMock.showRegistring(modelMock);
        assertEquals(result, "users/register");
    }

    @Test
    public void testRegister() throws Exception{
        //Test result if Bindingresult has errors
        when(bindResultMock.hasErrors()).thenReturn(true);
        String resultBindingErrors = userControllerMock.register(userMock, bindResultMock, modelMock, requestMock, redirectAttributesMock, localeMock);
        assertEquals(resultBindingErrors, "users/register");
        //Test result if Bindingresult has NO errors
        when(bindResultMock.hasErrors()).thenReturn(false);
        String resultNoBindingErrors = userControllerMock.register(userMock, bindResultMock, modelMock, requestMock, redirectAttributesMock, localeMock);
        assertEquals(resultNoBindingErrors, "redirect:/users/register");

    }

    @Test
    public void testLoginFail() throws Exception{
        String result = userControllerMock.loginFail(modelMock, redirectAttributesMock, localeMock);
        assertEquals(result, "redirect:/movies");
    }

}