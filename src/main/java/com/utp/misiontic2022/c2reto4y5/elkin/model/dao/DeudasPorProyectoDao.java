package com.utp.misiontic2022.c2reto4y5.elkin.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.utp.misiontic2022.c2reto4y5.elkin.model.vo.DeudasPorProyectoVo;
import com.utp.misiontic2022.c2reto4y5.elkin.util.JDBCUtilities;

public class DeudasPorProyectoDao {
    public List<DeudasPorProyectoVo> listarTotalAdeudadoPorProyectoSuperioresLimite(Double limiteInferior) throws SQLException {
        List<DeudasPorProyectoVo> respuesta = new ArrayList<>();
        var conn = JDBCUtilities.getConnection();
        PreparedStatement stmt = null;
        ResultSet rset = null;
        try {
            var query = "SELECT ID_Proyecto	as ID, SUM(Cantidad * mc.Precio_unidad) as VALOR "
                    + "FROM Compra "
                    + "JOIN MaterialConstruccion mc ON mc.ID_MaterialConstruccion = Compra.ID_MaterialConstruccion "
                    + "WHERE Pagado = 'No' " 
                    + "GROUP BY ID_Proyecto "
                    + "HAVING valor > ? "
                    + "ORDER BY valor DESC";

            stmt = conn.prepareStatement(query); 
            stmt.setDouble(1, limiteInferior);       
            rset = stmt.executeQuery();

            while (rset.next()) {
                var vo = new DeudasPorProyectoVo();
                vo.setId(rset.getInt("ID"));
                vo.setValor(rset.getDouble("VALOR"));            
                respuesta.add(vo);
            }
        } finally {
            if (rset != null) {
                rset.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return respuesta;
    }
    
}
