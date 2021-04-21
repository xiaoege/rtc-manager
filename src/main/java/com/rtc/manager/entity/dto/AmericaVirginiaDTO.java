package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rtc.manager.entity.america.virginia.AmericaVirginiaPrincipal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaVirginiaDTO {
    private AmericaVirginiaEntityInformationDTO entityInformation;

    private AmericaVirginiaRegisteredAgentInformationDTO registeredAgentInformation;

    private List<AmericaVirginiaPrincipal> principalInformation;

    private HashMap principalOfficeAddress;

    private HashMap curentShares;

    private HashMap mailingAddressForserviceOfProcess;

    public AmericaVirginiaEntityInformationDTO getEntityInformation() {
        return entityInformation == null ? new AmericaVirginiaEntityInformationDTO() : entityInformation;
    }

    public void setEntityInformation(AmericaVirginiaEntityInformationDTO entityInformation) {
        this.entityInformation = entityInformation;
    }

    public AmericaVirginiaRegisteredAgentInformationDTO getRegisteredAgentInformation() {
        return registeredAgentInformation == null ? new AmericaVirginiaRegisteredAgentInformationDTO() : registeredAgentInformation;
    }

    public void setRegisteredAgentInformation(AmericaVirginiaRegisteredAgentInformationDTO registeredAgentInformation) {
        this.registeredAgentInformation = registeredAgentInformation;
    }

    public HashMap getPrincipalOfficeAddress() {
        return principalOfficeAddress == null ? new HashMap() : principalOfficeAddress;
    }

    public void setPrincipalOfficeAddress(HashMap principalOfficeAddress) {
        this.principalOfficeAddress = principalOfficeAddress;
    }

    public HashMap getCurentShares() {
        return curentShares == null ? new HashMap() : curentShares;
    }

    public void setCurentShares(HashMap curentShares) {
        this.curentShares = curentShares;
    }

    public HashMap getMailingAddressForserviceOfProcess() {
        return mailingAddressForserviceOfProcess == null ? new HashMap() : mailingAddressForserviceOfProcess;
    }

    public void setMailingAddressForserviceOfProcess(HashMap mailingAddressForserviceOfProcess) {
        this.mailingAddressForserviceOfProcess = mailingAddressForserviceOfProcess;
    }

    public List<AmericaVirginiaPrincipal> getPrincipalInformation() {
        return principalInformation == null ? new ArrayList<>() : principalInformation;
    }

    public void setPrincipalInformation(List<AmericaVirginiaPrincipal> principalInformation) {
        this.principalInformation = principalInformation;
    }
}