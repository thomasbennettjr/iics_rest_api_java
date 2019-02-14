package com.metaopsis.icsapi.impl;


/**
 * Created by tbennett on 11/7/16.
 */
public class InformaticaCloudException extends Throwable {

    private boolean isICSError = false;
    public InformaticaCloudException(String message)
    {
        super(message);
        this.isICSError = false;

    }

    public InformaticaCloudException(String message, boolean isICSError)
    {
        super(message);
        this.isICSError = isICSError;

    }

    public boolean isICSError()
    {
        return this.isICSError;
    }
}
