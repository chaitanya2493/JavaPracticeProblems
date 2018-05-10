package com.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.ws.soap.MTOM;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sun.xml.internal.ws.developer.StreamingDataHandler;

@MTOM
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class ServiceCall {
	private static String uploadBasePath = "UploadedFiles";
	private static String downloadBasePath = "DownloadFiles";
	private static String loadedDate = null;

	static {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
		loadedDate = sdf.format(now);
	}

	private static Log log = LogFactory.getLog(ServiceCall.class);

	@WebMethod
	public void upload(@XmlMimeType("application/xop+xml") DataHandler dh, String fileName) throws Exception {

		try {
			File file = getUploadFile(fileName);
			file.getParentFile().mkdirs();
			log.info("Start file upload to " + file.getPath());
			streamingUpload(dh, file);
			log.info("End file upload to " + file.getPath());
		} catch (Exception e) {
			throw e;
		}
	}

	@WebMethod
	@XmlMimeType("application/xop+xml")
	public DataHandler download(String fileName) throws FileNotFoundException, Exception {
		try {
			File file = getDownloadFile(fileName);
			if (!file.exists())
				throw new FileNotFoundException(file.getPath());
			return new DataHandler(new FileDataSource(file));
		} catch (FileNotFoundException e) {
			log.error("File Not Found.", e);
			throw e;
		} catch (Exception e) {
			log.error("Error.", e);
			throw e;
		}
	}

	private File getUploadFile(String fileName) {
		Path p = Paths.get(uploadBasePath, loadedDate, fileName);
		return p.toFile();
	}

	private File getDownloadFile(String fileName) {
		Path p = Paths.get(downloadBasePath, fileName);
		return p.toFile();
	}

	private void streamingUpload(DataHandler data, File file) throws IOException {
		try (StreamingDataHandler dh = (StreamingDataHandler) data) {
			dh.moveTo(file);
			dh.close();
		}
	}
}

