package co.unicauca.cliente.controladores;

import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.github.cliftonlabs.json_simple.JsonObject;

import co.unicauca.cliente.modelos.Compra;

public class CompraControlle {

    private String comando;

    public CompraControlle() {
        this.comando = "http://localhost:8001/compras/";
    }

    public boolean enviarCompra(Compra compraRegistro) throws IOException {
        boolean bandera = false;

        JsonObject json = new JsonObject();

        json.put("codigoCompra", compraRegistro.getCodigoCompra());
        json.put("idComprador", compraRegistro.getIdComprador());
        json.put("tipoIdentificacion", compraRegistro.getTipoIdentificacion());
        json.put("valor", compraRegistro.getValor());
        json.put("lugarCompra", compraRegistro.getLugarCompra());
        json.put("fecha", compraRegistro.getFecha());
        json.put("idEmpresa", compraRegistro.getIdEmpresa());

        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpPost post = new HttpPost(comando);
        StringEntity postingString = new StringEntity(json.toJson());// convert your pojo to json
        post.setEntity(postingString);
        post.setHeader("Content-type",
                "application/json");
        CloseableHttpResponse response = httpClient.execute(post);
        httpClient.close();

        if (response != null) {
            bandera = true;
        }

        System.out.println(response);

        return bandera;
    }

}
