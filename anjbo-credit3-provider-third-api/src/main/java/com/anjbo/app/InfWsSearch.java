
package com.anjbo.app;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "InfWsSearch", targetNamespace = "http://ws.inf.creditapp.app/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface InfWsSearch {

	

    /**
     * 
     * @param request
     * @return
     *     returns app.creditapp.inf.ws.Response
     */
    @WebMethod
    @WebResult(name = "response", targetNamespace = "")
    @RequestWrapper(localName = "search", targetNamespace = "http://ws.inf.creditapp.app/", className = "com.anjbo.app.Search")
    @ResponseWrapper(localName = "searchResponse", targetNamespace = "http://ws.inf.creditapp.app/", className = "com.anjbo.app.SearchResponse")
    public Response search(
        @WebParam(name = "request", targetNamespace = "")
        Request request);

}