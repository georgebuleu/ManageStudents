import beans.StudentBean;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

public class ReadStudentServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        File file = new File("/home/george/SD/Teme/Tema1_Java8/student.xml");
        // se returneaza un raspuns HTTP de tip 404 in cazul incarenu se gaseste fisierul cu date
        if (!file.exists()) {
            resp.sendError(404, "Nu a fost gasit niciun studentserializat pe disc!");
            return;
        }
        XmlMapper xmlMapper = new XmlMapper();
        StudentBean bean = xmlMapper.readValue(file,
                StudentBean.class);
        req.setAttribute("nume", bean.getName());
        req.setAttribute("prenume", bean.getSurname());
        req.setAttribute("varsta", bean.getAge());
        req.setAttribute("nr-matricol", bean.getId());
        req.setAttribute("an-studiu", bean.getYear());
        req.setAttribute("facultate", bean.getCollege());
// redirectionare date catre pagina de afisare a informatiilorstudentului
        req.getRequestDispatcher("./info-student.jsp").forward(req, resp);

    }
}
