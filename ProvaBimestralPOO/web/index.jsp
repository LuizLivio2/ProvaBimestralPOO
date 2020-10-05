<%-- 
    Document   : index
    Created on : 5 de out de 2020, 00:41:39
    Author     : Luiz Livio
--%>

<%@page import="br.edu.fatecpg.poo.Disciplina"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="WEB-INF/jspf/head.jspf"%>
        <title>Página Inicial</title>
        <style>
            .table {
                text-align: center;
            }
        </style>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/navbar.jspf"%>
        <!--<h1>Prova Bimestral de POO</h1>
        <h2>Nome: Luiz Paulo Livio dos Santos</h2>
        <h2>RA: 1290481813022</h2>
        <h2>Quantidade de Disciplinas: </h2>
        <h2><a href="disciplinas.jsp">Ver Disciplinas</a></h2>-->
        <table class="table">
            <thead>
                <th>Avaliação de POO</th>
            </thead>
                <tr><td>Nome: Luiz Paulo Livio dos Santos</td></tr>
                <tr><td>RA: 1290481813022</td></tr>
                <tr><td>Quantidade de Disciplinas: <%= Disciplina.getList().size() %></td></tr>
        </table>
    <%@include file="WEB-INF/jspf/body-scripts.jspf"%>
    </body>
</html>
