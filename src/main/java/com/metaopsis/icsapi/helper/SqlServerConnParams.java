package com.metaopsis.icsapi.helper;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by tombennett on 8/16/17.
 */
public class SqlServerConnParams
{
    private String agentId;
    @JsonProperty("CryptoProtocolVersion")
    private String cryptoProtocolVersion;
    private String agentGroupId;
    private String trustStore;
    @JsonProperty("HostNameInCertificate")
    private String hostNameInCertificate;
    private String encryptionMethod;
    private String orgId;
    @JsonProperty("ValidateServerCertificate")
    private String validateServerCertificate;

    public SqlServerConnParams()
    {
    }

    public SqlServerConnParams(String agentId, String cryptoProtocolVersion, String agentGroupId, String trustStore, String hostNameInCertificate, String encryptionMethod, String orgId, String validateServerCertificate)
    {
        this.agentId = agentId;
        this.cryptoProtocolVersion = cryptoProtocolVersion;
        this.agentGroupId = agentGroupId;
        this.trustStore = trustStore;
        this.hostNameInCertificate = hostNameInCertificate;
        this.encryptionMethod = encryptionMethod;
        this.orgId = orgId;
        this.validateServerCertificate = validateServerCertificate;
    }

    public String getAgentId()
    {
        return agentId;
    }

    public void setAgentId(String agentId)
    {
        this.agentId = agentId;
    }

    public String getCryptoProtocolVersion()
    {
        return cryptoProtocolVersion;
    }

    public void setCryptoProtocolVersion(String cryptoProtocolVersion)
    {
        this.cryptoProtocolVersion = cryptoProtocolVersion;
    }

    public String getAgentGroupId()
    {
        return agentGroupId;
    }

    public void setAgentGroupId(String agentGroupId)
    {
        this.agentGroupId = agentGroupId;
    }

    public String getTrustStore()
    {
        return trustStore;
    }

    public void setTrustStore(String trustStore)
    {
        this.trustStore = trustStore;
    }

    public String getHostNameInCertificate()
    {
        return hostNameInCertificate;
    }

    public void setHostNameInCertificate(String hostNameInCertificate)
    {
        this.hostNameInCertificate = hostNameInCertificate;
    }

    public String getEncryptionMethod()
    {
        return encryptionMethod;
    }

    public void setEncryptionMethod(String encryptionMethod)
    {
        this.encryptionMethod = encryptionMethod;
    }

    public String getOrgId()
    {
        return orgId;
    }

    public void setOrgId(String orgId)
    {
        this.orgId = orgId;
    }

    public String getValidateServerCertificate()
    {
        return validateServerCertificate;
    }

    public void setValidateServerCertificate(String validateServerCertificate)
    {
        this.validateServerCertificate = validateServerCertificate;
    }

    @Override
    public String toString()
    {
        return "SqlServerConnParams{" +
                "agentId='" + agentId + '\'' +
                ", cryptoProtocolVersion='" + cryptoProtocolVersion + '\'' +
                ", agentGroupId='" + agentGroupId + '\'' +
                ", trustStore='" + trustStore + '\'' +
                ", hostNameInCertificate='" + hostNameInCertificate + '\'' +
                ", encryptionMethod='" + encryptionMethod + '\'' +
                ", orgId='" + orgId + '\'' +
                ", validateServerCertificate='" + validateServerCertificate + '\'' +
                '}';
    }
}
