import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Servlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        print(response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        print(response);
    }

    @Override
    protected void doHead(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        print(response);

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        print(response);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        print(response);
    }

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        print(response);
    }

    @Override
    protected void doTrace(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        print(response);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        print(response);
    }

    private static  void print(HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();

        writer.println("<html>");
        writer.println("<h1>Hello world!</h1>");
        writer.println("</html>");
    }
}
