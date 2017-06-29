package ba.pehli.cinema.controller;

import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.validation.Valid;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DeviceUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ba.pehli.cinema.domain.Movie;
import ba.pehli.cinema.domain.Rating;
import ba.pehli.cinema.domain.User;
import ba.pehli.cinema.domain.WSOmdbMovie;
import ba.pehli.cinema.service.MovieDao;
import ba.pehli.cinema.service.RatingDao;
import ba.pehli.cinema.service.UserDao;
import ba.pehli.cinema.utils.EmailUtils;
import static org.junit.Assert.*;

/**
 * Created by rbreekveldt on 28-6-17.
 */
public class MovieControllerTest {
    @Test
    public void list() throws Exception {
           }

    @Test
    public void showPage() throws Exception {
    }

    @Test
    public void downloadImage() throws Exception {
    }

    @Test
    public void showEdit() throws Exception {
    }

    @Test
    public void showNew() throws Exception {
    }

    @Test
    public void edit() throws Exception {
    }

    @Test
    public void newMovie() throws Exception {
    }

    @Test
    public void rateMovie() throws Exception {
    }

    @Test
    public void generateCatalog() throws Exception {
    }

    @Test
    public void getInfo() throws Exception {
    }

    @Test
    public void connectToFacebook() throws Exception {
    }

    @Test
    public void initBinder() throws Exception {
    }

    @Test
    public void setMessageSource() throws Exception {
    }

    @Test
    public void setEmailUtils() throws Exception {
    }

    @Test
    public void setDataSource() throws Exception {
    }

    @Test
    public void setRestTemplate() throws Exception {
    }

    @Test
    public void setFacebook() throws Exception {
    }

}