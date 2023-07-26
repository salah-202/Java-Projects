import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/CalcAgeServlet")
public class CalcAgeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Date birthDate = new SimpleDateFormat("MM-dd-yyyy").parse(req.getParameter("birthdate"));
            Date currentDate = new SimpleDateFormat("MM-dd-yyyy").parse(req.getParameter("currentdate"));

            long time_diff = currentDate.getTime() - birthDate.getTime();

            long hours_diff = (time_diff / (1000 * 60 * 60)) % 24;
            long days_diff = ((time_diff / (1000*60*60*24)) % 365)%30;
            long months_diff = ((time_diff / (1000*60*60*24)) % 365) / 30;
            long years_diff = (time_diff / (1000l*60*60*24*365));

            req.setAttribute("hours",hours_diff);
            req.setAttribute("days",days_diff);
            req.setAttribute("months",months_diff);
            req.setAttribute("years",years_diff);
            RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
            rd.forward(req,resp);

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
