
package cn.tsa.certapi.webservice.cfca;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>setCfcaCertAPIService complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="setCfcaCertAPIService">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://cfca.webservice.certapi.tsa.cn/}cfcaCertWebServiceImpl" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "setCfcaCertAPIService", propOrder = {
    "arg0"
})
public class SetCfcaCertAPIService {

    protected CfcaCertWebServiceImpl arg0;

    /**
     * 获取arg0属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CfcaCertWebServiceImpl }
     *     
     */
    public CfcaCertWebServiceImpl getArg0() {
        return arg0;
    }

    /**
     * 设置arg0属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CfcaCertWebServiceImpl }
     *     
     */
    public void setArg0(CfcaCertWebServiceImpl value) {
        this.arg0 = value;
    }

}
