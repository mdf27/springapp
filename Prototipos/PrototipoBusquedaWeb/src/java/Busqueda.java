/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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


/**
 *
 * @author majo
 */
public class Busqueda extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Busqueda</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Busqueda at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    private void buscar(HttpServletRequest request, HttpServletResponse response){
          try{
            Class.forName("com.mysql.jdbc.Driver");
            // Establecemos la conexión con la base de datos.
            Connection conexion = DriverManager.getConnection ("jdbc:mysql://localhost/prueba_lucene","root", "");
                        
            //Lucene
            StandardAnalyzer analyzer = new StandardAnalyzer(Version.LUCENE_40);            
            Directory index = new RAMDirectory();            
            IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_40, analyzer);            
            IndexWriter writer = new IndexWriter(index, config);
            
            // Preparamos la consulta
            //String sql = "select DESCRIPCION FROM productos";  
            String sql = "select NRO_ARTICULO, LAB, DESCRIPCION, PRECIO, PRECIO_OFERTA, T_IVA FROM productos;";
            Statement stmt = conexion.createStatement();  
            ResultSet rt = stmt.executeQuery(sql);  
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
            
            //busqueda
            int hitsPerPage = 50;
            String querystr = request.getParameter("filtro") + "*";
            Query q = new QueryParser(Version.LUCENE_40, "desc", analyzer).parse(querystr);
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
                //salida+="{\"descripcion\":\""+d.get("desc")+"\"}";
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
            
           //salida += ",[\"12345\",\""+"Aspirinas\",\"Juan\",\"$123\",\"20%\", \"130\"]";
      
            salida="["+salida+"]";
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(salida);
        }catch (ClassNotFoundException | SQLException | IOException | ParseException e){
        } 
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        buscar(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
