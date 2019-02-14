package com.metaopsis.icsapi.impl;

import java.net.SocketException;

import com.metaopsis.icsapi.helper.*;
import com.metaopsis.icsapi.helper.Error;

/**
 * Created by tbennett on 11/7/16.
 */
public interface InformaticaCloud {

    public User login(Login login) throws InformaticaCloudException;

    public boolean logout(User user) throws InformaticaCloudException;

    public boolean logoutAll(Logout logout) throws InformaticaCloudException;

    public ActivityLog[] activityLog(User user, Job job) throws InformaticaCloudException;

    public ActivityLog[] activityLog(User user, Job job, int offset) throws InformaticaCloudException;

    public ActivityLog[] activityLog(User user, Job job, int offset, int rowLimit) throws InformaticaCloudException;

    public Job job(User user, Job request, boolean start) throws InformaticaCloudException;

    public boolean hasError();

    public Error getError();
}
