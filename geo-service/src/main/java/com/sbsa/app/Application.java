/**
 * 
 */
package com.sbsa.app;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import com.sbsa.app.model.GeoIp;

/**
 * @author Administrator
 *
 */
@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	private static final String URL = "http://localhost:8081/geoip?ip=";
	
	private static RestTemplate restTemplate ;
	
	/**
	 * @param args
	 * @throws IOException 
	 * @throws URISyntaxException 
	 */
	public static void main(String[] args) throws IOException, URISyntaxException {
		List<GeoIp> result = new ArrayList<>();
		URI path= Thread.currentThread().getContextClassLoader().getResource("test.txt").toURI();
		Path filePath =Paths.get(path);//Paths.get("test.txt");//new File("test.txt").toPath();
		try (Stream<String> lines = Files.lines(filePath)) {
			 result = lines.filter(line -> null != line && !line.isEmpty())
					.map(line -> line.split(","))
					.sorted((o1, o2) -> o1[1].compareTo(o2[1]))
					.map(columns -> new GeoIp(columns[0], getCountryCode(columns[0]))) 
					.collect(Collectors.toList());
	    }
		System.out.println(" Ip Address Filtered  Country code ");
		for(GeoIp geoIp: result){
			System.out.println( geoIp.getIpAddress() + "   " + geoIp.getCountryCode());
		}
	}
	
	private static String getCountryCode(String ip) {
		if(restTemplate==null) {
			restTemplate = new RestTemplate();
		}
	    return restTemplate.getForObject(URL + ip, String.class);
	}
	

}
