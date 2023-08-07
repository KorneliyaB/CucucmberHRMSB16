package Utils;

import org.json.JSONObject;

public class APIPayloadConstants {
    public static String createEmployeePayload(){
        String createEmployeePayload= "{\n" +
                "  \"emp_firstname\": \"Tom\",\n" +
                "  \"emp_lastname\": \"Mittil\",\n" +
                "  \"emp_middle_name\": \"Djhone\",\n" +
                "  \"emp_gender\": \"M\",\n" +
                "  \"emp_birthday\": \"2005-06-12\",\n" +
                "  \"emp_status\": \"veryHappy\",\n" +
                "  \"emp_job_title\": \"QA Tester\"\n" +
                "}";
        return createEmployeePayload;
    }
    public static String createEmployeeJsonPayload(){
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname","Tom");
        obj.put("emp_lastname","Mittil");
        obj.put("emp_middle_name","Djhone");
        obj.put("emp_gender","M");
        obj.put("emp_birthday","2005-06-12");
        obj.put("emp_status","veryHappy");
        obj.put("emp_job_title","QA Tester");
        return obj.toString();
}
    public static String createEmployeeJsonPayloadDynamic
            (String fn, String ln, String mn, String gender,
             String dob, String status, String jobTitle){
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", fn);
        obj.put("emp_lastname", ln);
        obj.put("emp_middle_name", mn);
        obj.put("emp_gender", gender);
        obj.put("emp_birthday", dob);
        obj.put("emp_status",status);
        obj.put("emp_job_title",jobTitle);
        return obj.toString();
    }


}
