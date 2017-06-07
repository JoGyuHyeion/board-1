package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.sun.javafx.sg.prism.NGShape.Mode;
import java.util.*;
import dao.*;
import bean.*;

public final class listboard_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
 request.setCharacterEncoding("UTF-8"); 
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!doctype html>\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("    <head>\r\n");
      out.write("        <!-- Standard Meta -->\r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0\">\r\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.1.1.min.js\" integrity=\"sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("        <script src=\"semantic/semantic.js\"></script>\r\n");
      out.write("        <script src=\"js/header.js\"></script>\r\n");
      out.write("        <script src=\"js/listboard.js\"></script>\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"semantic/semantic.css\" />\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/header.css\" />\r\n");
      out.write("        <TITLE> ListBoard | TeamDG </TITLE>\r\n");
      out.write("        <META http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("    </HEAD>\r\n");
      out.write("    <body clas=\"pushable\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Following Menu -->\r\n");
      out.write("        <div class=\"ui large top fixed hidden menu\">\r\n");
      out.write("\r\n");
      out.write("            <div class=\"ui four item menu\">\r\n");
      out.write("                <a href=\"index.html\" class=\"item\">Home</a>\r\n");
      out.write("                <a href=\"about.html\" class=\"item\">About</a>\r\n");
      out.write("                <a href=\"projects.html\" class=\"item\">Projects</a>\r\n");
      out.write("                <a href=\"listboard.jsp\" class=\"active item\">Help</a>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- Sidebar Menu -->\r\n");
      out.write("        <div class=\"ui vertical inverted sidebar menu left\">\r\n");
      out.write("            <a href=\"index.html\" class=\"item\">Home</a>\r\n");
      out.write("            <a href=\"about.html\" class=\"item\">About</a>\r\n");
      out.write("            <a href=\"projects.html\" class=\"item\">Projects</a>\r\n");
      out.write("            <a href=\"listboard.jsp\" class=\"active item\">Help</a>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"pusher\">\r\n");
      out.write("            <div class=\"ui inverted vertical masthead center aligned segment\" >\r\n");
      out.write("\r\n");
      out.write("                <div class=\"ui container\">\r\n");
      out.write("                    <div class=\"ui large secondary inverted pointing menu\">\r\n");
      out.write("                        <a class=\"toc item\">\r\n");
      out.write("                            <i class=\"sidebar icon\"></i>\r\n");
      out.write("                        </a>\r\n");
      out.write("                        <a href=\"index.html\" class=\"item\">Home</a>\r\n");
      out.write("                        <a href=\"about.html\" class=\"item\">About</a>\r\n");
      out.write("                        <a href=\"projects.html\" class=\"item\">Projects</a>\r\n");
      out.write("                        <a href=\"listboard.jsp\" class=\"active item\">Help</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            ");

                String pageNum = request.getParameter("pageNum");
                if (pageNum == null) {
                    pageNum = "1";
                }

                int listSize = 10;
                int pageSize = 10;
                int currentPage = Integer.parseInt(pageNum);
                int lastRow = 0;
                List list = null;
                ArticleDao dao = new ArticleDaoFactory().articleDao();
                lastRow = dao.getLastRow();
                int endRow = lastRow - ((Integer.parseInt(pageNum) - 1) * listSize);
                int startRow = endRow - (listSize - 1);
                Paging paging = new Paging(lastRow, Integer.parseInt(pageNum), listSize, pageSize);
            
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <center style =\"padding-top:50px\"><font size='3' style =\"padding-top:100px;\"><h1> Q&A Board </h1></font></TD>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                <table class=\"ui unstackable table\">\r\n");
      out.write("                    <thead>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <th><center><b>번호</b></center></th>\r\n");
      out.write("                    <th><center><b>글 제목</b></center></th>\r\n");
      out.write("                    <th><center><b>작성자</b></center></th>\r\n");
      out.write("                    <th ><center><b>작성일</b></center></th>\r\n");
      out.write("                    <th><center><b>조회</b></center></th>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    </thead>\r\n");
      out.write("\r\n");
      out.write("                    ");
            if (lastRow > 0) {
                            list = dao.getDBAll(startRow, endRow);

                            Iterator it = list.iterator();
                            Article bean;
                            while (it.hasNext()) {
                                bean = (Article) it.next();
                                int listnum = bean.getNum();
                                String name = bean.getName();
                                String email = bean.getEmail();
                                String title = bean.getTitle();
                                String writedate = bean.getWritedate();
                                int readcount = bean.getReadcount();
                    
      out.write("\r\n");
      out.write("                    <tbody>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <td ><center>");
      out.print(listnum);
      out.write("</center></td>\r\n");
      out.write("                    <td ><center><a href=\"write_output.jsp?num=");
      out.print(listnum);
      out.write('"');
      out.write('>');
      out.print(title);
      out.write("</a></center></td>\r\n");
      out.write("                    <td ><center><a href=\"email.jsp?num=");
      out.print(listnum);
      out.write('"');
      out.write('>');
      out.print(name);
      out.write("</a></center></td>\r\n");
      out.write("                    <td ><center>");
      out.print(writedate);
      out.write("</center></td>\r\n");
      out.write("                    <td ><center>");
      out.print(readcount);
      out.write("</center></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    </tbody>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    ");

                        }
                    
      out.write("\r\n");
      out.write("\r\n");
      out.write("                </table>\r\n");
      out.write("                <table class=\"ui celled table\">\r\n");
      out.write("\r\n");
      out.write("                    <tfoot style =\"text-align: center;\">\r\n");
      out.write("                        <tr><th colspan=\"3\">\r\n");
      out.write("                                <div class=\"ui pagination menu\" >\r\n");
      out.write("                                    ");

                                        }

                                        if (paging.getStartPage() > 5) {
                                    
      out.write("\r\n");
      out.write("                                    <a class=\"icon item\" href=\"./listboard.jsp?pageNum=");
      out.print(paging.getStartPage() - 5);
      out.write("\">[이전]</a>\r\n");
      out.write("                                    ");

                                        }
                                        while (paging.getStartPage() <= paging.getEndPage()) {
                                            if (paging.getStartPage() == currentPage) {
                                    
      out.write("\r\n");
      out.write("                                    <a class=\"item\" href=\"./listboard.jsp?pageNum=");
      out.print(paging.getStartPage());
      out.write("\">Now</a>\r\n");
      out.write("                                    ");

                                    } else if (paging.getStartPage() != currentPage) {
                                    
      out.write("\r\n");
      out.write("                                    <a class=\"item\" href=\"./listboard.jsp?pageNum=");
      out.print(paging.getStartPage());
      out.write('"');
      out.write('>');
      out.print(paging.getStartPage());
      out.write("</a>\r\n");
      out.write("                                    ");

                                            }
                                            paging.setStartPage(paging.getStartPage() + 1);
                                        }
                                        if (paging.getEndPage() < paging.getTotalPages()) {
                                    
      out.write("\r\n");
      out.write("                                    <a class=\"icon item\" href=\"./listboard.jsp?pageNum=");
      out.print(paging.getStartPage());
      out.write("\"> > </a>\r\n");
      out.write("                                    ");

                                        }
                                    
      out.write("\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <button class=\"ui button\" onclick=\"boardWrite(");
      out.print(pageNum);
      out.write(")\" style=\"float: right;\">글 등록</button>\r\n");
      out.write("                            </th>\r\n");
      out.write("                        </tr></tfoot>\r\n");
      out.write("                </table>\r\n");
      out.write("\r\n");
      out.write("                <form name=\"form\" method=\"post\" action=\"searchlist.jsp\" onsubmit=\"return Check()\">\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"ui action input\">\r\n");
      out.write("                        <input type=\"text\" placeholder=\"Search...\" name=\"keyword\" size=\"20\" maxlength=\"30\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"ui selection dropdown\">\r\n");
      out.write("                        <input type=\"hidden\" name=\"gender\">\r\n");
      out.write("                        <i class=\"dropdown icon\"></i>\r\n");
      out.write("                        <div class=\"default text\">Select Filter</div>\r\n");
      out.write("                        <div class=\"menu\">\r\n");
      out.write("                            <div class=\"item key\" data-value=\"title\">글제목</div>\r\n");
      out.write("                            <div class=\"item key\" data-value=\"contents\">글내용</div>\r\n");
      out.write("                            <div class=\"item key\" data-value=\"name\">작성자</div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <input type=\"hidden\" class=\"hiddenItem\" name=\"key\"/>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <button type=\"submit\" class=\"ui button\" id=\"search\">Search</button>\r\n");
      out.write("                </form>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"ui inverted vertical footer segment\">\r\n");
      out.write("                    <div class=\"ui container\">\r\n");
      out.write("                        <div class=\"ui stackable inverted divided equal height stackable grid\">\r\n");
      out.write("                            <div class=\"three wide column\">\r\n");
      out.write("                                <h4 class=\"ui inverted header\">About</h4>\r\n");
      out.write("                                <div class=\"ui inverted link list\">\r\n");
      out.write("                                    <a href=\"#\" class=\"item\">Hahunnwo</a>\r\n");
      out.write("                                    <a href=\"#\" class=\"item\">Hawnghochan</a>\r\n");
      out.write("                                    <a href=\"#\" class=\"item\">Joekyuhyun</a>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"three wide column\">\r\n");
      out.write("                                <h4 class=\"ui inverted header\">Projects</h4>\r\n");
      out.write("                                <div class=\"ui inverted link list\">\r\n");
      out.write("                                    <a href=\"#\" class=\"item\">WhatDo</a>\r\n");
      out.write("                                    <a href=\"#\" class=\"item\">AnyToon</a>\r\n");
      out.write("                                    <a href=\"#\" class=\"item\">WhereTrip</a>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"seven wide column\">\r\n");
      out.write("                                <h4 class=\"ui inverted header\">others</h4>\r\n");
      out.write("                                <p>\r\n");
      out.write("                                    All questions ask you to contact the help board.</p>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </center>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <script>\r\n");
      out.write("            $(\".dropdown\").dropdown({\r\n");
      out.write("                // you can use any ui transition\r\n");
      out.write("                transition: 'drop'\r\n");
      out.write("            });\r\n");
      out.write("\r\n");
      out.write("            $(\".key\").click(function () {\r\n");
      out.write("                var value = this.html()\r\n");
      out.write("                $(\".hiddenItem\").val() = value;\r\n");
      out.write("            })\r\n");
      out.write("\r\n");
      out.write("        </script>\r\n");
      out.write("    </body>\r\n");
      out.write("</HTML>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
