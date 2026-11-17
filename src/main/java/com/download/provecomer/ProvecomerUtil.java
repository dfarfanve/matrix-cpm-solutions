package com.download.provecomer;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import main.java.com.pabisapi.crypto.PabisCrypto;

public class ProvecomerUtil {

    

    public static JsonElement getGoodBodyPatch(String clientName, String chainName) {
        JsonParser parser = new JsonParser();
        String strJson = "{'name':'" + clientName + "','chainList':[{'name':'" + chainName + "','status': true,'code':'000'}]}";
        return parser.parse(strJson);
    }

    public static JsonElement getBadBodyPatch(String clientName, String chainName, String errorCode) {
        JsonParser parser = new JsonParser();
        String strJson = "{'name':'" + clientName + "','chainList':[{'name':'" + chainName + "','status': false,'code':'" + errorCode + "'}]}";
        return parser.parse(strJson);
    }
    /**
     * Desencripta las contraseñas que son recibidas a través de los servicios
     * @param pass Contraseña encriptada
     * @return Contraseña desencriptada
     */
    public static String decrypt(String pass) {
        try {
            return PabisCrypto.decrypt(pass, "private.der");
        } catch (IOException | InvalidKeySpecException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(ProvecomerUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    /**
     * Verifica en el HTML que devuelve el intento de inicio de sesión la cadena de Error en clave o contraseña
     * @param strResponse Html en formato de cadena
     * @return Verdadero o Falso Si el html contiene o no la cadena
     */
    public static boolean isValidLogin(String strResponse) {
        if (strResponse.contains(" Error en clave o contraseña !!!!!")) {
            return false;
        } else {
            return true;
        }
    }

}
