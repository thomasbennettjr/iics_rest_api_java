package com.metaopsis.icsapi.impl;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.metaopsis.icsapi.helper.*;
import com.metaopsis.icsapi.helper.Error;
import com.metaopsis.icsapi.helper.v3.Lookup;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import org.apache.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.net.SocketException;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;
import java.util.UUID;

/**
 * Created by tbennett on 11/7/16.
 */
public class InformaticaCloudImpl implements InformaticaCloud {

    final static Logger logger = Logger.getLogger(InformaticaCloudImpl.class);
    private HttpHeaders headers;
    private ObjectMapper mapper;
    private RestTemplate rest;
    private Error error = null;
    private boolean hasError = false;



    public InformaticaCloudImpl()
    {
        this.headers = new HttpHeaders();
        this.headers.add("Content-Type", "application/json");
        this.headers.add("Accept", "application/json");

        this.mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        this.rest = new RestTemplate();
        this.rest.setErrorHandler(new CustomResponseErrorHandler());
    }

    public RuntimeEnvironment[] getRuntimeEnvironments(User user) throws InformaticaCloudException
    {
        logger.info(this.getClass().getName()+"::getRuntimeEnvironments::entered");
        Writer jsonWriter = null;
        jsonWriter = new StringWriter();
        HttpEntity<String> requestEntity = null;
        ResponseEntity<String> responseEntity = null;
        RuntimeEnvironment[] runtimes = null;
        try
        {
            HttpHeaders tv = new HttpHeaders();
            tv.remove("icSessionId");
            tv.add("icSessionId", user.getIcSessionId());
            tv.add("Content-Type", "application/json");
            tv.add("Accept", "application/json");
            mapper.writeValue(jsonWriter, "");
            jsonWriter.flush();
            requestEntity = new HttpEntity<String>(jsonWriter.toString(), tv);
            responseEntity = rest.exchange(user.getServerUrl()+InformaticaCloudRestUrls.RuntimeEnvironment.toString(), HttpMethod.GET, requestEntity, String.class);

            if (responseEntity.getStatusCode().is2xxSuccessful())
            {
                logger.info("Informatica Cloud Get User 200 Success");
                runtimes = mapper.readValue(responseEntity.getBody(), RuntimeEnvironment[].class);
                logger.debug(user.toString());
            } else {
                logger.info("Informatica Cloud Get User " + responseEntity.getStatusCode().toString());
                throw new InformaticaCloudException(responseEntity.toString(), true);
            }

        } catch(JsonParseException e) {
            logger.error(e.getClass().getName() + "::" + e.getMessage());
            throw new InformaticaCloudException(e.toString(), true);

        } catch(JsonMappingException e) {
            logger.error(e.getClass().getName() + "::" + e.getMessage());
            throw new InformaticaCloudException(e.toString(), true);

        } catch(IOException e)
        {
            logger.error(e.getClass().getName() + "::" + e.getMessage());
            throw new InformaticaCloudException(e.toString(), true);

        } catch(RestClientException e)
        {
            logger.error(e.getClass().getName() + "::" + e.getMessage());
            throw new InformaticaCloudException(e.toString(), true);
        }
        catch(Exception e)
        {
            logger.error(e.getClass().getName() + "::" + e.getMessage());
            throw new InformaticaCloudException(e.toString(), true);
        }

        logger.info(this.getClass().getName()+"::getAllUsers::exited");
        return runtimes;
    }

    public ValidSessionIdResponse validateSessionId(ValidSessionIdRequest request, User user) throws JsonGenerationException, JsonMappingException, IOException, InformaticaCloudException
    {
    		logger.info(this.getClass().getName()+"::validateSessionId::entered");
    		Writer jsonWriter = new StringWriter();
    		HttpEntity<String> requestEntity = null;
    		ResponseEntity<String> responseEntity = null;
    		ValidSessionIdResponse response = null;
    		
    		mapper.writeValue(jsonWriter, request);
    		jsonWriter.flush();
    		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "application/json");
        headers.add("icSessionId", user.getIcSessionId());
        logger.debug(headers.toString());
        
    		requestEntity = new HttpEntity<String>(jsonWriter.toString(),headers);
    		logger.trace(requestEntity.toString());
    		responseEntity = rest.exchange(user.getServerUrl() + InformaticaCloudRestUrls.ValidateSessionId, HttpMethod.POST, requestEntity, String.class);
    		logger.trace(responseEntity.toString());
    		logger.info("ICS RESPONSE CODE:"+responseEntity.getStatusCodeValue());
    		if (responseEntity.getStatusCode().is2xxSuccessful())
    		{	
    			response = mapper.readValue(responseEntity.getBody(), ValidSessionIdResponse.class);
    		} 
    		
