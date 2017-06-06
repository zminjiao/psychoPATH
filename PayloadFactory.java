/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.pentest.psychoPATH;

import burp.IIntruderAttack;
import burp.IIntruderPayloadGenerator;
import burp.IIntruderPayloadGeneratorFactory;
/**
 *
 * @author julian
 */

public class PayloadFactory implements IIntruderPayloadGeneratorFactory{

    private final PsychoTab tab;
    private final String payloadType;
    
    public PayloadFactory(PsychoTab tab, String payloadType) {
        this.tab = tab;
        this.payloadType = payloadType;
    }
    
    @Override
    public String getGeneratorName() {
        if (payloadType.equals("path")) {
            return "Path traversal";
        }
        if (payloadType.equals("mark")) {
            return "Payload marker";            
        } 
        if(payloadType.equals("directory"))
        {
            return "Directory checker";
        }        
        if(payloadType.equals("byte"))
        {
            return "Byte";
        }
        return "Invalid type";
    }

    @Override
    public IIntruderPayloadGenerator createNewInstance(IIntruderAttack attack) {
        return new IntruderPayloadGenerator(payloadType,tab); // 
    }
    
}