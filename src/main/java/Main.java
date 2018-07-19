import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnirestException {
        HttpResponse<JsonNode> jsonResponse = Unirest.get("http://localhost:4567/rest/estudiantes/")
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .asJson();

        System.out.println("Lista de estudiantes \n" + jsonResponse.getBody()+"\n") ;

        Scanner sc = new Scanner(System.in);
        String m= sc.nextLine();

        HttpResponse<JsonNode> jsonResponse2 = Unirest.get("http://localhost:4567/rest/estudiantes/"+m)
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .asJson();
        System.out.println("Estudiante con matricula seleccionada \n" + jsonResponse2.getBody()+"\n");

        JSONObject obj=new JSONObject();
        obj.put("correo","null");
        obj.put("matricula",20);
        obj.put("carrera","IC");
        obj.put("nombre","Fadul");
        HttpResponse<JsonNode> postResponse = Unirest.post("http://localhost:4567/rest/estudiantes/")
                    .header("accept", "application/json")
                    .header("Content-Type", "application/json")
                    .body(obj)
                    .asJson();


    }
}
