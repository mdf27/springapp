package SAF.Datos.Stock;
import SAF.Datos.Abstract.AbstractDAO;
import SAF.VO.Stock.DatosCompletosMedProdVO;
import SAF.VO.Stock.DatosCompletosMedicamentoVO;
import SAF.VO.Stock.DatosCompletosProductoVO;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
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

/**
 *
 * @author majo
 */
//@Service
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
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
        while (it.hasNext()){
            Date date = (Date)it.next();
            if (size!=1)
                resultado+= formateador.format(date) +",";
            else
                resultado+= formateador.format(date);
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
        List<String> presentaciones = m.getPresentacion();
        ListIterator it = presentaciones.listIterator();
        int size= presentaciones.size();
        while (it.hasNext()){
            String d= (String)it.next();
            if (size!=1)
                resultado+= d +", ";
            else
                resultado+=d;
            size--;
        }
        return resultado;
    }
    
    private String devolverDescripcionDescuentos(DatosCompletosProductoVO m){
        String resultado="";
        List<String> descripciones = m.getDescripcionDescuento();
        ListIterator it = descripciones.listIterator();
        int size= descripciones.size();
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
        
    private String devolverDescuentos(DatosCompletosProductoVO m){
        String resultado="";
        List<Double> descripciones = m.getDescuentos();
        ListIterator it = descripciones.listIterator();
        int size= descripciones.size();
        while (it.hasNext()){
            String d= ""+it.next();
            if (size!=1)
                resultado+= d +",\n";
            else
                resultado+=d;
            size--;
        }
        return resultado;
    }    
    
    public void crearIndiceProductosLuecene (Map <Integer,DatosCompletosProductoVO> productos,Map <Integer,DatosCompletosMedicamentoVO> medicamentos ) throws ClassNotFoundException, SQLException, IOException, ParseException{       
        //Lucene
        StandardAnalyzer analyzer = new StandardAnalyzer(Version.LUCENE_40);            
        IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_40, analyzer);            
        IndexWriter writer = new IndexWriter(indiceProductosLucene, config);        
        
        Iterator it = productos.keySet().iterator();
        while(it.hasNext()){
            DatosCompletosProductoVO rt = (DatosCompletosProductoVO)productos.get(it.next());
            Document d = new Document();
            d.add(new org.apache.lucene.document.TextField ("idProducto", ""+rt.getIdProducto(), Field.Store.YES));
            d.add(new org.apache.lucene.document.TextField ("descripcion", rt.getDescripcion(), Field.Store.YES));
   
            d.add(new org.apache.lucene.document.TextField ("precioVenta", ""+rt.getPrecioVenta(), Field.Store.YES));
            d.add(new org.apache.lucene.document.TextField ("precioCompra", ""+rt.getPrecioCompra(), Field.Store.YES));
            d.add(new org.apache.lucene.document.TextField ("porcentajeIva", ""+rt.getPorcentajeIva(), Field.Store.YES));
            if(rt.isHabilitado())
                d.add(new org.apache.lucene.document.TextField ("habilitado", "true", Field.Store.YES));
            else
                d.add(new org.apache.lucene.document.TextField ("habilitado", "false", Field.Store.YES));
            d.add(new org.apache.lucene.document.TextField ("cantidad", ""+rt.getCantidadStock(), Field.Store.YES));
            d.add(new org.apache.lucene.document.TextField ("codigos", devolverCodigosBarraProducto(rt), Field.Store.YES));
            d.add(new org.apache.lucene.document.TextField ("proveedor", rt.getProveedor(), Field.Store.YES));
            d.add(new org.apache.lucene.document.TextField ("tipoIva", rt.getTipoIVA(), Field.Store.YES));
            d.add(new org.apache.lucene.document.TextField ("vencimientos",devolverVencimientosProducto(rt), Field.Store.YES));
            d.add(new org.apache.lucene.document.TextField ("descuentos",""+devolverDescuentos(rt), Field.Store.YES));
            d.add(new org.apache.lucene.document.TextField ("descipcionesDescuento",devolverDescripcionDescuentos(rt), Field.Store.YES));
            
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

    public void setIndiceProductosLucene(Directory indiceProductosLucene) {
        this.indiceProductosLucene = indiceProductosLucene;
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
    
    public List<DatosCompletosMedProdVO> buscarProducto(String texto_buscar, String filtro) throws IOException, ParseException, java.text.ParseException{
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
                //querystr = "numero: "+ texto_buscar + "* OR laboratorio: "+ texto_buscar + "* OR descripcion: " + texto_buscar +"*";
                querystr = "descripcion:*";
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
        DatosCompletosMedProdVO productoMedicamento=null;
        List<DatosCompletosMedProdVO> productos=null;
        //mostrar resultados
        if (hits.length>0){                
            productos = new LinkedList<>();
            for(int i=0;i<hits.length;i++) {
                int docId = hits[i].doc;
                Document d = searcher.doc(docId);
                productoMedicamento = new DatosCompletosMedProdVO();
                int idProducto = Integer.valueOf(d.get("idProducto"));
                String desc = d.get("descripcion");
                String habilitado;
                if (d.get("habilitado").equals("true"))
                    habilitado ="Disponible";
                else
                    habilitado ="No Disponible";
                int cantidad =Integer.valueOf(d.get("cantidad"));
                String vencimientos = d.get("vencimientos");
                String codigos = d.get("codigos");
                String proveedor =d.get("proveedor");
                String tipoIva = d.get("tipoIva");
                String receta="";
                if (d.get("requiereReceta").equals("Si"))
                    receta+="Si";
                else
                    receta+="No";
                String drogas =  d.get("drogas");
                String laboratorio =  d.get("laboratorio");
                String accion = d.get("accion");
                String presentacion=  d.get("presentacion");
                double descuentoReceta = 0;
                double descuentoProducto = 0;
                double precioVenta = Double.valueOf(d.get("precioVenta"));
                precioVenta=Math.round(precioVenta*100.0)/100.0;
                double precioLista = precioVenta;   
                precioLista = Math.round(precioLista*100.0)/100.0;
                double porcentajeIva = Double.valueOf(d.get("porcentajeIva"));
                porcentajeIva = Math.round(porcentajeIva*100.0)/100.0;
                double farmaDescuento =0;
                
                String descripcionesDescuentos = d.get("descipcionesDescuento");
                descripcionesDescuentos=descripcionesDescuentos.replace(",", " ");
                descripcionesDescuentos=descripcionesDescuentos.replace("\n","");
                String [] listaDescripcionDescuentos = descripcionesDescuentos.split(" ");
                
                String descuentos = d.get("descuentos");
                descuentos=descuentos.replace(",", " ");
                descuentos=descuentos.replace("\n","");
                String [] listaDescuentos = descuentos.split(" ");
                
                int size= listaDescripcionDescuentos.length;                
                DecimalFormat df = new DecimalFormat("#.##");  
                Number numero;
                for (int j=0;j<size;j++){
                    numero = df.parse(listaDescuentos[j]);
                    descuentoReceta=numero.doubleValue();
                    switch (listaDescripcionDescuentos[j]) {
                        case "Producto":
                            precioVenta -= precioVenta*(descuentoProducto/100);
                            precioVenta= Math.round(precioVenta*100.0)/100.0;
                            break;
                        case "Receta":
                            farmaDescuento = precioLista-(precioLista*(descuentoReceta/100));
                            farmaDescuento= Math.round(farmaDescuento*100.0)/100.0;
                            break;
                    }
                }
                             
                double precioCompra = Double.valueOf(d.get("precioCompra"));
                precioCompra= Math.round(precioCompra*100.0)/100.0;
                productoMedicamento.setFarmaDescuento(farmaDescuento);
                productoMedicamento.setPorcentajeIva(porcentajeIva);
                productoMedicamento.setDescuentoProducto(descuentoProducto);                
                productoMedicamento.setDescuentoReceta(descuentoReceta);          
                productoMedicamento.setDescripcion(desc);
                productoMedicamento.setAccion(accion);
                productoMedicamento.setCantidad(cantidad);
                productoMedicamento.setCodigos(codigos);
                productoMedicamento.setHabilitado(habilitado);
                productoMedicamento.setIdProducto(idProducto);
                productoMedicamento.setDrogas(drogas);
                productoMedicamento.setLaboratorio(laboratorio);
                productoMedicamento.setPrecioCompra(precioCompra);
                productoMedicamento.setPrecioVenta(precioVenta);
                productoMedicamento.setPrecioLista(precioLista);
                productoMedicamento.setPresentacion(presentacion);
                productoMedicamento.setProveedor(proveedor);
                productoMedicamento.setReceta(receta);
                productoMedicamento.setTipoIVA(tipoIva);
                productoMedicamento.setVencimientos(vencimientos);

                productos.add(productoMedicamento);
            }
            
        }
        reader.close();

        return productos;
    }
}
