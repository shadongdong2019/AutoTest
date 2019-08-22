
package cn.tsa.certapi.webservice.cfca;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cn.tsa.certapi.webservice.cfca package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SetCfcaCertAPIService_QNAME = new QName("http://cfca.webservice.certapi.tsa.cn/", "setCfcaCertAPIService");
    private final static QName _SetCfcaCertAPIServiceResponse_QNAME = new QName("http://cfca.webservice.certapi.tsa.cn/", "setCfcaCertAPIServiceResponse");
    private final static QName _Handle_QNAME = new QName("http://cfca.webservice.certapi.tsa.cn/", "handle");
    private final static QName _HandleResponse_QNAME = new QName("http://cfca.webservice.certapi.tsa.cn/", "handleResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cn.tsa.certapi.webservice.cfca
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SetCfcaCertAPIService }
     * 
     */
    public SetCfcaCertAPIService createSetCfcaCertAPIService() {
        return new SetCfcaCertAPIService();
    }

    /**
     * Create an instance of {@link SetCfcaCertAPIServiceResponse }
     * 
     */
    public SetCfcaCertAPIServiceResponse createSetCfcaCertAPIServiceResponse() {
        return new SetCfcaCertAPIServiceResponse();
    }

    /**
     * Create an instance of {@link Handle }
     * 
     */
    public Handle createHandle() {
        return new Handle();
    }

    /**
     * Create an instance of {@link HandleResponse }
     * 
     */
    public HandleResponse createHandleResponse() {
        return new HandleResponse();
    }

    /**
     * Create an instance of {@link Result }
     * 
     */
    public Result createResult() {
        return new Result();
    }

    /**
     * Create an instance of {@link CfcaCertWebServiceImpl }
     * 
     */
    public CfcaCertWebServiceImpl createCfcaCertWebServiceImpl() {
        return new CfcaCertWebServiceImpl();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetCfcaCertAPIService }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cfca.webservice.certapi.tsa.cn/", name = "setCfcaCertAPIService")
    public JAXBElement<SetCfcaCertAPIService> createSetCfcaCertAPIService(SetCfcaCertAPIService value) {
        return new JAXBElement<SetCfcaCertAPIService>(_SetCfcaCertAPIService_QNAME, SetCfcaCertAPIService.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetCfcaCertAPIServiceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cfca.webservice.certapi.tsa.cn/", name = "setCfcaCertAPIServiceResponse")
    public JAXBElement<SetCfcaCertAPIServiceResponse> createSetCfcaCertAPIServiceResponse(SetCfcaCertAPIServiceResponse value) {
        return new JAXBElement<SetCfcaCertAPIServiceResponse>(_SetCfcaCertAPIServiceResponse_QNAME, SetCfcaCertAPIServiceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Handle }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cfca.webservice.certapi.tsa.cn/", name = "handle")
    public JAXBElement<Handle> createHandle(Handle value) {
        return new JAXBElement<Handle>(_Handle_QNAME, Handle.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HandleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cfca.webservice.certapi.tsa.cn/", name = "handleResponse")
    public JAXBElement<HandleResponse> createHandleResponse(HandleResponse value) {
        return new JAXBElement<HandleResponse>(_HandleResponse_QNAME, HandleResponse.class, null, value);
    }

}
