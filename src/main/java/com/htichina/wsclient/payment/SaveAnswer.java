
package com.htichina.wsclient.payment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>saveAnswer complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="saveAnswer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="questionAnswer" type="{http://payment.ws.htichina.com/}questionAnswer" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "saveAnswer", propOrder = {
    "questionAnswer"
})
public class SaveAnswer {

    protected QuestionAnswer questionAnswer;

    /**
     * 获取questionAnswer属性的值。
     * 
     * @return
     *     possible object is
     *     {@link QuestionAnswer }
     *     
     */
    public QuestionAnswer getQuestionAnswer() {
        return questionAnswer;
    }

    /**
     * 设置questionAnswer属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link QuestionAnswer }
     *     
     */
    public void setQuestionAnswer(QuestionAnswer value) {
        this.questionAnswer = value;
    }

}
