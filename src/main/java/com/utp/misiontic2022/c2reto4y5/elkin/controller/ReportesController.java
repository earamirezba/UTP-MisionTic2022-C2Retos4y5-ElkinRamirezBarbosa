package com.utp.misiontic2022.c2reto4y5.elkin.controller;

import java.sql.SQLException;
import java.util.List;

import com.utp.misiontic2022.c2reto4y5.elkin.model.dao.ProyectoBancoDao;
import com.utp.misiontic2022.c2reto4y5.elkin.model.vo.ProyectoBancoVo;

public class ReportesController {
    private ProyectoBancoDao proyectoBancoDao;
    //private DeudasPorProyectoDao deudasPorProyectoDao;
    //private ComprasDeLiderDao comprasDeLiderDao;

    public ReportesController() {    
        proyectoBancoDao = new ProyectoBancoDao();
        //deudasPorProyectoDao = new DeudasPorProyectoDao();
        //comprasDeLiderDao = new ComprasDeLiderDao();
    }   

    public List<ProyectoBancoVo> listarProyectosPorBanco(String banco) throws SQLException {
        return proyectoBancoDao.listarProyectosBanco(banco);
    }
    /*public List<DeudasPorProyectoVo> listarTotalAdeudadoPorProyectoSuperioresAlLimite(Double limiteInferior) throws SQLException {
        return deudasPorProyectoDao.listarTotalAdeudadoPorProyectoSuperioresLimite(limiteInferior);
    }
    public List<ComprasDeLiderVo> listarLideresQueMasGastan() throws SQLException {
        return comprasDeLiderDao.listarLideresQueGastan();
    }*/
    
}
