package com.codigomaestro.act6armandogr3069543;

import jakarta.servlet.jsp.tagext.SimpleTagSupport;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import java.io.IOException;
import java.util.Random;

public class Game extends SimpleTagSupport {
    private int seleccion;


    public void setSeleccion(String seleccion) {
        try {
            this.seleccion = Integer.parseInt(seleccion);
        } catch (NumberFormatException e) {
            this.seleccion = 0;
        }
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        Random random = new Random();
        int computerSelection = random.nextInt(3) + 1;

        String[] choices = {"Piedra", "Papel", "Tijera"};

        if (seleccion < 1 || seleccion > 3) {
            out.print("<h2>Selección inválida</h2>");
            return;
        }

        String userChoice = choices[seleccion - 1];
        String computerChoice = choices[computerSelection - 1];

        out.print("<h1>User: " + userChoice + " vs CPU: " + computerChoice + "</h1>");

        if (seleccion == computerSelection) {
            out.print("<h2>Empate!</h2>");
        } else if ((seleccion == 1 && computerSelection == 3) ||
                (seleccion == 2 && computerSelection == 1) ||
                (seleccion == 3 && computerSelection == 2)) {
            out.print("<h2>¡Ganaste!</h2>");
        } else {
            out.print("<h2>¡Perdiste!</h2>");
        }
    }
}
