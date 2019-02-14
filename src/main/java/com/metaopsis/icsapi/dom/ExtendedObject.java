package com.metaopsis.icsapi.dom;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExtendedObject
{
    @JsonProperty("@type")
    private String type = "extendedObject";
    @JsonProperty("object")
    private exObject object;

    private ExtendedObject(String objectName)
    {

    }

    private class exObject {
        @JsonProperty("@type")
        private String type = "mObject";
        private String name;
        private String label;
        private boolean metadataUpdated = false;

        private exObject() {}

        private exObject(String objectName)
        {
            this.name = objectName;
            this.label = objectName;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String objectName)
        {
            this.name = objectName;
        }

        public String getLabel() {
            return this.label;
        }

        public void setLabel(String objectName)
        {
            this.label = objectName;
        }

        @Override
        public String toString() {
            return "exObject{" +
                    "type='" + type + '\'' +
                    ", name='" + name + '\'' +
                    ", label='" + label + '\'' +
                    ", metadataUpdated='" + metadataUpdated + '\'' +
                    '}';
        }
    }
}
