package com.lijia.code;

import org.springframework.boot.json.JacksonJsonParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Json2Obj {
//    static String jsonStr = "{\n" +
//            "  \"status\": {\n" +
//            "    \"code\": 200,\n" +
//            "    \"message\": \"Request completed fine, no errors\"\n" +
//            "  },\n" +
//            "  \"document\": [\n" +
//            "    {\n" +
//            "      \"id\": 65096287,\n" +
//            "      \"name\": \"2018 Q3 Press Release\",\n" +
//            "      \"orderNumber\": 1,\n" +
//            "      \"version\": \"b6589fc6ab0dc82cf12099d1c2d40ab994e8410c\",\n" +
//            "      \"fileSize\": 496814,\n" +
//            "      \"fileHash\": \"+/tXIoySa9MJyaTVaiK0VFK920w=\",\n" +
//            "      \"fileHashDownload\": \"Zfio7Mdpx7sF9yHKQS6esf2IB7w=\",\n" +
//            "      \"mimeType\": \"APPLICATION/PDF\",\n" +
//            "      \"noteRequired\": false,\n" +
//            "      \"parentId\": 58813337,\n" +
//            "      \"createdOn\": {\n" +
//            "        \"milliseconds\": 1583809392000\n" +
//            "      },\n" +
//            "      \"createdBy\": {\n" +
//            "        \"firstName\": \"Matt\",\n" +
//            "        \"lastName\": \"Terrill\",\n" +
//            "        \"firstNameSort\": \"Matt\",\n" +
//            "        \"lastNameSort\": \"Terrill\",\n" +
//            "        \"organization\": \"API Dev Portal Test App\",\n" +
//            "        \"organizationSort\": \"API Dev Portal Test App\"\n" +
//            "      },\n" +
//            "      \"submittedOn\": {},\n" +
//            "      \"submittedBy\": {},\n" +
//            "      \"submitterGroups\": {},\n" +
//            "      \"lastModifiedOn\": {\n" +
//            "        \"milliseconds\": 1583809392000\n" +
//            "      },\n" +
//            "      \"lastModifiedBy\": {\n" +
//            "        \"firstName\": \"Matt\",\n" +
//            "        \"lastName\": \"Terrill\",\n" +
//            "        \"firstNameSort\": \"Matt\",\n" +
//            "        \"lastNameSort\": \"Terrill\"\n" +
//            "      },\n" +
//            "      \"unread\": false,\n" +
//            "      \"pageCount\": 41,\n" +
//            "      \"workspaceId\": 1213191,\n" +
//            "      \"versionNumber\": 0,\n" +
//            "      \"isFavorite\": false,\n" +
//            "      \"pdfProtection\": \"NONE\",\n" +
//            "      \"hasNote\": false,\n" +
//            "      \"extension\": \".pdf\",\n" +
//            "      \"isIrmSecured\": false,\n" +
//            "      \"isDeleted\": false,\n" +
//            "      \"isBusinessProcessEnabled\": false,\n" +
//            "      \"documentHash\": \"0\",\n" +
//            "      \"sharedResourceId\": 30341977,\n" +
//            "      \"sharedResourceCount\": 0,\n" +
//            "      \"entityType\": \"DOCUMENT\"\n" +
//            "    }\n" +
//            "  ]\n" +
//            "}";
//
//    public static void main(String[] args) {
//        Map<String, Object> map = new JacksonJsonParser().parseMap(jsonStr);
//        final List<JsonClass> list = new ArrayList();
//        parseJson(map, "Workspace", list);
//        Strings.
//
//    }
//
//    private static void parseJson(Map<String, Object> map, String classname, List<JsonClass> list) {
//        JsonClass jsonclass = new JsonClass(classname);
//        map.entrySet().stream().forEach(entry-> jsonclass.addfield(parseJson(entry, list)));
//    }
//
//
//
//
//    static class JsonClass {
//        final String name;
//        List<Field>
//
//
//        JsonClass(String name) {
//            this.name = name;
//        }
//    }
//    static class Field{
//        String name;
//        String type;
//
//        public String getName() {
//            return name;
//        }
//
//        public String getType() {
//            return type;
//        }
//
//        public void setType(String type) {
//            this.type = type;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//    }
}
