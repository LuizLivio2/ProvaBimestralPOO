<%-- 
    Document   : sobre
    Created on : 5 de out de 2020, 00:41:39
    Author     : Luiz Livio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="WEB-INF/jspf/head.jspf"%>
        <title>Página Inicial</title>
        <style>
            .table{
                text-align: center;
            }
        </style>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/navbar.jspf"%>
        <table class="table">
            <thead>
                <th>Sobre</th>
            </thead>
                <tr><td>Nome: Luiz Paulo Livio dos Santos</td></tr>
                <tr><td>RA: 1290481813022</td></tr>
                <tr><td><a href="https://github.com/luizlivio/ProvaBimestralPOO">Link do Repositório no GitHub</a></td></tr>
        </table>
        <%@include file="WEB-INF/jspf/body-scripts.jspf"%>
    </body>
</html>
