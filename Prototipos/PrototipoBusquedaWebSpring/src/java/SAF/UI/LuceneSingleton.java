package SAF.UI;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;

/**
 *
 * @author majo
 */
public class LuceneSingleton{
    private static LuceneSingleton instance;
    private Directory indiceProductosLucene = new RAMDirectory();  
    
    public Directory getIndiceProductosLucene(){
        return indiceProductosLucene;
    }
    
    private void  crearIndiceProductosLuecene (String consultaSQL)
                                throws ClassNotFoundException, SQLException, IOException, ParseException{
        Class.forName("com.mysql.jdbc.Driver");
        // Establecemos la conexión con la base de datos.
        Connection conexion = DriverManager.getConnection ("jdbc:mysql://localhost/prueba_lucene","root", "");

        //Lucene
        StandardAnalyzer analyzer = new StandardAnalyzer(Version.LUCENE_40);            
        //Directory index = new RAMDirectory();            
        IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_40, analyzer);            
        IndexWriter writer = new IndexWriter(indiceProductosLucene, config);
        Statement stmt = conexion.createStatement();
        ResultSet rt = stmt.executeQuery(consultaSQL);

        while (rt.next()) {
            Document d = new Document();
            d.add(new org.apache.lucene.document.TextField ("nro", rt.getString("NRO_ARTICULO"), Field.Store.YES));
            d.add(new org.apache.lucene.document.TextField ("lab", rt.getString("LAB"), Field.Store.YES));
            d.add(new org.apache.lucene.document.TextField ("desc", rt.getString("DESCRIPCION"), Field.Store.YES));
            d.add(new org.apache.lucene.document.TextField ("proveedor", "Juan Perez", Field.Store.YES));
            d.add(new org.apache.lucene.document.TextField ("precio", rt.getString("PRECIO"), Field.Store.YES));
            d.add(new org.apache.lucene.document.TextField ("descuento", rt.getString("T_IVA"), Field.Store.YES));
            d.add(new org.apache.lucene.document.TextField ("precio_oferta", rt.getString("PRECIO_OFERTA"), Field.Store.YES));
            writer.addDocument(d);
        }
        writer.close();        
    }       
          
    public static LuceneSingleton getInstance(String consultaSQL) 
            throws ClassNotFoundException, SQLException, IOException, ParseException{
        if(instance == null){
            LuceneSingleton bs = new LuceneSingleton();
            bs.indiceProductosLucene =  new RAMDirectory();  
            bs.crearIndiceProductosLuecene(consultaSQL);
            instance = bs;
        }
        return instance;
    };
    
    public void actualizarIndiceProductosLucene (String consultaSQL)
            throws ClassNotFoundException, SQLException, IOException, ParseException{
        crearIndiceProductosLuecene(consultaSQL);
    }    
    
}
