package principal;

import com.google.gson.Gson;
import modelo.CambioMoneda;
import modelo.RespuestaCambio;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Principal {
    public static void main(String[] args) {
        String apiKey = "63e9b38b36d32528da38a5d8";
        CambioMoneda cb = new CambioMoneda();

        if (cb.eleccionUser()) {
            String direccion = "https://v6.exchangerate-api.com/v6/" + apiKey +
                    "/pair/" + cb.getMoneda() + "/" + cb.getDestino() + "/" + cb.getCantidad();

            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(direccion))
                        .build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                String json = response.body();
                Gson gson = new Gson();
                RespuestaCambio respuesta = gson.fromJson(json, RespuestaCambio.class);

                if ("success".equals(respuesta.result)) {
                    System.out.println("✅ Resultado de conversión:");
                    System.out.printf("%.2f %s → %.2f %s%n", cb.getCantidad(), respuesta.base_code, respuesta.conversion_result, respuesta.target_code);
                    System.out.printf("Tipo de cambio: 1 %s = %.4f %s%n", respuesta.base_code, respuesta.conversion_rate, respuesta.target_code);
                } else {
                    System.out.println("❌ Error en la conversión.");
                }

            } catch (Exception e) {
                System.out.println("Error al consultar la API: " + e.getMessage());
            }
        }
    }
}

