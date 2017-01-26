import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class levels extends HttpServlet
{

    public levels()
    {
    }

    public void init(ServletConfig servletconfig)
        throws ServletException
    {
        super.init(servletconfig);
        try
        {
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
con=DriverManager.getConnection("jdbc:odbc:ecare","ecare","ecare");
//Class.forName("oracle.jdbc.driver.OracleDriver");
   //con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:project","ecare","ecare");
   st=con.createStatement();
        }
        catch(Exception exception)
        {
            System.out.println(exception);
        }
    }

    public void service(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws ServletException, IOException
    {
        PrintWriter printwriter = httpservletresponse.getWriter();
        httpservletresponse.setContentType("text/html");
        try
        {

            rs = st.executeQuery("select levelcode,levelname from hdlevels");
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
            printwriter.println(" <TR>");
            printwriter.println("  <TD></TD>");
            printwriter.println("  <TD></TD>");
            printwriter.println("  <TD>");
            printwriter.println("   <P align=left style='COLOR: forestgreen'><FONT size=3><STRONG>Welcome to SuperUserView</STRONG></FONT></P></TD></TR>");
            printwriter.println("  <TR> ");
            printwriter.println(" <TD></TD> ");
            printwriter.println(" <TD></TD>");
            printwriter.println(" <TD></TD></TR>");
            printwriter.println("  <TR> ");
            printwriter.println(" <TD></TD> ");
            printwriter.println(" <TD></TD>");
            printwriter.println(" <TD></TD></TR>");
            printwriter.println("  <TR> ");
            printwriter.println(" <TD></TD> ");
            printwriter.println(" <TD></TD>");
            printwriter.println(" <TD></TD></TR>");
            printwriter.println("  <TR> ");
            printwriter.println(" <TD></TD> ");
            printwriter.println(" <TD></TD>");
            printwriter.println(" <TD></TD></TR>");
            printwriter.println("  <TR>");
            printwriter.println(" <TD></TD>");
            printwriter.println(" <TD></TD>");
            printwriter.println("  <TD></TD></TR>");
            printwriter.println(" <TR>  ");
            printwriter.println("  <TD></TD>");
            printwriter.println("  <TD></TD>");
            printwriter.println("  <TD></TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD><STRONG>Level code</STRONG></TD>");
            printwriter.println("<TD><STRONG>Level name</STRONG></TD>");
            printwriter.println("<TD>");
            printwriter.println("<P align=center><STRONG>Actions</STRONG></P></TD></TR>");
            String s;
            String s1;
            String s2;
            for(; rs.next(); printwriter.println(" <P align=center><a href='./modifylevel?c=" + s + "&n=" + s1 + "'>" + s2 + "</a></P></TD></TR> "))
            {
                s = rs.getString("levelcode");
                s1 = rs.getString("levelname");
                s2 = "modify";
                printwriter.println(" <TR> ");
                printwriter.println(" <TD>" + s + "</TD> ");
                printwriter.println(" <TD>" + s1 + "</TD> ");
                printwriter.println(" <TD>  ");
            }

            printwriter.println(" <TR> ");
            printwriter.println("  <TD></TD> ");
            printwriter.println("  <TD>&nbsp;</TD></TR>");
            printwriter.println(" <TR> ");
            printwriter.println("   <TD></TD>");
            printwriter.println("  <TD></TD> ");
            printwriter.println("    <TD><a href='./addlevel1.html'><STRONG>click here to&gt;&gt;Add Levels</STRONG></a></TD></TR></TABLE>");
            printwriter.println("</P> ");
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
    ResultSet rs;
}