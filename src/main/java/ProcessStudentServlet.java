import beans.StudentBean;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.time.Year;

public class ProcessStudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String name = req.getParameter("nume");
       String surname = req.getParameter("prenume");
       int age = Integer.parseInt(req.getParameter("varsta"));
       String college = req.getParameter("facultate");
       int year = Integer.parseInt(req.getParameter("an-studiu"));
       int id = Integer.parseInt(req.getParameter("nr-matricol"));
       int currentYear = Year.now().getValue();
       int birthYear = currentYear - age;


       // initializare serializator Jackson
       XmlMapper mapper = new XmlMapper();

       // creare bean si populare cu date
       StudentBean bean = new StudentBean();
       bean.setName(name);
       bean.setSurname(surname);
       bean.setAge(age);
       bean.setId(id);
       bean.setCollege(college);
       bean.setYear(year);

       // serializare bean sub forma de string XML
       mapper.writeValue(new File("/home/george/SD/Teme/Tema1_Java8/student.xml"), bean);


       req.setAttribute("nume", name);
       req.setAttribute("prenume", surname);
       req.setAttribute("varsta", age);
       req.setAttribute("anNastere", birthYear);
       req.setAttribute("nr-matricol", id);
       req.setAttribute("an-studiu", year);
       req.setAttribute("facultate", college);

       req.getRequestDispatcher("./info-student.jsp").forward(req, resp);
    }
}
