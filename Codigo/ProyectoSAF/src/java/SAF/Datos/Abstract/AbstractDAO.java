/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SAF.Datos.Abstract;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Guillermo
 */
public abstract class AbstractDAO extends JdbcDaoSupport{
    
    @Autowired()
    public void setData(DataSource dataSource) {
        this.setDataSource(dataSource);
    }
    
    @Transactional
    protected Long getLastID(){
        String sql = "SELECT LAST_INSERT_ID()";
        
        return getJdbcTemplate().queryForObject(sql, Long.class);
    }
}
