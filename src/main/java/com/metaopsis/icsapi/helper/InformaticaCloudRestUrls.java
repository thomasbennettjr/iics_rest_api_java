package com.metaopsis.icsapi.helper;

/**
 * Created by tbennett on 11/7/16.
 */
public enum InformaticaCloudRestUrls {
    ActivityLog {
        public String toString() {
            return "/api/v2/activity/activityLog";
        }
    },
    ActivityMonitor {
        public String toString() {
            return "/api/v2/activity/activityMonitor";
        }
    },
    AuditLog {
        public String toString() {
            return "/api/v2/auditlog";
        }
    },
    Login {
        public String toString() {
            String env = System.getenv("INFA_CLOUD_ENV");
            if (env.toUpperCase().equals("ICS"))
                return "https://app.informaticaondemand.com/ma/api/v2/user/login";
            else if (env.toUpperCase().equals("IICS"))
                return "https://dm-us.informaticacloud.com/ma/api/v2/user/login";
            else // IICS Sandbox
                return "https://dm-sandbox.informaticacloud.com/ma/api/v2/user/login";

        }
    },
    Mapping {
        public String toString() {
            return "/api/v2/mapping";
        }
    },
    Job {
        public String toString() {
            return "/api/v2/job";
        }
    },
    MtTask {
        public String toString() {
            return "/api/v2/mttask/";
        }
    },
    Agent {
        public String toString() {
            return "/api/v2/agent";
        }
    },
    Connection {
        public String toString() {
            return "/api/v2/connection";
        }
    },
    Logout {
        public String toString() {
            return "/api/v2/user/logout";
        }
    },
    LogoutAll {
        public String toString() {
            return "https://app.informaticaondemand.com/ma/api/v2/user/logoutall";
        }
    },
    RuntimeEnvironment {
        public String toString() {
            return "/api/v2/runtimeEnvironment";
        }
    },
    Org {
        public String toString() {
            return "/api/v2/org";
        }
    },
    Schedule {
        public String toString() {
            return "/api/v2/schedule/";
        }
    },
    CustomFunc {
        public String toString() {
            return "/api/v2/customFunc";
        }
    },
    Workflow {
        public String toString() {
            return "/api/v2/workflow";
        }
    },
    ValidateSessionId {
    		public String toString() {
    			return "/api/v2/user/validSessionId";
    		}
    },
    User {
    		public String toString() {
    			return "/api/v2/user";
    		}
    },
    Project {
        public String toString() {return "/frs/api/v1/Projects"; }
    },
    Folder {
        public String toString() {return "/frs/api/v1/Projects('#id')/Folders"; }
    }
}
