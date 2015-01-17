package edu.oregonstate.mist.JerseyJavaTest;

import java.io.IOException;
import java.net.URI;
import javax.json.stream.JsonGenerator;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import com.sun.net.httpserver.HttpServer;

/**
 * Main application class
 *
 * Configure, start, and stop HTTP server.
 *
 * @author taylor
 */
@SuppressWarnings("restriction")
public class Application {

	public static Database database = new Database();
	static String host = "localhost";
	static Integer port = 8888;

	/**
	 * Run Jersey HTTP server
	 *
	 * @param	args	argument list
	 */
	public static void main(String[] args) {
		HttpServer server = configureHttpServer();
		startHttpServer(server);
		stopHttpServer(server);
	}

	/**
	 * Configure HTTP server URI and configuration
	 *
	 * @return		newly configured HttpServer instance
	 */
	private static HttpServer configureHttpServer() {
		URI baseUri = UriBuilder.fromUri("http://" + host + "/").port(port).build();

		ResourceConfig config = new ResourceConfig()
			.register(edu.oregonstate.mist.JerseyJavaTest.Api.v1.EmployeeResource.class)
			.property(JsonGenerator.PRETTY_PRINTING, true);

		return JdkHttpServerFactory.createHttpServer(baseUri, config, false);
	}

	/**
	 * Start HTTP server and print message
	 *
	 * @param	server	unbound HttpServer instance
	 */
	private static void startHttpServer(HttpServer server) {
		server.start();

		System.out.println("Server started on " + server.getAddress().toString());
	}

	/**
	 * Stop HTTP server on user input
	 *
	 * @param	server	bound HttpServer instance
	 */
	private static void stopHttpServer(HttpServer server) {
		System.out.print("Enter any key to quit: ");

		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		server.stop(0);

		System.out.println("Server stopped.");
	}
}
