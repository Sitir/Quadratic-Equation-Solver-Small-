package pl.adramelech_sgo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class calculate
 */
@WebServlet("/")
public class calculate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	float x1=0,x2=0,x3=0;
	  float fRoot1, fRoot2;
	    float fDiscriminant;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public calculate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter output = response.getWriter();
		output.print("<!DOCTYPE html>\n" +
		"<html>\n" +
		"<head>\n<title>My Servlet</title>\n</head>\n" +
		"<body>\n" +
		"Welcome to The Quadratic Equation Solver"+
		"Please Enter coefficients for equation<br>"+
		"a  .x^2 +   b  .x +    c    "+
		"<form action='calculate' method='post'> "+
		"  a N <input name='first'>"+
		"  b N <input name='second'>"+
		"  c N <input name='third'>"+
		"<input type='submit' name='Solve!'>"+
		"</form>"+
		"</body>\n"+
		"</html>");
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		  x1= getfValue(request.getParameter("first"));
		  x2 = getfValue(request.getParameter("second"));
		x3 = getfValue(request.getParameter("third"));
		 
		PrintWriter output = response.getWriter();
		
		output.print("The equation you have entered is :\n" );
		output.print("<br>" +x1+".x^2 + "+x2+".x + "+x3+"<br>\n");
		
		 if ( x1==0 && x2==0 ) {
			
			  response.setContentType("text/html;charset=UTF-8");
			 output.print("<!DOCTYPE html>\n" +
						"<html>\n" +
						"<head>\n<title>My Servlet</title>\n</head>\n" +
						"<body>\n" +
						"Cannot solve " + x3 +" = 0.0"+"\n"+
						"<form action='calculate' method='post'> "+
						"  a  <input name='first'>"+
						"  b  <input name='second'>"+
						"  c  <input name='third'>"+
						"<input type='submit' name='Solve!'>"+
						"</form>"+
						"</body>\n"+
						"</html>");
	            return;
	        } 
		 if ( x1==0 && x2 !=0 ) {
	            fRoot1 = -x3/x2;
	          
	            response.setContentType("text/html;charset=UTF-8");
	            output.print("<!DOCTYPE html>\n" +
	            		"<html>\n" +
	            		"<head>\n<title>My Servlet</title>\n</head>\n" +
	            		"<body>\n" +
	            		"Welcome to The Quadratic Equation Solver"+
	            		"Degenerate root : Root = "+ fRoot1+"\n"+
	            		"<form action='calculate' method='post'> "+
	            		"  a  <input name='first'>"+
	            		"  b  <input name='second'>"+
	            		"  c  <input name='third'>"+
	            		"<input type='submit' name='Solve!'>"+
	            		"</form>"+
	            		"</body>\n"+
	            		"</html>");
	            return;
	        }
		 
		 fDiscriminant = fdiscriminant(x1,x2,x3);

	        // Case for two real roots.

	        if ( fDiscriminant >= 0.0 ) {

	            fRoot1 = (float)(-x2/2.0/x1-(float)Math.sqrt(fDiscriminant) /
	                              2.0 / x1 );
	            fRoot2 = (float)(-x1/2.0/x1+(float)Math.sqrt(fDiscriminant) /
	                              2.0 / x1);

	         
	            response.setContentType("text/html;charset=UTF-8");
	            output.print("<!DOCTYPE html>\n" +
	            		"<html>\n" +
	            		"<head>\n<title>My Servlet</title>\n</head>\n" +
	            		"<body>\n" +
	            		"Two real roots : Root1 : " + fRoot1+"<br>\n"+
	            		"Root2 : " + fRoot2+"\n"+
	            		"<form action='calculate' method='post'> "+
	            		"  a  <input name='first'>"+
	            		"  b  <input name='second'>"+
	            		"  c  <input name='third'>"+
	            		"<input type='submit' name='Solve!'>"+
	            		"</form>"+
	            		"</body>\n"+
	            		"</html>");
	            return;
	         }

	         // Two complex roots

	         fRoot1 = (float) (-x2/2.0/x1);
	         fRoot2 = (float) (Math.sqrt(-fDiscriminant)/2.0/x1);
	         response.setContentType("text/html;charset=UTF-8");
	      
	     output.print("<!DOCTYPE html>\n" +
	            		"<html>\n" +
	            		"<head>\n<title>My Servlet</title>\n</head>\n" +
	            		"<body>\n" +
	            		"Two complex roots"+"\n"+
	            		"Root1 : " + fRoot1 + "+" + fRoot2 +"<br>\n"+
	            		"Root2 : " + fRoot1 + "-" + fRoot2 + "\n"+
	            		"<form action='calculate' method='post'> "+
	            		"  a  <input name='first'>"+
	            		"  b  <input name='second'>"+
	            		"  c  <input name='third'>"+
	            		"<input type='submit' name='Solve!'>"+
	            		"</form>"+
	            		"</body>\n"+
	            		"</html>");
	    }
		 
		

	
	 float getfValue(String string){
	  float foo = Float.parseFloat(string);
	return foo;
	}

	 static float fdiscriminant(float x1, float x2, float x3) {
		    float fReturn;

		       fReturn= (float)(x2*x2-4.0*x1*x3);
		       return fReturn;
		    }
	 
}
