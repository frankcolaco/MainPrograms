package com.examples;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.tomcat.util.codec.binary.Base64;


public class AuthorizationMain {

    private static final String HMAC_SHA256_ALGORITHM = "HmacSHA256";
    private static final String SIGNATURE_FORMAT = "%s\n%s\n%s\n%s\n%s\n%s\n%s\n";
    private static final String AUTH_HEADER_FORMAT_BH = "MAC ID=\"%s\",ts=\"%s\",nonce=\"%s\",bodyhash=\"%s\",mac=\"%s\"";
    private static final String UTF8_ENCODING = "UTF-8";

    public static void main(String[] args) {

    }

    private String generateMacHeader(String client_id, String client_secret, String resourcePath,
                                     String host, int port, String httpMethod, String payload, String nonce ,String ts  ) throws Exception {

        String bodyHash ;
        String signature ;
        String mac_authorization_header;

        SecretKeySpec signingKey = new SecretKeySpec(client_secret.getBytes(UTF8_ENCODING),HMAC_SHA256_ALGORITHM);
        Mac mac = Mac.getInstance(HMAC_SHA256_ALGORITHM);
        mac.init(signingKey);

        System.out.println(ts + "   is the ts\n"+nonce + "   is the nonce\n"+httpMethod + "   is the httpMethod\n"+resourcePath + "   is the resourcePath\n"+
                host + "   is the host\n"+port + "   is the port");

        // create the bodyHash value by hashing the payload and encoding it
        byte[] rawBodyHash = mac.doFinal(payload.getBytes(UTF8_ENCODING));
        bodyHash = Base64.encodeBase64String(rawBodyHash);
        System.out.println( bodyHash + " bodyHash should not be null ");
        signature = String.format(SIGNATURE_FORMAT, ts, nonce, httpMethod, resourcePath, host, port, bodyHash);


        // Generate signature using client secret (crypto initialized above)
        byte[] signatureBytes = mac.doFinal(signature.getBytes(UTF8_ENCODING));
        // now encode the cypher for the web
        String signatureStr = Base64.encodeBase64String(signatureBytes);
        System.out.println( signatureStr + "   is the MAC");


        mac_authorization_header = String.format(AUTH_HEADER_FORMAT_BH, client_id, ts, nonce, bodyHash, signatureStr);

        System.out.println(" mac_authorization_header full string is ::::::: " + mac_authorization_header);

        return mac_authorization_header;
    }
}
