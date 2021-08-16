package com.utp.misiontic2022.c2reto4y5.elkin;

import com.utp.misiontic2022.c2reto4y5.elkin.view.ReportesView;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        var reportesView = new ReportesView();
        var banco = "Conavi";
        reportesView.proyectosFinanciadosPorBanco(banco);
    }
}
