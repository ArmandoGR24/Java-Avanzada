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

public class UsersTagController extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
        StringBuilder tableContent = new StringBuilder();
        tableContent.append("<table class=\"table my-0\" id=\"dataTable\">")
                .append("<thead>")
                .append("<tr>")
                .append("<th>ID</th>")
                .append("<th>Usuario</th>")
                .append("<th>Rol</th>")
                .append("<th>Color</th>")
                .append("</tr>")
                .append("</thead>")
                .append("<tbody>");

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT iduser, user, role, color FROM users")) {

            while (resultSet.next()) {
                int id = resultSet.getInt("iduser");
                String username = resultSet.getString("user");
                String role = resultSet.getString("role");
                String color = resultSet.getString("color");

                tableContent.append("<tr>")
                        .append("<td>").append(id).append("</td>")
                        .append("<td>").append(username).append("</td>")
                        .append("<td>").append(role).append("</td>")
                        .append("<td style=\"background-color:").append(color).append(";\"></td>")
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