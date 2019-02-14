package com.metaopsis.icsapi.helper;

public enum InformaticaCloudV3RestUrls {
    Login {
        public String toString() {
            String env = System.getenv("INFA_CLOUD_ENV");
            if (env.equals("SANDBOX"))
                return "https://dm-sandbox.informaticacloud.com/saas/public/core/v3/login";
            else
                return "https://dm-us.informaticacloud.com/saas/public/core/v3/login";
        }
    },
    Logout {
        public String toString() {
            String env = System.getenv("INFA_CLOUD_ENV");
            if (env.equals("SANDBOX"))
                return "https://dm-sandbox.informaticacloud.com/saas/public/core/v3/logout";
            else
                return "https://dm-us.informaticacloud.com/saas/public/core/v3/logout";
        }
    },
    Lookup {
        public String toString() {
            return "/public/core/v3/lookup";
        }
    },
    Export {
        public String toString() {
            return "/public/core/v3/export";
        }
    },
    Import {
        public String toString() {
            return "/public/core/v3/import/package";
        }
    },
    AdvTaskflow {
        public String toString() {
            return "/active-bpel/odata/repository/v4/OdataRepository/Execute(Id='#id')";
        }
    }
}
