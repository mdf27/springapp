/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataLayer;

import java.util.Date;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 *
 * @author Guillermo
 */
public abstract class AbstractDAO extends JdbcDaoSupport{
    
    @Autowired()
    public void setData(DataSource ds) {
        this.setDataSource(ds);
    }
    
    protected long getLastID(){
        long retorno = Long.MIN_VALUE;
        
        String sql = "SELECT LAST_INSERT_ID()";
        
        retorno = getJdbcTemplate().queryForObject(sql, long.class);
                
        return retorno;
    }
}
