package control;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.ProductBean;
import model.ProductModelDS;


import com.google.gson.Gson;





/**
 * Servlet implementation class ProductControl
 */
@MultipartConfig
public class ProductControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

		
	
	static ProductModelDS model=new ProductModelDS();
	

	public ProductControl() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String action = request.getParameter("action");

		
		try {
			if (action != null) {
				
				
				
				  if (action.equalsIgnoreCase("read")) {
					int id = Integer.parseInt(request.getParameter("id"));
					request.removeAttribute("product");
					request.setAttribute("product", model.doRetrieveByKey(id));
				  }	
				  
				  else if (action.equalsIgnoreCase("delete")) {
				  		int id = Integer.parseInt(request.getParameter("id"));
				  		model.doDelete(id);
				  }
				  
				  else if (action.equalsIgnoreCase("insert")) {
					  	int codice =  Integer.parseInt(request.getParameter("codice"));
						String nome = request.getParameter("nome");
						double prezzo = Double.parseDouble(request.getParameter("prezzo"));
						String description = request.getParameter("descrizione");
						float gradazione = Float.parseFloat(request.getParameter("gradazione"));
						String tipo = request.getParameter("tipo");
						int capienza=Integer.parseInt(request.getParameter("capienza"));
						
						
						Part file=request.getPart("img");
						
						String imageFileName=file.getSubmittedFileName();
						
						
						String uploadPath="C:/Users/matte/git/repository/BurnHouse/WebContent/Immagini/"+imageFileName;
						
					
						
						
						try {
							FileOutputStream fos = new FileOutputStream(uploadPath);
							InputStream is = file.getInputStream();

							byte[] data = new byte[is.available()];
							int bytesRead;
							while ((bytesRead = is.read(data)) != -1) {
							    fos.write(data, 0, bytesRead);
							}
							fos.close();

							}
							catch(Exception e){
								response.sendRedirect("GeneralError");
							}
						
						ProductBean bean = new ProductBean();
						bean.setCode(codice);
						bean.setName(nome);
						bean.setPrice(prezzo);
						bean.setDescription(description);
						bean.setDegree(gradazione);
						bean.setType(tipo);
						bean.setImg(imageFileName);
						bean.setCapacity(capienza);
						model.doSave(bean);
					}
				  
				  else if(action.equalsIgnoreCase("modify")) {
					  	int id = Integer.parseInt(request.getParameter("id"));
					  	int codice =  Integer.parseInt(request.getParameter("codice"));
						String nome = request.getParameter("nome");
						double prezzo = Double.parseDouble(request.getParameter("prezzo"));
						String description = request.getParameter("descrizione");
						float gradazione = Float.parseFloat(request.getParameter("gradazione"));
						String tipo = request.getParameter("tipo");
						int capienza=Integer.parseInt(request.getParameter("capienza"));
						
						
						Part file=request.getPart("img");
						
						
						String imageFileName=file.getSubmittedFileName();
						
						
						String uploadPath="C:/Users/matte/eclipse-workspace 2023/Burn_House/src/main/webapp/Immagini/"+imageFileName;
						
					
						
						try {
							FileOutputStream fos = new FileOutputStream(uploadPath);
							InputStream is = file.getInputStream();

							byte[] data = new byte[is.available()];
							int bytesRead;
							while ((bytesRead = is.read(data)) != -1) {
							    fos.write(data, 0, bytesRead);
							}
							fos.close();

							}
							catch(Exception e){
								response.sendRedirect("GeneralError");
							}
						
						
						ProductBean bean = new ProductBean();
						bean.setCode(codice);
						bean.setName(nome);
						bean.setPrice(prezzo);
						bean.setDescription(description);
						bean.setDegree(gradazione);
						bean.setType(tipo);
						bean.setImg(imageFileName);
						bean.setCapacity(capienza);
						model.doModify(bean, id);
				  }
				  
				  
				  else if (action.equalsIgnoreCase("filter")) {
				  		int min =Integer.parseInt( request.getParameter("minGradazione"));
				  		int max =Integer.parseInt( request.getParameter("maxGradazione"));
				  		
				  		
				  		 
						
						Collection<ProductBean> filteredProducts = model.doFilter(min, max);
						request.setAttribute("filteredProducts", filteredProducts);
						
						
				  }else if(action.equalsIgnoreCase("sugg")) {
					  
					  request.removeAttribute("products");
					  Collection<ProductBean> prod=model.doRetrieveLike(request.getParameter("search"));
					  request.setAttribute("products", prod);
					  RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ProductView.jsp");
					  dispatcher.forward(request, response);
					  return;
				  }
				
			}		
		} catch (SQLException e) {
			response.sendRedirect("GeneralError.jsp");
		}
		
		
		String sort = request.getParameter("sort");
		
		try {
			request.removeAttribute("products");
			request.setAttribute("products", model.doRetrieveAll(sort));
		} catch (SQLException e) {
			response.sendRedirect("GeneralError.jsp");
		}

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ProductView.jsp");
		dispatcher.forward(request, response);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String action=request.getParameter("action");
		if(action!=null) {
	
		
		if(action.equalsIgnoreCase("ajax")) {
			try {
			String find=request.getParameter("find");
			Collection<String> suggest=model.doRetrieveLikeName(find);
			
			Gson jso=new Gson();
			String json=jso.toJson(suggest);
			
			response.getWriter().write(json);
			
			}catch(Exception e) {
				response.sendRedirect("GeneralError.jsp");
			}
		}else {
		doGet(request, response);
		}
		}
		}

}