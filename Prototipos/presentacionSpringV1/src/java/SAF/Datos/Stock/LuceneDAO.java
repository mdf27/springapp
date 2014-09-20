package SAF.Datos.Stock;

import SAF.VO.Stock.ProductoVO;
import SAF.VO.Stock.StockVO;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;
import org.springframework.stereotype.Service;

/**
 *
 * @author majo
 */
@Service
public class LuceneDAO{
        
    private static LuceneDAO instance;
    
    private Directory indiceProductosLucene = null; //new RAMDirectory();  
    
    public Directory getIndiceProductosLucene(){
        return indiceProductosLucene;
    }
    
    private void crearIndiceProductosLuecene (List<ProductoVO> productos,List<StockVO> stock ) throws ClassNotFoundException, SQLException, IOException, ParseException{       
        //Lucene
        StandardAnalyzer analyzer = new StandardAnalyzer(Version.LUCENE_40);            
        IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_40, analyzer);            
        IndexWriter writer = new IndexWriter(indiceProductosLucene, config);        
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
          
    public static LuceneDAO getInstance() 
            throws ClassNotFoundException, SQLException, IOException, ParseException{
       if(instance == null){
            LuceneDAO bs = new LuceneDAO();
            instance = bs;
        }
        return instance;
    };
    
    public boolean indiceCargado(){
        return (indiceProductosLucene==null);
    }
    
    public void cargarProductos(List<ProductoVO> productos,List<StockVO> stock ) throws ClassNotFoundException, SQLException, IOException, ParseException{  
        indiceProductosLucene =  new RAMDirectory();  
        crearIndiceProductosLuecene(productos,stock );        
    }
    
    public void actualizarIndiceProductosLucene (List<ProductoVO> productos,List<StockVO> stock )
            throws ClassNotFoundException, SQLException, IOException, ParseException{
        crearIndiceProductosLuecene(productos,stock);
    }    
    
    public String buscarProducto(String texto_buscar, String filtro) throws IOException, ParseException{
        StandardAnalyzer analyzer = new StandardAnalyzer(Version.LUCENE_40); 
        
        //busqueda
        int hitsPerPage = 50;
        String querystr;
        boolean espacios=false;
        if (texto_buscar.indexOf(" ")>0){            
            texto_buscar = "\"" + texto_buscar + "\"";         
            espacios=true;
        }
        
        if (filtro.equals("all")){
            if (espacios)
                querystr = querystr = "nro: "+ texto_buscar + " OR lab: "+ texto_buscar + " OR desc: " + texto_buscar;
            else
                querystr = "nro: "+ texto_buscar + "* OR lab: "+ texto_buscar + "* OR desc: " + texto_buscar +"*";
        }else{
            if (espacios)
                querystr = filtro+ ": " + texto_buscar;//+ " *";
            else
                querystr = filtro+ ":" + texto_buscar + "*";            
        }
        Query q = new QueryParser(Version.LUCENE_40,"", analyzer).parse(querystr);
        
        IndexReader reader = DirectoryReader.open(indiceProductosLucene);
        IndexSearcher searcher = new IndexSearcher(reader);
        TopScoreDocCollector collector = TopScoreDocCollector.create(hitsPerPage, true);
        searcher.search(q, collector);
        ScoreDoc[] hits = collector.topDocs().scoreDocs;

        //mostrar resultados
        String salida="";
        if (hits.length>0){                
            int docId = hits[0].doc;
            Document d = searcher.doc(docId);
            String desc = "\"descripcion\":\""+d.get("descripcion")+"\",";
            String precioVenta = "\"precioVenta\":"+d.get("precioVenta")+",";
            String precioCompra = "\"precioCompra\":\""+d.get("precioCompra")+"\"";
            String habilitado;
            if (d.get("habilitado").equals("true"))
                habilitado ="\"habilitado\":\""+"Disponible"+"\"";
            else
                habilitado ="\"habilitado\":\""+"No Disponible"+"\"";
            String cantidad = "\"cantidad\":\""+d.get("cantidad")+"\"";
            salida+="{"+desc+precioVenta+precioCompra+habilitado+cantidad+"}";
            for(int i=1;i<hits.length;i++) {
                docId = hits[i].doc;
                d = searcher.doc(docId);
                desc = "\"descripcion\":\""+d.get("descripcion")+"\",";
                precioVenta = "\"precioVenta\":"+d.get("precioVenta")+",";
                precioCompra = "\"precioCompra\":\""+d.get("precioCompra")+"\"";
                if (d.get("habilitado").equals("true"))
                    habilitado ="\"habilitado\":\""+"Disponible"+"\"";
                else
                    habilitado ="\"habilitado\":\""+"No Disponible"+"\"";
                cantidad = "\"cantidad\":\""+d.get("cantidad")+"\"";
                salida+="{"+desc+precioVenta+precioCompra+habilitado+cantidad+"}";
            }
        }
        reader.close();

        salida="["+salida+"]";
        return salida;
    }
    
}
