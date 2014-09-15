/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SAF.UI;

/**
 *
 * @author majo
 */
import java.io.IOException;
import java.sql.SQLException;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.store.Directory;
import org.apache.lucene.util.Version;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class luceneController {    
    @RequestMapping(value = "busqueda.htm",method = RequestMethod.GET)  
    
    public @ResponseBody String buscar (@RequestParam(value="buscar") String texto_buscar, @RequestParam(value="filtro") String filtro) throws ClassNotFoundException, SQLException, IOException, ParseException{
        String sql = "select NRO_ARTICULO, LAB, DESCRIPCION, PRECIO_VENTA, PRECIO_OFERTA, T_IVA FROM productos;";  
        LuceneSingleton ls = LuceneSingleton.getInstance(sql);
        Directory index = ls.getIndiceProductosLucene();
        StandardAnalyzer analyzer = new StandardAnalyzer(Version.LUCENE_40); 
        
        //busqueda
        int hitsPerPage = 50;
        String querystr;
        boolean espacios=false;
        if (texto_buscar.indexOf(" ")>0){
            //texto_buscar.replace(" ", " AND ");
            texto_buscar = "\"" + texto_buscar + "\"";
            System.out.println(texto_buscar);
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
        IndexReader reader = DirectoryReader.open(index);
        IndexSearcher searcher = new IndexSearcher(reader);
        TopScoreDocCollector collector = TopScoreDocCollector.create(hitsPerPage, true);
        searcher.search(q, collector);
        ScoreDoc[] hits = collector.topDocs().scoreDocs;

        //mostrar resultados
        String salida="";
        if (hits.length>0){                
            int docId = hits[0].doc;
            Document d = searcher.doc(docId);
            String nro = "\"nro\":"+d.get("nro")+",";
            String lab = "\"lab\":\""+d.get("lab")+"\",";
            String desc = "\"descripcion\":\""+d.get("desc")+"\",";
            String proveedor = "\"prov\":\""+d.get("proveedor")+"\",";
            String precio = "\"precio\":"+d.get("precio")+",";
            String descuento = "\"descuento\":\""+d.get("descuento")+"\",";
            String precio_oferta = "\"oferta\":\""+d.get("precio_oferta")+"\"";
            salida+="{"+nro+lab+desc+proveedor+precio+descuento+precio_oferta+"}";
            for(int i=1;i<hits.length;i++) {
                docId = hits[i].doc;
                d = searcher.doc(docId);
                nro = "\"nro\":"+d.get("nro")+",";
                lab= "\"lab\":\""+d.get("lab")+"\",";
                desc = "\"descripcion\":\""+d.get("desc")+"\",";
                proveedor = "\"prov\":\""+d.get("proveedor")+"\",";
                precio = "\"precio\":"+d.get("precio")+",";
                descuento = "\"descuento\":\""+d.get("descuento")+"\",";
                precio_oferta = "\"oferta\":\""+d.get("precio_oferta")+"\"";
                salida+=",{"+nro+lab+desc+proveedor+precio+descuento+precio_oferta+"}";
            }
        }
        reader.close();

        salida="["+salida+"]";
        
        return salida;        
    }
}
