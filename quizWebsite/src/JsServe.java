import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JsServe extends HttpServlet

{

    @Override

    protected

            void

            doGet(HttpServletRequest request, HttpServletResponse response)

                    throws ServletException, IOException {
        // Get the path to the JS file.
        String jsFilePath = getServletContext().getRealPath("script.js");

        // Set the content type of the response.
        response.setContentType("text/javascript");

        // Write the JS file to the response.
        byte[] jsFileBytes = Files.readAllBytes(Paths.get(jsFilePath));
        response.getOutputStream().write(jsFileBytes);
    }
}