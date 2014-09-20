package SAF.UI.Stock;

import SAF.Logica.Stock.BuscarProductoManager;
import SAF.VO.Stock.ProductoVO;
import SAF.VO.Stock.StockVO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.List;
import java.util.ListIterator;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

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
    
    private void  crearIndiceProductosLuecene () throws ClassNotFoundException, SQLException, IOException, ParseException{       
        //Lucene
        StandardAnalyzer analyzer = new StandardAnalyzer(Version.LUCENE_40);            
        IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_40, analyzer);            
        IndexWriter writer = new IndexWriter(indiceProductosLucene, config);
        
        //Manejador
        ApplicationContext context = new FileSystemXmlApplicationContext ("applicationContext.xml");
        BuscarProductoManager bpm = (BuscarProductoManager) context.getBean(BuscarProductoManager.class);
        List<ProductoVO> productos = bpm.buscarProductos();
        List<StockVO> stock = bpm.buscarProductoStock();
        
        //formateador
        DecimalFormat formateador = new DecimalFormat("#####.##");
        int i=0;
        for (ProductoVO rt : productos) {
            Document d = new Document();
            d.add(new org.apache.lucene.document.TextField ("descripcion", rt.getDescripcion(), Field.Store.YES));
            d.add(new org.apache.lucene.document.TextField ("precioVenta", formateador.format(rt.getPrecioVenta()), Field.Store.YES));
            d.add(new org.apache.lucene.document.TextField ("precioCompra", formateador.format(rt.getPrecioCompra()), Field.Store.YES));
            if(rt.isHabilitado())
                d.add(new org.apache.lucene.document.TextField ("habilitado", "true", Field.Store.YES));
            else
                d.add(new org.apache.lucene.document.TextField ("habilitado", "false", Field.Store.YES));
            d.add(new org.apache.lucene.document.TextField ("cantidad", ""+stock.get(i).getCantidad(), Field.Store.YES));
            writer.addDocument(d);
            i++;
        }
        writer.close();        
    }       
          
    public static LuceneSingleton getInstance() 
            throws ClassNotFoundException, SQLException, IOException, ParseException{
        if(instance == null){
            LuceneSingleton bs = new LuceneSingleton();
            bs.indiceProductosLucene =  new RAMDirectory();  
            bs.crearIndiceProductosLuecene();
            instance = bs;
        }
        return instance;
    };
    
    public void actualizarIndiceProductosLucene (String consultaSQL)
            throws ClassNotFoundException, SQLException, IOException, ParseException{
        crearIndiceProductosLuecene();
    }    
    
}
