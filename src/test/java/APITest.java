import com.metaopsis.icsapi.helper.*;
import com.metaopsis.icsapi.helper.Error;
import com.metaopsis.icsapi.impl.InformaticaCloudException;
import com.metaopsis.icsapi.impl.InformaticaCloudImpl;
import java.util.Iterator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by tbennett on 11/8/16.
 */
public class APITest {

    private InformaticaCloudImpl impl = new InformaticaCloudImpl();

    private final String _USERNAME = "user";
    private final String _PASSWORD = "pwd";
    @Test
    public void FindTasksByMappingId()
    {
        Login login = new Login(_USERNAME,_PASSWORD);
        try {
            User user = impl.login(login);
            String mappingid = "0109VC170000000000H9";
            ArrayList<String> names = new ArrayList<String>();
            /*
            MappingConfigurationTask[] mcts = impl.getAllMappingConfigurationTasks(user);
            for (MappingConfigurationTask mct : mcts) {
                MappingConfigurationTask mtask = impl.getMappingConfigurationTask(user, mct.getId());
                if (mtask.getMappingId().equals(mappingid)) {
                    names.add(mtask.getName());
                }
            } */
            Workflow[] workflows = impl.getAllWorkflows(user);

            impl.logout(user);

            if (!names.isEmpty())
            {
                Iterator<String> list = names.iterator();
                while(list.hasNext())
                {
                    System.out.println(list.next());
                }
            }
        } catch(Exception e)
        {
            e.printStackTrace();
        } catch (InformaticaCloudException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void TestProjectsandFolders()
    {
        String FromXSRF_TOKEN = "9RCJ9ZV8bu3jvMsNSwKaK8";
        String FromCookie = "SERVERID_SAAS=IICS-saas8225480; SERVERID_DA=IICS-da15097400; ICRTSERVERID=IICS-taskflow6247200; SERVERID_AC=IICS-ac15097400; USER_SESSION=5qH4Ly8MvsFjJmmDoNM5e2; XSRF_TOKEN=9RCJ9ZV8bu3jvMsNSwKaK8; infa-cloudshell-shash=153a2341e9589361c1269f2b9d979bd1; AID=TpGsxu6ErE9ZhXONHqDC; symphonyOsgiSid=TpGsxu6ErE9ZhXONHqDC";
        //String ToXSRF_TOKEN = "6IBq6WxdiYAbhRtXUt9NoC";
        //String ToCookie = "USER_SESSION=br6IG0Kme0ziyaGQAREv8S; XSRF_TOKEN=6IBq6WxdiYAbhRtXUt9NoC; ICRTSERVERID=IICS-taskflow6247200; infa-cloudshell-shash=5d3b794925d002f8cf6d48a009e8368e; AID=98oI4lHVv2DnGVT2bw8X; symphonyOsgiSid=98oI4lHVv2DnGVT2bw8X; SERVERID_SAAS=IICS-saas22594040; SERVERID_DA=IICS-da23635240";
        Login fromOrg = new Login(_USERNAME,_PASSWORD);
        Login toOrg = new Login(_USERNAME,_PASSWORD);
        try {
             User fromUser = impl.login(fromOrg);
             //User toUser = impl.login(toOrg);
             Project[] projects = impl.getAllProjects(fromUser,FromXSRF_TOKEN,FromCookie);
             for (Project project : projects)
             {
                 //System.out.println(project.getId()+"/"+project.getName()+"/"+project.getDescription());
                 //if (!project.getName().equals("Default")) {
                     System.out.println("/"+project.getName() + "-" + project.getId());
                     //Project _project = impl.createProject(toUser, new Project(project.getName(), project.getDescription()), ToXSRF_TOKEN, ToCookie);
                     //System.out.println(_project.toString());
                     Folder[] folders = impl.getAllFolders(fromUser, project, FromXSRF_TOKEN, FromCookie);
                     //System.out.println("Folders");
                     for (Folder folder : folders) {
                         System.out.println("\t/"+folder.getName() + "-" + folder.getId());
                        //Folder _folder =  impl.createFolder(toUser, _project, new Folder(folder.getName(), folder.getDescription()), ToXSRF_TOKEN, ToCookie);
                         // System.out.println(_folder.toString());

                     }
                 //}
             }
        } catch(InformaticaCloudException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void TestLoginApiCallSuccess()
    {

        Login login = new Login(_USERNAME,_PASSWORD);
        User user = null;
        try {
            user = impl.login(login);
            //System.out.println(user.toString());
            //assert(user.getEmails().equals("tbennett@informatica.com"));
            Connection[] connections = impl.getAllConnections(user);
            for (Connection connection : connections)
            {
                /* Teradata
                if (connection.getName().equals("TERADATA_TPT_NB_2"))
                {
                    Teradata td = (Teradata) impl.getConnection(user, connection.getId());
                    System.out.println(td.toString());
                    TeradataConnParams connParams = td.getConnParams();
                    connParams.setPassword("Test123");
                    td.setConnParams(connParams);
                    impl.updateTeradataConnection(user, td);
                    break;
                }
                */

                /* Oracle
                if (connection.getName().equals("Dev_Test"))
                {
                    OracleConnection conn = (OracleConnection) impl.getConnection(user, connection.getId());
                    System.out.println(conn.toString());
                    conn.setPassword("HelloWorld123");
                    impl.updateOracleConnection(user, conn);
                    break;
                }
                */

                if (connection.getName().equals("MSSQL_2008_V2"))
                {
                    SqlServerConnection conn = (SqlServerConnection) impl.getConnection(user, connection.getId());
                    System.out.println(conn.toString());
                    conn.setPassword("password123");
                    conn.setDescription("Test Fixed");
                    impl.updateSqlServerConnection(user, conn);
                    break;
                }

            }

        } catch (InformaticaCloudException e) {
            e.printStackTrace();
        } finally {
            try {
                if (user != null)
                    assert (impl.logout(user) == true);
            } catch(Throwable e) {}
        }
    }
/*
    @Test
    public void TestLoginApiCallFail()
    {
        Login login = new Login(_USERNAME,_PASSWORD);

        try {
            User user = impl.login(login);
            if (impl.hasError()) {
                assert(user == null);
                Error error = impl.getError();
                System.out.println(error.toString());
                assert (error.getStatusCode() == 403);

            }

        } catch (InformaticaCloudException e) {
            e.printStackTrace();
        }
    }
*/
    @Test
    public void TestStartJob()
    {
        Login login = new Login(_USERNAME,_PASSWORD);
        Job job = new Job();
        //job.setTaskName("mct_iot_load_infractions");
        job.setTaskType("MTT");
        try {
            User user = impl.login(login);
            if (impl.hasError()) {
                assert(user == null);
                Error error = impl.getError();
                assert (error.getStatusCode() == 403);
                System.out.println(error.toString());
            } else
            {
                Job response = impl.job(user,job,true);
                //assert(response.getTaskId().equals("001F060Z0000000000FV"));
                assert(impl.logout(user) == true);
            }

        } catch (InformaticaCloudException e) {
            e.printStackTrace();
        }
    }
/*
    @Test
    public void TestStartJobWait()
    {
        Login login = new Login(_USERNAME,_PASSWORD);
        Job job = new Job();
        job.setTaskName("mct_iot_load_customers");
        job.setTaskType("MTT");
        try {
            User user = impl.login(login);
            if (impl.hasError()) {
                assert(user == null);
                Error error = impl.getError();
                assert (error.getStatusCode() == 403);
                System.out.println(error.toString());
            } else
            {
                Job response = impl.job(user,job,true);
                //assert(response.getTaskId().equals("001F060Z0000000000F5"));
                ActivityLog[] logs = null;
                do {
                     logs = impl.activityLog(user, response, -1, 1);
                    if (logs == null) Thread.sleep(5000);
                } while(logs == null);
                assert(logs.length == 1);
                System.out.println(logs[0].toString());
                assert(impl.logout(user) == true);
            }

        } catch (InformaticaCloudException e) {
            e.printStackTrace();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    @Test
    public void TestStartJobStop()
    {
        Login login = new Login(_USERNAME,_PASSWORD);
        Job job = new Job();
        job.setTaskName("mct_iot_load_infractions");
        job.setTaskType("MTT");
        try {
            User user = impl.login(login);
            if (impl.hasError()) {
                assert(user == null);
                Error error = impl.getError();
                assert (error.getStatusCode() == 403);
                System.out.println(error.toString());
            } else
            {
                Job response = impl.job(user,job,true);
                Thread.sleep(500);

                //assert(response.getTaskId().equals("001F060Z0000000000F5"));
                Job stop = impl.job(user,job,false);

                assert(impl.logout(user) == true);
            }

        } catch (InformaticaCloudException e) {
            e.printStackTrace();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    @Test
    public void TestStopJobNoJob()
    {
        Login login = new Login(_USERNAME,_PASSWORD);
        Job job = new Job();
        job.setTaskName("mct_iot_load_infractions");
        job.setTaskType("MTT");
        try {
            User user = impl.login(login);
            if (impl.hasError()) {
                assert(user == null);
                Error error = impl.getError();
                assert (error.getStatusCode() == 403);
                System.out.println(error.toString());
            } else
            {

                Job stop = impl.job(user,job,false);
                if (impl.hasError())
                    System.out.println(impl.getError().toString());
                assert(impl.logout(user) == true);
            }

        } catch (InformaticaCloudException e) {
            e.printStackTrace();
        }
    }
    */
    
    @Test
    public void TestGetAllUsers()
    {
    		Login login = new Login(_USERNAME,_PASSWORD);
    		try
    		{
    			User user = impl.login(login);
    			User[] users = impl.getAllUsers(user);
    			StringBuffer buff = new StringBuffer();
    			ArrayList<String> container = new ArrayList<String>();
    			
    			for (User u : users)
    			{
    				if (!container.contains(u.getEmails()))
    				{
    					container.add(u.getEmails());
    					buff.append(u.getEmails()+";");
    				}
    			}
    			
    			System.out.println(buff.toString());
    		} catch(InformaticaCloudException e) {
    			e.printStackTrace();
    		}
    }
}
