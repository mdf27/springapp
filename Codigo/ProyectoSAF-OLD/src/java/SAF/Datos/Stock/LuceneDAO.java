package SAF.Datos.Stock;
import SAF.Datos.Abstract.AbstractDAO;
import SAF.VO.Stock.DatosCompletosMedicamentoVO;
import SAF.VO.Stock.DatosCompletosProductoVO;
import SAF.VO.Stock.ProductoVO;
import SAF.VO.Stock.StockVO;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
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
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 *
 * @author majo
 */
@Service
@Repository
public class LuceneDAO extends AbstractDAO{
        
    private static LuceneDAO instance;
    
    private Directory indiceProductosLucene = null; //new RAMDirectory();  
    
    public Directory getIndiceProductosLucene(){
        return this.indiceProductosLucene;
    }
    
    private String devolverCodigosBarraProducto(DatosCompletosProductoVO p){
        String resultado="";
        List<String> codigos = p.getCodigoBarras();
        ListIterator it = codigos.listIterator();
        int size= codigos.size();
        while (it.hasNext()){
            String cod = (String)it.next();
            if (size!=1)
                resultado+= cod +",";
            else
                resultado+= cod;
            size--;
        }
        return resultado;
    }
      
    private String devolverVencimientosProducto(DatosCompletosProductoVO p){
        String resultado="";
        List<Date> vencimientos = p.getVencimientoStock();
        ListIterator it = vencimientos.listIterator();
        int size= vencimientos.size();
        while (it.hasNext()){
            Date date = (Date)it.next();
            if (size!=1)
                resultado+= date.toString() +",";
            else
                resultado+= date.toString();
            size--;
        }
        return resultado;
    }
    
    private String devolverDrogasMedicamento(DatosCompletosMedicamentoVO m){
        String resultado="";
        List<String> drogas = m.getNombreDroga();
        ListIterator it = drogas.listIterator();
        int size= drogas.size();
        while (it.hasNext()){
            String d= (String)it.next();
            if (size!=1)
                resultado+= d +",";
            else
                resultado+=d;
            size--;
        }
        return resultado;
    }
    
    private String devolverATMedicamento(DatosCompletosMedicamentoVO m){
        String resultado="";
        List<String> accionT = m.getAccionTerapeutica();
        ListIterator it = accionT.listIterator();
        int size= accionT.size();
        while (it.hasNext()){
            String d= (String)it.next();
            if (size!=1)
                resultado+= d +",";
            else
                resultado+=d;
            size--;
        }
        return resultado;
    }
    
    private String devolverPresentacionesMedicamento(DatosCompletosMedicamentoVO m){
        String resultado="";
        List<String> presentaciones = m.getNombreDroga();
        ListIterator it = presentaciones.listIterator();
        int size= presentaciones.size();
        while (it.hasNext()){
            String d= (String)it.next();
            if (size!=1)
                resultado+= d +",\n";
            else
                resultado+=d;
            size--;
        }
        return resultado;
    }
    private void crearIndiceProductosLuecene (Map <Integer,DatosCompletosProductoVO> productos,Map <Integer,DatosCompletosMedicamentoVO> medicamentos ) throws ClassNotFoundException, SQLException, IOException, ParseException{       
        //Lucene
        StandardAnalyzer analyzer = new StandardAnalyzer(Version.LUCENE_40);            
        IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_40, analyzer);            
        IndexWriter writer = new IndexWriter(indiceProductosLucene, config);        
        
        Iterator it = productos.keySet().iterator();
        while(it.hasNext()){
            DatosCompletosProductoVO rt = (DatosCompletosProductoVO)productos.get(it.next());
            Document d = new Document();
            d.add(new org.apache.lucene.document.TextField ("descripcion", rt.getDescripcion(), Field.Store.YES));
   
            d.add(new org.apache.lucene.document.TextField ("precioVenta", ""+rt.getPrecioVenta(), Field.Store.YES));
            d.add(new org.apache.lucene.document.TextField ("precioCompra", ""+rt.getPrecioCompra(), Field.Store.YES));
            if(rt.isHabilitado())
                d.add(new org.apache.lucene.document.TextField ("habilitado", "true", Field.Store.YES));
            else
                d.add(new org.apache.lucene.document.TextField ("habilitado", "false", Field.Store.YES));
            d.add(new org.apache.lucene.document.TextField ("cantidad", ""+rt.getCantidadStock(), Field.Store.YES));
            d.add(new org.apache.lucene.document.TextField ("codigos", devolverCodigosBarraProducto(rt), Field.Store.YES));
            d.add(new org.apache.lucene.document.TextField ("proveedor", rt.getProveedor(), Field.Store.YES));
            d.add(new org.apache.lucene.document.TextField ("tipoIva", rt.getTipoIVA(), Field.Store.YES));
            d.add(new org.apache.lucene.document.TextField ("vencimientos",devolverVencimientosProducto(rt), Field.Store.YES));
            
            Iterator it1 = medicamentos.keySet().iterator();
            while (it1.hasNext()){
                DatosCompletosMedicamentoVO m = (DatosCompletosMedicamentoVO)medicamentos.get(it1.next());
                if (m.isRequiereReceta())
                    d.add(new org.apache.lucene.document.TextField ("requiereReceta","Si", Field.Store.YES));
                else
                    d.add(new org.apache.lucene.document.TextField ("requiereReceta","No", Field.Store.YES));
                d.add(new org.apache.lucene.document.TextField ("laboratorio",m.getNombreLaboratorio(), Field.Store.YES));
                d.add(new org.apache.lucene.document.TextField ("drogas",devolverDrogasMedicamento(m), Field.Store.YES));
                d.add(new org.apache.lucene.document.TextField ("accion",devolverATMedicamento(m), Field.Store.YES));
                d.add(new org.apache.lucene.document.TextField ("presentacion",devolverPresentacionesMedicamento(m), Field.Store.YES));
            }
            writer.addDocument(d);
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
        return (indiceProductosLucene!=null);
    }
    
