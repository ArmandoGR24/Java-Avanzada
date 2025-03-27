package com.codigomaestro.evidencia2agr.Controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;
import javax.naming.NamingException;
import static com.codigomaestro.evidencia2agr.DB.DB.getConnection;

public class PacientTagController extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
        StringBuilder tableContent = new StringBuilder();
        tableContent.append("<table class=\"table my-0\" id=\"dataTable\">")
                .append("<thead>")
                .append("<tr>")
                .append("<th>ID</th>")
                .append("<th>Paciente</th>")
                .append("<th>Edad</th>")
                .append("<th>Sexo</th>")
                .append("<th>Estatura</th>")
                .append("<th>Peso</th>")
                .append("<th>Cadera</th>")
                .append("<th>IAC</th>")
                .append("<th>IMC</th>")
                .append("</tr>")
                .append("</thead>")
                .append("<tbody>");

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT p.*, s.IAC, s.IMC " +
                             "FROM pacients p " +
                             "JOIN stats s ON p.idpacients = s.idpacient")) {

            while (resultSet.next()) {
                int id = resultSet.getInt("idpacients");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String sex = resultSet.getString("sex");
                double stature = resultSet.getDouble("stature");
                double weight = resultSet.getDouble("weight");
                double cadera = resultSet.getDouble("cadera");
                double iac = resultSet.getDouble("IAC");
                double imc = resultSet.getDouble("IMC");

                tableContent.append("<tr>")
                        .append("<td>").append(id).append("</td>")
                        .append("<td>").append(name).append("</td>")
                        .append("<td>").append(age).append("</td>")
                        .append("<td>").append(sex).append("</td>")
                        .append("<td>").append(stature).append("</td>")
                        .append("<td>").append(weight).append("</td>")
                        .append("<td>").append(cadera).append("</td>")
                        .append("<td>").append(iac).append("</td>")
                        .append("<td>").append(imc).append("</td>")
                        .append("</tr>");
            }

        } catch (SQLException | NamingException e) {
            throw new JspException("Error retrieving users", e);
        }

        tableContent.append("</tbody>")
                .append("</table>");

        getJspContext().getOut().write(tableContent.toString());
    }
}