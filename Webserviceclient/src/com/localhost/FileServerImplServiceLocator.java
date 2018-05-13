/**
 * FileServerImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.localhost;

public class FileServerImplServiceLocator extends org.apache.axis.client.Service implements com.localhost.FileServerImplService {

    public FileServerImplServiceLocator() {
    }


    public FileServerImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public FileServerImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for FileServerImplPort
    private java.lang.String FileServerImplPort_address = "http://localhost:9999/ws/file";

    public java.lang.String getFileServerImplPortAddress() {
        return FileServerImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String FileServerImplPortWSDDServiceName = "FileServerImplPort";

    public java.lang.String getFileServerImplPortWSDDServiceName() {
        return FileServerImplPortWSDDServiceName;
    }

    public void setFileServerImplPortWSDDServiceName(java.lang.String name) {
        FileServerImplPortWSDDServiceName = name;
    }

    public com.localhost.FileServer getFileServerImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(FileServerImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getFileServerImplPort(endpoint);
    }

    public com.localhost.FileServer getFileServerImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.localhost.FileServerImplPortBindingStub _stub = new com.localhost.FileServerImplPortBindingStub(portAddress, this);
            _stub.setPortName(getFileServerImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setFileServerImplPortEndpointAddress(java.lang.String address) {
        FileServerImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.localhost.FileServer.class.isAssignableFrom(serviceEndpointInterface)) {
                com.localhost.FileServerImplPortBindingStub _stub = new com.localhost.FileServerImplPortBindingStub(new java.net.URL(FileServerImplPort_address), this);
                _stub.setPortName(getFileServerImplPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("FileServerImplPort".equals(inputPortName)) {
            return getFileServerImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://localhost.com/", "FileServerImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://localhost.com/", "FileServerImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("FileServerImplPort".equals(portName)) {
            setFileServerImplPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
