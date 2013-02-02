

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calculate
 * Name:Jinguang Zhou
 * AndrewID:jinguanz
 * Course:08600
 * Date:11/04/2012
 */
public class Calculate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String X_ERROR="X is not a number.";
	private static final String Y_ERROR="Y is not a number.";
	private static final String DIVIDE_ERROR="Cannot divide by zero";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Calculate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String x = request.getParameter("x");
		String y = request.getParameter("y");
		String function = request.getParameter("function");
		if(!isDouble(x) && !isDouble(y)){
			printXYError(response,x,y);
			return;
		}else if(!isDouble(x)){
			printXErrorPage(response,x,y);
			return;
		}else if(!isDouble(y)){
			printYErrorPage(response,x,y);
			return;
		}
		if(function.equals("/") && y.equals("0")){
			printDivedeErrorPage(response,x,y);
			return;
		}
		printPage(response, x, y, function);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}
	
	public void printPage(HttpServletResponse response,String x,String y,String function) throws IOException{
		double result=calculate(x,y,function);
		String x_value=getStandardBalance(Double.parseDouble(x));
		String y_value=getStandardBalance(Double.parseDouble(y));
		String output=getStandardBalance(result);
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("    <head>");
        out.println("        <title>Calculate!</title>");
        out.println("    </head>");
        out.println("    <body>");
        out.println(x_value +function +y_value +"= " + output);
        out.println("        <form action=\"Calculate\" name=\"calculator\">");
        out.println("X: <input type=\"text\" id=\"x\" name=\"x\" value ="+x+">"+" Y: <input type=\"text\"id=\"y\" name=\"y\" value="+y+">" );
        out.println("<br></br> ");
        out.println("   <input type=\"submit\" id=\"plus\"name=\"function\" value=\"+\">");
        out.println("     <input type=\"submit\" id=\"minus\" name=\"function\" value=\"-\"> ");
        out.println("    <input type=\"submit\" id=\"multiply\" name=\"function\" value=\"*\"> ");
        out.println("    <input type=\"submit\" id=\"div\" name=\"function\" value=\"/\"> ");
        out.println("    <br></br>");
        out.println("    </form>");
        out.println("    </body>");
        out.println("</html>");		
	}
	
	public boolean isDouble(String x){
		try {
			Double.parseDouble(x);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
		
	}
	
	public void printDivedeErrorPage(HttpServletResponse response,String x,String y) throws IOException{
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("    <head>");
        out.println("        <title>Calculate!</title>");
        out.println("    </head>");
        out.println("    <body>");
        out.print(DIVIDE_ERROR);
        out.println("        <form action=\"Calculate\" name=\"calculator\">");
        out.println("X: <input type=\"text\" id=\"x\" name=\"x\"> Y: <input type=\"text\"id=\"y\" name=\"y\" value=" + y +">" );
        out.println("<br></br> ");
        out.println("   <input type=\"submit\" id=\"plus\"name=\"function\" value=\"+\">");
        out.println("     <input type=\"submit\" id=\"minus\" name=\"function\" value=\"-\"> ");
        out.println("    <input type=\"submit\" id=\"multiply\" name=\"function\" value=\"*\"> ");
        out.println("    <input type=\"submit\" id=\"div\" name=\"function\" value=\"/\"> ");
        out.println("    <br></br>");
        out.println("    </form>");
        out.println("    </body>");
        out.println("</html>");		
		
	}
	public void printXErrorPage(HttpServletResponse response, String x,String y) throws IOException{
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("    <head>");
        out.println("        <title>Calculate!</title>");
        out.println("    </head>");
        out.println("    <body>");
        out.print(X_ERROR);
        out.println("        <form action=\"Calculate\" name=\"calculator\">");
        out.println("X: <input type=\"text\" id=\"x\" name=\"x\"> Y: <input type=\"text\"id=\"y\" name=\"y\" value=" + y +">" );
        out.println("<br></br> ");
        out.println("   <input type=\"submit\" id=\"plus\"name=\"function\" value=\"+\">");
        out.println("     <input type=\"submit\" id=\"minus\" name=\"function\" value=\"-\"> ");
        out.println("    <input type=\"submit\" id=\"multiply\" name=\"function\" value=\"*\"> ");
        out.println("    <input type=\"submit\" id=\"div\" name=\"function\" value=\"/\"> ");
        out.println("    <br></br>");
        out.println("    </form>");
        out.println("    </body>");
        out.println("</html>");		
		
	}
	
	public void printYErrorPage(HttpServletResponse response,String x,String y) throws IOException{
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("    <head>");
        out.println("        <title>Calculate!</title>");
        out.println("    </head>");
        out.println("    <body>");
        out.print(Y_ERROR);
        out.println("        <form action=\"Calculate\" name=\"calculator\">");
        out.println("X: <input type=\"text\" id=\"x\" name=\"x\"> Y: <input type=\"text\"id=\"y\" name=\"y\" value=" + y +">" );
        out.println("<br></br> ");
        out.println("   <input type=\"submit\" id=\"plus\"name=\"function\" value=\"+\">");
        out.println("     <input type=\"submit\" id=\"minus\" name=\"function\" value=\"-\"> ");
        out.println("    <input type=\"submit\" id=\"multiply\" name=\"function\" value=\"*\"> ");
        out.println("    <input type=\"submit\" id=\"div\" name=\"function\" value=\"/\"> ");
        out.println("    <br></br>");
        out.println("    </form>");
        out.println("    </body>");
        out.println("</html>");		
	}
	
	public void printXYError(HttpServletResponse response,String x,String y) throws IOException{
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("    <head>");
        out.println("        <title>Calculate!</title>");
        out.println("    </head>");
        out.println("    <body>");
        out.println(X_ERROR);
        out.println(Y_ERROR);
        out.println("        <form action=\"Calculate\" name=\"calculator\">");
        out.println("X: <input type=\"text\" id=\"x\" name=\"x\" value ="+x+">"+" Y: <input type=\"text\"id=\"y\" name=\"y\" value="+y+">" );
        out.println("<br></br> ");
        out.println("   <input type=\"submit\" id=\"plus\"name=\"function\" value=\"+\">");
        out.println("     <input type=\"submit\" id=\"minus\" name=\"function\" value=\"-\"> ");
        out.println("    <input type=\"submit\" id=\"multiply\" name=\"function\" value=\"*\"> ");
        out.println("    <input type=\"submit\" id=\"div\" name=\"function\" value=\"/\"> ");
        out.println("    <br></br>");
        out.println("    </form>");
        out.println("    </body>");
        out.println("</html>");		
	}
	
	public double calculate(String x, String y, String function){
		double x_value=Double.parseDouble(x);
		double y_value=Double.parseDouble(y);
		if(function.equals("+"))
			return x_value+y_value;
		else if(function.equals("-"))
			return x_value-y_value;
		else if(function.equals("*"))
			return x_value*y_value;
		else
			return x_value/y_value;
	}
	
	public String getStandardBalance(double x) {
		DecimalFormat df = new DecimalFormat("#,###.00");
		return df.format(x);
	}

}
