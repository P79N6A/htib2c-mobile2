
package com.htichina.wsclient.payment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>saveAnswer complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡquestionAnswer���Ե�ֵ��
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
     * ����questionAnswer���Ե�ֵ��
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
