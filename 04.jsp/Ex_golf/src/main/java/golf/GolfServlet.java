package golf;

import golf.dao.GolfDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/golf")
public class GolfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final GolfDAO dao = new GolfDAO();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		if (action == null) {
			action = "home";
		}

		String path = "/index.jsp";

		switch (action) {
			case "teacher":
				try {
					req.setAttribute("teacherList", dao.getTeacherList());
				} catch (Exception e) {
					req.setAttribute("errorMsg", e.getMessage());
				}
				path = "/views/teacher.jsp";
				break;
			case "insert":
				path = "/views/insert.jsp";
				break;
			case "member":
				try {
					req.setAttribute("memberList", dao.getMemberList());
				} catch (Exception e) {
					req.setAttribute("errorMsg", e.getMessage());
				}
				path = "/views/member.jsp";
				break;
			case "result":
				path = "/views/result.jsp";
				break;
			case "home":
			default:
				path = "/index.jsp";
				break;
		}

		req.getRequestDispatcher(path).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		doGet(req, resp);
	}
}