    		if (response == null)
    			throw new InformaticaCloudException(response.toString());
    		logger.info(this.getClass().getName()+"::validateSessionId::exited");
    		return response;
    }
    
    public User[] getAllUsers(User user) throws InformaticaCloudException {
    		logger.info(this.getClass().getName()+"::getAllUsers::entered");
    		Writer jsonWriter = null;
        jsonWriter = new StringWriter();
        HttpEntity<String> requestEntity = null;
        ResponseEntity<String> responseEntity = null;
        User[] users = null;
        try
        {
        		HttpHeaders tv = new HttpHeaders();
            tv.remove("icSessionId");
            tv.add("icSessionId", user.getIcSessionId());
            tv.add("Content-Type", "application/json");
            tv.add("Accept", "application/json");
            mapper.writeValue(jsonWriter, "");
            jsonWriter.flush();
            requestEntity = new HttpEntity<String>(jsonWriter.toString(), tv);
            responseEntity = rest.exchange(user.getServerUrl()+InformaticaCloudRestUrls.User.toString(), HttpMethod.GET, requestEntity, String.class);

            if (responseEntity.getStatusCode().is2xxSuccessful())
            {
                logger.info("Informatica Cloud Get User 200 Success");
                users = mapper.readValue(responseEntity.getBody(), User[].class);
                logger.debug(user.toString());
            } else {
                logger.info("Informatica Cloud Get User " + responseEntity.getStatusCode().toString());
                throw new InformaticaCloudException(responseEntity.toString(), true);
            }
       
	    } catch(JsonParseException e) {
			logger.error(e.getClass().getName() + "::" + e.getMessage());
			throw new InformaticaCloudException(e.toString(), true);
	
		} catch(JsonMappingException e) {
			logger.error(e.getClass().getName() + "::" + e.getMessage());
		    throw new InformaticaCloudException(e.toString(), true);
		
		} catch(IOException e)
		{
			logger.error(e.getClass().getName() + "::" + e.getMessage());
		    throw new InformaticaCloudException(e.toString(), true);
		
		} catch(RestClientException e)
		{
			logger.error(e.getClass().getName() + "::" + e.getMessage());
		    throw new InformaticaCloudException(e.toString(), true);
		}
		catch(Exception e)
		{
		    logger.error(e.getClass().getName() + "::" + e.getMessage());
		    throw new InformaticaCloudException(e.toString(), true);
		}
        
        logger.info(this.getClass().getName()+"::getAllUsers::exited");
        return users;
    }


    public Folder[] getAllFolders(User user, Project project, String xsrf_token, String cookie) throws InformaticaCloudException
    {
        HttpEntity<String> requestEntity = null;
        ResponseEntity<String> responseEntity = null;
        Folder[] folders = null;
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json");
            headers.add("Accept", "application/json");
            headers.add("XSRF_TOKEN", xsrf_token);
            headers.add("Cookie",cookie);
            requestEntity = new HttpEntity<String>(null, headers);
            String url = user.getServerUrl().replaceFirst("/saas","")+InformaticaCloudRestUrls.Folder.toString();

            responseEntity = rest.exchange(url.replaceFirst("#id",project.getId()),
                    HttpMethod.GET, requestEntity, String.class);
            if (responseEntity.getStatusCode().is2xxSuccessful())
            {
                String respBody = responseEntity.getBody().substring(responseEntity.getBody().indexOf(":[") + 1, responseEntity.getBody().length() - 1);
                folders = mapper.readValue(respBody, Folder[].class);
            } else {
                logger.error(responseEntity.toString());
                throw new InformaticaCloudException(responseEntity.toString(), true);
            }
        } catch(Exception e)
        {
            logger.error(e.getClass().getName() + "::" + e.getMessage());
            throw new InformaticaCloudException(e.toString(), true);
        }

        return folders;
    }

    public Folder createFolder(User user,Project project, Folder folder, String xsrf_token, String cookie)
    {Writer jsonWriter = null;
        jsonWriter = new StringWriter();
        HttpEntity<String> requestEntity = null;
        ResponseEntity<String> responseEntity = null;
        Folder _folder = null;
        try {
            mapper.writeValue(jsonWriter, folder);
            jsonWriter.flush();
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json");
            headers.add("Accept", "application/json");
            headers.add("XSRF_TOKEN", xsrf_token);
            headers.add("Cookie",cookie);
            requestEntity = new HttpEntity<String>(jsonWriter.toString(), headers);
            String url = user.getServerUrl().replaceFirst("/saas","")+InformaticaCloudRestUrls.Folder.toString();
            responseEntity = rest.exchange(url.replaceFirst("#id",project.getId()), HttpMethod.POST, requestEntity, String.class);

            if (responseEntity.getStatusCode().is2xxSuccessful())
            {
                _folder = mapper.readValue(responseEntity.getBody(), Folder.class);
            }

        } catch(Exception e)
        {
            e.printStackTrace();
        }

        return _folder;
    }

    public Project[] getAllProjects(User user, String xsrf_token, String cookie) throws InformaticaCloudException
    {
        HttpEntity<String> requestEntity = null;
        ResponseEntity<String> responseEntity = null;
        Project[] projects = null;
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json");
            headers.add("Accept", "application/json");
            headers.add("XSRF_TOKEN", xsrf_token);
            headers.add("Cookie",cookie);
            requestEntity = new HttpEntity<String>(null, headers);
            String url = user.getServerUrl().replaceFirst("/saas","")+InformaticaCloudRestUrls.Project.toString();

            responseEntity = rest.exchange(url,
                    HttpMethod.GET, requestEntity, String.class);
            if (responseEntity.getStatusCode().is2xxSuccessful())
            {
                String respBody = responseEntity.getBody().substring(responseEntity.getBody().indexOf(":[") + 1, responseEntity.getBody().length() - 1);
                projects = mapper.readValue(respBody, Project[].class);
            } else {
                logger.error(responseEntity.toString());
                throw new InformaticaCloudException(responseEntity.toString(), true);
            }
        } catch(Exception e)
        {
            logger.error(e.getClass().getName() + "::" + e.getMessage());
            throw new InformaticaCloudException(e.toString(), true);
        }

        return projects;
    }

    public Project createProject(User user, Project project, String xsrf_token, String cookie)
    {
        Writer jsonWriter = null;
        jsonWriter = new StringWriter();
        HttpEntity<String> requestEntity = null;
        ResponseEntity<String> responseEntity = null;
        Project _project = null;
        try {
            mapper.writeValue(jsonWriter, project);
            jsonWriter.flush();
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json");
            headers.add("Accept", "application/json");
            headers.add("XSRF_TOKEN", xsrf_token);
            headers.add("Cookie",cookie);
            requestEntity = new HttpEntity<String>(jsonWriter.toString(), headers);
            String url = user.getServerUrl().replaceFirst("/saas","")+InformaticaCloudRestUrls.Project.toString();
            responseEntity = rest.exchange(url, HttpMethod.POST, requestEntity, String.class);

            if (responseEntity.getStatusCode().is2xxSuccessful())
            {
                _project = mapper.readValue(responseEntity.getBody(), Project.class);
            }

        } catch(Exception e)
        {
            e.printStackTrace();
        }

        return _project;
    }
    public com.metaopsis.icsapi.helper.v3.User loginV3(com.metaopsis.icsapi.helper.v3.Login login) throws InformaticaCloudException {
        logger.info(this.getClass().getName()+"::loginV3::entered");
        logger.debug(InformaticaCloudV3RestUrls.Login.toString());
        logger.debug(login.toString().replace(login.getPassword(),"*********"));
        Writer jsonWriter = null;
        jsonWriter = new StringWriter();
        HttpEntity<String> requestEntity = null;
        ResponseEntity<String> responseEntity = null;
        com.metaopsis.icsapi.helper.v3.User user = null;
        try {
            mapper.writeValue(jsonWriter, login);
            jsonWriter.flush();

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json");
            headers.add("Accept", "application/json");
            logger.debug(headers.toString());

            requestEntity = new HttpEntity<String>(jsonWriter.toString(), headers);

            responseEntity = rest.exchange(InformaticaCloudV3RestUrls.Login.toString(), HttpMethod.POST, requestEntity, String.class);

            if (responseEntity.getStatusCode().is2xxSuccessful())
            {
                logger.info("Informatica Cloud Login 200 Success");
                user = mapper.readValue(responseEntity.getBody(), com.metaopsis.icsapi.helper.v3.User.class);
                logger.debug(user.toString());
            } else {
                logger.info("Informatica Cloud Login " + responseEntity.getStatusCode().toString());
                logger.error(responseEntity.toString());
                throw new InformaticaCloudException(responseEntity.toString(), true);
            }
        } catch(JsonParseException e) {
            logger.error(e.getClass().getName() + "::" + e.getMessage());
            throw new InformaticaCloudException(e.toString(), true);

        } catch(JsonMappingException e) {
            logger.error(e.getClass().getName() + "::" + e.getMessage());
            throw new InformaticaCloudException(e.toString(), true);

        } catch(IOException e)
        {
            logger.error(e.getClass().getName() + "::" + e.getMessage());
            throw new InformaticaCloudException(e.toString(), true);

        } catch(RestClientException e)
        {
            logger.error(e.getClass().getName() + "::" + e.getMessage());
            throw new InformaticaCloudException(e.toString(), true);
        }
        catch(Exception e)
        {
            logger.error(e.getClass().getName() + "::" + e.getMessage());
            throw new InformaticaCloudException(e.toString(), true);
        }

        logger.info(this.getClass().getName()+"::loginV3::exited");
        return user;
    }

    public boolean executeAdvTaskflow(com.metaopsis.icsapi.helper.v3.Login login, com.metaopsis.icsapi.helper.v3.User user, Lookup lookup) throws InformaticaCloudException
    {

        String url = user.getProducts()[0].getBaseApiUrl().replaceFirst("/saas","")+InformaticaCloudV3RestUrls.AdvTaskflow.toString().replaceFirst("#id", lookup.getObjects()[0].getId());
        String basic = java.util.Base64.getEncoder().encodeToString((login.getUsername()+":"+login.getPassword()).getBytes());
        HttpHeaders headers = new HttpHeaders();
        boolean flag = false;
        headers.add("Authorization", "Basic " + basic);
        HttpEntity<String> requestEntity = null;
        ResponseEntity<String> responseEntity = null;
        try {
            requestEntity = new HttpEntity<String>("", headers);

            responseEntity = rest.exchange(url, HttpMethod.GET, requestEntity, String.class);

            if (responseEntity.getStatusCode().is2xxSuccessful())
            {

                logger.info("Informatica Cloud Login 200 Success");
                flag = true;
            } else {
                logger.info("Informatica Cloud Login " + responseEntity.getStatusCode().toString());
                logger.error(responseEntity.toString());
                throw new InformaticaCloudException(responseEntity.toString(), true);
            }
        } catch(Exception e)
            {
                logger.error(e.getClass().getName() + "::" + e.getMessage());
                throw new InformaticaCloudException(e.toString(), true);
            }
            return flag;
    }

    public Lookup lookup(Lookup lookup, com.metaopsis.icsapi.helper.v3.User user) throws InformaticaCloudException {
        logger.info(this.getClass().getName()+"::lookup::entered");
        Writer jsonWriter = null;
        jsonWriter = new StringWriter();
        HttpEntity<String> requestEntity = null;
        ResponseEntity<String> responseEntity = null;
        Lookup lookupResp = null;
        try {
            mapper.writeValue(jsonWriter, lookup);
            jsonWriter.flush();

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json");
            headers.add("Accept", "application/json");
            headers.add("INFA-SESSION-ID", user.getUserInfo().getSessionId());

            requestEntity = new HttpEntity<String>(jsonWriter.toString(), headers);

            responseEntity = rest.exchange(user.getProducts()[0].getBaseApiUrl()+InformaticaCloudV3RestUrls.Lookup.toString(), HttpMethod.POST, requestEntity, String.class);

            if (responseEntity.getStatusCode().is2xxSuccessful())
            {
                logger.info("Informatica Cloud Login 200 Success");
                lookupResp = mapper.readValue(responseEntity.getBody(), Lookup.class);
                logger.debug(user.toString());
            } else {
                logger.info("Informatica Cloud Login " + responseEntity.getStatusCode().toString());
                logger.error(responseEntity.toString());
                //error = mapper.readValue(responseEntity.getBody(), Error.class);
                //this.setError(error);
                //this.setErrorFlag(true);
                //logger.debug(error.toString());
                throw new InformaticaCloudException(responseEntity.toString(), true);
            }

        } catch(JsonParseException e) {
            logger.error(e.getClass().getName() + "::" + e.getMessage());
            throw new InformaticaCloudException(e.toString(), true);

        } catch(JsonMappingException e) {
            logger.error(e.getClass().getName() + "::" + e.getMessage());
            throw new InformaticaCloudException(e.toString(), true);

        } catch(IOException e)
        {
            logger.error(e.getClass().getName() + "::" + e.getMessage());
            throw new InformaticaCloudException(e.toString(), true);

        } catch(RestClientException e)
        {
            logger.error(e.getClass().getName() + "::" + e.getMessage());
            throw new InformaticaCloudException(e.toString(), true);
        }
        catch(Exception e)
        {
            logger.error(e.getClass().getName() + "::" + e.getMessage());
            throw new InformaticaCloudException(e.toString(), true);
        }

        return lookupResp;
    }

    public User login(Login login) throws InformaticaCloudException {
        //this.setErrorFlag(false);
        //this.setError(null);
        logger.info(this.getClass().getName()+"::login::entered");
        logger.debug(InformaticaCloudRestUrls.Login.toString());
        logger.debug(login.toString().replace(login.getPassword(),"*********"));
        Writer jsonWriter = null;
        jsonWriter = new StringWriter();
        HttpEntity<String> requestEntity = null;
        ResponseEntity<String> responseEntity = null;
        User user = null;
       try
       {
            mapper.writeValue(jsonWriter, login);
            jsonWriter.flush();
            	
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json");
            headers.add("Accept", "application/json");
            logger.debug(headers.toString());
            
            requestEntity = new HttpEntity<String>(jsonWriter.toString(), headers);

            responseEntity = rest.exchange(InformaticaCloudRestUrls.Login.toString(), HttpMethod.POST, requestEntity, String.class);

            if (responseEntity.getStatusCode().is2xxSuccessful())
            {
                logger.info("Informatica Cloud Login 200 Success");
                user = mapper.readValue(responseEntity.getBody(), User.class);
                logger.debug(user.toString());
            } else {
                logger.info("Informatica Cloud Login " + responseEntity.getStatusCode().toString());
                logger.error(responseEntity.toString());
                //error = mapper.readValue(responseEntity.getBody(), Error.class);
                //this.setError(error);
                //this.setErrorFlag(true);
                //logger.debug(error.toString());
                throw new InformaticaCloudException(responseEntity.toString(), true);
            }

        } catch(JsonParseException e) {
        		logger.error(e.getClass().getName() + "::" + e.getMessage());
            throw new InformaticaCloudException(e.toString(), true);

        } catch(JsonMappingException e) {
        		logger.error(e.getClass().getName() + "::" + e.getMessage());
            throw new InformaticaCloudException(e.toString(), true);

        } catch(IOException e)
        {
        		logger.error(e.getClass().getName() + "::" + e.getMessage());
            throw new InformaticaCloudException(e.toString(), true);

        } catch(RestClientException e)
        {
        		logger.error(e.getClass().getName() + "::" + e.getMessage());
            throw new InformaticaCloudException(e.toString(), true);
        }
        catch(Exception e)
        {
            logger.error(e.getClass().getName() + "::" + e.getMessage());
            throw new InformaticaCloudException(e.toString(), true);
        }
        
            logger.info(this.getClass().getName()+"::login::exited");
            return user;
       
    }

    public CustomFunc createCustomFunc(User user, CustomFuncRequest request) throws InformaticaCloudException
    {
        logger.info(this.getClass().getName()+"::getAllCustomFunc(User user)::entered");
        logger.debug(InformaticaCloudRestUrls.CustomFunc.toString());
        logger.debug(user.toString());
        Writer jsonWriter = null;
        jsonWriter = new StringWriter();
        HttpEntity<String> requestEntity = null;
        ResponseEntity<String> responseEntity = null;
        Error error = null;
        CustomFunc mapplet = null;
        try {
            long boundary = UUID.randomUUID().timestamp();
            HttpHeaders tv = new HttpHeaders();
            tv.add("icSessionId", user.getIcSessionId());
            tv.add("Content-Type", "multipart/form-data; boundary="+boundary);
            tv.add("Accept", "application/json");
            String active = request.isActive() ? "true" : "false";
            requestEntity = new HttpEntity<String>("--"+boundary+"\r\nContent-Disposition: form-data; name=\"file\"; filename=\""+ request.getFilename()
                    + "\"; Content-Type: text/xml\r\n\r\n"+request.getXml()+"\r\n\r\n--"+boundary+"\r\nContent-Disposition: form-data; name=\"name\"\r\n\r\n"
                    + request.getName()+"\r\n--"+boundary+"\r\nContent-Disposition: form-data; name=\"active\"\r\n\r\n"+active+"\r\n--"+boundary
                    + "\r\nContent-Disposition: form-data; name=\"desc\"\r\n\r\n"+request.getDescription()+"\r\n--"+boundary+"--", tv);
            responseEntity = rest.exchange(user.getServerUrl()+InformaticaCloudRestUrls.CustomFunc.toString(), HttpMethod.POST,
                    requestEntity, String.class);

            if (responseEntity.getStatusCode().is2xxSuccessful())
            {
                logger.info("Informatica Cloud CustomFunc 200 Success");
                mapplet = mapper.readValue(responseEntity.getBody(), CustomFunc.class);
                logger.debug(user.toString());
            } else {
                logger.info("Informatica Cloud CustomFunc " + responseEntity.getStatusCode().toString());
                error = mapper.readValue(responseEntity.getBody(), Error.class);
                this.setError(error);
                this.setErrorFlag(true);
                logger.debug(error.toString());
                throw new InformaticaCloudException(error.toString(), true);
            }

        }
        catch(JsonParseException jpe) {
            if (requestEntity != null)
                logger.debug(requestEntity.toString());
            if (responseEntity != null)
                logger.debug(responseEntity.toString());

            logger.fatal("JsonParseException::" + jpe.getMessage());
            throw(new InformaticaCloudException(jpe.getMessage()));

        } catch(JsonMappingException jme) {
            if (requestEntity != null)
                logger.debug(requestEntity.toString());
            if (responseEntity != null)
                logger.debug(responseEntity.toString());

            logger.fatal("JsonMappingException::" + jme.getMessage());
            throw(new InformaticaCloudException(jme.getMessage()));

        } catch(RestClientException rce)
        {
            logger.fatal("RestClientException::" + rce.getMessage());
            throw(new InformaticaCloudException(rce.getMessage()));
        } catch(IOException ioe)
        {
            logger.fatal("IOException::" + ioe.getMessage());
            throw(new InformaticaCloudException(ioe.getMessage()));

        } finally
        {
            logger.info(this.getClass().getName()+"::getAllCustomFunc(User user)::exited");
        }

        return mapplet;
    }

    public Scheduler createScheduler(User user, Scheduler request) throws InformaticaCloudException
    {
        logger.info(this.getClass().getName()+"::createScheduler(User user, Scheduler request)::entered");
        logger.debug(InformaticaCloudRestUrls.CustomFunc.toString());
        logger.debug(user.toString());
        Writer jsonWriter = null;
        jsonWriter = new StringWriter();
        HttpEntity<String> requestEntity = null;
        ResponseEntity<String> responseEntity = null;
        Error error = null;
        Scheduler scheduler = null;
        try {
            HttpHeaders tv = new HttpHeaders();
            tv.remove("icSessionId");
            tv.add("icSessionId", user.getIcSessionId());
            tv.add("Content-Type", "application/json");
            tv.add("Accept", "application/json");
            mapper.writeValue(jsonWriter, request);
            jsonWriter.flush();
            requestEntity = new HttpEntity<String>(jsonWriter.toString(), tv);
            responseEntity = rest.exchange(user.getServerUrl()+InformaticaCloudRestUrls.Schedule.toString(), HttpMethod.POST, requestEntity, String.class);

            if (responseEntity.getStatusCode().is2xxSuccessful())
            {
                logger.info("Informatica Cloud Scheduler 200 Success");
                scheduler = mapper.readValue(responseEntity.getBody(), Scheduler.class);
                logger.debug(user.toString());
            } else {
                logger.info("Informatica Cloud Scheduler " + responseEntity.getStatusCode().toString());
                error = mapper.readValue(responseEntity.getBody(), Error.class);
                this.setError(error);
                this.setErrorFlag(true);
                logger.debug(error.toString());
                throw new InformaticaCloudException(error.toString(), true);
            }

        }
        catch(JsonParseException jpe) {
            if (requestEntity != null)
                logger.debug(requestEntity.toString());
            if (responseEntity != null)
                logger.debug(responseEntity.toString());

            logger.fatal("JsonParseException::" + jpe.getMessage());
            throw(new InformaticaCloudException(jpe.getMessage()));

        } catch(JsonMappingException jme) {
            if (requestEntity != null)
                logger.debug(requestEntity.toString());
            if (responseEntity != null)
                logger.debug(responseEntity.toString());

            logger.fatal("JsonMappingException::" + jme.getMessage());
            throw(new InformaticaCloudException(jme.getMessage()));

        } catch(RestClientException rce)
        {
            logger.fatal("RestClientException::" + rce.getMessage());
            throw(new InformaticaCloudException(rce.getMessage()));
        } catch(IOException ioe)
        {
            logger.fatal("IOException::" + ioe.getMessage());
            throw(new InformaticaCloudException(ioe.getMessage()));

        } finally
        {
            logger.info(this.getClass().getName()+"::createScheduler(User user, Scheduler request)::exited");
        }

        return scheduler;
    }
    
    public boolean deleteMappingConfigurationTask(User user, String id) throws InformaticaCloudException
    {
    		logger.info(this.getClass().getName()+"::deleteMappingConfigurationTask(User user, String id)::entered");
        logger.debug(InformaticaCloudRestUrls.CustomFunc.toString());
        HttpEntity<String> requestEntity = null;
        ResponseEntity<String> responseEntity = null;
        Error error = null;
        boolean isDeleted = false;
        try
        {
        		HttpHeaders tv = new HttpHeaders();
            tv.remove("icSessionId");
            tv.add("icSessionId", user.getIcSessionId());
            tv.add("Content-Type", "application/json");
            tv.add("Accept", "application/json");
            requestEntity = new HttpEntity<String>("", tv);
            responseEntity = rest.exchange(user.getServerUrl()+InformaticaCloudRestUrls.MtTask.toString()+"/"+id, HttpMethod.DELETE, requestEntity, String.class);

            if (responseEntity.getStatusCode().is2xxSuccessful())
            {
                logger.info("Informatica Cloud MappingConfigurationTasks 200 Success");
                isDeleted = true;
                
                logger.debug(user.toString());
            } else {
                logger.info("Informatica Cloud MappingConfigurationTasks " + responseEntity.getStatusCode().toString());
                error = mapper.readValue(responseEntity.getBody(), Error.class);
                this.setError(error);
                this.setErrorFlag(true);
                logger.debug(error.toString());
                throw new InformaticaCloudException(error.toString(), true);
            }
        }
        catch(RestClientException rce)
        {
            logger.fatal("RestClientException::" + rce.getMessage());
            throw(new InformaticaCloudException(rce.getMessage()));
        } catch(IOException ioe)
        {
            logger.fatal("IOException::" + ioe.getMessage());
            throw(new InformaticaCloudException(ioe.getMessage()));

        } finally
        {
            logger.info(this.getClass().getName()+"::getAllMappingConfigurationTask(User user, String id)::exited");
            return isDeleted;
        }
    }
    
    public MappingConfigurationTask createMappingConfigurationTask(User user, String content) throws InformaticaCloudException
    {
        logger.info(this.getClass().getName()+"::getAllMappingConfigurationTask(User user, String id)::entered");
        logger.debug(InformaticaCloudRestUrls.MtTask.toString());
        logger.debug(user.toString());
        Writer jsonWriter = null;
        jsonWriter = new StringWriter();
        HttpEntity<String> requestEntity = null;
        ResponseEntity<String> responseEntity = null;
        Error error = null;
        MappingConfigurationTask mttask = null;
        try {
            HttpHeaders tv = new HttpHeaders();
            tv.remove("icSessionId");
            tv.add("icSessionId", user.getIcSessionId());
            tv.add("Content-Type", "application/json");
            tv.add("Accept", "application/json");
            requestEntity = new HttpEntity<String>(content, tv);
            responseEntity = rest.exchange(user.getServerUrl()+InformaticaCloudRestUrls.MtTask.toString(), HttpMethod.POST, requestEntity, String.class);

            if (responseEntity.getStatusCode().is2xxSuccessful())
            {
                logger.info("Informatica Cloud MappingConfigurationTasks 200 Success");
                mttask = mapper.readValue(responseEntity.getBody(), MappingConfigurationTask.class);
                
                logger.debug(user.toString());
            } else {
                logger.info("Informatica Cloud MappingConfigurationTasks " + responseEntity.getStatusCode().toString());
                error = mapper.readValue(responseEntity.getBody(), Error.class);
                this.setError(error);
                this.setErrorFlag(true);
                logger.debug(error.toString());
                throw new InformaticaCloudException(error.toString(), true);
            }

        }
        catch(JsonParseException jpe) {
            if (requestEntity != null)
                logger.debug(requestEntity.toString());
            if (responseEntity != null)
                logger.debug(responseEntity.toString());

            logger.fatal("JsonParseException::" + jpe.getMessage());
            throw(new InformaticaCloudException(jpe.getMessage()));

        } catch(JsonMappingException jme) {
            if (requestEntity != null)
                logger.debug(requestEntity.toString());
            if (responseEntity != null)
                logger.debug(responseEntity.toString());

            logger.fatal("JsonMappingException::" + jme.getMessage());
            throw(new InformaticaCloudException(jme.getMessage()));

        } catch(RestClientException rce)
        {
            logger.fatal("RestClientException::" + rce.getMessage());
            throw(new InformaticaCloudException(rce.getMessage()));
        } catch(IOException ioe)
        {
            logger.fatal("IOException::" + ioe.getMessage());
            throw(new InformaticaCloudException(ioe.getMessage()));

        } finally
        {
            logger.info(this.getClass().getName()+"::getAllMappingConfigurationTask(User user, String id)::exited");
        }

        return mttask;
    }
    
    public MappingConfigurationTask updateMappingConfigurationTask(User user, String content, String id) throws InformaticaCloudException
    {
        logger.info(this.getClass().getName()+"::getAllMappingConfigurationTask(User user, String id)::entered");
        logger.debug(InformaticaCloudRestUrls.MtTask.toString());
        logger.debug(user.toString());
        Writer jsonWriter = null;
        jsonWriter = new StringWriter();
        HttpEntity<String> requestEntity = null;
        ResponseEntity<String> responseEntity = null;
        Error error = null;
        MappingConfigurationTask mttask = null;
        try {
            HttpHeaders tv = new HttpHeaders();
            tv.remove("icSessionId");
            tv.add("icSessionId", user.getIcSessionId());
            tv.add("Content-Type", "application/json");
            tv.add("Accept", "application/json");
            requestEntity = new HttpEntity<String>(content, tv);
            System.out.println(user.getServerUrl()+InformaticaCloudRestUrls.MtTask.toString()+id);
            responseEntity = rest.exchange(user.getServerUrl()+InformaticaCloudRestUrls.MtTask.toString()+"/"+id, HttpMethod.POST, requestEntity, String.class);

            if (responseEntity.getStatusCode().is2xxSuccessful())
            {
                logger.info("Informatica Cloud MappingConfigurationTasks 200 Success");
                mttask = mapper.readValue(responseEntity.getBody(), MappingConfigurationTask.class);
                
                logger.debug(user.toString());
            } else {
                logger.info("Informatica Cloud MappingConfigurationTasks " + responseEntity.getStatusCode().toString());
                error = mapper.readValue(responseEntity.getBody(), Error.class);
                this.setError(error);
                this.setErrorFlag(true);
                logger.debug(error.toString());
                throw new InformaticaCloudException(error.toString(), true);
            }

        }
        catch(JsonParseException jpe) {
            if (requestEntity != null)
                logger.debug(requestEntity.toString());
            if (responseEntity != null)
                logger.debug(responseEntity.toString());

            logger.fatal("JsonParseException::" + jpe.getMessage());
            throw(new InformaticaCloudException(jpe.getMessage()));

        } catch(JsonMappingException jme) {
            if (requestEntity != null)
                logger.debug(requestEntity.toString());
            if (responseEntity != null)
                logger.debug(responseEntity.toString());

            logger.fatal("JsonMappingException::" + jme.getMessage());
            throw(new InformaticaCloudException(jme.getMessage()));

        } catch(RestClientException rce)
        {
            logger.fatal("RestClientException::" + rce.getMessage());
            throw(new InformaticaCloudException(rce.getMessage()));
        } catch(IOException ioe)
        {
            logger.fatal("IOException::" + ioe.getMessage());
            throw(new InformaticaCloudException(ioe.getMessage()));

        } finally
        {
            logger.info(this.getClass().getName()+"::getAllMappingConfigurationTask(User user, String id)::exited");
        }

        return mttask;
    }
    
    public MappingConfigurationTask getMappingConfigurationTask(User user, String id) throws InformaticaCloudException
    {
        logger.info(this.getClass().getName()+"::getAllMappingConfigurationTask(User user, String id)::entered");
        logger.debug(InformaticaCloudRestUrls.MtTask.toString());
        logger.debug(user.toString());
        Writer jsonWriter = null;
        jsonWriter = new StringWriter();
        HttpEntity<String> requestEntity = null;
        ResponseEntity<String> responseEntity = null;
        Error error = null;
        MappingConfigurationTask mttask = null;
        try {
            HttpHeaders tv = new HttpHeaders();
            tv.remove("icSessionId");
            tv.add("icSessionId", user.getIcSessionId());
            tv.add("Content-Type", "application/json");
            tv.add("Accept", "application/json");
            requestEntity = new HttpEntity<String>("", tv);
            responseEntity = rest.exchange(user.getServerUrl()+InformaticaCloudRestUrls.MtTask.toString()+"/"+id, HttpMethod.GET, requestEntity, String.class);

            if (responseEntity.getStatusCode().is2xxSuccessful())
            {
                logger.info("Informatica Cloud MappingConfigurationTasks 200 Success");
                mttask = mapper.readValue(responseEntity.getBody(), MappingConfigurationTask.class);
                
                logger.debug(user.toString());
            } else {
                logger.info("Informatica Cloud MappingConfigurationTasks " + responseEntity.getStatusCode().toString());
                error = mapper.readValue(responseEntity.getBody(), Error.class);
                this.setError(error);
                this.setErrorFlag(true);
                logger.debug(error.toString());
                throw new InformaticaCloudException(error.toString(), true);
            }

        }
        catch(JsonParseException jpe) {
            if (requestEntity != null)
                logger.debug(requestEntity.toString());
            if (responseEntity != null)
                logger.debug(responseEntity.toString());

            logger.fatal("JsonParseException::" + jpe.getMessage());
            throw(new InformaticaCloudException(jpe.getMessage()));

        } catch(JsonMappingException jme) {
            if (requestEntity != null)
                logger.debug(requestEntity.toString());
            if (responseEntity != null)
                logger.debug(responseEntity.toString());

            logger.fatal("JsonMappingException::" + jme.getMessage());
            throw(new InformaticaCloudException(jme.getMessage()));

        } catch(RestClientException rce)
        {
            logger.fatal("RestClientException::" + rce.getMessage());
            throw(new InformaticaCloudException(rce.getMessage()));
        } catch(IOException ioe)
        {
            logger.fatal("IOException::" + ioe.getMessage());
            throw(new InformaticaCloudException(ioe.getMessage()));

        } finally
        {
            logger.info(this.getClass().getName()+"::getAllMappingConfigurationTask(User user, String id)::exited");
        }

        return mttask;
    }
    
    public MappingConfigurationTask getMappingConfigurationTaskByName(User user, String name) throws InformaticaCloudException
    {
        logger.info(this.getClass().getName()+"::getAllMappingConfigurationTask(User user, String id)::entered");
        logger.debug(InformaticaCloudRestUrls.MtTask.toString());
        logger.debug(user.toString());
        Writer jsonWriter = null;
        jsonWriter = new StringWriter();
        HttpEntity<String> requestEntity = null;
        ResponseEntity<String> responseEntity = null;
        Error error = null;
        MappingConfigurationTask mttask = null;
        try {
            HttpHeaders tv = new HttpHeaders();
            tv.remove("icSessionId");
            tv.add("icSessionId", user.getIcSessionId());
            tv.add("Content-Type", "application/json");
            tv.add("Accept", "application/json");
            requestEntity = new HttpEntity<String>("", tv);
            responseEntity = rest.exchange(user.getServerUrl()+InformaticaCloudRestUrls.MtTask.toString()+"/name/"+name, HttpMethod.GET, requestEntity, String.class);

            if (responseEntity.getStatusCode().is2xxSuccessful())
            {
                logger.info("Informatica Cloud MappingConfigurationTasks 200 Success");
                mttask = mapper.readValue(responseEntity.getBody(), MappingConfigurationTask.class);
                
                logger.debug(user.toString());
            } else {
                logger.info("Informatica Cloud MappingConfigurationTasks " + responseEntity.getStatusCode().toString());
                error = mapper.readValue(responseEntity.getBody(), Error.class);
                this.setError(error);
                this.setErrorFlag(true);
                logger.debug(error.toString());
                throw new InformaticaCloudException(error.toString(), true);
            }

        }
        catch(JsonParseException jpe) {
            if (requestEntity != null)
                logger.debug(requestEntity.toString());
            if (responseEntity != null)
                logger.debug(responseEntity.toString());

            logger.fatal("JsonParseException::" + jpe.getMessage());
            throw(new InformaticaCloudException(jpe.getMessage()));

        } catch(JsonMappingException jme) {
            if (requestEntity != null)
                logger.debug(requestEntity.toString());
            if (responseEntity != null)
                logger.debug(responseEntity.toString());

            logger.fatal("JsonMappingException::" + jme.getMessage());
            throw(new InformaticaCloudException(jme.getMessage()));

        } catch(RestClientException rce)
        {
            logger.fatal("RestClientException::" + rce.getMessage());
            throw(new InformaticaCloudException(rce.getMessage()));
        } catch(IOException ioe)
        {
            logger.fatal("IOException::" + ioe.getMessage());
            throw(new InformaticaCloudException(ioe.getMessage()));

        } finally
        {
            logger.info(this.getClass().getName()+"::getAllMappingConfigurationTask(User user, String id)::exited");
        }

        return mttask;
    }
    
    public String getMappingConfigurationTaskJSON(User user, String id) throws InformaticaCloudException
    {
        logger.info(this.getClass().getName()+"::getAllMappingConfigurationTask(User user, String id)::entered");
        logger.debug(InformaticaCloudRestUrls.CustomFunc.toString());
        logger.debug(user.toString());
        Writer jsonWriter = null;
        jsonWriter = new StringWriter();
        HttpEntity<String> requestEntity = null;
        ResponseEntity<String> responseEntity = null;
        Error error = null;
        MappingConfigurationTask mttask = null;
        
        String mct = null;
        try {
            HttpHeaders tv = new HttpHeaders();
            tv.remove("icSessionId");
            tv.add("icSessionId", user.getIcSessionId());
            tv.add("Content-Type", "application/json");
            tv.add("Accept", "application/json");
            requestEntity = new HttpEntity<String>("", tv);
            responseEntity = rest.exchange(user.getServerUrl()+InformaticaCloudRestUrls.MtTask.toString()+"/"+id, HttpMethod.GET, requestEntity, String.class);

            if (responseEntity.getStatusCode().is2xxSuccessful())
            {
                logger.info("Informatica Cloud MappingConfigurationTasks 200 Success");
                mct =  responseEntity.getBody();
                
            } else {
                logger.info("Informatica Cloud MappingConfigurationTasks " + responseEntity.getStatusCode().toString());
                error = mapper.readValue(responseEntity.getBody(), Error.class);
                this.setError(error);
                this.setErrorFlag(true);
                logger.debug(error.toString());
                throw new InformaticaCloudException(error.toString(), true);
            }

        }
        catch(JsonParseException jpe) {
            if (requestEntity != null)
                logger.debug(requestEntity.toString());
            if (responseEntity != null)
                logger.debug(responseEntity.toString());

            logger.fatal("JsonParseException::" + jpe.getMessage());
            throw(new InformaticaCloudException(jpe.getMessage()));

        } catch(JsonMappingException jme) {
            if (requestEntity != null)
                logger.debug(requestEntity.toString());
            if (responseEntity != null)
                logger.debug(responseEntity.toString());

            logger.fatal("JsonMappingException::" + jme.getMessage());
            throw(new InformaticaCloudException(jme.getMessage()));

        } catch(RestClientException rce)
        {
            logger.fatal("RestClientException::" + rce.getMessage());
            throw(new InformaticaCloudException(rce.getMessage()));
        } catch(IOException ioe)
        {
            logger.fatal("IOException::" + ioe.getMessage());
            throw(new InformaticaCloudException(ioe.getMessage()));

        } finally
        {
            logger.info(this.getClass().getName()+"::getAllMappingConfigurationTask(User user, String id)::exited");
            return mct;
        }

    }
    
    public MappingConfigurationTask[] getAllMappingConfigurationTasks(User user) throws InformaticaCloudException
    {
        logger.info(this.getClass().getName()+"::getAllMappingConfigurationTasks(User user)::entered");
        logger.debug(InformaticaCloudRestUrls.MtTask.toString());
        logger.debug(user.toString());
        Writer jsonWriter = null;
        jsonWriter = new StringWriter();
        HttpEntity<String> requestEntity = null;
        ResponseEntity<String> responseEntity = null;
        Error error = null;
        MappingConfigurationTask[] mttasks = null;
        try {
            HttpHeaders tv = new HttpHeaders();
            tv.remove("icSessionId");
            tv.add("icSessionId", user.getIcSessionId());
            tv.add("Content-Type", "application/json");
            tv.add("Accept", "application/json");
            requestEntity = new HttpEntity<String>("", tv);
            responseEntity = rest.exchange(user.getServerUrl()+InformaticaCloudRestUrls.MtTask.toString(), HttpMethod.GET, requestEntity, String.class);

            if (responseEntity.getStatusCode().is2xxSuccessful())
            {
                logger.info("Informatica Cloud MappingConfigurationTasks 200 Success");
                mttasks = mapper.readValue(responseEntity.getBody(), MappingConfigurationTask[].class);
                logger.debug(user.toString());
            } else {
                logger.info("Informatica Cloud MappingConfigurationTasks " + responseEntity.getStatusCode().toString());
                error = mapper.readValue(responseEntity.getBody(), Error.class);
                this.setError(error);
                this.setErrorFlag(true);
                logger.debug(error.toString());
                throw new InformaticaCloudException(error.toString(), true);
            }

        }
        catch(JsonParseException jpe) {
            if (requestEntity != null)
                logger.debug(requestEntity.toString());
            if (responseEntity != null)
                logger.debug(responseEntity.toString());

            logger.fatal("JsonParseException::" + jpe.getMessage());
            throw(new InformaticaCloudException(jpe.getMessage()));

        } catch(JsonMappingException jme) {
            if (requestEntity != null)
                logger.debug(requestEntity.toString());
            if (responseEntity != null)
                logger.debug(responseEntity.toString());

            logger.fatal("JsonMappingException::" + jme.getMessage());
            throw(new InformaticaCloudException(jme.getMessage()));

        } catch(RestClientException rce)
        {
            logger.fatal("RestClientException::" + rce.getMessage());
            throw(new InformaticaCloudException(rce.getMessage()));
        } catch(IOException ioe)
        {
            logger.fatal("IOException::" + ioe.getMessage());
            throw(new InformaticaCloudException(ioe.getMessage()));

        } finally
        {
            logger.info(this.getClass().getName()+"::getAllMappingConfigurationTasks(User user)::exited");
        }

        return mttasks;
    }
    
    public Workflow[] getAllWorkflows(User user) throws InformaticaCloudException
    {
        logger.info(this.getClass().getName()+"::getAllWorkflows(User user)::entered");
        logger.debug(InformaticaCloudRestUrls.Workflow.toString());
        logger.debug(user.toString());
        Writer jsonWriter = null;
        jsonWriter = new StringWriter();
        HttpEntity<String> requestEntity = null;
        ResponseEntity<String> responseEntity = null;
        Error error = null;
        Workflow[] workflows = null;
        try {
            HttpHeaders tv = new HttpHeaders();
            tv.remove("icSessionId");
            tv.add("icSessionId", user.getIcSessionId());
            tv.add("Content-Type", "application/json");
            tv.add("Accept", "application/json");
            requestEntity = new HttpEntity<String>("", tv);
            responseEntity = rest.exchange(user.getServerUrl()+InformaticaCloudRestUrls.Workflow.toString(), HttpMethod.GET, requestEntity, String.class);

            if (responseEntity.getStatusCode().is2xxSuccessful())
            {
                logger.info("Informatica Cloud Workflow 200 Success");
                workflows = mapper.readValue(responseEntity.getBody(), Workflow[].class);
                
            } else {
                logger.info("Informatica Cloud Workflow " + responseEntity.getStatusCode().toString());
                error = mapper.readValue(responseEntity.getBody(), Error.class);
                this.setError(error);
                this.setErrorFlag(true);
                logger.debug(error.toString());
                throw new InformaticaCloudException(error.toString(), true);
            }

        }
        catch(JsonParseException jpe) {
            if (requestEntity != null)
                logger.debug(requestEntity.toString());
            if (responseEntity != null)
                logger.debug(responseEntity.toString());

            logger.fatal("JsonParseException::" + jpe.getMessage());
            throw(new InformaticaCloudException(jpe.getMessage()));

        } catch(JsonMappingException jme) {
            if (requestEntity != null)
                logger.debug(requestEntity.toString());
            if (responseEntity != null)
                logger.debug(responseEntity.toString());

            logger.fatal("JsonMappingException::" + jme.getMessage());
            throw(new InformaticaCloudException(jme.getMessage()));

        } catch(RestClientException rce)
        {
            logger.fatal("RestClientException::" + rce.getMessage());
            throw(new InformaticaCloudException(rce.getMessage()));
        } catch(IOException ioe)
        {
            logger.fatal("IOException::" + ioe.getMessage());
            throw(new InformaticaCloudException(ioe.getMessage()));

        } finally
        {
            logger.info(this.getClass().getName()+"::getAllWorkflows(User user)::exited");
        }

        return workflows;
    }
    
    public String getWorkflowJSON(User user, String id) throws InformaticaCloudException
    {
        logger.info(this.getClass().getName()+"::getWorkflowJSON(User user, String id)::entered");
        logger.debug(InformaticaCloudRestUrls.Workflow.toString());
        Writer jsonWriter = null;
        jsonWriter = new StringWriter();
        HttpEntity<String> requestEntity = null;
        ResponseEntity<String> responseEntity = null;
        Error error = null;
        MappingConfigurationTask mttask = null;
        String workflow = null;
        try {
            HttpHeaders tv = new HttpHeaders();
            tv.remove("icSessionId");
            tv.add("icSessionId", user.getIcSessionId());
            tv.add("Content-Type", "application/json");
            tv.add("Accept", "application/json");
            requestEntity = new HttpEntity<String>("", tv);
            responseEntity = rest.exchange(user.getServerUrl()+InformaticaCloudRestUrls.Workflow.toString()+"/"+id, HttpMethod.GET, requestEntity, String.class);

            if (responseEntity.getStatusCode().is2xxSuccessful())
            {
                logger.info("Informatica Cloud MappingConfigurationTasks 200 Success");
                workflow =  responseEntity.getBody();
                
            } else {
                logger.info("Informatica Cloud MappingConfigurationTasks " + responseEntity.getStatusCode().toString());
                error = mapper.readValue(responseEntity.getBody(), Error.class);
                this.setError(error);
                this.setErrorFlag(true);
                logger.debug(error.toString());
                throw new InformaticaCloudException(error.toString(), true);
            }

        }
        catch(JsonParseException jpe) {
            if (requestEntity != null)
                logger.debug(requestEntity.toString());
            if (responseEntity != null)
                logger.debug(responseEntity.toString());

            logger.fatal("JsonParseException::" + jpe.getMessage());
            throw(new InformaticaCloudException(jpe.getMessage()));

        } catch(JsonMappingException jme) {
            if (requestEntity != null)
                logger.debug(requestEntity.toString());
            if (responseEntity != null)
                logger.debug(responseEntity.toString());

            logger.fatal("JsonMappingException::" + jme.getMessage());
            throw(new InformaticaCloudException(jme.getMessage()));

        } catch(RestClientException rce)
        {
            logger.fatal("RestClientException::" + rce.getMessage());
            throw(new InformaticaCloudException(rce.getMessage()));
        } catch(IOException ioe)
        {
            logger.fatal("IOException::" + ioe.getMessage());
            throw(new InformaticaCloudException(ioe.getMessage()));

        } finally
        {
            logger.info(this.getClass().getName()+"::getAllMappingConfigurationTask(User user, String id)::exited");
            return workflow;
        }

    }
    
    
    public Mapping[] getAllMappings(User user) throws InformaticaCloudException
    {
        logger.info(this.getClass().getName()+"::getAllMappings(User user)::entered");
        logger.debug(InformaticaCloudRestUrls.CustomFunc.toString());
        logger.debug(user.toString());
        Writer jsonWriter = null;
        jsonWriter = new StringWriter();
        HttpEntity<String> requestEntity = null;
        ResponseEntity<String> responseEntity = null;
        Error error = null;
        Mapping[] mappings = null;
        try {
            HttpHeaders tv = new HttpHeaders();
            tv.remove("icSessionId");
            tv.add("icSessionId", user.getIcSessionId());
            tv.add("Content-Type", "application/json");
            tv.add("Accept", "application/json");
            requestEntity = new HttpEntity<String>("", tv);
            responseEntity = rest.exchange(user.getServerUrl()+InformaticaCloudRestUrls.Mapping.toString(), HttpMethod.GET, requestEntity, String.class);

            if (responseEntity.getStatusCode().is2xxSuccessful())
            {
                logger.info("Informatica Cloud Mapping 200 Success");
                mappings = mapper.readValue(responseEntity.getBody(), Mapping[].class);
                logger.debug(user.toString());
            } else {
                logger.info("Informatica Cloud Mapping " + responseEntity.getStatusCode().toString());
                error = mapper.readValue(responseEntity.getBody(), Error.class);
                this.setError(error);
                this.setErrorFlag(true);
                logger.debug(error.toString());
                throw new InformaticaCloudException(error.toString(), true);
            }

        }
        catch(JsonParseException jpe) {
            if (requestEntity != null)
                logger.debug(requestEntity.toString());
            if (responseEntity != null)
                logger.debug(responseEntity.toString());

            logger.fatal("JsonParseException::" + jpe.getMessage());
            throw(new InformaticaCloudException(jpe.getMessage()));

        } catch(JsonMappingException jme) {
            if (requestEntity != null)
                logger.debug(requestEntity.toString());
            if (responseEntity != null)
                logger.debug(responseEntity.toString());

            logger.fatal("JsonMappingException::" + jme.getMessage());
            throw(new InformaticaCloudException(jme.getMessage()));

        } catch(RestClientException rce)
        {
            logger.fatal("RestClientException::" + rce.getMessage());
            throw(new InformaticaCloudException(rce.getMessage()));
        } catch(IOException ioe)
        {
            logger.fatal("IOException::" + ioe.getMessage());
            throw(new InformaticaCloudException(ioe.getMessage()));

        } finally
        {
            logger.info(this.getClass().getName()+"::getAllMappings(User user)::exited");
        }

        return mappings;
    }
    
    public Mapping getMapping(User user, String id) throws InformaticaCloudException
    {
        logger.info(this.getClass().getName()+"::getAllMapping(User user, String id)::entered");
        logger.debug(InformaticaCloudRestUrls.CustomFunc.toString());
        logger.debug(user.toString());
        Writer jsonWriter = null;
        jsonWriter = new StringWriter();
        HttpEntity<String> requestEntity = null;
        ResponseEntity<String> responseEntity = null;
        Error error = null;
        Mapping mapping = null;
        try {
            HttpHeaders tv = new HttpHeaders();
            tv.remove("icSessionId");
            tv.add("icSessionId", user.getIcSessionId());
            tv.add("Content-Type", "application/json");
            tv.add("Accept", "application/json");
            requestEntity = new HttpEntity<String>("", tv);
            responseEntity = rest.exchange(user.getServerUrl()+InformaticaCloudRestUrls.Mapping.toString()+"/"+id, HttpMethod.GET, requestEntity, String.class);

            if (responseEntity.getStatusCode().is2xxSuccessful())
            {
                logger.info("Informatica Cloud Mapping 200 Success");
                mapping = mapper.readValue(responseEntity.getBody(), Mapping.class);
                logger.debug(user.toString());
            } else {
                logger.info("Informatica Cloud Mapping " + responseEntity.getStatusCode().toString());
                error = mapper.readValue(responseEntity.getBody(), Error.class);
                this.setError(error);
                this.setErrorFlag(true);
                logger.debug(error.toString());
                throw new InformaticaCloudException(error.toString(), true);
            }

        }
        catch(JsonParseException jpe) {
            if (requestEntity != null)
                logger.debug(requestEntity.toString());
            if (responseEntity != null)
                logger.debug(responseEntity.toString());

            logger.fatal("JsonParseException::" + jpe.getMessage());
            throw(new InformaticaCloudException(jpe.getMessage()));

        } catch(JsonMappingException jme) {
            if (requestEntity != null)
                logger.debug(requestEntity.toString());
            if (responseEntity != null)
                logger.debug(responseEntity.toString());

            logger.fatal("JsonMappingException::" + jme.getMessage());
            throw(new InformaticaCloudException(jme.getMessage()));

        } catch(RestClientException rce)
        {
            logger.fatal("RestClientException::" + rce.getMessage());
            throw(new InformaticaCloudException(rce.getMessage()));
        } catch(IOException ioe)
        {
            logger.fatal("IOException::" + ioe.getMessage());
            throw(new InformaticaCloudException(ioe.getMessage()));

        } finally
        {
            logger.info(this.getClass().getName()+"::getAllMapping(User user, String id)::exited");
        }

        return mapping;
    }

    public Mapping getMappingByName(User user, String name) throws InformaticaCloudException
    {
        logger.info(this.getClass().getName()+"::getMappingByName(User user, String name)::entered");
        logger.debug(user.toString());
        Writer jsonWriter = null;
        jsonWriter = new StringWriter();
        HttpEntity<String> requestEntity = null;
        ResponseEntity<String> responseEntity = null;
        Error error = null;
        Mapping mapping = null;
        try {
            HttpHeaders tv = new HttpHeaders();
            tv.remove("icSessionId");
            tv.add("icSessionId", user.getIcSessionId());
            tv.add("Content-Type", "application/json");
            tv.add("Accept", "application/json");
            requestEntity = new HttpEntity<String>("", tv);
            responseEntity = rest.exchange(user.getServerUrl()+InformaticaCloudRestUrls.Mapping.toString()+"/name/"+name, HttpMethod.GET, requestEntity, String.class);

            if (responseEntity.getStatusCode().is2xxSuccessful())
            {
                logger.info("Informatica Cloud Mapping 200 Success");
                mapping = mapper.readValue(responseEntity.getBody(), Mapping.class);
                logger.debug(user.toString());
            } else {
                logger.info("Informatica Cloud Mapping " + responseEntity.getStatusCode().toString());
                error = mapper.readValue(responseEntity.getBody(), Error.class);
                this.setError(error);
                this.setErrorFlag(true);
                logger.debug(error.toString());
                throw new InformaticaCloudException(error.toString(), true);
            }

        }
        catch(JsonParseException jpe) {
            if (requestEntity != null)
                logger.debug(requestEntity.toString());
            if (responseEntity != null)
                logger.debug(responseEntity.toString());

            logger.fatal("JsonParseException::" + jpe.getMessage());
            throw(new InformaticaCloudException(jpe.getMessage()));

        } catch(JsonMappingException jme) {
            if (requestEntity != null)
                logger.debug(requestEntity.toString());
            if (responseEntity != null)
                logger.debug(responseEntity.toString());

            logger.fatal("JsonMappingException::" + jme.getMessage());
            throw(new InformaticaCloudException(jme.getMessage()));

        } catch(RestClientException rce)
        {
            logger.fatal("RestClientException::" + rce.getMessage());
            throw(new InformaticaCloudException(rce.getMessage()));
        } catch(IOException ioe)
        {
            logger.fatal("IOException::" + ioe.getMessage());
            throw(new InformaticaCloudException(ioe.getMessage()));

        } finally
        {
            logger.info(this.getClass().getName()+"::getMappingByName(User user, String name)::exited");
        }

        return mapping;
    }
    
    public Scheduler[] getAllScheduler(User user) throws InformaticaCloudException
    {
        logger.info(this.getClass().getName()+"::getAllScheduler(User user)::entered");
        logger.debug(InformaticaCloudRestUrls.CustomFunc.toString());
        logger.debug(user.toString());
        Writer jsonWriter = null;
        jsonWriter = new StringWriter();
        HttpEntity<String> requestEntity = null;
        ResponseEntity<String> responseEntity = null;
        Error error = null;
        Scheduler[] schedulers = null;
        try {
            HttpHeaders tv = new HttpHeaders();
            tv.remove("icSessionId");
            tv.add("icSessionId", user.getIcSessionId());
            tv.add("Content-Type", "application/json");
            tv.add("Accept", "application/json");
            requestEntity = new HttpEntity<String>("", tv);
            responseEntity = rest.exchange(user.getServerUrl()+InformaticaCloudRestUrls.Schedule.toString(), HttpMethod.GET, requestEntity, String.class);

            if (responseEntity.getStatusCode().is2xxSuccessful())
            {
                logger.info("Informatica Cloud Scheduler 200 Success");
                schedulers = mapper.readValue(responseEntity.getBody(), Scheduler[].class);
                logger.debug(user.toString());
            } else {
                logger.info("Informatica Cloud Scheduler " + responseEntity.getStatusCode().toString());
                error = mapper.readValue(responseEntity.getBody(), Error.class);
                this.setError(error);
                this.setErrorFlag(true);
                logger.debug(error.toString());
                throw new InformaticaCloudException(error.toString(), true);
            }

        }
        catch(JsonParseException jpe) {
            if (requestEntity != null)
                logger.debug(requestEntity.toString());
            if (responseEntity != null)
                logger.debug(responseEntity.toString());

            logger.fatal("JsonParseException::" + jpe.getMessage());
            throw(new InformaticaCloudException(jpe.getMessage()));

        } catch(JsonMappingException jme) {
            if (requestEntity != null)
                logger.debug(requestEntity.toString());
            if (responseEntity != null)
                logger.debug(responseEntity.toString());

            logger.fatal("JsonMappingException::" + jme.getMessage());
            throw(new InformaticaCloudException(jme.getMessage()));

        } catch(RestClientException rce)
        {
            logger.fatal("RestClientException::" + rce.getMessage());
            throw(new InformaticaCloudException(rce.getMessage()));
        } catch(IOException ioe)
        {
            logger.fatal("IOException::" + ioe.getMessage());
            throw(new InformaticaCloudException(ioe.getMessage()));

        } finally
        {
            logger.info(this.getClass().getName()+"::getAllScheduler(User user)::exited");
        }

        return schedulers;
    }

    public void updateSqlServerConnection(User user, SqlServerConnection connection) throws InformaticaCloudException
    {
        logger.info(this.getClass().getName()+"::updateSqlServerConnection(User user, SqlServerConnection connection)::entered");
        logger.debug(user.getServerUrl()+InformaticaCloudRestUrls.Connection.toString()+"/"+connection.getId());
        logger.debug(user.toString());
        Writer jsonWriter = null;
        jsonWriter = new StringWriter();
        HttpEntity<String> requestEntity = null;
        ResponseEntity<String> responseEntity = null;
        Error error = new Error();

        try {
            HttpHeaders tv = new HttpHeaders();
            tv.remove("icSessionId");
            tv.add("icSessionId", user.getIcSessionId());
            tv.add("Content-Type", "application/json");
            tv.add("Accept", "application/json");
            mapper.writeValue(jsonWriter, connection);
            jsonWriter.flush();
            requestEntity = new HttpEntity<String>(jsonWriter.toString(), tv);

            responseEntity = rest.exchange(user.getServerUrl()+InformaticaCloudRestUrls.Connection.toString()+"/"+connection.getId(), HttpMethod.POST, requestEntity, String.class);

            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                logger.info("Informatica Cloud Connection 200 Success");
                logger.debug(user.toString());
            } else {
                error.setStatusCode(responseEntity.getStatusCodeValue());
                error.setDescription(responseEntity.getBody());
                error.setType("Update Connection");
                throw(new InformaticaCloudException(error.toString()));
            }
        }
        catch(JsonParseException jpe) {
            if (requestEntity != null)
                logger.debug(requestEntity.toString());
            if (responseEntity != null)
                logger.debug(responseEntity.toString());

            logger.fatal("JsonParseException::" + jpe.getMessage());
            throw(new InformaticaCloudException(jpe.getMessage()));

        } catch(JsonMappingException jme) {
            if (requestEntity != null)
                logger.debug(requestEntity.toString());
            if (responseEntity != null)
                logger.debug(responseEntity.toString());

            logger.fatal("JsonMappingException::" + jme.getMessage());
            throw(new InformaticaCloudException(jme.getMessage()));

        } catch(RestClientException rce)
        {
            logger.fatal("RestClientException::" + rce.getMessage());
            throw(new InformaticaCloudException(rce.getMessage()));
        } catch(IOException ioe)
        {
            logger.fatal("IOException::" + ioe.getMessage());
            throw(new InformaticaCloudException(ioe.getMessage()));

        } finally
        {
            logger.info(this.getClass().getName()+"::updateSqlServerConnection(User user, SqlServerConnection connection)::exited");
        }
    }
    
    public void updateODBCConnection(User user, ODBCConnection connection) throws InformaticaCloudException
    {
        logger.info(this.getClass().getName()+"::updateODBCConnection(User user, ODBCConnection connection)::entered");
        logger.debug(user.getServerUrl()+InformaticaCloudRestUrls.Connection.toString()+"/"+connection.getId());
        logger.debug(user.toString());
        Writer jsonWriter = null;
        jsonWriter = new StringWriter();
        HttpEntity<String> requestEntity = null;
        ResponseEntity<String> responseEntity = null;
        Error error = new Error();

        try {
            HttpHeaders tv = new HttpHeaders();
            tv.remove("icSessionId");
            tv.add("icSessionId", user.getIcSessionId());
            tv.add("Content-Type", "application/json");
            tv.add("Accept", "application/json");
            mapper.writeValue(jsonWriter, connection);
            jsonWriter.flush();
            requestEntity = new HttpEntity<String>(jsonWriter.toString(), tv);

            responseEntity = rest.exchange(user.getServerUrl()+InformaticaCloudRestUrls.Connection.toString()+"/"+connection.getId(), HttpMethod.POST, requestEntity, String.class);

            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                logger.info("Informatica Cloud Connection 200 Success");
                logger.debug(user.toString());
            } else {
                error.setStatusCode(responseEntity.getStatusCodeValue());
                error.setDescription(responseEntity.getBody());
                error.setType("Update Connection");
                throw(new InformaticaCloudException(error.toString()));
            }
        }
        catch(JsonParseException jpe) {
            if (requestEntity != null)
                logger.debug(requestEntity.toString());
            if (responseEntity != null)
                logger.debug(responseEntity.toString());

            logger.fatal("JsonParseException::" + jpe.getMessage());
            throw(new InformaticaCloudException(jpe.getMessage()));

        } catch(JsonMappingException jme) {
            if (requestEntity != null)
                logger.debug(requestEntity.toString());
            if (responseEntity != null)
                logger.debug(responseEntity.toString());

            logger.fatal("JsonMappingException::" + jme.getMessage());
            throw(new InformaticaCloudException(jme.getMessage()));

        } catch(RestClientException rce)
        {
            logger.fatal("RestClientException::" + rce.getMessage());
            throw(new InformaticaCloudException(rce.getMessage()));
        } catch(IOException ioe)
        {
            logger.fatal("IOException::" + ioe.getMessage());
            throw(new InformaticaCloudException(ioe.getMessage()));

        } finally
        {
            logger.info(this.getClass().getName()+"::updateODBCConnection(User user, ODBCConnection connection)::exited");
        }
    }
    
    public void updateOracleConnection(User user, OracleConnection connection) throws InformaticaCloudException
    {
        logger.info(this.getClass().getName()+"::updateOracleConnection(User user, OracleConnection connection)::entered");
        logger.debug(user.getServerUrl()+InformaticaCloudRestUrls.Connection.toString()+"/"+connection.getId());
        logger.debug(user.toString());
        Writer jsonWriter = null;
        jsonWriter = new StringWriter();
        HttpEntity<String> requestEntity = null;
        ResponseEntity<String> responseEntity = null;
        Error error = new Error();

        try {
            HttpHeaders tv = new HttpHeaders();
            tv.remove("icSessionId");
            tv.add("icSessionId", user.getIcSessionId());
            tv.add("Content-Type", "application/json");
            tv.add("Accept", "application/json");
            mapper.writeValue(jsonWriter, connection);
            jsonWriter.flush();
            requestEntity = new HttpEntity<String>(jsonWriter.toString(), tv);

            responseEntity = rest.exchange(user.getServerUrl()+InformaticaCloudRestUrls.Connection.toString()+"/"+connection.getId(), HttpMethod.POST, requestEntity, String.class);

            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                logger.info("Informatica Cloud Connection 200 Success");
                logger.debug(user.toString());
            } else {
                error.setStatusCode(responseEntity.getStatusCodeValue());
                error.setDescription(responseEntity.getBody());
                error.setType("Update Connection");
                throw(new InformaticaCloudException(error.toString()));
            }
        }
        catch(JsonParseException jpe) {
            if (requestEntity != null)
                logger.debug(requestEntity.toString());
            if (responseEntity != null)
                logger.debug(responseEntity.toString());

            logger.fatal("JsonParseException::" + jpe.getMessage());
            throw(new InformaticaCloudException(jpe.getMessage()));

        } catch(JsonMappingException jme) {
            if (requestEntity != null)
                logger.debug(requestEntity.toString());
            if (responseEntity != null)
                logger.debug(responseEntity.toString());

            logger.fatal("JsonMappingException::" + jme.getMessage());
            throw(new InformaticaCloudException(jme.getMessage()));

        } catch(RestClientException rce)
        {
            logger.fatal("RestClientException::" + rce.getMessage());
            throw(new InformaticaCloudException(rce.getMessage()));
        } catch(IOException ioe)
        {
            logger.fatal("IOException::" + ioe.getMessage());
            throw(new InformaticaCloudException(ioe.getMessage()));

        } finally
        {
            logger.info(this.getClass().getName()+"::updateOracleConnection(User user, OracleConnection connection)::exited");
        }
    }

    public void updateTeradataConnection(User user, Teradata connection) throws InformaticaCloudException
    {
        logger.info(this.getClass().getName()+"::updateTeradataConnection(User user, Teradata connection)::entered");
        logger.debug(user.getServerUrl()+InformaticaCloudRestUrls.Connection.toString()+"/"+connection.getId());
        logger.debug(user.toString());
        Writer jsonWriter = null;
        jsonWriter = new StringWriter();
        HttpEntity<String> requestEntity = null;
        ResponseEntity<String> responseEntity = null;
        Error error = new Error();

        try {
            HttpHeaders tv = new HttpHeaders();
            tv.remove("icSessionId");
            tv.add("icSessionId", user.getIcSessionId());
            tv.add("Content-Type", "application/json");
            tv.add("Accept", "application/json");
            tv.add("Update-Mode", "PARTIAL");
            mapper.writeValue(jsonWriter, connection);
            jsonWriter.flush();
            requestEntity = new HttpEntity<String>(jsonWriter.toString(), tv);

            responseEntity = rest.exchange(user.getServerUrl()+InformaticaCloudRestUrls.Connection.toString()+"/"+connection.getId(), HttpMethod.POST, requestEntity, String.class);

            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                logger.info("Informatica Cloud Connection 200 Success");
                logger.debug(user.toString());
            } else {
                error.setStatusCode(responseEntity.getStatusCodeValue());
                error.setDescription(responseEntity.getBody());
                error.setType("Update Connection");
                throw(new InformaticaCloudException(error.toString()));
            }
        }
        catch(JsonParseException jpe) {
            if (requestEntity != null)
                logger.debug(requestEntity.toString());
            if (responseEntity != null)
                logger.debug(responseEntity.toString());

            logger.fatal("JsonParseException::" + jpe.getMessage());
            throw(new InformaticaCloudException(jpe.getMessage()));

        } catch(JsonMappingException jme) {
            if (requestEntity != null)
                logger.debug(requestEntity.toString());
            if (responseEntity != null)
                logger.debug(responseEntity.toString());

            logger.fatal("JsonMappingException::" + jme.getMessage());
            throw(new InformaticaCloudException(jme.getMessage()));

        } catch(RestClientException rce)
        {
            logger.fatal("RestClientException::" + rce.getMessage());
            throw(new InformaticaCloudException(rce.getMessage()));
        } catch(IOException ioe)
        {
            logger.fatal("IOException::" + ioe.getMessage());
            throw(new InformaticaCloudException(ioe.getMessage()));

        } finally
        {
            logger.info(this.getClass().getName()+"::updateTeradataConnection(User user, Teradata connection)::exited");
        }
    }

    public Connection getConnectionByName(User user, String name) throws InformaticaCloudException
    {
        logger.info(this.getClass().getName()+"::getConnectionByName(User user, String name)::entered");

        logger.debug(user.toString());
        Writer jsonWriter = null;
        jsonWriter = new StringWriter();
        HttpEntity<String> requestEntity = null;
        ResponseEntity<String> responseEntity = null;
        Error error = null;
        Connection connection = null;

        try {
            String enc_name = URLEncoder.encode(name,"UTF-8");
            logger.debug(InformaticaCloudRestUrls.Connection.toString()+"/name/"+enc_name);
            HttpHeaders tv = new HttpHeaders();
            tv.remove("icSessionId");
            tv.add("icSessionId", user.getIcSessionId());
            tv.add("Content-Type", "application/json");
            tv.add("Accept", "application/json");
            requestEntity = new HttpEntity<String>("", tv);
            responseEntity = rest.exchange(user.getServerUrl()+InformaticaCloudRestUrls.Connection.toString()+"/name/"+enc_name, HttpMethod.GET, requestEntity, String.class);

            if (responseEntity.getStatusCode().is2xxSuccessful())
            {
                logger.info("Informatica Cloud Connection 200 Success");
                connection = mapper.readValue(responseEntity.getBody(), Connection.class);
                logger.debug(user.toString());
            } else {
                logger.info("Informatica Cloud Connection " + responseEntity.getStatusCode().toString());
                error = mapper.readValue(responseEntity.getBody(), Error.class);
                this.setError(error);
                this.setErrorFlag(true);
                logger.debug(error.toString());
                throw new InformaticaCloudException(error.toString(), true);
            }
        }
        catch(JsonParseException jpe) {
            if (requestEntity != null)
                logger.debug(requestEntity.toString());
            if (responseEntity != null)
                logger.debug(responseEntity.toString());

            logger.fatal("JsonParseException::" + jpe.getMessage());
            throw(new InformaticaCloudException(jpe.getMessage()));

        } catch(JsonMappingException jme) {
            if (requestEntity != null)
                logger.debug(requestEntity.toString());
            if (responseEntity != null)
                logger.debug(responseEntity.toString());

            logger.fatal("JsonMappingException::" + jme.getMessage());
            throw(new InformaticaCloudException(jme.getMessage()));

        } catch(RestClientException rce)
        {
            logger.fatal("RestClientException::" + rce.getMessage());
            throw(new InformaticaCloudException(rce.getMessage()));
        } catch(IOException ioe)
        {
            logger.fatal("IOException::" + ioe.getMessage());
            throw(new InformaticaCloudException(ioe.getMessage()));

        } finally
        {
            logger.info(this.getClass().getName()+"::getConnectionByName(User user, String name)::exited");
        }

        return connection;
    }

    public IConnection getConnection(User user, String id) throws InformaticaCloudException
    {
        logger.info(this.getClass().getName()+"::getConnection(User user, String id)::entered");
        logger.debug(InformaticaCloudRestUrls.Connection.toString()+"/"+id);
        logger.debug(user.toString());
        Writer jsonWriter = null;
        jsonWriter = new StringWriter();
        HttpEntity<String> requestEntity = null;
        ResponseEntity<String> responseEntity = null;
        Error error = null;
        Connection connection = null;
        IConnection dynamic = null;
        try {
            HttpHeaders tv = new HttpHeaders();
            tv.remove("icSessionId");
            tv.add("icSessionId", user.getIcSessionId());
            tv.add("Content-Type", "application/json");
            tv.add("Accept", "application/json");
            requestEntity = new HttpEntity<String>("", tv);
            responseEntity = rest.exchange(user.getServerUrl()+InformaticaCloudRestUrls.Connection.toString()+"/"+id, HttpMethod.GET, requestEntity, String.class);

            if (responseEntity.getStatusCode().is2xxSuccessful())
            {
                logger.info("Informatica Cloud Connection 200 Success");
                connection = mapper.readValue(responseEntity.getBody(), Connection.class);
                String type;
                if (connection.getType().equals("TOOLKIT"))
                {
                    type = connection.getInstanceName();
                } else {
                    type = connection.getType();
                }
                if (type.equals("Teradata"))
                    dynamic = mapper.readValue(responseEntity.getBody(), Teradata.class);
                else if (type.equals("Oracle"))
                    dynamic = mapper.readValue(responseEntity.getBody(), OracleConnection.class);
                else if (type.contains("SqlServer"))
                    dynamic = mapper.readValue(responseEntity.getBody(), SqlServerConnection.class);
                else if (type.equals("ODBC"))
                		dynamic = mapper.readValue(responseEntity.getBody(), ODBCConnection.class);

                logger.debug(user.toString());
            } else {
                logger.info("Informatica Cloud Connection " + responseEntity.getStatusCode().toString());
                error = mapper.readValue(responseEntity.getBody(), Error.class);
                this.setError(error);
                this.setErrorFlag(true);
                logger.debug(error.toString());
                throw new InformaticaCloudException(error.toString(), true);
            }
        }
        catch(JsonParseException jpe) {
            if (requestEntity != null)
                logger.debug(requestEntity.toString());
            if (responseEntity != null)
                logger.debug(responseEntity.toString());

            logger.fatal("JsonParseException::" + jpe.getMessage());
            throw(new InformaticaCloudException(jpe.getMessage()));

        } catch(JsonMappingException jme) {
            if (requestEntity != null)
                logger.debug(requestEntity.toString());
            if (responseEntity != null)
                logger.debug(responseEntity.toString());

            logger.fatal("JsonMappingException::" + jme.getMessage());
            throw(new InformaticaCloudException(jme.getMessage()));

        } catch(RestClientException rce)
        {
            logger.fatal("RestClientException::" + rce.getMessage());
            throw(new InformaticaCloudException(rce.getMessage()));
        } catch(IOException ioe)
        {
            logger.fatal("IOException::" + ioe.getMessage());
            throw(new InformaticaCloudException(ioe.getMessage()));

        } finally
        {
            logger.info(this.getClass().getName()+"::getConnection(User user, String id)::exited");
        }

        return dynamic;
    }

    public Connection[] getAllConnections(User user) throws InformaticaCloudException
    {
        logger.info(this.getClass().getName()+"::getAllConnections(User user)::entered");
        logger.debug(InformaticaCloudRestUrls.Connection.toString());
        logger.debug(user.toString());
        Writer jsonWriter = null;
        jsonWriter = new StringWriter();
        HttpEntity<String> requestEntity = null;
        ResponseEntity<String> responseEntity = null;
        Error error = null;
        Connection[] connections = null;
        try {
            HttpHeaders tv = new HttpHeaders();
            tv.remove("icSessionId");
            tv.add("icSessionId", user.getIcSessionId());
            tv.add("Content-Type", "application/json");
            tv.add("Accept", "application/json");
            requestEntity = new HttpEntity<String>("", tv);
            responseEntity = rest.exchange(user.getServerUrl()+InformaticaCloudRestUrls.Connection.toString(), HttpMethod.GET, requestEntity, String.class);

            if (responseEntity.getStatusCode().is2xxSuccessful())
            {
                logger.info("Informatica Cloud Connection 200 Success");
                connections = mapper.readValue(responseEntity.getBody(), Connection[].class);
                logger.debug(user.toString());
            } else {
                logger.info("Informatica Cloud Connection " + responseEntity.getStatusCode().toString());
                error = mapper.readValue(responseEntity.getBody(), Error.class);
                this.setError(error);
                this.setErrorFlag(true);
                logger.debug(error.toString());
                throw new InformaticaCloudException(error.toString(), true);
            }
        }
        catch(JsonParseException jpe) {
            if (requestEntity != null)
                logger.debug(requestEntity.toString());
            if (responseEntity != null)
                logger.debug(responseEntity.toString());

            logger.fatal("JsonParseException::" + jpe.getMessage());
            throw(new InformaticaCloudException(jpe.getMessage()));

        } catch(JsonMappingException jme) {
            if (requestEntity != null)
                logger.debug(requestEntity.toString());
            if (responseEntity != null)
                logger.debug(responseEntity.toString());

            logger.fatal("JsonMappingException::" + jme.getMessage());
            throw(new InformaticaCloudException(jme.getMessage()));

        } catch(RestClientException rce)
        {
            logger.fatal("RestClientException::" + rce.getMessage());
            throw(new InformaticaCloudException(rce.getMessage()));
        } catch(IOException ioe)
        {
            logger.fatal("IOException::" + ioe.getMessage());
            throw(new InformaticaCloudException(ioe.getMessage()));

        } finally
        {
            logger.info(this.getClass().getName()+"::getAllConnections(User user)::exited");
        }

        return connections;
    }


    public CustomFunc[] getAllCustomFunc(User user) throws InformaticaCloudException
    {
        logger.info(this.getClass().getName()+"::getAllCustomFunc(User user)::entered");
        logger.debug(InformaticaCloudRestUrls.CustomFunc.toString());
        logger.debug(user.toString());
        Writer jsonWriter = null;
        jsonWriter = new StringWriter();
        HttpEntity<String> requestEntity = null;
        ResponseEntity<String> responseEntity = null;
        Error error = null;
        CustomFunc[] mapplets = null;
        try {
            HttpHeaders tv = new HttpHeaders();
            tv.remove("icSessionId");
            tv.add("icSessionId", user.getIcSessionId());
            tv.add("Content-Type", "application/json");
            tv.add("Accept", "application/json");
            requestEntity = new HttpEntity<String>("", tv);
            responseEntity = rest.exchange(user.getServerUrl()+InformaticaCloudRestUrls.CustomFunc.toString(), HttpMethod.GET, requestEntity, String.class);

            if (responseEntity.getStatusCode().is2xxSuccessful())
            {
                logger.info("Informatica Cloud CustomFunc 200 Success");
                mapplets = mapper.readValue(responseEntity.getBody(), CustomFunc[].class);
                logger.debug(user.toString());
            } else {
                logger.info("Informatica Cloud CustomFunc " + responseEntity.getStatusCode().toString());
                error = mapper.readValue(responseEntity.getBody(), Error.class);
                this.setError(error);
                this.setErrorFlag(true);
                logger.debug(error.toString());
                throw new InformaticaCloudException(error.toString(), true);
            }

        }
         catch(JsonParseException jpe) {
            if (requestEntity != null)
                logger.debug(requestEntity.toString());
            if (responseEntity != null)
                logger.debug(responseEntity.toString());

            logger.fatal("JsonParseException::" + jpe.getMessage());
            throw(new InformaticaCloudException(jpe.getMessage()));

        } catch(JsonMappingException jme) {
            if (requestEntity != null)
                logger.debug(requestEntity.toString());
            if (responseEntity != null)
                logger.debug(responseEntity.toString());

            logger.fatal("JsonMappingException::" + jme.getMessage());
            throw(new InformaticaCloudException(jme.getMessage()));

        } catch(RestClientException rce)
        {
            logger.fatal("RestClientException::" + rce.getMessage());
            throw(new InformaticaCloudException(rce.getMessage()));
        } catch(IOException ioe)
        {
            logger.fatal("IOException::" + ioe.getMessage());
            throw(new InformaticaCloudException(ioe.getMessage()));

        } finally
        {
            logger.info(this.getClass().getName()+"::getAllCustomFunc(User user)::exited");
        }

        return mapplets;
    }

    public boolean logout(User user) throws InformaticaCloudException {
        //this.setErrorFlag(false);
        //this.setError(null);
        logger.info(this.getClass().getName()+"::logout::entered");
        logger.debug(InformaticaCloudRestUrls.Logout.toString());
        //logger.debug(user.toString());
        Writer jsonWriter = null;
        jsonWriter = new StringWriter();
        HttpEntity<String> requestEntity = null;
        ResponseEntity<String> responseEntity = null;
        Error error = null;
        boolean result = false;
        try
        {
        	HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json");
            headers.add("Accept", "application/json");
            headers.add("icSessionId", user.getIcSessionId());
            logger.debug(headers.toString());
            
            requestEntity = new HttpEntity<String>("", headers);

            responseEntity = rest.exchange(user.getServerUrl()+InformaticaCloudRestUrls.Logout, HttpMethod.POST, requestEntity, String.class);
            if (responseEntity.getStatusCode().is2xxSuccessful())
            {
                logger.info("Informatica Cloud Logout 200 Success");
                result = true;
            } else {
                logger.info("Informatica Cloud Logout " + responseEntity.getStatusCode().toString());
                //error = mapper.readValue(responseEntity.getBody(), Error.class);
                //this.setError(error);
                //this.setErrorFlag(true);
                //logger.debug(error.toString());
                throw new InformaticaCloudException(responseEntity.toString(), true);
            }
        } catch(Exception e)
        {
            logger.error(e.getClass().getName() + e.getMessage());
            	throw new InformaticaCloudException(e.getMessage());
        }  
        logger.info(this.getClass().getName()+"::logout::exited");
        logger.info("Logout Response::" + result);
        return result;
    }

    public boolean logoutAll(Logout logout) throws InformaticaCloudException {
        this.setErrorFlag(false);
        this.setError(null);
        logger.info(this.getClass().getName()+"::logoutAll(Logout logout)::entered");
        logger.debug(InformaticaCloudRestUrls.Login.toString());
        logger.debug(logout.toString());
        Writer jsonWriter = null;
        jsonWriter = new StringWriter();
        HttpEntity<String> requestEntity = null;
        ResponseEntity<String> responseEntity = null;
        Error error = null;
        boolean result = false;
        try
        {
            mapper.writeValue(jsonWriter, logout);
            jsonWriter.flush();
            requestEntity = new HttpEntity<String>(jsonWriter.toString(), this.headers);

            responseEntity = rest.exchange(InformaticaCloudRestUrls.LogoutAll.toString(), HttpMethod.POST, requestEntity, String.class);
            if (responseEntity.getStatusCode().is2xxSuccessful())
            {
                logger.info("Informatica Cloud LogoutAll 200 Success");
                result = true;
            } else {
                logger.info("Informatica Cloud LogoutAll " + responseEntity.getStatusCode().toString());
                error = mapper.readValue(responseEntity.getBody(), Error.class);
                this.setError(error);
                this.setErrorFlag(true);
                logger.debug(error.toString());
                throw(new InformaticaCloudException(error.toString(), true));
            }
        } catch(RestClientException rce)
        {
            logger.fatal("RestClientException::" + rce.getMessage());
            throw(new InformaticaCloudException(rce.getMessage()));
        } catch(IOException ioe)
        {
            logger.fatal("IOException::" + ioe.getMessage());
            throw(new InformaticaCloudException(ioe.getMessage()));

        } finally
        {
            logger.info(this.getClass().getName()+"::logoutAll(Logout logout)::exited");
            logger.info("LogoutAll Response::" + result);
            return result;
        }

    }

    public ActivityLog[] activityLog(User user, Job job) throws InformaticaCloudException {
        logger.info(this.getClass().getName()+"::activityLog(User user, Job job)::entered");
        ActivityLog[] logs = this.activityLog(user, job, -1, -1);
        logger.info(this.getClass().getName()+"::activityLog(User user, Job job)::exited");
        return logs;
    }

    public ActivityLog[] activityLog(User user, Job job, int offset) throws InformaticaCloudException {
        logger.info(this.getClass().getName()+"::activityLog(User user, Job job, int offset)::entered");
        ActivityLog[] logs = this.activityLog(user, job, offset, -1);
        logger.info(this.getClass().getName()+"::activityLog(User user, Job job, int offset)::exited");
        return logs;
    }

    public ActivityLog[] activityLog(User user, Job job, int offset, int rowLimit) throws InformaticaCloudException {
        //this.setErrorFlag(false);
        //this.setError(null);
        HttpEntity<String> requestEntity = null;
        ResponseEntity<String> responseEntity = null;
        Error error = null;
        ActivityLog[] logs = null;
        try
        {
            if (user == null)
            {
                throw new InformaticaCloudException("User is null");
            }
            if (job == null)
            {
            		throw new InformaticaCloudException("Job is null");
            }
            logger.info(this.getClass().getName()+"::activityLog(User user, Job job, int offset)::entered");
            StringBuffer activityLogUrl = new StringBuffer();
            activityLogUrl.append(user.getServerUrl()+InformaticaCloudRestUrls.ActivityLog+"?taskId="+job.getTaskId()+"&runId="+job.getRunId());
            logger.trace(activityLogUrl.toString());
            if (offset > 0)
                activityLogUrl.append("&offset="+offset);
            if (rowLimit > 0)
                activityLogUrl.append("&rowLimit="+rowLimit);

            logger.debug(activityLogUrl.toString());



            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json");
            headers.add("Accept", "application/json");
            headers.add("icSessionId", user.getIcSessionId());
            logger.debug(headers.toString());
            
            requestEntity = new HttpEntity<String>("", headers);
            responseEntity = rest.exchange(activityLogUrl.toString(), HttpMethod.GET, requestEntity, String.class);

            if (responseEntity.getStatusCode().is2xxSuccessful())
            {
                logger.info("Informatica Cloud ActivityLog 200 Success");
                logs = mapper.readValue(responseEntity.getBody(), ActivityLog[].class);
                logger.debug(Arrays.toString(logs));
            } else {
                logger.info("Informatica Cloud ActivityLog " + responseEntity.getStatusCode().toString());
                throw(new InformaticaCloudException(responseEntity.toString(), true));
            }
        } catch(JsonParseException e) {

            logger.error(e.getClass().getName() + e.getMessage());
            throw(new InformaticaCloudException(e.getMessage()));

        } catch(JsonMappingException e) {
        		logger.error(e.getClass().getName() + e.getMessage());
            throw(new InformaticaCloudException(e.getMessage()));

        } catch(RestClientException e)
        {
        		logger.error(e.getClass().getName() + e.getMessage());
            throw(new InformaticaCloudException(e.getMessage()));
        } catch(IOException e)
        {
        		logger.error(e.getClass().getName() + e.getMessage());
            throw(new InformaticaCloudException(e.getMessage()));

        } catch(Exception e)
        {
        		logger.error(e.getClass().getName() + e.getMessage());
            throw(new InformaticaCloudException(e.getMessage()));

        }
            logger.info(this.getClass().getName()+"::activityLog(User user, Job job, int offset)::exited");

            if (logs.length > 1)
                throw new InformaticaCloudException("More than 1 Log returned. Total Logs " + logs.length);
            else if (logs.length == 0)
            		return null;
            else
                return logs;

    }

    public ActivityMonitor[] activityMonitor(User user, boolean details) throws InformaticaCloudException {
        //this.setErrorFlag(false);
        //this.setError(null);
        HttpEntity<String> requestEntity = null;
        ResponseEntity<String> responseEntity = null;
        Error error = null;
        ActivityMonitor[] logs = null;
        try
        {
            if (user == null)
            {
                throw new InformaticaCloudException("User is null");
            }

            logger.info(this.getClass().getName()+"::activityMonitor(User user, boolean details)::entered");
            StringBuffer activityLogUrl = new StringBuffer();
            activityLogUrl.append(user.getServerUrl()+InformaticaCloudRestUrls.ActivityMonitor+"?details="+Boolean.toString(details));
            logger.trace(activityLogUrl.toString());


            logger.debug(activityLogUrl.toString());



            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json");
            headers.add("Accept", "application/json");
            headers.add("icSessionId", user.getIcSessionId());
            logger.debug(headers.toString());

            requestEntity = new HttpEntity<String>("", headers);
            responseEntity = rest.exchange(activityLogUrl.toString(), HttpMethod.GET, requestEntity, String.class);

            if (responseEntity.getStatusCode().is2xxSuccessful())
            {
                logger.info("Informatica Cloud ActivityLog 200 Success");
                logs = mapper.readValue(responseEntity.getBody(), ActivityMonitor[].class);
                logger.debug(Arrays.toString(logs));
            } else {
                logger.info("Informatica Cloud ActivityLog " + responseEntity.getStatusCode().toString());
                throw(new InformaticaCloudException(responseEntity.toString(), true));
            }
        } catch(JsonParseException e) {

            logger.error(e.getClass().getName() + e.getMessage());
            throw(new InformaticaCloudException(e.getMessage()));

        } catch(JsonMappingException e) {
            logger.error(e.getClass().getName() + e.getMessage());
            throw(new InformaticaCloudException(e.getMessage()));

        } catch(RestClientException e)
        {
            logger.error(e.getClass().getName() + e.getMessage());
            throw(new InformaticaCloudException(e.getMessage()));
        } catch(IOException e)
        {
            logger.error(e.getClass().getName() + e.getMessage());
            throw(new InformaticaCloudException(e.getMessage()));

        } catch(Exception e)
        {
            logger.error(e.getClass().getName() + e.getMessage());
            throw(new InformaticaCloudException(e.getMessage()));

        }
        logger.info(this.getClass().getName()+"::activityLog(User user, Job job, int offset)::exited");

        if (logs.length > 1)
            throw new InformaticaCloudException("More than 1 Log returned. Total Logs " + logs.length);
        else if (logs.length == 0)
            return null;
        else
            return logs;

    }

    public Job job(User user, Job request, boolean start) throws InformaticaCloudException {
        //this.setErrorFlag(false);
        //this.setError(null);
        logger.info(this.getClass().getName()+"::job(User user, Job request, boolean start)::entered");
        logger.debug(InformaticaCloudRestUrls.Login.toString());
        //logger.debug(user.toString());
        logger.debug(request.toString());
        logger.debug("Start Job::" + start);
        Writer jsonWriter = null;
        jsonWriter = new StringWriter();
        HttpEntity<String> requestEntity = null;
        ResponseEntity<String> responseEntity = null;
        Error error = null;
        Job response = null;
        try
        {
            mapper.writeValue(jsonWriter, request);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json");
            headers.add("Accept", "application/json");
            headers.add("icSessionId", user.getIcSessionId());
            logger.debug(headers.toString());
            jsonWriter.flush();
            requestEntity = new HttpEntity<String>(jsonWriter.toString(), headers);

            if (start)
                responseEntity = rest.exchange(user.getServerUrl()+InformaticaCloudRestUrls.Job, HttpMethod.POST, requestEntity, String.class);
            else
                responseEntity = rest.exchange(user.getServerUrl()+InformaticaCloudRestUrls.Job+"/stop", HttpMethod.POST, requestEntity, String.class);

            if (responseEntity.getStatusCode().is2xxSuccessful())
            {
                logger.info("Informatica Cloud Job 200 Success");
                response = mapper.readValue(responseEntity.getBody(), Job.class);
                logger.debug(response.toString());
            } else {
                logger.error("Informatica Cloud Job " + responseEntity.getStatusCode().toString());
                throw(new InformaticaCloudException(responseEntity.toString(), true));
            }
        } catch(JsonParseException e) {
            logger.error(e.getClass().getName() + e.getMessage());
            throw(new InformaticaCloudException(e.getMessage()));

        } catch(JsonMappingException e) {
            logger.error(e.getClass().getName() + e.getMessage());
            throw(new InformaticaCloudException(e.getMessage()));

        } catch(RestClientException e)
        {
            logger.error(e.getClass().getName() + e.getMessage());
            throw(new InformaticaCloudException(e.getMessage()));
        } catch(IOException e)
        {
            logger.error(e.getClass().getName() + e.getMessage());
            throw(new InformaticaCloudException(e.getMessage()));

        } 
            logger.info(this.getClass().getName()+"::job(User user, Job request, boolean start)::exited");
            return response;
    }

    public boolean hasError() {
        return this.hasError;
    }

    public Error getError() {
        return this.error;
    }

    private void setErrorFlag(boolean flag)
    {
        this.hasError = flag;
    }

    private void setError(Error error)
    {
        this.error = error;
    }
    
    
}
