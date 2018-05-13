package com.localhost.client;

import java.io.*;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.soap.MTOMFeature;
import javax.xml.ws.soap.SOAPBinding;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import com.localhost.FileServer;
import com.localhost.XRayType1;

public class FileClient {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://localhost:9999/ws/file?wsdl");
		QName qname = new QName("http://localhost.com/", "FileServerImplService");
		Service service = Service.create(url, qname);
		FileServer fileServer = service.getPort(FileServer.class);
		XRayType1 dh = fileServer.downloadFile("sampl.pdf");
		/* Location for downloading and storing in client’s machine */ 
		FileOutputStream outputStream = new FileOutputStream("/var/www/html/sample/test.pdf");
		DataHandler pdfcontent = dh.getImageData();
		pdfcontent.writeTo(outputStream);
		outputStream.flush();
		System.out.println(" Download Successful!");
	}
}