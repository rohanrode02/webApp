import com.sun.net.httpserver.*;
import java.io.*;
import java.net.InetSocketAddress;

public class Main {

    public static void main(String[] args) throws Exception {

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        // Serve HTML Page
        server.createContext("/", exchange -> {
            File file = new File("web/index.html");
            String html = new String(java.nio.file.Files.readAllBytes(file.toPath()));
            exchange.sendResponseHeaders(200, html.length());
            exchange.getResponseBody().write(html.getBytes());
            exchange.close();
        });

        // Handle form submit
        server.createContext("/register", exchange -> {

            if (exchange.getRequestMethod().equalsIgnoreCase("POST")) {

                BufferedReader br = new BufferedReader(new InputStreamReader(exchange.getRequestBody()));
                String form = br.readLine(); // name=..&email=..&course=..

                String[] data = form.split("&");
                String name = data[0].split("=")[1];
                String email = data[1].split("=")[1];
                String course = data[2].split("=")[1];

                StudentDAO dao = new StudentDAO();
                dao.saveStudent(name, email, course);
            }

            String msg = "Student Registered Successfully!";
            exchange.sendResponseHeaders(200, msg.length());
            exchange.getResponseBody().write(msg.getBytes());
            exchange.close();
        });

        System.out.println("Server started at http://localhost:8080/");
        server.start();
    }
}
