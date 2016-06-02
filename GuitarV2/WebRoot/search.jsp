<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="cumt.pojo.Guitar"%>
<%@page import="cumt.dao.GuitarDao"%>
<%
 GuitarDao dao=new GuitarDao();
String pageNo=request.getParameter("pageNo");
		Guitar guitar=dao.getGuitarByNum(pageNo);
		
		if(guitar!=null){
			request.setAttribute("guitar",guitar);
		}
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
%>