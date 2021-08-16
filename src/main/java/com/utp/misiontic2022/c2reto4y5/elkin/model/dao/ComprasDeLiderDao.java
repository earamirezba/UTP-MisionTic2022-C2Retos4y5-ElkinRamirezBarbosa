package com.utp.misiontic2022.c2reto4y5.elkin.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.utp.misiontic2022.c2reto4y5.elkin.model.vo.ComprasDeLiderVo;
import com.utp.misiontic2022.c2reto4y5.elkin.util.JDBCUtilities;

public class ComprasDeLiderDao {
    
    public List<ComprasDeLiderVo> listarLideresQueGastan() throws SQLException {
        List<ComprasDeLiderVo> respuesta = new ArrayList<>();
        var conn = JDBCUtilities.getConnection();
        PreparedStatement stmt = null;
        ResultSet rset = null;
        try {
            var query = "SELECT l.Nombre || ' ' || l.Primer_Apellido || ' ' || l.Segundo_Apellido as LIDER, SUM(c.Cantidad * mc.Precio_unidad) as VALOR "
                    + "FROM Lider l "
                    + "JOIN Proyecto p ON p.ID_Lider = l.ID_Lider JOIN Compra c ON c.ID_Proyecto = p.Id_Proyecto "
                    + "JOIN MaterialConstruccion mc ON mc.ID_MaterialConstruccion = c.ID_MaterialConstruccion "
                    + "GROUP BY LIDER ORDER BY Valor DESC LIMIT 10";

            stmt = conn.prepareStatement(query);
            rset = stmt.executeQuery();

            while (rset.next()) {
                var vo = new ComprasDeLiderVo();
                vo.setLider(rset.getString("LIDER"));
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
