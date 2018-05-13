package com.localhost;

public class FileServerProxy implements com.localhost.FileServer {
  private String _endpoint = null;
  private com.localhost.FileServer fileServer = null;
  
  public FileServerProxy() {
    _initFileServerProxy();
  }
  
  public FileServerProxy(String endpoint) {
    _endpoint = endpoint;
    _initFileServerProxy();
  }
  
  private void _initFileServerProxy() {
    try {
      fileServer = (new com.localhost.FileServerImplServiceLocator()).getFileServerImplPort();
      if (fileServer != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)fileServer)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)fileServer)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (fileServer != null)
      ((javax.xml.rpc.Stub)fileServer)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.localhost.FileServer getFileServer() {
    if (fileServer == null)
      _initFileServerProxy();
    return fileServer;
  }
  
  public byte[] fileDownload(java.lang.String arg0) throws java.rmi.RemoteException{
    if (fileServer == null)
      _initFileServerProxy();
    return fileServer.fileDownload(arg0);
  }
  
  public com.localhost.XRayType1 downloadFile(java.lang.String arg0) throws java.rmi.RemoteException{
    if (fileServer == null)
      _initFileServerProxy();
    return fileServer.downloadFile(arg0);
  }
  
  
}