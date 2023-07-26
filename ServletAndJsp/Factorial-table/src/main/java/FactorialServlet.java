import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/FactorialServlet")
public class FactorialServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int num = 0;
        int fact = 1;

        ArrayList<Integer> nums = new ArrayList<Integer>();
        ArrayList<Integer> facts = new ArrayList<Integer>();

        nums.add(num);
        facts.add(fact);

        while (num < 10) {
            num++;
            fact *= num;

            nums.add(num);
            facts.add(fact);
        }

        request.setAttribute("Numbers",nums);
        request.setAttribute("Factorials",facts);

        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request,response);

    }
}

