/**
 * FileServer.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.localhost;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface FileServer extends java.rmi.Remote {
	@WebMethod
    public byte[] fileDownload(java.lang.String arg0) throws java.rmi.RemoteException;
	@WebMethod
    public com.localhost.XRayType1 downloadFile(java.lang.String arg0) throws java.rmi.RemoteException;
}
