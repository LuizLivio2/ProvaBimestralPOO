<%-- 
    Document   : disciplinas
    Created on : 5 de out de 2020, 00:55:52
    Author     : Luiz Livio
--%>

<%@page import="br.edu.fatecpg.poo.Disciplina"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Disciplinas</title>
    </head>
    <body>
        <% 
            if (request.getParameter("botaoAlterar") != null){
                int i = Integer.parseInt(request.getParameter("i"));
                float notaEdit = Float.parseFloat(request.getParameter("nota"));
                if (notaEdit < 0){
                    notaEdit = 0;
                } else if (notaEdit > 10){
                    notaEdit = 10;
                }
                Disciplina disciplina = Disciplina.getList().get(i);
                disciplina.setNota(notaEdit);
            }
        
        %>
        
        
        <div>
            <h1 style="text-align: center">Disciplinas</h1>
        </div>
        <table border="1">
            <tr>
                <th>Disciplina</th>
                <th>Ementa</th>
                <th>Ciclo</th>
                <th>Nota</th>
                <th>Alterar Nota</th>
            </tr>
            
            <% 
                for (int i = 0; i < Disciplina.getList().size();i++){
                    Disciplina disciplina = Disciplina.getList().get(i); %>
                    <tr>
                        <td><%= disciplina.getNome() %></td>
                        <td><%= disciplina.getEmenta() %></td>
                        <td><%= disciplina.getCiclo() %></td>
                        <td><%= disciplina.getNota() %></td>
                        <td>
                            <form method="get">
                                <div>
                                    <input type="text" name="nota" value="<%= disciplina.getNota() %>"/>
                                    <input type="submit" name="botaoAlterar" value="Alterar!"/>
                                    <input type="hidden" name="i" value="<%= i %>"/>
                                </div>
                            </form>
                        </td>
                    </tr>
                <%}%>
            
        </table>
    </body>
</html>
