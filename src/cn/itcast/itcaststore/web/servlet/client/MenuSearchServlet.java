package cn.itcast.itcaststore.web.servlet.client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import cn.itcast.itcaststore.domain.PageBean;
import cn.itcast.itcaststore.domain.User;
import cn.itcast.itcaststore.service.ProductService;

/**
 * Servlet implementation class MenuSearchServlet
 */
@WebServlet(name="MenuSearchServlet",urlPatterns="/MenuSearchServlet")
public class MenuSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 1.���嵱ǰҳ�룬Ĭ��Ϊ1
		int currentPage = 1;
		String _currentPage = request.getParameter("currentPage");
		if (_currentPage != null) {
			currentPage = Integer.parseInt(_currentPage);
		}
		// 2.����ÿҳ��ʾ����,Ĭ��Ϊ4
		int currentCount = 4;	
		//��ȡǰ̨ҳ�������������ֵ
		String searchfield = request.getParameter("textfield");
		//�����������û������ֵ��������ݵ�ΪĬ��ֵ����ʱĬ�ϲ�ѯȫ����ƷĿ¼
		if("全部商品".equals(searchfield)){
			request.getRequestDispatcher("/showProductByPage").forward(request, response);
			return;
		}
		
		//��־
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		Logger logger = Logger.getLogger("userlog");
		try{						
			logger.info("[" + user.getId() + "]正在浏览商品");
					
		}catch(Exception e){
			logger.info("错误信息:"+e.toString());
		}		
		
		//����service��ķ�����ͨ������ģ����ѯ��������Ӧ��ͼ��
		ProductService service = new ProductService();
		PageBean bean = service.findBookByName(currentPage,currentCount,searchfield);
		// �����ݴ洢��request��Χ����ת��product_search_list.jspҳ��չʾ
		request.setAttribute("bean", bean);
		request.getRequestDispatcher("/client/product_search_list.jsp").forward(request, response);
	}		

}
