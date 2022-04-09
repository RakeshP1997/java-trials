
import java.util.Arrays;
import java.util.stream.Collectors;

public class abc {
    public static void main (String[] args) {
        final String regReservedChars = "\n\t\r?+*{}[]().|/";
        final String extraChars = "\"\\";
        final String elasticSearchReservedChars = "#@&<>~: ";
//        final String[] value = {"INTERNALERROR: Internal error from server: STATUS CODE 500: <html>\\n<head>\\n<meta http-equiv=\\\"Content-Type\\\" content=\\\"text/html; charset=ISO-8859-1\\\"/>\\n<title>Error 500 There was an error processing your request. It has been logged (ID 3328a5f58dd7de21).\\n</title>\\n</head>\\n<body><h2>HTTP ERROR 500</h2>\\n<p>Problem accessing /long-running-rest/v1/fetch/ed6da28e-4d85-4898-8032-e3c5cfa45d76. Reason:\\n<pre>    There was an error processing your request. It has been logged (ID 3328a5f58dd7de21).\\n</pre></p><br/>                                                \\n<br/>                                                \\n<br/>                                                \\n<br/>                                                \\n<br/>                                                \\n<br/>                                                \\n<br/>                                                \\n<br/>                                                \\n<br/>                                                \\n<br/>                                                \\n<br/>                                                \\n<br/>                                                \\n<br/>                                                \\n<br/>                                                \\n<br/>                                                \\n<br/>                                                \\n<br/>                                                \\n<br/>                                                \\n<br/>                                                \\n<br/>                                                \\n\\n</body>\\n</html>\\n"};
        final String[] value = {"INTERNALERROR: Internal error from server: STATUS CODE 500: <html>\\n<head>\\n<meta http-equiv=\\\"Content-Type\\\" content=\\\"text/html; charset=ISO-8859-1\\\"/>\\n<title>Error 500 There was an error processing your request. It has been logged (ID 3328a5f58dd7de21).\\n</title>\\n</head>\\n<body><h2>HTTP ERROR 500</h2>\\n<p>Problem accessing /long-running-rest/v1/fetch/ed6da28e-4d85-4898-8032-e3c5cfa45d76. Reason:\\n<pre>    There was an error processing your request. It has been logged (ID 3328a5f58dd7de21).\\n</pre></p><br/>                                                \\n<br/>                                                \\n<br/>                                                \\n<br/>                                                \\n<br/>                                                \\n<br/>                                                \\n<br/>                                                \\n<br/>                                                \\n<br/>                                                \\n<br/>                                                \\n<br/>                                                \\n"};
//        value[0] = value[0].replace('x', '\\');
        System.out.println("Initial length : " + value[0].length());
        value[0] = value[0].replaceAll("[\\\\]", "\\\\\\\\");
        final String[] finalValue = {value[0]};
//        value.replaceAll("[?]", "\\\\?");
//        System.out.println(elasticSearchReservedChars.substring(13));
        Arrays.stream(regReservedChars.split(""))
                .collect(Collectors.toList())
                .forEach(esChar -> {
//                    System.out.println(value[0]);
                    value[0] = value[0].replaceAll(String.format("[\\%s]",esChar), "\\\\" + esChar);
                });
//        Arrays.stream(extraChars.split(""))
//                .collect(Collectors.toList())
//                .forEach(esChar -> {
//                    System.out.println(value[0]);
//
//                });
//        System.out.println("HI        " + value[0]);

//        System.out.println(value[0]);
        value[0] = value[0].replaceAll("[\"]", "\\\\\"");
        Arrays.stream(elasticSearchReservedChars.split(""))
                .collect(Collectors.toList())
                .forEach(esChar1 -> {
//                    System.out.println(value[0]);
                    value[0] = value[0].replaceAll(String.format("[%s]",esChar1), "\\\\" + esChar1);
                });
        System.out.println(value[0]);
        System.out.println("String length: " + value[0].length());
    }
}