<%@page import="com.sun.javafx.sg.prism.NGShape.Mode"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import = "java.util.*" %>
<%@ page import = "dao.*" %>
<%@ page import = "bean.*" %>
<% request.setCharacterEncoding("UTF-8"); %>

<!doctype html>
<html>

    <head>
        <!-- Standard Meta -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
        <script src="https://code.jquery.com/jquery-3.1.1.min.js" integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script>
        <script src="semantic/semantic.js"></script>
        <script src="js/header.js"></script>
        <script src="js/listboard.js"></script>
        <link rel="stylesheet" type="text/css" href="semantic/semantic.css" />
        <link rel="stylesheet" type="text/css" href="css/header.css" />
        <TITLE> ListBoard | TeamDG </TITLE>
        <META http-equiv="Content-Type" content="text/html; charset=euc-8">
    </HEAD>
    <body clas="pushable">

        <!-- Following Menu -->
        <div class="ui large top fixed hidden menu">

            <div class="ui four item menu">
                <a href="index.html" class="item">Home</a>
                <a href="about.html" class="item">About</a>
                <a href="projects.html" class="item">Projects</a>
                <a href="listboard.jsp" class="active item">Help</a>
            </div>
        </div>
        <!-- Sidebar Menu -->
        <div class="ui vertical inverted sidebar menu left">
            <a href="index.html" class="item">Home</a>
            <a href="about.html" class="item">About</a>
            <a href="projects.html" class="item">Projects</a>
            <a href="listboard.jsp" class="active item">Help</a>
        </div>

        <div class="pusher">
            <div class="ui inverted vertical masthead center aligned segment" >

                <div class="ui container">
                    <div class="ui large secondary inverted pointing menu">
                        <a class="toc item">
                            <i class="sidebar icon"></i>
                        </a>
                        <a href="index.html" class="item">Home</a>
                        <a href="about.html" class="item">About</a>
                        <a href="projects.html" class="item">Projects</a>
                        <a href="listboard.jsp" class="active item">Help</a>
                    </div>
                </div>
            </div>
            <%
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
            %>

            <center style ="padding-top:50px"><font size='3' style ="padding-top:100px;"><h1> Q&A Board </h1></font></TD>


                <table class="ui unstackable table">
                    <thead>
                        <tr>
                            <th><center><b>번호</b></center></th>
                    <th><center><b>글 제목</b></center></th>
                    <th><center><b>작성자</b></center></th>
                    <th ><center><b>작성일</b></center></th>
                    <th><center><b>조회</b></center></th>
                    </tr>
                    </thead>

                    <%            if (lastRow > 0) {
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
                    %>
                    <tbody>
                        <tr>
                            <td ><center><%=listnum%></center></td>
                    <td ><center><a href="write_output.jsp?num=<%=listnum%>"><%=title%></a></center></td>
                    <td ><center><a href="email.jsp?num=<%=listnum%>"><%=name%></a></center></td>
                    <td ><center><%=writedate%></center></td>
                    <td ><center><%=readcount%></center></td>
                    </tr>
                    </tbody>


                    <%
                        }
                    %>

                </table>
                <table class="ui celled table">

                    <tfoot style ="text-align: center;">
                        <tr><th colspan="3">
                                <div class="ui pagination menu" >
                                    <%
                                        }

                                        if (paging.getStartPage() > 5) {
                                    %>
                                    <a class="icon item" href="./listboard.jsp?pageNum=<%=paging.getStartPage() - 5%>">[이전]</a>
                                    <%
                                        }
                                        while (paging.getStartPage() <= paging.getEndPage()) {
                                            if (paging.getStartPage() == currentPage) {
                                    %>
                                    <a class="item" href="./listboard.jsp?pageNum=<%=paging.getStartPage()%>">Now</a>
                                    <%
                                    } else if (paging.getStartPage() != currentPage) {
                                    %>
                                    <a class="item" href="./listboard.jsp?pageNum=<%=paging.getStartPage()%>"><%=paging.getStartPage()%></a>
                                    <%
                                            }
                                            paging.setStartPage(paging.getStartPage() + 1);
                                        }
                                        if (paging.getEndPage() < paging.getTotalPages()) {
                                    %>
                                    <a class="icon item" href="./listboard.jsp?pageNum=<%=paging.getStartPage()%>"> > </a>
                                    <%
                                        }
                                    %>
                                </div>
                                <button class="ui button" onclick="boardWrite(<%=pageNum%>)" style="float: right;">글 등록</button>
                            </th>
                        </tr></tfoot>
                </table>

                <form name="form" method="post" action="searchlist.jsp" onsubmit="return Check()">

                    <div class="ui action input">
                        <input type="text" placeholder="Search..." name="keyword" size="20" maxlength="30">
                    </div>
                    <div class="ui selection dropdown">
                        <input type="hidden" name="gender">
                        <i class="dropdown icon"></i>
                        <div class="default text">Select Filter</div>
                        <div class="menu">
                            <div class="item key" data-value="title">글제목</div>
                            <div class="item key" data-value="contents">글내용</div>
                            <div class="item key" data-value="name">작성자</div>
                        </div>
                        <input type="hidden" class="hiddenItem" name="key"/>
                    </div>
                    <button type="submit" class="ui button" id="search">Search</button>
                </form>

                <div class="ui inverted vertical footer segment">
                    <div class="ui container">
                        <div class="ui stackable inverted divided equal height stackable grid">
                            <div class="three wide column">
                                <h4 class="ui inverted header">About</h4>
                                <div class="ui inverted link list">
                                    <a href="#" class="item">Hahunnwo</a>
                                    <a href="#" class="item">Hawnghochan</a>
                                    <a href="#" class="item">Joekyuhyun</a>
                                </div>
                            </div>
                            <div class="three wide column">
                                <h4 class="ui inverted header">Projects</h4>
                                <div class="ui inverted link list">
                                    <a href="#" class="item">WhatDo</a>
                                    <a href="#" class="item">AnyToon</a>
                                    <a href="#" class="item">WhereTrip</a>
                                </div>
                            </div>
                            <div class="seven wide column">
                                <h4 class="ui inverted header">others</h4>
                                <p>
                                    All questions ask you to contact the help board.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </center>
        </div>

        <script>
            $(".dropdown").dropdown({
                // you can use any ui transition
                transition: 'drop'
            });

            $(".key").click(function () {
                var value = this.html()
                $(".hiddenItem").val() = value;
            })

        </script>
    </body>
</HTML>
