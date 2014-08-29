/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lucenedb;

import java.sql.*;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;

/**
 *
 * @author majo
 */
public class LuceneDB {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        //conectarme a la base de datos
        try{
            Class.forName("com.mysql.jdbc.Driver");
            // Establecemos la conexión con la base de datos.
            Connection conexion = DriverManager.getConnection ("jdbc:mysql://localhost/prueba_lucene","root", "");
            // Preparamos la consulta
            Statement s = conexion.createStatement();
            
            
            //*********** CODIGO SOLO PARA PRUEBAS DEL CORRECTO CARGADO DE TODOS LOS DATOS ***********
            //ResultSet rs = s.executeQuery ("select count(*) from productos"); //lo uso para ver si se guardaron todos los registros
            //ResultSet rs = s.executeQuery ("select * from productos");
            
            /*leo los resultados para ver si funciona bn
            while (rs.next()){
                System.out.println (rs.getString (1) + " " + rs.getString (2)+ " " + rs.getInt(3));
                //System.out.println (rs.getString (1)); //impresion de la cantidad de registros
            }*/
            //*********** FIN *********** 
            
            
            //Lucene
            StandardAnalyzer analyzer = new StandardAnalyzer(Version.LUCENE_40);            
            Directory index = new RAMDirectory();            
            IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_40, analyzer);            
            IndexWriter writer = new IndexWriter(index, config);
            String sql = "select DESCRIPCION FROM productos";  
            Statement stmt = conexion.createStatement();  
            ResultSet rt = stmt.executeQuery(sql);  
            while (rt.next()) {  
                Document d = new Document();  
                d.add(new TextField ("desc", rt.getString("DESCRIPCION"), Field.Store.YES));
                writer.addDocument(d);  
            }  
            writer.close();
            
            //busqueda
            int hitsPerPage = 10;
            String querystr = "a" + "*";
            Query q = new QueryParser(Version.LUCENE_40, "desc", analyzer).parse(querystr);
            IndexReader reader = DirectoryReader.open(index);
            IndexSearcher searcher = new IndexSearcher(reader);
            TopScoreDocCollector collector = TopScoreDocCollector.create(hitsPerPage, true);
            searcher.search(q, collector);
            ScoreDoc[] hits = collector.topDocs().scoreDocs;
            
            //mostrar resultados
            if (hits.length==0)
                System.out.println ("Sin resultados");
            else{
                for(int i=0;i<hits.length;++i) {
                    int docId = hits[i].doc;
                    Document d = searcher.doc(docId);
                    System.out.println (d.get("desc"));
                }
            }
        }catch (Exception e){
           e.printStackTrace();
        } 
    }
    
}
