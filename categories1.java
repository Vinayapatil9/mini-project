import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class categories1 extends HttpServlet
{

    public categories1()
    {
    }

    public void init(ServletConfig servletconfig)
        throws ServletException
    {
        super.init(servletconfig);
        try
        {
            System.out.println("inside init");
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
con=DriverManager.getConnection("jdbc:odbc:ecare","ecare","ecare");

//Class.forName("oracle.jdbc.driver.OracleDriver");
//con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:project","ecare","ecare");
 st=con.createStatement();
            st1 = con.createStatement();
            System.out.println("statement is created");
        }
        catch(Exception exception)
        {
            System.out.println("init method" + exception);
        }
    }

    public void service(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws ServletException, IOException
    {
        System.out.println("inside service");
        PrintWriter printwriter = httpservletresponse.getWriter();
        httpservletresponse.setContentType("text/html");
        try
        {
            System.out.println("inside try");
            rs = st.executeQuery("select * from categoryies");
            printwriter.println("<html>");
            printwriter.println("<head>");
            printwriter.println("<style>");
            printwriter.println("a{ Text-Decoration:none;}");
            printwriter.println("</style>");
            printwriter.println("</head>");
            printwriter.println("<body>");
            printwriter.println("<form > ");
            printwriter.println("<TABLE border=0 cellPadding=1 cellSpacing=1 width=75% align=center>");
            printwriter.println("<P>");
            printwriter.println("<TR>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD>");
            printwriter.println("<P align=left style='COLOR: forestgreen'><FONT size=5><STRONG><U>HD Categories</U></STRONG></FONT></P></TD></TR>");
            printwriter.println("<P align=center>&nbsp;</P>");
            printwriter.println("<P align=center>");
            printwriter.println("<TABLE border=0 cellPadding=1 cellSpacing=1 style='HEIGHT: 130px; WIDTH: 431px'");
            printwriter.println("width=75%>");
            printwriter.println("<TR>");
            printwriter.println("<TD><STRONG>CategoryId</STRONG></TD>");
            printwriter.println("<TD><STRONG>&nbsp;&nbsp;CategoryName</STRONG></TD>");
            printwriter.println("<TD>");
            printwriter.println("<P align=center><STRONG>&nbsp;&nbsp;Actions&nbsp;&nbsp;</STRONG></P></TD></TR>");
            System.out.println("after rs");
            String s;
            String s1;
            for(; rs.next(); printwriter.println("<P align=center><a href='./viewcategory?c=" + s + "&n=" + s1 + "'>View </a></P></TD></TR>"))
            {
                System.out.println("INSIDE RS");
                s = rs.getString(1);
                System.out.println("code is " + s);
                s1 = rs.getString(2);
                System.out.println("name is " + s1);
                String s2 = "View";
                printwriter.println(" <TR> ");
                printwriter.println(" <TD>&nbsp;&nbsp;" + s + "&nbsp;&nbsp;</TD> ");
                printwriter.println(" <TD>&nbsp;&nbsp;" + s1 + "&nbsp;&nbsp;</TD> ");
                printwriter.println(" <TD>  ");
            }

            printwriter.println("<TR>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD>&nbsp;</TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD></TD>");
            printwriter.println("</form>");
            printwriter.println("</body>");
            printwriter.println("</html>");
        }
        catch(Exception exception)
        {
            System.out.println(exception);
        }
    }
Connection con;
Statement st;
    Statement st1;
    ResultSet rs;
    ResultSet rs1;
}