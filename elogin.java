import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class elogin extends HttpServlet
{

    public elogin()
    {
        flag = 0;
    }

    public void init(ServletConfig servletconfig)
        throws ServletException
    {
        super.init(servletconfig);
        try
        {
            System.out.println("inside try");
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
con=DriverManager.getConnection("jdbc:odbc:ecare","ecare","ecare");
//Class.forName("oracle.jdbc.driver.OracleDriver");
  //con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:project","ecare","ecare");
  st=con.createStatement();
            st1 = con.createStatement();
            System.out.println("elogin---------"+con);
            System.out.println("statement is created");
        }
        catch(Exception exception)
        {
            System.out.println(exception);
            exception.printStackTrace();
            
        }
    }

    public void service(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws ServletException, IOException
    {
        String s = "";
        String s2 = "";
        String s4 = "";
        String s5 = "";
        String s6 = "";
        String s7 = "";
        PrintWriter printwriter = httpservletresponse.getWriter();
        httpservletresponse.setContentType("text/html");//MIME TYE
        HttpSession httpsession = httpservletrequest.getSession(true);
        try
        {
            String s3 = httpservletrequest.getParameter("text1");
            System.out.println("user_id is "+s3);
            String s1 = httpservletrequest.getParameter("password1");
            System.out.println("password is "+s1);
            String s8 = s3.substring(0,2);
            System.out.println("substring is "+s8);
            httpsession.setAttribute("user",s3);
            rs = st.executeQuery("select user_id,password from registration where user_id='"+s3+"' and password='"+s1+"'");
            System.out.println("after select statement");
            while(rs.next())
            {
                System.out.println("Inside while");
                s5 = rs.getString(1);
                System.out.println("userid----"+s5);
                s4 = rs.getString(2);
                System.out.println("pass----"+s4);
            }
            if(s5.equals(s3) && s4.equals(s1))
            {
                if(s8.equals("CC"))
                    httpservletresponse.sendRedirect("./corporateclientview.html");
                else
                if(s8.equals("CU"))
                {
                     httpservletresponse.sendRedirect("./selectcompany");
                }
            } else
            {
                System.out.println("Inside else");
                printwriter.println("<html>");
                printwriter.println("<HEAD>");
                printwriter.println("<TITLE></TITLE>");
                printwriter.println("<BODY>");
                printwriter.println("<form name=f1 action='./elogin.html' style='COLOR: forestgreen'>");
                printwriter.println("<P>&nbsp;</P>");
                printwriter.println("<P align=center>&nbsp;</P> ");
                printwriter.println("<P align=center>&nbsp;</P>");
                printwriter.println("<P align=center><STRONG><FONT size=4>Invalid Username/Password </FONT></STRONG></P>");
                printwriter.println("<P align=center><FONT size=4><STRONG>Please Check again</STRONG></FONT></P>");
                printwriter.println("<P align=center>&nbsp;</P> ");
  
	httpservletresponse.setHeader("refresh","2 url='./elogin.html'");
                printwriter.println("</form>");
                printwriter.println("</BODY>");
                printwriter.println("</html>");
            }
        }
        catch(Exception exception)
        {
            System.out.println(exception);
            exception.printStackTrace();
        }
    }
Connection con;
    Statement st;
    Statement st1;
    ResultSet rs;
    ResultSet rs1;
    int flag;
}