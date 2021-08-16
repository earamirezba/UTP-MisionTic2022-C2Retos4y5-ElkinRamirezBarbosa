package com.utp.misiontic2022.c2reto4y5.elkin;

import com.utp.misiontic2022.c2reto4y5.elkin.view.ReportesView;

/**
 * Pruebas Reto 4
 *
 */
public class App {
    public static void main(String[] args) {
        var reportesView = new ReportesView();

        // 1st Test
        //Información de los proyectos financiados por un banco (consulta 2 del Reto 3)
        // var banco = "Conavi";
        // reportesView.proyectosFinanciadosPorBanco(banco);

        //2do Test
        //Listado del total adeudado de cada proyecto filtrado por un límite inferior dado (consulta 4 del Reto 3)
        reportesView = new ReportesView();
        var limiteInferior = 50_000d;
        reportesView.totalAdeudadoPorProyectosSuperioresALimite(limiteInferior);
    }
}