    public void cargarProductos(Map <Integer,DatosCompletosProductoVO> productos,Map <Integer,DatosCompletosMedicamentoVO> medicamentos)
                        throws ClassNotFoundException, SQLException, IOException, ParseException{  
        indiceProductosLucene =  new RAMDirectory();  
        crearIndiceProductosLuecene(productos,medicamentos);        
    }
    
    public void actualizarIndiceProductosLucene (Map <Integer,DatosCompletosProductoVO> productos,Map <Integer,DatosCompletosMedicamentoVO> medicamentos)
            throws ClassNotFoundException, SQLException, IOException, ParseException{
        crearIndiceProductosLuecene(productos,medicamentos);
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
                querystr = querystr = "numero: "+ texto_buscar + " OR laboratorio: "+ texto_buscar + " OR descripcion: " + texto_buscar;
            else
                querystr = "numero: "+ texto_buscar + "* OR laboratorio: "+ texto_buscar + "* OR descripcion: " + texto_buscar +"*";
        }else{
            if (espacios)
                querystr = filtro+ ": " + texto_buscar;//+ " *";
            else
                querystr = filtro+ ":" + texto_buscar + "*";            
        }
        Query q = new QueryParser(Version.LUCENE_40,"", analyzer).parse(querystr);
        
        IndexReader reader = DirectoryReader.open(this.getIndiceProductosLucene());
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
            String precioCompra = "\"precioCompra\":"+d.get("precioCompra")+",";
            String habilitado;
            if (d.get("habilitado").equals("true"))
                habilitado ="\"habilitado\":\""+"Disponible"+"\",";
            else
                habilitado ="\"habilitado\":\""+"No Disponible"+"\",";
            String cantidad = "\"cantidad\":\""+d.get("cantidad")+"\",";
            String vencimientos = "\"vencimientos\":\""+d.get("vencimientos")+"\",";
            String codigos = "\"codigos\":\""+d.get("codigos")+"\",";
            String proveedor = "\"proveedor\":\""+d.get("proveedor")+"\",";
            String tipoIva = "\"tipoiva\":\""+d.get("tipoIva")+"\",";
            String receta =  "\"receta\":\"";
            if (d.get("requiereReceta").equals("Si"))
                receta+="Si\",";
            else
                receta+="No\",";
            String drogas =  "\"drogas\":\""+d.get("drogas")+"\",";
            String laboratorio =  "\"laboratorio\":\""+d.get("laboratorio")+"\",";
            String accion =  "\"accion\":\""+d.get("accion")+"\",";
            String presentacion=  "\"presentacion\":\""+d.get("presentacion")+"\"";
            salida+="{"+desc+precioVenta+precioCompra+habilitado+cantidad+vencimientos+codigos+proveedor+
                        tipoIva+receta+drogas+laboratorio+accion+presentacion+"}";
            for(int i=1;i<hits.length;i++) {
                docId = hits[i].doc;
                d = searcher.doc(docId);
                desc = "\"descripcion\":\""+d.get("descripcion")+"\",";
                precioVenta = "\"precioVenta\":"+d.get("precioVenta")+",";
                precioCompra = "\"precioCompra\":"+d.get("precioCompra")+",";
                if (d.get("habilitado").equals("true"))
                    habilitado ="\"habilitado\":\""+"Disponible"+"\",";
                else
                    habilitado ="\"habilitado\":\""+"No Disponible"+"\",";
                cantidad = "\"cantidad\":\""+d.get("cantidad")+"\",";
                vencimientos = "\"vencimientos\":\""+d.get("vencimientos")+"\",";
                codigos = "\"codigos\":\""+d.get("codigos")+"\",";
                proveedor = "\"proveedor\":\""+d.get("proveedor")+"\",";
                tipoIva = "\"tipoiva\":\""+d.get("tipoIva")+"\",";
                receta =  "\"receta\":\"";
                receta+="No\",";
                drogas =  "\"drogas\":\""+d.get("drogas")+"\",";
                laboratorio =  "\"laboratorio\":\""+d.get("laboratorio")+"\",";
                accion =  "\"accion\":\""+d.get("accion")+"\",";
                presentacion=  "\"presentacion\":\""+d.get("presentacion")+"\"";
                salida+=",{"+desc+precioVenta+precioCompra+habilitado+cantidad+vencimientos+codigos+proveedor+
                        tipoIva+receta+drogas+laboratorio+accion+presentacion+"}";
            }
        }
        reader.close();

        salida="["+salida+"]";
        return salida;
    }
}
