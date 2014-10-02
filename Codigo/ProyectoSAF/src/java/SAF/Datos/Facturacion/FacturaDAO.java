/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.Datos.Facturacion;

import SAF.Datos.Abstract.AbstractDAO;
import SAF.VO.Facturacion.FacturaVO;
import SAF.VO.Facturacion.IdFacturaVO;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Fernanda
 */
@Repository
public class FacturaDAO extends AbstractDAO {

    /*@Transactional(rollbackFor = Exception.class)
     public int insertarFactura(FacturaVO factura) {

     //Genero sentencia SQL
     String sql = "INSERT INTO Factura (idTipoFactura,  idCliente, RUT, razonSocial, fecha, descuento, montoNetoTotal, montoNetoGralIva,"
     + " montoNetoGralIvaMin, montoTotal, montoTotalAPagar) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

     if (factura.getIdCliente() != -1) {
     Object[] parametros = new Object[]{factura.getIdTipoFactura(), factura.getIdCliente(), factura.getRUT(), factura.getRazonSocial(), factura.getFecha(), factura.getDescuento(), factura.getMontoNetoTotal(), factura.getMontoNetoGravIva(), factura.getMontoNetoGravIvaMin(), factura.getMontoTotal(),
     factura.getMontoTotalAPagar()};

     getJdbcTemplate().update(sql, parametros);
     } else {
     Object[] parametros = new Object[]{factura.getIdTipoFactura(), null, factura.getRUT(), factura.getRazonSocial(), factura.getFecha(), factura.getDescuento(), factura.getMontoNetoTotal(), factura.getMontoNetoGravIva(), factura.getMontoNetoGravIvaMin(), factura.getMontoTotal(),
     factura.getMontoTotalAPagar()};

     getJdbcTemplate().update(sql, parametros);
     }
     return super.getLastID().intValue();

     }*/
    public String obtenerSerieActual(String serieAnterior) {

        char ult_letra = serieAnterior.charAt(2);
        char penult_letra = serieAnterior.charAt(1);
        char primera_letra = serieAnterior.charAt(0);
        if (ult_letra == 'Z') {
            ult_letra = 'A';
            if (penult_letra == 'Z') {
                penult_letra = 'A';
                if (primera_letra == 'Z') {
                    //se acabaron las facutras, que hago?
                } else {
                    primera_letra = (char) ((int) primera_letra + 1);
                }

            } else {
                penult_letra = (char) ((int) penult_letra + 1);
            }

        } else {
            ult_letra = (char) ((int) ult_letra + 1);
        }
        String serie = "";
        serie = serie + primera_letra + penult_letra + ult_letra;

        return serie;

    }

    public IdFacturaVO obtenerIdFacturaInicial() throws Exception {

        try {
            File fXmlFile = new File("src/java/NumeroFactura.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            int nro = Integer.parseInt(doc.getElementsByTagName("nroComienzo").item(0).getTextContent());
            String serie = doc.getElementsByTagName("serieComienzo").item(0).getTextContent();
            IdFacturaVO result = new IdFacturaVO();
            result.setNroFactura(nro);
            result.setNroSerie(serie);
            return result;
        } catch (Exception ex) {
            throw new Exception("No se pudo abrir el xml de configuracion para la numeracion inicial de Facturas");
        }

    }

    @Transactional(rollbackFor = Exception.class)
    public IdFacturaVO insertarFactura(FacturaVO factura) throws Exception {

        String sql2 = "select nroSerie from Factura where fecha = (select max(fecha) from Factura where idTipoFactura = ?)"
                + " and idTipoFactura = ?;";

        Object[] parametros = {factura.getIdTipoFactura(), factura.getIdTipoFactura()};

        List<String> resultQuery = getJdbcTemplate().queryForList(sql2, parametros, String.class);
        String serieAnterior;
        Integer max;
        String serie;
        if (resultQuery == null || resultQuery.isEmpty()) {
            IdFacturaVO idFactura = obtenerIdFacturaInicial();
            max = idFactura.getNroFactura();
            serie = idFactura.getNroSerie();

        } else {
            serieAnterior = resultQuery.get(0);

            String sql1 = "SELECT MAX(nroFactura) FROM Factura where idTipoFactura = ? AND nroSerie = ?";
            parametros = new Object[]{factura.getIdTipoFactura(), serieAnterior};

            max = getJdbcTemplate().queryForObject(sql1, parametros, Integer.class);

            serie = serieAnterior;
            if (max == 9999999) {
                serie = obtenerSerieActual(serieAnterior);
                max = 0000001;
            } else {
                max++;
            }
        }

        //Genero sentencia SQL
        String sql = "INSERT INTO Factura (nroFactura, idTipoFactura, nroSerie, idCliente, RUT, "
                + "razonSocial, fecha, descuento, montoNetoTotal, montoNetoGralIva,"
                + " montoNetoGralIvaMin, montoTotal, montoTotalAPagar) "
                + "VALUES(? ,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            if (factura.getIdCliente() != -1) {
                parametros = new Object[]{max, factura.getIdTipoFactura(), serie, factura.getIdCliente(),
                    factura.getRUT(), factura.getRazonSocial(), factura.getFecha(), factura.getDescuento(),
                    factura.getMontoNetoTotal(), factura.getMontoNetoGravIva(), factura.getMontoNetoGravIvaMin(),
                    factura.getMontoTotal(), factura.getMontoTotalAPagar()};

                getJdbcTemplate().update(sql, parametros);
            } else {
                parametros = new Object[]{max, factura.getIdTipoFactura(), serie, null, factura.getRUT(), factura.getRazonSocial(), factura.getFecha(), factura.getDescuento(), factura.getMontoNetoTotal(), factura.getMontoNetoGravIva(), factura.getMontoNetoGravIvaMin(), factura.getMontoTotal(),
                    factura.getMontoTotalAPagar()};

                getJdbcTemplate().update(sql, parametros);

            }
        } catch (DuplicateKeyException e) {
            return insertarFactura(factura);

        }
        IdFacturaVO result = new IdFacturaVO();
        result.setNroFactura(max);
        result.setNroSerie(serie);
        return result;

    }

    public FacturaVO getFactura(int nroFactura, String nroSerie, short idTipoFactura) {

        //Genero sentencia SQL
        String sql = "SELECT * from Factura where nroFactura = ? AND idTipoFactura= ? AND nroSerie = ?";

        Object[] params = {nroFactura, idTipoFactura, nroSerie};

        List<Map<String, Object>> resultQuery = getJdbcTemplate().queryForList(sql, params);

        FacturaVO resultado = null;

        if (resultQuery.size() == 1) {
            for (Map map : resultQuery) {

                resultado = new FacturaVO(map);
            }

        }

        return resultado;
    }

}
