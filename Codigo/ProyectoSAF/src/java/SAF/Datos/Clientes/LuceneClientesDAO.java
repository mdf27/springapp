/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.Datos.Clientes;

import SAF.Datos.Abstract.AbstractDAO;
import SAF.VO.Clientes.DatosCompletosClienteVO;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
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
import org.springframework.stereotype.Repository;

/**
 *
 * @author majo
 */
@Repository
public class LuceneClientesDAO extends AbstractDAO{
    private static LuceneClientesDAO instance;
    
    private Directory indiceClientesLucene = null;

    public Directory getIndiceClientesLucene() {
        return indiceClientesLucene;
    }
    
    private String formatearFecha (Date date){
        String resultado="";
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
        resultado+= formateador.format(date);
        return resultado;
    }
    
    public void crearIndiceClientesLuecene (Map <Integer,DatosCompletosClienteVO> clientes) throws ClassNotFoundException, SQLException, IOException, ParseException{       
        //Lucene
        StandardAnalyzer analyzer = new StandardAnalyzer(Version.LUCENE_40);            
        IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_40, analyzer);            
        IndexWriter writer = new IndexWriter(indiceClientesLucene, config);        
        
        Iterator it = clientes.keySet().iterator();
        while(it.hasNext()){
            DatosCompletosClienteVO rt = (DatosCompletosClienteVO)clientes.get(it.next());
            Document d = new Document();
            int idCliente = rt.getIdCliente();
            d.add(new org.apache.lucene.document.TextField ("idCliente", ""+idCliente, Field.Store.YES));
            d.add(new org.apache.lucene.document.TextField ("apellidos", rt.getApellidos(), Field.Store.YES));
   
            d.add(new org.apache.lucene.document.TextField ("nombres", rt.getNombres(), Field.Store.YES));
            d.add(new org.apache.lucene.document.TextField ("direccion", rt.getDireccion(), Field.Store.YES));
            d.add(new org.apache.lucene.document.TextField ("telefono", rt.getTelefono(), Field.Store.YES));
            d.add(new org.apache.lucene.document.TextField ("email", rt.getEmail(), Field.Store.YES));
            d.add(new org.apache.lucene.document.TextField ("cedula", ""+rt.getCedula(), Field.Store.YES));
            d.add(new org.apache.lucene.document.TextField ("razonSocial", ""+rt.getRazonSocial(), Field.Store.YES));
            d.add(new org.apache.lucene.document.TextField ("rut", ""+rt.getRut(), Field.Store.YES));
            d.add(new org.apache.lucene.document.TextField ("descuento", ""+rt.getDescuento(), Field.Store.YES));
            d.add(new org.apache.lucene.document.TextField ("fCreacion", formatearFecha(rt.getfCreacion()), Field.Store.YES));
            d.add(new org.apache.lucene.document.TextField ("idCuenta",""+rt.getIdCuenta(), Field.Store.YES));
            d.add(new org.apache.lucene.document.TextField ("saldo",""+rt.getSaldo(), Field.Store.YES));
            d.add(new org.apache.lucene.document.TextField ("tope",""+rt.getTope(), Field.Store.YES));
            d.add(new org.apache.lucene.document.TextField ("fCreacionCuenta",formatearFecha(rt.getfCreacionCuenta()), Field.Store.YES));
            
            writer.addDocument(d);
        }
        writer.close();        
    }       
          
    public static LuceneClientesDAO getInstance() 
            throws ClassNotFoundException, SQLException, IOException, ParseException{
       if(instance == null){
            LuceneClientesDAO bs = new LuceneClientesDAO();
            instance = bs;
        }
        return instance;
    };
    
    public boolean indiceCargado(){
        return (indiceClientesLucene!=null);
    }

    public void setIndiceClientesLucene(Directory indiceClientesLucene) {
        this.indiceClientesLucene = indiceClientesLucene;
    }
    
    public void cargarClientes(Map <Integer,DatosCompletosClienteVO>clientes)
                        throws ClassNotFoundException, SQLException, IOException, ParseException{  
        indiceClientesLucene =  new RAMDirectory();  
        crearIndiceClientesLuecene(clientes);        
    }
    
    private void  eliminarIndice () throws IOException{
        StandardAnalyzer analyzer = new StandardAnalyzer(Version.LUCENE_40);            
        IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_40, analyzer);            
        IndexWriter writer = new IndexWriter(indiceClientesLucene, config);        
        writer.deleteAll();
        writer.close();
        this.indiceClientesLucene= new RAMDirectory();
    }
    
    public void actualizarIndiceProductosLucene (Map <Integer,DatosCompletosClienteVO> clientes)
            throws ClassNotFoundException, SQLException, IOException, ParseException{
        eliminarIndice();
        crearIndiceClientesLuecene(clientes);
    }    
    
    
    private void cargarListaClientes(Document d, List<DatosCompletosClienteVO> clientes) throws java.text.ParseException{
            DatosCompletosClienteVO cliente=new DatosCompletosClienteVO();
            int idCliente = Integer.valueOf(d.get("idCliente"));
            String nombres = d.get("nombres");
            int idCuenta =Integer.valueOf(d.get("idCuenta"));
            String apellidos = d.get("apellidos");
            String direccion = d.get("direccion");
            String telefono =d.get("telefono");
            String email = d.get("email");
            String razonSocial=d.get("razonSocial");
            int cedula = Integer.valueOf(d.get("cedula"));
            int rut = Integer.valueOf(d.get("rut"));
            double descuento = Double.valueOf(d.get("descuento"));
            String fCreacion = d.get("fCreacion");
            String fCreacionCuenta = d.get("fCreacionCuenta");
            double saldo = Double.valueOf(d.get("saldo"));
            double tope = Double.valueOf(d.get("tope"));
            
            cliente.setApellidos(apellidos);
            cliente.setCedula(cedula);
            cliente.setDescuento(descuento);
            cliente.setDireccion(direccion);
            cliente.setEmail(email);
            cliente.setIdCliente(idCliente);
            cliente.setIdCuenta(idCuenta);
            cliente.setNombres(nombres);
            cliente.setRazonSocial(razonSocial);
            cliente.setRut(rut);
            cliente.setSaldo(saldo);
            cliente.setTelefono(telefono);
            cliente.setTope(tope);
            Date date = new Date(fCreacion);
            cliente.setfCreacion(date);
            Date date1 = new Date(fCreacionCuenta);
            cliente.setfCreacionCuenta(date1);
            
            clientes.add(cliente);
    }
    
    public List<DatosCompletosClienteVO> buscarCliente(String texto_buscar, String filtro) throws IOException, ParseException, java.text.ParseException, org.apache.lucene.queryparser.classic.ParseException{
        StandardAnalyzer analyzer = new StandardAnalyzer(Version.LUCENE_40); 
        
        //busqueda
        int hitsPerPage = 50;
        String querystr;
        boolean espacios=false;
        if (texto_buscar.indexOf(" ")>0){            
            texto_buscar = "\"" + texto_buscar + "\"";         
            espacios=true;
        }
        
        /*if (filtro.equals("all")){
            if (espacios)
                querystr = querystr = "nombres: "+ texto_buscar + " OR apellidos: "+ texto_buscar + " OR descripcion: " + texto_buscar+ " OR drogas: " + texto_buscar+ " OR presentacion: " + texto_buscar;
            else
                querystr = "codigos: "+ texto_buscar + "* OR laboratorio: "+ texto_buscar + "* OR descripcion: " + texto_buscar +"* OR presentacion: " + texto_buscar +"* OR drogas: " + texto_buscar +"*";
                
        }else{
            if (espacios)
                querystr = filtro+ ": " + texto_buscar;//+ " *";
            else
                querystr = filtro+ ":" + texto_buscar + "*";            
        }*/
        if (espacios)
            querystr = querystr = "nombres: "+ texto_buscar + " OR apellidos: "+ texto_buscar ;
        else
            querystr = "nombres: "+ texto_buscar + "* OR apellidos: "+ texto_buscar +"*";
        
        Query q = new QueryParser(Version.LUCENE_40,"", analyzer).parse(querystr);
        
        IndexReader reader = DirectoryReader.open(this.indiceClientesLucene);
        IndexSearcher searcher = new IndexSearcher(reader);
        TopScoreDocCollector collector = TopScoreDocCollector.create(hitsPerPage, true);
        searcher.search(q, collector);
        ScoreDoc[] hits = collector.topDocs().scoreDocs;
        
        List<DatosCompletosClienteVO> clientes=null;
        //mostrar resultados
        if (hits.length>0){                
            clientes = new LinkedList<>();
            for(int i=0;i<hits.length;i++) {
                int docId = hits[i].doc;
                Document d = searcher.doc(docId);
                cargarListaClientes(d, clientes);
            }            
        }
        reader.close();

        return clientes;
    }

}
