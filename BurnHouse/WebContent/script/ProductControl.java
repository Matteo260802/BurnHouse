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
import org.json.JSONArray;

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
		//System.out.println("Azione eseguita");
		//System.out.println(action);
		System.out.println("ciao");
		try {
			if (action != null) {
				if(action.equalsIgnoreCase("ajax")) {
					String find=request.getParameter("find");
					Collection<String> suggest=(List<String>) model.doRetrieveLikeName(find);
					JSONArray json=new JSONArray(suggest);
					System.out.println(json.toString());
					
				}else {
				
				
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
						
						System.out.println("Nel metodo dopost di AddImage");
						Part file=request.getPart("img");
						
						String imageFileName=file.getSubmittedFileName();
						System.out.println("Immagine selezionata: "+imageFileName);
						
						String uploadPath="C:/Users/matte/eclipse-workspace 2023/Burn_House/src/main/webapp/Immagini/"+imageFileName;
						System.out.println("Upload Path: "+uploadPath);
					
						
						
						try {
							FileOutputStream fos = new FileOutputStream(uploadPath);
							InputStream is =file.getInputStream();
							
							byte[] data = new byte[is.available()];
							is.read(data);
							fos.write(data);
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
						
						System.out.println("Nel metodo dopost di AddImage");
						Part file=request.getPart("img");
						
						
						String imageFileName=file.getSubmittedFileName();
						System.out.println("Immagine selezionata: "+imageFileName);
						
						String uploadPath="C:/Users/matte/eclipse-workspace 2023/Burn_House/src/main/webapp/Immagini/"+imageFileName;
						System.out.println("Upload Path: "+uploadPath);
					
						
						try {
							FileOutputStream fos = new FileOutputStream(uploadPath);
							InputStream is =file.getInputStream();
							
							byte[] data = new byte[is.available()];
							is.read(data);
							fos.write(data);
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
				  		//System.out.println("Min: "+min);
				  		//System.out.println("Max: "+max);
				  		
				  		 
						
						Collection<ProductBean> filteredProducts = model.doFilter(min, max);
						request.setAttribute("filteredProducts", filteredProducts);
						//filteredProducts.forEach(e -> System.out.println(e.getName()+", "+e.getDegree()));
						
				  }
				
			}
			}			
		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}
		
		
		String sort = request.getParameter("sort");

		try {
			request.removeAttribute("products");
			request.setAttribute("products", model.doRetrieveAll(sort));
		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ProductView.jsp");
		dispatcher.forward(request, response);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
