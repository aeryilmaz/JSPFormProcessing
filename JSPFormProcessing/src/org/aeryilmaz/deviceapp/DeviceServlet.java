package org.aeryilmaz.deviceapp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aeryilmaz.deviceapp.entity.DeviceInfo;
import org.aeryilmaz.deviceapp.repository.DeviceRepository;
import org.aeryilmaz.deviceapp.service.DeviceService;
import org.aeryilmaz.service.ServiceException;

/**
 * Servlet implementation class DeviceServlet
 */
@WebServlet("/savedevice")
public class DeviceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{		
		response.getWriter().append("Access forbidden");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try {
			String name = request.getParameter("name");
			String ipAddress = request.getParameter("ip_address");
			
			//...
			
			DeviceInfo di = new DeviceInfo(name, ipAddress); 
			
			DeviceService service = new DeviceService(DeviceRepository.INSTANCE);
			
			service.save(di);
			
			response.getWriter().append(di.toString());			
		}
		catch (ServiceException ex) {
			
		}
		
	}

}
